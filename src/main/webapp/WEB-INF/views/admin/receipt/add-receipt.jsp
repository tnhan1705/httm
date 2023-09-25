
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Thêm Phiếu Nhập</h1>
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

			<h2 class="section-title">Thêm phiếu nhập sản phẩm mới</h2>
			<form:form class="form" action="add" method="post" modelAttribute="addreceipt">

				<div class="form-group">
					<label class="form-label" >Mã phiếu nhập:</label>

					<form:input path="id" class="form-input" type="text"
						/>

				</div>
				<div class="form-group">
					<label class="form-label" for="categoryName">Ngày lập</label>
					 <form:input path="date" class="form-input" type="date" />
				</div>
				
				<div class="form-group">
					<label class="form-label" for="categoryName">Nhà cung cấp</label>
					<form:select path="supplier.id" class="form-input" items="${suppliers}"  itemLabel="name" itemValue="id" 
						  />
				</div>
				<c:if test="${message != null}">
				<div class="alert alert-success">
								${message}
							</div>
							</c:if>
				
				<div class="form-group">
					<button class="btn btn-primary" type="submit">Thêm mới</button>
				</div>

			</form:form>
		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>
	<!-- CSS -->
	<style>
.form {
	max-width: 600px;
	margin: auto;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 20px;
}

.form-label {
	display: block;
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-input {
	display: block;
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

.btn {
	display: inline-block;
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border-radius: 5px;
	border: none;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.2s ease-in-out;
}

.btn:hover {
	background-color: #0069d9;
}

.section-title {
	margin-bottom: 30px;
	text-align: center;
}
</style>

</main>