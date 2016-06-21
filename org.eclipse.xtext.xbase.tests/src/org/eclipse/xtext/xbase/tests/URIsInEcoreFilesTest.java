/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class URIsInEcoreFilesTest extends AbstractPortableURIsTest {

	@Test public void testXbase() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.ecore", "xbase");
	}
	
	@Test public void testXtype() {
		doTestResource("org.eclipse.xtext.xbase/model/Xtype.ecore", "xtype");
	}
	
	@Test public void testXbaseWithAnnotations() {
		doTestResource("org.eclipse.xtext.xbase/model/XAnnotations.ecore", "xAnnotations");
	}
	
	@Test public void testXbaseGenmodel() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.genmodel", "xbase", "xtype", "xAnnotations");
	}
	
	@Test public void testCommonTypes() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.ecore", "types");
	}

	@Test public void testCommonTypesGenModel() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.genmodel", "types");
	}
	
}
