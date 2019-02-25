package Caso1;

public class ServidorThread extends Thread{
	
	private Buffer buffer;
	
	public ServidorThread(Buffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void run()
	{
		while(buffer.darNumMensajes() == 0)
		{
			Thread.yield();
		}
		buffer.leerMensaje();
	}

}
