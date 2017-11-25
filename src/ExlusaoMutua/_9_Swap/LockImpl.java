package ExlusaoMutua._9_Swap;

import ExlusaoMutua._8_TestAndSet.TSL;

public class LockImpl implements Lock {

	private Swap flag = new Swap();
	
	public void requestCS(){
		while (flag.swap(true));
	}
	
	public void releaseCS(){
		flag.swap(false);
	}
}
