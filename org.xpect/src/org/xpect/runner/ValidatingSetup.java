package org.xpect.runner;

import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;

@XpectSetupFactory
public class ValidatingSetup {
	public void validate() {
	}

	@Creates
	public ValidatingSetup create() {
		return this;
	}
}
