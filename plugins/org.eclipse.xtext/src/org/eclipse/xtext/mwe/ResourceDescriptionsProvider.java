/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

public class ResourceDescriptionsProvider {
	public IResourceDescriptions get(ResourceSet resourceSet) {
		ResourceSetBasedResourceDescriptions descriptions = new ResourceSetBasedResourceDescriptions();
		descriptions.setContext(resourceSet);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		return descriptions;
	}
}