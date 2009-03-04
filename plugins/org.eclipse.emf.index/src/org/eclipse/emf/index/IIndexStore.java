/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.IndexChangeListener;
import org.eclipse.emf.index.impl.IndexStoreFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IIndexStore {

	static final IIndexStore INSTANCE = IndexStoreFactory.createIndexStore();

	EPackageDescriptor.DAO ePackageDAO();

	EClassDescriptor.DAO eClassDAO();

	ResourceDescriptor.DAO resourceDAO();

	EObjectDescriptor.DAO eObjectDAO();

	ECrossReferenceDescriptor.DAO eCrossReferenceDAO();

	void beginTransaction();

	void endTransaction();

	void addIndexChangeListener(IndexChangeListener listener);

	void removeIndexChangeListener(IndexChangeListener listener);

	/**
	 * Should be called by DAOs only.
	 * 
	 * @param event
	 */
	void fireIndexChangedEvent(IndexChangeEvent event);
}