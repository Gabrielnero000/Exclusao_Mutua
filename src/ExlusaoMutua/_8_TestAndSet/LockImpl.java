package ExlusaoMutua._8_TestAndSet;

public class LockImpl implements Lock {

	private TSL flag = new TSL();
	
	public void requestCS(){
		while (flag.testAndSet());
	}
	
	public void releaseCS(){
		flag.unlock();
	}
}
