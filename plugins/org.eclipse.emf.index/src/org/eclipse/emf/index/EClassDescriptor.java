/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.ecore.EClass;

/**
 * Primary key: (name, nsURI)
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EClassDescriptor {
	public interface Factory {
		EClassDescriptor createDescriptor(EClass eClass, EPackageDescriptor ePackageDescriptor);
	}

	public interface DAO extends IDAO<EClassDescriptor>{
		Query createQuery();
		
		IGenericQuery<EClassDescriptor> createQueryEClass(EClass eClass);

		IGenericQuery<EClassDescriptor> createQueryEClassesInPackage(EPackageDescriptor ePackageDescriptor);
	}

	public interface Query extends IGenericQuery<EClassDescriptor>{
		Query ePackage(EPackageDescriptor ePackageDescriptor);
		
		EPackageDescriptor.Query ePackage();
		
		Query name(String pattern);
	}

	EPackageDescriptor getEPackageDescriptor();
	
	String getName();

	String getDisplayName();
	
	// TODO supertypes
}