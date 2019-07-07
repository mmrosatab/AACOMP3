<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href='css/estilo.css'></link>
<title>SAGM</title>
</head>
	<body>
		<header>
			<h2>SISTEMA DE APOIO À GESTÃO DE MUSEUS (SAGM)</h2>
		</header>
		<section>
			<div class='texto'>Olá, <%=request.getAttribute("nome")%> </div> 
			<div class='texto'>Função: <%=request.getAttribute("funcao")%> </div>
			<div><a href='InformarSolicitacao.jsp'>Solicitar Criação Museu</a>
				 <a href='CriarMuseu.jsp'>Criar Museu</a>
			</div>
		</section>
	</body>
</html>