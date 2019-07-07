<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="dominio.*" %>

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
			<div class='texto'><p>Área de identificação do usuário</p></div>
			<form action="index" method="post">
				<label>CPF:</label>
				<div><input type="text" name="cpf"></div>
				<label>Senha:</label>  
				<div><input type="password" name="senha"></div>
				<input class='sub' type="submit" name="btnIdentificar" value="Identificar">
			</form>
		</section>
	</body>
</html>