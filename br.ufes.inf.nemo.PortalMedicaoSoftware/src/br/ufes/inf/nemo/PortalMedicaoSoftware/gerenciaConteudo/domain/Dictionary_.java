package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Dictionary.class)
public class Dictionary_ extends PersistentObjectSupport_ {

	public static volatile SetAttribute<Dictionary, Term> Terms;

}
