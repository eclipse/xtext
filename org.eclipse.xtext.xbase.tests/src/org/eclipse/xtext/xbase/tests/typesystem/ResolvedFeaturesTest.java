/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.lang.ref.SoftReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.OverrideHelper;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Lorenzo Bettini - https://bugs.eclipse.org/bugs/show_bug.cgi?id=454786
 */
public class ResolvedFeaturesTest extends AbstractXbaseTestCase {
	public static class BaseClass {
		public Object baseClassMethod(List<String> l) {
			return null;
		}
	}

	public static class DerivedClass extends ResolvedFeaturesTest.BaseClass {
		public Object derivedClassMethod(List<String> l) {
			return null;
		}
	}

	@Inject
	private OverrideHelper overrideHelper;

	private static final String BASE_CLASS_METHOD_ERASED_SIGNATURE = "baseClassMethod(java.util.List)";

	private static final String DERIVED_CLASS_METHOD_ERASED_SIGNATURE = "derivedClassMethod(java.util.List)";

	public ResolvedFeatures toResolvedOperations(Class<?> type) throws Exception {
		XTypeLiteral typeLiteral = (XTypeLiteral) expression("typeof(" + type.getCanonicalName() + ")");
		ResolvedFeatures result = overrideHelper.getResolvedFeatures((JvmDeclaredType) typeLiteral.getType());
		return result;
	}

	public ResolvedFeatures toResolvedOperations(String castExpression) throws Exception {
		XCastedExpression cast = (XCastedExpression) expression(castExpression);
		ResolvedFeatures result = overrideHelper.getResolvedFeatures(cast.getType());
		return result;
	}

	@Test
	public void testAllOperationsIncludeDeclaredOperations() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
		List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(1, declared.size());
		Assert.assertSame(Iterables.getFirst(declared, null), Iterables.getFirst(all, null));
	}

	@Test
	public void testDeclaredOperationsAreIncludedInAllOperations() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(1, declared.size());
		Assert.assertSame(Iterables.getFirst(declared, null), Iterables.getFirst(all, null));
	}

	@Test
	public void testDeclaredAndAllOperationsErasedSignature() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
		Assert.assertNotNull(
				Iterables.getFirst(resolvedOperations.getAllOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE), null));
		Assert.assertNull(Iterables
				.getFirst(resolvedOperations.getDeclaredOperations(ResolvedFeaturesTest.BASE_CLASS_METHOD_ERASED_SIGNATURE), null));
	}

	@Test
	public void testDeclaredOperationsErasedSignatureAreIncludedInAllOperations() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
		List<IResolvedOperation> declared = resolvedOperations
				.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(1, declared.size());
		Assert.assertSame(Iterables.getFirst(declared, null), Iterables.getFirst(all, null));
	}

	@Test
	public void testAllOperationsErasedSignatureIncludeDeclaredOperations() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ResolvedFeaturesTest.DerivedClass.class);
		List<IResolvedOperation> declared = resolvedOperations
				.getDeclaredOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations(ResolvedFeaturesTest.DERIVED_CLASS_METHOD_ERASED_SIGNATURE);
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(1, declared.size());
		Assert.assertSame(Iterables.getFirst(declared, null), Iterables.getFirst(all, null));
	}

	@Test
	public void testArrayListHasNoAbstractMethods() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(ArrayList.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		Assert.assertFalse(all.isEmpty());
		all.forEach((IResolvedOperation it) -> {
			Assert.assertFalse(it.getDeclaration().isAbstract());
		});
	}

	@Test
	public void testIterableIterator() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(Iterable.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		Assert.assertFalse(all.isEmpty());
		IResolvedOperation iterator = Iterables
				.getOnlyElement(Iterables.filter(all, (IResolvedOperation it) -> it.getDeclaration().isAbstract()));
		Assert.assertEquals("java.lang.Iterable.iterator()", iterator.getDeclaration().getIdentifier());
	}

	@Test
	public void testUnmodifiableIterator() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(UnmodifiableIterator.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(all.toString(), 2,
				Iterables.size(Iterables.filter(all, (IResolvedOperation it) -> it.getDeclaration().isAbstract())));
		Assert.assertEquals(all.toString(), (1 + 6),
				Iterables.size(Iterables.filter(all, (IResolvedOperation it) -> it.getDeclaration().isFinal())));
		List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
		Assert.assertEquals(1, declared.size());
	}

	@Test
	public void testAbstractList() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(AbstractList.class);
		List<IResolvedOperation> all = resolvedOperations.getAllOperations();
		Assert.assertFalse(all.isEmpty());
		Assert.assertEquals(all.toString(), 1 + 1,
				Iterables.size(Iterables.filter(all, (IResolvedOperation it) -> it.getDeclaration().isAbstract())));
		List<IResolvedOperation> declared = resolvedOperations.getDeclaredOperations();
		Assert.assertEquals(1, Iterables.size(Iterables.filter(declared, (IResolvedOperation it) -> it.getDeclaration().isAbstract())));
	}

	@Test
	public void testSoftReferenceConstructors() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations(SoftReference.class);
		Assert.assertEquals(1, resolvedOperations.getDeclaredOperations().size());
		Assert.assertEquals(2, resolvedOperations.getDeclaredConstructors().size());
		resolvedOperations.getDeclaredConstructors().forEach((IResolvedConstructor it) -> {
			switch (it.getDeclaration().getParameters().size()) {
				case 1:
					Assert.assertEquals("SoftReference(T)", it.getResolvedSignature());
					Assert.assertEquals("SoftReference(java.lang.Object)", it.getResolvedErasureSignature());
					break;
				case 2:
					Assert.assertEquals("SoftReference(T,java.lang.ref.ReferenceQueue<? super T>)", it.getResolvedSignature());
					Assert.assertEquals("SoftReference(java.lang.Object,java.lang.ref.ReferenceQueue)", it.getResolvedErasureSignature());
					break;
				default:
					Assert.fail("Unexpected constructor: " + it);
					break;
			}
		});
	}

	@Test
	public void testSoftReferenceOfString() throws Exception {
		ResolvedFeatures resolvedOperations = toResolvedOperations("null as java.lang.ref.SoftReference<String>");
		Assert.assertEquals(1, resolvedOperations.getDeclaredOperations().size());
		Assert.assertEquals(2, resolvedOperations.getDeclaredConstructors().size());
		resolvedOperations.getDeclaredConstructors().forEach((IResolvedConstructor it) -> {
			switch (it.getDeclaration().getParameters().size()) {
				case 1:
					Assert.assertEquals("SoftReference(java.lang.String)", it.getResolvedSignature());
					Assert.assertEquals("SoftReference(java.lang.String)", it.getResolvedErasureSignature());
					break;
				case 2:
					Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue<? super java.lang.String>)",
							it.getResolvedSignature());
					Assert.assertEquals("SoftReference(java.lang.String,java.lang.ref.ReferenceQueue)", it.getResolvedErasureSignature());
					break;
				default:
					Assert.fail("Unexpected constructor: " + it);
					break;
			}
		});
	}

	@Test
	public void testReferenceOfString() throws Exception {
		ResolvedFeatures resolvedFeatures = toResolvedOperations("null as java.lang.ref.Reference<String>");
		List<IResolvedField> fields = Lists.newArrayList(resolvedFeatures.getDeclaredFields());
		Assert.assertEquals("String",
				FluentIterable.from(fields).firstMatch((IResolvedField it) -> Boolean.valueOf("referent".equals(it.getSimpleSignature())))
						.get().getResolvedType().getHumanReadableName());
		Assert.assertEquals("ReferenceQueue<? super String>",
				FluentIterable.from(fields).firstMatch((IResolvedField it) -> Boolean.valueOf("queue".equals(it.getSimpleSignature())))
						.get().getResolvedType().getHumanReadableName());
	}
}
