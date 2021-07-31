package 백준;

public class Click {

	public  static boolean preSucceed;
	public static boolean clickSucced() {
		if (preSucceed == false) {
	        preSucceed = true;
	    } else {
	        preSucceed = false;
	    }

	    return preSucceed;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;
		int N=100;
		boolean[] click=new boolean[N];
		for(int i=0 ; i<N ; i++)
			click[i]=false;
		int n_click=0;
		while(n_click<90) {
			result++;
			for(int j=0 ; j<N ;j++) {
				if(click[j]==false) {
					boolean succeed=clickSucced();
					click[j]=succeed;
					
					if(succeed==true)
						n_click++;
				}
			}
		}
		System.out.println(result);
	}

}
