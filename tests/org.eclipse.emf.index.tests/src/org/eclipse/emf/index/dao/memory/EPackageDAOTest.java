/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.EPackageDescriptor.DAO;
import org.eclipse.emf.index.dao.AbstractEPackageDAOTest;
import org.eclipse.emf.index.impl.memory.EPackageDAOImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EPackageDAOTest extends AbstractEPackageDAOTest {

	@Override
	protected DAO createEPackageDAO() {
		return new EPackageDAOImpl(indexStore);
	}
	
}
