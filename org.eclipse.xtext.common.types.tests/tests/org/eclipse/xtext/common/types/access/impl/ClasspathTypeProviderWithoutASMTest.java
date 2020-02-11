/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.access.binary.asm.ClassFileBytesAccess;
import org.eclipse.xtext.common.types.access.reflect.ReflectionTypeProviderTest;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderWithoutASMTest extends ReflectionTypeProviderTest {

	@Override
	protected AbstractRuntimeJvmTypeProvider createTypeProvider() {
		return new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet, indexedJvmTypeAccess, null) {
			@Override
			protected ITypeFactory<BinaryClass, JvmDeclaredType> createDeclaredTypeFactory(ClassFileBytesAccess readerAccess, ClassLoader classLoader) {
				return new DeclaredTypeFactory(readerAccess, classLoader, false);
			}
		};
	}
	
	@Override
	@Test
	public void testCreateMirror_01() {
		URI uri = URI.createURI("java:/Objects/java.util.Map");
		IMirror mirror = getTypeProvider().createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof BinaryClassMirror);
		assertEquals("java.util.Map", ((BinaryClassMirror) mirror).getMirroredClass().getName());
	}
}

