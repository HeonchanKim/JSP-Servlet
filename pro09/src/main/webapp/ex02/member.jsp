<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	import="java.util.List"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 클라이언트에서 전달한 데이터의 문자 인코딩 설정
request.setCharacterEncoding("utf-8");
%>

<%-- useBean 액션 태그를 이용해 자바빈 생성 --%>
<jsp:useBean id="member" class="ex02.MemberVO" />
 
<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- 자바빈의 속성의 이름과 요청 매개변수의 이름이 같으면, setProperty 액션 태그의
	 property 속성에 "*(와일드카드 문자)"를 사용할수 있다. --%>
<jsp:setProperty name="member" property="*" />

<%
// MemberDAO 객체 생성
MemberDAO memberDAO = new MemberDAO();

// MemberDAO 객체의 insertMember 메소드를 이용해 새로운 회원 등록
if (member.getAccount() != null)
	memberDAO.insertMember(member);

// 전체 회원 회원 목록 구해오기
List<MemberVO> memberList = memberDAO.getMemberList();

// 표현 언어에서 접근할 수 있도록 request 객체에 memberList를 바인딩
request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member List</title>
</head>
<body>
	<h1>Member List</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Account</th>
				<th>Name</th>
				<th>Email</th>
				<th>Registration Date</th>
			</tr>
		</thead>
		<tbody>
		
		<c:choose>
			<c:when test="${empty memberList}">
				<tr>
					<td colspan="5">There are no registered members.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="item" items="${memberList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.account}</td>
						<td>${item.name}</td>
						<td>${item.email}</td>
						<td>${item.regdate}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	
	<p>[<a href="./member-reg.html">Register a new member</a>]</p>
</body>
</html>