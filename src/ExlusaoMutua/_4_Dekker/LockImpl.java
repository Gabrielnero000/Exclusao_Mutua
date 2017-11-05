package ExlusaoMutua._4_Dekker;
public class LockImpl implements Lock{
	
	boolean wantCS[] = {false, false}; // Booleans que indicam a intensão de entrar na seção crítica
	
	volatile int turn  = 1; // Indica de quem é a vez executar a seção crítica
	
	public void requestCS(int id){

		int otherId = 1 - id; 				// ID do outro processo
		wantCS[id] = true; 					// Quero entrar na seção crítica
		while (wantCS[otherId]){ 			// Enquanto o outro processo estiver querendo entrar na seção crítica
			if (turn == otherId){ 			// Caso seja a vez do outro processo...
				wantCS[id] = false;			// Eu desisto de entrar agora...
				while (turn  == otherId);	// Até que o outro execute a seção critica...
				wantCS[id] = true;			// E volto a querer entrar na seção crítica
			}
		}
	}
	
	public void releaseCS(int id){
		turn = 1 - id;						// Passa a vez para o outro processo
		wantCS[id] = false;					// Concluí a seção crítica
	}
}
