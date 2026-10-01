<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; 
              charset=UTF-8"> 
        <title>Productos</title> 
        
    </head> 
    <body> 
        <h2>Registrar Producto</h2>  
        <form action="producto?accion=agregar" method="post">  
            Nombre: <input type="text" name="nombre" required> 
            <br><br>  
            Precio: <input type="number" name="precio" min="0" 
                           required> <br><br>  
            <input type="submit" value="Guardar">  
        </form> <br>  
        <h2>Listado</h2>  
        <table border="1" class="table table-bordered">  
            <tr>  
                <th>ID</th>  
                <th>Nombre</th>  
                <th>Precio</th> 
            </tr>  
            <c:forEach var="prod" items="${productos}"> 
                <tr>  
                    <td>${prod.id}</td> 
                    <td>${prod.nombre}</td> 
                    <td>${prod.precio}</td> 
                </tr> 
            </c:forEach> 
        </table> 
    </body> 
</html> 