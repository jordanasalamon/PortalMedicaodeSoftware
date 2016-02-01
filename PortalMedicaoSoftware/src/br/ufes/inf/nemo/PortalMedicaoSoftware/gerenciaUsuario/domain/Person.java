package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Person extends PersistentObjectSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(max = 150)
	private String Name;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
