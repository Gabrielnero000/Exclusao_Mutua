// Algoritmo de Bakery para exclusão mútua.
// Utiliza um array de ints como fixas de atendimento, onde o menor numero é atendido primeiro
// Funciona para N processos.

package ExlusaoMutua._7_Bakery;

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
            System.out.println("Saindo na seção...\n");

            //Fim da Seção Crítica
			lock.releaseCS(id);
			// CASO DE FALHA:
			// try {Thread.sleep(200 + id*500);} catch (InterruptedException e) {}
		}
	}
	
	public static void main (String[] args)
	{
		int nproc = 10;						// Quantidade de processos
		Thread[] threads = new Thread[nproc];
		MyLock[] myLocks = new MyLock[nproc];

		Lock lock = new LockImpl(nproc);

		for(int p = 0; p < nproc; p++)		//Inicia threads
		{
			myLocks[p] = new MyLock(lock, p);
			threads[p] = new Thread(myLocks[p]);
			threads[p].start();
		}
    }
}
