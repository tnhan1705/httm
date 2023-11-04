
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách serri sản phẩm</h1>
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
						<th>Số seri</th>
						<th>phiếu nhập</th>
						<th>Màu</th>
						<th>Trạng thái</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="seri" items="${listseri}">
						<tr>


							<td>${seri.id}</td>
							<td>${seri.receipt.id}</td>
							<td>${seri.color}</td>
							<c:choose>
								<c:when test="${seri.status}">
									<td>còn hàng</td>
								</c:when>
								<c:otherwise>
									<td>đã bán</td>
								</c:otherwise>
							</c:choose>




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