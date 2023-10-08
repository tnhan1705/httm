<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div id="sidebar" class="span3">
	<div class="well well-small">
		<a id="myCart" href="/user/cart"><img
			src="/templates/User/bootstrap-shop/themes/images/ico-cart.png"
			alt="cart">Giỏ hàng </a>
	</div>
	<!-- <div class="well well-small">
		<a id="myCart" href="/user/historyCart"><img
			src="/templates/User/bootstrap-shop/themes/images/ico-cart.png"
			alt="cart">Lịch sử mua hàng </a>
	</div> -->
	
	<ul id="sideManu" class="nav nav-tabs nav-stacked">
		<li ><a>Hỗ trợ đề xuất sản phẩm</a>
			<ul>
				<li>
					<textarea name="description" rows="4" cols="50"></textarea>
					<button>Bắt đầu</button>
				</li>
			</ul>
		</li>
		<br/>
		<li><a>Danh mục</a>
			<ul>
				<c:forEach var="cateItem" items="${ category }">
					<li><a href='<c:url value="/user/products/${ cateItem.id }"/>'>
							<i class="icon-chevron-right"></i>${ cateItem.name }</a></li>
				</c:forEach>
			</ul>
		</li>
		<br/><!-- class="subMenu open" -->
		<li><a>Sắp xếp</a>
			<ul>
				<li><a href='<c:url value="/user/products/sort?sortType=name-asc"/>'> <i
						class="icon-chevron-right"></i>Theo tên A-Z
				</a></li>
				<li><a href='<c:url value="/user/products/sort?sortType=name-desc"/>'> <i
						class="icon-chevron-right"></i>Theo tên Z-A
				</a></li>
				<li><a href='<c:url value="/user/products/sort?sortType=price-asc"/>'> <i
						class="icon-chevron-right"></i>Theo giá tiền tăng dần
				</a></li>
				<li><a href='<c:url value="/user/products/sort?sortType=price-desc"/>'> <i
						class="icon-chevron-right"></i>Theo giá tiền giảm dần
				</a></li>
			</ul>
		</li>
	</ul>
</div>