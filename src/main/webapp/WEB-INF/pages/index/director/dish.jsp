<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<div class="clear">
	<form:form method="POST" modelAttribute="dish_bean"
		action="saveDish.html" class="form-horizontal base-form">
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
					<div class="control-label">Описание</div>
					<div class="controls">
						<form:textarea type="text" maxlength="14" path="description" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Цена</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="price" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">&nbsp;</div>
					<div class="controls form-buttons">
						<button type="submit" class="btn">Сохранить</button>
						<button type="reset"
							onclick="window.location='<c:url value='cafe-list.html' />'"
							class="btn">Отменить</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>