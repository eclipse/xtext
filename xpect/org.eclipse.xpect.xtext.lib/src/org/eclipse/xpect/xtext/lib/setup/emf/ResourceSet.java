/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.setup.emf;

import java.util.List;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.setup.XpectSetupComponent;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectSetupComponent
@XpectImport(ResourceSetDefaultsSetup.class)
public class ResourceSet {
	private final List<ResourceFactory> factories = Lists.newArrayList();

	public void add(ResourceFactory file) {
		factories.add(file);
	}

	public List<ResourceFactory> getFactories() {
		return factories;
	}
}
