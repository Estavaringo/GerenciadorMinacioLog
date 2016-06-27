<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/Paginas/header.jsp" %>

<main>
    <div class="section" id="index-banner">
        <div class="container">
            <div class="row">
                <div class="col s12 m9">
                    <c:if test="${empty usuarioLogado}">
                        <h1 class="header center-on-small-only">Login</h1>
                    </c:if>
                    <c:if test="${not empty usuarioLogado}">
                        <h1 class="header center-on-small-only">Gerenciador MinacioLog</h1>
                    </c:if>
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
                    <c:if test="${empty usuarioLogado}">
                        <h4 class="header">Login</h4>
                        <form method="POST" action="Executa">
                            <input type="hidden" name="logicaDeNegocio" value="Login">

                            <div class="input-field">
                                <i class="material-icons prefix">perm_identity</i>
                                <label for="descricao-incluir">E-Mail</label>
                                <input id="descricao-incluir" type="email" class="validate" name="email" value="" />
                            </div>
                            <div class="input-field">
                                <i class="material-icons prefix">lock</i>
                                <label for="descricao-incluir">Senha</label>
                                <input id="descricao-incluir" type="password" class="validate" name="senha" value="" />
                            </div>

                            <button type="submit" class="btn btn-default" value="Cadastrar">Login</button>

                        </form>
                    </c:if>

                    <c:if test="${not empty usuarioLogado}">
                        <h4 class="header">Bem-vindo ${usuarioLogado.email}</h4>
                    </c:if>
                </div>
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
<%@ include file="/WEB-INF/Paginas/footer.jsp" %>