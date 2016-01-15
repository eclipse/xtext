package org.xpect.runner;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Configuration;
import org.xpect.state.Creates;

@XpectSetupFactory
public class ArgumentContributor {
	public void contributeArguments(Configuration[] configurations) {
	}

	@Creates
	public ArgumentContributor create() {
		return this;
	}
}
