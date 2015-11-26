package dominio.jpa;

import javax.persistence.*;

public class EMF {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("redesocial");
	
	public static EntityManagerFactory get() {
		return emf;
	}

}
