package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Publication extends PortalItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Title;
	private Date Year;
	private String Filepath;
	private String Reference;
	private String Abstract;
	private Boolean isByNemo;
	private PublicationType Type;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Author> Authors;
	
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
	public PublicationType getType() {
		return Type;
	}
	public void setType(PublicationType type) {
		Type = type;
	}
	public Set<Author> getAuthors() {
		return Authors;
	}
	public void setAuthors(Set<Author> Authors) {
		this.Authors = Authors;
	}
	public Boolean getIsByNemo() {
		return isByNemo;
	}
	public void setIsByNemo(Boolean isByNemo) {
		this.isByNemo = isByNemo;
	}
		
	
}
