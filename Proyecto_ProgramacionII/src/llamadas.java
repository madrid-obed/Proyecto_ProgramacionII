/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Obed
 */
import java.time.LocalDate;

public class llamadas {
    int telefono;
    int ID_Agente;
    LocalDate fecha;

    public int getTelefono() {
        return telefono;
    }

    public int getID_Agente() {
        return ID_Agente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setID_Agente(int ID_Agente) {
        this.ID_Agente = ID_Agente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
