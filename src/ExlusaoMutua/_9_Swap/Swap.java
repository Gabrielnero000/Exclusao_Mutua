package ExlusaoMutua._9_Swap;

public class Swap {
    private boolean value = false;

    public boolean swap(boolean newValue){
        boolean temp = value;
        value = newValue;
        return temp;
    }
}
