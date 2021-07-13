package servlet;

import model.Banco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        Banco banco = new Banco();
        banco.remove(id);

        response.sendRedirect("listaEmpresas");
    }
}
