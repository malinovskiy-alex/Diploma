<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<table class=" table table-striped table-bordered table-condensed">
	<thead>
		<tr>
			<td>Огранизация</td>
			<td>Представитель</td>
			<td>Телефон представителя</td>
			<td>Адресс представительства</td>
			<td>Профиль</td>
			<td>Продукты</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${vendor_list}" var="vendor">
			<tr>
				<td>${vendor.organization}</td>
				<td>${vendor.advertiser}</td>
				<td>${vendor.phone}</td>
				<td>${vendor.address}</td>
				<td><a class="btn btn-primary"
					href="vendor.html?id=${vendor.id}"> Редактировать</a></td>
				<td><a class="btn btn-primary"
					href="product-list.html?id=${vendor.id}">Список продуктов</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a class="btn btn-primary" href="<c:url value='vendor.html'/>">
	Новый поставщик</a>