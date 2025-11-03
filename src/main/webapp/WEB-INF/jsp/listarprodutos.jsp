<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Importando as Taglibs que adicionamos no pom.xml --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
</head>
<body>
    <h2>Lista de Produtos</h2>
    <%-- O c:url gera o link corretamente para a URL do controller --%>
    <a href="<c:url value='/produtos/novo' />">Cadastrar Novo Produto</a>
    <hr>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome do Produto</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Estoque</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%-- Substitui o scriptlet <% for (Produto p : produtos) %> [cite: 763-764, 3088] --%>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.id_produto}</td>
                    <td>${produto.nome_produto}</td>
                    <td>${produto.descricao}</td>
                    <%-- Usando a tag de formatação de número como moeda --%>
                    <td><fmt:formatNumber value="${produto.preco}" type="currency" currencySymbol="R$ " /></td>
                    <td>${produto.estoque}</td>
                    <td>
                        <a href="<c:url value='/produtos/editar/${produto.id_produto}' />">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>