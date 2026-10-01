package pe.edu.utp.pdddemo.dao.impl; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import pe.edu.utp.pdddemo.dao.ProductoDAO; 
import pe.edu.utp.pdddemo.modelo.Producto; 
import pe.edu.utp.pdddemo.util.Conexion; 
public class ProductoMySQLDAO implements ProductoDAO{ 
@Override 
public void registrar(Producto p) { 
try { 
String sql = "INSERT INTO producto(nombre,precio) VALUES(?,?)"; 
PreparedStatement ps = 
Conexion.getInstance().prepareStatement(sql); 
ps.setString(1, p.getNombre()); 
ps.setDouble(2, p.getPrecio()); 
ps.executeUpdate(); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
} 
@Override 
public List<Producto> listar() { 
List<Producto> lista = new ArrayList<>(); 
try { 
Statement st = Conexion.getInstance().createStatement(); 
ResultSet rs = st.executeQuery("SELECT * FROM producto"); 
while (rs.next()) { 
Producto p = new Producto(); 
p.setId(rs.getInt("id")); 
p.setNombre(rs.getString("nombre")); 
p.setPrecio(rs.getDouble("precio")); 
lista.add(p); 
} 
} catch (Exception e) { 
e.printStackTrace(); 
} 
return lista; 
} 
} 