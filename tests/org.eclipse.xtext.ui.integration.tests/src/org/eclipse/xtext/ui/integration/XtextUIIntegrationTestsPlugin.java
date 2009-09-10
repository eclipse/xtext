package org.eclipse.xtext.ui.integration;

import org.osgi.framework.BundleContext;

public class XtextUIIntegrationTestsPlugin extends Activator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.ui.integration.tests";

	// The shared instance
	private static XtextUIIntegrationTestsPlugin plugin;

	/**
	 * The constructor
	 */
	public XtextUIIntegrationTestsPlugin() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static XtextUIIntegrationTestsPlugin getDefault() {
		return plugin;
	}

	private static void setDefault(XtextUIIntegrationTestsPlugin activator) {
		plugin = activator;
	}

}
