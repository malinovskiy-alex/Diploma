<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<div class="clear">
	<form:form method="POST" modelAttribute="vendor_bean"
		action="saveVendor.html" class="form-horizontal base-form">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<div class="control-label">Название организации</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="organization" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">ФИО представителя</div>
					<div class="controls">
						<form:input type="text" maxlength="70" path="advertiser" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Телефон</div>
					<div class="controls">
						<form:input type="text" maxlength="14" path="phone" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Адресс</div>
					<div class="controls">
						<form:input type="text" maxlength="80" path="address" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">&nbsp;</div>
					<div class="controls form-buttons">
						<button type="submit" class="btn">Сохранить</button>
						<button type="reset"
							onclick="window.location='<c:url value='vendor-list.html' />'"
							class="btn">Отменить</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>