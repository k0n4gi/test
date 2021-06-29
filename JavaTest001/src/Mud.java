
public class Mud {
	
	
	interface Callback{
		void callback();
	}
	
	private Callback mCallback;
	
	public Mud(Object obj) {
		if(obj instanceof Callback) {
			mCallback = (Callback)obj;
		}
	}
	
	public void print() {
		System.out.println("Mud hi");
		if(mCallback != null) {
			mCallback.callback();
		}
	}
}
