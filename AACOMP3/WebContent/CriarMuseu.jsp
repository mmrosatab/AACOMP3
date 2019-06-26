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
			
			<section>
				<select id=cbPais>
				    <option>Selecionar Solicitação</option>
				    <option></option>
				    <option></option>
				    <option></option>
				</select>
			</section>		
			
			
			<form action="criacarMuseu" method="post">
				<label>Nome:</label>
				<div><input type="text" name="nome"></div>
				<label>Data de Criação:</label> 
				<div><input type="text" name="dataCriacao"></div> 
				<label>Cidade:</label>
				<div><input type="text" name="cidade"></div> 
				<label>CPF gestor:</label>
				<div><input type="text" name="cpf"></div>
				<label>Nome do gestor:</label>
				<div><input type="text" name="nomeGestor"></div>
				<input class='sub' type="submit" name="cmd" value="Criar Museu">
			</form>
		</section>
	</body>
</html>