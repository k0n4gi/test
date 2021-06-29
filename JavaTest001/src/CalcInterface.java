
public interface CalcInterface {

	/**
	 *  nums의 모든 합
	 * @param nums
	 * @return
	 */
	int plus(int[] nums);
	/**
	 * nums의 모든 차
	 * @param nums
	 * @return
	 */
	int min(int[] nums);
	/**
	 * nums의 모든 곱
	 * @param nums
	 * @return
	 */
	int mult(int[] nums);
	/**
	 * nums의 모든 나누기
	 * @param nums
	 * @return
	 */
	int div(int[] nums);
	/**
	 * num의 e제곱
	 * @param num
	 * @param e
	 * @return
	 */
	int pow(int num, int e);
	
}
