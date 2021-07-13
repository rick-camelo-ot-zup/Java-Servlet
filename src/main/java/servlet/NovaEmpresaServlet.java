package servlet;

import model.Banco;
import model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");
        String dataAbertura = request.getParameter("data");
        Empresa empresa = new Empresa();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            empresa = new Empresa(nomeEmpresa, sdf.parse(dataAbertura));
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        banco.adiciona(empresa);

        request.setAttribute("empresa", empresa.getNome());
        response.sendRedirect("listaEmpresas");

        //chamar o JSP
/*        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);*/

    }
}
