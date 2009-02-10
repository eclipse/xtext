package org.eclipse.xtext.ui.integration.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class TestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static TestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.ui.integration.TestLanguageRuntimeModule(), new org.eclipse.xtext.ui.integration.TestLanguageUIModule());
	}
	
	public static TestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
