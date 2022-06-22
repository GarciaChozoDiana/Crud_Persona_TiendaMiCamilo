package controlador;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;
import modelo.PersonaDAO;


@WebServlet(name = "PersonaController", urlPatterns = {"/PersonaController"})
public class PersonaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        PersonaDAO personaDAO = new PersonaDAO();
        String accion;
        RequestDispatcher dispatcher = null; //enviar las peticiones de la url
        
        accion = request.getParameter("accion"); // lo utilizamos para recoger parametros por peticion get
        
        if(accion == null || accion.isEmpty()){
        dispatcher = request.getRequestDispatcher("Persona/index.jsp");
        List<Persona> listarPersona = personaDAO.listarPersona();
        request.setAttribute("lista", listarPersona); 
        } else if ("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("Persona/nuevo.jsp");
        }else if ("insertar".equals(accion)){
            
            int per_id = Integer.parseInt(request.getParameter("per_id"));
            String per_nombres = request.getParameter("per_nombres");
            String per_apellidos = request.getParameter("per_apellidos");
            String tper_id = request.getParameter("tper_id");
            String tdoc_id = request.getParameter("tdoc_id");
            String per_numdoc = request.getParameter(" per_numdoc");
            String per_fec_nacimiento = request.getParameter("per_fec_nacimiento");
            
            Persona persona = new Persona(0, per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento);
            
            personaDAO.insertarPersona(persona);          
            dispatcher = request.getRequestDispatcher("Persona/index.jsp");
            List<Persona> listarPersona = personaDAO.listarPersona();
            request.setAttribute("lista", listarPersona);
            
        } else if ("modificar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Persona/modificar.jsp");
            int per_id = Integer.parseInt(request.getParameter("per_id"));
            Persona persona = personaDAO.mostrarPersona(per_id);
            request.setAttribute("persona", persona);
            
        } else if ("actualizar".equals(accion)){
            
            int per_id = Integer.parseInt(request.getParameter("per_id"));
            String per_nombres = request.getParameter("per_nombres");
            String per_apellidos = request.getParameter("per_apellidos");
            String tper_id = request.getParameter("tper_id");
            String tdoc_id = request.getParameter("tdoc_id");
            String per_numdoc = request.getParameter(" per_numdoc");
            String per_fec_nacimiento = request.getParameter("per_fec_nacimiento");
            
            Persona persona = new Persona(per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento);
            
            personaDAO.actualizarPersona(persona);          
            dispatcher = request.getRequestDispatcher("Persona/index.jsp");
            List<Persona> listarPersona = personaDAO.listarPersona();
            request.setAttribute("lista", listarPersona);
        }
        
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
