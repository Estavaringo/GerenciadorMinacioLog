<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>

<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.TipoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <div class="container">
                <a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only">
                    <i class="material-icons">menu</i>
                </a>
            </div>
            <!--MENU DIAGONAL NA ESQUERDA -->
            <!-- This content will be: 3-columns-wide on large screens, 4-columns-wide on medium screens, 12-columns-wide on small screens -->
            <ul id="slide-out" class="side-nav fixed">
                <li class="logo off">
                    <a id="logo-container" href="#!" class="brand-logo"><img src="img/minaciolog.png" alt="Logotipo Minacio Log"></a>
                </li>
                <li class="bold">
                    <a href="#" class="waves-effect waves-teal">Sobre</a>
                </li>
                <li class="bold">
                    <a href="#" class="waves-effect waves-teal">DashBoard</a>
                </li>
                <li class="bold">
                    <a href="#" class="waves-effect waves-teal">Operação</a>
                </li>
                <li class="bold"><a href="#" class="waves-effect waves-teal">Clientes</a>
                </li>
                <li class="no-padding">
                    <ul class="collapsible collapsible-accordion">
                        <li class="no-padding bold active">
                            <a class="collapsible-header waves-effect waves-teal"><i class="material-icons" style="font-size: 24px">add</i>Cadastros</a>
                            <div class="collapsible-body" style="display: block;">
                                <ul>
                                    <!--Para deixar algum item ativado, adicionar class="active" -->
                                    <li class="active"><a href="Executa?logicaDeNegocio=ClienteServlet&tarefa=cadastrarCliente">Clientes</a></li>
                                    <li><a href="Executa?logicaDeNegocio=TipoClienteServlet&tarefa=consultarLista">Tipo de Cliente</a></li>
                                    <li><a href="Executa?logicaDeNegocio=TipoContatoServlet&tarefa=consultarLista">Tipo de Contato</a></li>
                                    <li><a href="Executa?logicaDeNegocio=TipoEnderecoServlet&tarefa=consultarLista">Tipo de Endereços</a></li>
                                    <li><a href="Executa?logicaDeNegocio=TipoFaturamentoServlet&tarefa=consultarLista">Tipo de Faturamento</a></li>
                                    <li><a href="Executa?logicaDeNegocio=CidadeServlet&tarefa=consultarLista">Cidade</a></li>
                                    <li><a href="Executa?logicaDeNegocio=UFServlet&tarefa=consultarLista">UF</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </header>
        <main>
            <div class="section" id="index-banner">
                <div class="container">
                    <div class="row">
                        <div class="col s12 m9">
                            <h1 class="header center-on-small-only">Cadastrar Cliente</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
                <div class="col s9 m8 l9"> <!-- Note a soma das colunas sempre serão 12 -->
                    <!-- Teal page content
                    
                          This content will be:
                      9-columns-wide on large screens,
                      8-columns-wide on medium screens,
                      12-columns-wide on small screens  -->

                    <!-- CONTEÚDO DE CADA PÁGINA -->
                    <div class="col s12 m8 l9">
                        <div id="introduction" class="section scrollspy">
                            <div class="divider"></div>
                            <div class="section">

                                <h5>Cadastrar Cliente</h5>
                                <form method="POST" action="Executa">
                                    <!--Nome das Classes que deverão ser informadas ocultas-->
                                    <input type="hidden" name="logicaDeNegocio" value="ClienteServlet">
                                    <input type="hidden" name="tarefa" value="incluir">


                                    <div class="input-field">
                                        <i class="material-icons prefix">account_circle</i>
                                        <label for="icon_prefix">Nome</label>
                                        <input id="icon_prefix" type="text" class="validate" name="descricao" value="" />
                                    </div>
                                    
                                    <div class="input-field">
                                        <select name="tipoCliente">
                                            <option value="" disabled selected>Escolha o Tipo de Cliente</option>
                                            <c:forEach var="tipoCliente" items="${listaTipoCliente}">
                                                <option value="${tipoCliente.codigo}" class="form-control" >${tipoCliente.descricao}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group">
                                        <select name="tipoFaturamento">
                                            <option value="" disabled selected>Escolha o Tipo de Faturamento</option>
                                            <c:forEach var="tipoFaturamento" items="${listaTipoFaturamento}">
                                                <option value="${tipoFaturamento.codigo}" >${tipoFaturamento.primeira}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-default" value="Cadastrar">Cadastrar</button>
                                    
                                </form>

                            </div>
                        </div>
                    </div>
                    <!-- ATALHOS DAS SESSÕES DA PÁGINA -->
                    <div class="col hide-on-small-only m3 l2">
                        <div class="tabs-wrapper" style="top: 0px;">
                            <ul class="section table-of-contents">
                                <li><a href="#Lista">Tipos de Clientes</a></li>
                                <li class="ocultarElemento"><a href="#Incluir">Incluir</a></li>
                                <li class="ocultarElemento"><a href="#Alterar">Alterar</a></li>
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
        <script src="js/main.js"></script>

    </body>
</html>
