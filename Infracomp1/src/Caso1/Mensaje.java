package Caso1;

public class Mensaje {
	
	private int contenido;
	
	/**
	 * Crea un nuevo mensaje con su contenido
	 * @param contenido Contenido del mensaje.
	 */
	public Mensaje(int contenido)
	{
		this.contenido = contenido;
	}
	
	public void marcarComoLeido()
	{
		contenido++;
	}

}
