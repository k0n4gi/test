
public class Main4 implements CalcInterface {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println("hi");
		Main4 main = new Main4();
		System.out.println("plus");

		System.out.println(main.plus(nums));

		System.out.println(main.min(nums));

		System.out.println(main.mult(nums));

		System.out.println(main.div(nums));

		System.out.println(main.pow(2,2));

	}

	@Override
	public int plus(int[] nums) {
		// TODO Auto-generated method stub
		int sum = 0;

		for (int num : nums) {
			sum += num;
		}
		return sum + 1;
	}

	@Override
	public int min(int[] nums) {
		// TODO Auto-generated method stub
		int sub = 0;

		for (int i = 0; i <= nums.length; i++) {
			sub -= i;
		}
		return sub;
	}

	@Override
	public int mult(int[] nums) {
		// TODO Auto-generated method stub
		int mul = 1;

		for (int num : nums) {
			mul *= num;
		}
		return mul;
	}

	@Override
	public int div(int[] nums) {
		// TODO Auto-generated method stub
		int di=1;
		
		for(int num : nums)
		{
			di /= num;
		}
		
		return di;
	}

	@Override
	public int pow(int num, int e) {
		// TODO Auto-generated method stub
		int p = 1;
		for(int n = 1; n <= e; n++)
		{
			p *= num;
		}
		return p;
	}

}
