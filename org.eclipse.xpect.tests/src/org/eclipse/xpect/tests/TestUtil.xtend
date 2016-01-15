package org.eclipse.xpect.tests

import org.junit.Assert

class TestUtil {
	def static assertEquals(Object expected, Object actual) {
		val e = switch expected {
			Iterable<?>: expected.join("\n")
			default: expected?.toString?.trim ?: "null"
		}
		val a = actual?.toString?.trim ?: "null"
		Assert.assertEquals(e, a)
	}
}
