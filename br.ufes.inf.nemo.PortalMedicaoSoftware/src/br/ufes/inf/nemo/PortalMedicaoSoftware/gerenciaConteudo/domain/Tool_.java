package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Tool.class)
public class Tool_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Tool, String> Name;
	public static volatile SingularAttribute<Tool, String> Description;
	public static volatile SingularAttribute<Tool, String> Link;

}
