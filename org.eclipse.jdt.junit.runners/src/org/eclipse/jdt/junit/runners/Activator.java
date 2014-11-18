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

	public static boolean CAN_RUN_SUBTREES = canRunSubTrees();

	// test if fix for
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=443498 is available
	private static boolean canRunSubTrees() {
		try {
			Class.forName("org.eclipse.jdt.internal.junit4.runner.DescriptionMatcher");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	private void patchTestKindRegistry() {
		if (!CAN_RUN_SUBTREES) {
			// install workaround for
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=443498
			TestKindRegistry default1 = TestKindRegistry.getDefault();
			@SuppressWarnings("unchecked")
			ArrayList<ITestKind> kinds = default1.getAllKinds();
			for (int i = 0; i < kinds.size(); i++) {
				if (kinds.get(i).getId().equals(TestKindRegistry.JUNIT4_TEST_KIND_ID))
					kinds.set(i, new PatchedTestKind(kinds.get(i)));
			}
		}
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		patchTestKindRegistry();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}
