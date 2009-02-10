package org.eclipse.xtext.ui.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Generated from UIPlugin.xpt
 */
public class XtextActivator extends AbstractUIPlugin {

	private Injector injector;
	private static XtextActivator INSTANCE;

	public Injector getInjector() {
		return injector;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		this.injector = Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule(), new org.eclipse.xtext.XtextUIModule());
	}
	
	public static XtextActivator getInstance() {
		return INSTANCE;
	}
	
}
