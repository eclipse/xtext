/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import testdata.Annotation1;
import testdata.Annotation2;
import testdata.Properties1;

import com.google.common.base.Function;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AnnotationsCompilerTest extends AbstractXtend2TestCase {
	
	public void testSimpleAnnotationOnType() throws Exception {
		final String text = "@com.google.inject.Singleton() class Foo {}";
		assertNotNull(getAnnotationOnClass(text, Singleton.class));
	}
	
	public void testParameterizedAnnotationOnType() throws Exception {
		final String text = "@com.google.inject.ImplementedBy(typeof(String)) class Foo {}";
		ImplementedBy implementedBy = getAnnotationOnClass(text, ImplementedBy.class);
		assertTrue(implementedBy.value() == String.class);
	}
	
	public void testKeyValueParameterizedAnnotationOnType() throws Exception {
		final String text = "@com.google.inject.ImplementedBy( value = typeof(String)) class Foo {}";
		ImplementedBy implementedBy = getAnnotationOnClass(text, ImplementedBy.class);
		assertTrue(implementedBy.value() == String.class);
	}
	
	public void testKeyValueParameterizedAnnotationOnField() throws Exception {
		final String text = "class Foo { @com.google.inject.Inject(optional = true) String string }";
		Inject inject = getAnnotationOnField(text, Inject.class);
		assertTrue(inject.optional());
	}
	
	public void testMarkerAnnotationOnField() throws Exception {
		final String text = "class Foo { @com.google.inject.Inject String string }";
		Inject inject = getAnnotationOnField(text, Inject.class);
		assertNotNull(inject);
	}
	
	public void testAnnotationOnField() throws Exception {
		final String text = "class Foo { @com.google.inject.Inject() String string }";
		Inject inject = getAnnotationOnField(text, Inject.class);
		assertNotNull(inject);
	}
	
	public void testBug351554_01() throws Exception {
		final String text = 
			"class Foo {\n" +
			"	@org.eclipse.xtext.validation.Check(org::eclipse::xtext::validation::CheckType::NORMAL)\n" +
			"	def void checkSomething(Object o) {}\n" +
			"}";
		Check check = getAnnotationOnMethod(text, Check.class);
		assertNotNull(check);
		assertEquals(CheckType.NORMAL, check.value());
	}

	public void testBug351554_02() throws Exception {
		final String text = 
			"@testdata.Annotation1(children = @testdata.Annotation2({'a', 'b'}), value=true)\n" +
			"class Foo {}";
		Annotation1 annotation = getAnnotationOnClass(text, Annotation1.class);
		assertNotNull(annotation);
		assertNotNull(annotation.children());
		assertEquals(1, annotation.children().length);
		Annotation2 nestedAnnotation = annotation.children()[0];
		assertNotNull(nestedAnnotation);
		assertNotNull(nestedAnnotation.value());
		assertEquals(2, nestedAnnotation.value().length);
		assertEquals("a", nestedAnnotation.value()[0]);
		assertEquals("b", nestedAnnotation.value()[1]);
	}
	
	protected <T extends Annotation> T getAnnotationOnClass(final String text, Class<T> annotation) throws Exception {
		Class<?> class1 = compileToClass(text);
		return class1.getAnnotation(annotation);
	}
	
	protected <T extends Annotation> T getAnnotationOnField(final String text, Class<T> annotation) throws Exception {
		Class<?> class1 = compileToClass(text);
		Field field = class1.getDeclaredFields()[0];
		return field.getAnnotation(annotation);
	}
	
	protected <T extends Annotation> T getAnnotationOnMethod(final String text, Class<T> annotation) throws Exception {
		Class<?> class1 = compileToClass(text);
		Method method = class1.getDeclaredMethods()[0];
		return method.getAnnotation(annotation);
	}

	protected Class<?> compileToClass(final String text) throws Exception {
		XtendFile file = parseHelper.parse(text);
		validationHelper.assertNoErrors(file);
		JvmGenericType inferredType = associations.getInferredType(file.getXtendClass());
		CharSequence javaCode = generator.generateType(inferredType);
		Class<?> class1 = javaCompiler.compileToClass("Foo", javaCode.toString());
		return class1;
	}
	
	@Inject
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<XtendFile> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private IXtend2JvmAssociations associations;
	
	@Inject
	private JvmModelGenerator generator;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(Check.class);
		javaCompiler.addClassPathOfClass(StringExtensions.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(Xtend2Package.class);
		javaCompiler.addClassPathOfClass(Inject.class);
		javaCompiler.addClassPathOfClass(Properties1.class);
		javaCompiler.addClassPathOfClass(Function.class);
		javaCompiler.addClassPathOfClass(StringConcatenation.class);
	}
}
