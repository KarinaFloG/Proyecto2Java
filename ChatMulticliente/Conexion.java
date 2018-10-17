import java.net.*;
import java.io.*;

public class Conexion extends Thread{
	static Integer id = 0;
	private Socket cliente;

	public Conexion(Socket c){ //Recibimos el socket cliente
		this.cliente = c; // lo guardamos
		id++; //aumentamos el id de la conexion
		setName(id.toString()); //renombramos el hilo
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
				System.out.println("Cliente " +getName() + ": " + cadena); //imprimimos en pantalla
				if(cadena.equals("adios")){ // sale del ciclo infinito
					break;
				}

				salida.write("Servidor [ " + cadena + "]\r\n"); // se lo regresamos al cliente /r retorno de carro
				salida.flush();
			}

			//cierra flujos
			salida.close();
			entrada.close();
			//cierra clliente
			cliente.close();
		}catch(IOException ioe){
			System.out.println(ioe);
		}
	}
}