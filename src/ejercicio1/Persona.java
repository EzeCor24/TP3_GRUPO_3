package ejercicio1;

import exception.DniInvalido;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String apellido;
	private String dni;

	// M�todo verificarDniInvalido()
	public boolean verificarDniInvalido(String dni) throws DniInvalido {
		boolean contieneLetra = false;
		for (int i = 0; i < dni.length(); i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				contieneLetra = true; // Caracter
			}
			if (contieneLetra == true) {
				DniInvalido exc = new DniInvalido();
				throw exc;
			}
		}
		return contieneLetra;
	}

	// M�todo compareTo()
	@Override
	public int compareTo(Persona p) {
		//que permita ordenar los datos seg�n el Apellido desde la A � Z
		return this.apellido.compareToIgnoreCase(p.getApellido());
	}

	// M�todo hashCode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	// M�todo equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	// M�todo toString()
	@Override
	public String toString() {
		return apellido + " " + nombre + " - DNI=" + dni;
	}

	// Constructores
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	// Setters and Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}