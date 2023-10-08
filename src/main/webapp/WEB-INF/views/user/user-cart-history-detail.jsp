<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="/user/home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Lịch sử mua hàng</li>
	</ul>
	<h3>Lịch sử mua hàng</h3>
	<br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Sản phẩm</th>
				<th>Mô tả</th>
				<th>Số lượng</th>
				<th>Giá</th>
				<th>Tổng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="lo" items="${ listOrder }">
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
					
				<!-- </tr> -->
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
</div>