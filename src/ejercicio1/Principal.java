package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
		Archivo archivo = new Archivo();
		archivo.setRuta("archivos/Personas.txt");
		
		//Punto B
		try {
			TreeSet<Persona> listPersonas = archivo.leer_lineas();
			
			for(Persona p : listPersonas) {
				System.out.println(p.toString());
			}
		
			//Punto C
			Archivo archivo2 = new Archivo();
			archivo2.setRuta("archivos/Resultado.txt");
			if (!archivo2.existeArchivo()) {
				archivo2.crearArchivo();
			} 
			
			Iterator<Persona> it = listPersonas.iterator();
			while (it.hasNext()) {
				Persona p = it.next();
				archivo2.escribirArchivo(p.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
