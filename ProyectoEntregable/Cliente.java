//Flores G. Karina Prebe 9
//Serrano S. Jorge Alejandro Prebe 13
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente{
	public static void main(String[] args) {
		int puerto = 15000;
		String ip = "192.168.1.71";
		int bandera = 0;
		String ban = "abierta";
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
				if(cadena.equals("ADD")){
					ban = "abierta";
					while(ban.equals("abierta")){
						cadena = sc.nextLine();
						if(cadena.equals("QUIT")){
							salida.println(cadena);
							//bandera = 1;
							break;
						}


						salida.println(cadena);
						System.out.println(entrada.readLine()); 
					}

				}else{
					System.out.println("Intenta con add");
					ban = "cerrada";
				}




/**				if(cadena.equals("QUIT")){
					salida.println(cadena);
					//bandera = 1;
					break;
				} **/






				//Si lo que ingresa el cliente es igual a adios, para el flujo del programa y lo desconecta
		/**		if(cadena.equals("QUIT")){
					salida.println(cadena);
					bandera = 1;
					//break;
				}

				salida.println(cadena);
				System.out.println(entrada.readLine());	
					/**salida.println(cadena);
					System.out.println(entrada.readLine());**/


	/**			salida.println(cadena);
				System.out.println(entrada.readLine()); **/
			} 
		}catch(IOException ioe){
			System.out.println(ioe);
		}
	}
}