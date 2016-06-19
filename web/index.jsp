<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>App Minacio Log</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
	<header>
	<!-- BARRA SUPERIOR-->
	  <nav class="light-blue lighten-1" role="navigation">
	    <div class="nav-wrapper container">
	    	<!-- Botão de Menu que irá aparecer quando a tela for pequena, para abrir o Menu que estará oculto -->
			<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
	    	<a id="logo-container" href="#" class="brand-logo">Minacio Log</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="#"><!--Usuário--></a></li>
	        </ul>
	    </div>
		<!--MENU DIAGONAL NA ESQUERDA -->
		<!-- This content will be: 3-columns-wide on large screens, 4-columns-wide on medium screens, 12-columns-wide on small screens -->
		<ul id="slide-out" class="side-nav fixed">
			<li class="logo off">
				<a id="logo-container" href="#!" class="brand-logo">
					<object id="front-page-logo" type="image/svg+xml" data="res/materialize.svg">
						Your browser does not support SVG
					</object>
				</a>
			</li>
			<li class="bold"><a href="#" class="waves-effect waves-teal">Sobre</a></li>
			<li class="bold"><a href="#" class="waves-effect waves-teal">DashBoard</a></li>
			<li class="bold"><a href="#" class="waves-effect waves-teal">Operação</a></li>
			<li class="bold"><a href="#" class="waves-effect waves-teal">Clientes</a></li>
			<li class="no-padding">
			      <ul class="collapsible collapsible-accordion">
					<li class="bold active"><a class="collapsible-header waves-effect waves-teal"><i class="tiny material-icons">face</i>Cadastros</a>
						<div class="collapsible-body" style="display: block;">
							<ul>
								<!--Para deixar algum item ativado, adicionar class="active" -->
								<li><a href="#">Tipo de Cliente</a></li>
								<li><a href="#">Tipo de Contato</a></li>
								<li><a href="#">Tipo de Endereços</a></li>
								<li><a href="#">Cidade</a></li>
								<li><a href="#">UF</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</li>
		</ul>
	  </nav>
	</header>
	<main>
		 <div class="row">
			<!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
			<div class="col s9 m8 l9"> <!-- Note a soma das colunas sempre serão 12 -->
				<!-- Teal page content
				
				      This content will be:
				  9-columns-wide on large screens,
				  8-columns-wide on medium screens,
				  12-columns-wide on small screens  -->
				<!-- CONTEÚDO INICIAL DE APRESENTAÇÃO DO SITE E BOTÃO ENTRAR -->
				<!-- 
				<div class="section no-pad-bot" id="index-banner">
					<div class="container">
						<br><br>
						<h1 class="header center orange-text">Gerenciador Minacio Log</h1>
						<div class="row center">
						<h5 class="header col s12 light">Sistema de gerenciamento de clientes e controle financeiros da Minacio Log.</h5>
						</div>
						<div class="row center">
							<form action="executa" method="POST">
								<input type="hidden" name="tarefa" value="Logout" />
								<button class="btn-large waves-effect waves-light" type="submit" name="action" value="login">
									Entrar<i class="material-icons right">send</i>
								</button>
							</form>
						</div>
					</div>
				</div>
				 -->
				
				<!-- CONTEÚDO DE CADA PÁGINA -->
				<div class="col s12 m8 l9">
					<div id="introduction" class="section scrollspy">
						<div class="divider"></div>
						<h2 class="header">Titulo Sessão 1</h2>
						<p>Texto de Descrição da Sessão 1</p>
						<h4>Sub-Titulo da Sessão 1</h4>
						<div class="section">
							<h5>Section 1</h5>
							<br><br><br>
							<p>COLOQUE O CONTEÚDO 1 AQUI</p>
                                                        
                                                        <div id="Formulario_teste">
                                                            
                                                            <form method="POST" action="Executa">
                                                                <!--Nome das Classes que deverão ser informadas ocultas-->
                                                                <input type="hidden" name="logicaDeNegocio" value="TipoClienteServlet">
                                                                <input type="hidden" name="tarefa" value="incluir">
                                                                
                                                                <div class="form-group">
                                                                    <label>Descrição:</label> 
                                                                    <input type="text" class="form-control" placeholder="Insira o texto aqui" name="descricao" value="" />
                                                                </div>
                                                                
                                                                <button type="submit" class="btn btn-default" value="Cadastrar">Cadastrar</button>
                                                                
                                                                
                                                                
                                                            </form>
                                                        </div>
                                                        
							<br><br><br>
						</div>
					</div>
					
					<div id="structure" class="section scrollspy">
					<div class="divider"></div>
					<h2 class="header">Titulo Sessão 2</h2>
					<p>Texto de Descrição da Sessão 2</p>
					<h4>Sub-Titulo da Sessão 2</h4>
					<div class="section">
					<h5>Section 2</h5>
					<br><br><br>
					<p>COLOQUE O CONTEÚDO 2 AQUI</p>
					<br><br><br>
					</div>
					</div>
					
					<div id="initialization" class="section scrollspy">
					<div class="divider"></div>
					<h2 class="header">Titulo Sessão 3</h2>
					<p>Texto de Descrição da Sessão 3</p>
					<h4>Sub-Titulo da Sessão 3</h4>
					
					<div class="section">
					<h5>Section 3</h5>
					<br><br><br>
					<p>COLOQUE O CONTEÚDO 3 AQUI</p>
					<br><br><br>
					</div>
					</div>
				</div>
				<div class="col hide-on-small-only m3 l2">
					<div class="tabs-wrapper" style="top: 0px;">
						<ul class="section table-of-contents">
						<li><a href="#introduction">Section 1</a></li>
						<li><a href="#structure">Section 2</a></li>
						<li><a href="#initialization">Section 2</a></li>
						</ul>
					</div>
				</div>		
			</div>
	
	    </div>
	</main>
	<!-- RODAPÉ DA PÁGINA -->
	<footer class="page-footer orange">
		<div class="container">
			<div class="row">
				<div class="col l6 s12">
					<h5 class="white-text">Company Bio</h5>
					<p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>
				</div>
				<div class="col l3 s12">
				</div>
				<div class="col l3 s12">
					<h5 class="white-text">Connect</h5>
					<ul>
						<li><a class="white-text" href="#!">Link 1</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">
				Elaborado por <a class="orange-text text-lighten-3" href="#">Flávio Sampaio</a> e <a class="orange-text text-lighten-3" href="#">Gabriel Estavaringo</a>
			</div>
		</div>
	</footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
</html>

