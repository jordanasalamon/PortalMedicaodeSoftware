package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Dictionary  extends PersistentObjectSupport{
	
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Term> Terms;
	
	public Set<Term> getTerms() {
		return Terms;
	}
	public void setTerms(Set<Term> terms) {
		Terms = terms;
	}

}
