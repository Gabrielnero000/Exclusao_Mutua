
// Exlusão mútua com boolean compartilhado
// True se alguem está na seção crítica, False caso contrário
// FALHA: caso um dos threads durma dentro da seção crítica,
//        o outro thread entra

package ExlusaoMutua._1_SingleBoolean;

public class MyLock extends Thread{

    Lock lock;
    int n;

    public MyLock(Lock lock, int n){
        this.lock = lock;
        this.n= n;
    }

    public void run() {
        while (true) {
            lock.requestCS();
            //Inicio da Seção Crítica

            System.out.println("Entrando na seção...");
            System.out.println("teste " + n);
            // CASO DE FALHA
            //try {Thread.sleep(200); }catch (Exception e){}
            System.out.println("Saindo na seção...");

            //Fim da Seção Crítica
            lock.releaseCS();
        }
    }

    public static void main (String[] args) {
        Lock lock = new LockImpl();
        MyLock L1 = new MyLock(lock, 0);
        MyLock L2 = new MyLock(lock, 2);
        Thread t1 = new Thread(L1);
        Thread t2 = new Thread(L2);
        t1.start();
        t2.start();
    }
}
