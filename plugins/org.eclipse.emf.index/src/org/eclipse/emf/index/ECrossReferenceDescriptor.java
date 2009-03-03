/*******************************************************************************
t * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.emf.index;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface ECrossReferenceDescriptor {

	static final int NO_INDEX = -1;
	
	public interface DAO extends IDAO<ECrossReferenceDescriptor>{
		Query createQuery();
		
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObject target);
	
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReference(EObjectDescriptor sourceDescriptor, EReference reference);
		
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesFrom(EObjectDescriptor sourceDescriptor);
		
		IGenericQuery<ECrossReferenceDescriptor> createQueryCrossReferencesTo(EObjectDescriptor targetDescriptor);
	}

	public interface Query extends IGenericQuery<ECrossReferenceDescriptor> {
		EObjectDescriptor.Query source();
		
		Query source(EObjectDescriptor sourceDescriptor);
		
		EObjectDescriptor.Query target();
		
		Query target(EObjectDescriptor targetDescriptor);

		Query referenceName(String pattern);
	}

	EObjectDescriptor getSource();
	
	String getReferenceName();

	EObjectDescriptor getTarget();
	
	int getIndex();
}