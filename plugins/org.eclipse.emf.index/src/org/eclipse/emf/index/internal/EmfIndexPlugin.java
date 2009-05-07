package org.eclipse.emf.index.internal;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;


public class EmfIndexPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.eclipse.emf.index";
	
	private static EmfIndexPlugin plugin;
	
	public static EmfIndexPlugin getDefault() {
		return plugin;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static void logError(String message, Throwable t) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, t));
	}

	public static void logError(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message));
	}

}
