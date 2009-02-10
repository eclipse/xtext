package org.eclipse.xtext.testlanguages.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class ReferenceGrammarTestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static ReferenceGrammarTestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule(), new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUIModule());
	}
	
	public static ReferenceGrammarTestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
