package problem_1_2_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiDimensionArrayTest {

	@Test
	public void testSum() {
		int[] lengthOfDeminsion = {4,4};
		long[][] a ={{1,2,34,5},{2,3,44,55},{122,345,6,7},{11,22,33,44} };
		MultiDimensionArray array = new MultiDimensionArray(a);
		assertEquals(736,array.sum(array, lengthOfDeminsion));
	}

}
