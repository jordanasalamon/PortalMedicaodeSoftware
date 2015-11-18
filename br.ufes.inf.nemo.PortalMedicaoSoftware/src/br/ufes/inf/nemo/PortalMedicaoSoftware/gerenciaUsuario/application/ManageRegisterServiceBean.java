package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence.UserDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageRegisterServiceBean extends CrudServiceBean<User> implements
		ManageRegisterService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private UserDAO userDAO;
	
	@Override
	public BaseDAO<User> getDAO() {
		return userDAO;
	}

	@Override
	protected User createNewEntity() {
		return new User();
	}

	@Override
	public User register(String name, String email, String username, String password) {
		try {
			User newUser = new User();
			newUser.setName(name);
			newUser.setEmail(email);
			newUser.setUsername(username);
			newUser.setPassword(password);
			if(this.userDAO.retrieveAll().isEmpty()){
				newUser.setIsAdmin(true);
			}
			else{
				newUser.setIsAdmin(false);
			}
			return newUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
