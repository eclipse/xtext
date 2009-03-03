/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.dao.AbstractEObjectDAOTest;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EPackageDescriptor;
import org.eclipse.emf.index.impl.memory.EClassDAOImpl;
import org.eclipse.emf.index.impl.memory.EObjectDAOImpl;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EObjectDAOTest extends AbstractEObjectDAOTest {

	@Override
	protected EPackageDescriptor.DAO createEPackageDAO() {
		return new EPackageDAOImpl(indexStore);
	}

	@Override
	protected EClassDescriptor.DAO createEClassDAO() {
		return new EClassDAOImpl(indexStore);
	}

	@Override
	protected ResourceDescriptor.DAO createResourceDAO() {
		return new ResourceDAOImpl(indexStore);
	}

	@Override
	protected EObjectDescriptor.DAO createEObjectDAO() {
		return new EObjectDAOImpl(indexStore);
	}

}
