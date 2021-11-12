<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ex02.*"
	import="java.util.List"
    pageEncoding="UTF-8" %>
<%
// 클라이언트에서 전달한 데이터의 문자 인코딩 설정
request.setCharacterEncoding("utf-8");

/*
// 클라이언트에서 전달한 값으로 MemberVO 객체를 생성
MemberVO member = new MemberVO(
		0,
		request.getParameter("account"),
		request.getParameter("passwd"),
		request.getParameter("name"),
		request.getParameter("email"),
		null
);
*/
%>

<%-- useBean 액션 태그를 이용해 자바빈 생성 --%>
<jsp:useBean id="member" class="ex02.MemberVO" />

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- value 속성에 request 객체의 getParameter 메소드를 이용해 클라이언트에서 전달된 값을 설정 --%>
<%--
<jsp:setProperty name="member" property="account" value="<%= request.getParameter("account") %>" />
<jsp:setProperty name="member" property="passwd" value="<%= request.getParameter("passwd") %>" />
<jsp:setProperty name="member" property="name" value="<%= request.getParameter("name") %>" />
<jsp:setProperty name="member" property="email" value="<%= request.getParameter("email") %>" />
 --%>
 
<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- setProperty 액션 태그의 value 속성의 값이 클라이언트에서 전달된 값이라면
	 param 속성의 요청 매개변수만 명시해도 된다. --%>
<%-- 
<jsp:setProperty name="member" property="account" param="account" />
<jsp:setProperty name="member" property="passwd" param="passwd" />
<jsp:setProperty name="member" property="name" param="name" />
<jsp:setProperty name="member" property="email" param="email" />
--%>

<%-- setProperty 액션 태그를 이용해 자바빈의 속성을 설정 --%>
<%-- setProperty 액션 태그의 property 속성의 값과 value 속성의 값이 같으면
	 value 속성을 생략할 수 있다. --%>
<%--
<jsp:setProperty name="member" property="account" />
<jsp:setProperty name="member" property="passwd" />
<jsp:setProperty name="member" property="name" />
<jsp:setProperty name="member" property="email" />
 --%>
 
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
<% for (MemberVO item : memberList) { %>
			<tr>
				<td><% out.print(item.getId()); %></td>
				<td><%= item.getAccount() %></td>
				<td><%= item.getName() %></td>
				<td><%= item.getEmail() %></td>
				<td><%= item.getRegdate() %></td>
			</tr>
<% } %>
		</tbody>
	</table>
	
	<p>[<a href="./member-reg.html">Register a new member</a>]</p>
</body>
</html>