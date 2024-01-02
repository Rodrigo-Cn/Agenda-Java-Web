<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="main.model.Javabeans" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<Javabeans> lista = (ArrayList<Javabeans>) request.getAttribute("contatos"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Editar Contato</title>
    <link rel="icon" href="imagens/">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Editar Contato</h1>
    <form name="newNumber" action="update">
        <table>
            <tr>
                <td><input type="number" name="idcon" id="caixa" readonly value="<% out.print(request.getAttribute("idcon")); %>" ></td>
            </tr>
            <tr>
                <td><input type="text" name="nome" value="<% out.print(request.getAttribute("nome")); %>" ></td>
            </tr>
            <tr>
                <td><input type="text" name="phone" value="<% out.print(request.getAttribute("phone")); %>" ></td>
            </tr>
            <tr>
                <td><input type="text" name="email" value="<% out.print(request.getAttribute("email")); %>" ></td>
            </tr>
            </table>
            <input type="button" value="Salvar" onclick="validar()">
        </form>
        <script src="validador.js"></script>
</body>
</html>