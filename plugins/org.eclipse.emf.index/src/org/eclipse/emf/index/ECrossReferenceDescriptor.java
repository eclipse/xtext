/*******************************************************************************
t * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.emf.index;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ECrossReferenceDescriptor {

	static final int NO_INDEX = -1;
	
	public interface DAO extends IDAO<ECrossReferenceDescriptor>{
		Query createQuery();
		
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObject target);
	
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(URI sourceURI);
		
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(URI targetURI);
	}

	public interface Query extends IGenericQuery<ECrossReferenceDescriptor> {
		
		Query sourceFragment(String pattern);
		
		Query sourceResource(ResourceDescriptor sourceResourceDescriptor);
		
		ResourceDescriptor.Query sourceResource();
		
		Query targetFragment(String pattern);
		
		Query targetResource(ResourceDescriptor targetResourceDescriptor);

		ResourceDescriptor.Query targetResource();

		Query referenceName(String pattern);
		
		Query index(int index);
	}

	String getSourceFragment();
	
	String getTargetFragment();
	
	ResourceDescriptor getSourceResourceDescriptor();

	ResourceDescriptor getTargetResourceDescriptor();
	
	int getIndex();
	
	String getReferenceName();

	/**
	 * Derived
	 * @return
	 */
	URI getSourceURI();

	/**
	 * Derived
	 * @return
	 */
	URI getTargetURI();
	
}