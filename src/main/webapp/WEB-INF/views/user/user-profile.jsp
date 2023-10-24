<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	<ul class="breadcrumb">
		<li><a href="/user/home">Trang chủ</a> <span class="divider">/</span></li>
		<li class="active">Thông tin cá nhân</li>
	</ul>
	<div class="well">
		<!--
	<div class="alert alert-info fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	<div class="alert fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div>
	 <div class="alert alert-block alert-error fade in">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
	 </div> -->

		<h4>Thông tin cá nhân</h4>
		<form:form method="POST"
			action="/user/updateProfile?userId=${ userInfor.id }"
			class="form-horizontal" modelAttribute="userInfor">

			<div class="control-group">
				<!-- <label class="control-label">Title <sup>*</sup></label>
				<div class="controls">
					<select class="span1" name="days">
						<option value="">-</option>
						<option value="1">Mr.</option>
						<option value="2">Mrs</option>
						<option value="3">Miss</option>
					</select>
				</div> -->
			</div>

			<div class="control-group">
				<label class="control-label" for="inputFname1">Họ <sup>*</sup></label>
				<div class="controls">
					<form:input type="text" path="surname" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputLnam">Tên <sup>*</sup></label>
				<div class="controls">
					<form:input type="text" path="name" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAddress">Địa chỉ <sup>*</sup></label>
				<div class="controls">
					<form:input type="text" path="address" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="phoneNumber">SĐT <sup>*</sup></label>
				<div class="controls">
					<form:input type="text" path="phone" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="state">Giới tính <sup>*</sup></label>
				<div class="controls">
					<form:select id="state" path="gender">
						<form:option value="Nam">Nam</form:option>
						<form:option value="Nữ">Nữ</form:option>
					</form:select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Ngày sinh <sup>*</sup></label>
				<div class="controls">
					<form:input type="date" id="birthday" name="days" path="dayOfBirth"></form:input>
				</div>
			</div>
			<div>
				<p>${ mess }</p>
			</div>
			<div class="control-group">
				<div class="controls">
					<button class="btn btn-large btn-success" type="submit">Cập
						nhật thông tin</button>
						<!-- <input
						class="btn btn-large btn-success" type="submit"/> -->
				</div>
			</div>

		</form:form>
		<div class="form-horizontal"></div>

		<h4>Thông tin tài khoản</h4>
		<form:form action="/user/profile" method="post"
			class="form-horizontal" modelAttribute="account">
			<div class="control-group">
				<!-- <label class="control-label">Title <sup>*</sup></label>
				<div class="controls">
					<select class="span1" name="days">
						<option value="">-</option>
						<option value="1">Mr.</option>
						<option value="2">Mrs</option>
						<option value="3">Miss</option>
					</select>
				</div> -->
			</div>
			<div class="control-group">
				<label class="control-label" for="inputFname1">Tên đăng nhập
					<sup>*</sup>
				</label>
				<div class="controls">
					<form:input type="text" id="inputFname1"
						placeholder="Tên đăng nhập" path="userName" disabled="disabled" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputLnam">Email <sup>*</sup></label>
				<div class="controls">
					<form:input type="text" id="inputLnam" placeholder="Email"
						path="email" disabled="disabled" />
				</div>
			</div>
			<!-- <div class="control-group">
				<div class="controls">
					<input type="hidden" name="email_create" value="1"> <input
						type="hidden" name="is_new_customer" value="1"> <input
						class="btn btn-large btn-success" type="submit" value="Lưu" />
				</div>
			</div> -->
		</form:form>
		<div class="form-horizontal"></div>

	</div>
	</div>