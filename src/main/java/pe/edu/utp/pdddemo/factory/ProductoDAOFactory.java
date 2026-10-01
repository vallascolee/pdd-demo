package pe.edu.utp.pdddemo.factory;

import pe.edu.utp.pdddemo.dao.ProductoDAO;
import pe.edu.utp.pdddemo.dao.impl.ProductoMySQLDAO;
import pe.edu.utp.pdddemo.dao.impl.ProductoPostgresSQLDAO;

public class ProductoDAOFactory {

    public static ProductoDAO crear(String tipoBD) {

        if (tipoBD.equals("mysql")) {
            return new ProductoMySQLDAO();
        }
        if (tipoBD.equals("postgres")) {
            return new ProductoPostgresSQLDAO();
        }
        throw new IllegalArgumentException("base de datos no soportada");
    }
}
