package ExlusaoMutua._2_IntID;

public interface Lock {
    public void requestCS(int id);
    public void releaseCS(int id);
}
