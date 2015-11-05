package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Tool  extends PersistentObjectSupport{
	
	private static final long serialVersionUID = 1L;
	private String Name;
	private String Description;
	private String Link;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}
	
}
