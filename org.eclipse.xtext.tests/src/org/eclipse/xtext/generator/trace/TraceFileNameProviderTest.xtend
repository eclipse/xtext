/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace

import org.junit.Test
import static org.junit.Assert.*

class TraceFileNameProviderTest {
	val nameProvider = new TraceFileNameProvider

	@Test
	def testTraceFileNameOnWindows() {
		assertTrue(nameProvider.isTraceFileName("C:\\workspace\\.Foo.java._trace"))
	}
	@Test
	def testTraceFileNameOnUnix() {
		assertTrue(nameProvider.isTraceFileName("/workspace/.Foo.java._trace"))
	}

	@Test
	def testTraceFromJavaSimple() {
		val trace = nameProvider.getTraceFromJava("Foo.java")
		assertEquals(".Foo.java._trace", trace)
	}

	@Test
	def testTraceFromJavaOnWindows() {
		val trace = nameProvider.getTraceFromJava("C:\\workspace\\Foo.java")
		assertEquals("C:\\workspace\\.Foo.java._trace", trace)
	}

	@Test
	def testTraceFromJavaOnUnix() {
		val trace = nameProvider.getTraceFromJava("/workspace/Foo.java")
		assertEquals("/workspace/.Foo.java._trace", trace)
	}

	@Test
	def testJavaFromTraceSimple() {
		val java = nameProvider.getJavaFromTrace(".Foo.java._trace")
		assertEquals("Foo.java", java)
	}

	@Test
	def testJavaFromTraceOnWindows() {
		val java = nameProvider.getJavaFromTrace("C:\\workspace\\.Foo.java._trace")
		assertEquals("C:\\workspace\\Foo.java", java)
	}

	@Test
	def testJavaFromTraceOnUnix() {
		val java = nameProvider.getJavaFromTrace("/workspace/.Foo.java._trace")
		assertEquals("/workspace/Foo.java", java)
	}
}