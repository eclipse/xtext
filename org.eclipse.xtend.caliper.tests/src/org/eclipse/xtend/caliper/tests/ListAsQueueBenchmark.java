package org.eclipse.xtend.caliper.tests;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import org.eclipse.emf.common.util.BasicEList;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * Just a dummy caliper test to test the build.
 * 
 * Originally taken from {@linkplain http://blog.publicobject.com/2010/07/caliper-confirms-reality-linkedlist-vs.html}.
 * 
 * With Java6:
 * 
 * <pre>
 *  benchmark size    ns linear runtime
 *  ArrayList    0  6.11 ========
 *  ArrayList    1 12.01 ================
 *  ArrayList    2 11.67 ===============
 *  ArrayList    3 11.75 ===============
 *  ArrayList    5 12.19 ================
 *  ArrayList   10 12.15 ================
 *  ArrayList  100 20.72 ===========================
 * BasicEList    0  4.59 ======
 * BasicEList    1 12.86 =================
 * BasicEList    2 12.49 ================
 * BasicEList    3 12.70 =================
 * BasicEList    5 12.90 =================
 * BasicEList   10 13.47 ==================
 * BasicEList  100 22.39 ==============================
 * LinkedList    0 12.57 ================
 * LinkedList    1 10.76 ==============
 * LinkedList    2 11.26 ===============
 * LinkedList    3 11.29 ===============
 * LinkedList    5 11.33 ===============
 * LinkedList   10 11.31 ===============
 * LinkedList  100 11.26 ===============
 * ArrayDeque    0  4.76 ======
 * ArrayDeque    1  4.63 ======
 * ArrayDeque    2  4.59 ======
 * ArrayDeque    3  4.60 ======
 * ArrayDeque    5  4.59 ======
 * ArrayDeque   10  4.59 ======
 * ArrayDeque  100  4.35 =====
 * </pre>
 * 
 * @author Sebastian Zarnekow - Adding case for BasicEList
 */
public final class ListAsQueueBenchmark extends SimpleBenchmark {

	@Param({ "0", "1", "2", "3", "5", "10", "100" })
	int size;

	private final ArrayList<String> arrayList = new ArrayList<String>();
	private final BasicEList<String> basicEList = new BasicEList<String>();
	private final LinkedList<String> linkedList = new LinkedList<String>();
	private final Deque<String> arrayDeque = new ArrayDeque<String>();

	@Override
	protected void setUp() throws Exception {
		for (int i = 0; i < size; i++) {
			arrayList.add("A");
			basicEList.add("A");
			linkedList.add("A");
			arrayDeque.add("A");
		}
	}

	public void timeArrayList(int reps) {
		for (int i = 0; i < reps; i++) {
			arrayList.add("A");
			arrayList.remove(0);
		}
	}

	public void timeBasicEList(int reps) {
		for (int i = 0; i < reps; i++) {
			basicEList.add("A");
			basicEList.remove(0);
		}
	}

	public void timeLinkedList(int reps) {
		for (int i = 0; i < reps; i++) {
			linkedList.add("A");
			linkedList.remove(0);
		}
	}

	public void timeArrayDeque(int reps) {
		for (int i = 0; i < reps; i++) {
			arrayDeque.addLast("A");
			arrayDeque.removeFirst();
		}
	}

	public static void main(String[] args) {
		Runner.main(ListAsQueueBenchmark.class, args);
	}

}