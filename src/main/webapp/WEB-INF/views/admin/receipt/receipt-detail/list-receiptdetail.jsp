
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<main id="main" class="main">

	<div class="pagetitle">
		<h1>Chi tiết phiếu nhập</h1>
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

			<div class="user-info">
				<h3>Phiếu nhập</h3>
			</div>

			<table class="category-table">
				<thead>
					<tr>
						<th>Sản phẩm</th>
						<th>Số lượng</th>
						<th>Giá nhập</th>
						<th>Tổng giá</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="receiptDetail" items="${listReceiptDetail}"
						varStatus="loopStatus">
						<c:set var="number" value="${loopStatus.index}" />
						<tr>
							<td>${receiptDetail.product.name}</td>
							<td>${receiptDetail.product.name}</td>
        					<td>${receiptDetail.quantity} 
        						
          						  <c:forEach var="seri" items="${ColorAndQuantitysp1}">
              					  (${seri.key} : ${seri.value})
           							 </c:forEach>
      							  </td>

							<td>${receiptDetail.price}</td>
							<td>${receiptDetail.price*receiptDetail.quantity}</td>
							<c:if
								test="${(empty receiptDetail.product.listSeri) or (empty receipt.listSeri)}">
								<td><a
									href="/admin/receipt-detail/addSeri?idp=${receiptDetail.product.id}&idr=${receiptDetail.receipt.id}"
									type="button" class="btn btn-primary"
									style="background-color: #4caf50; color: white; width: 100px; border: none; margin-top: 10px; margin-left: 10px">Thêm
										seri</a></td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td>Tổng phiếu nhập</td>
						<td>${sum}</td>
					</tr>
					<!-- các hàng khác ở đây -->
				</tbody>
			</table>

			<div style="text-align: right;">
				<a href="/admin/order/list" type="button" class="btn btn-primary"
					style="background-color: #4caf50; color: white; width: 100px; border: none; margin-top: 10px;">Quay
					lại</a>
				<c:if test="${receipt.status == 0}">
					<a href="/admin/receipt-detail/confirmz?idr=${receipt.id}"
						type="button" class="btn btn-primary"
						style="background-color: #4caf50; color: white; width: 100px; border: none; margin-top: 10px; margin-left: 10px">Xác
						nhận</a>
					<a
						href="/admin/receipt-detail/confirmz?idr=${receipt.id}&status=huy"
						type="button" class="btn btn-primary"
						style="background-color: red; color: white; width: 100px; border: none; margin-top: 10px; margin-left: 10px;">Hủy</a>
				</c:if>
			</div>
		</div>

		<!-- End Left side columns -->

		<!-- Right side columns -->

		<!-- End Right side columns -->


	</section>

</main>

<style>
.user-info {
	border: 1px solid #ddd;
	padding: 20px;
	margin-bottom: 20px;
}

.user-field {
	margin-bottom: 10px;
}

.user-field label {
	font-weight: bold;
}

.user-field span {
	margin-left: 10px;
}

.color-rectangle {
	width: 50px; /* Độ rộng của hình chữ nhật */
	height: 30px; /* Chiều cao của hình chữ nhật */
	display: none; /* Ban đầu ẩn hình chữ nhật */
}
</style>
<!-- Một số phần HTML khác -->

<script th:inline="javascript">
    function showColorAndQuantity {
        event.preventDefault();

        const table = document.getElementById('colorQuantityTable');
        const tbody = document.getElementById('colorQuantityBody');

        tbody.innerHTML = '';

        /* Lấy dữ liệu từ controller thông qua Thymeleaf */
        const seris = [[${serilist}]]; // Thay null bằng tên biến dữ liệu bạn đã truyền từ controller

        seris.forEach(item => {
            const row = tbody.insertRow();
            const cellColor = row.insertCell(0);
            const cellQuantity = row.insertCell(1);

            cellColor.innerHTML = item.color;
            cellQuantity.innerHTML = item.quantity;
        });

        table.style.display = 'block';
    }
</script>
