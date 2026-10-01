package pe.edu.utp.pdddemo.util; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
public class Conexion { 
private static Connection conn; 
public static Connection getInstance() { 
try { 
if (conn == null || conn.isClosed()) { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/pdd_demo", 
"root", "12345678"); 
} 
} catch (ClassNotFoundException | SQLException e) { 
e.printStackTrace(); 
} 
return conn; 
} 
} 