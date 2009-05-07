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

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IndexStore {

	EPackageDescriptor.DAO ePackageDAO();

	EClassDescriptor.DAO eClassDAO();

	ResourceDescriptor.DAO resourceDAO();

	EObjectDescriptor.DAO eObjectDAO();

	EReferenceDescriptor.DAO eReferenceDAO();

	void addIndexChangeListener(IndexChangeListener listener);

	void removeIndexChangeListener(IndexChangeListener listener);

	/*
	 * The following methods should be called by DAOs only.
	 * TODO: consider moving them to a separate interface
	 */
	void fireIndexChangedEvent(IndexChangeEvent event);

	void beginTransaction();
	
	void endTransaction();
}
