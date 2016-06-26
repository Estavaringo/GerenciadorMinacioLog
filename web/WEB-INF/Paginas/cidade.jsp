<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>

<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <h1 class="header center-on-small-only">Cidade</h1>
                    <h4 class="light red-text text-lighten-4 center-on-small-only">Cadastro de Cidades</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
        <div class="col s9 m8 l9">
            <!-- CONTEÚDO DE CADA PÁGINA -->
            <div class="col s12 m8 l9">
                <div id="introduction" class="section scrollspy">
                    <div class="divider"></div>
                    <h4 class="header">Cidades cadastradas</h4>
                    <div class="section">
                        <table id="table" class="highlight">
                            <thead>
                                <tr>
                                    <th data-field="codigo">Código</th>
                                    <th data-field="descricao">UF</th>
                                    <th data-field="descricao">Cidade</th>
                                    <th data-field="descricao">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaCidade}">
                                    <c:forEach var="cidade" items="${listaCidade}">
                                        <tr>
                                            <th scope="row">${cidade.codigo}</th>
                                            <td> ${cidade.codigoUF}</td>
                                            <td id="descricao-${cidade.codigo}"> ${cidade.descricao}</td>
                                            <td>
                                                <!-- Dropdown Trigger -->
                                                <a class='dropdown-button btn-floating grey darken-2' href='#' data-constrainwidth="false" data-activates='dropdown${cidade.codigo}'><i class="material-icons">menu</i></a>

                                                <!-- Dropdown Structure -->
                                                <ul id='dropdown${cidade.codigo}' class='dropdown-content'>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-alterar grey-text text-darken-4" id="${cidade.codigo}"><i class="material-icons yellow-text text-darken-4">edit</i>Alterar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-excluir grey-text text-darken-4" id="${cidade.codigo}"><i class="material-icons red-text">delete</i>Excluir</a></li>
                                                </ul>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                        <br><br><br>
                    </div>
                </div>
            </div>
            <!-- ESTRUTURA DA MODAL ALTERAR -->
            <div id="modal-alterar" class="modal modal-fixed-footer">
                <form method="POST" action="Executa">
                    <div class="modal-content">
                        <h4>Alterar Cidade</h4>
                        <p>Altere a Cidade selecionada:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="CidadeServlet">
                        <input type="hidden" name="tarefa" value="alterar">
                        <input type="hidden" name="codigo" id="codigo-alterar">

                        <div class="input-field">
                            <i class="material-icons prefix">description</i>
                            <input id="descricao-alterar" type="text" name="descricao" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default" value="Alterar">Alterar</button>
                        <a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancelar</a>
                    </div>
                </form>
            </div>
            <!-- ESTRUTURA DA MODAL EXCLUIR -->
            <div id="modal-excluir" class="modal modal-fixed-footer">
                <form method="POST" action="Executa">
                    <div class="modal-content">
                        <h4>Excluir Cidade</h4>
                        <p>Confirme a exclusão da Cidade selecionado:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="CidadeServlet">
                        <input type="hidden" name="tarefa" value="remover">
                        <input type="hidden" name="codigo" id="codigo-excluir">

                        <div class="input-field">
                            <i class="material-icons prefix">description</i>
                            <input disabled class="grey-text text-darken-4" id="descricao-excluir" type="text" name="descricao" value="" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default" value="Alterar">Confirmar Exclusão</button>
                        <a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancelar</a>
                    </div>
                </form>
            </div>
            <!-- ABRE MODAL INCLUIR -->
            <div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
                <a class="modal-trigger btn-floating btn-large red" href="#modal-incluir">
                    <i class="large material-icons">add</i>
                </a>
            </div>
            <!-- ESTRUTURA DA MODAL INCLUIR -->
            <div id="modal-incluir" class="modal modal-fixed-footer">
                <form method="POST" action="Executa">
                    <div class="modal-content">
                        <h4>Incluir Cidade</h4>
                        <p>Insira abaixo o novo Cidade:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="CidadeServlet">
                        <input type="hidden" name="tarefa" value="incluir">

                        <div class="input-field">
                            <i class="material-icons prefix">description</i>
                            <input id="descricao-incluir" placeholder="Insira o texto aqui" type="text" name="descricao" value="" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default" value="Incluir">Incluir</button>
                        <a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancelar</a>
                    </div>
                </form>
            </div>
            <!-- ATALHOS DAS SESSÕES DA PÁGINA -->
            <div class="col hide-on-small-only m3 l2">
                <div class="tabs-wrapper" style="top: 0px;">
                    <ul class="section table-of-contents">
                        <li><a href="#introduction">Topo da Página</a></li>
                    </ul>
                </div>
            </div>		
        </div>

    </div>
</main>
<%@ include file="footer.jsp" %>