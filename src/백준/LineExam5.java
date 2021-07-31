package 백준;
import java.util.Scanner;

public class LineExam5 {
	public final static int RIGHT = 2;
	public final static int ALL = 1;
	public final static int LEFT = 0;
	public final static int BOTH = 3;

	public static int[][] numberSet = { { ALL, BOTH, BOTH, BOTH, ALL }, { RIGHT, RIGHT, RIGHT, RIGHT, RIGHT },
			{ ALL, RIGHT, ALL, LEFT, ALL }, { ALL, RIGHT, ALL, RIGHT, ALL }, { BOTH, BOTH, ALL, RIGHT, RIGHT },
			{ ALL, LEFT, ALL, RIGHT, ALL }, { LEFT, LEFT, ALL, BOTH, ALL }, { ALL, RIGHT, RIGHT, RIGHT, RIGHT },
			{ ALL, BOTH, ALL, BOTH, ALL }, { ALL, BOTH, ALL, RIGHT, RIGHT } };

	/*
	 * public int[] num1= {RIGHT,RIGHT,RIGHT,RIGHT,RIGHT}; public int[] num2=
	 * {ALL,RIGHT,ALL,LEFT,ALL}; public int[] num3= {ALL,RIGHT,ALL,RIGHT,ALL};
	 * public int[] num4= {BOTH,BOTH,ALL,RIGHT,RIGHT}; public int[] num5=
	 * {ALL,LEFT,ALL,RIGHT,ALL}; public int[] num6= {LEFT,LEFT,ALL,BOTH,ALL}; public
	 * int[] num7= {ALL,RIGHT,RIGHT,RIGHT,RIGHT}; public int[] num8=
	 * {ALL,BOTH,ALL,BOTH,ALL}; public int[] num9= {ALL,BOTH,ALL,RIGHT,RIGHT};
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int count = Integer.parseInt(input.split(" ")[0]);
		String sort = input.split(" ")[1];

		int[] width_arr = new int[count];
		String[] output_arr = new String[count];

		int maxWidth = 0;
		for (int i = 0; i < count; i++) {
			String[] input_arr = sc.nextLine().split(" ");
			width_arr[i] = Integer.parseInt(input_arr[0]);
			output_arr[i] = input_arr[1];
			if (maxWidth < width_arr[i])
				maxWidth = width_arr[i];
		}

		int widths = maxWidth;
		int height = widths * 2 - 1;

		String buffer = "";
		// for(int i=0 ; i<height ; i++) {
		for (int k = 0; k < height; k++) {

			for (int m = 0; m < count; m++) {
				String number = output_arr[m];
				int each_width = width_arr[m];
				int each_height = each_width * 2 - 1;
				String[] number_arr_string = number.split("");
				int[] number_arr = new int[number_arr_string.length];
				for (int i = 0; i < number_arr_string.length; i++) {
					number_arr[i] = Integer.parseInt(number_arr_string[i]);
				}

				for (int j = 0; j < number_arr.length; j++) {
					int startLine = 0;
					if (each_height < height) {
						if (sort.equals("TOP")) {

						} else if (sort.equals("MIDDLE")) {
							startLine = (height - each_height) / 2;
						} else if (sort.equals("BOTTOM")) {
							startLine = height - each_height;
						}
					}
					int position = 0;
					if(k < startLine) {
						buffer += NullMethod(each_width);
						buffer += " ";
						continue;
					}else if (k == startLine)
						position = 0;
					else if (k < startLine + (each_height - 1) / 2)
						position = 1;
					else if (k == startLine + (each_height - 1) / 2)
						position = 2;
					else if (k == startLine + (each_height - 1))
						position = 4;
					else if (k < startLine + (each_height - 1))
						position = 3;
					else if (k > startLine + (each_height - 1)) {
						buffer += NullMethod(each_width);
						buffer += " ";
						continue;
					}

					if (numberSet[number_arr[j]][position] == LEFT)
						buffer += LeftMethod(each_width);
					else if (numberSet[number_arr[j]][position] == RIGHT)
						buffer += RightMethod(each_width);
					else if (numberSet[number_arr[j]][position] == ALL)
						buffer += AllMethod(each_width);
					else if (numberSet[number_arr[j]][position] == BOTH)
						buffer += BothMethod(each_width);

					buffer += " ";
				}
			}
			buffer += "\n";
		}

		System.out.println(buffer);
	}

	public static String RightMethod(int width) {
		String text = "";
		for (int i = 0; i < width - 1; i++) {
			text += ".";
		}
		text += "#";
		return text;
	}

	public static String LeftMethod(int width) {
		String text = "";
		text += "#";
		for (int i = 0; i < width - 1; i++) {
			text += ".";
		}
		return text;
	}

	public static String AllMethod(int width) {
		String text = "";
		for (int i = 0; i < width; i++) {
			text += "#";
		}
		return text;
	}

	public static String NullMethod(int width) {
		String text = "";
		for (int i = 0; i < width; i++) {
			text += ".";
		}
		return text;
	}

	public static String BothMethod(int width) {
		String text = "";
		text += "#";
		for (int i = 0; i < width - 2; i++) {
			text += ".";
		}
		text += "#";
		return text;
	}
}
