package dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import jpaControllers.UsuarioNormalJpaController;
import jpaControllers.exceptions.NonexistentEntityException;
import modelo.UsuarioNormal;
import dao.interfaces.IUsuarioNormalDAO;

/**
 *
 * @author marlon
 */
public class UsuarioNormalDAO implements IUsuarioNormalDAO {
    
    private UsuarioNormalJpaController usuarioNormalJpaController;

    public UsuarioNormalDAO() {
        this.usuarioNormalJpaController = new UsuarioNormalJpaController(Persistence.createEntityManagerFactory("BlogPU"));
    }

    @Override
    public UsuarioNormal obtenerUsuarioNormalPorId(Long id) {
        return this.usuarioNormalJpaController.findUsuarioNormal(id);
    }

    @Override
    public List<UsuarioNormal> obtenerUsuariosNormales() {
        return this.usuarioNormalJpaController.findUsuarioNormalEntities();
    }

    @Override
    public void crearUsuarioNormal(UsuarioNormal usuario) {
        this.usuarioNormalJpaController.create(usuario);
    }

    @Override
    public void editarUsuarioNormal(UsuarioNormal usuario) {
        try {
            this.usuarioNormalJpaController.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioNormalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarUsuarioNormal(Long id) {
        try {
            this.usuarioNormalJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(UsuarioNormalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
