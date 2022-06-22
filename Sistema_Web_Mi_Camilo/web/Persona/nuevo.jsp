<%-- 
    Document   : nuevo
    Created on : 17/06/2022, 12:22:28 AM
    Author     : MiguelMaquen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
    </head>
    <body>
        <h2>Nuevo Registro</h2>

        
        <form action="PersonaController?accion=insertar" method="POST" autocomplete="off">
            

            <p>
                Nombres
               <input per_nombres="per_nombres" name="per_nombres" type="text" />
            </p>
            <p>
                Apellidos
                <input per_apellidos="per_apellidos" name="per_apellidos" type="text" />
            </p>
            <p>
                 TipoPersona
                <input tper_id="tper_id" name="tper_id" type="text" />
            </p>
            <p>
                Documento
                <input tdoc_id="tdoc_id" name="tdoc_id" type="text" />
            </p>
            <p>
                 PerDocumento
                <input per_numdoc="per_numdoc" name="per_numdoc" type="text" />
            </p>
            <p>
                 FechaNacimiento
                <input per_fec_nacimiento="per_fec_nacimiento" name="per_fec_nacimiento" type="text" />
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
        
        
    </body>
</html>
