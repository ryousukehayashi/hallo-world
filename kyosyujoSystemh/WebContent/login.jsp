<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kyosyujosystem</title>
</head>
<body>

<h2>ログイン画面</h2>
<p class="error">${errMessage}</p>
<form action="<%=request.getContextPath()%>/Login" method = "post">
ID<input type="text" name="loginId" pattern="[0-9]*" title="数字で入力して下さい"><br/>
パスワード<input type="password" name="pass"><br/>
<input type="submit"value="ログイン">
</form>
<input type="button" value="終了" onClick="window.close()">
</body>
</html>