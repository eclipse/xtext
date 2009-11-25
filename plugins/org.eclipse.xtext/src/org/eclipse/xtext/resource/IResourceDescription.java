/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionProviderRegistry;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResourceDescription {

	/**
	 * @return descriptions of all EObjects provided by the given Resource. The result is expected
	 * 	to return any combination of <code>name</code> and <code>eObjectOrProxy</code> only once
	 *  as an {@link IEObjectDescription}.
	 */
	Iterable<IEObjectDescription> getExportedObjects();
	
	/**
	 * returns the list of names the described resource depends
	 * depends on. 
	 */
	Iterable<String> getImportedNames();
	
	URI getURI();
	
//	boolean isDirtyState();
	
//	String getContainerName();
	
	@ImplementedBy(DefaultResourceDescriptionProvider.class)
	interface Provider {
		IResourceDescription getResourceDescription(Resource resource);
		
		@ImplementedBy(DefaultResourceDescriptionProviderRegistry.class)
		interface Registry {
			IResourceDescription.Provider getResourceDescriptionProvider(Resource resource);
		}
	}
	
}
