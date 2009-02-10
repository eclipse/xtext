package org.eclipse.xtext.testlanguages.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ContentAssistTestLanguageActivator extends AbstractUIPlugin {

	private Injector injector;
	private static ContentAssistTestLanguageActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.testlanguages.ContentAssistTestLanguageRuntimeModule(), new org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUIModule());
	}
	
	public static ContentAssistTestLanguageActivator getInstance() {
		return INSTANCE;
	}
	
}
 