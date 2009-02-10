/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class InheritanceTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new ConcreteTestLanguageRuntimeModule());
	}

	public void testSimple() throws Exception {
		EObject model = getModel("model 23.34 : element A element B");
		assertEquals(23.34, invokeWithXtend("magicNumber", model));
		assertWithXtend("'A'", "elements.get(0).name", model);
		assertWithXtend("'B'", "elements.get(1).name", model);
	}
}
