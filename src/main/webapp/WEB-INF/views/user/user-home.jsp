<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="span9">
	
	<h4>Latest Products</h4>
	<ul class="thumbnails">
		<c:forEach var="productItem" items="${ product.content }">
			<li class="span3">
				<div class="thumbnail">
					<a
						href="<c:url value="/user/product-details/${ productItem.id }"/>"><img width="150" height="150"
						src="/templates/image/${ productItem.image }"
						alt="" /></a>
					<div class="caption">
						<h5>${ productItem.name }</h5>
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
	<div class="pagination">
		<ul>
		<c:if test="${product.number > 0}">
            <li><a href="/user/home?p=0">First</a></li>
            <li><a href="/user/home?p=${product.number - 1}">Prev</a></li>
        </c:if>
        <c:if test="${product.number < product.totalPages - 1}">
            <li><a href="/user/home?p=${product.number + 1}">Next</a></li>
            <li><a href="/user/home?p=${product.totalPages - 1}">Last</a></li>
        </c:if>
		</ul>
	</div>
</div>