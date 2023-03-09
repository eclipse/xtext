/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.util.List;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferenceBuilderTest extends AbstractJvmModelTest {
	@Inject
	private JvmTypeReferenceBuilder.Factory typeReferenceBuilderFactory;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private JvmTypeReferenceBuilder typeReferenceBuilder;

	@Before
	public void setUp() {
		typeReferenceBuilder = typeReferenceBuilderFactory.create(resourceSetProvider.get());
	}

	@Test
	public void testTypeRef_01() {
		JvmTypeReference stringType = typeReferenceBuilder.typeRef(String.class);
		Assert.assertEquals("java.lang.String", stringType.getIdentifier());
	}

	@Test
	public void testTypeRef_02() {
		JvmParameterizedTypeReference type = (JvmParameterizedTypeReference) typeReferenceBuilder.typeRef(List.class);
		Assert.assertEquals("java.util.List", type.getIdentifier());
		Assert.assertTrue(type.getArguments().isEmpty());
	}

	@Test
	public void testTypeRef_03() {
		try {
			typeReferenceBuilder.typeRef(List.class, typeReferenceBuilder.typeRef(String.class),
					typeReferenceBuilder.typeRef(String.class));
			Assert.fail();
		} catch (IllegalArgumentException e) {
			// ok
		}
	}

	@Test
	public void testTypeRef_04() {
		try {
			typeReferenceBuilder.typeRef(List[].class, typeReferenceBuilder.typeRef(String.class));
			Assert.fail();
		} catch (IllegalArgumentException e) {
			// ok
		}
	}

	@Test
	public void testTypeRef_05() {
		JvmTypeReference typeRef = typeReferenceBuilder.typeRef("hubble.Fubble", typeReferenceBuilder.typeRef(String.class));
		Assert.assertTrue(typeRef instanceof JvmUnknownTypeReference);
		Assert.assertEquals("hubble.Fubble", typeRef.getQualifiedName());
	}

	@Test
	public void testWildcard_01() {
		JvmTypeConstraint firstConstraint = Iterables
				.getFirst(((JvmWildcardTypeReference) typeReferenceBuilder.wildcard()).getConstraints(), null);
		Assert.assertEquals("java.lang.Object", firstConstraint.getTypeReference().getIdentifier());
	}

	@Test
	public void testWildcard_02() {
		List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) typeReferenceBuilder
				.wildcardExtends(typeReferenceBuilder.typeRef(CharSequence.class))).getConstraints();
		Assert.assertEquals(1, constraints.size());
		JvmUpperBound upperBound = Iterables.getFirst(Iterables.filter(constraints, JvmUpperBound.class), null);
		Assert.assertEquals("java.lang.CharSequence", upperBound.getTypeReference().getIdentifier());
	}

	@Test
	public void testWildcard_03() {
		List<JvmTypeConstraint> constraints = ((JvmWildcardTypeReference) typeReferenceBuilder
				.wildcardSuper(typeReferenceBuilder.typeRef(CharSequence.class))).getConstraints();
		Assert.assertEquals(2, constraints.size());
		JvmLowerBound lowerBound = Iterables.getFirst(Iterables.filter(constraints, JvmLowerBound.class), null);
		Assert.assertEquals("java.lang.CharSequence", lowerBound.getTypeReference().getIdentifier());
	}
}
