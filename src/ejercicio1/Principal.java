package ejercicio1;

import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import exception.DniInvalido;

public class Principal {

	public static void main(String[] args) {
		
		//Punto A
		String dni = JOptionPane.showInputDialog("Ingrese un número");
		Persona per = new Persona();
		try {
			if(!per.verificarDniInvalido(dni)) {
				System.out.println("DNI correcto: " + dni);
			}
		} catch (DniInvalido e1) {
			e1.printStackTrace();
		}
		
		Archivo archivo = new Archivo();
		// archivo.setRuta("archivos/Personas.txt");
		archivo.setRuta("archivos/Personas2.txt");

		//Punto B
		try {
			//lista que no acepte datos duplicados
			TreeSet<Persona> listPersonas = archivo.leer_lineas();
			Archivo archivo2 = new Archivo();
			archivo2.setRuta("archivos/Resultado.txt");
			if (archivo2.existeArchivo()) {
				System.out.println("Existe archivo");
			} else {
				System.out.println("Se va a crear el archivo.");
				archivo2.crearArchivo();
			}

			//que permita ordenar los datos según el Apellido desde la A – Z
			Persona[] listaOrdenada = listPersonas.toArray(new Persona[0]);
			//Arrays.sort(listaOrdenada);
			Persona aux;
			for(int i = 0; i < listaOrdenada.length;i++) {
				for(int i2 = 0; i2 < listaOrdenada.length;i2++) {
					if(listaOrdenada[i].compareTo(listaOrdenada[i2])==1) {
						aux = listaOrdenada[i];
						listaOrdenada[i] = listaOrdenada[i2];
						listaOrdenada[i2] = aux;
					}
				}
			}
			for(Persona p : listaOrdenada) {
				System.out.println(p.toString());
			}
			
			/*Iterator<Persona> it = listPersonas.iterator();
			while (it.hasNext()) {
				Persona p = it.next();
				archivo2.escribirArchivo(p.toString());
				System.out.println(p.toString());
			}*/
		} catch (DniInvalido e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
