package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Local
public interface UserDAO extends BaseDAO<User> {

	public User retrieveByUsername(String username);
}
