<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>

<body>
<h2>メニュー画面</h2>

<form action="<%=request.getContextPath()%>/Touroku">
<input type="submit" value="登録">
</form>

<form action="<%=request.getContextPath()%>/Logout">
<input type="submit" value="終了">
</form>
</body>
</html>