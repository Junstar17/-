package 백준;
import java.util.Scanner;

public class LineExam2 {

	public static String getHexToDec(String hex) {
		   long v = Long.parseLong(hex, 16);   
		   return String.valueOf(v);
		 }
	public static int dec(String hex){
		 String[] temp = hex.split("0x");
		 StringBuffer dec = null;
		 for(String strArr : temp){
			 dec = new StringBuffer();
			 dec.append(strArr);
		 }
		 return Integer.parseInt(dec.toString(), 16);
	 }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String canvas= sc.nextLine();
		String[] size =canvas.split(":")[1].split("x");
		String sizeX=size[0].trim();
		String sizeY=size[1].trim();
		//String BackColor= getHexToDec(sc.nextLine().split(":")[1].trim());
		int BackColor= dec(sc.nextLine().split(":")[1].trim().replaceFirst("0x", ""));
		int numOfFrame= Integer.parseInt(sc.nextLine().split(":")[1].trim());
		String No= sc.nextLine().split(":")[1].trim();
		String[] Noarry=No.split(" ");
		
		String[] width=new String[numOfFrame];
		String[] height =new String[numOfFrame];
		int[] alpha =new int[numOfFrame];
		String[] duration=new String[numOfFrame];
		String[] total=new String[numOfFrame];
		for(int i=0 ; i<numOfFrame ; i++) {
			String entity= sc.nextLine().split(":")[1].trim();
			String[] entity_arr=entity.split(" ");
			width[i]=entity_arr[0];
			height[i]=entity_arr[1];
			if(entity_arr[2].equals("yes"))
				alpha[i]=1;
			else
				alpha[i]=0;
			duration[i]=entity_arr[3];
			total[i]=width[i]+"x"+height[i]+", "+duration[i]+", "+alpha[i];
		}
		System.out.println(sizeX);
		System.out.println(sizeY);
		System.out.println(BackColor);
		System.out.println(numOfFrame);
		for(int i=0 ; i<numOfFrame ; i++) {
			System.out.println(total[i]);
		}
	}

}
