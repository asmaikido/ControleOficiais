<%@ page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de oficiais</title>

<script type="text/javascript">
	function confirmaexclusao (matricula){
		if (window.confirm('Tem certeza de que deseja excluir?')){
			location.href="ofcontroller.do?acao=excluir&matricula="+matricula;
		}
	}
</script>

</head>
<body>
	<%List<Oficial> listaoficiais = (List<Oficial>)request.getAttribute("listaoficiais");%>
	<table border=1>
		<tr>
			<th> Nome </th>
			<th> Matrícula </th>
			<th> Ação </th> 
		</tr>
	<%for (Oficial o: listaoficiais){%>
		<tr>
			<td><%=o.getOf_nome()%></td>
			<td><%=o.getOf_matricula()%></td>
			<td> <a href="javascript:confirmaexclusao(<%=o.getOf_matricula()%>)">excluir</a> | <a href="ofcontroller.do?acao=alterar&matricula=<%=o.getOf_matricula()%>">alterar</a> </td>
		</tr>
	<%}%>
	</table>
</body>
</html>