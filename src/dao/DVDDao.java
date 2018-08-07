package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entitys.DVD;
import entitys.Livro;

public class DVDDao {

	public void insertDVD(DVD dvd) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AcervoDB");
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
	
	public void removeDVD(DVD dvd) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("AcervoDB");

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
}
