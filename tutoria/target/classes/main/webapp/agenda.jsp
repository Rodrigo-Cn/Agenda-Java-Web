<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="main.model.Javabeans" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Javabeans> lista = (ArrayList<Javabeans>) request.getAttribute("contatos"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Agenda</title>
    <link rel="icon" href="imagens/">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Agenda de Contatos</h1>
    <a href="novocontato.html" class="button">Novo Contato</a>
    <table id="tablle">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Fone</th>
                <th>E-mail</th>
                <th>Opções</th>
            </tr>
        </thead>
        <tbody>
            <% for (int i = 0; i < lista.size(); i++) { %>
                <tr>
                    <td><%= lista.get(i).getIdnumber() %></td>
                    <td><%= lista.get(i).getName() %></td>
                    <td><%= lista.get(i).getNumber() %></td>
                    <td><%= lista.get(i).getEmail() %></td>
                    <td><a href="select?idcon=<%= lista.get(i).getIdnumber() %>" class="button">Editar</a><a href="delete?idcon=<%= lista.get(i).getIdnumber() %>" id="delete" class="button" >Deletar</a></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>