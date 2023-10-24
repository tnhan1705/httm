<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div id="header">
	<div class="container">
		<!-- <div id="welcomeLine" class="row">
			<div class="span6">
				Welcome!<strong> User</strong>
			</div>
			<div class="span6">
				<div class="pull-right">
					<a href="product_summary.html"><span class="">Fr</span></a> <a
						href="product_summary.html"><span class="">Es</span></a> <span
						class="btn btn-mini">En</span> <a href="product_summary.html"><span>&pound;</span></a>
					<span class="btn btn-mini">$155.00</span> <a
						href="product_summary.html"><span class="">$</span></a>
					<a href="cart"><span class="btn btn-mini btn-primary">
					<i class="icon-shopping-cart icon-white"></i> [ 3 ] Itemes in your cart </span></a>
				</div>
			</div>
		</div> -->
		<!-- Navbar ================================================== -->
		<div id="logoArea" class="navbar">
			<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="navbar-inner">
				<a class="brand" href="/user/home"><img
					src="/templates/User/bootstrap-shop/themes/images/logo.png"
					alt="Bootsshop" /></a>
				<form class="form-inline navbar-search" method="get"
					action="/user/search">
					<input id="searchInput" class="srchTxt" type="text" placeholder="Tìm kiếm"/>
					<button type="button" onclick="search()" id="submitButton" class="btn btn-primary">Tìm</button>
				</form>

				<script type="text/javascript">
					function search() {
						var keyword = document.getElementById("searchInput").value;
						window.location.href = "/user/search?keyword=" + keyword;
					}
				</script>

				<ul id="topMenu" class="nav pull-right">
					<!-- <li class=""><a href="/user/special-offer">Specials Offer</a></li>
					<li class=""><a href="/user/delivery">Delivery</a></li> -->
					<li class=""><a href="/user/contact">Giới thiệu</a></li>
					<!-- <li class=""><a href="/user/register">Đăng ký</a></li> -->
					<c:if test="${ checkLogin == null }">
						<li class=""><a href="/signin">Đăng ký</a></li>
						<li class=""><a href="/login">Đăng nhập</a></li>
					</c:if>
					<c:if test="${ checkLogin != null }">
						<li class=""><a href="/user/profile">Thông tin cá nhân</a></li>
						<li class=""><a href="/logout">Đăng Xuất</a></li>
					</c:if>

					<!-- <div id="login" class="modal hide fade in" tabindex="-1"
							role="dialog" aria-labelledby="login" aria-hidden="false">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h3>Login Block</h3>
							</div>
							<div class="modal-body">
								<form class="form-horizontal loginFrm">
									<div class="control-group">
										<input type="text" id="inputEmail" placeholder="Email">
									</div>
									<div class="control-group">
										<input type="password" id="inputPassword"
											placeholder="Password">
									</div>
									<div class="control-group">
										<label class="checkbox"> <input type="checkbox">
											Remember me
										</label>
									</div>
								</form>
								<button type="submit" class="btn btn-success">Sign in</button>
								<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
							</div>
						</div></li> -->
				</ul>
			</div>
		</div>
	</div>
</div>