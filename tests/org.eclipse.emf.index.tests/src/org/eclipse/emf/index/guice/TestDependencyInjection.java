/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.guice;

import org.eclipse.emf.index.IndexStore;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class TestDependencyInjection extends AbstractEmfIndexTest {
	
	@Inject 
	private IndexStore indexStore;

	public void testIndexStoreSingleton() throws Exception {
		TestClass testClass = new TestClass();
		injector.injectMembers(testClass);
		assertEquals(indexStore, testClass.indexStore);
	}
	
	private static class TestClass {
		@Inject 
		public IndexStore indexStore;
	}
}
