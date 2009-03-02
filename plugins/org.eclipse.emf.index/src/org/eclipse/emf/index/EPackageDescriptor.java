/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.util.Date;

import org.eclipse.emf.ecore.EPackage;

/**
 * Primary key: (nsUri)
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EPackageDescriptor {
	public interface Factory {
		EPackageDescriptor createDescriptor(EPackage ePackage, long indexingDate);
	
		boolean isFactoryFor(EPackage ePackage);
	}

	public interface DAO extends IDAO<EPackageDescriptor>{
		Query createQuery();

		IGenericQuery<EPackageDescriptor> createQueryEPackage(EPackage ePackage);
	}

	public interface Query extends IGenericQuery<EPackageDescriptor> {
		Query nsURI(String pattern);

		Query name(String pattern);
		
		Query indexingDate(long date);
		
		Query indexingDate(Date date);
	}

	String getNsURI();
	
	String getName();
	
	long getIndexingDate();
	
	/**
	 * Convenience method to access the EPackage. The ePackage itself should must
	 * not be stored in the index.
	 * 
	 * @return the ePackage
	 */
	EPackage getEPackage();
}