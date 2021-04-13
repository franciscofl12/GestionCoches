package model.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import main.Entidad;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private boolean activo;

	private String apellidos;

	private String dniNie;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNac;

	private String localidad;

	private String nombre;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="cliente")
	private List<Venta> ventas;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDniNie() {
		return this.dniNie;
	}

	public void setDniNie(String dniNie) {
		this.dniNie = dniNie;
	}

	public String getFechaNac() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(fechaNac);
		return strDate;
	}

	public void setFechaNac(String fechaNac) { 
		Date fechaNacDate = null;
		try {
			fechaNacDate = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		this.fechaNac = fechaNacDate;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setCliente(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setCliente(null);

		return venta;
	}

	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos;
	}
	
	
	

}