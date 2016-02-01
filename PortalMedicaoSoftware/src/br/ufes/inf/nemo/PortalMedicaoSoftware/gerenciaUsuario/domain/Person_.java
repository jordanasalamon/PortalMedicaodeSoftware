package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;

@StaticMetamodel(Person.class)
public class Person_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<Person, String> Name;
}
