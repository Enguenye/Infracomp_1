package Caso1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[])
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./data/param"));
			int tamBuffer = Integer.parseInt(reader.readLine().split("=")[1]);
			int numClientes = Integer.parseInt(reader.readLine().split("=")[1]);
			int numServidores = Integer.parseInt(reader.readLine().split("=")[1]);
			Buffer buffer = new Buffer(tamBuffer, numClientes);
			for (int i = 0; i < numServidores; i++) {
				ServidorThread s = new ServidorThread(buffer);
				s.start();
			}
			for (int i = 0; i <numClientes; i++) {
				int numPet = Integer.parseInt(reader.readLine().split("=")[1]);
				ClienteThread c = new ClienteThread(numPet,buffer);
				c.start();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
