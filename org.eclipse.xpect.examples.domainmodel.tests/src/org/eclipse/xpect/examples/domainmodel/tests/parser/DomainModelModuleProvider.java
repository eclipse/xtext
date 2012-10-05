package org.eclipse.xpect.examples.domainmodel.tests.parser;

import org.eclipse.xpect.setup.IGuiceModuleProvider;
import org.eclipse.xtext.example.domainmodel.DomainmodelRuntimeModule;

import com.google.inject.Module;

public class DomainModelModuleProvider implements IGuiceModuleProvider {

	@Override
	public Module getRuntimeModule() {
		return new DomainmodelRuntimeModule();
	}

	@Override
	public Module getUIModule() {
		return null;
	}

}
