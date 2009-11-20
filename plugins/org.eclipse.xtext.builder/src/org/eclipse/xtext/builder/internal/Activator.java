package org.eclipse.xtext.builder.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.impl.javasupport.JdtBuilderModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Activator extends AbstractUIPlugin {

	private static Activator INSTANCE;
	
	public static Activator getDefault() {
		return INSTANCE;
	}

	private Injector injector;
	
	public Injector getInjector() {
		return injector;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		injector = Guice.createInjector(new JdtBuilderModule());
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		INSTANCE = null;
	}
}
