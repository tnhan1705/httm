<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="/user/home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Sản phẩm</li>
	</ul>

	<div>${ ResultAdvise }</div>
	<div id="myTab" class="pull-right">
		<a href="#listView" data-toggle="tab"><span class="btn btn-large"><i
				class="icon-list"></i></span></a> <a href="#blockView" data-toggle="tab"><span
			class="btn btn-large btn-primary"><i class="icon-th-large"></i></span></a>
	</div>
	<br class="clr" />
	<div class="tab-content">
		<div class="tab-pane" id="listView">
			<c:forEach var="productItem" items="${ product.content }">
				<div class="row">
					<div class="span2">
						<img width="100"
							src="/templates/User/bootstrap-shop/themes/images/Product/${ productItem.image }"
							alt="" />
					</div>
					<div class="span4">
						<h3>${ productItem.name }</h3>

						<!-- <h5>Product Name</h5> -->
						<a class="btn btn-small pull-right"
							href="<c:url value="/user/product-details/${ productItem.id }"/>">View
							Details</a> <br class="clr" />
					</div>
					<div class="span3 alignR">
						<form class="form-horizontal qtyFrm">
							<h3>
								<fmt:formatNumber value="${productItem.price}" type="currency"
									currencySymbol="" maxFractionDigits="0"></fmt:formatNumber>
								đ
							</h3>
							<!-- <label class="checkbox"> <input type="checkbox">
								Adds product to compair
							</label> -->
							<br /> <a
								href="<c:url value="/user/product-details/${ productItem.id }"/>"
								class="btn btn-large btn-primary"> Add to <i
								class=" icon-shopping-cart"></i></a> <a
								href="<c:url value="/user/product-details/${ productItem.id }"/>"
								class="btn btn-large"><i class="icon-zoom-in"></i></a>
						</form>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="tab-pane  active" id="blockView">
			<ul class="thumbnails">
				<c:forEach var="productItem" items="${ product.content }">
					<li class="span3">
						<div class="thumbnail">
							<a
								href="<c:url value="/user/product-details/${ productItem.id }"/>"><img
								width="100"
								src="/templates/User/bootstrap-shop/themes/images/Product/${ productItem.image }"
								alt="" /></a>
							<div class="caption">
								<h5>${ productItem.name }</h5>
								<h4 style="text-align: center">
									<a class="btn"
										href="<c:url value="/user/product-details/${ productItem.id }"/>">
										<i class="icon-zoom-in"></i>
									</a> <a class="btn"
										href="<c:url value="/user/product-details/${ productItem.id }"/>">Add
										to <i class="icon-shopping-cart"></i>
									</a> <a class="btn btn-primary"><fmt:formatNumber
											value="${productItem.price}" type="currency"
											currencySymbol="" maxFractionDigits="0"></fmt:formatNumber> đ</a>
								</h4>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
			<hr class="soft" />
		</div>
	</div>

	<!-- <a href="compair.html" class="btn btn-large pull-right">Compair
		Product</a> -->
	<!-- Phân trang -->
	<div class="pagination">
		<ul>
		<c:if test="${product.number > 0}">
            <li><a href="/user/products/${id}?p=0">First</a></li>
            <li><a href="/user/products/${id}?p=${product.number - 1}">Prev</a></li>
        </c:if>
        <c:if test="${product.number < product.totalPages - 1}">
            <li><a href="/user/products/${id}?p=${product.number + 1}">Next</a></li>
            <li><a href="/user/products/${id}?p=${product.totalPages - 1}">Last</a></li>
        </c:if>
		</ul>
	</div>
	<br class="clr" />
</div>