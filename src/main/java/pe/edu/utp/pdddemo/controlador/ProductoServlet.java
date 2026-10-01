package pe.edu.utp.pdddemo.controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import pe.edu.utp.pdddemo.facade.ProductoFacade;
import pe.edu.utp.pdddemo.facade.ProductoFacadeImpl;
import pe.edu.utp.pdddemo.modelo.Producto;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/producto"})
public class ProductoServlet extends HttpServlet {

    ProductoFacade prodFacade = new ProductoFacadeImpl();

    private static final String VIEW_PATH = "/WEB-INF/views/";

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar" -> {
                List<Producto> lista = prodFacade.listar();
                request.setAttribute("productos", lista);
                request.getRequestDispatcher(VIEW_PATH
                        + "productos.jsp").forward(request, response);
            }
            case "agregar" -> {
                Producto p = new Producto();
                p.setNombre(request.getParameter("nombre"));
                p.setPrecio(Double.valueOf(request.getParameter("precio")));
                prodFacade.registrar(p);

                response.sendRedirect("producto?accion=listar");
            }

            default -> {
                response.sendRedirect("producto?accion=listar");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
