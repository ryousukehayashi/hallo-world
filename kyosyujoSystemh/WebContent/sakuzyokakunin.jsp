<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>以下の内容を削除します。よろしいですか?</h2>
<p>生徒ID：${studentid.studentId}</p>
<p>氏名：${student.studentName}</p>
<p>氏名(カタカナ):${student.studentNamePhonetic}</p>
<p>誕生日：${student.birthDay}</p>
<p>住所：${student.address}</p>
<p>性別：${mcode.gender}</p>
<p>電話番号1：${student.phoneNumber1}</p>
<p>電話番号2：${student.phoneNumber2}</p>
<p>希望コース:${mcode1.requestCource}</p>
<p>眼鏡：${mcode2.available}</p>
<p>開始日：${student.startingDate}</p>
<p>受付日：${student.receptionDate}</p>
<p>受付担当者ID：${student.receptionEmployee}</p>
<p>備考：${student.note}</p>

<form action="<%=request.getContextPath() %>/DeleteCheck" method="post">
<input type="hidden" name="studentId" value="${studentid.studentId}"/>
<input type="hidden" name="studentName" value="${student.studentName}"/>
<input type="hidden" name="studentNamePhonetic" value="${student.studentNamePhonetic}"/>
<input type="hidden" name="birthDay" value="${student.birthDay}"/>
<input type="hidden" name="address" value="${student.address}"/>
<input type="hidden" name="gender" value="${student.gender}"/>
<input type="hidden" name="phoneNumber1" value="${student.phoneNumber1}"/>
<input type="hidden" name="phoneNumber2" value="${student.phoneNumber2}"/>
<input type="hidden" name="requestCourse" value="${student.requestCourse}"/>
<input type="hidden" name="glass" value="${student.glass}"/>
<input type="hidden" name="startingDate" value="${student.startingDate}"/>
<input type="hidden" name="receptionDate" value="${student.receptionDate}"/>
<input type="hidden" name="receptionEmployee" value="${student.receptionEmployee}"/>
<input type="hidden" name="note" value="${student.note}"/>
<input type="submit" value="削除確定"/>
</form>
</body>
</html>