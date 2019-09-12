<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>連絡帳</title>
<link rel="stylesheet" href="style.css">

<script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script src="js/confirm.js"></script>
<script src="js/all_check.js"></script>
<script src="js/check_count.js"></script>
<script src="js/update.js"></script>

</head>

<body>
<h1>連絡帳</h1>

<form name="form">
	<table>
        <tr>
            <th> <button type="button" id="all" onclick="AllCheck()">選択</button></th>
            <th colspan="2">氏名</th>
            <th>会社名</th>
            <th>TEL</th>
            <th>メールアドレス</th>
        </tr>
        	<c:forEach var = "getList" items="${list}">
        	<tr>
        	<td><input type="checkbox" name="id" value="${getList.id}"></td>
        	<td><c:out value="${getList.first_name}"></c:out></td>
        	<td><c:out value="${getList.last_name}"></c:out></td>
        	<td><c:out value="${getList.company_name}"></c:out></td>
        	<td><c:out value="${getList.tel}"></c:out></td>
        	<td><c:out value="${getList.mail_address}"></c:out></td>
        	</tr>
        	</c:forEach>

	</table>
</form>
		<!-- ボタンを追加 -->
		<table>
		<tr>
		<input type="button" value="新規登録" onclick="location.href='./NewRegistration'">

		<!-- チェックの数が２以上の時、ボタンを禁止にする。 -->
		<form action="./Update" method="get">
		<input type="hidden" name="id" id="id" />
		<button type="submit"  id="edit" onclick="getTableRecords()">編集</button>
		</form>


		<form action="./Delete" method="post">
		<input type="hidden" name="getDelId[]" id="getDelId"/>
		<button type="submit" name="btn" onclick="DeletingConfirm()">削除</button>
		</form>

		<!-- safariは閉じる。Chromeはセキュリティの問題でタブが残る？ -->
		<button type="button" onclick="WindowClose()">閉じる</button>

		<tr>
		</table>

</body>
</html>