/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.search;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A filter to reject elements form the candidates in the global "Open Xtext Element" dialog. Filters can be registered
 * to the extension point <code>org.eclipse.xtext.ui.searchFilter</code>.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IXtextSearchFilter {

	/**
	 * The search dialog AND connects the results of this method called on all registered search filers. Users should
	 * therefore be as specific as possible in the implementation of this method in order not to interfer with filters
	 * from other languages.
	 * 
	 * @param element
	 *            the element to be checked
	 * @return <code>true</code> if the element should NOT appear in the dialog.
	 */
	boolean reject(IEObjectDescription element);

	public static class Registry {

		private static final Logger LOG = Logger.getLogger(IXtextSearchFilter.Registry.class);

		public static final String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".searchFilter";

		public static final String FILTER = "filter";

		public static final String NAMESPACE_DELIMITER = "namespace_delimiter";

		public static final String ATTRIBUTE = "class";

		public static final String VALUE = "value";
		
		public static final String DEFAULT_NAMESPACE_DELIMITER = ".";

		public static Collection<IXtextSearchFilter> allFilters() {
			IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_POINT_ID);
			List<IXtextSearchFilter> filters = Lists.newArrayList();
			for (IConfigurationElement configurationElement : configurationElements) {
				try {
					if (FILTER.equals(configurationElement.getName())) {
						IXtextSearchFilter filter = (IXtextSearchFilter) configurationElement
								.createExecutableExtension(ATTRIBUTE);
						filters.add(filter);
					}
				} catch (CoreException e) {
					LOG.error("Error instantiating IXtextSerachFilter from registry", e);
				}
			}
			return filters;
		}

		public static Collection<String> allNamespaceDelimiters() {
			IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_POINT_ID);
			Set<String> delimiters = Sets.newHashSet();
			delimiters.add(DEFAULT_NAMESPACE_DELIMITER);
			for (IConfigurationElement configurationElement : configurationElements) {
				if (NAMESPACE_DELIMITER.equals(configurationElement.getName())) {
					String delimiter = configurationElement.getAttribute(VALUE);
					if(delimiter.contains("*") || delimiter.contains("?")) {
						LOG.error("Invalid namespace delimiter in " + configurationElement.getContributor().getName() + ": '*' and '?' not allowed.");
					}
					delimiters.add(delimiter);
				}
			}
			return delimiters;
		}
	}
}
