package main;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import main.Controlador;
import model.entities.Cliente;
import model.entities.Fabricante;


public class ClienteControlador extends Controlador {

	private static ClienteControlador controlador = null;

	public ClienteControlador () {
		super(Cliente.class, "VentaDeCoches");
	}
	
	/**
	 * 
	 * @return
	 */
	public static ClienteControlador getControlador () {
		if (controlador == null) {
			controlador = new ClienteControlador();
		}
		return controlador;
	}

	/**
	 *  
	 */
	public Cliente find (int id) {
		return (Cliente) super.find(id);
	}

	
	
	public List<Cliente> findAllClientes () {
		EntityManager em = getEntityManagerFactory().createEntityManager();
		Query q = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		List<Cliente> resultado = (List<Cliente>) q.getResultList();
		em.close();
		return resultado;
	}
	

	
	public static String toString (Cliente cliente) {
		return cliente.getNombre() + " " + cliente.getApellidos(); 
	}
	
	public void modify(Cliente cliente) {
		
		EntityManager em = getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		
	}
	

}
