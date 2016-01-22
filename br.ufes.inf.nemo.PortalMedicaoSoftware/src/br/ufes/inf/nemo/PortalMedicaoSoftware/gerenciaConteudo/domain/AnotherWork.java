package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.Entity;

@Entity
public class AnotherWork extends PortalItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filepath;
	private String link;
	private boolean isByNemo;
	

	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean getIsByNemo() {
		return isByNemo;
	}
	public void setIsByNemo(boolean isByNemo) {
		this.isByNemo = isByNemo;
	}

	
}
