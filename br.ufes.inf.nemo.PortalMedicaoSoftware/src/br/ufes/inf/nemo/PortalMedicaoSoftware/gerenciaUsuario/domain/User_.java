package br.ufes.inf.nemo.PortalMedicaoSoftware.gerenciaUsuario.domain;

import br.ufes.inf.nemo.util.ejb3.persistence.PersistentObjectSupport_;
import javax.persistence.metamodel.*;

@StaticMetamodel(User.class)
public class User_ extends PersistentObjectSupport_ {

	public static volatile SingularAttribute<User, String> Name;
	public static volatile SingularAttribute<User, String> Email;
	public static volatile SingularAttribute<User, String> Login;
	public static volatile SingularAttribute<User, String> Password;
	public static volatile SingularAttribute<User, Boolean> isAdmin;
}
