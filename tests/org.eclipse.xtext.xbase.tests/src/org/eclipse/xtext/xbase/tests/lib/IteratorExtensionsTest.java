/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static com.google.common.collect.Lists.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Test;

import com.google.common.collect.Iterators;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IteratorExtensionsTest extends BaseIterablesIteratorsTest<Iterator<Integer>> {
	
	@Test public void testToIterable() throws Exception {
		ArrayList<String> list = newArrayList("A","B");
		for (String s : IteratorExtensions.toIterable(list.iterator())) {
			assertTrue(list.contains(s));
		}
	}
	
	@Override
	protected boolean canIterateTwice() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<Integer>[] testData(Integer... elements) {
		return new Iterator[] { Iterators.forArray(elements) };
	}

	@Override
	protected Iterator<Integer> dummy() {
		return Collections.<Integer>emptyList().iterator();
	}

	@Override
	protected boolean is(Iterator<Integer> input, Integer... elements) {
		return Iterators.elementsEqual(input, Iterators.forArray(elements));
	}

	@Override
	protected Iterator<Integer> operator_plus(Iterator<Integer> first, Iterator<Integer> second) {
		return IteratorExtensions.operator_plus(first, second);
	}

	@Override
	protected Integer findFirst(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.findFirst(input, filter);
	}

	@Override
	protected Integer findLast(Iterator<Integer> input, Function1<Integer, Boolean> filter) {
		return IteratorExtensions.findLast(input, filter);
	}

	@Override
	protected Integer last(Iterator<Integer> input) {
		return IteratorExtensions.last(input);
	}

	@Override
	protected Integer head(Iterator<Integer> input) {
		return IteratorExtensions.head(input);
	}
	
	@Override
	protected void forEach(Iterator<Integer> input, Procedure2<Integer, Integer> proc) {
		IteratorExtensions.forEach(input, proc);
	}
}
