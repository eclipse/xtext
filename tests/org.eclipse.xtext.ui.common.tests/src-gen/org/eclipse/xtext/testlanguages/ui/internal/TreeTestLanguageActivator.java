package org.eclipse.xtext.testlanguages.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class TreeTestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static TreeTestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.TreeTestLanguageRuntimeModule(), new org.eclipse.xtext.testlanguages.TreeTestLanguageUIModule());
	}
	
	public static TreeTestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
