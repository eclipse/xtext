/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;


import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests "new line extensive test" framework.
 * 
 * @see AbstractXtendTestCase#runExtensive(NewLineTest)
 * 
 * @author Boris Brodski
 */
public class NewLineTestFrameworkTest extends AbstractXtendTestCase {
	@Test
	public void newLineTestFramework_runCount0() throws Exception {
		testNewLineFramework(0);
	}

	@Test
	public void newLineTestFramework_runCount1() throws Exception {
		testNewLineFramework(1);
	}

	@Test
	public void newLineTestFramework_runCount2() throws Exception {
		testNewLineFramework(2);
	}

	@Test
	public void newLineTestFramework_runCount5() throws Exception {
		testNewLineFramework(5);
	}

	@Test
	public void newLineTestFramework_runCount6() throws Exception {
		testNewLineFramework(6);
	}

	@Test
	public void newLineTestFramework_runCount10() throws Exception {
		testNewLineFramework(10);
	}

	@Test
	public void newLineTestFramework_runCount100() throws Exception {
		testNewLineFramework(100);
	}

	private void testNewLineFramework(final int countOfNls) throws Exception {
		int expectedCountOfRuns = (int) Math.pow(2,
				Math.min(MAX_NEWLINE_COUNT_FOR_EXTENSIVE_TEST, countOfNls));
		final AtomicInteger countOfRuns = new AtomicInteger();
		final Set<String> combinations = new HashSet<String>();
		runExtensive(new NewLineTest() {
			public void test(final NewLineProvider p) throws Exception {
				StringBuilder stringBuilder = new StringBuilder();
				for (int i = 0; i < countOfNls; i++) {
					String nl = p.nl();
					Assert.assertTrue(nl.equals("\n") || nl.equals("\r\n"));
					stringBuilder.append(nl);
				}
				combinations.add(stringBuilder.toString());
				countOfRuns.set(countOfRuns.get() + 1);
			}
		});
		Assert.assertEquals(expectedCountOfRuns, countOfRuns.get());

		// Ensure, that all combinations were different
		Assert.assertEquals(expectedCountOfRuns, combinations.size());
	}
}
