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
            <!-- ÁREA DO USUÁRIO -->
            <ul id="dropdown1" class="dropdown-content">
                <li class="divider"></li>
                <li><a href="Executa?logicaDeNegocio=Logout"><i class="material-icons left">close</i>Sair</a></li>
            </ul>
            <!-- BARRA SUPERIOR-->
            <nav class="grey darken-3" role="navigation">
                <!-- BARRA SUPERIOR-->
                <div class="nav-wrapper container">
                    <!-- Botão de Menu que irá aparecer quando a tela for pequena, para abrir o Menu que estará oculto -->
                    <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
                    <a id="logo-container" href="/gerenciadorMinacioLog" class="brand-logo"><img src="img/minaciolog_texto.png" alt="Logotipo Minacio Log"></a>
                    <c:if test="${not empty usuarioLogado}">
                        <ul class="right">
                            <!-- Dropdown Trigger -->
                            <li>
                                <a class="dropdown-button" href="#!" data-activates="dropdown1">
                                    <b class="hide-on-med-and-down">Olá ${usuarioLogado.nome}</b><i class="material-icons right">account_circle</i><i class="material-icons right hide-on-med-and-down">arrow_drop_down</i>
                                </a>
                            </li>
                        </ul>
                    </c:if>
                </div>
                <!--MENU DIAGONAL NA ESQUERDA -->
                <!-- This content will be: 3-columns-wide on large screens, 4-columns-wide on medium screens, 12-columns-wide on small screens -->
                <ul id="slide-out" class="side-nav fixed">
                    <li class="logo off">
                        <a id="logo-container" href="/gerenciadorMinacioLog" class="brand-logo">
                            <img src="img/minaciolog.png" alt="Logotipo Minacio Log">
                        </a>
                    </li>
                    <li id="li-sobre" class="bold">
                        <a href="#" class="waves-effect waves-light">
                            <b>Sobre</b>
                        </a>
                    </li>
                    <li id="li-dashboard" class="bold">
                        <a href="#" class="waves-effect waves-light">
                            <b>DashBoard</b>
                        </a>
                    </li>
                    <li class="bold">
                        <a href="Executa?logicaDeNegocio=JobServlet&tarefa=consultarLista" class="waves-effect waves-teal">
                            <b>Operação</b>
                        </a>
                    </li>
                    <li id="li-clientes" class="bold">
                        <a href="Executa?logicaDeNegocio=ClienteServlet&tarefa=consultarLista" class="waves-effect waves-light">
                            <b>Clientes</b>
                        </a>
                    </li>
                    <li class="no-padding">
                        <ul class="collapsible collapsible-accordion">
                            <li class="no-padding bold active">
                                <a class="collapsible-header waves-effect waves-light">
                                    <b>Cadastros</b>
                                </a>
                                <div class="collapsible-body" style="display: block;">
                                    <ul>
                                        <!--Para deixar algum item ativado, adicionar class="active" -->
                                        <li><a href="Executa?logicaDeNegocio=TipoClienteServlet&tarefa=consultarLista"><b>Tipo de Cliente</b></a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoContatoServlet&tarefa=consultarLista"><b>Tipo de Contato</b></a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoEnderecoServlet&tarefa=consultarLista"><b>Tipo de Endereço</b></a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoFaturamentoServlet&tarefa=consultarLista"><b>Tipo de Faturamento</b></a></li>
                                        <li><a href="Executa?logicaDeNegocio=CidadeServlet&tarefa=consultarLista"><b>Cidade</b></a></li>
                                        <li><a href="Executa?logicaDeNegocio=UFServlet&tarefa=consultarLista"><b>UF</b></a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </li>

                    <c:if test="${not empty usuarioLogado}">
                        <li id="li-clientes" class="bold">
                            <a href="Executa?logicaDeNegocio=Logout" class="waves-effect waves-light">
                                Sair
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </header>
