<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lista de Funcionários</title>
</head>
<body>
    <h2>Lista de Funcionários</h2>
    <a href="<c:url value='/funcionarios/novo' />">Cadastrar Novo Funcionário</a>
    <hr>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Cargo</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td>${funcionario.id_pessoa}</td>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.email}</td>
                    <td>${funcionario.telefone}</td>
                    <td>${funcionario.cargo}</td>
                    <td>
                        <a href="<c:url value='/funcionarios/editar/${funcionario.id_pessoa}' />">Editar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<c:url value='/' />">Voltar ao Início</a>
</body>
</html>