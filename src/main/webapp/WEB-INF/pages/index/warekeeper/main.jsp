<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%><form:form method="POST"
	modelAttribute="product_form">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td>Название</td>
				<td>Цена за единицу</td>
				<td>Единица</td>
				<td>Количество</td>
				<td>Добавить</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${product_form.products}" var="pr"
				varStatus="index">
				<tr>
					<form:input path="products[${index.index}].product.name"
						type="hidden" />
					<form:input path="products[${index.index}].product.price"
						type="hidden" />
					<form:input path="products[${index.index}].product.type"
						type="hidden" />
					<form:input path="products[${index.index}].availableQuantity"
						type="hidden" />
					<td>${pr.product.name}</td>
					<td>${pr.product.price}</td>
					<td>${pr.product.type.type}</td>
					<td>${pr.availableQuantity}</td>
					<td><form:input path="products[${index.index}].added" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="submit" class="btn btn-primary">Оприходовать
		продукты</button>
</form:form>