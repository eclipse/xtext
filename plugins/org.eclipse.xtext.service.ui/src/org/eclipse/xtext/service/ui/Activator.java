package org.eclipse.xtext.service.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.service.ui.internal.ExtensionPointActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class Activator extends AbstractUIPlugin {

	private static Activator plugin;

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.xtext.service.ui";

	/**
	 * @return singleton instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setDefault(this);

		ExtensionPointActivator.activateServices();
	}

	private static void setDefault(Activator activator) {
		plugin = activator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		setDefault(null);
		super.stop(context);
	}

}
