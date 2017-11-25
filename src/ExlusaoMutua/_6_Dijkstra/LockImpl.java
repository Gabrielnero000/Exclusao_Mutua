package ExlusaoMutua._6_Dijkstra;

public class LockImpl implements Lock {
	
	volatile  int[] status; // Status dos processos: 0 se ocioso,
							//						 1 se desejar entrar na CS,
							//						 2 se estiver dentro da CS.

	volatile int turn, nproc; // De quem é a vez e numero de processos (predefinido).

	public LockImpl(int n){
		nproc = n;						// Numero máximo de processos.
		turn = 0;						// Vez do primeiro processo.
		status = new int[n];			// Inicializa status dos processos, uma celula para cada.
		for (int i = 0; i < n; i++){    // Seta todos pos processos como 0.
			status[i] = 0;
		}
	}
	
	public void requestCS(int id){
		int j;

		do{
			status[id] = 1;											// Processo ID quer entrar
			while (turn != id)										// Enquanto não for a vez de ID...
				if(status[turn] == 0)								// Se o processo da vez não quer entrar na CS...
					turn = id;										// Passa a vez para ID.
			status[id] = 2;											// Processo ID está na CS.
			j = 0;
			while ((j < nproc) && ((j == id) || (status[j] != 2)))	// Caso haja mais alguém na CS, espere.
				j++;
		}while (j != nproc);										// Se algum status além de ID estiver na CS, comece de novo.
	}
	
	public void releaseCS(int id){
		status[id] = 0;					// Concluí a seção crítica
	}
}
