<!DOCTYPE html>
<%@page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formul�rio de cadastro de dados de oficial</title>
<script type="text/javascript">
	boolean function confirmacadastro(){
		if (window.confirm('Tem certeza de que deseja excluir?')){
			return true;
		}
	}
</script>
</head>
<body>
	<h1>Controle de mandados para relat�rios - vers�o 1</h1><br>
	<p><b>Matr�cula n�o cadastrada!</b></p><br>
	<% if (confirmacadastro()) {%>
		<form action="ofcontroller.do" method="post">
			<label for="nome">Nome</label>
  			<input type="text" name="nome" id="nome" value="">
			<label for="matricula">Matr�cula</label>
  			<input type="text" name="matricula" id="matricula" value="">
  			<label for="senha">Senha</label>
  			<input type="password" name="senha" id="senha" value="">
  		
  			<!-- Seta o atributo a��o com o valor cadastrar para OficialController -->
  			<input type="hidden" name="acao" value="cadastrar">
  		
  			<input type="submit" value="Cadastrar">
  	<%}%>
	</form>
</body>
</html>