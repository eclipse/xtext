package org.eclipse.xtext.parser.keywords.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class KeywordsTestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static KeywordsTestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule(), new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUIModule());
	}
	
	public static KeywordsTestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
