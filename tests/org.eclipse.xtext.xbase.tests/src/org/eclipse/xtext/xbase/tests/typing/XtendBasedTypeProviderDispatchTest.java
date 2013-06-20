/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendBasedTypeProviderDispatchTest extends Assert {
	
	@Test public void testDispatchType() {
		XBinaryOperation binaryOperation = XbaseFactory.eINSTANCE.createXBinaryOperation();
		try {
			new SomeCustomTypeProviderWithXtend().type(binaryOperation, null, true);
			fail("Expected runtime exception");
		} catch(RuntimeException e) {
			assertEquals(RuntimeException.class, e.getClass());
			assertEquals("This is expected", e.getMessage());
		}
	}
	
	@Test public void testDispatchExpectedType() {
		XMemberFeatureCall featureCall = XbaseFactory.eINSTANCE.createXMemberFeatureCall();
		try {
			new SomeCustomTypeProviderWithXtend().expectedType(featureCall, null, 0, true);
			fail("Expected runtime exception");
		} catch(RuntimeException e) {
			assertEquals(RuntimeException.class, e.getClass());
			assertEquals("This is expected", e.getMessage());
		}
	}
	
	@Test public void testDispatchTypeForIdentifiable() {
		JvmAnnotationType annotation = TypesFactory.eINSTANCE.createJvmAnnotationType();
		try {
			new SomeCustomTypeProviderWithXtend().typeForIdentifiable(annotation, true);
			fail("Expected runtime exception");
		} catch(RuntimeException e) {
			assertEquals(RuntimeException.class, e.getClass());
			assertEquals("This is expected", e.getMessage());
		}
	}

}
