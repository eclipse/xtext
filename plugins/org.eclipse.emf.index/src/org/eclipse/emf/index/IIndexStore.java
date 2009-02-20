/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.index.impl.IndexStoreFactory;


/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IIndexStore {
	
	static final IIndexStore eINSTANCE = IndexStoreFactory.createIndexStore();

	IIndexFeeder indexFeeder();
	
	EPackageDescriptor.DAO ePackageDAO();
	
	EClassDescriptor.DAO eClassDAO();

	ResourceDescriptor.DAO resourceDAO();

	EObjectDescriptor.DAO eObjectDAO();
	
	ECrossReferenceDescriptor.DAO eCrossReferenceDAO();
}