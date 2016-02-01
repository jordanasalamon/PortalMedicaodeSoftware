package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class User extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Email;
	private String Username;
	@Size(max = 10)
	private String Password;
	private boolean isAdmin;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
}
