package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageRegisterService extends CrudService<User> {

	public User register(String name, String email, String username, String password) throws Exception;
	
}
