<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	
	<h4>Latest Products</h4>
	<ul class="thumbnails">
		<c:forEach var="productItem" items="${ product }">
			<li class="span3">
				<div class="thumbnail">
					<a
						href="<c:url value="/user/product-details/${ productItem.id }"/>"><img width="100"
						src="/templates/image/${ productItem.image }"
						alt="" /></a>
					<div class="caption">
						<h5>${ productItem.name }</h5>
						<%-- <p>${ productItem.description }</p> --%>
						<h4 style="text-align: center">
							<a class="btn"
								href="<c:url value="/user/product-details/${ productItem.id }"/>">
								<i class="icon-zoom-in"></i>
							</a> <a class="btn" href="<c:url value="/user/product-details/${ productItem.id }"/>">Add to <i class="icon-shopping-cart"></i>
							</a> <a class="btn btn-primary"><fmt:formatNumber
									value="${productItem.price}" type="currency" currencySymbol=""
									maxFractionDigits="0"></fmt:formatNumber> đ</a>
						</h4>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>