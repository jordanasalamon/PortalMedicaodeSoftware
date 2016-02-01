package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class PortalItem extends PersistentObjectSupport implements Comparable<PortalItem>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(max = 150)
	private String name;
	@Lob
	@Column( length = 100000 )
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int compareTo(PortalItem arg0) {
		if (name == null) return 1;
		if (arg0.name == null) return -1;
		int cmp = name.compareTo(arg0.name);
	    if (cmp != 0)   return cmp;
	    return uuid.compareTo(arg0.uuid);
	}
	
	

}
