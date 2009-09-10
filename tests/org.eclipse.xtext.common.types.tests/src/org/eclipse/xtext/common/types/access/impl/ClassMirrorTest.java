/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import junit.framework.TestCase;

import org.eclipse.xtext.common.types.Type;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClassMirrorTest extends TestCase implements IClasspathTypeProvider {

	public void testCreateClassMirror_01() {
		ClassMirror mirror = ClassMirror.createClassMirror(String.class, this);
		assertNotNull(mirror);
	}
	
	public void testCreateClassMirror_02() {
		try {
			ClassMirror.createClassMirror(int.class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	public void testCreateClassMirror_03() {
		try {
			ClassMirror.createClassMirror(String[].class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}
	
	public void testCreateClassMirror_04() {
		try {
			ClassMirror.createClassMirror(java.util.Map.Entry.class, this);
			fail("Expected IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			// OK
		}
	}

	public <T> Type createType(Class<T> clazz) {
		fail("Unexpected call");
		return null;
	}
}
