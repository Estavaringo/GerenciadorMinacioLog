<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>
<%@page import="java.util.Collection"%>
<%@page import="br.com.minaciolog.gerenciador.beans.Job"%>
<%@page import="br.com.minaciolog.gerenciador.beans.Cliente"%>
<%@page import="br.com.minaciolog.gerenciador.beans.TipoFaturamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <h1 class="header center-on-small-only">Job</h1>
                    <h4 class="light red-text text-lighten-4 center-on-small-only">Gerenciador de Jobs</h4>
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
                    <h4 class="header">Jobs cadastrados</h4>
                    <div class="section">
                        <table class="highlight">
                            <thead>
                                <tr>
                                    <th data-field="codigo">Cliente</th>
                                    <th data-field="codigo">JOB</th>
                                    <th data-field="descricao">O.S.</th>
                                    <th data-field="descricao">Titulo</th>
                                    <th data-field="descricao">Entrada</th>
                                    <th data-field="descricao">Saida</th>
                                    <th data-field="descricao">Vencimento 1</th>
                                    <th data-field="descricao">Vencimento 2</th>
                                    <th data-field="descricao">Vencimento 3</th>
                                    <th data-field="descricao">Comissão à Receber</th>
                                    <th data-field="descricao">Pagar Agência</th>
                                    <th data-field="descricao">Pagar Produtor</th>
                                    <th data-field="descricao">Observações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${not empty listaJob}">
                                    <c:forEach var="job" items="${listaJob}">
                                        <tr>
                                            <th id="cliente-${job.codigo}">${job.cliente}</th>
                                            <th id="codigo-ecalc-${job.codigo}">${job.codigoECalc}</th>
                                            <th id="codigo-os-${job.codigo}">${job.codigoOS}</th>
                                            <td id="titulo-${job.codigo}"> ${job.titulo}</td>
                                            <td id="data-entrada-${job.codigo}"> ${job.dataEntrada}</td>
                                            <td id="data-saida-${job.codigo}"> ${job.dataSaida}</td>
                                            <td id="vencimento-1-${job.codigo}">  </td>
                                            <td id="vencimento-2-${job.codigo}">  </td>
                                            <td id="vencimento-3-${job.codigo}">  </td>
                                            <td id="comissao-${job.codigo}"> ${job.valor * job.bv}</td>
                                            <td id="comissao-agencia-${job.codigo}"> ${job.valor * job.bvAgencia}</td>
                                            <td id="comissao-produtor-${job.codigo}"> ${job.valor * job.bvProdutor}</td>
                                            <td id="observacao-${job.codigo}"> ${job.observacao}</td>
                                            <td>
                                                <!-- Dropdown Trigger -->
                                                <a class='dropdown-button btn-floating grey darken-2' href='#' data-constrainwidth="false" data-activates='dropdown${job.codigo}'><i class="material-icons">menu</i></a>

                                                <!-- Dropdown Structure -->
                                                <ul id='dropdown${job.codigo}' class='dropdown-content'>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-alterar grey-text text-darken-4" id="${job.codigo}"><i class="material-icons yellow-text text-darken-4">edit</i>Alterar</a></li>
                                                    <li class="divider"></li>
                                                    <li><a class="botao-excluir grey-text text-darken-4" id="${job.codigo}"><i class="material-icons red-text">delete</i>Excluir</a></li>
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
                        <h4>Alterar Job</h4>
                        <p>Altere o Job selecionado:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="JobServlet">
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
                        <h4>Excluir Job</h4>
                        <p>Confirme a exclusão do Job selecionado:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="JobServlet">
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
                        <h4>Incluir Job</h4>
                        <p>Insira os dados do novo Job:</p>

                        <!--Nome das Classes que deverão ser informadas na requisição-->
                        <input type="hidden" name="logicaDeNegocio" value="JobServlet">
                        <input type="hidden" name="tarefa" value="incluir">

                        <div class="input-field">
                            <i class="material-icons prefix">note_add</i>
                            <label for="titulo-incluir">Titulo</label>
                            <input id="titulo-incluir" type="text" class="validate" name="titulo" value="" />
                        </div>

                        <div class="input-field">
                            <select id="select-cliente" name="codigoCliente">
                                <option value="" disabled selected>Escolha o Cliente</option>
                                <c:forEach var="cliente" items="${listaCliente}">
                                    <option value="${cliente.codigo}" id="${cliente.codigoFaturamento}" class="form-control" >${cliente.nome}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="input-field">
                            <select id="select-faturamento" name="tipoFaturamento">
                                <option value="" disabled selected>Escolha o Tipo de Faturamento</option>
                                <c:forEach var="tipoFaturamento" items="${listaTipoFaturamento}">
                                    <option value="${tipoFaturamento.codigo}"> ${tipoFaturamento.descricao}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="input-field">
                            <select id="select-parcelas" name="qtdParcelas">
                                <option value="" disabled selected>Escolha a Quantidade de Parcelas</option>
                                <option value="1" >1</option>
                                <option value="1" >2</option>
                                <option value="1" >3</option>
                            </select>
                        </div>

                        <div class="input-field">
                            <label for="ecalc-incluir">Código E-Calc</label>
                            <input id="ecalc-incluir" type="text" class="validate" name="codigoECalc" value="" />
                        </div>

                        <div class="input-field">
                            <label for="os-incluir">Código OS</label>
                            <input id="os-incluir" type="text" class="validate" name="codigoOS" value="" />
                        </div>

                        <div class="input-field">
                            <label for="datepicker">Data de Entrada</label>
                            <input type="date" class="datepicker" id="datepicker" name="dataEntrada">
                        </div>

                        <div class="input-field">
                            <label for="datepicker">Data de Saida</label>
                            <input type="date" id="datepicker" class="datepicker" name="dataSaida">
                        </div>


                        <div class="input-field">
                            <label for="valor-incluir">Valor</label>
                            <input id="valor-incluir" type="text" class="validate" name="valor" value="" />
                        </div>

                        <div class="input-field">
                            <label for="valor-incluir">BV</label>
                            <input id="valor-incluir" type="text" class="validate" name="bv" value="" />
                        </div>

                        <div class="input-field">
                            <label for="valor-incluir">BV Agência</label>
                            <input id="valor-incluir" type="text" class="validate" name="bvAgencia" value="" />
                        </div>

                        <div class="input-field">
                            <label for="valor-incluir">BV Produtor</label>
                            <input id="valor-incluir" type="text" class="validate" name="bvProdutor" value="" />
                        </div>

                        <!--    RANGE PARA INSERIR O BV
                                                <div class="input-field" >
                                                    <p>BV:</p>
                                                    <p class="range-field" style="width: 500px">
                                                        <input type="range" id="bv-range-incluir" min="0" name="bv" max="50" step="0.01" />
                                                    </p>
                                                </div>
                                                
                                                
                        
                                                <div class="input-field">
                                                    <p>BV Agencia</p>
                                                    <p class="range-field" style="width: 500px">
                                                        <input type="range" id="bv-agencia-range-incluir" min="0" name="bvAgencia" max="50" step="0.01" />
                                                    </p>
                                                </div>
                        
                                            <div class="input-field" >
                                                    <p>BV Produtor</p>
                                                    <p class="range-field" style="width: 500px">
                                                        <input type="range" id="bv-produtor-range-incluir" min="0" name="bvProdutor" max="50" step="0.01" />
                                                    </p>
                                                </div>
                        -->
                        <div class="input-field">
                            <label for="observacao-incluir">Observações</label>
                            <textarea id="observacao-incluir" class="materialize-textarea" name="observacao"></textarea>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="modal-action waves-effect waves-green btn btn-default" value="Cadastrar">Cadastrar</button>
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