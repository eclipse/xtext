/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.indexer;

import junit.framework.TestCase;

import org.eclipse.xtext.index.internal.dbaccess.IndexDatabase;


/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class DatabaseTest extends TestCase {

	private IndexDatabase indexDatabase;

	@Override
	protected void tearDown() throws Exception {
		if (indexDatabase != null) {
			indexDatabase.shutdown();
		}
	}

	public void testDatabase() throws Exception {
		indexDatabase = IndexDatabase.getInstance();
	}
}
