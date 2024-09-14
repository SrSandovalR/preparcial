package codigo.basedeDatos.Model;

import java.sql.Timestamp;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private Timestamp fechaRegistro;

    // Constructores
    public Usuario() {}

    public Usuario(int id, String nombre, String email, Timestamp fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Timestamp getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Timestamp fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}

