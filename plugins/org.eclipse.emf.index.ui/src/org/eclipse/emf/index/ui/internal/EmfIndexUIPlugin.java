package org.eclipse.emf.index.ui.internal;

import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EPackageRegistryIndexFeeder;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EmfIndexUIPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.index.ui";

	// The shared instance
	private static EmfIndexUIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EmfIndexUIPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		EPackageRegistryIndexFeeder.feedEPackagesFromRegistry(IIndexStore.eINSTANCE);
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EmfIndexUIPlugin getDefault() {
		return plugin;
	}

}
