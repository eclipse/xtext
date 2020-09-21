/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.io.Serializable;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceSerializer;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LightweightTypeReferenceSerializerTest extends AbstractLightweightTypeReferenceTest {
	@Override
	protected ParameterizedTypeReference typeRef(Class<?> type) {
		return getOwner().newParameterizedTypeReference(type(type));
	}

	@Test
	public void testObject() {
		assertInXtendAndJava(typeRef(Object.class), "java.lang.Object");
	}

	@Test
	public void testList() {
		assertInXtendAndJava(typeRef(List.class), "java.util.List");
	}

	@Test
	public void testListWildcard() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		typeRef.addTypeArgument(typeRef.getOwner().newWildcardTypeReference());
		assertInXtendAndJava(typeRef, "java.util.List<?>");
	}

	@Test
	public void testListUpperBound() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.addUpperBound(typeRef(CharSequence.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<? extends java.lang.CharSequence>");
	}

	@Test
	public void testListUpperBoundObject() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.addUpperBound(typeRef(Object.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<?>");
	}

	@Test
	public void testListUpperBounds() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.addUpperBound(typeRef(CharSequence.class));
		newWildcardTypeReference.addUpperBound(typeRef(Serializable.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
	}

	@Test
	public void testListUpperBoundsIncludingObject() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.addUpperBound(typeRef(CharSequence.class));
		newWildcardTypeReference.addUpperBound(typeRef(Object.class));
		newWildcardTypeReference.addUpperBound(typeRef(Serializable.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<? extends java.lang.CharSequence & java.io.Serializable>");
	}

	@Test
	public void testListLowerBound() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.setLowerBound(typeRef(CharSequence.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<? super java.lang.CharSequence>");
	}

	@Test
	public void testListLowerAndUpperBound() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.setLowerBound(typeRef(CharSequence.class));
		newWildcardTypeReference.addUpperBound(typeRef(Serializable.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(typeRef, "java.util.List<? super java.lang.CharSequence>");
	}

	@Test
	public void testArray() {
		assertInXtendAndJava(getOwner().newArrayTypeReference(typeRef(Object.class)), "java.lang.Object[]");
	}

	@Test
	public void testArray2() {
		assertInXtendAndJava(getOwner().newArrayTypeReference(getOwner().newArrayTypeReference(typeRef(Object.class))),
				"java.lang.Object[][]");
	}

	@Test
	public void testArrayGeneric() {
		ParameterizedTypeReference typeRef = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = typeRef.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.setLowerBound(typeRef(CharSequence.class));
		typeRef.addTypeArgument(newWildcardTypeReference);
		assertInXtendAndJava(getOwner().newArrayTypeReference(typeRef), "java.util.List<? super java.lang.CharSequence>[]");
	}

	@Test
	public void testAnyType() {
		assertInXtendAndJava(getOwner().newAnyTypeReference(), "java.lang.Object");
	}

	@Test
	public void testFunctionType() {
		assertInJava(assertInXtend(getOwner().newFunctionTypeReference(type(Function0.class)), "()=>void"),
				"org.eclipse.xtext.xbase.lib.Functions$Function0");
	}

	@Test
	public void testFunctionType1() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Function0.class));
		newFunctionTypeReference.setReturnType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		assertInJava(assertInXtend(newFunctionTypeReference, "()=>java.lang.String"),
				"org.eclipse.xtext.xbase.lib.Functions$Function0<java.lang.String>");
	}

	@Test
	public void testFunctionType2() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Function1.class));
		newFunctionTypeReference.addParameterType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(Void.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		assertInJava(assertInXtend(newFunctionTypeReference, "(java.lang.String)=>void"),
				"org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Void, java.lang.String>");
	}

	@Test
	public void testFunctionType3() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Function1.class));
		newFunctionTypeReference.setReturnType(typeRef(Object.class));
		newFunctionTypeReference.addTypeArgument(typeRef(Object.class));
		newFunctionTypeReference.addParameterType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		assertInJava(assertInXtend(newFunctionTypeReference, "(java.lang.String)=>java.lang.Object"),
				"org.eclipse.xtext.xbase.lib.Functions$Function1<java.lang.Object, java.lang.String>");
	}

	@Test
	public void testFunctionType4() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Function3.class));
		newFunctionTypeReference.setReturnType(typeRef(Object.class));
		newFunctionTypeReference.addTypeArgument(typeRef(Object.class));
		newFunctionTypeReference.addParameterType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		ParameterizedTypeReference listOfCharSequence = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = listOfCharSequence.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.setLowerBound(typeRef(CharSequence.class));
		listOfCharSequence.addTypeArgument(newWildcardTypeReference);
		newFunctionTypeReference.addParameterType(listOfCharSequence);
		newFunctionTypeReference.addTypeArgument(listOfCharSequence);
		ArrayTypeReference arrayOfObject = newFunctionTypeReference.getOwner().newArrayTypeReference(typeRef(Object.class));
		newFunctionTypeReference.addParameterType(arrayOfObject);
		newFunctionTypeReference.addTypeArgument(arrayOfObject);
		assertInJava(
				assertInXtend(newFunctionTypeReference,
						"(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>java.lang.Object"),
				"org.eclipse.xtext.xbase.lib.Functions$Function3<java.lang.Object, java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
	}

	@Test
	public void testFunctionType5() {
		assertInJava(assertInXtend(getOwner().newFunctionTypeReference(type(Procedure0.class)), "()=>void"),
				"org.eclipse.xtext.xbase.lib.Procedures$Procedure0");
	}

	@Test
	public void testFunctionType6() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Procedure1.class));
		newFunctionTypeReference.addParameterType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		assertInJava(assertInXtend(newFunctionTypeReference, "(java.lang.String)=>void"),
				"org.eclipse.xtext.xbase.lib.Procedures$Procedure1<java.lang.String>");
	}

	@Test
	public void testFunctionType7() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Procedure3.class));
		newFunctionTypeReference.addParameterType(typeRef(String.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		ParameterizedTypeReference listOfCharSequence = typeRef(List.class);
		WildcardTypeReference newWildcardTypeReference = listOfCharSequence.getOwner().newWildcardTypeReference();
		newWildcardTypeReference.setLowerBound(typeRef(CharSequence.class));
		listOfCharSequence.addTypeArgument(newWildcardTypeReference);
		newFunctionTypeReference.addParameterType(listOfCharSequence);
		newFunctionTypeReference.addTypeArgument(listOfCharSequence);
		ArrayTypeReference arrayOfObject = newFunctionTypeReference.getOwner().newArrayTypeReference(typeRef(Object.class));
		newFunctionTypeReference.addParameterType(arrayOfObject);
		newFunctionTypeReference.addTypeArgument(arrayOfObject);
		assertInJava(
				assertInXtend(newFunctionTypeReference,
						"(java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[])=>void"),
				"org.eclipse.xtext.xbase.lib.Procedures$Procedure3<java.lang.String, java.util.List<? super java.lang.CharSequence>, java.lang.Object[]>");
	}

	@Test
	public void testFunctionType8() {
		assertInJava(assertInXtend(getOwner().newFunctionTypeReference(type(Runnable.class)), "()=>void"), "java.lang.Runnable");
	}

	@Test
	public void testFunctionType9() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Readable.class));
		newFunctionTypeReference.addParameterType(typeRef(CharBuffer.class));
		newFunctionTypeReference.setReturnType(typeRef(Integer.TYPE));
		assertInJava(assertInXtend(newFunctionTypeReference, "(java.nio.CharBuffer)=>int"), "java.lang.Readable");
	}

	@Test
	public void testFunctionType10() {
		FunctionTypeReference newFunctionTypeReference = getOwner().newFunctionTypeReference(type(Iterable.class));
		newFunctionTypeReference.addTypeArgument(typeRef(String.class));
		ParameterizedTypeReference typeRef = typeRef(Iterator.class);
		typeRef.addTypeArgument(typeRef(String.class));
		newFunctionTypeReference.setReturnType(typeRef);
		assertInJava(assertInXtend(newFunctionTypeReference, "()=>java.util.Iterator<java.lang.String>"),
				"java.lang.Iterable<java.lang.String>");
	}

	@Test
	@Ignore
	public void testUnboundTypeReference() {
		assertInXtendAndJava(UnboundTypeReference.create(null, null, null), "java.lang.Object");
	}

	@Test
	public void testUnknownTypeReference() {
		assertInXtendAndJava(getOwner().newUnknownTypeReference("Foo"), "Foo");
	}

	@Test
	public void testUnknownTypeReference1() {
		assertInXtendAndJava(getOwner().newUnknownTypeReference(), "Object");
	}

	protected void assertInXtendAndJava(LightweightTypeReference ref, String expectation) {
		assertInXtend(ref, expectation);
		assertInJava(ref, expectation);
	}

	protected LightweightTypeReference assertInXtend(LightweightTypeReference ref, String expectation) {
		return assertIn(ref, expectation, false);
	}

	protected LightweightTypeReference assertInJava(LightweightTypeReference ref, String expectation) {
		return assertIn(ref, expectation, true);
	}

	protected LightweightTypeReference assertIn(LightweightTypeReference ref, String expectation, boolean isJava) {
		TestAppender appender = new TestAppender(isJava);
		LightweightTypeReferenceSerializer serializer = new LightweightTypeReferenceSerializer(appender);
		ref.accept(serializer);
		Assert.assertEquals(expectation, appender.toString());
		return ref;
	}
}
