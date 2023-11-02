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
				<form style="margin-top: 20px" method="get" action="/user/advise" accept-charset="UTF-8">
					<input style ="height: 120px; width:90%" id="adviseInput" type="text" placeholder="Tư vấn"/>
					<button type="button" onclick="advise()" id="submitButton" class="btn btn-primary">Bắt đầu</button>
				</form>
				<script type="text/javascript">
					function advise() {
						var keyword = document.getElementById("adviseInput").value;
						var encodedText = encodeURIComponent(keyword);
						window.location.href = "/user/advise?keyword=" + encodedText;
					}
				</script>
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
				<li><a href='<c:url value="/user/products/?sortType=name-asc"/>'> <i
						class="icon-chevron-right"></i>Theo tên A-Z
				</a></li>
				<li><a href='<c:url value="/user/products/?sortType=name-desc"/>'> <i
						class="icon-chevron-right"></i>Theo tên Z-A
				</a></li>
				<li><a href='<c:url value="/user/products/?sortType=price-asc"/>'> <i
						class="icon-chevron-right"></i>Theo giá tiền tăng dần
				</a></li>
				<li><a href='<c:url value="/user/products/?sortType=price-desc"/>'> <i
						class="icon-chevron-right"></i>Theo giá tiền giảm dần
				</a></li>
			</ul>
		</li>
	</ul>
</div>