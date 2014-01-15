/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClassMirrorTest extends Assert implements ITypeFactory<BinaryClass, JvmDeclaredType> {

	@Test public void testCreateClassMirror_01() {
		BinaryClassMirror mirror = BinaryClassMirror.createClassMirror(new BinaryClass("java.lang.String", null), this);
		assertNotNull(mirror);
	}
	
	@Test public void testCreateClassMirror_02() {
		try {
			BinaryClassMirror.createClassMirror(new BinaryClass.Primitive(int.class), this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	@Test public void testCreateClassMirror_03() {
		try {
			BinaryClassMirror.createClassMirror(new BinaryClass.Array(new BinaryClass("java.lang.String", null), 1, ""), this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	@Test public void testCreateClassMirror_04() {
		BinaryClassMirror mirror = BinaryClassMirror.createClassMirror(new BinaryClass("java.util.Map$Entry", null), this);
		assertNotNull(mirror);
	}

	public JvmDeclaredType createType(BinaryClass clazz) {
		fail("Unexpected call");
		return null;
	}
}
