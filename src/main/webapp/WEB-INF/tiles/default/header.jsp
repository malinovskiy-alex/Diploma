<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%><sec:authorize
	access="isAuthenticated()" var="isAuth" />
<div class="navbar-inner">
	<div class="container">
		<button data-target=".nav-collapse" data-toggle="collapse"
			class="btn btn-navbar" type="button">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<c:if test="${isAuth}">
					<li class=""><a href="<c:url value="/main.html"></c:url>">Home</a></li>
				</c:if>
				<li class=""><a href="<c:url value="/logout"></c:url>">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
