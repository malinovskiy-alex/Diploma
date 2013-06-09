<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Название</td>
			<td>Цена</td>
			<td>Описание</td>
			<td>Редактировать</td>
			<td>Состав</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${dish_list}" var="dish">
			<tr>
				<td>${dish.name}</td>
				<td>${dish.price}&nbsp;грн</td>
				<td>${dish.description}</td>
				<td><a class="btn btn-primary" href="dish.html?id=${dish.id}">Редактировать</a></td>
				<td><a class="btn btn-primary" href="dish-set.html?id=${dish.id}">Состав</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="btn btn-primary" href="product.html">Добавить новое блюдо</a>