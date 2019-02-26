package Caso1;

public class ClienteThread extends Thread{
	
	private int numMensajes;
		
	private Buffer buffer;

	/**
	 * Le asina al cliente el numero de mensajes a mandar.
	 * @param numMensajes numero de mensajes que va a mandar el cliente.
	 */
	public ClienteThread(int numMensajes, Buffer buffer)
	{
		this.numMensajes = numMensajes;
		this.buffer = buffer;
	}
	
	/**
	 * Inicializa sus mensajes y los envía.
	 */
	public void run()
	{
		for(int i = 0; i < numMensajes; i++)
		{
			Mensaje m = new Mensaje(i);
			buffer.recibirMensaje(m);
		}
		buffer.descontarClientes();
	}

}
