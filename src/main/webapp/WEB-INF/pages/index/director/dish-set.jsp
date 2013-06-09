<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%>
<script src="<c:url value="/resources/js/templates.js" />"></script>
<script>
	function postProduct() {
		$('#dish_form').get(0).setAttribute('action', 'addProduct.html');
		$('#dish_form').submit();
	}
	function deleteProduct(pos) {
		$('#dish_form').get(0).setAttribute('action',
				'removeProduct.html?pos=' + pos);
		$('#dish_form').submit();
	}
</script>
<form:form id="dish_form" action="saveDishSet.html" method="POST"
	modelAttribute="order_form">
	<form:input path="dishId" type="hidden" />
	<div class="clear">
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<label class="control-label">Продукт</label>
					<div class="controls">
						<select id="productId" name="productId">
							<option value="" disabled="disabled" selected
								style='display: none;'>Выберите продукт</option>
							<c:forEach items="${product_list}" var="product">
								<option value="${product.id}">${product.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Количество</label>
					<div class="controls">
						<input id="weight" type="text" name="weight" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls form-buttons">
						<button onclick="postProduct()" type="button"
							class="btn btn-primary send">Добавить продукт</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td>Продукт</td>
				<td>Количество</td>
				<td>Редактировать</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dish_form.products}" var="product"
				varStatus="status">
				<tr>
					<form:input path="orders[${status.index}].productId" type="hidden" />
					<form:input path="orders[${status.index}].productName"
						type="hidden" />
					<form:input path="orders[${status.index}].weight" type="hidden" />
					<td>${product.productName}</td>
					<td>${product.weight}</td>
					<td>
						<button onclick="deleteProduct(${status.index})" type="button"
							class="btn btn-primary">Убрать</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="postOrder()" type="button" class="btn btn-primary">Сохранить
		состав</button>
</form:form>
