
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class llamadas {
    int telefono;
    int ID_Agente;
    String tipoLlamada;
    LocalDate fecha;
    LocalDateTime fechaInicio;
    LocalDateTime fechaFin;
    public String getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }
    
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
    
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Duration getDuracion() {
        if (fechaInicio != null && fechaFin != null) {
            return Duration.between(fechaInicio, fechaFin);
        }
        return Duration.ZERO;
    }

    public String getDuracionFormateada() {
        Duration duracion = getDuracion();
        long minutos = duracion.toMinutes();
        long segundos = duracion.minusMinutes(minutos).getSeconds();
        return minutos + " min " + segundos + " s";
    }
    
}
