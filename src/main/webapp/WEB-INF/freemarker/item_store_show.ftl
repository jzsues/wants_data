<#assign first = datas?first>
<div class="right_container_main_items_div hoverable">
	<div class="right_container_main_items_div_bl" data-type="BL">
			<a class="_link" href="item?id=${first.asin}" index="0" title="">
				<div class="right_container_main_items_div_bl_inner">
					<div class="right_container_main_items_div_bl_img_group" style="opacity: 1;">
						<div class="right_container_main_items_div_bl_img_group_left hovered" style="left: 0px; top: 121px;">
							<div class="right_container_main_items_div_bl_img_group_left_img"></div>
						</div>
						<div class="right_container_main_items_div_bl_imgs">
							<div class="right_container_main_items_div_bl_imgs_inner">
								<div class="right_container_main_items_div_bl_imgs_inner_container" style="left: 0px; width: 3220px; top: 0px;">
									<div class="right_container_main_items_div_bl_imgs_item_inner" value="6" slideindex="0">
										<img class="_img" src="http://img.ubabytime.com/${first.cover_img}" style="width: 460px; height: 340px;">
									</div>
								</div>
							</div>
						</div>
						<div class="right_container_main_items_div_bl_img_group_right hovered" style="left: 437px; top: 121px;">
							<div class="right_container_main_items_div_bl_img_group_right_img"></div>
						</div>
					</div>
					<div class="right_container_main_items_div_bl_info" style="left: 0px; top: 350px; height: 49px;">
						<div class="right_container_main_items_div_bl_name">${first.name}</div>
						<div class="right_container_main_items_div_bl_rate">价格: ${first.price}</div>
					</div>
					<div class="right_container_main_items_div_bl_info hovered" style="left: 0px; top: 247px; height: 103px;">
						<div class="right_container_main_items_div_bl_name">${first.name}</div>
						<div class="right_container_main_items_div_bl_rate">价格: ${first.price}</div>
						<div class="right_container_main_items_div_bl_content" style="opacity: 1;">
							<div class="right_container_main_items_div_bl_desc">
							${first.name}
							</div>
							<div class="hover_div_act" style="top: 12px;">
								<div role="button" class="hover_div_act_button hover_div_act_button_bl" style="-webkit-user-select: none;" tabindex="0">
									<div class="hover_div_act_button_icon_1"></div>
									<div class="hover_div_act_button_text">我想要</div>
								</div>
								<div role="button" class="hover_div_act_button hover_div_act_button_sl" aria-expanded="false"
									style="-webkit-user-select: none;" tabindex="0">
									<div class="hover_div_act_button_icon_2"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</a>
	</div>
</div>
<#list datas as item>
	<#if item.asin!=first.asin>
	<div class="right_container_main_items_div hoverable" style="float: left;">
		<div class="right_container_main_items_div_sl" index="3" type="M">
			<a class="_link" href="item?id=${item.asin}" tabindex="0"><div class="_div ">
					<div class="right_container_main_items_div_sl_bg"></div>
					<div class="right_container_main_items_div_sl_content">
						<img class="" src="http://img.ubabytime.com/${item.cover_img}" style="width: 220px; height: 140px;">
						<div class="right_container_main_items_div_sl_icon_div">
							<div class="right_container_main_items_div_sl_icon_div_inner">
								<div class="right_container_main_items_div_sl_icon_div_img">${item.price}</div>
							</div>
						</div>
						<div class="right_container_main_items_div_sl_content_desc">
							<div class="right_container_main_items_div_sl_content_desc_title">${item.name}</div>
							<div class="right_container_main_items_div_sl_content_desc_star">
								<div class="star_inner" g:type="AverageStarRating"
									g:url="http://chrome.google.com/webstore/permalink?id=lcgmndephhjcabhhjfcmncnhbmgbkpij" g:groups="chrome_webstore"
									g:rating_override="4.706638115631692" title="平均评分：4.71 颗星（超赞）">
									<div class="star_inner_item"></div>
									<div class="star_inner_item"></div>
									<div class="star_inner_item"></div>
									<div class="star_inner_item"></div>
									<div class="star_inner_item"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="mini_hover hovered">
						<div class="mini_hover_inner" style="left: 0px;">
							<div class="mini_hover_content">
								<div class="">
									<div class="logo">
										<div class="inner">
											<img class="" alt="来自亚马逊" src="http://img.ubabytime.com/${item.cover_img}" style="width: 50px; height: 50px;">
										</div>
									</div>
									<div class="name">
										<div class="inner">${item.name}</div>
										<div>
											<div class="star_inner" g:type="AverageStarRating"
												g:url="http://chrome.google.com/webstore/permalink?id=lcgmndephhjcabhhjfcmncnhbmgbkpij" g:groups="chrome_webstore"
												g:rating_override="4.706638115631692" title="平均评分：4.71 颗星（超赞）">
												<div class="star_inner_item"></div>
												<div class="star_inner_item"></div>
												<div class="star_inner_item"></div>
												<div class="star_inner_item"></div>
												<div class="star_inner_item"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="mini_hover_info">
								<div class="desc">${item.name}</div>
							</div>
						</div>
					</div>
				</div>
			</a>
		</div>
	</div>
	</#if>
</#list>