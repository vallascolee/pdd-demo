package pe.edu.utp.pdddemo.facade;

import java.util.List;
import pe.edu.utp.pdddemo.modelo.Producto;

public interface ProductoFacade {

    public void registrar(Producto producto);

    public List<Producto> listar();
}
