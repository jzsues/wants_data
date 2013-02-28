<#assign first = datas?first>
<ol name="item_grid_middle" class="gallery  group">
<li id="screenshot-119090" class="group">
	<div class="gallery">
		<div class="gallery-shot">
			<div class="gallery-img">
				<a href="/shots/119090-Ice-ice-baby-icon-illustration" class="gallery-link"> <img
					alt="Ice ice baby - icon/illustration"
					src="${first.cover_img}">
				</a> <a href="/shots/119090-Ice-ice-baby-icon-illustration" class="gallery-over" style="opacity: 0;"> <strong>${first.name}</strong> <em>February 23, 2011</em>
				</a>
			</div>

			<ul class="tools group">
				<li class="fav"><a href="/shots/119090-Ice-ice-baby-icon-illustration/fans"
					title="See fans of this screenshot">733</a></li>
				<li class="cmnt"><a href="/shots/119090-Ice-ice-baby-icon-illustration#comments"
					title="View comments on this screenshot">45</a></li>
				<li class="views">8,574</li>
			</ul>

		</div>
		<div class="extras">
			<a href="/shots/119090-Ice-ice-baby-icon-illustration/rebounds"> <span rel="tipsy"
				class="rebound-mark has-rebounds" original-title="${first.name}.">2</span>
			</a>
		</div>
	</div>

	<h2>
		<a href="/cuberto" class="url" rel="contact" title="Cuberto"><img alt="Cuberto" class="photo"
			src="http://dribbble.s3.amazonaws.com/users/4859/avatars/original/dribbble.png?1317224423"> ${first.asin}</a> <a
			href="/account/pro" class="badge-link"> <span class="badge badge-pro">Pro</span>
		</a>
	</h2>
</li>
</ol>
<ol name="item_grid_mini" class="multi-grid">
<#list datas as item>
	<#if item.asin!=first.asin>
	<li class="multi-thumb">
		<div class="board">
		<a href="/shots/852280-Map-Wires" class="zoom" original-title=""> <strong
				style="opacity: 0;"><span>380</span></strong> <img alt="Map Wires"
				src="${item.cover_img}">
		</a>
		</div>
		<div class="tipsy-player">
			<span class="tipsy-player-link">
				<b>${item.name}</b>
				${item.prd_desc}
			</span>
		</div>
	</li>
	</#if>
</#list>
</ol>