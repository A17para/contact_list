<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
<script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="js/confirm.js"></script>
</head>
<body>
<h2>編集</h2>

<form action="/contact_list/Update" method="post">
<p>
<c:forEach var = "getList" items="${list}">
<input type="hidden" name="id" value="${getList.id}" />
<label>氏(※)：<input type="text" name="first_name" value="${getList.first_name}" ></label><br>
<label>名氏(※)：<input type="text" name="last_name" value="${getList.last_name}" ></label><br>
<label>会社名：<input type="text" name="company_name" value="${getList.company_name}" ></label><br>
<label>TEL：<input type="tel" name="tel" value="${getList.tel}" ></label><br>
<label>MAIL：<input type="email" name="mail_address" value="${getList.mail_address}" ></label><br>
</c:forEach>
</p>

<!-- クリック時に確認ウィンドウがあったほうが親切? -->
<input type="submit" value="登録する" onclick="UpdateConfirm()">
</form>

<input type="button" value="キャンセル" onclick="location.href='./Main'">

</body>
</html>