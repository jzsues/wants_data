package org.wants.data.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import org.wants.data.meta.ItemRankType;
import org.wants.data.service.RankService;

/**
 * @author jiangzm
 * 
 */
@Controller
public class RankController {
	@Autowired
	RankService rankService;

	@RequestMapping(value = "hot/{page}/{size}/{batch}/{type}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> hot_list(@PathVariable("page") final Integer page, @PathVariable("size") final Integer size,
			@PathVariable("batch") final String batch, @PathVariable("type") final String type,
			@RequestParam(required = false) final String callback, @RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(), AjaxResponseCode.SUCCESS.getCode());
				String hotCategory = "baby-products";
				PageRequest pageRequest = new PageRequest(page, size);
				Page<ItemInfo> pages = rankService.findItemByBatchAndCategoryAndType(batch, hotCategory, type, pageRequest);
				List<ItemInfo> list = pages.getContent();
				resp.setAddition(list);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

	@RequestMapping(value = "slider/{totalPage}/{size}/{batch}/{type}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> slider_list(@PathVariable("totalPage") final Integer totalPage, @PathVariable("size") final Integer size,
			@PathVariable("batch") final String batch, @PathVariable("type") final String type,
			@RequestParam(required = false) final String callback, @RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(), AjaxResponseCode.SUCCESS.getCode());
				String hotCategory = "baby-products";
				LinkedList<List<ItemInfo>> lists = new LinkedList<List<ItemInfo>>();
				for (int page = 0; page < totalPage; page++) {
					PageRequest pageRequest = new PageRequest(page, size);
					Page<ItemInfo> pages = rankService.findItemByBatchAndCategoryAndType(batch, hotCategory, type, pageRequest);
					List<ItemInfo> list = pages.getContent();
					lists.add(list);
				}
				resp.setAddition(lists);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

	@RequestMapping(value = "list/{page}/{size}/{batch}/{category}/{type}", method = RequestMethod.GET)
	public @ResponseBody
	Callable<AjaxResponse> prd_list(@PathVariable("page") final Integer page, @PathVariable("size") final Integer size,
			@PathVariable("batch") final String batch, @PathVariable("category") final String category,
			@PathVariable("type") final String type, @RequestParam(required = false) final String callback,
			@RequestParam(required = false) final String ftl) {
		return new Callable<AjaxResponse>() {
			@Override
			public AjaxResponse call() throws Exception {
				AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(), AjaxResponseCode.SUCCESS.getCode());
				Map<String, Object> cond = new HashMap<String, Object>();
				cond.put("batch", batch);
				cond.put("category", category);
				cond.put("type", type);
				PageRequest pageRequest = new PageRequest(page, size);
				Page<ItemInfo> pages = rankService.findItemByBatchAndCategoryAndType(batch, category, type, pageRequest);
				Iterable<ItemInfo> list = pages.getContent();
				resp.setAddition(list);
				resp.setCallback(callback);
				resp.setFtl(ftl);
				return resp;
			}
		};
	}

	@RequestMapping(value = "rank/types", method = RequestMethod.GET)
	public @ResponseBody
	AjaxResponse types(@RequestParam(required = false) final String callback) {
		AjaxResponse resp = new AjaxResponse(AjaxResponseStatus.OK.getCode(), AjaxResponseCode.SUCCESS.getCode());
		List<String> sTypes = ItemRankType.getTypes();
		resp.setAddition(sTypes);
		resp.setCallback(callback);
		return resp;
	}
}
