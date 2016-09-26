<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>
<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <h1 class="header center-on-small-only">
                        <i class="large material-icons" style="position: relative;top: 15px;">store</i>${Cliente.nome}</div>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col s12 m3">
                <h5 class="light cyan-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">stars</i>${Cliente.descricaoTipoCliente}
                </h5>
            </div>
            <div class="col s12 m3">
                <h5 class="light cyan-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">shopping_cart</i>${Cliente.descricaoFaturamento}
                </h5>
            </div>
            <div class="col s12 m3">
                <h5 class="light cyan-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">today</i>${Cliente.dataInclusao}
                </h5>
            </div>
        </div>
    </div>
    <div class="row" style="margin: 10px;">
        <div class="col s12 m12 l12 center-on-small-only">
            <a href="Executa?logicaDeNegocio=AgendaServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">contact_phone</i>Agenda</a>
            <a href="Executa?logicaDeNegocio=ProspeccaoServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large red" style="width: 222px"><i class="material-icons left">settings_phone</i>Registrar</a>
            <a href="Executa?logicaDeNegocio=UltimosJobsServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">restore</i>Últ. Trabalhos</a>
            <a href="Executa?logicaDeNegocio=EnderecoClienteServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">location_on</i>Endereços</a>
        </div>
    </div>           
    <div class="row">
        <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
        <div class="col s9 m8 l10">
            <!-- CONTEÚDO DE CADA PÁGINA -->
            <div class="col s12 m12 l12">
                <div id="introduction" class="section scrollspy">
                    <h4 class="header">Contatos Efetuados</h4>
                    <div class="section">
                        <table class="responsive-table">
                            <thead>
                                <tr>
                                    <th data-field="codigo">Código</th>
                                    <th data-field="cliente">Cliente</th>
                                    <th data-field="nome-contato">Nome</th>
                                    <th data-field="descricao">Descrição</th>
                                    <th data-field="data">Data</th>
                                    <th data-field="acao">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaProspeccao}">
                                    <c:forEach var="prospeccao" items="${listaProspeccao}">
                                        <tr>
                                            <th scope="row">${prospeccao.codigo}</th>
                                            <td id="cliente-${prospeccao.codigo}"> ${Cliente.nome}</td>
                                            <td id="nome-contato${prospeccao.codigo}"> ${prospeccao.nome}</td>
                                            <td id="descricao-${prospeccao.codigo}"> ${prospeccao.descricao}</td>
                                            <td id="data-${prospeccao.codigo}"><fmt:formatDate value="${prospeccao.data}" pattern="dd/MM/yyyy"/></td>
                                            <td>
                                                <!-- Dropdown Trigger -->
                                                <a class='dropdown-button btn-floating cyan darken-2' href='#' data-constrainwidth="false" data-activates='dropdown${prospeccao.codigo}'><i class="material-icons">more_horiz</i></a>

                                                <!-- Dropdown Structure -->
                                                <ul id='dropdown${prospeccao.codigo}' class='dropdown-content'>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-alterar grey-text text-darken-4" id="${prospeccao.codigo}"><i class="material-icons yellow-text text-darken-4">edit</i>Alterar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-excluir grey-text text-darken-4" id="${prospeccao.codigo}"><i class="material-icons red-text">delete</i>Excluir</a></li>
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
                        <h4>Alterar Cliente</h4>
                        <p>Altere o Cliente selecionado:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="TipoClienteServlet">
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
                        <h4>Excluir Cliente</h4>
                        <p>Confirme a exclusão do Cliente selecionado:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="TipoClienteServlet">
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
                <a class="botao-incluir-prospeccao btn-floating btn-large red" id="${prospeccao.codigo}">
                    <i class="large material-icons">add</i>
                </a>
            </div>
            <!-- ESTRUTURA DA MODAL INCLUIR -->
            <div id="modal-incluir" class="modal modal-fixed-footer">
                <form method="POST" action="Executa">
                    <div class="modal-content">
                        <h4>Registrar Contato</h4>
                        <p>Insira os dados do contato:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="ClienteServlet">
                        <input type="hidden" name="tarefa" value="incluir">

                        <div class="input-field">
                            <i class="material-icons prefix">account_circle</i>
                            <label for="cliente-incluir">Nome</label>
                            <input id="descricao-incluir" type="text" class="validate" name="cliente" value="" />
                        </div>

                        <div class="input-field">
                            
                        </div>

                        <div class="form-group">
                            
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
</main>
<%@ include file="footer.jsp" %>