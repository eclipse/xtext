/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.tests.AbstractPortableURIsTest;
import org.junit.Test;

/**
 * @author zarnekow - Initial contribution and API
 */
// UI Test
public class URIsInEcoreFilesTest extends AbstractPortableURIsTest {
	
	@Test public void testXtext() {
		doTestResource("org.eclipse.xtext/org/eclipse/xtext/Xtext.ecore", "xtext");
	}
	
	@Test public void testXtextGenmodel() {
		doTestResource("org.eclipse.xtext/org/eclipse/xtext/Xtext.genmodel", "xtext");
	}
	
}
