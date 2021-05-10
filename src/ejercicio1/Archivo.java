package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

import exception.DniInvalido;

public class Archivo {
	private String ruta;

	//Constructores
	public Archivo() {
		super();
	}
	
	public Archivo(String ruta) {
		super();
		this.ruta = ruta;
	}

	//Métodos
	public boolean existeArchivo() {
		File archivo = new File(ruta);
		if(archivo.exists()) {
			return true;
		}
		return false;
	}
	
	public boolean crearArchivo() {
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void escribirArchivo(String input){
		try{
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(input + "\n");
			miBuffer.close();
			entrada.close();	
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public TreeSet<Persona> leer_lineas() {
		TreeSet<Persona> listPersonas = new TreeSet<Persona>();
		Persona persona = new Persona();
		FileReader entrada;
		try{
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = miBuffer.readLine();
			while(linea != null){
				persona = separarCampos(linea);
				if (persona != null) {
					try {
						persona.verificarDniInvalido(persona.getDni());
						listPersonas.add(persona);
					}catch (DniInvalido e) {
						System.out.println("Se descarto a " + persona.toString() + ". " + e);
					}
				}
				linea = miBuffer.readLine();
			}
			miBuffer.close();
			entrada.close();
		
		}catch(IOException e){
			System.out.println("No se encontro el archivo");
		}catch(Exception e) {
			System.out.println("Error " + e);
		}
		return listPersonas;
	}
	
	private Persona separarCampos(String linea) {
		if (!linea.equals("")) {
			Persona persona = new Persona();
			String[] p = linea.split("-");
			persona.setNombre(p[0]);
			persona.setApellido(p[1]);
			persona.setDni(p[2]);
			return persona;
		}
		else {
			return null;
		}
	}

	//Getters and Setters
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
}