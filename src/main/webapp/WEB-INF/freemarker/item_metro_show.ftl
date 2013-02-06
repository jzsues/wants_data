<#list datas as item>
<li class="span3" style="height: 220px; margin-bottom: 0;" rel="tooltip" data-placement="bottom" data-original-title="${item.price}"><a
	href="/movie/ted/" target="_blank" alt="${item.name}">
		<div class="thumbnail">
			<img alt="${item.name}" style="width: 180px; height: 180px;" src="${item.cover_img}">
			<div style="margin-top: 3px; text-align: center; line-height: 18px;">
				<b>${item.name}</b>
			</div>
		</div>
</a></li>
</#list>