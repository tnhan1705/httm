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
				<th>Mã đơn</th>
				<th>Ngày đặt</th>
				<th>Trạng thái</th>
				<th>Chi tiết</th>
				<th>Huỷ đơn hàng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ol" items="${ orderList }">
				<tr>
					<td>${ ol.getId() }</td>
					<td>${ ol.getDate() }</td>
					<td>${ ol.getStatus() }</td>
					<td><form action="/user/historyCartDetail" method="post">
							<button type="submit">
								Xem chi tiết
							</button>
							<input type="hidden" name="orderId"
								value="${ol.getId()}">
						</form></td>
					<td><c:if test="${ ol.getStatus() eq 'chờ duyệt' }">
							<form action="/user/cancelOrder" method="post">
							<button type="submit">
								Huỷ đơn hàng
							</button>
							<input type="hidden" name="orderId"
								value="${ol.getId()}">
						</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>