package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;
import br.ufes.inf.nemo.PortalMedicaoSoftware.util.Authorship;
import br.ufes.inf.nemo.PortalMedicaoSoftware.util.Type;

@Entity
public class Publication extends PersistentObjectSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Title;
	private Date Year;
	private String Filepath;
	private String Reference;
	private String Abstract;
	private Authorship Authorship;
	private Type Type;
	private HashSet<Author> Authors;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Date getYear() {
		return Year;
	}
	public void setYear(Date year) {
		Year = year;
	}
	public String getFilepath() {
		return Filepath;
	}
	public void setFilepath(String filepath) {
		Filepath = filepath;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Authorship getAuthorship() {
		return Authorship;
	}
	public void setAuthorship(Authorship authorship) {
		Authorship = authorship;
	}
	public Type getType() {
		return Type;
	}
	public void setType(Type type) {
		Type = type;
	}
	public HashSet<Author> getAuthors() {
		return Authors;
	}
	public void setAuthors(HashSet<Author> Authors) {
		this.Authors = Authors;
	}
		
	
}
