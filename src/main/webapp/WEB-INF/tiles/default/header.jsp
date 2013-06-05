<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="navbar-inner">
	<div class="container">
		<button data-target=".nav-collapse" data-toggle="collapse"
			class="btn btn-navbar" type="button">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<li class=""><a href="<c:url value="/"></c:url>">Home</a></li>
				<li class=""><a href="<c:url value="/login.html"></c:url>">Login</a></li>
				<li class=""><a
					href="<c:url value="/registration.html"></c:url>">Registration</a></li>
			</ul>
		</div>
	</div>
</div>
