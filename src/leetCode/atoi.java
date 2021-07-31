package leetCode;

public class atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "  -0012a42";
		System.out.println(myAtoi(str));
	}

	public static int myAtoi(String s) {
		s= s.trim();
		int i = 0;
		int result= 0;
	    int sign =1;
	    if(s.length() ==0)
	    	return 0;
	    if(s.charAt(i) == '-' || s.charAt(i) == '+' ) {
			sign = s.charAt(i++) == '-' ? -1 : 1;
		}
		while(i < s.length() && 0 <= s.charAt(i) - '0' &&  s.charAt(i) -'0' <=9) {
			if( result >Integer.MAX_VALUE / 10 || (result==Integer.MAX_VALUE / 10 && s.charAt(i)-'0' > Integer.MAX_VALUE % 10)) {
				return sign ==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result*10 + ( s.charAt(i++) - '0');
			
		}
		return result * sign;
	 
	}
	  public static int myAtoi2(String s) {
		  boolean      isMinus = false;
		  try {
				s= s.trim();
		        char[] array = s.toCharArray();
		        StringBuilder builder= new StringBuilder();
		        boolean isStart =false;
		        boolean isAsign = false;
		   
		       
		        for(int i=0; i < array.length ; i++) {
		        	if(array[i] == 45 || array[i] == 43) {
		        		if(isStart) {
		        			break;
		        		}
		        		if(!isAsign) {
		        			if(array[i] == 45)
		        				isMinus = !isMinus;
		        			isAsign =true;
		        			isStart = true;
		        		}else {
		        			return 0;
		        		}
		        	}
		        	else if( (array[i]>=48 && array[i] <58)) {
		        		builder.append(array[i]);
		        		isStart = true;
		        	}else if(i==0) {
		        		return 0;
		        	}else {
		        		if(isStart) {
		        			break;
		        		}
	        		}
		        }
		        if(builder.toString().length()==0) {
		        	return 0;
		        }
		        long result = Long.parseLong(builder.toString());
		        
		        if(isMinus)
		        	result = result*(-1);
		        if( Integer.MAX_VALUE < result) {
		        	return Integer.MAX_VALUE;
		        }
		        else if(Integer.MIN_VALUE > result) {
		        	return Integer.MIN_VALUE;
		        }else
		        {
		        	return (int)result;
		        }
		  }catch(Exception err) {
			  if(isMinus) {
				  return Integer.MIN_VALUE;
			  }else {
				  return Integer.MAX_VALUE;
			  }
		  }
		  
	    }
}
