package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.persistence.metamodel.*;

@StaticMetamodel(Ontology.class)
public class Ontology_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Ontology, String> Name;
	public static volatile SingularAttribute<Ontology, String> Description;
	public static volatile SingularAttribute<Ontology, String> Filepath;
	public static volatile SingularAttribute<Ontology, String> Link;
}
