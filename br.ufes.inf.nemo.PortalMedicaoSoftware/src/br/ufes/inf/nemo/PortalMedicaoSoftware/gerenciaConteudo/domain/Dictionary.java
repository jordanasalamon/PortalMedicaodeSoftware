package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import java.util.HashSet;

import javax.persistence.Entity;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport;

@Entity
public class Dictionary  extends PersistentObjectSupport{
	
	private static final long serialVersionUID = 1L;
	private HashSet<Term> Terms;
	
	public HashSet<Term> getTerms() {
		return Terms;
	}
	public void setTerms(HashSet<Term> terms) {
		Terms = terms;
	}

}
