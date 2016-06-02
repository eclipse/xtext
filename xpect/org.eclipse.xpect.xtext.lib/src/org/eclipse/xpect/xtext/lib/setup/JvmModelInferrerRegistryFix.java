package org.eclipse.xpect.xtext.lib.setup;

import org.apache.log4j.Logger;
import org.eclipse.xpect.util.ReflectionUtil;

public class JvmModelInferrerRegistryFix {

	private final static Logger LOG = Logger.getLogger(JvmModelInferrerRegistryFix.class);

	// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=403920
	// in Xtext 2.4.0 - 2.4.1
	public static void apply() {
		try {
			Class<?> registryClass = null;
			try {
				registryClass = Class.forName("org.eclipse.xtext.xbase.jvmmodel.JvmModelInferrerRegistry");
			} catch (ClassNotFoundException e) {
				// ignore, we're probably using Xtext >= 2.7.0, where this class doen't exist anymore
			}
			if (registryClass != null) {
				Object registry = ReflectionUtil.readField(registryClass, null, "INSTANCE", Object.class);
				ReflectionUtil.writeField(registryClass, registry, "isUseRegistry", false);
			}
		} catch (Throwable t) {
			LOG.error(t.getMessage(), t);
		}
	}
}
