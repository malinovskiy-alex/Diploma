<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Адресс</td>
			<td>Телефон</td>
			<td>Количество мест</td>
			<td>Редактировать</td>
			<td>Сотрудники</td>
		</tr>
	</thead>
	<c:forEach items="${cafe_list}" var="cafe">
		<tr>
			<td>${cafe.address}</td>
			<td>${cafe.phone}</td>
			<td>${cafe.placeCount}</td>
			<td><a class="btn btn-primary" href="cafe.html?id=${cafe.id}">
					Редактировать</a></td>
			<td><a class="btn btn-primary"
				href="employer-list.html?cafe=${cafe.id}">Сотрудники</a></td>
	</c:forEach>
</table>
<a class="btn btn-primary" href="<c:url value='cafe.html'/>">
	Добавить кафе </a>