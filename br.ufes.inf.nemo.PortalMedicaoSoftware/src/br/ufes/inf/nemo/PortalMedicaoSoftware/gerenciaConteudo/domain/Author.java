package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Author  extends PersistentObjectSupport{
	
	private static final long serialVersionUID = 1L;
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
}
