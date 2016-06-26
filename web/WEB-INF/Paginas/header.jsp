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
            <nav class="grey darken-3" role="navigation">
                <!-- BARRA SUPERIOR-->
                <div class="nav-wrapper container">
                    <!-- Botão de Menu que irá aparecer quando a tela for pequena, para abrir o Menu que estará oculto -->
                    <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
                    <a id="logo-container" href="/gerenciadorMinacioLog" class="brand-logo"><img src="img/minaciolog_texto.png" alt="Logotipo Minacio Log"></a>
                </div>
                <!--MENU DIAGONAL NA ESQUERDA -->
                <!-- This content will be: 3-columns-wide on large screens, 4-columns-wide on medium screens, 12-columns-wide on small screens -->
                <ul id="slide-out" class="side-nav fixed">
                    <li class="logo off">
                        <a id="logo-container" href="/gerenciadorMinacioLog" class="brand-logo">
                            <img src="img/minaciolog.png" alt="Logotipo Minacio Log">
                        </a>
                    </li>
                    <li class="bold">
                        <a href="#" class="waves-effect waves-teal">
                            Sobre
                        </a>
                    </li>
                    <li class="bold">
                        <a href="#" class="waves-effect waves-teal">
                            DashBoard
                        </a>
                    </li>
                    <li class="bold">
                        <a href="#" class="waves-effect waves-teal">
                            Operação
                        </a>
                    </li>
                    <li class="bold">
                        <a href="Executa?logicaDeNegocio=ClienteServlet&tarefa=consultarLista" class="waves-effect waves-teal">
                            Clientes
                        </a>
                    </li>
                    <li class="no-padding">
                        <ul class="collapsible collapsible-accordion">
                            <li class="no-padding bold active">
                                <a class="collapsible-header waves-effect waves-teal">
                                    Cadastros
                                </a>
                                <div class="collapsible-body" style="display: block;">
                                    <ul>
                                        <!--Para deixar algum item ativado, adicionar class="active" -->
                                        <li><a href="Executa?logicaDeNegocio=TipoClienteServlet&tarefa=consultarLista">Tipo de Cliente</a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoContatoServlet&tarefa=consultarLista">Tipo de Contato</a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoEnderecoServlet&tarefa=consultarLista">Tipo de Endereço</a></li>
                                        <li><a href="Executa?logicaDeNegocio=TipoFaturamentoServlet&tarefa=consultarLista">Tipo de Faturamento</a></li>
                                        <li><a href="Executa?logicaDeNegocio=CidadeServlet&tarefa=consultarLista">Cidade</a></li>
                                        <li><a href="Executa?logicaDeNegocio=UFServlet&tarefa=consultarLista">UF</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </header>