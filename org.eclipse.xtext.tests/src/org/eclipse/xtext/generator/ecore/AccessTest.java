/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.ecore;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedPackage1Package;
import org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage;
import org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage;
import org.junit.Assert;
import org.junit.Test;

public abstract class AccessTest extends Assert {
	
	@Test public void testRootPackage() {
		Assert.assertNotNull(RootPackage.eINSTANCE);
		Assert.assertNotNull(RootPackage.Literals.ROOT_CLASS);
		Assert.assertNotNull(RootPackage.Literals.ROOT_DATA_TYPE);
		Assert.assertNotNull(RootPackage.Literals.ROOT_ENUM);
		Assert.assertNotNull(RootPackage.Literals.ROOT_CLASS__ATTRIBUTE1);
		Assert.assertNotNull(RootPackage.Literals.ROOT_CLASS__REFERENCE1);
		Assert.assertEquals(0,RootPackage.ROOT_CLASS);
		Assert.assertEquals(2,RootPackage.ROOT_DATA_TYPE);
		Assert.assertEquals(1,RootPackage.ROOT_ENUM);
		Assert.assertEquals(0,RootPackage.ROOT_CLASS__ATTRIBUTE1);
		Assert.assertEquals(1,RootPackage.ROOT_CLASS__REFERENCE1);
	}

	@Test public void testNestedPackage() {
		Assert.assertNotNull(NestedPackage1Package.eINSTANCE);
		Assert.assertNotNull(NestedPackage1Package.Literals.NESTED_CLASS1);
		Assert.assertEquals(0,NestedPackage1Package.NESTED_CLASS1);
	}

	@Test public void testNoLiteralPackage() {
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE);
		Assert.assertFalse(false);
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE.getNoLitClass());
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE.getNoLitDataType());
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE.getNoLitClass_Attribute2());
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE.getNoLitClass_Reference2());
		Assert.assertNotNull(NoLiteralsPackage.eINSTANCE.getNoLitEnum());
	}
	
}
