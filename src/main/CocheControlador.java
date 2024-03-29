package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import main.Controlador;
import model.entities.Cliente;
import model.entities.Coche;

public class CocheControlador extends Controlador {

	private static CocheControlador controlador = null;

	public CocheControlador () {
		super(Coche.class, "VentaDeCoches");
	}
	
	/**
	 * 
	 * @return
	 */
	public static CocheControlador getControlador () {
		if (controlador == null) {
			controlador = new CocheControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Coche find (int id) {
		return (Coche) super.find(id);
	}

	
	/**
	 * 
	 * @return
	 */
	public Coche findFirst () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Coche c order by c.id", Coche.class);
			Coche resultado = (Coche) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Coche findLast () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Coche c order by c.id desc", Coche.class);
			Coche resultado = (Coche) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Coche findNext (Coche c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Coche c where c.id > :idActual order by c.id", Coche.class);
			q.setParameter("idActual", c.getId());
			Coche resultado = (Coche) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Coche findPrevious (Coche c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Coche c where c.id < :idActual order by c.id desc", Coche.class);
			q.setParameter("idActual", c.getId());
			Coche resultado = (Coche) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	/**
	 * 
	 * @param coche
	 * @return
	 */
	public boolean exists(Coche coche) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		
		boolean ok = true;
		try {
			Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche where id = ?", Coche.class);
			q.setParameter(1, coche.getId());
			coche = (Coche) q.getSingleResult(); 
		}
		catch (NoResultException ex) {
			ok = false;
		}
		em.close();
		return ok;
	}
	
	
	
	public List<Coche> findAllCoches () {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Coche c", Coche.class);
		List<Coche> resultado = (List<Coche>) q.getResultList();
		em.close();
		return resultado;
	}
	

	
	public static String toString (Coche coche) {
		return coche.getFabricante() + " " + coche.getModelo() + " - " + coche.getBastidor(); 
	}

	public void modify(Coche actual) {
		
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(actual);
		em.getTransaction().commit();
		em.close();
		
	}

	

}
