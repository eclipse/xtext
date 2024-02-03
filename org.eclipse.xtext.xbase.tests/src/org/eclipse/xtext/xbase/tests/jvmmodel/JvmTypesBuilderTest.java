/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.JvmTypeReferenceUtil;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsFactory;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function3;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import foo.TestAnnotation3;

public class JvmTypesBuilderTest extends AbstractXbaseTestCase {
	@Inject
	private TypesFactory typesFactory;

	@Inject
	private TypeReferences references;

	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private ILogicalContainerProvider containerProvider;

	private JvmTypeReferenceBuilder jvmTypeReferenceBuilder;

	@Inject
	public JvmTypeReferenceBuilder setJvmTypeReferenceBuilder(JvmTypeReferenceBuilder.Factory factory, XtextResourceSet resourceSet) {
		return jvmTypeReferenceBuilder = factory.create(resourceSet);
	}

	@Test
	public void testEmptyAnnotation() throws Exception {
		XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
		XExpression e = expression("'Foo'");
		XAnnotation anno = f.createXAnnotation();
		anno.setAnnotationType(references.findDeclaredType(Inject.class, e));
		JvmGenericType type = typesFactory.createJvmGenericType();
		jvmTypesBuilder.addAnnotations(type, Lists.newArrayList(anno));
		Assert.assertEquals(anno.getAnnotationType(), type.getAnnotations().get(0).getAnnotation());
	}

	@Test
	public void testStringAnnotation() throws Exception {
		XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
		XExpression e = expression("'Foo'");
		XAnnotation anno = f.createXAnnotation();
		anno.setAnnotationType(references.findDeclaredType(Inject.class, e));
		anno.setValue(e);
		JvmGenericType type = typesFactory.createJvmGenericType();
		jvmTypesBuilder.addAnnotation(type, anno);
		Assert.assertEquals(anno.getAnnotationType(), type.getAnnotations().get(0).getAnnotation());
		Assert.assertTrue(
				((JvmCustomAnnotationValue) type.getAnnotations().get(0).getValues().get(0)).getValues().get(0) instanceof XStringLiteral);
	}

	@Test
	public void testAnnotationDefaultValue() throws Exception {
		XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
		XExpression e = expression("'Foo'");
		XAnnotation anno = f.createXAnnotation();
		anno.setAnnotationType(references.findDeclaredType(Named.class, e));
		anno.setValue(e);
		JvmGenericType type = typesFactory.createJvmGenericType();
		jvmTypesBuilder.addAnnotation(type, anno);
		Assert.assertEquals(anno.getAnnotationType(), type.getAnnotations().get(0).getAnnotation());
		Assert.assertTrue(
				((JvmCustomAnnotationValue) type.getAnnotations().get(0).getValues().get(0)).getValues().get(0) instanceof XStringLiteral);
		Assert.assertNull(type.getAnnotations().get(0).getValues().get(0).getOperation());
	}

	@Test
	public void testStringAnnotationWithNullExpression() throws Exception {
		XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
		XExpression context = expression("'Foo'");
		XAnnotation anno = f.createXAnnotation();
		anno.setAnnotationType(references.findDeclaredType(Inject.class, context));
		XAnnotationElementValuePair pair = f.createXAnnotationElementValuePair();
		jvmTypesBuilder.operator_add(anno.getElementValuePairs(), pair);
		JvmGenericType type = typesFactory.createJvmGenericType();
		jvmTypesBuilder.addAnnotation(type, anno);
		Assert.assertEquals(anno.getAnnotationType(), type.getAnnotations().get(0).getAnnotation());
		Assert.assertTrue(type.getAnnotations().get(0).getExplicitValues().isEmpty());
		Assert.assertFalse(type.getAnnotations().get(0).getValues().isEmpty());
	}

	@Test
	public void testIntegerAnnotation() throws Exception {
		XAnnotationsFactory f = XAnnotationsFactory.eINSTANCE;
		XExpression e = expression("'Foo'");
		XAnnotation anno = f.createXAnnotation();
		JvmAnnotationType annotatiomType = (JvmAnnotationType) references.findDeclaredType(TestAnnotation3.class, e);
		anno.setAnnotationType(annotatiomType);
		XAnnotationElementValuePair pair = f.createXAnnotationElementValuePair();
		pair.setElement(Iterables.getFirst(annotatiomType.getDeclaredOperations(), null));
		pair.setValue(expression("10"));
		jvmTypesBuilder.operator_add(anno.getElementValuePairs(), pair);
		JvmGenericType type = typesFactory.createJvmGenericType();
		jvmTypesBuilder.addAnnotation(type, anno);
		Assert.assertEquals(anno.getAnnotationType(), type.getAnnotations().get(0).getAnnotation());
		Assert.assertEquals(1, type.getAnnotations().get(0).getValues().size());
		JvmCustomAnnotationValue value = (JvmCustomAnnotationValue) type.getAnnotations().get(0).getValues().get(0);
		Assert.assertTrue(value.getValues().get(0) instanceof XNumberLiteral);
	}

	@Test
	public void testAnnotationCreation() throws Exception {
		XExpression e = expression("'foo'");
		JvmAnnotationType anno = jvmTypesBuilder.toAnnotationType(e, "foo.bar.MyAnnotation", (JvmAnnotationType it) -> {
			jvmTypesBuilder.setDocumentation(it, "Foo");
		});
		Assert.assertEquals("foo.bar", anno.getPackageName());
		Assert.assertEquals("MyAnnotation", anno.getSimpleName());
		Assert.assertEquals("Foo", jvmTypesBuilder.getDocumentation(anno));
	}

	@Test
	public void testInterfaceCreation() throws Exception {
		XExpression e = expression("'foo'");
		JvmGenericType interf = jvmTypesBuilder.toInterface(e, "foo.bar.MyInterface", (JvmGenericType it) -> {
			jvmTypesBuilder.addSuperInterface(it, jvmTypeReferenceBuilder.typeRef(Iterable.class));
			jvmTypesBuilder.addSuperInterface(it, jvmTypeReferenceBuilder.typeRef(Collection.class));
		});
		Assert.assertTrue(interf.isInterface());
		Assert.assertEquals("foo.bar", interf.getPackageName());
		Assert.assertEquals("MyInterface", interf.getSimpleName());
		var superTypes = interf.getSuperTypes();
		Assert.assertEquals(2, superTypes.size());
		Assert.assertTrue(JvmTypeReferenceUtil.isExpectedAsInterface(superTypes.get(0)));
		Assert.assertTrue(JvmTypeReferenceUtil.isExpectedAsInterface(superTypes.get(1)));
	}

	@Test
	public void testClassCreation() throws Exception {
		XExpression e = expression("'foo'");
		JvmGenericType interf = jvmTypesBuilder.toClass(e, "foo.bar.MyClass", (JvmGenericType it) -> {
			jvmTypesBuilder.setSuperClass(it, jvmTypeReferenceBuilder.typeRef(AbstractList.class));
		});
		Assert.assertFalse(interf.isInterface());
		Assert.assertEquals("foo.bar", interf.getPackageName());
		Assert.assertEquals("MyClass", interf.getSimpleName());
		var superTypes = interf.getSuperTypes();
		Assert.assertEquals(1, superTypes.size());
		Assert.assertTrue(JvmTypeReferenceUtil.isExpectedAsClass(superTypes.get(0)));
	}

	@Test
	public void testEnumCreation() throws Exception {
		XExpression e = expression("'foo'");
		JvmEnumerationType myEnum = jvmTypesBuilder.toEnumerationType(e, "MyEnum", (JvmEnumerationType it) -> {
			jvmTypesBuilder.setDocumentation(it, "Foo");
			jvmTypesBuilder.operator_add(it.getMembers(), jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL0"));
			jvmTypesBuilder.operator_add(it.getMembers(), jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL1"));
		});
		Assert.assertNull(myEnum.getPackageName());
		Assert.assertEquals("MyEnum", myEnum.getSimpleName());
		Assert.assertEquals("Foo", jvmTypesBuilder.getDocumentation(myEnum));
		Assert.assertArrayEquals(Lists.newArrayList("LITERAL0", "LITERAL1").toArray(new Object[0]),
				Lists.transform(myEnum.getLiterals(), JvmEnumerationLiteral::getSimpleName).toArray(new Object[0]));
	}

	@Test
	public void testEnumCreation2() throws Exception {
		XExpression e = expression("'foo'");
		JvmEnumerationType myEnum = jvmTypesBuilder.toEnumerationType(e, "MyEnum");
		jvmTypesBuilder.setDocumentation(myEnum, "Foo");
		jvmTypesBuilder.operator_add(myEnum.getMembers(), jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL0"));
		jvmTypesBuilder.operator_add(myEnum.getMembers(), jvmTypesBuilder.toEnumerationLiteral(e, "LITERAL1"));
		Assert.assertNull(myEnum.getPackageName());
		Assert.assertEquals("MyEnum", myEnum.getSimpleName());
		Assert.assertEquals("Foo", jvmTypesBuilder.getDocumentation(myEnum));
		Assert.assertArrayEquals(Lists.newArrayList("LITERAL0", "LITERAL1").toArray(new Object[0]),
				Lists.transform(myEnum.getLiterals(), JvmEnumerationLiteral::getSimpleName).toArray(new Object[0]));
	}

	@Test
	public void testSetBody() throws Exception {
		JvmOperation op = typesFactory.createJvmOperation();
		jvmTypesBuilder.setBody(op, (ITreeAppendable it) -> {
			StringConcatenation builder = new StringConcatenation();
			builder.append("foo");
			it.append(builder);
		});
		jvmTypesBuilder.setBody(op, (ITreeAppendable it) -> {
			StringConcatenation builder = new StringConcatenation();
			builder.append("bar");
			it.append(builder);
		});
		Assert.assertEquals(1, op.eAdapters().size());
	}

	@Test
	public void testSetBody_02() throws Exception {
		XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
		XtextResource res = new XtextResource();
		res.setLanguageName("org.eclipse.xtext.xbase.Xbase");
		JvmOperation op = typesFactory.createJvmOperation();
		jvmTypesBuilder.operator_add(res.getContents(), op);
		jvmTypesBuilder.operator_add(res.getContents(), expr);
		jvmTypesBuilder.setBody(op, (ITreeAppendable it) -> {
			StringConcatenation builder = new StringConcatenation();
			builder.append("bar");
			it.append(builder);
		});
		Assert.assertEquals(1, op.eAdapters().size());
		jvmTypesBuilder.setBody(op, expr);
		Assert.assertEquals(op, containerProvider.getLogicalContainer(expr));
		Assert.assertEquals(0, op.eAdapters().size());
		jvmTypesBuilder.setBody(op, (ITreeAppendable it) -> {
			new StringConcatenation().append("bar");
			it.append(new StringConcatenation());
		});
		Assert.assertEquals(1, op.eAdapters().size());
		Assert.assertNull(containerProvider.getLogicalContainer(expr));
	}

	@Test
	public void testSetBody_03() throws Exception {
		JvmOperation op = typesFactory.createJvmOperation();
		jvmTypesBuilder.setBody(op, new StringConcatenationClient() {
			@Override
			protected void appendTo(StringConcatenationClient.TargetStringConcatenation builder) {
				builder.append("foo");
			}
		});
		jvmTypesBuilder.setBody(op, new StringConcatenationClient() {
			@Override
			protected void appendTo(StringConcatenationClient.TargetStringConcatenation builder) {
				builder.append("bar");
			}
		});
		Assert.assertEquals(1, op.eAdapters().size());
	}

	@Test
	public void testSetBody_04() throws Exception {
		XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
		XtextResource res = new XtextResource();
		res.setLanguageName("org.eclipse.xtext.xbase.Xbase");
		JvmOperation op = typesFactory.createJvmOperation();
		jvmTypesBuilder.operator_add(res.getContents(), op);
		jvmTypesBuilder.operator_add(res.getContents(), expr);
		jvmTypesBuilder.setBody(op, new StringConcatenationClient() {
			@Override
			protected void appendTo(StringConcatenationClient.TargetStringConcatenation builder) {
				builder.append("bar");
			}
		});
		Assert.assertEquals(1, op.eAdapters().size());
		jvmTypesBuilder.setBody(op, expr);
		Assert.assertEquals(op, containerProvider.getLogicalContainer(expr));
		Assert.assertEquals(0, op.eAdapters().size());
		jvmTypesBuilder.setBody(op, new StringConcatenationClient() {
			@Override
			protected void appendTo(StringConcatenationClient.TargetStringConcatenation builder) {
				builder.append("bar");
			}
		});
		Assert.assertEquals(1, op.eAdapters().size());
		Assert.assertNull(containerProvider.getLogicalContainer(expr));
	}

	@Test
	@Ignore
	public void testAddNull() throws Exception {
		BasicEList<String> list = new BasicEList<String>();
		// FIXME Iterables.addAll(list, null);
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testAddAllNull() throws Exception {
		BasicEList<String> list = new BasicEList<String>();
		List<String> otherList = Lists.newArrayList(null, null, null);
		jvmTypesBuilder.operator_add(list, otherList);
		Assert.assertTrue(list.isEmpty());
	}

	@Test
	public void testAddAllNull_1() throws Exception {
		BasicEList<String> list = new BasicEList<String>();
		List<String> otherList = null;
		jvmTypesBuilder.operator_add(list, otherList);
		Assert.assertTrue(list.isEmpty());
	}

	/**
	 * Invokes an executable's compilation strategy and check against the expected string
	 */
	protected void expectBody(JvmExecutable executable, CharSequence expectedBody) {
		CompilationStrategyAdapter adapter = Iterables.getFirst(Iterables.filter(executable.eAdapters(), CompilationStrategyAdapter.class),
				null);
		Assert.assertNotNull(adapter);
		FakeTreeAppendable appendable = new FakeTreeAppendable();
		adapter.getCompilationStrategy().apply(appendable);
		Assert.assertEquals(expectedBody.toString(), appendable.toString());
	}

	@Test
	public void testToGetterWithNullTypeRef() throws Exception {
		XExpression e = expression("''");
		JvmOperation getter = jvmTypesBuilder.toGetter(e, "foo", null);
		expectBody(getter, "return this.foo;");
	}

	@Test
	public void testToFieldWithKeywordCollision() throws Exception {
		XExpression e = expression("''");
		JvmField field = jvmTypesBuilder.toField(e, "package", jvmTypeReferenceBuilder.typeRef(String.class));
		Assert.assertEquals("package", field.getSimpleName());
	}

	@Test
	public void testToGetterWithKeywordCollision() throws Exception {
		XExpression e = expression("''");
		JvmOperation getter = jvmTypesBuilder.toGetter(e, "package", jvmTypeReferenceBuilder.typeRef(String.class));
		expectBody(getter, "return this.package_;");
	}

	@Test
	public void testToSetterWithKeywordCollision() throws Exception {
		XExpression e = expression("''");
		JvmOperation setter = jvmTypesBuilder.toSetter(e, "package", jvmTypeReferenceBuilder.typeRef(String.class));
		Assert.assertEquals("package", setter.getParameters().get(0).getSimpleName());
		expectBody(setter, "this.package_ = package_;");
	}

	@Test
	public void testInitializeSafely_0() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmGenericType> init) -> {
				return jvmTypesBuilder.toClass(expr, name, init);
			});
		});
	}

	@Test
	public void testInitializeSafely_1() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmConstructor> init) -> {
				return jvmTypesBuilder.toConstructor(expr, init);
			});
		});
	}

	@Test
	public void testInitializeSafely_2() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmField> init) -> {
				return jvmTypesBuilder.toField(expr, name, null, init);
			});
		});
	}

	@Test
	public void testInitializeSafely_3() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmOperation> init) -> {
				return jvmTypesBuilder.toMethod(expr, name, null, init);
			});
		});
	}

	@Test
	public void testInitializeSafely_4() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmAnnotationType> init) -> {
				return jvmTypesBuilder.toAnnotationType(expr, name, init);
			});
		});
	}

	@Test
	public void testInitializeSafely_5() throws Exception {
		expectErrorLogging(2, () -> {
			genericTestInitializeSafely((EObject expr, String name, Procedure1<? super JvmEnumerationType> init) -> {
				return jvmTypesBuilder.toEnumerationType(expr, name, init);
			});
		});
	}

	protected <T extends Object> void genericTestInitializeSafely(
			Function3<? super EObject, ? super String, ? super Procedure1<? super T>, ? extends EObject> create) {
		XNullLiteral expr = XbaseFactory.eINSTANCE.createXNullLiteral();
		Wrapper<Boolean> initialized = new Wrapper<Boolean>(Boolean.valueOf(false));
		EObject element = create.apply(expr, "foo", (Procedure1<T>) (T it) -> {
			initialized.set(true);
			throw new RuntimeException();
		});
		Assert.assertTrue(initialized.get().booleanValue());
		Assert.assertNotNull(element);
	}

	protected void expectErrorLogging(Runnable block) {
		expectErrorLogging(1, block);
	}

	protected void expectErrorLogging(int numberOfloggings, Runnable block) {
		LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, JvmTypesBuilder.class, block);
		loggings.assertNumberOfLogEntries(numberOfloggings);
	}

	@Test
	public void testErrorLogging_01() throws Exception {
		expectErrorLogging(() -> {
			JvmGenericType source = typesFactory.createJvmGenericType();
			jvmTypesBuilder.toClass(source, "foo.bar");
		});
	}

	@Test
	public void testErrorLogging_02() throws Exception {
		expectErrorLogging(() -> {
			JvmGenericType source = typesFactory.createJvmGenericType();
			jvmTypesBuilder.toClass(source, "foo.bar");
		});
	}
}
