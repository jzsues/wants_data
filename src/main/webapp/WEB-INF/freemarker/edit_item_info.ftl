<form id="item_info_form_${datas.asin}" class="form" action="">
	<legend>商品信息<img id="loading_img" style="display:none;" src="/item/resources/img/loading.gif"></legend>
	<input type="hidden" name="version" id="version" value="${datas.version?if_exists}"/>
	<div class="row">
		<div class="span6">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="asin"><b>ASIN</b></label>
					<div class="controls">
						<input type="text" class="input-small" id="asin" name="asin" placeholder="Asin" value="${datas.asin}" readonly="readonly">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="name"><b>名称</b></label>
					<div class="controls">
						<input type="text" class="input-xxlarge" id="name" name="name" placeholder="名称" value="${datas.name}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="price"><b>价格</b></label>
					<div class="controls">
						<input type="text" class="input-small" id="price" name="price" placeholder="价格" value="${datas.price}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="list_price"><b>市场价</b></label>
					<div class="controls">
						<input type="text" class="input-small" id="list_price" name="list_price" placeholder="市场价" value="${datas.list_price}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="you_save"><b>能省</b></label>
					<div class="controls">
						<input type="text" class="input-small" id="you_save" name="you_save" placeholder="能省" value="${datas.you_save}">
					</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="cover_img"><b>封面</b><button class="btn btn-success btn-mini">更新</button></label>
				<div class="controls">
					<input type="hidden"  name="cover_img" value="${datas.cover_img}">
					<img style="width:67px;height:67px;" src="${datas.cover_img}">
				</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="thumbs"><b>图片</label>
					<div class="controls">
						<#list datas.thumbs?if_exists as img>
						<input type="hidden"  name="_thumbs" value="${img}">
						<img src="${img}">
						</#list>
					</div>
				</div>
			</fieldset>
		</div>
		<div class="span4">
			<fieldset>

				<div class="control-group">
					<label class="control-label" for="prd_desc"><b>描述</b></label>
					<div class="controls">
						<textarea id="prd_desc" name="prd_desc" rows="5" class="span4">${datas.prd_desc?if_exists}</textarea>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="prd_details"><b>详细</b></label>
					<div class="controls">
						<textarea id="prd_details" name="prd_details" rows="5" class="span4">${datas.prd_details?if_exists}</textarea>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="prd_features"><b>特性</b></label>
					<div class="controls">
						<textarea id="prd_features" name="prd_features" rows="5" class="span4">${datas.prd_features?if_exists}</textarea>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="prd_spec"><b>规格</b></label>
					<div class="controls">
						<textarea id="prd_spec" name="prd_spec" rows="5" class="span4">${datas.prd_spec?if_exists}</textarea>
					</div>
				</div>
			</fieldset>
		</div>
	</div>
</form>