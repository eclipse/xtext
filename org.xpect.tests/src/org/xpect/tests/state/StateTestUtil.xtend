package org.xpect.tests.state

import org.junit.Assert
import org.xpect.state.AnalyzedConfiguration
import org.xpect.state.Configuration

class StateTestUtil {
	def static assertEquals(Object expected, Object actual) {
		val e = switch expected {
			Iterable<?>: expected.join("\n")
			default: expected?.toString?.trim ?: "null"
		}
		val a = actual?.toString?.trim ?: "null"
		Assert.assertEquals(e, a)
	}

	def static AnalyzedConfiguration newAnalyzedConfiguration((Configuration)=>void init) {
		return new AnalyzedConfiguration(new Configuration() => init)
	}

}
