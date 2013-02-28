/**
 * 
 */
package org.wants.data.controller;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wants.data.entity.AjaxResponse;
import org.wants.data.entity.CategoryInfo;
import org.wants.data.meta.AjaxResponseCode;
import org.wants.data.meta.AjaxResponseStatus;
import org.wants.data.service.CategoryService;

/**
 * @author jiangzm
 * 
 */
@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "parent/{parent}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> parent(@PathVariable("parent") final String parent,
			@RequestParam(required = false) final String callback, @RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(),
						AjaxResponseCode.SUCCESS.getCode());
				List<CategoryInfo> list = categoryService.findByParent(parent);
				resp.setAddition(list);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

	@RequestMapping(value = "{category}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> category(@PathVariable("category") final String category,
			@RequestParam(required = false) final String callback, @RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(),
						AjaxResponseCode.SUCCESS.getCode());
				CategoryInfo res = categoryService.findByCategory(category);
				resp.setAddition(res);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

}
