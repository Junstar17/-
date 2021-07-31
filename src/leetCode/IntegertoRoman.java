package leetCode;

public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 1994;
		System.out.println(intToRoman(num));
	}

	   public static  String intToRoman(int num) {
	        
		   StringBuilder builder = new StringBuilder();
		   
		   while(num /10 !=0 || num%10 !=0) {
			  if(num >= 1000) {
				  int value = num /1000;
				  num = num%1000;
				  for(int i=0; i< value ; i++) {
					  builder.append("M");
				  }
			  }else if(num >=100) {
				  int value = num / 100;
				  num = num%100;
				  if(value == 9) {
					  builder.append("CM");
				  }else if(value >=5) {
					  int sub = value -5 ;
					  builder.append("D");
					  for(int i=0; i<sub ; i++) {
						  builder.append("C");
					  }
				  }else if(value == 4) {
					  builder.append("CD");
				  }else {
					  for(int i=0; i<value ; i++) {
						  builder.append("C");
					  }
				  }
			  }
			  else if(num >=10) {
				  int value = num / 10;
				  num = num%10;
				  if(value == 9) {
					  builder.append("XC");
				  }else if(value >=5) {
					  int sub = value -5 ;
					  builder.append("L");
					  for(int i=0; i<sub ; i++) {
						  builder.append("X");
					  }
				  }else if(value == 4) {
					  builder.append("XL");
				  }else {
					  for(int i=0; i<value ; i++) {
						  builder.append("X");
					  }
				  }
			  }else {
				  int value = num;
				  num = 0;
				  if(value == 9) {
					  builder.append("IX");
				  }else if(value >=5) {
					  int sub = value -5 ;
					  builder.append("V");
					  for(int i=0; i<sub ; i++) {
						  builder.append("I");
					  }
				  }else if(value == 4) {
					  builder.append("IV");
				  }
				  else {
					  for(int i=0; i<value ; i++) {
						  builder.append("I");
					  }
				  }
			  }
		   }
		   return builder.toString();
	    }
}
