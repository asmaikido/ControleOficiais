<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul�rio de cadastro de dados de oficial</title>
</head>
<body>
	<h1>Controle de mandados para relat�rios - vers�o 1</h1>
	<%Oficial oficial = (Oficial)request.getAttribute("oficial");%>
	
	<form action="ofcontroller.do" method="post">
		Nome: <input type="text" name="nome" value=""/>
		Matr�cula: <input type="text" name="matricula" value="<%=oficial.getOfMatricula()%>"/>
		<input type="submit" value="Salvar"/>
	</form>
	

</body>
</html>