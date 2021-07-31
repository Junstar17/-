package 백준;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class LineExam1 {

	public static double getDistance(int x, int y, int x1, int y1) {

		return Math.sqrt(Math.pow(Math.abs(x1 - x), 2) + Math.pow(Math.abs(y1 - y), 2));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int round = sc.nextInt();
		
		sc.nextLine();

		// int x[] = new int[101];
		// int y[] = new int[101];
		
		int x = 0;
		int y = 0;
		
		// List<Culr<Integer,String>> list = new ArrayList<Culr<Integer,String>>();
		// Culr<Integer, String> culr= new Culr<Integer,String>(0,"");
		String vicArr[] = new String[round];
		for (int i = 0; i < round; i++) {
			int numOfStone = sc.nextInt();
			String victory = "";
			int vicNum = 0;
			double[] Browndistance = new double[1001];
			double[] Conydistance = new double[1001];
			int brownCnt = 0;
			int conyCnt = 0;
			for(int n=0 ; n<1001 ; n++) {
				Browndistance[n]=Conydistance[n]=2000;
			}
			for (int j = 0; j < numOfStone; j++) {
				x = sc.nextInt();
				y = sc.nextInt();
				String teamName = sc.nextLine().trim();
				if (teamName.equals("Brown")) {
					Browndistance[brownCnt++] = getDistance(0, 0, x, y);
				} else {
					Conydistance[conyCnt++] = getDistance(0, 0, x, y);
				}
			}
			Arrays.sort(Browndistance);
			Arrays.sort(Conydistance);
			if (Browndistance[0] < Conydistance[0]) {
				victory = "Brown";
				for (int k = 0; k < brownCnt; k++) {
					if (Browndistance[k] < Conydistance[0])
						vicNum++;
				}

			} else {
				victory = "Cony";
				for (int k = 0; k < conyCnt; k++) {
					if (Conydistance[k] < Browndistance[0])
						vicNum++;
				}
			}
			vicArr[i]=victory + " " + vicNum;
		}
		for(int i=0 ; i<round ;i++) {
			System.out.println(vicArr[i]);
		}
	}

}
