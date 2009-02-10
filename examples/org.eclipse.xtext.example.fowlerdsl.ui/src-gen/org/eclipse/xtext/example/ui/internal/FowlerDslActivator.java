package org.eclipse.xtext.example.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class FowlerDslActivator extends AbstractUIPlugin {

	private Injector injector;
	private static FowlerDslActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.example.FowlerDslRuntimeModule(), new org.eclipse.xtext.example.FowlerDslUIModule());
	}
	
	public static FowlerDslActivator getInstance() {
		return INSTANCE;
	}
	
}
 