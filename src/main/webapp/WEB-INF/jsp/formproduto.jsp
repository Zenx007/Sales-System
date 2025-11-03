<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Importando as Taglibs --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>
</head>
<body>

    [cite_start]<%-- Muda o título da página se for cadastro ou edição [cite: 1726, 1746] --%>
    <c:if test="${produto.id_produto == null}">
        <h2>Cadastrar Produto</h2>
    </c:if>
    <c:if test="${produto.id_produto != null}">
        <h2>Editar Produto</h2>
    </c:if>

    <%--
      Este é o formulário Spring.
      'modelAttribute="produto"' conecta este form ao objeto enviado pelo Controller.
      O 'action' aponta para o endpoint @PostMapping("/salvar").
    --%>
    <form:form modelAttribute="produto"
               action="${pageContext.request.contextPath}/produtos/salvar"
               method="post">

        <%-- Campo 'hidden' para guardar o ID. Essencial para a edição. --%>
        <form:hidden path="id_produto" />

        <div>
            <label>Nome do Produto:</label><br>
            <%-- 'path' deve ser o nome exato do atributo na classe Produto --%>
            <form:input path="nome_produto" required="true" />
        </div>
        <br>
        <div>
            <label>Descrição:</label><br>
            <form:textarea path="descricao" rows="3" />
        </div>
        <br>
        <div>
            <label>Preço:</label><br>
            <form:input path="preco" type="number" step="0.01" required="true" />
        </div>
        <br>
        <div>
            <label>Estoque:</label><br>
            <form:input path="estoque" type="number" required="true" />
        </div>
        <br>

        <input type="submit" value="Salvar" />
    </form:form>

    <br>
    <a href="<c:url value='/produtos' />">Voltar para a Lista</a>

</body>
</html>