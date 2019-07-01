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
			<form action="solicitarCriacaoMuseu" method="post">
				<% String meu_nome 		= "";
				   String minhaData 	= "";
				   String cidade 		= "";
				   String cpf 			= "";
				   String nomeG 		= "";
				   
				   if(request.getAttribute("meu_nome") != null)
				   {
					   meu_nome = request.getAttribute("meu_nome").toString();
				   }
				   if(request.getAttribute("dataCriacao") != null)
				   {
					   minhaData = request.getAttribute("dataCriacao").toString();
				   }
				   if(request.getAttribute("cidade") != null)
				   {
					   cidade = request.getAttribute("cidade").toString();
				   }
				   if(request.getAttribute("cpf") != null)
				   {
					   cpf = request.getAttribute("cpf").toString();
				   }
				   if(request.getAttribute("nomeGestor") != null)
				   {
					   nomeG = request.getAttribute("nomeGestor").toString();
				   }
				   
				%>
				<div>
					<select class="texto" name="opcoes"">
					<% ArrayList<SolicitacaoMuseuMD> s  = new ArrayList<SolicitacaoMuseuMD>();
					   s = SolicitacaoMuseuMD.listarSolicitacoes();
					   String nome;
					   String data;
					   for(SolicitacaoMuseuMD sol:s){
						   nome  = sol.getNome();
						   data  = sol.getData();
					%>				
					    <option value= <%=data + "-" + nome%> > <%=nome%> </option>
					<%}%>
					</select>
					<input class='sub' type="submit" name="cmd" value="Ok">
				</div>
			</form>
			<form action="solicitarCriacaoMuseu" method="post">
				
				<label>Nome:</label>
				<div><input type="text" name="meu_nome" value=<%= meu_nome%>></div>
				<label>Data de Criação:</label> 
				<div><input type="text" name="dataCriacao" value=<%=minhaData%>></div> 
				<label>Cidade:</label>
				<div><input type="text" name="cidade" value=<%=cidade%>></div> 
				<label>CPF gestor:</label>
				<div><input type="text" name="cpf" value=<%=cpf%>></div>
				<label>Nome do gestor:</label>
				<div><input type="text" name="nomeGestor" value=<%=nomeG%>></div>
				<input class='sub' type="submit" name="cmd" value="Criar Museu">
			</form>
		</section>
	</body>
</html>