package org.wants.data.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.wants.data.entity.AjaxResponse;
import org.wants.data.meta.AjaxResponseCode;
import org.wants.data.meta.AjaxResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler implements MessageSourceAware {
	MessageSource messageSource;
	@Autowired
	LocaleResolver localeResolver;

	@ExceptionHandler
	public @ResponseBody
	AjaxResponse handleBusinessException(Exception ex, HttpServletRequest request) {
		Locale locale = getLocale(request);
		String msg = messageSource.getMessage("test", null, locale);
		AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.INTERNAL_SERVER_ERROR.getCode(),
				AjaxResponseCode.ERROR.getCode());
		resp.setMsg(msg);
		resp.setDevMsg(ex.getMessage());
		return resp;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	private Locale getLocale(HttpServletRequest request) {
		return localeResolver.resolveLocale(request);
	}

}
