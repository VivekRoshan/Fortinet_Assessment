
/**Resolution: (separate(list,k)) -> Here we use the technique of backtracking to fill the partitions.
 * We keep an array, where array[i] represents the current sum of the i'th partition and a boolean
 * array to keep tract of which elements have already been taken to a partition.
 * separate method validates the given list and passes the list to a recursive method,
 * which tries to add array element into some subset. If sum of this subset reaches required sum, 
 * we iterate for next part recursively, otherwise we backtrack for different set of elements. 
 * If number of subsets whose sum reaches the required sum is (K-1), we flag that it is possible
 *  to partition array into K parts with equal sum, because remaining elements already have a sum equal to required sum.
 * 
 * Time Complexity: The worst case time complexity for this method is N*K where N = length of list; K = no. of partitions.
 * Space Complexity: O(2N+K) N- size of list ; K - partitions required.
 * given list -n ; subsetsum - k list; boolean array - n: Total 2N+K 
 */

package problem_1_2_3;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KSubSets {
	//main method to test the functionality.
	public static void main(String[] args) 
	
	{
	    KSubSets kSubSets = new KSubSets();
	    List<Integer> list = new ArrayList<>();
	    list.add(2);list.add(1);list.add(5);list.add(4);list.add(3);list.add(3);
	    System.out.println(kSubSets.separate(list, 3));
	}

	//  Method returns true if list be partitioned into K subsets
	// with equal sum
	public boolean separate(List<Integer> list, int k){
		    
		if(list == null)
			return false;
		if(k == 0 || list.size() == 0)
	    	return false;

		
		int N = list.size();
		
		 //  If K is 1, then complete array will be our answer
		if (k == 1)
	        return true;

	    //  If total number of partitions are more than N, then
	    // division is not possible
	    if (N < k)
	        return false;
	    
	    
	    // if array sum is not divisible by K then we can't divide
	    // array into K partitions
	    int sum = 0;
	    for (int i = 0; i < N; i++)
	        sum += list.get(i);
	    if (sum % k != 0)
	        return false;

	    //  the sum of each subset should be subset (= sum / K)
	    int subset = sum / k;
	    int subsetSum[] = new int[k];
	    boolean taken[] = new boolean[N];

	    //  Initialize sum of each subset from 0
	    for (int i = 0; i < k; i++)
	        subsetSum[i] = 0;

	    //  mark all elements as not taken
	    for (int i = 0; i < N; i++)
	        taken[i] = false;

	    // initialize first subset sum as last element of
	    // array and mark that as taken
	    subsetSum[0] = list.get(N - 1);
	    taken[N - 1] = true;
	    if (subset < subsetSum[0])
	        return false;

	    //  call recursive method to check K-partition condition
	    return seperateRec(list, subsetSum, taken,
	                                     subset, k, N, 0, N - 1);
		}
	
	// Recursive Utility method to check K equal sum
		// partitions of list
		/**
		    list           - given input list
		    subsetSum array   - sum to store each subset of the array
		    taken           - boolean array to check whether element
		                      is taken into sum partition or not
		    K               - number of partitions needed
		    N               - total number of element in array
		    curIdx          - current subsetSum index
		    limitIdx        - lastIdx from where array element should
		                      be taken 
		    return type - boolean(true/false)                  */
	boolean seperateRec(List<Integer> list, int subsetSum[], boolean taken[],
            int subset, int K, int N, int curIdx, int limitIdx)
	{
		if (subsetSum[curIdx] == subset)
		{
			/*  current index (K - 2) represents (K - 1) subsets of equal
     		sum last partition will already remain with sum 'subset'*/
		if (curIdx == K - 2)
			return true;

		//  recursive call for next partition
		return seperateRec(list, subsetSum, taken, subset,
                                     K, N, curIdx + 1, N - 1);
		}

		//  start from limitIdx and include elements into current partition
		for (int i = limitIdx; i >= 0; i--)
		{
			//  if already taken, continue
			if (taken[i])
				continue;
			int tmp = subsetSum[curIdx] + list.get(i);

			// if temp is less than subset then only include the element
			// and call recursively
			if (tmp <= subset)
			{
				//  mark the element and include into current partition sum
				taken[i] = true;
				subsetSum[curIdx] += list.get(i);
				boolean nxt = seperateRec(list, subsetSum, taken,
                                     subset, K, N, curIdx, i - 1);

				// after recursive call unmark the element and remove from
				// partition sum
				taken[i] = false;
				subsetSum[curIdx] -= list.get(i);
				if (nxt)
					return true;
			}
		}
		return false;
}
	@Test
	public void testseperate() {
		KSubSets sets = new KSubSets();
		List<Integer> list = new ArrayList<>();
	    list.add(2);list.add(1);list.add(5);list.add(4);list.add(3);list.add(3);
	    assertEquals(true,sets.separate(list, 3)); //true
	    assertEquals(false,sets.separate(list, 4)); //false
	    assertEquals(true,sets.separate(list, 1)); //k=1
	    assertEquals(false,sets.separate(list, 0)); //k==0
	    //n>k
	    assertEquals(false,sets.separate(list, 7));
	    //same length as list-> false
	    assertEquals(false,sets.separate(list, 6));
	    List<Integer> list1 = new ArrayList<>();
	    list1.add(2);list1.add(2);list1.add(2);list1.add(2);list1.add(2);list1.add(2);
	    //n and k are equal with->true as solution
	    assertEquals(true,sets.separate(list1, 6));
	    List<Integer> list2 = new ArrayList<>();
	    //no elements in the list
	    assertEquals(false,sets.separate(list2, 1));
	}
	}


