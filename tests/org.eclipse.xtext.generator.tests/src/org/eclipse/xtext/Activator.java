package org.eclipse.xtext;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.generator.tests";

	// The shared instance
	private static Activator plugin;

	public Activator() {
		// TODO Auto-generated constructor stub
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
}
