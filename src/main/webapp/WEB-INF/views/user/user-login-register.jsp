<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Đăng nhập</li>
	</ul>
	<h3>Tài khoản</h3>
	<hr class="soft" />

	<div class="row">
		<div class="span4">
			<div class="well">
				<!-- <h5>Không có tài khoản?</h5> -->
				<!-- <br /> Enter your e-mail address to create an account.<br />
				<br />
				<br /> -->
				<!-- <form action="/user/register"> -->
				<%-- <h5>Đăng ký tài khoản</h5>
				<form:form action="/user/register" class="form-horizontal"
					modelAttribute="userAccount">
					<div class="control-group">
						<label class="control-label" for="input_email">Email <sup>*</sup></label>
						<div class="controls">
							<!-- <input type="text" id="input_email" placeholder="Email"> -->
							<form:input type="email" id="input_email" placeholder="Email"
								path="email" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLnam">Tên đăng nhập
							<sup>*</sup>
						</label>
						<div class="controls">
							<form:input type="text" id="inputLnam"
								placeholder="Tên đăng nhập" path="userName" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Mật khẩu
							<sup>*</sup>
						</label>
						<div class="controls">
							<form:input type="password" id="inputPassword1"
								placeholder="Mật khẩu" path="passWord" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Xác nhận
							mật khẩu <sup>*</sup>
						</label>
						<div class="controls">
							<input type="password" id="inputPassword1"
								placeholder="Xác nhân mật khẩu">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="email_create" value="1"> <input
								type="hidden" name="is_new_customer" value="1"> <input
								class="btn btn-large btn-success" type="submit" value="Đăng ký" />
						</div>
					</div>
				</form:form> --%>
				<!-- <div class="controls">
						<button type="submit" class="btn block">Tạo tài khoản</button>
					</div>
				</form> -->
				<h5>Đăng ký tài khoản</h5>
				<br />
				<form:form action="/user/login-register" method="post"
					modelAttribute="userAccount">
					<div class="control-group">
						<label class="control-label" for="input_email">Email <sup>*</sup></label>
						<div class="controls">
							<!-- <input type="text" id="input_email" placeholder="Email"> -->
							<form:input type="email" id="input_email" placeholder="Email"
								path="email" />
							<form:errors path="email" cssClass="text-danger" />
							<p class="error" style="color: red; margin-left: 10px">
								${errorem}</p>

						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLnam">Tên đăng nhập
							<sup>*</sup>
						</label>
						<div class="controls">
							<form:input type="text" id="inputLnam"
								placeholder="Tên đăng nhập" path="userName" />
							<form:errors path="userName" cssClass="text-danger" />
							<p class="error" style="color: red; margin-left: 10px">
								${errorun}</p>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Mật khẩu
							<sup>*</sup>
						</label>
						<div class="controls">
							<form:input type="password" id="inputPassword1"
								placeholder="Mật khẩu" path="passWord" />
							<form:errors path="passWord" cssClass="text-danger" />
							<p class="error" style="color: red; margin-left: 10px">
								${errorpw}</p>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Xác nhận
							mật khẩu <sup>*</sup>
						</label>
						<div class="controls">
							<input type="password" name="passwordConfirm" id="inputPassword1"
								placeholder="Xác nhân mật khẩu">
							<p class="error" style="color: red; margin-left: 10px">
								<c:if test="${checkPassword}">${error}</c:if>
							</p>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<input type="hidden" name="email_create" value="1"> <input
								type="hidden" name="is_new_customer" value="1"> <input
								class="btn btn-large btn-success" type="submit" value="Đăng ký" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="span1">&nbsp;</div>
		<div class="span4">
			<div class="well">
				<h5>Đăng nhập</h5>
				<form:form action="/user/login-register" method="post"
					modelAttribute="userAccount">
				
				</form:form>
					<div class="control-group">
						<label class="control-label" for="inputEmail1">Email</label>
						<div class="controls">
							<input class="span3" type="text" id="inputEmail1"
								placeholder="Email">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputPassword1">Mật khẩu</label>
						<div class="controls">
							<input type="password" class="span3" id="inputPassword1"
								placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">Đăng nhập</button>
							<a href="forgetpass.html">Quên mật khẩu?</a>
						</div>
					</div>
			</div>
		</div>
	</div>

</div>