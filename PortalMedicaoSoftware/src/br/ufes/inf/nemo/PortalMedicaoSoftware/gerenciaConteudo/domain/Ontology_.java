package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Ontology.class)
public class Ontology_ extends PortalItem_ {

	public static volatile SingularAttribute<Ontology, String> filepath;
	public static volatile SingularAttribute<Ontology, String> link;
}
