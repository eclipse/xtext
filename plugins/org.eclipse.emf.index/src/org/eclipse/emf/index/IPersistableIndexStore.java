/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public interface IPersistableIndexStore extends IndexStore {

	void load(InputStream inputStream) throws IOException, ClassNotFoundException, ClassCastException;

	void save(OutputStream outputStream) throws IOException;

	public EClassDescriptor.DAO eClassDAO();

	public ResourceDescriptor.DAO resourceDAO();

	public EObjectDescriptor.DAO eObjectDAO();

	public EReferenceDescriptor.DAO eReferenceDAO();

	public EPackageDescriptor.DAO ePackageDAO();
}
