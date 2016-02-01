package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageUsersService extends CrudService<User> {

	public User login(String username, String password) throws Exception;
	public User getAdmin() throws Exception;
}
