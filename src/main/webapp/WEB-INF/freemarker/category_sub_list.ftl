<div class="left_menu_list_item_collections_sub">
	<div class="left_menu_list_item">
		<#list datas as category>
		<div class="left_menu_list_item_inner">
			<div class="left_menu_list_item_collections_sub_item_inner">
				<a id="${category.category}" class="category_tree">${category.name}</a>
			</div>
		</div>
		</#list>
	</div>
</div>