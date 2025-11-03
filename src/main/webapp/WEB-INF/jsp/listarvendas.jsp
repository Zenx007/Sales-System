<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Vendas</title>
</head>
<body>
    <h2>Lista de Vendas</h2>
    <a href="<c:url value='/vendas/nova' />">Registrar Nova Venda</a>
    <hr>

    <table>
        <thead>
            <tr>
                <th>ID Venda</th>
                <th>Cliente</th>
                <th>Funcionário</th>
                <th>Produto</th>
                <th>Qtd.</th>
                <th>Data da Venda</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="venda" items="${vendas}">
                <tr>
                    <td>${venda.id_venda}</td>
                    <td>${venda.cliente.nome}</td>
                    <td>${venda.funcionario.nome}</td>
                    <td>${venda.produto.nome_produto}</td>
                    <td>${venda.quantidade}</td>
                    <td><fmt:formatDate value="${venda.data_venda}" pattern="dd/MM/yyyy" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<c:url value='/' />">Voltar ao Início</a>
</body>
</html>