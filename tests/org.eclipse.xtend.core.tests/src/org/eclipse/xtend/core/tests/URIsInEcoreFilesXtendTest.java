/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import org.eclipse.xtext.junit4.internal.AbstractPortableURIsTest;
import org.junit.Test;

/**
 * @author Sven Efftinge
 */
public class URIsInEcoreFilesXtendTest extends AbstractPortableURIsTest {

	@Test
	public void testXtend() {
		doTestResource("org.eclipse.xtend.core/model/Xtend.ecore", "xtend");
	}

	@Test
	public void testXtendGenModel() {
		doTestResource("org.eclipse.xtend.core/model/Xtend.genmodel", "xtend");
	}

	@Test
	public void testRichStrings() {
		doTestResource("org.eclipse.xtend.core/model/RichStrings.ecore", "richstring");
	}

	@Test
	public void testRichStringsGenModel() {
		doTestResource("org.eclipse.xtend.core/model/RichStrings.genmodel", "richstring");
	}

}
