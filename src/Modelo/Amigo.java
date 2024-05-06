package Modelo;

public class Amigo extends Usuario {
    private String nombre;
    private String apellido;
    private String username;

    public Amigo(String nombre, String apellido, String username) {
        super(nombre, apellido, username, "");
    }

    
}
