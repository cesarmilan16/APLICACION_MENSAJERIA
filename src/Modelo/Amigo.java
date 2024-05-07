package Modelo;

public class Amigo extends Persona {
    private String username;


    public Amigo(String username, String nombre, String apellido) {
        super(nombre, apellido);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void imprimirAmigo() {
        System.out.println("Username: " + username);
        super.escribirDatos();
    }
}