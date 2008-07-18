package org.eclipse.xtext.service.ui;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.xtext.service.ui.internal.ExtensionPointActivator;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator plugin;
	
	public static Activator getDefault() {
		return plugin;
	}

	public Activator() {
	}
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);
		
		ExtensionPointActivator.activateServices();
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		super.stop(context);
	}
	
}
