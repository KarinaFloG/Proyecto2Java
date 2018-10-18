//Flores G. Karina Prebe 9
//Serrano S. Jorge Alejandro Prebe 13
import java.net.*;
import java.io.*;

public class Servidor{
	public static void main(String[] args) {
		int puerto = 15000; //Declaramos el puerto por el que escucharemos
		System.out.println("Esperando...");
		ServerSocket sock = null; //Declaramos nuestro socket servidor


		try{
			sock = new ServerSocket(puerto); //Instanciamos el objeto para abrir el socket
			while(true){ //Ciclo infinito en el que se va a quedar
				//AQUI DEBE DE IR LA VALIDACION PARA EL ADD PORQUE AQUI ACEPTA LA CONEXION
				Socket cliente = sock.accept(); //En escucha de nuevos cliente
				//AQUI PODEMOS IR AGREGANDO A UNA LISTA, LOS CLIENTES QUE SE VAN CONECTANDO
				System.out.println("Nueva conexion de: " + cliente.getInetAddress()); //Vamos a ver quien se conecto
				Conexion c = new Conexion(cliente); //Hilo que va a tratar la conexion
				c.start(); //Ejecutamos el hilo
			}

		}catch(IOException ioe){
			System.err.println(ioe); //Impresion a la salida estandar de error por si algo falla
		}
	}
}