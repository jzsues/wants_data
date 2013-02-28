/**
 * 
 */
package org.wants.data.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wants.data.entity.AjaxResponse;
import org.wants.data.entity.ItemInfo;
import org.wants.data.meta.AjaxResponseCode;
import org.wants.data.meta.AjaxResponseStatus;
import org.wants.data.service.ItemService;

/**
 * @author jiangzm
 * 
 */
@Controller
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "info/{asin}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> info(@PathVariable("asin") final String asin, @RequestParam(required = false) final String callback,
			@RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(), AjaxResponseCode.SUCCESS.getCode());
				ItemInfo item = itemService.findByAsin(asin);
				resp.setAddition(item);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

}
