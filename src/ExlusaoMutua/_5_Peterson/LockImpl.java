package ExlusaoMutua._5_Peterson;

public class LockImpl implements Lock {
	
	boolean wantCS[] = {false, false}; // Booleans que indicam a intensão de entrar na seção crítica
	
	volatile int turn  = 1; // Indica de quem é a vez executar a seção crítica
	
	public void requestCS(int id){

		int otherId = 1 - id; 						// ID do outro processo
		wantCS[id] = true; 							// Quero entrar na seção crítica
		turn = otherId;								// Passa a vez para o seguinte (o seguinte desbloqueia este)
		while (wantCS[otherId] && turn == otherId); // Enquanto o outro quer entrar e é a vez do outro, espere
	}
	
	public void releaseCS(int id){
		wantCS[id] = false;					// Concluí a seção crítica
	}
}
