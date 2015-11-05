package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Term.class)
public class Term_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Term, String> Name;
	public static volatile SingularAttribute<Term, String> Description;

}
