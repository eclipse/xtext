/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.lang.annotation.RetentionPolicy;
import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow
 */
public abstract class AbstractTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
	@Inject
	private TypeReferences typeReferences;

	private XtextResourceSet resourceSet;

	@Before
	public void createResourceSet() {
		resourceSet = get(XtextResourceSet.class);
	}

	@After
	public void tearDown() {
		resourceSet = null;
	}

	public abstract String resolve(JvmTypeReference declaration, JvmTypeReference reference);

	@Test
	public void testResolve_01() {
		JvmTypeReference declaration = typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, resourceSet);
		JvmTypeReference resolveMe = declaration;
		String resolved = resolve(declaration, resolveMe);
		Assert.assertEquals("NestedList<T>", resolved);
	}

	@Test
	public void testResolve_02() {
		JvmTypeReference declaration = typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, resourceSet);
		JvmTypeReference resolveMe = typeReferences.getTypeForName(List.class, resourceSet);
		String resolved = resolve(declaration, resolveMe);
		Assert.assertEquals("List<List<T>>", resolved);
	}

	@Test
	public void testResolve_03() {
		JvmTypeReference declaration = typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, resourceSet);
		JvmTypeReference resolveMe = typeReferences.getTypeForName(Iterable.class, this.resourceSet);
		String resolved = resolve(declaration, resolveMe);
		Assert.assertEquals("Iterable<List<T>>", resolved);
	}

	@Test
	public void testResolve_04() {
		JvmTypeReference declaration = typeReferences.getTypeForName(TypeResolutionTestData.NestedList.class, resourceSet);
		JvmTypeReference resolveMe = typeReferences.getTypeForName(Iterable.class, resourceSet);
		String resolved = resolve(declaration, resolveMe);
		Assert.assertEquals("Iterable<List<T>>", resolved);
	}

	@Test
	public void testResolve_05() {
		JvmTypeReference declaration = typeReferences.getTypeForName(RetentionPolicy.class, resourceSet);
		JvmTypeReference resolveMe = typeReferences.getTypeForName(Enum.class, resourceSet);
		String resolved = resolve(declaration, resolveMe);
		Assert.assertEquals("Enum<RetentionPolicy>", resolved);
	}
}
