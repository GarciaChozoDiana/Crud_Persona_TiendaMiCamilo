
package modelo;

import java.sql.Date;

public class Persona {
    
    private int per_id;
    private String  per_nombres, per_apellidos, tper_id, tdoc_id, per_numdoc, per_fec_nacimiento;

    public Persona(int per_id, String per_nombres, String per_apellidos, String tper_id, String tdoc_id, String  per_numdoc, String per_fec_nacimiento) {
        this.per_id = per_id;
        this.per_nombres = per_nombres;
        this.per_apellidos = per_apellidos;
        this.tper_id = tper_id;
        this.tdoc_id = tdoc_id;
        this.per_numdoc = per_numdoc;
        this.per_fec_nacimiento = per_fec_nacimiento;

    }

    public Persona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Persona(int i, int per_id, String per_nombres, String per_apellidos, String tper_id, String tdoc_id, String per_numdoc, String per_fec_nacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public String getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public String getTper_id() {
        return tper_id;
    }

    public void setTper_id(String tper_id) {
        this.tper_id = tper_id;
    }

    public String getTdoc_id() {
        return tdoc_id;
    }

    public void setTdoc_id(String tdoc_id) {
        this.tdoc_id = tdoc_id;
    }

    public String getPer_numdoc() {
        return per_numdoc;
    }

    public void setPer_numdoc(String per_numdoc) {
        this.per_numdoc = per_numdoc;
    }

    public String getPer_fec_nacimiento() {
        return per_fec_nacimiento;
    }

    public void setPer_fec_nacimiento(String per_fec_nacimiento) {
        this.per_fec_nacimiento = per_fec_nacimiento;
    }

   
    
}