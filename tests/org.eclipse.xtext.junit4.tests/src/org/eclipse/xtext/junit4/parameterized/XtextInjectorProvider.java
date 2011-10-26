package org.eclipse.xtext.junit4.parameterized;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.GlobalRegistries;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.eclipse.xtext.junit4.GlobalRegistries.GlobalStateMemento;

import com.google.inject.Injector;

public class XtextInjectorProvider implements IInjectorProvider, IRegistryConfigurator
{

	protected GlobalStateMemento globalStateMemento;
	protected Injector injector;

	static
	{
		GlobalRegistries.initializeDefaults();
	}

	public Injector getInjector()
	{
		if (injector == null)
		{
			this.injector = new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
		return injector;
	}

	public void restoreRegistry()
	{
		globalStateMemento.restoreGlobalState();
	}

	public void setupRegistry()
	{
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		if (injector != null)
			new XtextStandaloneSetup().register(injector);
	}
}