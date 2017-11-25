package ExlusaoMutua._5_Peterson;

public interface Lock {
	public void requestCS(int id);
	public void releaseCS(int id);
}
