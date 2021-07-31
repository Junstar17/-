package 백준;
import java.util.Scanner;

public class LineExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] result = new int[10];
		int realIdx=0;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int numOfClient = Integer.parseInt(input.split("\\|")[0]);
		String time = input.split("\\|")[1];
		int hour = Integer.parseInt(time.split(":")[0]);
		int minute = Integer.parseInt(time.split(":")[1]);
		int second = Integer.parseInt(time.split(":")[2]);
		int realTime = hour*3600 + minute *60 + second;
		
		int[] clientTime_arr=new int[numOfClient];
		String[] clientType_arr=new String[numOfClient];
		String[] clientTask_arr=new String[numOfClient];
		int[] clientId_arr=new int[numOfClient];
		
		for(int i=0 ; i<numOfClient ; i++) {
			realIdx=i;
			String[] client_info = sc.nextLine().split("\\|");
			String[] time_temp = client_info[0].split(":");
			int hour_temp = Integer.parseInt(time_temp[0]);
			int minute_temp = Integer.parseInt(time_temp[1]);
			int second_temp = Integer.parseInt(time_temp[2]);
			int realTime_temp= hour_temp*3600 + minute_temp *60 + second_temp;
			clientTime_arr[i]=realTime_temp;
			if(realTime_temp>realTime) {
				System.out.println("");
				break;
			}
			clientType_arr[i]=client_info[1];
			clientTask_arr[i]=client_info[2];
			clientId_arr[i]=Integer.parseInt(client_info[3]);
			
		}
		for(int i=0  ; i<realIdx ; i++) {
			if(clientType_arr[i].equals("I")) {
				result[clientId_arr[i]]=1;
			}else {
				result[clientId_arr[i]]=0;
			}
		}
		for(int i=0; i<10 ;i++)
			System.out.println(i+" "+result[i]);
		
	}

}
