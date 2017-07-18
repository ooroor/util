package net.barakiroth.oorutil;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import com.google.common.collect.Lists;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

/**
 * Utilities pertinent to arrays.
 */
public class ArrUt {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
	////
	//// END nested classes and enums
	//// =======================================================================
	////
	//// S T A T I C
	//// =======================================================================
	//// BEGIN static variables
	//// =======================================================================
	//// BEGIN static public variables
	////
	////
	//// END static public variables
	//// =======================================================================
	//// BEGIN static protected variables
	////
	////
	//// END static protected variables
	//// =======================================================================
	//// BEGIN static package variables
	////
	////
	//// END static package variables
	//// =======================================================================
	//// BEGIN static private variables
	////
	/**
	 * For logging purposes, e.g. to file.
	 */
	@SuppressWarnings("unused")
	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(ArrUt.class);
	////
	//// END static private variables
	//// =======================================================================
	//// END static variables
	//// =======================================================================
	////
	//// I N S T A N C E
	//// =======================================================================
	//// BEGIN instance variables
	//// =======================================================================
	//// BEGIN instance public variables
	////
	////
	//// END instance public variables
	//// =======================================================================
	//// BEGIN instance protected variables
	////
	////
	//// END instance protected variables
	//// =======================================================================
	//// BEGIN instance package variables
	////
	////
	//// END instance package variables
	//// =======================================================================
	//// BEGIN instance private variables
	////
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** Returns a new array with duplicates removed.
	 * E.g.: [1, 2, 3, 1, 1, 2, 2, 3, 2, 3, 2, 3, 1] => [1, 2, 3]
	 * @param arr The array in which duplicates are to be removed
	 * @param templArr An empty array of elements of the type T.
	 * Used to produce a new result array.
	 * TODO: This is the best I could get up with, scrutinise this!
	 * @param <T> The type of the elements in the array.
	 * @return The array as passed as a parameter minus duplicated elements.
	 */
	 public static <T> T[] removeDuplicates(T[] arr, T[] templArr) {
		 final List<T> lst = Lists.newArrayList(arr);
		 final Set<T> set = new LinkedHashSet<T>(lst);
		 final T[] newArr = set.toArray(templArr);

		 return newArr;
	 }

	/** Returns a new array with duplicates removed.
	 * E.g.: [1, 2, 3, 1, 1, 2, 2, 3, 2, 3, 2, 3, 1] => [1, 2, 3]
	 * May only be used from templatized contexts, ref. the unit test
	 * for this method.
	 * @param arr The array in which duplicates are to be removed
	 * @param <T> The type of the elements in the array.
	 * @return The array as passed as a parameter minus duplicated elements.
	 */
	 public static <T> T[] removeDuplicates(T[] arr) {
		 final List<T> lst = Lists.newArrayList(arr);
		 final Set<T> set = new LinkedHashSet<T>(lst);
		 @SuppressWarnings("unused")
		 final Object[] newArr = set.toArray();
		 @SuppressWarnings("unchecked")
		 final T[] newArr2 = (T[])set.toArray();

		 return newArr2;
	 }

	/** Shuffle the elements of the array.
	 * @param array The array to be shuffled.
	 * @param random The instance of {@link Random} to be used in the shuffling.
	 * @param <T> The type of the elements in the array to shuffle. 
	 */
	public static <T> void shuffle(final T[] array, final Random random) {
		int index;
		T temp;
	    for (int i = array.length - 1; i > 0; i--) {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }	
	}

	/** Returns <code>true</code> if the 
	 * array passed contains a value 
	 * equalling the parameter val.
	 * @param arr The array in which to find a value equalling val.
	 * @param val The value to look for in the array passed.
	 * @param <T> The type of the elements in the array.
	 * @return Whether the value was found in the array passed or not.
	 */
	public static <T> boolean contains(final T[] arr, final T val) {

		if (arr == null) {
			throw new NullPointerException("The parameter arr cannot be null");
		}

		boolean contains = false;
		for(final T arrVal : arr) {

			if (arrVal == null) {
				contains = val == null;
			} else {
				contains = arrVal.equals(val);
			}

			if (contains) {
				break;
			}
		} // END for

		return contains;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/