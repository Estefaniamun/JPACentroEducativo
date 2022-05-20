package modelo.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SuperControlador {
	
	protected static EntityManager createEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");
		return entityManagerFactory.createEntityManager();
	}

}
