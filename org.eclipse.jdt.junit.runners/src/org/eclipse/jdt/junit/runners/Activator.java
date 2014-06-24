package org.eclipse.jdt.junit.runners;

import java.util.ArrayList;

import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.jdt.junit.ui.runners"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		patchTestKindRegistry();
	}

	private void patchTestKindRegistry() {
		TestKindRegistry default1 = TestKindRegistry.getDefault();
		@SuppressWarnings("unchecked")
		ArrayList<ITestKind> kinds = default1.getAllKinds();
		for (int i = 0; i < kinds.size(); i++) {
			if (kinds.get(i).getId().equals(TestKindRegistry.JUNIT4_TEST_KIND_ID))
				kinds.set(i, new PatchedTestKind(kinds.get(i)));
		}
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
	public static Activator getDefault() {
		return plugin;
	}

}
