<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>

<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.TipoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <h1 class="header center-on-small-only">Tipo de Cliente</h1>
                    <h4 class="light red-text text-lighten-4 center-on-small-only">Cadastro de Tipos de Clientes.</h4>
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
                    <h4 class="header">Tipos de Clientes cadastrados</h4>
                    <div class="section">
                        <table class="highlight">
                            <thead>
                                <tr>
                                    <th data-field="codigo">Código</th>
                                    <th data-field="descricao">Tipo de Cliente</th>
                                    <th data-field="descricao">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaTipoCliente}">
                                    <c:forEach var="tipoCliente" items="${listaTipoCliente}">
                                        <tr>
                                            <th scope="row">${tipoCliente.codigo}</th>
                                            <td> ${tipoCliente.descricao}</td>
                                            <td>
                                                <div style="display: inline">
                                                    <a class="btn-floating btn-large orange">
                                                        <i class="large material-icons" onclick="abrirFormularioEdicao(${tipoCliente.codigo})">mode_edit</i>
                                                    </a>
                                                    <form method="POST" action="Executa">
                                                        <input type="hidden" name="logicaDeNegocio" value="TipoClienteServlet">
                                                        <input type="hidden" name="tarefa" value="remover">
                                                        <input type="hidden" name="codigo" value=${tipoCliente.codigo}>
                                                        <button type="submit" class="btn-floating btn-large waves-effect waves-light red" value="Remover"><i class="material-icons" style="font-size: 24px">delete</i></button>
                                                    </form>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                        <br><br><br>
                    </div>
                </div>

                <div id="SessaoIncluir" class="section scrollspy ocultarElemento">
                    <div class="divider"></div>
                    <h4>Inclusão de novo tipo de cliente</h4>
                    <div class="section">
                        <h5>Novo Tipo de Cliente</h5>
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
                </div>
                <div id="SessaoAlterar" class="section scrollspy ocultarElemento">
                    <div class="divider"></div>
                    <h4>Alterar Tipo de Cliente</h4>
                    <div class="section">
                        <h5>Novo Tipo de Cliente</h5>
                        <form method="POST" action="Executa">
                            <!--Nome das Classes que deverão ser informadas ocultas-->
                            <input type="hidden" name="logicaDeNegocio" value="TipoClienteServlet">
                            <input type="hidden" name="tarefa" value="alterar">

                            <div class="form-group">
                                <label>Descrição:</label>
                                <input type="text" class="form-control" placeholder="Insira o texto aqui" name="descricao" value="" />
                            </div>

                            <button type="submit" class="btn btn-default" value="Cadastrar">Cadastrar</button>
                        </form>
                    </div>
                </div>
                <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
                    <a id="BotaoAdicionar" class="btn-floating btn-large red">
                        <i class="large material-icons">add</i>
                    </a>
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
        </div>

    </div>
</main>
<%@ include file="footer.jsp" %>