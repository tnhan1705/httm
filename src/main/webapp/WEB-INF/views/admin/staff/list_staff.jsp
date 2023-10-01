
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<%@ page import="paintstore.Utils.SecurityUtils"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách nhân viên</h1>
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
						<th>Mã nhân viên</th>
						<th>Họ Tên </th>
						<th>Địa chỉ</th>
						<th>Ngày sinh</th>
						<th>Sđt</th>
						<th>Tên tài khoản</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="staff" items="${listStaff}">
						<tr>
							<td>${staff.id}</td>
							<td>${staff.surname} ${staff.name}</td>
							<td>${staff.address}</td>
							<td>${staff.dateOfBirth}</td>
							<td>${staff.sdt}</td>
							<td>${staff.account.userName}</td>
							<td id="edit-cell">
								<a style="background-color: red;" href="delete?usernameac=${staff.account.userName}" class="edit-button" >Xóa</a>
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
	<script>
    function edit() {
        window.location.href = "/admin/category/edit?idc=${category.id}"; // Thay đổi link cần chuyển hướng tới
    }
    function delete1() {
        window.location.href = "http://example.com/delete"; // Thay đổi link cần chuyển hướng tới
    }
</script>
</main>