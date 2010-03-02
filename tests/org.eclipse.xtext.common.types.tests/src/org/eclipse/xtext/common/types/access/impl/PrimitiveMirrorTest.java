/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.TypeResource;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveMirrorTest extends TestCase implements ITypeFactory<Class<?>> {

	private PrimitiveMirror mirror;
	private PrimitiveTypeFactory helper;
	private int callCount;
	private TypeResource resource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		callCount = 0;
		helper = new PrimitiveTypeFactory();
		mirror = new PrimitiveMirror(this);
		resource = new TypeResource();
		resource.setMirror(mirror);
	}
	
	@Override
	protected void tearDown() throws Exception {
		mirror = null;
		helper = null;
		resource = null;
		super.tearDown();
	}

	public void testSetup_01() {
		assertTrue(resource.getContents().isEmpty());
	}
	
	public void testInitialize_01() {
		mirror.initialize(resource);
		assertEquals(9, callCount); // byte, short, integer, long, char, float, double, boolean, void
		assertEquals(callCount, resource.getContents().size());
	}

	public JvmType createType(Class<?> clazz) {
		callCount++;
		return helper.createType(clazz);
	}
}
