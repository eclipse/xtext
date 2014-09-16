package org.xpect.runner;

import org.xpect.setup.XpectSetup;
import org.xpect.state.Creates;

@XpectSetup(ValidatingSetup.class)
public class ValidatingSetup {
	public void validate() {
	}

	@Creates
	public ValidatingSetup create() {
		return this;
	}
}
