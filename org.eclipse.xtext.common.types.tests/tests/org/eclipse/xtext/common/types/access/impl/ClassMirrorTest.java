/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class ClassMirrorTest extends Assert implements ITypeFactory<Class<?>, JvmDeclaredType> {

	@Test public void testCreateClassMirror_01() {
		ClassMirror mirror = ClassMirror.createClassMirror(String.class, this);
		assertNotNull(mirror);
	}
	
	@Test public void testCreateClassMirror_02() {
		try {
			ClassMirror.createClassMirror(int.class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	@Test public void testCreateClassMirror_03() {
		try {
			ClassMirror.createClassMirror(String[].class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	@Test public void testCreateClassMirror_04() {
		try {
			ClassMirror.createClassMirror(java.util.Map.Entry.class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}

	@Override
	public JvmDeclaredType createType(Class<?> clazz) {
		fail("Unexpected call");
		return null;
	}
}
