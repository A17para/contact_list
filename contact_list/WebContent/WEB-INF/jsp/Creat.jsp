<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<script src="js/confirm.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.0.min.js"></script>
<!-- <link rel="stylesheet" href="style.css"> -->
</head>
<body>
<h2>新規登録</h2>

<form action="./NewRegistration" method="post">
<p>
<label>氏(※)：<input type="text" name="first_name" required></label><br>
<label>名氏(※)：<input type="text" name="last_name" required></label><br>
<label>会社名：<input type="text" name="company_name"></label><br>
<label>TEL：<input type="tel" name="tel"></label><br>
<label>MAIL：<input type="email" name="mail_address"></label><br>
</p>

<!-- クリック時に確認ウィンドウがあったほうが親切? -->
<input type="submit" value="登録する" onclick="EntryConfirm()">
</form>

<input type="button" value="キャンセル" onclick="location.href='./Main'">

</body>
</html>