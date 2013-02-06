<#list datas as category>
<#if category.parent =="root">
<div class="left_menu_list_item" data-extend="false" data-parent="${category.parent}" id="${category.category}">
	<div class="left_menu_list_item_inner">
		<a id="a_${category.category}" class="category_tree">${category.name}</a>
	</div>
</div>
<div id="c_${category.category}" class="left_menu_list_item_collections"></div>
<#else>
<div class="left_menu_list_item" data-extend="false" data-parent="${category.parent}" id="${category.category}">
	<div class="left_menu_list_item_inner">
		<div class="left_menu_list_item_collections_sub_item_inner">
			<a id="${category.category}" class="category_tree">${category.name}</a>
		</div>
	</div>
</div>
</#if>
</#list>