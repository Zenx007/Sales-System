<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema de Vendas</title>
</head>
<body>
    <h1>Bem-vindo ao Sistema de Vendas</h1>
    <p>Escolha uma opção abaixo:</p>

    <h3>Vendas</h3>
    <a href="<c:url value='/vendas/nova' />">Registrar Nova Venda</a><br>
    <a href="<c:url value='/vendas' />">Listar Vendas</a>

    <h3>Produtos</h3>
    <a href="<c:url value='/produtos' />">Listar Produtos</a><br>
    <a href="<c:url value='/produtos/novo' />">Cadastrar Produto</a>

    <h3>Clientes</h3>
    <a href="<c:url value='/clientes' />">Listar Clientes</a><br>
    <a href="<c:url value='/clientes/novo' />">Cadastrar Cliente</a>

    <h3>Funcionários</h3>
    <a href="<c:url value='/funcionarios' />">Listar Funcionários</a><br>
    <a href="<c:url value='/funcionarios/novo' />">Cadastrar Funcionário</a>

    <h3>Relatório Geral</h3>
    <a href="<c:url value='/pessoas' />">Listar Todas as Pessoas</a>
</body>
</html>