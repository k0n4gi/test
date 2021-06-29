import java.util.ArrayList;

public class Main3 {
	public static void main(String[] args) {
		Main main = new Main();
		Main2 main2 = new Main2();
		
		int[] nums = {1,2,3,4,5};
		
		ArrayList<CalcInterface> array = new ArrayList();
		
		array.add(main);
		//array.add(main2);
		for(CalcInterface inter : array) {
			System.out.println(inter.plus(nums));
			
		}
		
	}
	
}
