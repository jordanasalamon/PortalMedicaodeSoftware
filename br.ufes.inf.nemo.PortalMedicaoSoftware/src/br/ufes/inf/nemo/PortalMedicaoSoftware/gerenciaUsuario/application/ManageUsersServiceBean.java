package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain.User;
import br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.persistence.UserDAO;
import br.ufes.inf.nemo.util.ejb3.application.CrudServiceBean;
import br.ufes.inf.nemo.util.ejb3.persistence.BaseDAO;

@Stateless
public class ManageUsersServiceBean extends CrudServiceBean<User> implements
		ManageUsersService {

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
	public User login(String username, String password) {
		try {
			User user = userDAO.retrieveByUsername(username);
			if(user != null) {
				String passwd = user.getPassword();
				if(passwd.equals(password)){
					return user;
				}
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User getAdmin(){
		try{
			User user = userDAO.retrieveAdmin();
			if(user != null){
				return user;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
