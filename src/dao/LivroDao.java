package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entitys.Livro;


public class LivroDao {
	
	public void insertLivro(Livro livro) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
	
	
	public void removeLivro(Livro livro) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");

		EntityManager manager = factory.createEntityManager();

		livro = manager.find(Livro.class, livro.get_id());
		try {
			manager.getTransaction().begin();
			manager.remove(livro);
			manager.getTransaction().commit();
		} finally {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		manager.close();
		factory.close();
	}
	
	public Livro findByID(String id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		Livro livro = (Livro) manager.createQuery(
				"select livro from Livro livro where id = '" + id + "'").getSingleResult();
		manager.close();
		factory.close();
		return livro;
	}
	
	public Livro findByNome(String nome) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		Livro livro = (Livro) manager.createQuery(
				"select livro from Livro livro where nome = '" + nome + "'").getSingleResult();
		manager.close();
		factory.close();
		return livro;
	}
	
	public Livro findByGenero(String genero) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("postgre");
		EntityManager manager = factory.createEntityManager();
		Livro livro = (Livro) manager.createQuery(
				"select livro from Livro livro where genero = '" + genero + "'").getSingleResult();
		manager.close();
		factory.close();
		return livro;
	}
}
