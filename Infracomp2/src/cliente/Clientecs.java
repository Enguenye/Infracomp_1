package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Clientecs {
	public final static String SERVIDOR = "localhost";
	public static void main(String[] args) throws IOException {	
		Socket socket=null;
		PrintWriter escritor=null;
		BufferedReader lector=null;
		System.out.println("Escriba el puerto");
		Scanner consola = new Scanner(System.in);
		try {
			int puerto = consola.nextInt();
			socket = new Socket(SERVIDOR, puerto);
			escritor = new PrintWriter(socket.getOutputStream(),true);
			lector = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
		} catch (Exception e) {
			System.err.println("Error "+e.getMessage());
			System.exit(1);
		} 
		while(true) {
			
		}
		
	}
}
