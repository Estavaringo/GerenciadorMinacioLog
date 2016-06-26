<%-- 
    Document   : index
    Created on : 09/04/2016, 19:00:03
    Author     : flaviosampaioreisdelima
--%>
<%@ include file="/WEB-INF/Paginas/header.jsp" %>
<main>
    <div class="row">
        <!-- ARMAZENAR TODAS AS DIVS DE CONTEÚDO DO SITE -->
        <div class="col s9 m8 l9"> <!-- Note a soma das colunas sempre serão 12 -->
            <!-- Teal page content
            
                  This content will be:
              9-columns-wide on large screens,
              8-columns-wide on medium screens,
              12-columns-wide on small screens  -->
            <!-- CONTEÚDO INICIAL DE APRESENTAÇÃO DO SITE E BOTÃO ENTRAR -->
            <!-- 
            <div class="section no-pad-bot" id="index-banner">
                    <div class="container">
                            <br><br>
                            <h1 class="header center orange-text">Gerenciador Minacio Log</h1>
                            <div class="row center">
                            <h5 class="header col s12 light">Sistema de gerenciamento de clientes e controle financeiros da Minacio Log.</h5>
                            </div>
                            <div class="row center">
                                    <form action="executa" method="POST">
                                            <input type="hidden" name="tarefa" value="Logout" />
                                            <button class="btn-large waves-effect waves-light" type="submit" name="action" value="login">
                                                    Entrar<i class="material-icons right">send</i>
                                            </button>
                                    </form>
                            </div>
                    </div>
            </div>
            -->

            <!-- CONTEÚDO DE CADA PÁGINA -->
            <div class="col s12 m8 l9">
                <div id="introduction" class="section scrollspy">
                    <div class="divider"></div>
                    <h2 class="header">Titulo Sessão 1</h2>
                    <p>Texto de Descrição da Sessão 1</p>
                    <h4>Sub-Titulo da Sessão 1</h4>
                    <div class="section">
                        <h5>Section 1</h5>
                        <br><br><br>
                        <p>COLOQUE O CONTEÚDO 1 AQUI</p>
                    </div>
                    <br><br><br>
                </div>
            </div>

            <div id="structure" class="section scrollspy">
                <div class="divider"></div>
                <h2 class="header">Titulo Sessão 2</h2>
                <p>Texto de Descrição da Sessão 2</p>
                <h4>Sub-Titulo da Sessão 2</h4>
                <div class="section">
                    <h5>Section 2</h5>
                    <br><br><br>
                    <p>COLOQUE O CONTEÚDO 2 AQUI</p>
                    <br><br><br>
                </div>
            </div>

            <div id="initialization" class="section scrollspy">
                <div class="divider"></div>
                <h2 class="header">Titulo Sessão 3</h2>
                <p>Texto de Descrição da Sessão 3</p>
                <h4>Sub-Titulo da Sessão 3</h4>

                <div class="section">
                    <h5>Section 3</h5>
                    <br><br><br>
                    <p>COLOQUE O CONTEÚDO 3 AQUI</p>
                    <br><br><br>
                </div>
            </div>
        </div>
        <!-- ATALHOS DAS SESSÕES DA PÁGINA -->
        <div class="col hide-on-small-only m3 l2">
            <div class="tabs-wrapper" style="top: 0px;">
                <ul class="section table-of-contents">
                    <li><a href="#introduction">Section 1</a></li>
                    <li><a href="#structure">Section 2</a></li>
                </ul>
            </div>
        </div>		
    </div>

</div>
</main>
<%@ include file="/WEB-INF/Paginas/footer.jsp" %>