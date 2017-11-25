package ExlusaoMutua._6_Dijkstra;

public interface Lock {
	public void requestCS(int id);
	public void releaseCS(int id);
}
