package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Calculadora;

@WebServlet("/calcula")
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            double n1 = Double.parseDouble(request.getParameter("n1"));
            double n2 = Double.parseDouble(request.getParameter("n2"));
            String operador = request.getParameter("operador");

            Calculadora calculadora = new Calculadora(n1, n2, operador);
            double valor = calculadora.getValorCalculado();

            out.println(valor);
        } catch (NullPointerException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("Por favor, entre com todos os dados.");
        } catch (NumberFormatException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("Por favor, entre com números para n1 e n2.");
        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
            out.println("Por favor, entre com uma operação válida.");
        }
    }

}
