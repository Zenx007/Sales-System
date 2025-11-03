<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Funcionário</title>
</head>
<body>
    <c:if test="${funcionario.id_pessoa == null}">
        <h2>Cadastrar Funcionário</h2>
    </c:if>
    <c:if test="${funcionario.id_pessoa != null}">
        <h2>Editar Funcionário</h2>
    </c:if>

    <form:form modelAttribute="funcionario" action="${pageContext.request.contextPath}/funcionarios/salvar" method="post">

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
        <%-- Campos extras de Funcionário --%>
        <div>
            <label>Cargo:</label><br>
            <form:input path="cargo" required="true" />
        </div>
        <br>
        <div>
            <label>Senha:</label><br>
            <form:password path="senha" required="true" />
        </div>
        <br>

        <input type="submit" value="Salvar" />
    </form:form>

    <br>
    <a href="<c:url value='/funcionarios' />">Voltar para a Lista</a>
</body>
</html>