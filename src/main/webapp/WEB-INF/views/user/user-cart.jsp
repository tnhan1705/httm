<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="/user/home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Giỏ hàng</li>
	</ul>
	<h3>GIỎ HÀNG</h3>
	<h3>
		<div class="well well-small">
			<a id="myCart" href="/user/historyCart"><img
				src="/templates/User/bootstrap-shop/themes/images/ico-cart.png"
				alt="cart">Lịch sử mua hàng </a>
		</div>
		<div class="cart-buttons">
			<form action="/user/orderDetermination" method="post">
				<input type="hidden" name="orderId" value="${ order.getId() }">
				<button type="submit" class="btn btn-large pull-right">
					Đặt hàng <i class="icon-arrow-right"></i>
				</button>
			</form>
			<a href="/user/home" class="btn btn-large pull-left"><i
				class="icon-arrow-left"></i>Tiếp tục mua hàng </a>
		</div>
	</h3>
	<br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Sản phẩm</th>
				<th>Mô tả</th>
				<th>Số lượng</th>
				<th>Giá</th>
				<th>Tổng</th>
				<th>Xoá</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="totalPrice" value="0" />
			<c:forEach var="lo" items="${ listOrder }">
				<tr>
					<td><img width="60"
						src="/templates/User/bootstrap-shop/themes/images/Product/${ lo.getProduct().getImage() }"
						alt="" /></td>
					<td>${ lo.getProduct().getName() }<br />Màu : ${ lo.getColor() }
					</td>
					<td>
						<div class="input-append">
							<input class="span1" style="max-width: 34px" size="16"
								type="text" value="${ lo.getQuantity() }" disabled="disabled">
						</div>
					</td>
					<td><fmt:formatNumber value="${ lo.getProduct().getPrice() }"
							type="currency" currencySymbol="" maxFractionDigits="0"></fmt:formatNumber>
						đ</td>
					<td><fmt:formatNumber
							value="${lo.getProduct().getPrice() * lo.getQuantity()}"
							type="currency" currencySymbol="" maxFractionDigits="0"></fmt:formatNumber>
						đ</td>
					<c:set var="totalPrice"
						value="${totalPrice + (lo.getProduct().getPrice() * lo.getQuantity())}" />
					<td><form action="/user/removeProduct" method="post">
							<button class="btn btn-danger" type="submit">
								<i class="icon-remove icon-white"></i>
							</button>
							<input type="hidden" name="orderDetailId"
								value="${lo.getOrder().getId()}"> <input type="hidden"
								id="input-value" name="productId"
								value="${lo.getProduct().getId()}">
						</form></td>
				</tr>
			</c:forEach>

			<tr>
				<!-- <td colspan="6" style="text-align: right"><strong>Tổng tiền </strong></td> -->
				<td colspan="6" style="text-align: right"><strong>Tổng
						tiền: <fmt:formatNumber value="${totalPrice}" type="currency"
							currencySymbol="" maxFractionDigits="0"></fmt:formatNumber> đ
				</strong></td>
			</tr>
		</tbody>
	</table>

	<h3>${ message }</h3>


	<!-- <table class="table table-bordered">
		<tbody>
			<tr>
				<td>
					<form class="form-horizontal">
						<div class="control-group">
							<label class="control-label"><strong> VOUCHERS
									CODE: </strong> </label>
							<div class="controls">
								<input type="text" class="input-medium" placeholder="CODE">
								<button type="submit" class="btn">ADD</button>
							</div>
						</div>
					</form>
				</td>
			</tr>

		</tbody>
	</table> -->

	<!-- <table class="table table-bordered">
		<tr>
			<th>ESTIMATE YOUR SHIPPING</th>
		</tr>
		<tr>
			<td>
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="inputCountry">Country </label>
						<div class="controls">
							<input type="text" id="inputCountry" placeholder="Country">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPost">Post Code/
							Zipcode </label>
						<div class="controls">
							<input type="text" id="inputPost" placeholder="Postcode">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">ESTIMATE</button>
						</div>
					</div>
				</form>
			</td>
		</tr>
	</table> -->
	<!-- <a href="products.html" class="btn btn-large"><i
		class="icon-arrow-left"></i> Continue Shopping </a> <a href="login.html"
		class="btn btn-large pull-right">Next <i class="icon-arrow-right"></i></a> -->

</div>