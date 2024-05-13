package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mensaje {
    private String texto;
    private Usuario de;
    private Date fechaMensaje;
    private boolean leido;
    private Mensaje mensajeRespuesta;

    public Mensaje(String texto, Usuario de) {
        this.texto = texto;
        this.de = de;
        Calendar calendar = Calendar.getInstance();
        fechaMensaje = calendar.getTime();
        this.leido = false;
        this.mensajeRespuesta = null;
    }

        
    public boolean isLeido() {
        return leido;
    }

    public Usuario getDe() {
        return de;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public boolean isRespueta() {
        return mensajeRespuesta != null;
    }

    public Mensaje getRespuesta() {
        return mensajeRespuesta;
    }

    public void setRespuesta (Mensaje mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public void escribirMensaje() {
        

        String patron = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patron);
        if (isRespueta()) {
            System.out.println("-----------------------------------");
            System.out.println("Mensaje respondido:" + mensajeRespuesta.de.getUsername() + " - " + mensajeRespuesta.de.getNombre());
            System.out.println("El día: " + df.format(mensajeRespuesta.fechaMensaje));
            System.out.println("Mensaje: " + mensajeRespuesta.texto);
            System.out.println("-----------------------------------");
        }
        System.out.println("Mensaje de:" + de.getUsername() + " - " + de.getNombre());
        System.out.println("El día: " + df.format(fechaMensaje));
        System.out.println("Mensaje: " + texto);

        
    }
}
