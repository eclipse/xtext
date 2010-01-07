/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetBasedAllContainersStateProvider implements IAllContainersState.Provider{

	public IAllContainersState get(IResourceDescriptions context) {
		if (context instanceof ResourceSetBasedResourceDescriptions) {
			ResourceSetBasedResourceDescriptions resourceDescs = (ResourceSetBasedResourceDescriptions) context;
			ResourceSet resourceSet = resourceDescs.getResourceSet();
			IAllContainersState adapter = (IAllContainersState) EcoreUtil.getAdapter(resourceSet.eAdapters(), IAllContainersState.class);
			if (adapter == null)
				throw new IllegalStateException("No "+IAllContainersState.class.getName()+" installed.");
			return adapter;
		}
		throw new IllegalStateException("Passed "+IResourceDescriptions.class.getName()+" not of type "+ResourceSetBasedResourceDescriptions.class.getName());
	}

}
