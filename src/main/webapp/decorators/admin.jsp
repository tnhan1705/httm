<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard - NiceAdmin Bootstrap Template</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/templates/admin/assets/img/favicon.png" rel="icon">
<link href="/templates/admin/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="/templates/admin/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="/templates/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="/templates/admin/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="/templates/admin/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link href="/templates/admin/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link href="/templates/admin/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link href="/templates/admin/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/templates/admin/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Mar 09 2023 with Bootstrap v5.2.3
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
	<!-- ======= Header ======= -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- End Header -->

	<!-- ======= Sidebar ======= -->
	<%@ include file="/common/admin/sidebar.jsp"%>
	<!-- End Sidebar-->

	<dec:body></dec:body>

	<!-- ======= Footer ======= -->
	<%@ include file="/common/admin/footer.jsp"%>
	<!-- End Footer -->
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script
		src="/templates/admin/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="/templates/admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/templates/admin/assets/vendor/chart.js/chart.umd.js"></script>
	<script src="/templates/admin/assets/vendor/echarts/echarts.min.js"></script>
	<script src="/templates/admin/assets/vendor/quill/quill.min.js"></script>
	<script
		src="/templates/admin/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="/templates/admin/assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="/templates/admin/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="/templates/admin/assets/js/main.js"></script>

</body>
</html>