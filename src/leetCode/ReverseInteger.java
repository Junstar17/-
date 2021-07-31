package leetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(9646324351L));
	}	
	public static int reverse(long x) {
        
		int flag = x >0 ? 1 : -1;
		
		char[] numbers = String.valueOf(Math.abs(x)).toCharArray();
		StringBuilder builder = new StringBuilder();
		for(int i=numbers.length-1 ; i>=0 ; i--) {
			builder.append(numbers[i]);
		}
		long result_long = Long.parseLong(builder.toString()) * flag;
		int result = result_long > Integer.MAX_VALUE || result_long< Integer.MIN_VALUE? 0 : (int)result_long;
		
		return result;
    }

}
