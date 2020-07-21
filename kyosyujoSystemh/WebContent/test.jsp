<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${message}</h2>
<form action = "<%=request.getContextPath()%>/test" method="post">
<input type="submit"value="接続画面に戻る"/>
</form>
</body>
</html>