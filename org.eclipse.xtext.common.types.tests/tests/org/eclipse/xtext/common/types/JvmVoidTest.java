/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmVoidTest extends Assert {

	private JvmVoid _void;

	@Before
	public void setUp() throws Exception {
		_void = TypesFactory.eINSTANCE.createJvmVoid();
	}
	
	@Test public void testGetIdentifier_01() {
		assertEquals("void", _void.getIdentifier());
	}
	
	@Test public void testGetQualifiedName() {
		assertEquals("void", _void.getQualifiedName());
		assertEquals("void", _void.getQualifiedName('$'));
	}
	
	@Test public void testGetSimpleName() {
		assertEquals("void", _void.getSimpleName());
	}
	
}
