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


    public Mensaje(String texto, Usuario de) {
        this.texto = texto;
        this.de = de;
        Calendar calendar = Calendar.getInstance();
        fechaMensaje = calendar.getTime();
        this.leido = false;
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

    public void escribirMensaje() {
        System.out.println("Mensaje de:" + de.getUsername() + " - " + de.getNombre());

        String patron = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patron);
        System.out.println("El día: " + df.format(fechaMensaje));
        System.out.println("Mensaje: " + texto);
    }
}
