/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ecore;

import java.io.Serializable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.index.IDAO;
import org.eclipse.emf.index.IGenericQuery;

/**
 * Primary key: (name, nsURI)
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface EClassDescriptor extends Serializable {

	public interface DAO extends IDAO<EClassDescriptor> {
		Query createQuery();

		IGenericQuery<EClassDescriptor> createQueryEClass(EClass eClass);

		IGenericQuery<EClassDescriptor> createQueryEClassesInPackage(EPackageDescriptor ePackageDescriptor);
	}

	public interface Query extends IGenericQuery<EClassDescriptor> {
		Query ePackage(EPackageDescriptor ePackageDescriptor);

		EPackageDescriptor.Query ePackage();

		Query name(String pattern);

		EClassDescriptor.Query superClass();

		Query superClass(EClassDescriptor eClassDescriptor);
	}

	EPackageDescriptor getEPackageDescriptor();

	String getName();

	String getDisplayName();

	EClassDescriptor[] getSuperClasses();

	/**
	 * Convenience method to access the EClass. The eClass itself should must
	 * not be stored in the index.
	 * 
	 * @return the eClass
	 */
	EClass getEClass();
}