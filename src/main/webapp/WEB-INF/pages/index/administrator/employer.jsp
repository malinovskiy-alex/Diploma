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
					<div class="control-label">FIO</div>
					<div class="controls">
						<form:input type="text" maxlength="70" path="FIO" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Password</div>
					<div class="controls">
						<form:input type="password" maxlength="70" path="address" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Address</div>
					<div class="controls">
						<form:input type="text" maxlength="70" path="address" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Phone</div>
					<div class="controls">
						<form:input type="text" maxlength="14" path="phone" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Email</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="email" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Birthday</div>
					<div class="controls">
						<form:input type="text" maxlength="50" path="email" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">INN</div>
					<div class="controls">
						<form:input type="text" maxlength="8" path="INN" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Relay number</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="smenaNumber" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Medical coeficient</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="medCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Weekend coeficient</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="weekCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Work coeficient</div>
					<div class="controls">
						<form:input type="text" maxlength="4" path="workCoef" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Role</div>
					<div class="controls">
						<form:select path="role" items="${roles}" itemLabel="name"
							itemValue="id">
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">&nbsp;</div>
					<div class="controls form-buttons">
						<button type="submit" class="btn">Submit</button>
						<button type="reset"
							onclick="window.location='<c:url value='cafe-list.html' />'"
							class="btn">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>