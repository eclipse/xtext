package org.eclipse.xtext.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class XtextGrammarTestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static XtextGrammarTestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.XtextGrammarTestLanguageRuntimeModule(), new org.eclipse.xtext.XtextGrammarTestLanguageUIModule());
	}
	
	public static XtextGrammarTestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
 