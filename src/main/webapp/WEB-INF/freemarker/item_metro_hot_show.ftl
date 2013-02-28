<ul class="thumbnails">
	<#list datas as item>
	<li class="span3" style="height: 220px; margin-bottom: 0;" rel="tooltip" data-placement="bottom" data-original-title="${item.price}"><a
				href="item?id=${item.asin}" target="_blank" alt="${item.r_name!}">
					<div class="thumbnail">
						<img alt="${item.name}" style="width: 180px; height: 180px;" src="http://img.ubabytime.com${item.cover_img}!x180">
						<div style="font-size:12px;margin-top: 3px; text-align: center; line-height: 18px;height:36px">
							<b>${item.r_name!}</b>
						</div>
						<div class="price_value">
					      <div class="price_tag">
					        <h6>$26</h6>
					      </div>
					    </div>
					</div>
			</a></li>
	</#list>
</ul>
