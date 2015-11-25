package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import javax.persistence.metamodel.*;

@StaticMetamodel(User.class)
public class User_ extends Person_ {

	public static volatile SingularAttribute<User, String> Email;
	public static volatile SingularAttribute<User, String> Username;
	public static volatile SingularAttribute<User, String> Password;
	public static volatile SingularAttribute<User, Boolean> isAdmin;
}
