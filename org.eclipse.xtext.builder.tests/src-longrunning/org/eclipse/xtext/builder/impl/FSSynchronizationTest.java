/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
public class FSSynchronizationTest extends AbstractFSSynchronizationTest {
	
	@Override
	@Test
	@Ignore("https://github.com/eclipse/xtext-eclipse/issues/681")
	// TODO fix and delete me
	public void testCleanUpDerivedResourcesWithCreateBetween() {
		super.testCleanUpDerivedResourcesWithCreateBetween();
	}

}
