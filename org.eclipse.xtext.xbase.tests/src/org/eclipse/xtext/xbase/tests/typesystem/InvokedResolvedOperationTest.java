/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.util.JavaRuntimeVersion;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.override.InvokedResolvedOperation;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InvokedResolvedOperationTest extends AbstractXbaseTestCase {
	@Inject
	private InvokedResolvedOperation.Provider invokedOperationProvider;

	public InvokedResolvedOperation toOperation(String expression) throws Exception {
		XAbstractFeatureCall featureCall = ((XAbstractFeatureCall) expression(expression));
		return invokedOperationProvider.resolve(featureCall);
	}

	@Test
	public void testIteratorOfObject() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList.iterator");
		Assert.assertEquals("Iterator<Object>", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("ArrayList<Object>", operation.getContextType().getSimpleName());
		Assert.assertEquals("iterator()", operation.getSimpleSignature());
	}

	@Test
	public void testStaticMethod() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList");
		Assert.assertEquals("ArrayList<Object>", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("newArrayList()", operation.getSimpleSignature());
	}

	@Test
	public void testStaticMethod_02() throws Exception {
		InvokedResolvedOperation operation = toOperation("newImmutableList");
		Assert.assertEquals("List<Object>", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("newImmutableList(Object[])", operation.getSimpleSignature());
	}

	@Test
	public void testToArray_01() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList.toArray");
		Assert.assertEquals("Object[]", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("toArray()", operation.getSimpleSignature());
	}

	@Test
	public void testToArray_02() throws Exception {
		InvokedResolvedOperation operation = toOperation("<String>newArrayList.toArray");
		Assert.assertEquals("Object[]", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("toArray()", operation.getSimpleSignature());
	}

	@Test
	public void testToArrayWithParam_01() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList.toArray(null as String[])");
		Assert.assertEquals("String[]", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("toArray(String[])", operation.getSimpleSignature());
	}

	@Test
	public void testToArrayWithParam_02() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList.<CharSequence>toArray(null as String[])");
		Assert.assertEquals("CharSequence[]", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("toArray(CharSequence[])", operation.getSimpleSignature());
	}

	@Test
	public void testArrayListOfStringIteratesStrings() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList(\"\").iterator");
		Assert.assertEquals("Iterator<String>", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("ArrayList<String>", operation.getContextType().getSimpleName());
		Assert.assertEquals("iterator()", operation.getSimpleSignature());
	}

	@Test
	public void testTypeArguments_01() throws Exception {
		InvokedResolvedOperation operation = toOperation("(null as overrides.AbstractForCharSequence).method");
		Assert.assertEquals("CharSequence", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("V, K", IterableExtensions.join(operation.getResolvedTypeParameters(), ", ", it -> it.getSimpleName()));
		Assert.assertEquals("CharSequence, CharSequence",
				IterableExtensions.join(operation.getResolvedTypeArguments(), ", ", it -> it.getSimpleName()));
		Assert.assertEquals("method(Class<? extends CharSequence>)", operation.getSimpleSignature());
	}

	@Test
	public void testTypeArguments_02() throws Exception {
		InvokedResolvedOperation operation = toOperation("newArrayList(1, 1d)");
		if (JavaRuntimeVersion.isJava12OrLater()) {
			Assert.assertEquals("ArrayList<Number & Comparable<?> & Constable & ConstantDesc>",
					operation.getResolvedReturnType().getSimpleName());
			Assert.assertEquals("Number & Comparable<?> & Constable & ConstantDesc",
					IterableExtensions.join(operation.getResolvedTypeArguments(), ", ", it -> it.getSimpleName()));
			Assert.assertEquals("newArrayList(Number & Comparable<?> & Constable & ConstantDesc[])", operation.getSimpleSignature());
		} else {
			Assert.assertEquals("ArrayList<Number & Comparable<?>>", operation.getResolvedReturnType().getSimpleName());
			Assert.assertEquals("Number & Comparable<?>",
					IterableExtensions.join(operation.getResolvedTypeArguments(), ", ", it -> it.getSimpleName()));
			Assert.assertEquals("newArrayList(Number & Comparable<?>[])", operation.getSimpleSignature());
		}
	}

	@Test
	public void testTypeArguments_03() throws Exception {
		InvokedResolvedOperation operation = toOperation("(newArrayList() as Iterable<? extends String>).toList");
		Assert.assertEquals("List<? extends String>", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("? extends String",
				IterableExtensions.join(operation.getResolvedTypeArguments(), ", ", it -> it.getSimpleName()));
		Assert.assertEquals("toList(Iterable<? extends String>)", operation.getSimpleSignature());
	}

	@Test
	public void testExplicitTypeArguments() throws Exception {
		InvokedResolvedOperation operation = toOperation("(null as overrides.AbstractForCharSequence).<String, StringBuilder>method");
		Assert.assertEquals("String", operation.getResolvedReturnType().getSimpleName());
		Assert.assertEquals("V, K", IterableExtensions.join(operation.getResolvedTypeParameters(), ", ", it -> it.getSimpleName()));
		Assert.assertEquals("String, StringBuilder",
				IterableExtensions.join(operation.getResolvedTypeArguments(), ", ", it -> it.getSimpleName()));
		Assert.assertEquals("method(Class<? extends String>)", operation.getSimpleSignature());
	}
}
