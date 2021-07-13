package servlet;

import model.Banco;
import model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Alterando empresa");

        String nomeEmpresa = request.getParameter("nome");
        String dataAbertura = request.getParameter("data");
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);
        Empresa empresa = new Empresa();
        try {
            Banco banco = new Banco();
            empresa = banco.buscaEmpresaPelaId(id);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            empresa.setNome(nomeEmpresa);
            empresa.setDataAbertura(sdf.parse(dataAbertura));
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        response.sendRedirect("listaEmpresas");
    }
}
