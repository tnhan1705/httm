<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Danh sách danh mục</h1>
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

			<form:form modelAttribute="product" method="POST"
				action="/admin/receipt-detail/addSeri?idp=${idp}&idr=${idr} ">
				<form:errors path="*" cssClass="error" />

				<table class="category-table">
					<thead>
						<tr>
							<th>Mã seri</th>
							<th>Màu</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="seri" items="${listSeri}" varStatus="loop">
							<tr></tr>

							<td><div class="form-group">${seri.id}</div></td>
							<td><form:input path="listSeri[${loop.index}].color"
									type="text" /></td>

						</c:forEach>
						<tr></tr>

					</tbody>
				</table>
				<c:forEach var="seri" items="${listSeri}">
					<input type="hidden" name="seriIds" value="${seri.id}" />
				</c:forEach>
				<br>

				<button type="submit">Lưu</button>
			</form:form>


		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
</main>