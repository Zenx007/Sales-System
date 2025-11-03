<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Cliente</title>
</head>
<body>
    <c:if test="${cliente.id_pessoa == null}">
        <h2>Cadastrar Cliente</h2>
    </c:if>
    <c:if test="${cliente.id_pessoa != null}">
        <h2>Editar Cliente</h2>
    </c:if>

    <form:form modelAttribute="cliente" action="${pageContext.request.contextPath}/clientes/salvar" method="post">

        <%-- O ID aqui é o 'id_pessoa' da classe Pessoa --%>
        <form:hidden path="id_pessoa" />

        <div>
            <label>Nome:</label><br>
            <form:input path="nome" required="true" />
        </div>
        <br>
        <div>
            <label>E-mail:</label><br>
            <form:input path="email" type="email" required="true" />
        </div>
        <br>
        <div>
            <label>Telefone:</label><br>
            <form:input path="telefone" required="true" />
        </div>
        <br>

        <input type="submit" value="Salvar" />
    </form:form>

    <br>
    <a href="<c:url value='/clientes' />">Voltar para a Lista</a>
</body>
</html>