/**
 * 
 */
package hackerrank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.santhosh.hackerrank.algorithm.codinginterview.ArrayLeftRotation;

/**
 * @author santhosh
 *
 */
public class TestArrayLeftRotation {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.santhosh.hackerrank.algorithm.codinginterview.ArrayLeftRotation#arrayLeftRotation(int[], int, int)}.
	 */
	@Test
	public void testArrayLeftRotationForArrayWithSingleElement() {
		int[] inputArray= new int[]{1};
		int[] outputArray=ArrayLeftRotation.arrayLeftRotation(inputArray, 1, 1);
		Assert.assertArrayEquals(inputArray,outputArray);
	}
	
	@Test
	public void testArrayLeftRotationForArrayWithElementsEqualRotation() {
		int[] inputArray= new int[]{1,2,3,4};
		int[] outputArray=ArrayLeftRotation.arrayLeftRotation(inputArray, 4, 4);
		Assert.assertArrayEquals(inputArray,outputArray);
	}
	
	@Test
	public void testArrayLeftRotationForArrayWithElementsWithKHalfN() {
		int[] inputArray= new int[]{1,2,3,4};
		int[] expectedOutputArray=new int[] {3,4,1,2};
		int[] outputArray=ArrayLeftRotation.arrayLeftRotation(inputArray, 4, 2);
		Assert.assertArrayEquals(expectedOutputArray,outputArray);
	}
	
	
   

}
