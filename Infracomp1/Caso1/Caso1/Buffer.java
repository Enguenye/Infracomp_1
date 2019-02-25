package Caso1;

import java.util.ArrayList;

public class Buffer {

	private static int tamaño;

	private static ArrayList<Mensaje> listaDeMensajes = new ArrayList<Mensaje>();

	/**
	 * Inicializa el buffer con su capacidad
	 * @param tamaño Capacidad del buffer.
	 */
	public Buffer(int tamaño)
	{
		this.tamaño = tamaño; 
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
		while(listaDeMensajes.size() >= tamaño)
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
