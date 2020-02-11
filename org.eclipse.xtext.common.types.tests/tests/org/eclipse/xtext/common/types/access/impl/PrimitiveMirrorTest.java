/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveMirrorTest extends Assert implements ITypeFactory<Class<?>, JvmType> {

	private PrimitiveMirror mirror;
	private PrimitiveTypeFactory helper;
	private int callCount;
	private TypeResource resource;

	@Before
	public void setUp() throws Exception {
		callCount = 0;
		helper = new PrimitiveTypeFactory();
		mirror = new PrimitiveMirror(this);
		resource = new TypeResource();
		resource.setMirror(mirror);
	}
	
	@After
	public void tearDown() throws Exception {
		mirror = null;
		helper = null;
		resource = null;
	}

	@Test public void testSetup_01() {
		assertTrue(resource.getContents().isEmpty());
	}
	
	@Test public void testInitialize_01() {
		mirror.initialize(resource);
		assertEquals(9, callCount); // byte, short, integer, long, char, float, double, boolean, void
		assertEquals(callCount, resource.getContents().size());
	}

	@Override
	public JvmType createType(Class<?> clazz) {
		callCount++;
		return helper.createType(clazz);
	}
}
