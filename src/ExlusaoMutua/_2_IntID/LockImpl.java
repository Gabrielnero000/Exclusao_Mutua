package ExlusaoMutua._2_IntID;

public class LockImpl implements Lock{

    int turn = 0; // Indica qual processo pode entrar

    public void requestCS(int id) {
        while (turn == 1-id); // Enquanto eu não sou o processo da vez, espere
    }

    public void releaseCS(int id) {
        turn = 1 - id; // Troca o processo da vez
    }
}
