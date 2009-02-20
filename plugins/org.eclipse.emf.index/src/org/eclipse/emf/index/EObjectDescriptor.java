/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Primary key: (fragment, resourceDescriptor.uri)
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EObjectDescriptor {
	public interface Factory {
		EObjectDescriptor createDescriptor(EObject eObject, ResourceDescriptor resourceDescriptor,
				EClassDescriptor typeDescriptor);

		boolean isFactoryFor(EClass eClass);
	}

	public interface DAO extends IDAO<EObjectDescriptor> {
		Query createQuery();

		IGenericQuery<EObjectDescriptor> createQueryEObjectByURI(URI fragmentURI);

		IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EClass eClass);

		IGenericQuery<EObjectDescriptor> createQueryEObjectInResource(EObject eObject,
				ResourceDescriptor resourceDescriptor);

	    IGenericQuery<EObjectDescriptor> createQueryEObjectsByType(EClassDescriptor eClassDescriptor);
	    
		IGenericQuery<EObjectDescriptor> createQueryEObjectsInResource(ResourceDescriptor resourceDescriptor);
	}

	public interface Query extends IGenericQuery<EObjectDescriptor> {
		EClassDescriptor.Query eClass();

		Query eClass(EClassDescriptor typeDescriptor);

		Query resource(ResourceDescriptor resourceDescriptor);

		ResourceDescriptor.Query resource();

		Query fragment(String pattern);

		Query userData(String key, String pattern);

		Query name(String pattern);
	}

	ResourceDescriptor getResourceDescriptor();

	EClassDescriptor getEClassDescriptor();

	String getName();

	String getDisplayName();

	String getFragment();

	URI getFragmentURI();

	String getUserData(String key);
}