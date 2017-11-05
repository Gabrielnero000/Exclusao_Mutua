package ExlusaoMutua._3_TwoBooleans;
public class LockImpl implements Lock{

	volatile boolean wantCS[] = {false, false}; // Booleans associados aos IDs
												// Volatile para garantir que os valores
                                                // em todos os threads serão os mesmos (em Java)

	public void requestCS(int id) {
		wantCS[id] = true; // Quero entrar na seção crítica
		while (wantCS[1 - id]); // Enquanto eu não não sou o processo da vez, espere
	}
	
	public void releaseCS(int id) {
	    wantCS[id] = false; // Saí da seção crítica
	}
}
