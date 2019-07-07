<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href='css/estilo.css'></link>
<title>Parabéns!</title>
</head>
<body>
		<header>
			<h2><%=request.getAttribute("nome").toString()%> foi criado com sucesso!</h2>
		</header>
		<section align="center">
			<img src="../Comp3_Final/like.png" align="middle" width="200" height="200" >
		</section>
	</body>
</html>