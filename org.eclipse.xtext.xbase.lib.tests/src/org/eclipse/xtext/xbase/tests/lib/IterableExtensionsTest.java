/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Test;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Karsten Thoms - testMap, testFlatMap
 */
public class IterableExtensionsTest extends BaseIterablesIteratorsTest<Iterable<Integer>> {

	@Override
	protected Iterable<Integer>[] testData(Integer... elements) {
		@SuppressWarnings("unchecked")
		Iterable<Integer>[] result = new Iterable[] {
			Lists.newArrayList(elements),
			Lists.newLinkedList(Lists.newArrayList(elements)),
			Sets.newLinkedHashSet(Lists.newArrayList(elements)),
			Sets.newTreeSet(Lists.newArrayList(elements))
		};
		return result;
	}
	
	@Override
	protected Iterable<Integer>[] nullableTestData(Integer... elements) {
		@SuppressWarnings("unchecked")
		Iterable<Integer>[] result = new Iterable[] {
			Lists.newArrayList(elements),
			Lists.newLinkedList(Lists.newArrayList(elements)),
			Sets.newLinkedHashSet(Lists.newArrayList(elements)),
//			Sets.newTreeSet(Lists.newArrayList(elements)) null is not allowed
		};
		return result;
	}

	@Override
	protected Iterable<Integer> dummy() {
		return Collections.emptyList();
	}

	@Override
	protected boolean is(Iterable<Integer> input, Integer... elements) {
		return Iterables.elementsEqual(input, Lists.newArrayList(elements));
	}

	@Override
	protected Iterable<Integer> operator_plus(Iterable<Integer> first, Iterable<Integer> second) {
		return IterableExtensions.operator_plus(first, second);
	}

	@Override
	protected Integer findFirst(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.findFirst(input, filter);
	}

	@Override
	protected Integer findLast(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.findLast(input, filter);
	}

	@Override
	protected Integer lastOrNull(Iterable<Integer> input) {
		return IterableExtensions.lastOrNull(input);
	}

	@Override
	protected Integer head(Iterable<Integer> input) {
		return IterableExtensions.head(input);
	}
	
	@Override
	protected void forEach(Iterable<Integer> input, Procedure2<Integer, Integer> proc) {
		IterableExtensions.forEach(input, proc);
	}
	
	@Override
	protected Iterable<Integer> takeWhile(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.takeWhile(input, filter);
	}
	
	@Override
	protected Iterable<Integer> dropWhile(Iterable<Integer> input, Function1<Integer, Boolean> filter) {
		return IterableExtensions.dropWhile(input, filter);
	}
	
	@Override
	protected Integer max(Iterable<Integer> input) {
		return IterableExtensions.max(input);
	}
	
	@Override
	protected Integer max(Iterable<Integer> input, Comparator<? super Integer> comparator) {
		return IterableExtensions.max(input, comparator);
	}
	
	@Override
	protected Integer maxBy(Iterable<Integer> input, Function1<? super Integer, String> compareBy) {
		return IterableExtensions.maxBy(input, compareBy);
	}
	
	@Override
	protected Integer min(Iterable<Integer> input) {
		return IterableExtensions.min(input);
	}
	
	@Override
	protected Integer min(Iterable<Integer> input, Comparator<? super Integer> comparator) {
		return IterableExtensions.min(input, comparator);
	}
	
	@Override
	protected Integer minBy(Iterable<Integer> input, Function1<? super Integer, String> compareBy) {
		return IterableExtensions.minBy(input, compareBy);
	}
	
	@Test public void testJoinWithNull() {
		List<String> list = Lists.newArrayList("a", null, "c");
		String string = IterableExtensions.join(list, ",");
		assertEquals("a,null,c", string);
	}
	
	@Test public void testSortBy() throws Exception {
		List<? extends CharSequence> list = newArrayList("foo","bar","baz");
		List<? extends CharSequence> sorted = IterableExtensions.sortBy(list, new Functions.Function1<CharSequence, String>() {
			@Override
			public String apply(CharSequence p) {
				return p.toString();
			}
		});
		assertNotSame(list, sorted);
		assertEquals(sorted, newArrayList("bar","baz","foo"));
	}
	
	@Test public void testFilterNull() throws Exception {
		Iterator<String> iter = IterableExtensions.filterNull(newArrayList("foo", null, "bar")).iterator();
		assertEquals("foo", iter.next());
		assertEquals("bar", iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test public void testJoinWithBeforeAndAfter() throws Exception {
		ArrayList<String> list = newArrayList("foo", "bar");
		ArrayList<String> singletonList = newArrayList("foo");
		ArrayList<String> emptylist = new ArrayList<String>();
		
		final Functions.Function1<String, String> function = new Functions.Function1<String, String>() {
			@Override
			public String apply(String p) {
				return p;
			}
		};
		assertEquals("<foo,bar>", IterableExtensions.join(list, "<", ",", ">", function));
		assertEquals("<foo>", IterableExtensions.join(singletonList, "<", ",", ">", function));
		assertEquals("", IterableExtensions.join(emptylist, "<", ",", ">", function));
		
		assertEquals("foo,bar>", IterableExtensions.join(list, null, ",", ">", function));
		assertEquals("foo>", IterableExtensions.join(singletonList, null, ",", ">", function));
		assertEquals("", IterableExtensions.join(emptylist, null, ",", ">", function));
		
		assertEquals("<foobar>", IterableExtensions.join(list, "<", null, ">", function));
		assertEquals("<foo>", IterableExtensions.join(singletonList, "<", null, ">", function));
		assertEquals("", IterableExtensions.join(emptylist, "<", null, ">", function));
		
		assertEquals("<foo,bar", IterableExtensions.join(list, "<", ",", null, function));
		assertEquals("<foo", IterableExtensions.join(singletonList, "<", ",", null, function));
		assertEquals("", IterableExtensions.join(emptylist, "<", ",", null, function));
	}
	
	@Test public void testIndexed() {
		Iterator<Pair<Integer, String>> result = IterableExtensions.indexed(newArrayList("foo", "bar")).iterator();
		assertEquals(new Pair<Integer, String>(0, "foo"), result.next());
		assertEquals(new Pair<Integer, String>(1, "bar"), result.next());
		assertFalse(result.hasNext());
	}

	class A {}
	interface C {}
	class B extends A implements C {}
	class D extends A {}

	@Test public void testReject() {
		List<Integer> nullList = new ArrayList<>();
		nullList.add(null);
		List<Object> objects = newArrayList(1, 2, null, 4l, "String");
		assertEquals(newArrayList(1, 2, null, 4l), newArrayList(IterableExtensions.reject(objects, String.class)));
		assertEquals(nullList, newArrayList(IterableExtensions.reject(objects, Object.class)));
		
		List<Integer> integerObjects = newArrayList(1, 2, null, 4);
		assertEquals(nullList, newArrayList(IterableExtensions.reject(integerObjects, Integer.class)));
		
		List<A> bObjects = newArrayList(new B(), new B(), new D());
		assertEquals(0, IterableExtensions.size(IterableExtensions.reject(bObjects, A.class)));
		assertEquals(1, IterableExtensions.size(IterableExtensions.reject(bObjects, B.class)));
		assertEquals(1, IterableExtensions.size(IterableExtensions.reject(bObjects, C.class)));
		assertEquals(2, IterableExtensions.size(IterableExtensions.reject(bObjects, D.class)));
		
		Function1<Integer, Boolean> function = new Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return p % 2 == 0;
			}
		};
		assertEquals(newArrayList(1,3,5),newArrayList(IterableExtensions.reject(newArrayList(1,2,3,4,5), function)));
		Function1<Integer, Boolean> functionNullSafe = new Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return p == null || p % 2 == 0;
			}
		};
		assertEquals(newArrayList(1,5),newArrayList(IterableExtensions.reject(newArrayList(1,2,null,4,5), functionNullSafe)));
		try {
			newArrayList(IterableExtensions.reject(null, function));
			fail("NullPointerException expected");
		} catch (NullPointerException e) {
			// expected NPE
		}
		try {
			Function1<? super Integer, Boolean> nullFn = null;
			newArrayList(IterableExtensions.reject(newArrayList(1,2,3), nullFn));
			fail("NullPointerException expected");
		} catch (NullPointerException e) {
			// expected NPE
		}
		try {
			Class<Integer> nullClass = null;
			newArrayList(IterableExtensions.reject(newArrayList(1,2,3), nullClass));
			fail("NullPointerException expected");
		} catch (NullPointerException e) {
			// expected NPE
		}
		Function1<Integer, Boolean> brokenFunction = new Function1<Integer, Boolean>() {
			@Override
			public Boolean apply(Integer p) {
				return null;
			}
		};
		try {
			newArrayList(IterableExtensions.reject(newArrayList(1,2,3), brokenFunction));
			fail("NullPointerException expected");
		} catch (NullPointerException e) {
			// expected NPE
		}
	}

	@Test public void testMap () {
		ArrayList<String> list = newArrayList("foo", "bar");
		
		final Functions.Function1<String, String> function = new Functions.Function1<String, String>() {
			@Override
			public String apply(String p) {
				return "Hello "+p;
			}
		};
		
		assertEquals(newArrayList("Hello foo", "Hello bar"), newArrayList(IterableExtensions.map(list, function)));
	
		// test that the returned iterator supports remove on the underyling list
		// therefore we need a function that maps to the same object contained in the list
		final Functions.Function1<String, String> functionForRemove = new Functions.Function1<String, String>() {
			@Override
			public String apply(String p) {
				return "foo".equals(p) ? p : "Hello "+p;
			}
		};

		assertTrue(list.contains("foo"));
		assertEquals(2, list.size());
		assertEquals(newArrayList("foo", "Hello bar"), newArrayList(IterableExtensions.map(list, functionForRemove)));
		Iterator<String> iterator = IterableExtensions.map(list, functionForRemove).iterator();
		iterator.next();
		iterator.remove();
		
		assertTrue(!list.contains("foo"));
		assertEquals(1, list.size());
	}

	@Test public void testFlatMap () {
		ArrayList<String> list = newArrayList("foo", "bar");
		
		final Functions.Function1<String, Iterable<String>> function = new Functions.Function1<String, Iterable<String>>() {
			@Override
			public Iterable<String> apply(String p) {
				return newArrayList("Hello", p);
			}
		};
		assertEquals(newArrayList("Hello", "foo", "Hello", "bar"), newArrayList(IterableExtensions.flatMap(list, function)));
	}
	
	@Test public void testContains() {
		ArrayList<String> list = newArrayList("element1", "element2", "element3", null);
		
		assertTrue(IterableExtensions.contains(list, "element3"));
		assertTrue(IterableExtensions.contains(list, new String("element3")));
		assertTrue(IterableExtensions.contains(list, null));
		
		assertFalse(IterableExtensions.contains(list, "element4"));
		assertFalse(IterableExtensions.contains(list, new String("element4")));
	}
	
	private static class TestableCollection<T> extends ForwardingCollection<T> {

		private Collection<T> original;
		boolean containsWasCalled;
		Object containsParameter;
		
		public TestableCollection(Collection<T> original) {
			super();
			this.original = original;
		}

		@Override
		protected Collection<T> delegate() {
			return original;
		}
		
		@Override
		public boolean contains(Object object) {
			containsWasCalled = true;
			containsParameter = object;
			return super.contains(object);
		}
	}
	
	@Test public void testContainsOnCollection() {
		//GIVEN a collection, declared as an iterable
		TestableCollection<String> collection = new TestableCollection<String>(newHashSet("element1", "element2", "element3"));
		
		//WHEN we call the contains method via the IterableExtensions
		IterableExtensions.contains(collection, "element1");
		
		//THEN we expect that the collection's native contains method was used
		assertTrue("IterableExtensions.contains didn't use the collection's native contains method",
					collection.containsWasCalled);
		assertEquals("element1", collection.containsParameter);
	}
}
