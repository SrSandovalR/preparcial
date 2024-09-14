package codigo.basedeDatos.Service;

import codigo.basedeDatos.Dao.UsuarioDao;
import codigo.basedeDatos.Model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioService {
    private final UsuarioDao usuarioDao = new UsuarioDao();

    public void crearUsuario(Usuario usuario) throws SQLException {
        usuarioDao.create(usuario);
    }

    public Usuario obtenerUsuario(int id) throws SQLException {
        return usuarioDao.read(id);
    }

    public List<Usuario> obtenerTodosUsuarios() throws SQLException {
        return usuarioDao.readAll();
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        usuarioDao.update(usuario);
    }

    public void eliminarUsuario(int id) throws SQLException {
        usuarioDao.delete(id);
    }
}
