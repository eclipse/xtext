/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AssignmentLinkingTest extends AbstractXtend2TestCase {

	@Inject
	private ValidationTestHelper validator;
	
	public void testLocalVariable() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    var aString = ''\n" +
				"    aString = 'foo'\n" + 
				"  }\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("aString", XbasePackage.Literals.XVARIABLE_DECLARATION, assignment);
	}
	
	public void testParameter() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String aString) {\n" + 
				"    aString = 'foo'\n" + 
				"  }\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertNotNull("feature is available", assignment.getFeature());
		JvmIdentifiableElement linked = assignment.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertEquals("aString", linked.getIdentifier());
		assertTrue(TypesPackage.Literals.JVM_FORMAL_PARAMETER.isInstance(linked));
		assertNull(assignment.getInvalidFeatureIssueCode(), assignment.getInvalidFeatureIssueCode());
	}
	
	public void testQualifiedField() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    this.aString = 'foo'\n" + 
				"  }" +
				"  String aString\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.aString", assignment);
	}
	
	public void testUnqualifiedField_onThis() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    aString = 'foo'\n" + 
				"  }" +
				"  String aString\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.aString", assignment);
	}
	
	public void testUnqualifiedField_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.FieldAccess it) {\n" + 
				"    stringField = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.FieldAccess.stringField", assignment);
	}
	
	public void testUnqualifiedField_onExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    stringField = 'foo'\n" + 
				"  }\n" +
				"  extension testdata.FieldAccess" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.FieldAccess.stringField", assignment);
	}
	
	public void testSugaredAssignment_onThis() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    string = 'foo'\n" + 
				"  }" +
				"  def setString(String aString) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setString(java.lang.String)", assignment);
	}
	
	public void testUnqualifiedField_withConflict_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.Properties1 it) {\n" + 
				"    prop1 = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.prop1", assignment);
	}
	
	public void testSugaredAssignment_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.Properties1 it) {\n" + 
				"    prop2 = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.setProp2(java.lang.String)", assignment);
	}
	
	public void testSugaredAssignment_onExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    prop2 = 'foo'\n" + 
				"  }\n" +
				"  extension testdata.Properties1" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.setProp2(java.lang.String)", assignment);
	}
	
	public void testSugaredAssignment_asExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String something) {\n" + 
				"    something.myValue = 'foo'\n" + 
				"  }\n" +
				"  def void setMyValue(String something, String value) {}" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setMyValue(java.lang.String,java.lang.String)", assignment);
	}
	
	public void testSugaredAssignment_onThis_withIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String it) {\n" + 
				"    value = 'foo'\n" + 
				"  }\n" +
				"  def void setValue(String receiver, String value) {}" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setValue(java.lang.String,java.lang.String)", assignment);
	}
	
	protected void assertLinksTo(String identifier, XAssignment featureCall) {
		assertLinksTo(identifier, featureCall, false);
	}
	
	protected void assertLinksTo(String identifier, EClass type, XAssignment featureCall) {
		assertLinksTo(identifier, type, featureCall, false);
	}
	
	protected void assertLinksTo(String identifier, XAssignment featureCall, boolean withIssues) {
		assertLinksTo(identifier, TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT, featureCall, withIssues);
	}
	
	protected void assertLinksTo(String identifier, EClass type, XAssignment featureCall, boolean withIssues) {
		assertNotNull("feature is available", featureCall.getFeature());
		JvmIdentifiableElement linked = featureCall.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertEquals(identifier, linked.getIdentifier());
		assertTrue(type.isInstance(linked));
		if (withIssues)
			assertNotNull("Expected issues", featureCall.getInvalidFeatureIssueCode());
		else {
			assertNull(featureCall.getInvalidFeatureIssueCode(), featureCall.getInvalidFeatureIssueCode());
			validator.assertNoErrors(featureCall);
		}
	}

	protected XAssignment getLastAssignment(XtendClass clazz) {
		return getAssignment(clazz, -1);
	}
	
	protected XAssignment getAssignment(XtendClass clazz, int assignmentInFunction) {
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		List<XExpression> expressions = body.getExpressions();
		int idx = assignmentInFunction;
		if (idx == -1)
			idx = expressions.size() - 1;
		XAssignment result = (XAssignment) expressions.get(idx);
		return result;
	}
	
}
