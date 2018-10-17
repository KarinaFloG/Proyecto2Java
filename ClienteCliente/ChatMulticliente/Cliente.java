import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente{
	public static void main(String[] args) {
		int puerto = 15000;
		String ip = "192.168.1.71";

		BufferedReader entrada = null;
		PrintWriter salida = null;
		Scanner sc = new Scanner(System.in);
		Socket sock = null;

		try{
			//Creacion del socket 
			sock = new Socket(ip, puerto);
			//Para leer los datos del teclado
			entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			//Para escribir en la pantalla lo que contiene el flujo del socket
			salida = new PrintWriter(sock.getOutputStream(), true);

			//Empaquetar los datos
			PaqueteEnvio datos = new PaqueteEnvio();


			while(true){
				//Lee del teclado
				String cadena = sc.nextLine();
				//Si lo que ingresa el cliente es igual a adios, para el flujo del programa y lo desconecta
				if(cadena.equals("adios")){
					salida.println(cadena);
					break;
				}

				datos.setIp(ip);
				datos.setMensaje(cadena);
				//salida.println(cadena);
				//System.out.println(entrada.readLine());
				ObjectOutputStream paquete_datos = new ObjectOutputStream(sock.getOutputStream());
			} 
		}catch(IOException ioe){
			System.out.println(ioe);
		}
	}
}