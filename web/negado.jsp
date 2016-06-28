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
                        <h1 class="header center-on-small-only">Acesso Negado</h1>
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
                        <h4 class="header">Faça login para ter acesso ao sistema!</h4>
                        <a href="index.jsp" class="btn btn-default">
                            Fazer Login
                        </a>
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