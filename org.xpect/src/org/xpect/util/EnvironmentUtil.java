package org.xpect.util;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.xpect.Environment;
import org.xpect.runner.XpectRunner;

public class EnvironmentUtil {
	public static final Environment ENVIRONMENT = detectEnvironement();

	private static Environment detectEnvironement() {
		if (XpectRunner.testClassloader != null) {
			if (EcorePlugin.IS_ECLIPSE_RUNNING)
				return Environment.PLUGIN_TEST;
			else
				return Environment.STANDALONE_TEST;
		} else {
			if (EcorePlugin.IS_ECLIPSE_RUNNING)
				return Environment.WORKBENCH;
			else
				throw new IllegalStateException("not (yet) supported environment: standalone, but without JUnit.");
		}
	}

}
