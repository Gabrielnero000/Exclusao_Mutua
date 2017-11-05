
//Exlusão mútua com int compartilhado
//ID 0 associadon a um processo e ID 1 associado ao outro processo
//Apenas o ID da vez pode ser executado, depois altera para o outro ID
//FALHA: Deadlock quando um thread espera que o outro thread altere o ID

package ExlusaoMutua._2_IntID;

public class MyLock extends Thread {
	
	Lock lock;
	int n;
	int id;
	
	public MyLock(Lock lock, int n, int id){
		this.lock = lock;
		this.n= n;
		this.id = id;
	}
	
	public void run() {
		while (true) {
			lock.requestCS(id);
			//Inicio da seção critica

            System.out.println("Entrando na seção...");
            System.out.println("teste " + n);
            // CASO DE FALHA
            //try {Thread.sleep(200); }catch (Exception e){}
            System.out.println("Saindo na seção...");

            //Fim da Seção Crítica
			lock.releaseCS(id);
		}
	}
	
	public static void main (String[] args) {
		Lock lock = new LockImpl();
		MyLock L1 = new MyLock(lock, 0, 0);
		MyLock L2 = new MyLock(lock, 1, 1);
		Thread t1 = new Thread(L1);
        Thread t2 = new Thread(L2);
		t1.start();
		t2.start();
	}
}
