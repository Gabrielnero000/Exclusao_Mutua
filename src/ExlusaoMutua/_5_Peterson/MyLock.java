// Algoritmo de Peterson para exclusão mútua.
// Simplificação do algoritmo de Dekker
// FALHA: Limitado à dois processos

package ExlusaoMutua._5_Peterson;

public class MyLock extends Thread {
	
	Lock lock;
	int id;

	public MyLock(Lock lock, int id){
		this.lock = lock;		
		this.id = id;
	}
	
	public void run()
	{
		while (true)
		{
			lock.requestCS(id);
            //Inicio da seção critica

            System.out.println("Entrando na seção...");
            System.out.println("teste " + id);
            System.out.println("Saindo na seção...");

            //Fim da Seção Crítica
			lock.releaseCS(id);
		}
	}
	
	public static void main (String[] args)
	{
		Lock lock = new LockImpl();
		MyLock L1 = new MyLock(lock, 0);
		MyLock L2 = new MyLock(lock, 1);
        Thread t1 = new Thread(L1);
        Thread t2 = new Thread(L2);
        t1.start();
        t2.start();
    }
}
