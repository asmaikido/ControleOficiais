<%@ page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de oficiais</title>
</head>
<body>
<%
	List<Oficial> listaoficiais = (List<Oficial>)request.getAttribute("listaoficiais");
	out.print("<table border=1>");
	out.print("<tr> <th> Nome </th> <th> Matrícula </th> </tr>");
	for (Oficial o: listaoficiais){
		out.print("<tr>");
		out.print("<td>" + o.getOf_nome() + "</td> <td> " + o.getOf_matricula() + "</td>");
		out.print("</tr>");
	}
	out.print("</table>");
%>
</body>
</html>