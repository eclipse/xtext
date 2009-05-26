package org.eclipse.emf.index.ui.event.impl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.event.IndexChangeListener;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;

import com.google.inject.Inject;

public class ExtensionRegistryBasedIndexChangeListenerRegistry {
	private static final String CLASS = "class";
	private static final String ORG_ECLIPSE_EMF_INDEX_INDEX_CHANGE_LISTENER = "org.eclipse.emf.index.indexChangeListener";
	private IExtensionRegistry registry;
	private IndexStore index;

	@Inject
	public ExtensionRegistryBasedIndexChangeListenerRegistry(IExtensionRegistry registry, IndexStore indexStore) {
		this.index = indexStore;
		this.registry = registry;
		addListenersFromRegistry();
	}

	private void addListenersFromRegistry() {
		IExtensionPoint extensionPoint = registry.getExtensionPoint(ORG_ECLIPSE_EMF_INDEX_INDEX_CHANGE_LISTENER);
		IExtension[] extensions = extensionPoint.getExtensions();
		for (IExtension iExtension : extensions) {
			IConfigurationElement[] configurationElements = iExtension.getConfigurationElements();
			for (IConfigurationElement iConfigurationElement : configurationElements) {
				try {
					index.addIndexChangeListener((IndexChangeListener) iConfigurationElement
							.createExecutableExtension(CLASS));
				}
				catch (CoreException e) {
					EmfIndexUIPlugin.logError("Error instantiating index change listener. Contributed by "
							+ iExtension.getNamespaceIdentifier(), e);
				}
			}
		}
	}

}
