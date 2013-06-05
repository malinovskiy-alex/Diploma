<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Кафедра</title>

<link href="<c:url value="/resources/css/bootstrap-responsive.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/docs.css"/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.7.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

</head>
<body>
	<div class="wrapper">

		<div class="navbar navbar-inverse navbar-fixed-top">
			<tiles:insertAttribute name="header" />
		</div>

		<%--<div id="subheader">
			<tiles:insertAttribute name="subheader" />
		</div> --%>

		<div class="container">
			<tiles:insertAttribute name="content" />
		</div>

		<%-- <div class="footer">
			<tiles:insertAttribute name="footer" />
		</div> --%>
	</div>
</body>
</html>
