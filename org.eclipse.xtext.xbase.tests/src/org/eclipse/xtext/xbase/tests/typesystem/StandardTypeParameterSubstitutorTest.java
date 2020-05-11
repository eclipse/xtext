/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardTypeParameterSubstitutorTest extends AbstractXbaseTestCase {
	@Inject
	private IBatchTypeResolver typeResolver;

	@Test
	public void testArrayOfWildcard() {
		LightweightTypeReference substituted = substituteInArrayContext("?");
		Assert.assertEquals("Object[]", substituted.getSimpleName());
	}

	@Test
	public void testArrayOfWildcardString() {
		LightweightTypeReference substituted = substituteInArrayContext("? extends String");
		Assert.assertEquals("String[]", substituted.getSimpleName());
	}

	@Test
	public void testArrayOfWildcardSuperString() {
		LightweightTypeReference substituted = substituteInArrayContext("? super String");
		Assert.assertEquals("Object[]", substituted.getSimpleName());
	}

	protected LightweightTypeReference substituteInArrayContext(String componentType) {
		LightweightTypeReference typeReference = toTypeReference("Iterable<" + componentType + ">");
		DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = collector.getTypeParameterMapping(typeReference);
		Assert.assertEquals(1, mapping.size());
		JvmTypeParameter typeParameter = Iterables.getFirst(mapping.keySet(), null);
		LightweightMergedBoundTypeArgument boundArgument = mapping.get(typeParameter);
		Assert.assertEquals(componentType, boundArgument.getTypeReference().getSimpleName());
		ITypeReferenceOwner owner = typeReference.getOwner();
		ArrayTypeReference originalArray = owner.newArrayTypeReference(owner.newParameterizedTypeReference(typeParameter));
		Assert.assertEquals("T[]", originalArray.getSimpleName());
		LightweightTypeReference substitutedArray = new StandardTypeParameterSubstitutor(mapping, typeReference.getOwner()).substitute(originalArray);
		return substitutedArray;
	}

	protected LightweightTypeReference toTypeReference(CharSequence reference) {
		try {
			String expression = "null as " + reference;
			XCastedExpression castExpression = (XCastedExpression) expression(expression);
			IResolvedTypes resolvedTypes = typeResolver.resolveTypes(castExpression);
			return resolvedTypes.getActualType(castExpression);
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}
}
