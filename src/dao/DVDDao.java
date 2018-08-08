package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitys.DVD;

public class DVDDao {

	public void insert(DVD dvd) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(dvd);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
	
	public void remove(DVD dvd) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");

		EntityManager manager = factory.createEntityManager();

		dvd = manager.find(DVD.class, dvd.get_id());
		try {
			manager.getTransaction().begin();
			manager.remove(dvd);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
	
	public DVD findByID(String id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		DVD dvd = (DVD) manager.createQuery(
				"select dvd from DVD dvd where id = '" + id + "'").getSingleResult();
		manager.close();
		factory.close();
		return dvd;
	}
	
	public DVD findByNome(String nome) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		DVD dvd = (DVD) manager.createQuery(
				"select dvd from DVD dvd where nome = '" + nome + "'").getSingleResult();
		manager.close();
		factory.close();
		return dvd;
	}
}
