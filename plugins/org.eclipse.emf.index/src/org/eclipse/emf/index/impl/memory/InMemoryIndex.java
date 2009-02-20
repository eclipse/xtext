/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import org.eclipse.emf.index.IIndexFeeder;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.EPackageDescriptor.DAO;
import org.eclipse.emf.index.impl.IndexFeederImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class InMemoryIndex implements IIndexStore {

	private EClassDAOImpl eClassDAO;
	private ResourceDAOImpl resourceDAO;
	private EObjectDAOImpl eObjectDAO;
	private ECrossReferenceDAOImpl eCrossReferenceDAO;
	private EPackageDAOImpl ePackageDAO;
	private IIndexFeeder indexFeeder;

	public InMemoryIndex() {
		eObjectDAO = new EObjectDAOImpl(this);
		eClassDAO = new EClassDAOImpl(this);
		eCrossReferenceDAO = new ECrossReferenceDAOImpl(this);
		resourceDAO = new ResourceDAOImpl(this);
		ePackageDAO = new EPackageDAOImpl(this);
		indexFeeder = new IndexFeederImpl(this);
	}

	public EClassDAOImpl eClassDAO() {
		return eClassDAO;
	}

	public ResourceDAOImpl resourceDAO() {
		return resourceDAO;
	}

	public EObjectDAOImpl eObjectDAO() {
		return eObjectDAO;
	}

	public ECrossReferenceDAOImpl eCrossReferenceDAO() {
		return eCrossReferenceDAO;
	}

	public DAO ePackageDAO() {
		return ePackageDAO;
	}
	
	public IIndexFeeder indexFeeder() {
		return indexFeeder;
	}

}
