package org.eclipse.xpect.runner;

import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.state.Creates;

@XpectSetupFactory
public class ArgumentContributor {
	public void contributeArguments(Configuration[] configurations) {
	}

	@Creates
	public ArgumentContributor create() {
		return this;
	}
}
