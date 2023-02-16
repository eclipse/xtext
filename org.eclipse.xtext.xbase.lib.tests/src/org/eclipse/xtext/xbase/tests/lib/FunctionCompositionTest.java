/**
 * Copyright (c) 2015, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.lib;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.xtext.xbase.lib.FunctionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
public class FunctionCompositionTest {
	
	private Function2<Integer, Integer, Integer> binaryFun = (Integer e, Integer e2) -> {
		return e * e2;
	};

	private Function1<Integer, Integer> times2 = (Integer e) -> {
		return e * 2;
	};

	private Function1<Integer, Integer> squared = (Integer e) -> {
		return e * e;
	};

	@Test
	public void testCompose() {
		int actual = FunctionExtensions.compose(times2, squared).apply(4);
		Assert.assertEquals(32, actual);
	}

	@Test
	public void testAndThen() {
		int actual = FunctionExtensions.andThen(times2, squared).apply(4);
		Assert.assertEquals(64, actual);
	}

	@Test
	public void testAndThen2() {
		int actual = FunctionExtensions.andThen(binaryFun, squared).apply(2, 1);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testAndThenProcedure() {
		Procedure1<AtomicInteger> incrementer = (AtomicInteger it) -> {
			it.incrementAndGet();
		};
		
		Procedure1<AtomicInteger> function = (AtomicInteger it) -> {
			Assert.assertEquals(2, it.incrementAndGet());
		};
		
		AtomicInteger counter = new AtomicInteger();
		FunctionExtensions.andThen(incrementer, function).apply(counter);
		
		Assert.assertEquals(3, counter.incrementAndGet());
	}
}
