<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<div class="clear">
	<form:form method="POST" modelAttribute="product_bean"
		action="saveProduct.html" class="form-horizontal base-form">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<div class="control-label">Название</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="name" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Единица</div>
					<div class="controls">
						<form:select path="type">
							<form:options items="${types}" itemLabel="type" />
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Поставщик</div>
					<div class="controls">
						<form:select path="vendor" items="${vendor_list}"
							itemLabel="organization" itemValue="id">
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Цена</div>
					<div class="controls">
						<form:input path="price" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">&nbsp;</div>
					<div class="controls form-buttons">
						<button type="submit" class="btn">Добавить</button>
						<button type="reset"
							onclick="window.location='<c:url value='product-list.html' />'"
							class="btn">Назад</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>