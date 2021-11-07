package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private final static int MAXRANGE = 2_000;
	private final static int MINRANGE = 1_000;
	private final static int ELEMS = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int NTIMES = 1_000;
	
	//Continents
	private final static long AFRICA = 1_110_635_000;
	private final static long AMERICAS = 972_005_000;
	private final static long ANTARCTICA = 0;
	private final static long ASIA = 4_298_723_000L;
	private final static long EUROPE = 742_452_000;
	private final static long OCEANIA = 38_304_000;
	
	private static long addElementsFindTime(List<Integer> list, int elems) {
    	long time = System.nanoTime();
    	
    	for (int i = 0; i <= elems; i++) {
            list.add(i);
        }
    	
    	return time = System.nanoTime() - time;
    }
	
	private static long readMiddleElemFindTime(List<Integer> list, int ntimes) {
		long time = System.nanoTime();
		
		for (int i = 0; i < ntimes; i++) {
    		list.get(list.size()/2);
    	}
		
		return time = System.nanoTime() - time;
	}
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> arrayList = new ArrayList<>();
    	
    	for (int i = MINRANGE; i < MAXRANGE; i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final List<Integer> linkedList = new LinkedList<>(arrayList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final var temp = arrayList.get(0);
    	arrayList.set(0, arrayList.get(arrayList.size()-1));
    	arrayList.set(arrayList.size()-1, temp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for (final var i : arrayList) {
    		System.out.println(i);
    	}
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	System.out.println("It required " + addElementsFindTime(arrayList, ELEMS) / TO_MS 
    						+ " ms to add " + ELEMS + " elements into ArrayList");
    	
    	System.out.println("It required " + addElementsFindTime(linkedList, ELEMS) / TO_MS 
				+ " ms to add " + ELEMS + " elements into LinkedList");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	System.out.println("It required " + readMiddleElemFindTime(arrayList, NTIMES) / TO_MS 
    						+ " ms to read " + NTIMES + " times the middle element of the ArrayList");
    	
    	System.out.println("It required " + readMiddleElemFindTime(linkedList, NTIMES) / TO_MS 
				+ " ms to read " + NTIMES + " times the middle element of the LinkedList");
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	
    	final Map<String, Long> map = new HashMap<>();
    	
    	map.put("Africa", AFRICA);
    	map.put("Americas", AMERICAS);
    	map.put("Antarctica", ANTARCTICA);
    	map.put("Asia", ASIA);
    	map.put("Europe", EUROPE);
    	map.put("Oceania", OCEANIA);
    	
        /*
         * 8) Compute the population of the world
         */
    }
}
