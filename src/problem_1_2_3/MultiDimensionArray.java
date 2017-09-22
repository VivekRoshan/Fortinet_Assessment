/**
 * Resolution: We try to calculate the sum of the multi-dimensional array by adding the elements one after the other.
 * getValue(int...) helps to retrieve the elements one after the other and add up to sum variable.
 * variable of the the getValue() is an array which has the length equal to number of dimesions.
 * Ex: if the array is 2D, return a[indexOfDimension[0]][indexOfDimension[1]];
 * if the array is 3D, return a[indexOfDimension[0]][indexOfDimension[1]][indexOfDimension[2]];
 * The procedure is, lets take a 3D array, the initial value retrieved is getValue(0,0,0).
 * Now it is added to the sum and the last value is incremented, ie.. getValue(0,0,1) till sizeArray[i]<=lengthOfDimension[i]
 * Then, it is capped back to 0 and the element beside it is incremented.
 * Procedure: lets consider a 3D matrix with 2*2*2, the size array would be (000),(001),(010),(011),(100),(101),(110),(111).
 * 
 * Time Complexity: N-> Number of elements in the multi-dimensional array
 * 
 * Space Complexity: O(N+k) N-> Number of elements (No temporary multi-array created) k-> No of dimesnions.
 * only space extra created is temporary variable sum and SizeofArray(k).
 */
package problem_1_2_3;



public class MultiDimensionArray {

	static long[][] a; //as an example
	public MultiDimensionArray(long[][] a ) {
	this.a = a;
	}
	// This is a provided function, Assume it works
	//dummy stub for testing
    public static Long getValue(int... indexOfDimension) {
        return a[indexOfDimension[0]][indexOfDimension[1]];
    }

   
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static long sum(MultiDimensionArray mArray, int[] lengthOfDimension){
    	if(lengthOfDimension == null)
    		return 0;
    	if(lengthOfDimension.length == 0)
    		return 0;
    	long sum=0;
    	int[] sizeArray= new int[lengthOfDimension.length];
    	while(true){
    		int temp=0;
    		int i=lengthOfDimension.length-1;
    		sum=sum + getValue(sizeArray);
    		sizeArray[i]+=1;
    		while(sizeArray[i]==lengthOfDimension[i])
    		{
    			if(i==0){
    			temp=1;
    			break;
    		}
    		sizeArray[i]=0;
    		sizeArray[i-1]++;
    		i--;
    		}
    		if(temp==1){
    			break;
    		}
    	}
    return sum;
    	} 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lengthOfDeminsion = {4,4};
		long[][] a ={{1,2,34,5},{2,3,44,55},{122,345,6,7},{11,22,33,44} };
		MultiDimensionArray array = new MultiDimensionArray(a);
		System.out.println(array.sum(array, lengthOfDeminsion));
	}

}
