/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import org.junit.Assert;
import org.junit.Test;

public class TraceFileNameProviderTest {
	private final TraceFileNameProvider nameProvider = new TraceFileNameProvider();

	@Test
	public void testTraceFileNameOnWindows() {
		Assert.assertTrue(nameProvider.isTraceFileName("C:\\workspace\\.Foo.java._trace"));
	}

	@Test
	public void testTraceFileNameOnUnix() {
		Assert.assertTrue(nameProvider.isTraceFileName("/workspace/.Foo.java._trace"));
	}

	@Test
	public void testTraceFromJavaSimple() {
		String trace = nameProvider.getTraceFromJava("Foo.java");
		Assert.assertEquals(".Foo.java._trace", trace);
	}

	@Test
	public void testTraceFromJavaOnWindows() {
		String trace = nameProvider.getTraceFromJava("C:\\workspace\\Foo.java");
		Assert.assertEquals("C:\\workspace\\.Foo.java._trace", trace);
	}

	@Test
	public void testTraceFromJavaOnUnix() {
		String trace = nameProvider.getTraceFromJava("/workspace/Foo.java");
		Assert.assertEquals("/workspace/.Foo.java._trace", trace);
	}

	@Test
	public void testJavaFromTraceSimple() {
		String java = nameProvider.getJavaFromTrace(".Foo.java._trace");
		Assert.assertEquals("Foo.java", java);
	}

	@Test
	public void testJavaFromTraceOnWindows() {
		String java = nameProvider.getJavaFromTrace("C:\\workspace\\.Foo.java._trace");
		Assert.assertEquals("C:\\workspace\\Foo.java", java);
	}

	@Test
	public void testJavaFromTraceOnUnix() {
		String java = nameProvider.getJavaFromTrace("/workspace/.Foo.java._trace");
		Assert.assertEquals("/workspace/Foo.java", java);
	}
}
