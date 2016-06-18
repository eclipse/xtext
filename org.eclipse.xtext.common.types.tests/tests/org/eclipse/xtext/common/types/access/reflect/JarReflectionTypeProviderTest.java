/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import org.apache.log4j.Level;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.ClassLoaderFromJar;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.testSetups.Bug470767;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JarReflectionTypeProviderTest extends ReflectionTypeProviderTest {

	@Override
	protected AbstractRuntimeJvmTypeProvider createTypeProvider() {
		return new ReflectionTypeProvider(new ClassLoaderFromJar(), resourceSet, indexedJvmTypeAccess, services);
	}

	@Test
	public void testBug470767_02() {
		LoggingTester.captureLogging(Level.ERROR, ReflectionTypeFactory.class, new Runnable() {
			@Override
			public void run() {
				String typeName = Bug470767.class.getName();
				JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
				assertTrue(Iterables.isEmpty(type.getAllNestedTypes()));
			}
		}).assertLogEntry("Incomplete nested types for org.eclipse.xtext.common.types.testSetups.Bug470767");
	}
	
	@Override
	public void testBug470767() {
		LoggingTester.captureLogging(Level.ERROR, ReflectionTypeFactory.class, new Runnable() {
			@Override
			public void run() {
				JarReflectionTypeProviderTest.super.testBug470767();
			}
		}).assertLogEntry("Incomplete nested types for org.eclipse.xtext.common.types.testSetups.Bug470767");
	}
	
}
