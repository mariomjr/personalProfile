<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
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

    <body class="bodyLogin">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
            <div class="container topnav">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand topnav" href="http://localhost:8084/personalProfile/">Personal Profile</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#services">Services</a>
                        </li>
                        <li>
                            <a href="#contact">Contact</a>
                        </li>
                        <li>
                            <a href="login.jsp">Entrar</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        
        <!-- Header -->
        <div class="intro-header">
            <div class="container">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message">
                            <!-- Login -->
                            
                            <form action="usuarioLogin" method="post"  role="form" data-toggle="validator" >
                				<input type="hidden" id="action" name="action" value="autenticar">
	                            <div class="panel panel-primary divLogin">
	                                <div class="panel-heading">
	                                    Login Personal Profile
	                                </div>
	                                <c:if test="${not empty message}">                
						                <div class="alert alert-danger">
						                    ${message}
						                </div>
						            </c:if> 
	                                <div class="panel-body">
	                                    Usuário: 
	                                    <div class="input-group">
	                                        <span class="input-group-addon glyphicon glyphicon-user" id="basic-addon1"></span>
	                                        <input type="text" id="login" name="login" class="form-control">
	                                    </div>
	                                    Senha:
	                                    <div class="input-group">
	                                        <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon1"></span>
	                                        <input type="password" id="senha" name="senha" class="form-control">
	                                    </div>
	                                    <div class="divBtnEntrar">
	                                        <button class="btn btn-success btnEntrar" type="submit">Entrar</button>
	                                    </div>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        
        </div>
        <!-- /.intro-header -->

        
        
        <!-- Page Content -->

        <a  name="services"></a>
        <div class="content-section-a">

            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Construa seu perfil:</h2>
                        <p class="lead">Um perfil online muda a forma de lidar com os contatos. É prático apresentar meus dados a uma vaga de emprego a um novo amigo ou até uma nova amiga <3... </p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="resources/img/dog.png" alt="">
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-a -->

        <div class="content-section-a">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Construa sua agenda pessoal</h2>
                        <p class="lead">Com esta funcionalidade poderei levar minha agenda para onde estiver, seja no trabalho ou em casa. O acesso aos dados da agenda é de uso privado do cliente, diferente do perfil que poderá ser compartilhado.</p>
                    </div>
                    <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                        <img class="img-responsive" src="resources/img/ipad.png" alt="">
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-b -->

        <div class="content-section-a">

            <div class="container">

                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Galeria de fotos</h2>
                        <p class="lead">Armazene imagens na hora que precisar.</p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="resources/img/phones.png" alt="">
                    </div>
                </div>

            </div>
            <!-- /.container -->

        </div>
        <!-- /.content-section-a -->

        <a  name="contact"></a>
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

        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="list-inline">
                            <li>
                                <a href="#">Home</a>
                            </li>

                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="#services">Services</a>
                            </li>
                            <li class="footer-menu-divider">&sdot;</li>
                            <li>
                                <a href="#contact">Contact</a>
                            </li>
                        </ul>
                        <p class="copyright text-muted small">Copyright &copy; Your Company 2014. All Rights Reserved</p>
                    </div>
                </div>
            </div>
        </footer>
       
    </body>
</html>