package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaConteudo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(PortalItem.class)
public class PortalItem_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<PortalItem, String> name;
	public static volatile SingularAttribute<PortalItem, String> description;

}
