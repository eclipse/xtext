package org.eclipse.xtext.xbase.tests.lib;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.xbase.lib.CollectionExtensions.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.junit.Test;

/**
 * Tests for {@link CollectionExtensions}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
public class CollectionExtensionsTest {
	
	@Test
	public void testAdd_01() {
		List<String> strings = newArrayList("A", "B", "C");
		List<String> strings2 = newArrayList("X", "Y", "Z");
		operator_add(strings, strings2);
		List<String> expected = newArrayList("A", "B", "C", "X", "Y", "Z");
		assertEquals(expected, strings);
	}

	@Test
	public void testAdd_02() {
		List<Number> numbers = newArrayList(1, 1.0d);
		List<Integer> integers = newArrayList(1, 2, 3);
		operator_add(numbers, integers);
		List<Number> expected = newArrayList(1, 1.0d, 1, 2, 3);
		assertEquals(expected, numbers);
	}

	@Test
	public void testRemove_01() {
		List<String> strings = newArrayList("A", "B", "C");
		List<String> strings2 = newArrayList("A", "C");
		operator_remove(strings, strings2);
		List<String> expected = newArrayList("B");
		assertEquals(expected, strings);
	}
	
	@Test
	public void testRemove_02() {
		List<Number> numbers = newArrayList(1, 1.0d, 2);
		List<Integer> integers = newArrayList(1, 2);
		operator_remove(numbers, integers);
		List<Number> expected = newArrayList(1.0d);
		assertEquals(expected, numbers);
	}
}
