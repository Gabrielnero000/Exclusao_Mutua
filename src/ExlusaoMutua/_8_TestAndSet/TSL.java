package ExlusaoMutua._8_TestAndSet;

public class TSL {
    private boolean locked = false;

    public boolean testAndSet(){
        boolean temp = locked;
        if(!locked)
            locked = true;
        return temp;
    }
    public void unlock(){
        locked = false;
    }
}
