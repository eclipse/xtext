package org.eclipse.xpect.ui.registry;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xpect.registry.IExtensionInfo;
import org.osgi.framework.Bundle;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class UIExtensionInfoRegistry implements IExtensionInfo.Registry {

	public static class UiExtensionInfo implements IExtensionInfo {

		private final IConfigurationElement configurationElement;

		public UiExtensionInfo(IConfigurationElement configurationElement) {
			super();
			this.configurationElement = configurationElement;
		}

		public Collection<String> getAttributes() {
			return Lists.newArrayList(configurationElement.getAttributeNames());
		}

		public String getAttributeValue(String name) {
			return configurationElement.getAttribute(name);
		}

		public Function<String, Class<?>> getClassLoader() {
			return new Function<String, Class<?>>() {
				public Class<?> apply(String input) {
					try {
						String bundleName = configurationElement.getContributor().getName();
						Bundle bundle = Platform.getBundle(bundleName);
						return bundle.loadClass(input);
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(e);
					} catch (InvalidRegistryObjectException e) {
						throw new RuntimeException(e);
					}
				}
			};
		}

		public String getLocation() {
			return configurationElement.getContributor().getName();
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			result.append("<");
			result.append(configurationElement.getName());
			List<String> attrs = Lists.newArrayList(getAttributes());
			Collections.sort(attrs);
			for (String attr : attrs) {
				result.append(" ");
				result.append(attr);
				result.append("=\"");
				result.append(getAttributeValue(attr));
				result.append("\"");
			}
			result.append(" />");
			return result.toString();
		}

	}

	public Collection<String> getExtensionPoints() {
		List<String> names = Lists.newArrayList();
		for (IExtensionPoint ep : Platform.getExtensionRegistry().getExtensionPoints())
			names.add(ep.getUniqueIdentifier());
		return names;
	}

	public Collection<IExtensionInfo> getExtensions(String extensionPointName) {
		List<IExtensionInfo> result = Lists.newArrayList();
		for (IConfigurationElement cfg : Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointName))
			result.add(new UiExtensionInfo(cfg));
		return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("<plugin>\n");
		for (String point : getExtensionPoints()) {
			result.append("  <extension point=\"");
			result.append(point);
			result.append("\">\n");
			for (IExtensionInfo ext : getExtensions(point)) {
				result.append("    ");
				result.append(ext.toString());
				result.append("\n");
			}
		}
		result.append("  </extension>\n");
		result.append("</plugin>");
		return result.toString();
	}

}
