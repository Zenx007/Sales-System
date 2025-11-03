<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Registrar Venda</title>
</head>
<body>
    <h2>Registrar Venda</h2>

    <%-- Mensagens de Sucesso ou Erro [cite: 1449-1454] --%>
    <c:if test="${not empty mensagemSucesso}">
        <p style="color:blue;">${mensagemSucesso}</p>
    </c:if>
    <c:if test="${not empty mensagemErro}">
        <p style="color:red;">${mensagemErro}</p>
    </c:if>

    <form:form modelAttribute="venda" action="${pageContext.request.contextPath}/vendas/salvar" method="post">

        <div>
            <label>Produto:</label><br>
            <%-- 'path' deve apontar para o ID dentro do objeto --%>
            <form:select path="produto.id_produto" required="true">
                <option value="">Selecione um Produto...</option>
                <c:forEach var="prod" items="${todosProdutos}">
                    <option value="${prod.id_produto}">
                        ${prod.nome_produto} (Estoque: ${prod.estoque})
                    </option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        <div>
            <label>Cliente:</label><br>
            <form:select path="cliente.id_pessoa" required="true">
                <option value="">Selecione um Cliente...</option>
                <c:forEach var="cli" items="${todosClientes}">
                    <option value="${cli.id_pessoa}">${cli.nome}</option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        <div>
            <label>Funcionário:</label><br>
            <form:select path="funcionario.id_pessoa" required="true">
                <option value="">Selecione um Funcionário...</option>
                <c:forEach var="func" items="${todosFuncionarios}">
                    <option value="${func.id_pessoa}">${func.nome}</option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        <div>
            <label>Quantidade:</label><br>
            <form:input path="quantidade" type="number" min="1" required="true" />
        </div>
        <br>

        <input type="submit" value="Registrar Venda" />
    </form:form>

    <br>
    <a href="<c:url value='/vendas' />">Voltar para a Lista de Vendas</a>
</body>
</html>