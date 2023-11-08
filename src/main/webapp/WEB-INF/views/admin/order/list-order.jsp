
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách phiếu đặt</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Home</a></li>
				<li class="breadcrumb-item active">Dashboard</li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<section class="section dashboard">


		<!-- Left side columns -->

		<div class="row">

			<table class="category-table">
				<thead>
					<tr>
						<th>Mã phiếu đặt</th>
						<th>Ngày đặt</th>
						<th>Tên tài khoản</th>
						<th>Nhân viên xác nhận</th>
						<th>Hình thức thanh toán</th>
						<th>Trạng thái</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${listOrder}">
						<tr>
							<td>${order.id}</td>
							<td><fmt:formatDate value="${order.date}"
									pattern="dd/MM/yyyy" /></td>
							<td>${order.user.name}</td>
							<td>${order.staff.name}</td>
						    <td>${order.pay}</td> -
					        <td>${order.status}</td>
	         				<td>
                                  <div class="button-container" style="display: inline-block;">
                                     <a href="/admin/order/detail?idc=${order.id}" class="edit-button">Chi tiết</a>
                                     <c:if test="${order.status == 'Đã Xác Nhận'}">
                                     <a href="/admin/order/ship?ido=${order.id}" class="edit-button">Giao hàng</a>
                                     </c:if>
                                     <c:if test="${order.status == 'chờ duyệt'}">
                                     <a href="confirm?ido=${order.id}" class="edit-button">Xác nhận</a>
                                     </c:if>
                                     <c:if test="${order.status == 'chờ duyệt'}">
                                     <a href="delete?ido=${order.id}" class="edit-button" style="background-color: red"
                                     onclick="return confirm('Bạn có chắc chắn muốn xóa đơn đặt hàng này?');">Hủy</a>
                                     </c:if>
                                  </div>
                            </td>

						</tr>
					</c:forEach>
					<!-- các hàng khác ở đây -->
				</tbody>
			</table>
		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>

</main>

<style>
  .button-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .button-container a {
    margin-bottom: 10px;
    flex-basis: 48%; /* Điều chỉnh kích thước của thẻ "a" */
  }
</style>

