<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
	<table border=1>
		<tr>
			<th> Nome </th>
			<th> Matr�cula </th>
			<th> A��o </th> 
		</tr>
	    <c:forEach items="${requestScope.listaoficiais}" var ="o">
		    <tr>
			    <td>${o.nome}</td>
			    <td>${o.matricula}</td>
			    <td> <a href="javascript:confirmaexclusao(${o.matricula})">excluir</a> | <a href="ofcontroller.do?acao=alterar&matricula=${o.matricula}">alterar</a> </td>
		    </tr>
	    </c:forEach>
	</table>
</body>
</html>