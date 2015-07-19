<!DOCTYPE html>
<%@page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de entrada de dados de oficial</title>
</head>
<body>
	<%Oficial oficial = (Oficial)request.getAttribute("oficial");%>
	<form action="ofcontroller.do" method="post">
		Nome: <input type="text" name="nome" value="<%=oficial.getOf_nome()%>"/>
		Matrícula: <input type="text" name="matricula" value="<%=oficial.getOf_matricula()%>"/>
		<input type="submit" value="Salvar"/>
	</form>
	

</body>
</html>