package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Dictionary.class)
public class Dictionary_ extends PortalItem_ {

	public static volatile SetAttribute<Dictionary, Term> terms;

}
