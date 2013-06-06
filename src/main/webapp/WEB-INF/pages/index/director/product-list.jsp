<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Название</td>
			<td>Цена за единицу</td>
			<td>Единица</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${product_list}" var="product">
			<tr>
				<td>${product.name}</td>
				<td>${product.priceByOne}</td>
				<td>${product.type}</td>
				<td><button class="btn btn-primary" type="button">
						Редактировать</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>