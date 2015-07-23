<!DOCTYPE html>
<%@page import="br.com.asm.controleoficiais.persistencia.entidade.Oficial"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formul�rio de cadastro de dados de oficial</title>
</head>
<body>
	<h1>Controle de mandados para relat�rios - vers�o 1</h1><br>
	<p><b>Matr�cula n�o cadastrada!</b></p><br>
	<p>Desejar efetuar o cadastro do oficial?</p>

	<input id="numb" type="boolean">

	<button type="button" onclick="myFunction()">Submit</button>

	<p id="demo"></p>
	
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
	<script>
        window.onload = downScripts;
        
        function downScripts() {
            var element = document.createElement("script");
            element.src = "myscripts.js";
            document.body.appendChild(element);
        }
    </script>
    <noscript>Desculpe-me, seu "browser" n�o suporta JavaScript!</noscript>
</body>
</html>