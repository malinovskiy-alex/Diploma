<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class="table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>ФИО</td>
			<td>Адресс</td>
			<td>Телефон</td>
			<td>Емейл</td>
			<td>Дата рождения</td>
			<td>Идентификационній номер</td>
			<td>Коэф. рабочих дней</td>
			<td>Коэф. больничных дней</td>
			<td>Коэф. отпускных дней</td>
			<td>Должность</td>
			<td>Редактирование</td>
		</tr>
	</thead>
	<c:forEach items="${employer_list}" var="employer">
		<tr>
			<td>${employer.FIO}</td>
			<td>${employer.address}</td>
			<td>${employer.phone}</td>
			<td>${employer.email}</td>
			<td>${employer.birthday}</td>
			<td>${employer.INN}</td>
			<td>${employer.workCoef}</td>
			<td>${employer.medCoef}</td>
			<td>${employer.weekCoef}</td>
			<td>${employer.role.name}</td>
			<td><a class="btn btn-primary"
				href="employer.html?id=${employer.id}">Редактировать</a></td>
	</c:forEach>
</table>
<a class="btn btn-primary" href="<c:url value='cafe.html'/>">
	Добавить сотрудника </a>