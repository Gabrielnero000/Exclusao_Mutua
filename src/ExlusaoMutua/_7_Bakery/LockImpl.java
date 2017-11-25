package ExlusaoMutua._7_Bakery;

public class LockImpl implements Lock {
	
	volatile  int[] number;       // Numero de atendimento.
	volatile boolean[] choosing;  // Associado à atribuição do numero de atendimento.
	volatile int nproc;			  // Quantidade de processos.

	public LockImpl(int n){
		nproc = n;						// Seta a quantidade máxima de processos.
		choosing = new boolean[n];		// Associado à atribuição do numero de atendimento.
		number = new int[n];			// Quantidade de numeros de atendimento.
		for (int i = 0; i < n; i++){    // Inicializa tudo como "parado".
			number[i] = 0;
			choosing[i] = false;
		}
	}
	
	public void requestCS(int id){
		choosing[id] = true;						// Inicia atribuição de numero de atendimento.
		for(int i = 0; i < nproc; i++)				// Verifica qual é o maior numero de atendimento e atrubui à ID.
			if (number[i] > number[id])
				number[id] = number[i];
		number[id]++;								// Incrementa o numero de atendimento, se tornando o maior.
		choosing[id] = false;						// Processo de atribuição acabou.
		for (int i = 0; i < nproc; i++){
			while (choosing[i]);					// Enquanto algum processo está recebendo um numero de atendimento, espere.
			while ((number[i] != 0) &&              // Enquanto ID não tiver o menor numero de atendimento, espere.
					((number[i] < number[id]) ||
					((number[i] == number[id]) && (i < id))));
		}

	}
	
	public void releaseCS(int id){
		number[id] = 0;	// Concluí a seção crítica
	}
}
