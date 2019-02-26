package Caso1;

import java.util.ArrayList;

public class Buffer {

	private static int tama�o;

	private static ArrayList<Mensaje> listaDeMensajes = new ArrayList<Mensaje>();

	private int numClientes;

	private static int numM = 0;

	/**
	 * Inicializa el buffer con su capacidad
	 * @param tama�o Capacidad del buffer.
	 */
	public Buffer(int tama�o, int numClientes)
	{
		this.tama�o = tama�o; 
		this.numClientes = numClientes;
	}

	public int darNumClientes()
	{
		return numClientes;
	}

	public int darNumMensajes()
	{
		return listaDeMensajes.size();
	}
	
	public void descontarClientes(){
		numClientes--;
	}

	/**
	 * Recibe el mensaje de un cliente.
	 */
	public void recibirMensaje(Mensaje mensaje)
	{
		synchronized (this) {
			while(listaDeMensajes.size() >= tama�o)
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized(mensaje)
		{
			listaDeMensajes.add(mensaje);
			try {
				mensaje.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}
	/**
	 * Cuando hay un Thread disponible lee el mensaje.
	 */
	public void leerMensaje()
	{
		synchronized(this)
		{
			if(listaDeMensajes.size() != 0)
			{
				Mensaje mensaje = listaDeMensajes.remove(0);
				synchronized(mensaje)
				{	
					numM++;
					System.out.println("lee mensaje" + numM);
					mensaje.marcarComoLeido();
					mensaje.notify();
				}
			}
				
				
		}	
	
	}

}
