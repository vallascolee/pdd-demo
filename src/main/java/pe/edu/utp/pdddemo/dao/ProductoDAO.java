package pe.edu.utp.pdddemo.dao;

import java.util.List;
import pe.edu.utp.pdddemo.modelo.Producto;

public interface ProductoDAO {

    public void registrar(Producto p);

    public List<Producto> listar();
}
