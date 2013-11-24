package org.xpect.registry;

import java.util.Collection;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.google.common.base.Function;

public interface IExtensionInfo {

	public interface Registry {

		Registry INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new DelegatingExtensionInfoRegistry() : new StandaloneExtensionRegistry();

		Collection<String> getExtensionPoints();

		Collection<IExtensionInfo> getExtensions(String extensionPointName);
	}

	Collection<String> getAttributes();

	String getAttributeValue(String name);

	Function<String, Class<?>> getClassLoader();

	String getLocation();

}
