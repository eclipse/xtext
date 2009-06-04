/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.resource.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.emf.index.resource.ResourceIndexer;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ExtensionRegistryBasedIndexerRegistry implements ResourceIndexer.Registry {

	private static final String CLASS = "class";
	private static final String FILE_EXTENSIONS = "fileExtensions";
	private static final String ORG_ECLIPSE_EMF_INDEX_INDEXER = "org.eclipse.emf.index.indexer";
	private IExtensionRegistry registry;

	@Inject
	public ExtensionRegistryBasedIndexerRegistry(IExtensionRegistry registry) {
		this.registry = registry;
	}

	public void deregisterIndexer(String fileExtension, ResourceIndexer indexer) {
		throw new UnsupportedOperationException();
	}

	public void registerIndexer(String fileExtension, ResourceIndexer indexer) {
		throw new UnsupportedOperationException();
	}

	public ResourceIndexer getIndexerFor(String fileExtension) {
		IExtensionPoint extensionPoint = registry.getExtensionPoint(ORG_ECLIPSE_EMF_INDEX_INDEXER);
		IExtension[] extensions = extensionPoint.getExtensions();
		for (IExtension iExtension : extensions) {
			IConfigurationElement[] configurationElements = iExtension.getConfigurationElements();
			for (IConfigurationElement iConfigurationElement : configurationElements) {
				String attribute = iConfigurationElement.getAttribute(FILE_EXTENSIONS);
				if (toList(attribute).contains(fileExtension))
					try {
						return (ResourceIndexer) iConfigurationElement.createExecutableExtension(CLASS);
					} catch (CoreException e) {
						EmfIndexUIPlugin.logError("Error instantiating resource indexer. Contributed by "
								+ iExtension.getNamespaceIdentifier(), e);
					}
			}
		}
		return null;
	}

	/**
	 * @param attribute
	 * @return
	 */
	public static List<String> toList(String attribute) {
		String[] split = attribute.split(",");
		List<String> result = new ArrayList<String>(split.length);
		for (String string : split) {
			String trim = string.trim();
			if (trim.length() > 0)
				result.add(trim);
		}
		return result;
	}

}
