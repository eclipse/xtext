/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.EagerResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetBasedAllContainersStateProvider implements IAllContainersState.Provider {

	private final static Logger log = Logger.getLogger(ResourceSetBasedAllContainersStateProvider.class);

	@Override
	public IAllContainersState get(IResourceDescriptions context) {
		ResourceSet resourceSet = getResourceSet(context);
		IAllContainersState adapter = (IAllContainersState) EcoreUtil.getAdapter(resourceSet.eAdapters(),
				IAllContainersState.class);
		if (adapter == null) {
			return handleAdapterNotFound(resourceSet);
		}
		return adapter;
	}
	
	/**
	 * @since 2.4
	 */
	protected ResourceSet getResourceSet(IResourceDescriptions context) {
		if (context instanceof ResourceSetBasedResourceDescriptions) 
			return ((ResourceSetBasedResourceDescriptions) context).getResourceSet();
		else if (context instanceof EagerResourceSetBasedResourceDescriptions) 
			return ((EagerResourceSetBasedResourceDescriptions) context).getResourceSet();
		String contextType = context == null ? "null" : context.getClass().getName();
		throw new IllegalStateException("Passed " + contextType + " is not based on a resource set");
	}

	protected IAllContainersState handleAdapterNotFound(final ResourceSet resourceSet) {
		if (log.isDebugEnabled())
			log.debug("No explicit container state set. Falling back to default.");
		FlatResourceSetBasedAllContainersState containersState = new FlatResourceSetBasedAllContainersState(resourceSet);
		return containersState;
	}

}
