<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%>
<style>
.error {
	color: red
}
</style>
<form:form method="POST" modelAttribute="product_form">
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td>Название</td>
				<td>Цена за единицу</td>
				<td>Единица</td>
				<td>Количество</td>
				<td>Принимаемое количество</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${product_form.beans}" var="pr" varStatus="status">
				<tr>
					<form:input path="beans[${status.index}].cafeProductId"
						type="hidden" />
					<form:input path="beans[${status.index}].name" type="hidden" />
					<form:input path="beans[${status.index}].price" type="hidden" />
					<form:input path="beans[${status.index}].type" type="hidden" />
					<form:input path="beans[${status.index}].available" type="hidden" />
					<td>${pr.name}</td>
					<td>${pr.price}</td>
					<td>${pr.type.type}</td>
					<td>${pr.available}</td>
					<td><form:input path="beans[${status.index}].added"
							class="input-small" /> <form:errors
							path="beans[${status.index}].added" cssClass="error" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="submit" class="btn btn-primary">Принять</button>
</form:form>