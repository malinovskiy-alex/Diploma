<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%>
<script src="<c:url value="/resources/js/templates.js" />"></script>
<script>
	function postDish() {
		$('#order_form').get(0).setAttribute('action', 'addDish.html');
		$('#order_form').submit();
	}
	function postOrder() {
		$('#order_form').get(0).setAttribute('action', 'saveOrder.html');
		$('#order_form').submit();
	}
	function deleteDish(pos) {
		$('#order_form').get(0).setAttribute('action',
				'removeDish.html?pos=' + pos);
		$('#order_form').submit();
	}
</script>
<form:form id="order_form" action="saveOrder.html" method="POST"
	modelAttribute="order_form">
	<div class="clear">
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<label class="control-label">Блюдо</label>
					<div class="controls">
						<select id="dishId" name="dishId">
							<option value="" disabled="disabled" selected
								style='display: none;'>Выберите блюдо</option>
							<c:forEach items="${dish_list}" var="dish">
								<option value="${dish.id}">${dish.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Количество</label>
					<div class="controls">
						<input id="count" type="text" name="count" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls form-buttons">
						<button onclick="postDish()" type="button"
							class="btn btn-primary send">Добавить блюдо</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<td>Название</td>
				<td>Цена за единицу</td>
				<td>Количество</td>
				<td>Стоимость</td>
				<td>Редактировать</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${order_form.orders}" var="order"
				varStatus="status">
				<tr>
					<form:input path="orders[${status.index}].dishId" type="hidden" />
					<form:input path="orders[${status.index}].dishName" type="hidden" />
					<form:input path="orders[${status.index}].dishPrice" type="hidden" />
					<form:input path="orders[${status.index}].totalPrice" type="hidden" />
					<form:input path="orders[${status.index}].count" type="hidden" />
					<td>${order.dishName}</td>
					<td>${order.dishPrice}</td>
					<td>${order.count}</td>
					<td>${order.totalPrice}</td>
					<td>
						<button onclick="deleteDish(${status.index})" type="button"
							class="btn btn-primary">Убрать</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="postOrder()" type="button" class="btn btn-primary">Сохранить
		заказ</button>Total price ${order_form.totalPrice}
</form:form>
