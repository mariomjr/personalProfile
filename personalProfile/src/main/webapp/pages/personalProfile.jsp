<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile</title>
		<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css"/>
		<link rel="stylesheet" href="resources/css/personalProfile.css"/>
		<script type="text/javascript" src="resources/js/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery-mask-min.js"></script>
		<script type="text/javascript" src="resources/js/personalProfile.js"></script>
		<link rel="icon" href="resources/img/perfil2.jpg">
                
        <!-- Bootstrap Core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="resources/css/landing-page.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        
	</head>
	<body>
        <!-- Navigation -->
	    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
	        <div class="container topnav" style="margin-left:inherit !important">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand topnav navbar-brand" href="#">Dados Pessoais</a>
	            </div>
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a href="#" onclick="redirecionarPaginaProfile()">Personal Profile</a>
	                    </li>
                    </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container -->
	    </nav>
        
        <!-- Header -->
        <div class="intro-header-dadospessoais">
            <div class="container" style="margin-left:inherit !important">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <!-- Menu Header -->
                            <div class="barraLadoEsquerdo">
                                <div class="btn-group-vertical menuEsquerdo" role="group">
                                    <img alt="Foto do perfil" src="resources/img/perfil.jpg"
                                                class="imagemPerfil">
                                    <button type="button" class="btn btn-default" onclick="redirecionarPaginaProfile()">Dados pessoais</button>
                                    <button type="button" class="btn btn-default" onclick="redirecionarAgendaPessoal()">Agenda Pessoal</button>
                                    <button type="button" class="btn btn-default" onclick="redirecionarGaleria()">Galeria</button>
                                    <button type="button" class="btn btn-default" onclick="redirecionarTelefones()">Telefones</button>
                                    <form action="usuarioLogin" method="get"  role="form" data-toggle="validator" >
                                    	<input type="hidden" id="action" name="action" value="sair">
                                    	<button type="submit" class="btn btn-default" style="width:100%">Sair</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Dados Pessoais // Preencher -->
                <main>
                	<div class="corpoDireito">
                    	<div class="bodyDados">
                    		<c:if test="${not empty message}">                
				                <div class="alert alert-success">
				                    ${message}
				                </div>
				            </c:if>
                    		<form action="usuarioLogin" method="post"  role="form" data-toggle="validator" >
                				<input type="hidden" id="action" name="action" value="salvarProfile">
	                            <div class="row divCampos">
									<div class="col-md-2">
										Nome:
									</div>
									<div class="col-md-6">
										<input type="text" id="nome" name="nome" class="form-control" value="${usuario.nome}"/> 
									</div>
								</div>
								<div class="row divCampos">
									<div class="col-md-2">
										Endereço:
									</div>
									<div class="col-md-6">
										<input type="text" id="endereco" name="endereco" class="form-control" value="${usuario.endereco}"/> 
									</div>
								</div>
	                            <div class="row divCampos">
									<div class="col-md-2">
										Telefone:
									</div>
									<div class="col-md-6">
										<input type="text" id="telefone"  name="telefone" class="form-control" value="${usuario.telefone}"/> 
									</div>
	                           	</div>
	                            <div class="row divCampos">
									<div class="col-md-2">
										E-mail:
									</div>
									<div class="col-md-6">
										<input type="text" id="email" name="email" class="form-control" value="${usuario.email}"/> 
									</div>
	                            </div>
                            
                           		<button type="submit" class="btn btn-primary  btn-md">Salvar</button> 
                       		</form>
                        </div>
                    </div>
                </main>
       		</div>
                <!-- /.container -->

        </div>

        <div class="banner">

            <div class="container">

                <div class="row">
                    <div class="col-lg-6">
                        <h2>Conheça mais em:</h2>
                    </div>
                    <div class="col-lg-6">
                        <ul class="list-inline banner-social-buttons">
                            <li>
                                <a href="https://twitter.com/" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                            </li>
                            <li>
                                <a href="https://github.com/" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                            </li>
                            <li>
                                <a href="https://facebook.com/" target="_blank" class="btn btn-default btn-lg"><i class="fa fa-facebook fa-fw"></i> <span class="network-name">Facebook</span></a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.banner -->
		
	</body>
</html>