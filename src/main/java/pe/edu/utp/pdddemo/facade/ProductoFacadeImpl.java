package pe.edu.utp.pdddemo.facade;

import java.util.List;
import pe.edu.utp.pdddemo.dao.ProductoDAO;
import pe.edu.utp.pdddemo.factory.ProductoDAOFactory;
import pe.edu.utp.pdddemo.modelo.Producto;

public class ProductoFacadeImpl implements ProductoFacade {

    ProductoDAO dao = ProductoDAOFactory.crear("mysql");

    @Override
    public void registrar(Producto producto) {
        dao.registrar(producto);
    }

    @Override
    public List<Producto> listar() {
        return dao.listar();
    }
}
