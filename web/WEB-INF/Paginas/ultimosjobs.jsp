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
                <h5 class="light deep-orange-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">stars</i>${Cliente.descricaoTipoCliente}
                </h5>
            </div>
            <div class="col s12 m3">
                <h5 class="light deep-orange-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">shopping_cart</i>${Cliente.descricaoFaturamento}
                </h5>
            </div>
            <div class="col s12 m3">
                <h5 class="light deep-orange-text text-lighten-4 center-on-small-only">
                    <i class="small material-icons left" style="position: relative;bottom: 4px;">today</i>${Cliente.dataInclusao}
                </h5>
            </div>
        </div>
    </div>
    <div class="row" style="margin: 10px;">
        <div class="col s12 m12 l12 center-on-small-only">
            <a href="Executa?logicaDeNegocio=AgendaServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">contact_phone</i>Agenda</a>
            <a href="Executa?logicaDeNegocio=ProspeccaoServlet&tarefa=consultarLista&codigoCliente=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">settings_phone</i>Registrar</a>
            <a href="Executa?logicaDeNegocio=UltimosJobsServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large red" style="width: 222px"><i class="material-icons left">restore</i>Últ. Trabalhos</a>
            <a href="Executa?logicaDeNegocio=EnderecoClienteServlet&tarefa=consultar&codigo=${Cliente.codigo}" class="waves-effect waves-light btn-large cyan darken-2" style="width: 222px"><i class="material-icons left">location_on</i>Endereços</a>
        </div>
    </div>           
    <div class="row">
        <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
        <div class="col s9 m8 l10">
            <!-- CONTEÚDO DE CADA PÁGINA -->
            <div class="col s12 m12 l12">
                <div id="introduction" class="section scrollspy">
                    <h4 class="header">Últimos Trabalhos</h4>
                    <div class="section">
                        <table class="responsive-table">
                            <thead>
                                <tr>
                                    <th data-field="cliente">Cliente</th>
                                    <th data-field="ecalc">JOB</th>
                                    <th data-field="os">O.S.</th>
                                    <th data-field="titulo">Titulo</th>
                                    <th data-field="dataEntrada">Entrada</th>
                                    <th data-field="dataSaida">Saida</th>
                                    <th data-field="valor">Valor</th>
                                    <th data-field="comissao">Comissão à Receber</th>
                                    <th data-field="comissaoAgencia">Comissão à Pagar Agência</th>
                                    <th data-field="comissaoProdutor">Comissão à Pagar Produtor</th>
                                    <th data-field="observacao">Observações</th>
                                    <th data-field="acoes">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaJob}">
                                    <c:forEach var="job" items="${listaJob}">
                                        <tr>
                                            <td id="cliente-${job.codigo}">${job.cliente}</td>
                                            <td id="ecalc-${job.codigo}">${job.codigoECalc}</td>
                                            <td id="os-${job.codigo}">${job.codigoOS}</td>
                                            <td id="descricao-${job.codigo}"> ${job.titulo}</td>
                                            <td id="data-entrada-${job.codigo}"><fmt:formatDate value="${job.dataEntrada}" pattern="dd/MM/yyyy"/></td>
                                            <td id="data-saida-${job.codigo}"><fmt:formatDate value="${job.dataSaida}" pattern="dd/MM/yyyy"/></td>
                                            <td id="valor-${job.codigo}"> <fmt:formatNumber pattern="R$ #0.00" value="${job.valor}"/> </td>
                                            <td id="bv-${job.codigo}"> <fmt:formatNumber pattern="R$ #0.00" value="${job.valor * job.bv / 100}"/></td>
                                            <td id="bv-agencia-${job.codigo}"> <fmt:formatNumber pattern="R$ #0.00" value="${job.valor * job.bvAgencia / 100}"/></td>
                                            <td id="bv-produtor-${job.codigo}"> <fmt:formatNumber pattern="R$ #0.00" value="${job.valor * job.bvProdutor / 100}"/></td>
                                            <td id="observacao-${job.codigo}" > ${job.observacao}</td>
                                            <td>
                                                <!-- Dropdown Trigger -->
                                                <a class='dropdown-button btn-floating grey darken-2' href='#' data-constrainwidth="false" data-activates='dropdown${job.codigo}'><i class="material-icons">menu</i></a>

                                                <!-- Dropdown Structure -->
                                                <ul id='dropdown${job.codigo}' class='dropdown-content'>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-alterar-job grey-text text-darken-4" id="${job.codigo}"><i class="material-icons yellow-text text-darken-4">edit</i>Alterar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-excluir grey-text text-darken-4" id="${job.codigo}"><i class="material-icons deep-orange-text">delete</i>Excluir</a></li>
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
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default deep-orange" value="Alterar">Alterar</button>
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
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default deep-orange" value="Alterar">Confirmar Exclusão</button>
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
                        <h4>Incluir Cliente</h4>
                        <p>Insira os dados do novo Cliente:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="ClienteServlet">
                        <input type="hidden" name="tarefa" value="incluir">

                        <div class="input-field">
                            <i class="material-icons prefix">account_circle</i>
                            <label for="descricao-incluir">Nome</label>
                            <input id="descricao-incluir" type="text" class="validate" name="descricao" value="" />
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
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default deep-orange" value="Cadastrar">Cadastrar</button>
                        <a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancelar</a>
                    </div>
                </form>
            </div>		
        </div>

    </div>
</main>
<%@ include file="footer.jsp" %>
