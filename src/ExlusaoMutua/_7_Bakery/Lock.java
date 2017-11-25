package ExlusaoMutua._7_Bakery;

public interface Lock {
	public void requestCS(int id);
	public void releaseCS(int id);
}
