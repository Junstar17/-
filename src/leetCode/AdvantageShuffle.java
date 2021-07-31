package leetCode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvantageShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(advantageCount(new int[] {9,1,2,4,5}, new int[] {6,2,9,1,4}));
System.out.println("");
	}

	public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
      int arr[][] = new int[A.length][2];
      Arrays.sort(A);
      for(int i=0;i<n;i++)
      {
          arr[i][0] = B[i];
          arr[i][1] = i;
      }
      Arrays.sort(arr,(int l1[],int l2[])->{
         return Integer.compare(l1[0],l2[0]); 
      });
      int i=0;
      int ans[] = new int[n];
      for(int j = 0;j<n;j++)
      {
          if(A[j]>arr[i][0])
          {   
              ans[arr[i][1]] = A[j];
              A[j] = -1;
              ++i;
          }
      }
      
      for(int j=0;j<n;j++)
      {
          if(A[j]!=-1)
          {
              ans[arr[i][1]] = A[j];
              ++i;
          }
      }
      return ans;
  }
 public static int[] advantageCount3(int[] A, int[] B) {
		 int[] A_array = A.clone();
		List<Integer> B_array =Arrays.stream(B).boxed().collect(Collectors.toList());
		 
		 Arrays.sort(A_array);
		 B_array.sort(Comparator.reverseOrder());
		 
		 int first = 0;
		 int last = A.length-1;
		 
		while(first < last) {
			 int A_value  = A_array[last];
			 int B_value = B_array.get(first);
			 
			 if(B_value < A_value) {
				 A_array[last] = A_array[first];
				 A_array[first] = A_value;
				 
				 last--;
			 }else {
				 if(last < A.length-1) {
					 int last_value = A_array[A.length-1];
					 A_array[A.length-1] = A_array[first];
					 A_array[first] = last_value;
				 }
				
			 }
			 first++;
		 }

		int[] result = new int[A.length];
		for(int i=0; i < result.length ; i++) {
			int b = B[i];
			int idx = B_array.indexOf(b);
			result[i] = A_array[idx];
		}
		return result;
		 
	 }
	// 오답
	 public static int[] advantageCount2(int[] A, int[] B) {
	        
		 Arrays.sort(A);
		 
		 for(int i= 0 ; i<A.length-1 ; i++) {
			 int value = A[i];
			 int compare = B[i];
			 
			 if(value <= compare) {
				 int next_value = A[i+1];
				 int currentIdx = i+1;
				 int initIdx = 0;
				 while(initIdx <= A.length) {
					 
					 if(next_value <= compare) {
						 initIdx++;
						 if(initIdx <= A.length -1) {
							 next_value = A[initIdx];	 
						 }else {
							 break;
						 }
						 	 
					 }else {
						 if(initIdx < currentIdx) {
							 if(A[i] > B[initIdx] && A[initIdx] > B[i]) {
								 A[initIdx] = A[i];
									A[i] = next_value;
									break;
							 }
						 }else {
							 A[initIdx] = A[i];
								A[i] = next_value;
								break;
						 }
						
					 }
				 }
			 }
		 }
		 return A;
    }
	
	 
}
