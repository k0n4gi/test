
public class Main5 implements Mud.Callback{

	public static void main(String[] args) {
		Main5 main = new Main5();
		Mud mud = new Mud(main);
		mud.print();
	}

	@Override
	public void callback() {
		// TODO Auto-generated method stub
		System.out.println("i'm Main5");
	}
	
	
}
