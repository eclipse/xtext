package org.xpect.tests.state

import org.xpect.state.Configuration
import org.xpect.state.ResolvedConfiguration

class StateTestUtil {

	def static ResolvedConfiguration newAnalyzedConfiguration((Configuration)=>void init) {
		return new ResolvedConfiguration(new Configuration() => init)
	}

}
