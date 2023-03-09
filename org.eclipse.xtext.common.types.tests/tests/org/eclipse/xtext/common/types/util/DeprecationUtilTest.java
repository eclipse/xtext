/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Predicate;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DeprecationUtilTest extends Assert {

	private ClasspathTypeProvider typesProvider = new ClasspathTypeProviderFactory(getClass().getClassLoader(), null).createTypeProvider();

	@Test
	public void testDeprecationUtil() {
		JvmDeclaredType clazz = (JvmDeclaredType) typesProvider.findTypeByName("org.eclipse.xtext.common.types.util.Deprecation");
		assertFalse(DeprecationUtil.isDeprecated(getOperation(clazz, "test")));
		assertTrue(DeprecationUtil.isDeprecated(getOperation(clazz, "deprecated")));
		assertTrue(DeprecationUtil.isDeprecated(getOperation(clazz, "deprecatedAndTest")));
		assertTrue(DeprecationUtil.isDeprecated(getOperation(clazz, "testAndDeprecated")));
		assertFalse(DeprecationUtil.isDeprecated(getOperation(clazz, "localDeprecated")));
	}
	
	@Test
	public void testDeprecationUtil_2() {
		JvmDeclaredType clazz = (JvmDeclaredType) typesProvider.findTypeByName("org.eclipse.xtext.common.types.util.Deprecation2");
		assertTrue(DeprecationUtil.isTransitivelyDeprecated(getOperation(clazz, "implicitDeprecated")));
	}
	
	protected JvmOperation getOperation(JvmDeclaredType type, final String name) {
		JvmOperation operation = find(type.getDeclaredOperations(), new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation op) {
				return equal(name, op.getSimpleName());
			}
		});
		return operation;
	}
}
