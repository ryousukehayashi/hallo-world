<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<h2>生徒登録画面</h2>
<p>生徒の情報を入力して下さい</p>
<p class="error">${errMessage}</p>
<p class="error1">${errMessage1}</p>
<form action="<%=request.getContextPath()%>/Insert" method="post">
<p>生徒ID:<input type="text" name="studentId"value="${student.studentId}"><input type="submit" name="kensaku" value="問合せ"></p>
<p>氏名：<input type="text" name="studentName" value="${student.studentName }" maxlength='30'  ></p>
<p>フリガナ(カナ)：<input type="text" name="studentNamePhonetic"value="${student.studentNamePhonetic}"maxlength='30'  pattern="^[ｧ-ﾝﾞﾟ]+$" title="半角ｶﾀｶﾅでご入力ください。"></p>
<p>生年月日(年)：<input type="number" name="birthDayYear"value="${student.birthDayYears}"maxlength='4' min='1900'max='2100' ></p>
<p>生年月日(月)：<input type="number" name="birthDayMouth"value="${student.birthDayMouth}"maxlength='2'min='01'max='12' ></p>
<p>生年月日(日)：<input type="number" name="birthDayDays"value="${student.birthDayDays}"maxlength='2' min='01'max='31'></p>
<p>住所：<input type="text" name="address"value="${student.address}"maxlength='100'></p>
<c:choose>
  <c:when test="${student.gender == '0'}"><c:set var="gender_0_checked">checked</c:set></c:when>
  <c:otherwise><c:set var="sex_0_checked">checked</c:set></c:otherwise>
</c:choose>
<p>性別：<input type="radio" name="gender" <c:if test="${student.gender == '1'}">checked</c:if>  value="1"/> 男
<input type="radio" name="gender"<c:if test="${student.gender == '2'}">checked</c:if>  value="2"/>女</p>
<p>連絡先1：<input type="text" name="phoneNumber1"value="${student.phoneNumber1}"maxlength='11'	pattern="[0-9]*" title="数字で入力して下さい"></p>
<p>連絡先2：<input type="text" name="phoneNumber2"value="${student.phoneNumber2}"maxlength='11'pattern="[0-9]*" title="数字で入力して下さい" ></p>
<p>希望コース：<select name="requestCouse">
<option value="01"<c:if test="${student.requestCourse == '01'}">selected</c:if>>普通車MT 原付・二輪免許無し</option>
<option value="02"<c:if test="${student.requestCourse == '02'}">selected</c:if>>普通車MT 原付・二輪免許有り</option>
<option value="03"<c:if test="${student.requestCourse == '03'}">selected</c:if>>普通車AT 原付・二輪免許無し</option>
<option value="04"<c:if test="${student.requestCourse == '04'}">selected</c:if>>普通車AT 原付・二輪免許有り</option>
<option value="05"<c:if test="${student.requestCourse == '05'}">selected</c:if>>普通車MT　仮免許有り</option>
<option value="06"<c:if test="${student.requestCourse == '06'}">selected</c:if>>普通車AT　仮免許有り</option>
<option value="07"<c:if test="${student.requestCourse == '07'}">selected</c:if>>普通車MT AT限定免許有り</option>
</select></p>
<p>眼鏡：<input type="radio" name="glasses" <c:if test="${student.glass == 1}">checked</c:if> value="1">有り
<input type="radio" name="glasses"<c:if test="${student.glass == 0}">checked</c:if> value="0">無し
</p>
<p>開始日：<input type="text" name="startingDate" value="${student.startingDate}"maxlength='8'　pattern="[0-9]*" title="数字で入力して下さい" ></p>
<p>受付日：<input type="text" name="receptionDate"value="${student.receptionDate}"maxlength='8'pattern="[0-9]*" title="数字で入力して下さい" ></p>
<p>受付担当者ID：<input type="text" name="receptionEmpoyee" value=<%=session.getAttribute("loginId")%>></p>
<p>受付担当者名称：<%=session.getAttribute("userName")%></p>
<p>備考：<input type="text"  name="note" value="${student.note}"></p>

<p><input type="submit" name="touroku" value="登録確認"> <input type="submit" name="kousin" value="更新確認"> 
<input type="submit" name="sakuzyo" value="削除確認"></p>

<input type="submit" name="syuryou" value="終了">

</form>

</body>
</html>