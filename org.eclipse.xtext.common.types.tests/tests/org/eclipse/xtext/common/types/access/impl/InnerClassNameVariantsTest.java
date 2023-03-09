/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import com.google.common.collect.Iterators;

/**
 * Tests for {@link InnerClassNameVariants}}
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
public class InnerClassNameVariantsTest {

	private InnerClassNameVariants innerClassNameVariants = new InnerClassNameVariants();

	@Test
	public void testNoDollar() {
		assertVariants("a.b.c.Outer").are("a.b.c.Outer");
		assertVariants("Outer").are("Outer");
	}

	@Test
	public void testDollarNotInLastSegment() {
		assertVariants("so$me.Package").are("so$me.Package");
		assertVariants("is.so$me.Package").are("is.so$me.Package");
		assertVariants("so$me.pack.Age").are("so$me.pack.Age");
	}

	@Test
	public void testDollarInLastSegment() {
		assertVariants("demo.Outer$Inner").are("demo.Outer$Inner", "demo.Outer.Inner");
		assertVariants("demo.Outer$Inner$InnerMost").are("demo.Outer$Inner$InnerMost", "demo.Outer.Inner$InnerMost",
				"demo.Outer$Inner.InnerMost", "demo.Outer.Inner.InnerMost");
	}

	private class TestHelper {

		public TestHelper(String base) {
			super();
			this.base = base;
		}

		private String base;

		public void are(String... expected) {
			final String base1 = base;
			Iterator<String> variants = innerClassNameVariants.variantsFor(base1);
			String[] actual = Iterators.toArray(variants, String.class);
			assertArrayEquals(expected, actual);
		}

	}

	private TestHelper assertVariants(String base) {
		return new TestHelper(base);
	}

}
