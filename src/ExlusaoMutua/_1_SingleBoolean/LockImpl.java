package ExlusaoMutua._1_SingleBoolean;

public class LockImpl implements Lock{
    boolean busy = false; //Informa se alguém está na seção critica

    public void requestCS() {
        while (busy){ //Enquanto alguém está na seção critica, espere
            busy = true; //Entrei na seção crítica
        }
    }

    public void releaseCS() {
        busy = false; //Saí da seção crítica
    }
}
