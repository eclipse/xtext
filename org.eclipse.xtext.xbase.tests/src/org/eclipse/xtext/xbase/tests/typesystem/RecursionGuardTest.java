/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecursionGuardTest {
	private ReflectExtensions reflectExtensions = new ReflectExtensions();

	@Test
	public void tryNextAndDoneYieldsEmpty() throws Exception {
		RecursionGuard<String> recursionGuard = new RecursionGuard<>();
		String s = "literal";
		Assert.assertTrue(recursionGuard.tryNext(s));
		recursionGuard.done(s);
		Assert.assertNull(reflectExtensions.get(recursionGuard, "head"));
	}

	@Test
	public void tryNextTwiceYieldsFalse() {
		RecursionGuard<String> recursionGuard = new RecursionGuard<>();
		String s = "literal";
		Assert.assertTrue(recursionGuard.tryNext(s));
		Assert.assertFalse(recursionGuard.tryNext(s));
	}

	@Test
	public void tryNextWithDifferentValuesYieldsTrue() {
		RecursionGuard<String> recursionGuard = new RecursionGuard<>();
		Assert.assertTrue(recursionGuard.tryNext("first"));
		Assert.assertTrue(recursionGuard.tryNext("second"));
	}

	@Test
	public void clearYieldsEmpty() throws Exception {
		RecursionGuard<String> recursionGuard = new RecursionGuard<>();
		Assert.assertTrue(recursionGuard.tryNext("dummy"));
		recursionGuard.clear();
		Assert.assertNull(reflectExtensions.get(recursionGuard, "head"));
	}

	@Test(expected = IllegalStateException.class)
	public void doneTwice() {
		RecursionGuard<String> recursionGuard = new RecursionGuard<>();
		String s = "literal";
		Assert.assertTrue(recursionGuard.tryNext(s));
		recursionGuard.done(s);
		recursionGuard.done(s);
	}
}
