/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(NewTypeSystemRuntimeInjectorProvider.class)
public class FeatureCallValidationTest2 extends FeatureCallValidationTest {
	
	@Override
	@Test
	public void testThisInStaticContext() throws Exception {
		super.testThisInStaticContext();
	}
	
	@Override
	@Test
	public void testSuperInStaticContext() throws Exception {
		super.testSuperInStaticContext();
	}
	
}
