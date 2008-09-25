package org.eclipse.xtext.service.examples;

import org.eclipse.xtext.service.Inject;

public class WithOptionalDependency {
	@Inject(optional=true)
	public InjectedService2 dependency;
}
