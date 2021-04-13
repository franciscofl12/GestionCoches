package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import main.Controlador;
import model.entities.Cliente;
import model.entities.Venta;

public class VentaControlador extends Controlador {

	private static VentaControlador controlador = null;

	public VentaControlador () {
		super(Venta.class, "VentaDeVentas");
	}
	
	/**
	 * 
	 * @return
	 */
	public static VentaControlador getControlador () {
		if (controlador == null) {
			controlador = new VentaControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Venta find (int id) {
		return (Venta) super.find(id);
	}

	
	/**
	 * 
	 * @return
	 */
	public Venta findFirst () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Venta c order by c.id", Venta.class);
			Venta resultado = (Venta) q.setMaxResults(1).getSingleResult();
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
	public Venta findLast () {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Venta c order by c.id desc", Venta.class);
			Venta resultado = (Venta) q.setMaxResults(1).getSingleResult();
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
	public Venta findNext (Venta c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Venta c where c.id > :idActual order by c.id", Venta.class);
			q.setParameter("idActual", c.getId());
			Venta resultado = (Venta) q.setMaxResults(1).getSingleResult();
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
	public Venta findPrevious (Venta c) {
		try {
			EntityManager em = getEntityManagerFactory().createEntityManager();
			Query q = em.createQuery("SELECT c FROM Venta c where c.id < :idActual order by c.id desc", Venta.class);
			q.setParameter("idActual", c.getId());
			Venta resultado = (Venta) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	/**
	 * 
	 * @param Venta
	 * @return
	 */
	public boolean exists(Venta Venta) {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		
		boolean ok = true;
		try {
			Query q = em.createNativeQuery("SELECT * FROM tutorialjavaVentas.Venta where id = ?", Venta.class);
			q.setParameter(1, Venta.getId());
			Venta = (Venta) q.getSingleResult(); 
		}
		catch (NoResultException ex) {
			ok = false;
		}
		em.close();
		return ok;
	}
	
	
	
	public List<Venta> findAllVentas () {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT v FROM Venta v", Venta.class);
		List<Venta> resultado = (List<Venta>) q.getResultList();
		em.close();
		return resultado;
	}
	

	
	public static String toString (Venta Venta) {
		return Venta.getId() + " " + Venta.getCliente() + " - " + Venta.getPrecioVenta()  + " - " + Venta.getCoche()  + " - " + Venta.getConcesionario()  + " - " + Venta.getFecha(); 
	}

	public void modify(Venta actual) {
		
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(actual);
		em.getTransaction().commit();
		em.close();
		
	}

	

}
