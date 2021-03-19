package net.barakiroth.oorutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

import static java.util.stream.Collectors.toList;

/**
 * Utilities pertinent to arrays.
 */
public class ArrUt {
	/**
	 * For logging purposes, e.g. to file.
	 */
	@SuppressWarnings("unused")
	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(ArrUt.class);
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

	/**
	 * An implementation variant of #add
	 * Ref.: https://stackoverflow.com/questions/66645283/how-do-i-produce-an-array-of-arrays-of-merged-and-permuted-source-arrays-using-j
	 * @param a
	 * @return
	 */
	private static Function<List<?>, Stream<List<?>>> add1(final Object[] a) {
		return list -> Arrays.stream(a).map(
				y -> {
					final List<Object> n = new ArrayList<>(list);
					n.add(y);
					return n;
				}
		);
	}

	/**
	 * An implementation variant of #makeCartesianProduct
	 * @param arrays
	 * @return
	 */
	public static List<List<?>> makeCartesianProduct1(final Object[]... arrays) {

		Stream<List<?>> stream = Stream.of(Collections.emptyList());
		for (Object[] array : arrays)
			stream = stream.flatMap(add1(array));
		return stream.collect(toList());
	}

	private static Function<List<Object>, Stream<List<Object>>> add(final Object[] sourceArrays) {
		return
				list ->
						Arrays
								.stream(sourceArrays)
								.map(
										sourceArray -> {
											final List<Object> n = new ArrayList<>(list);
											n.add(sourceArray);
											return n;
										}
								);
	}

	/**
	 * Ref.: https://stackoverflow.com/questions/66645283/how-do-i-produce-an-array-of-arrays-of-merged-and-permuted-source-arrays-using-j
	 * @param sourceArrays
	 * @return
	 */
	public static Collection<List<Object>> makeCartesianProduct(final Object[]... sourceArrays) {
		return
				Arrays
						.stream(sourceArrays)
						.map(
								sourceArray ->
										add(sourceArray)
						)
						.reduce(
								Stream
										.of(
												Arrays.asList()
										),
								(s, p) ->
										s.flatMap(p),
								(a, b) ->
										Stream.concat(a, b)
						)
						.collect(toList());
	}

	public static Set<List<Object>> makeCartesianProductAsSet(final Object[]... sourceArrays) {
		return new HashSet<>(makeCartesianProduct(sourceArrays));
	}
}