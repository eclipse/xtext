package org.xpect.tests.state

import org.junit.Assert
import org.xpect.state.Configuration
import org.xpect.state.ResolvedConfiguration

class StateTestUtil {
	def static assertEquals(Object expected, Object actual) {
		val e = switch expected {
			Iterable<?>: expected.join("\n")
			default: expected?.toString?.trim ?: "null"
		}
		val a = actual?.toString?.trim ?: "null"
		Assert.assertEquals(e, a)
	}

	def static ResolvedConfiguration newAnalyzedConfiguration((Configuration)=>void init) {
		return new ResolvedConfiguration(new Configuration() => init)
	}

}
