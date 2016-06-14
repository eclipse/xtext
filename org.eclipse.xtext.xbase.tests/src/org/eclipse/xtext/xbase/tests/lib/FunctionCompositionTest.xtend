/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib

import java.util.concurrent.atomic.AtomicInteger
import org.junit.Assert
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class FunctionCompositionTest {

	val binaryFun = [int e, int e2|e * e2]
	val times2 = [int e|e * 2]
	val squared = [int e|e * e]

	@Test def void testCompose() {
		Assert.assertEquals(32, (times2.compose(squared).apply(4)))
	}

	@Test def void testAndThen() {
		Assert.assertEquals(64, (times2.andThen(squared).apply(4)))
	}

	@Test def void testAndThen2() {
		Assert.assertEquals(4, (binaryFun.andThen(squared).apply(2, 1)))
	}

	@Test def void testAndThenProcedure() {
		val (AtomicInteger)=>void incrementer = [incrementAndGet]
		val counter = new AtomicInteger;
		(incrementer.andThen [
			Assert.assertEquals(2, incrementAndGet)
		]).apply(counter)
		Assert.assertEquals(3, counter.incrementAndGet)
	}

}