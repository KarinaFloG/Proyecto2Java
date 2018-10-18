//Flores G. Karina Prebe 9
//Serrano S. Jorge Alejandro Prebe 13
import java.net.*;
import java.io.*;
import java.util.*;

public class Conexion extends Thread{
	static Integer id = 0;
	private Socket cliente;
	static ArrayList<String> conectados = new ArrayList<String>();

	public Conexion(Socket c){ //Recibimos el socket cliente
		this.cliente = c; // lo guardamos
		id++; //aumentamos el id de la conexion
		setName(id.toString()); //renombramos el hilo
		conectados.add(getName());
	}


	@Override
	public void run(){
		//Declaramos los flujos
		BufferedReader entrada = null; //Para leer
		OutputStreamWriter salida = null; //Para escribir

		try{
			//Para leer los datos del teclado, SOLO INSTANCIAMOS EL OBJETO, AUN NO SE USA
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); //Obtenemos nuestros flujos
			//Para escribir en la pantalla lo que contiene el flujo del socket, SOLO SE INSTANCIA
			salida = new OutputStreamWriter(cliente.getOutputStream());

			while(true){ //Ciclo infinito
				String cadena = entrada.readLine(); //leemos lo que mando el cliente
				if(cadena.equals("LIST")){
					System.out.println("Los clientes conectados son: ");
					for(int i = 0; i < conectados.size(); i++){
						System.out.println("Cliente[" + conectados.get(i) + "]");
					}
				}else if(cadena.equals("QUIT")){
					break;
				}
				System.out.println("Cliente " +getName() + ": " + cadena); //imprimimos en pantalla
				salida.write("Servidor [ " + cadena + "]\r\n"); // se lo regresamos al cliente /r retorno de carro
				salida.flush();
				
			}

			//cierra flujos
			System.out.println("Hasta luego..");
			salida.close();
			entrada.close();
			//cierra clliente
			cliente.close();
		}catch(IOException ioe){
			System.out.println(ioe);
		}
	}
}