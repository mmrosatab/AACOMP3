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
				<div>
					<select class="texto" name="opcoes">
					<% ArrayList<SolicitacaoMuseuMD> s  = new ArrayList<SolicitacaoMuseuMD>();
					   s = SolicitacaoMuseuMD.listarSolicitacoes();
					   String nome;
					   String data;
					   String [] semEspaco;
					   for(SolicitacaoMuseuMD sol:s){
						   nome  = sol.getNome();
						   data  = sol.getData();
						   data = data + "-" +nome.replace(" ", ".");
					%>				
					    <option value= <%= data%> > <%=nome%> </option>
					<%}%>
					</select>
					<input class='sub' type="submit" name="cmd" value="Ok">
				</div>
			</form>
			<form action="solicitarCriacaoMuseu" method="post">
			
			<% 	   String meu_nome 		= "";
				   String minhaData 	= "";
				   String cidade 		= "";
				   String estado		= "";
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
				   if(request.getAttribute("estado") != null)
				   {
					   estado = request.getAttribute("estado").toString();
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
				
				<b><label>Nome:</label></b>
				<div class="texto"> <%=meu_nome%> </div>
				<b><label>Data de Criação:</label></b> 
				<div class="texto"> <%=minhaData %> </div>
				<b><label>Cidade:</label></b>
				<div class="texto"> <%=cidade%> </div>
				<b><label>Estado:</label></b>
				<div class="texto"> <%=estado%> </div>
				<b><label>CPF gestor:</label></b>
				<div class="texto"> <%=cpf%> </div>
				<b><label>Nome do gestor:</label></b>
				<div class="texto"> <%=nomeG%> </div>
				<input class='sub' type="submit" name="cmd" value="Criar Museu">
			</form>
		</section>
	</body>
</html>