<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>
<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.TipoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/Paginas/header.jsp" %>
<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <h1 class="header center-on-small-only">Cliente</h1>
                    <h4 class="light red-text text-lighten-4 center-on-small-only">Gerenciador de Clientes da Minacio Log</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
        <div class="col s9 m8 l9">

            <!-- CONTEÚDO DA PÁGINA -->
            <div class="col s12 m8 l9">
                <div id="introduction" class="section scrollspy">
                    <div class="divider"></div>
                    <h2 class="header">Titulo Sessão 1</h2>
                    <p>Texto de Descrição da Sessão 1</p>
                    <h4>Sub-Titulo da Sessão 1</h4>
                    <div class="section">
                        <h5>Lista com todos os clientes</h5>
                        <br><br><br>
                        <p>CONSULTAR CLIENTE EM CONSTRUÇÃO</p>
                    </div>
                    <br><br><br>
                </div>
            </div>
            <!-- ABRE MODAL DE CADASTRO DE CLIENTE -->
            <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
                <a id="BotaoAdicionar" class="modal-trigger btn-floating btn-large red" href="#modal1">
                    <i class="large material-icons">add</i>
                </a>
            </div>
            <!-- ESTRUTURA DA MODAL -->
            <div id="modal1" class="modal modal-fixed-footer">
                <form method="POST" action="Executa">
                    <div class="modal-content">
                        <h4>Cadastrar Cliente</h4>
                        <p>Preencha os dados abaixo:</p>

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
                                    <option value="${tipoFaturamento.codigo}" >${tipoFaturamento.descricao}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default" value="Cadastrar">Cadastrar</button>
                        <a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>	
    </div>
    <!-- ATALHOS DAS SESSÕES DA PÁGINA -->
    <div class="col hide-on-small-only m3 l2">
        <div class="tabs-wrapper" style="top: 0px;">
            <ul class="section table-of-contents">
                <li><a href="#Lista">Todos os cadastros</a></li>
                <li class="ocultarElemento"><a href="#Incluir">Incluir</a></li>
                <li class="ocultarElemento"><a href="#Alterar">Alterar</a></li>
            </ul>
        </div>
    </div>
</main>
<%@ include file="/WEB-INF/Paginas/footer.jsp" %>