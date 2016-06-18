package org.eclipse.xtext.tests;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;

import com.google.inject.Injector;

/**
 * @since 2.9
 */
public class XtextInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation;
	protected GlobalStateMemento stateAfterInjectorCreation;
	protected Injector injector;

	static {
		GlobalRegistries.initializeDefaults();
	}

	@Override
	public Injector getInjector() {
		if (injector == null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
			this.injector = new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState();
		}
		return injector;
	}

	@Override
	public void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState();
	}

	@Override
	public void setupRegistry() {
		getInjector();
		stateAfterInjectorCreation.restoreGlobalState();
	}
}