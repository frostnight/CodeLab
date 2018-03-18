<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.member.db.*" %>
<%
	List memberlist = (List) request.getAttribute("memberlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center>
		<td colspan=2>회원 목록</td>
	</tr>
	<%
		for(int i=0; i < memberlist.size(); i++){
			MemberBean member = (MemberBean) memberlist.get(i);
	%>
	<tr align=center>
		<td>
			<a href="MemberViewAction.me?id=<%=member.getMEMBER_ID() %>">
				<%=member.getMEMBER_ID() %>
			</a>
		</td>
		<td>
		<a href="MemberDeleteAction.me?id=<%=member.getMEMBER_ID() %>">삭제</a>
		</td>
	</tr>
	<%
		}
	%>
	<tr align=center>
		<td colspan=2>
			<a href="./BoardList.bo">[게시판 이동]</a>
		</td>
	</tr>
</table>
</center>
</body>
</html>