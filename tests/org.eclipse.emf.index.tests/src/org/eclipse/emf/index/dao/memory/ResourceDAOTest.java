/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.dao.memory;

import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.dao.AbstractResourceDAOTest;
import org.eclipse.emf.index.impl.memory.ResourceDAOImpl;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceDAOTest extends AbstractResourceDAOTest {

	@Override
	protected ResourceDescriptor.DAO createResourceDAO() {
		return new ResourceDAOImpl(indexStore);
	}

}
