package main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.model.Dao;
import main.model.Javabeans;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Controller","/main","/insert","/select","/update","/delete"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();
    Javabeans contato = new Javabeans();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getServletPath();
        if (action.equals("/main")){
            contatos(request,response);
        }else if (action.equals("/insert")){
            novoContato(request,response);
        }else if (action.equals("/select")){
            listarContato(request,response);
        }else if (action.equals("/update")){
            editarContato(request,response);
        }else if (action.equals("/delete")){
            deletarContato(request,response);
        }else {
            response.sendRedirect("index.html");
        }
    }
    protected void contatos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<Javabeans> list = dao.listarContatos();

            request.setAttribute("contatos", list);
            RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        contato.setName(request.getParameter("nome"));
        contato.setNumber(request.getParameter("phone"));
        contato.setEmail(request.getParameter("email"));
        dao.criarContato(contato);
        response.sendRedirect("main");
    }
    protected void listarContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idcon = Integer.parseInt(request.getParameter("idcon"));
        contato.setIdnumber(idcon);
        dao.selecionarContato(contato);

        try {
            request.setAttribute("idcon",contato.getIdnumber());
            request.setAttribute("nome",contato.getName());
            request.setAttribute("phone",contato.getNumber());
            request.setAttribute("email",contato.getEmail());
            RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            contato.setIdnumber(Integer.parseInt(request.getParameter("idcon")));
            contato.setName(request.getParameter("nome"));
            contato.setNumber(request.getParameter("phone"));
            contato.setEmail(request.getParameter("email"));
            dao.editarContato(contato);
            response.sendRedirect("main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void deletarContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idcon = Integer.parseInt(request.getParameter("idcon"));
        contato.setIdnumber(idcon);
        dao.selecionarContato(contato);
        try {
            dao.deletarContato(contato);
            response.sendRedirect("main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

