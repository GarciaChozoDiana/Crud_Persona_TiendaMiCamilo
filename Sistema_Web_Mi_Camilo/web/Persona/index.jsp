<%-- 
    Document   : productos
    Created on : 17/06/2022, 01:07:40 AM
    Author     : Diana Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PERSONA</title>
    </head>
    <body>
        <h1>Persona</h1>
        
        <a href="PersonaController?accion=nuevo">Nuevo Registro</a>
        
        <br /><br />
        
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Persona</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>TipoPersona</th>
                    <th>Documento</th>
                    <th>PerDocumento</th>
                    <th>FechaNacimiento</th>
                    <th></th>
                    <th></th>

                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="persona" items="${lista}">
                    
                    <tr>
                        <td><c:out value="${persona.per_id}" /></td>
                        <td><c:out value="${persona.per_nombres}" /></td>
                        <td><c:out value="${persona.per_apellidos}" /></td>
                        <td><c:out value="${persona.tper_id}" /></td>
                        <td><c:out value="${persona.tdoc_id}" /></td>
                        <td><c:out value="${persona.per_numdoc}" /></td>
                        <td><c:out value="${persona.per_fec_nacimiento}" /></td>
                        <td><a href="PersonaController?accion=modificar&per_id<c:out value="${persona.per_id}" />">Modificar</a></td>
                        <td><a href="PersonaController?accion=eliminar&per_id<c:out value="${persona.per_id}" />">Eliminar</a></td>
                    </tr>
                    
                    
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
