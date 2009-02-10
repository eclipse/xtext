package org.eclipse.xtext.reference.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class ReferenceGrammarActivator extends AbstractUIPlugin {

	private Injector injector;
	private static ReferenceGrammarActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.reference.ReferenceGrammarRuntimeModule(), new org.eclipse.xtext.reference.ReferenceGrammarUIModule());
	}
	
	public static ReferenceGrammarActivator getInstance() {
		return INSTANCE;
	}
	
}
