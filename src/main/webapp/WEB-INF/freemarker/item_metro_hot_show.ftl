<#list datas as items>
	<#if items_index==0>
	<div class="item active" style="background-color: white;">
	<#else>
	<div class="item" style="background-color: white;">
	</#if>
	<ul class="thumbnails">
		<#list items as item>
			<li class="span3" style="height: 220px; margin-bottom: 0;" rel="tooltip" data-placement="bottom" data-original-title="${item.price}"><a
				href="http://wants.ubabytime.com/item?id=${item.asin}" target="_blank" alt="${item.name}">
					<div class="thumbnail">
						<img alt="${item.name}" style="width: 180px; height: 180px;" src="http://img.ubabytime.com${item.cover_img}">
						<div style="font-size:12px;margin-top: 3px; text-align: center; line-height: 18px;">
							<b>${item.name}</b>
						</div>
					</div>
			</a></li>
		</#list>
	</ul>
	</div>
</#list>