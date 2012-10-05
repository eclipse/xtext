package org.eclipse.xpect.xtext.lib.setup;

import org.eclipse.xpect.setup.IGuiceModuleProvider;

import com.google.inject.Guice;

public class XtextStandaloneSetup extends StandaloneSetup {
	private IGuiceModuleProvider moduleProvider;

	public IGuiceModuleProvider getModuleProvider() {
		return moduleProvider;
	}

	public void setModuleProvider(IGuiceModuleProvider moduleProvider) {
		this.moduleProvider = moduleProvider;
	}

	@Override
	public ClassCtx beforeClass(IClassSetupContext frameworkCtx) {
		installInjector(Guice.createInjector(moduleProvider.getRuntimeModule()));
		return null;
	}

}
