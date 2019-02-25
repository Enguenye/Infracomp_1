package Caso1;

import java.util.ArrayList;

public class Buffer {

	private static int tama�o;

	private static ArrayList<Mensaje> listaDeMensajes = new ArrayList<Mensaje>();

	/**
	 * Inicializa el buffer con su capacidad
	 * @param tama�o Capacidad del buffer.
	 */
	public Buffer(int tama�o)
	{
		this.tama�o = tama�o; 
	}
	
	public int darNumMensajes()
	{
		return listaDeMensajes.size();
	}

	/**
	 * Recibe el mensaje de un cliente.
	 */
	public synchronized void recibirMensaje(Mensaje mensaje)
	{
		while(listaDeMensajes.size() >= tama�o)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		listaDeMensajes.add(mensaje);
	}
	/**
	 * Cuando hay un Thread disponible lee el mensaje.
	 */
	public synchronized void leerMensaje()
	{
		Mensaje mensaje = listaDeMensajes.remove(0);
		mensaje.marcarComoLeido();
		mensaje.notify();
	}

}
