package codigo.basedeDatos.Dao;

import codigo.basedeDatos.Conexion.Conexion;
import codigo.basedeDatos.Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public void create(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, email, fecha_registro) VALUES (?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setTimestamp(3, usuario.getFechaRegistro());
            statement.executeUpdate();
        }
    }

    public Usuario read(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("fecha_registro")
                );
            }
        }
        return null;
    }

    public List<Usuario> readAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                usuarios.add(new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("fecha_registro")
                ));
            }
        }
        return usuarios;
    }

    public void update(Usuario usuario) throws SQLException {
        String query = "UPDATE usuarios SET nombre = ?, email = ?, fecha_registro = ? WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getEmail());
            statement.setTimestamp(3, usuario.getFechaRegistro());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

