<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="center">
	<form method="POST" action="j_spring_security_check"
		class="form-horizontal base-form">
		<div class="row">
			<div class="span5">
				<div class="control-group">
					<div class="control-label">Email</div>
					<div class="controls">
						<input type="text" maxlength="30" name="j_username" />
					</div>
				</div>
				<div class="control-group">
					<div class="control-label">Password</div>
					<div class="controls">
						<input type="password" maxlength="30" name="j_password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn btn-primary" type="submit">Login</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>