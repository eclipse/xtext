package org.xpect.registry;

import java.util.Set;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;

public interface ITestSuiteInfo {

	public interface Registry {
		final Registry INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new TestSuiteInfoRegistry.Delegate() : new TestSuiteInfoRegistry();

		ITestSuiteInfo getTestSuite(Resource resource);
	}

	// String getName();

	LazyClass<Object> getClazz();

	Set<String> getFileExtensions();

	// Set<String> getLanguageNames();
}
