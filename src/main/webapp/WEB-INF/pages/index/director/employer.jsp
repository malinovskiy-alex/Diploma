<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="UTF-8"%>
<div class="clear">
	<form:form method="POST" modelAttribute="employer_bean"
		action="saveEmployer.html" class="form-horizontal base-form">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<div class="control-label">ФИО</div>
					<div class="controls">
						<form:input type="text" maxlength="70" path="FIO" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Пароль</div>
					<div class="controls">
						<form:input type="password" maxlength="70" path="address" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Адресс</div>
					<div class="controls">
						<form:input type="text" maxlength="70" path="address" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Телефон</div>
					<div class="controls">
						<form:input type="text" maxlength="14" path="phone" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Емейл</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="email" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Дата рождения</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="email" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">ИНН</div>
					<div class="controls">
						<form:input type="text" maxlength="8" path="INN" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Номер смены</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="smenaNumber" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Коефициент больничных</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="medCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Коэфициент отпускных</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="weekCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Коэфициент рабочих</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="workCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Должность</div>
					<div class="controls">
						<form:select path="role" items="${roles}" itemLabel="name"
							itemValue="id">
						</form:select>
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