import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente{
	public static void main(String[] args) {
		int puerto = 15000;
		String ip = "192.168.1.169";

		BufferedReader entrada = null;
		PrintWriter salida = null;
		Scanner sc = new Scanner(System.in);
		Socket sock = null;

		try{
			sock = new Socket(ip, puerto);
			//Para leer los datos del teclado
			entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			//Para escribir en la pantalla lo que contiene el flujo del socket
			salida = new PrintWriter(sock.getOutputStream(), true);

			while(true){
				//Lee del teclado
				String cadena = sc.nextLine();
				//Si lo que ingresa el cliente es igual a adios, para el flujo del programa y lo desconecta
				if(cadena.equals("adios")){
					salida.println(cadena);
					break;
				}

				salida.println(cadena);
				System.out.println(entrada.readLine());
			} 
		}catch(IOException ioe){
			System.out.println(ioe);
		}
	}
}