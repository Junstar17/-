package leetCode;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "anagram", t = "nagaram";
		System.out.println(isAnagram(s,t));
	}
	 public static boolean isAnagram(String s, String t) {
		 if(s.length() != t.length()){
	            return false;
	        }
	        Map<Character, Integer> map  = new HashMap();
	        for(int i=0; i<s.length() ; i++) {
	        	char value = s.charAt(i);
	        	if(map.containsKey(value)) {
	        		map.put(value, map.get(value)+1);
	        	}else {
	        		map.put(value, 1);
	        	}
	        }
	        
	        for(int i=0; i<t.length(); i++) {
	        	char value = t.charAt(i);
	        	if(map.containsKey(value)) {
	        		if(map.get(value) ==0) {
	        			return false;
	        		}else {
	        			map.put(value, map.get(value) -1 );
	        		}
	        	}
	        	else {
	        		return false;
	        	}
	        }
	        return true;
    }

}
