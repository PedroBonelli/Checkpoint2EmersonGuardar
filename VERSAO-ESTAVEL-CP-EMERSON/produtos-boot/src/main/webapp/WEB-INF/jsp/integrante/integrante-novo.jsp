<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

    <title>Integrantes - Cadastro</title>
    
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
					
					<h2>Integrante</h2>
					
					<form:form modelAttribute="IntegranteModel" action="${contextPath}/integrantes" method="post">
					
						<spring:hasBindErrors name="IntegranteModel">
							<div class="alert alert-danger" role="alert">
								<form:errors path="*" class="has-error" />
							</div>
						</spring:hasBindErrors>
					
						<div class="form-group">
							<label class="control-label" for="nome">Nome:</label>
							<form:input type="text" path="nome" id="nome" class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="nome"/></font><br/>
                        </div>
						<hr/>
						
						<div class="form-group">
							<label class="control-label" for="nome">Gênero:</label>
							<form:input type="text" path="genero" id="genero" class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="genero"/></font><br/>
                        </div>
						<hr/>
						
						<div class="form-group">
							<label class="control-label" for="nome">Função:</label>
							<form:input type="text" path="role" id="role" class="form-control" maxlength="50" size="50" />
							<font color="red"><form:errors path="role"/></font><br/>
                        </div>
						<hr/>
						
						<div class="form-group">
                        	<label class="control-label" for="banda">Banda:</label>
                        
	                        <form:select path="banda.id">
	                        	<form:options items="${bandas}" itemValue="id" itemLabel="nome" />
	                        </form:select>
						</div>
						
						
						<a class="btn btn-default btn-lg" href="${contextPath}/integrantes">Cancelar</a>
						<button type="submit" class="btn btn-primary btn-lg">Gravar</button>
                            
                        <br>
                        <br>
					</form:form>
					
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