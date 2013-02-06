/**
 * 
 */
package org.wants.data.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wants.data.entity.AccessInfo;
import org.wants.data.service.AccessService;
import org.wants.data.util.AddressUtil;

/**
 * @author jiangzm
 * 
 */
public class AccessHandlerInterceptorAdapter implements AsyncHandlerInterceptor {
	final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	AccessService accessService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String ip = StringUtils.trimToEmpty(AddressUtil.getIpAddress(request));
		String user_agent = StringUtils.trimToEmpty(request.getHeader("user-agent"));
		String cookie = StringUtils.trimToEmpty(request.getHeader("cookie"));
		String referer = StringUtils.trimToEmpty(request.getHeader("referer"));
		String language = StringUtils.trimToEmpty(request.getHeader("accept-language"));
		String requestURL = StringUtils.trimToEmpty(request.getRequestURL().toString());
		String queryString = StringUtils.trimToEmpty(request.getQueryString());
		Date time = new Date();
		long timestamp = time.getTime();
		AccessInfo access = new AccessInfo(user_agent, cookie, ip, referer, timestamp, language, requestURL, queryString);
		try {
			accessService.save(access);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	}

}
