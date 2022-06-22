package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    Connection conexion;
    
    public PersonaDAO(){
     Conexion con = new Conexion();
     conexion = con.getConexion();

    }
    public List<Persona> listarPersona(){    
        PreparedStatement ps;
        ResultSet rs;        
        List<Persona> lista = new ArrayList<>();
        
        try{
            
            ps = conexion.prepareStatement("SELECT per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento FROM persona");
            
           rs = ps.executeQuery();           
           while(rs.next()){
               //con el get accedemos a los diferentes campos de nuestra tabla
               int per_id = rs.getInt("per_id");
               String per_nombres = rs.getString("per_nombres");
               String per_apellidos = rs.getString("per_apellidos");
               String tper_id = rs.getString("tper_id");
               String tdoc_id = rs.getString("tdoc_id");
               String per_numdoc = rs.getString("per_numdoc");
               String per_fec_nacimiento = rs.getString("per_fec_nacimiento");
               
               Persona persona = new Persona (per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento);
               
               lista.add(persona);           
           }           
           return lista;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Persona mostrarPersona(int _id){
    
        PreparedStatement ps;
        ResultSet rs;        
        Persona persona = null ;
        
        try{
            
           ps = conexion.prepareStatement("SELECT per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento FROM persona WHERE per_id=?");
           
           ps.setInt(1, _id);
           rs = ps.executeQuery();
           
           while(rs.next()){
               
               int per_id = rs.getInt("per_id");
               String per_nombres = rs.getString("per_nombres");
               String per_apellidos = rs.getString("per_apellidos");
               String tper_id = rs.getString("tper_id");
               String tdoc_id = rs.getString("tdoc_id");
               String per_numdoc = rs.getString("per_numdoc");
               String per_fec_nacimiento = rs.getString("per_fec_nacimiento");
               
               persona = new Persona(per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento);           
           }           
           return persona;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertarPersona(Persona persona){
    
        PreparedStatement ps;
        
        try{
            
           ps = conexion.prepareStatement("INSERT into persona(per_id, per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento)VALUES (?,?,?,?,?,?,?)");
           
           ps.setInt(1, persona.getPer_id());
           ps.setString(2, persona.getPer_nombres());
           ps.setString(3, persona.getPer_apellidos());
           ps.setString(4, persona.getTper_id());
           ps.setString(5, persona.getTdoc_id());
           ps.setString(6, persona.getPer_numdoc());
           ps.setString (7, persona.getPer_fec_nacimiento());
           ps.execute();
           return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizarPersona(Persona persona){
    
        PreparedStatement ps;
        
        try{
            
           ps = conexion.prepareStatement("UPDATE into persona SET per_id=?, per_nombres=?, per_apellidos=?, tper_id=?, tdoc_id=?, per_numdoc=?, per_fec_nacimiento=? WHERE per_id=?");
           
           ps.setInt(1, persona.getPer_id());
           ps.setString(2, persona.getPer_nombres());
           ps.setString(3, persona.getPer_apellidos());
           ps.setString(4, persona.getTper_id());
           ps.setString(5, persona.getTdoc_id());
           ps.setString(6, persona.getPer_numdoc());
           ps.setString(7, persona.getPer_fec_nacimiento());
           ps.execute();
           return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminarPersona(int _id){
    
        PreparedStatement ps;
        
        try{
            
           ps = conexion.prepareStatement("DELETE from persona WHERE per_id=?");
           
           ps.setInt(1, _id);
           ps.execute();
           return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
