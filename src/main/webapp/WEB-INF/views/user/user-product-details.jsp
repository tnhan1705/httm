<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>



<div class="span9">
	<ul class="breadcrumb">
		<li><a href="/user/home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Sản phẩm<span class="divider">/</span></li>
		<li class="active">Chi tiết sản phẩm</li>
	</ul>
	<div class="row">
		<!-- Product Image -->
		<div id="gallery" class="span3">
			<img
				src="/templates/image/${ productDetails.image }"
				style="width: 100%" alt="Fujifilm FinePix S2950 Digital Camera" />
			<div id="differentview" class="moreOptopm carousel slide">
				<div class="carousel-inner">
					<div class="item active"></div>
					<div class="item"></div>
				</div>
			</div>
		</div>
		<h3>${ message }</h3>
		<div class="span6">
			<h3>${ productDetails.name }</h3>
			<hr class="soft" />
			<form class="form-horizontal qtyFrm" action="/user/addProduct"
				method="post">
				<div class="control-group">
					<label class="control-label"><span><fmt:formatNumber
								value="${productDetails.price}" type="currency"
								currencySymbol="" maxFractionDigits="0"></fmt:formatNumber> đ</span></label>
					<div class="controls">
						<input type="number" min="${productDetails.number > 0 ? 1 : 0}" name="number"
							max="${ productDetails.number }" class="span1" value="${productDetails.number > 0 ? 1 : 0}" /> <input
							type="hidden" name="productId" value="${productDetails.id}" />
						<button type="submit" class="btn btn-large btn-primary pull-right" ${productDetails.number == 0 ? 'disabled' : ''}>
							Thêm vào giỏ hàng <i class="icon-shopping-cart"></i>
						</button>
					</div>
				</div>

				<hr class="soft" />
				<h4 id="quantity">Còn <span id="quantityDisplay">${initialQuantity}</span> sản phẩm trong kho</h4>
				<div class="form-horizontal qtyFrm pull-right">
					<div class="control-group">
						<h5>
							<label class="control-label"><span>Màu</span></label>
						</h5>
						<div class="controls">
							<select class="span2" name="selectedColor" id="selectedColor">
								<c:forEach var="Color" items="${ numberAndQuantity }">
									<option value="${ Color.key }">${ Color.key } (${ Color.value})</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
			</form>
			<hr class="soft clr" />
			<p>${productDetails.description}</p>
			<hr class="soft" />
		</div>
	</div>
</div>
