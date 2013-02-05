/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.annotations;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AnnotationsValidatorTest extends AbstractXbaseWithAnnotationsTest {
	
	@Inject 
	protected ValidationTestHelper validator;
	
	@Test public void testTypeConformance_01() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2('foo')", false);
		validator.assertNoErrors(annotation);
	}
	@Test public void testTypeConformance_02() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = 'foo')", false);
		validator.assertNoErrors(annotation);
	}
	@Test public void testTypeConformance_03() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2({'foo'})", false);
		validator.assertNoErrors(annotation);
	}
	@Test public void testTypeConformance_04() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = {'foo'})", false);
		validator.assertNoErrors(annotation);
	}
	@Test public void testTypeConformance_05() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(true)", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "expected String | String[] but was boolean");
	}
	@Test public void testTypeConformance_06() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = 42)", false);
		validator.assertError(annotation, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String | String[]", "int");
	}
	@Test public void testTypeConformance_07() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2({typeof(String)})", false);
		validator.assertError(annotation, XbasePackage.Literals.XTYPE_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "Class<String>");
	}
	@Test public void testTypeConformance_08() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = {true})", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "boolean");
	}
	@Test public void testTypeConformance_09() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(true)", false);
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION, "children");
	}
	
	@Test public void testTypeConformance_10() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(value = true , children = @testdata.Annotation2('foo'), foo = 'bar' )", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testTypeConformance_11() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation1(value = true , children = @testdata.Annotation2(true), foo = 'bar' )", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String[]", "boolean");
	}
	
	@Test public void testTypeConformance_12() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = {'', true, 1, ''})", false);
		validator.assertError(annotation, XbasePackage.Literals.XBOOLEAN_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "boolean");
		validator.assertError(annotation, XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "String", "int");
	}
	
	@Test public void testEmptyValueList_01() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(value = {})", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testEmptyValueList_02() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2({})", false);
		validator.assertNoErrors(annotation);
	}
	
	@Test public void testNoOperationFound() throws Exception {
		XAnnotation annotation = annotation("@testdata.Annotation2(toString = true)", false);
		validator.assertNoError(annotation, IssueCodes.INCOMPATIBLE_TYPES);
		// TODO use better error message like in Java (e.g. Annotation A does not define an attribute b)
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR, Diagnostic.LINKING_DIAGNOSTIC);
		validator.assertError(annotation, XAnnotationsPackage.Literals.XANNOTATION, IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION, "attribute 'value'");
	}
}
