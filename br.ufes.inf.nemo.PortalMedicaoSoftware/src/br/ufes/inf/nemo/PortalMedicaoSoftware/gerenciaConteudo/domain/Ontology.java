package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Ontology extends PersistentObjectSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Name;
	private String Description;
	private String Filepath;
	private String Link;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getFilepath() {
		return Filepath;
	}
	public void setFilepath(String filepath) {
		Filepath = filepath;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}	
	
}
