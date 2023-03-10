/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.participant;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ResourceRelocationStrategyRegistry {

	private static Logger LOG = Logger.getLogger(ResourceRelocationStrategyRegistry.class);

	private static final String EXTENSION_POINT_ID = "org.eclipse.xtext.ui.resourceRelocationStrategy";

	private List<IResourceRelocationStrategy> strategies;

	public List<? extends IResourceRelocationStrategy> getStrategies() {
		if (strategies != null) {
			return strategies;
		} else {
			IConfigurationElement[] configurationElements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(ResourceRelocationStrategyRegistry.EXTENSION_POINT_ID);
			strategies = new ArrayList<>();
			for (IConfigurationElement configurationElement : configurationElements) {
				try {
					strategies.add((IResourceRelocationStrategy) configurationElement.createExecutableExtension("class"));
				} catch (CoreException e) {
					LOG.error("Error instantiating participant strategy", e);
				}
			}
			return strategies;
		}
	}
}
