<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Название</td>
			<td>Цена за единицу</td>
			<td>Единица</td>
			<td>Редактировать</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${product_list}" var="product">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.type.type}</td>
				<td><a class="btn btn-primary"
					href="product.html?id=${product.id}">Редактировать</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="btn btn-primary" href="product.html">Добавить новый товар</a>