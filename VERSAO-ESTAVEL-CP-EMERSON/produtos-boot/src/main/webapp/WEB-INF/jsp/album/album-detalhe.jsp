<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>

    <title>Album - Detalhe</title>
    
    <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
    
    <link href="${contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/css/small-business.css" rel="stylesheet">

</head>

<body>
    
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${contextPath}/produto">Produtos</a>
                    </li>
                    <li>
                    	<a href="${contextPath}/categoria">Categorias</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="well">
					
					<h2>Album - Editar</h2>
					
						<div class="form-group">
							<label class="control-label" for="nome">Nome:</label>
							<b>${album.nome}</b>
                        </div>
						<hr>
						
						<div class="form-group">
							<label class="control-label" for="nome">Ano de Lançamento:</label>
							<b>${album.anoLancamento}</b>
                        </div>
						<hr>
						
						<div class="form-group">
							<label class="control-label" for="nome">Gênero:</label>
							<b>${album.genero}</b>
                        </div>
						<hr>
						
						<div class="form-group">
							<label class="control-label" for="nome">Gravadora:</label>
							<b>${album.gravadira}</b>
                        </div>
						<hr>
						
						<div class="form-group">
							<label class="control-label" for="nome">Banda:</label>
							<b>${album.banda.nome}</b>
                        </div>
						<hr>
						
						
						<a class="btn btn-default btn-lg" href="${contextPath}/albums">Voltar</a>
                            
                        <br>
                        <br>
					
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="${contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${contextPath}/js/bootstrap.min.js"></script>

</body>
</html>