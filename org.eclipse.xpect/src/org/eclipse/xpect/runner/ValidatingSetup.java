package org.eclipse.xpect.runner;

import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;

@XpectSetupFactory
public class ValidatingSetup {
	public void validate() {
	}

	@Creates
	public ValidatingSetup create() {
		return this;
	}
}
