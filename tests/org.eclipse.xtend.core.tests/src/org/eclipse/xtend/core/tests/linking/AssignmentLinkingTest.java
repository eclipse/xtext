/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AssignmentLinkingTest extends AbstractXtendTestCase {

	@Inject
	private ValidationTestHelper validator;
	
	@Test public void testBug447982_01() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def m() {\n" + 
				"		x = 1\n" + 
				"	} \n" + 
				"	def x(int x) {}\n" + 
				"	def setX(int x) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("C.setX(int)", TypesPackage.Literals.JVM_OPERATION, assignment);
	}
	
	@Test public void testBug447982_02() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def static m() {\n" + 
				"		x = 1\n" + 
				"	} \n" + 
				"	def static x(int x) {}\n" + 
				"	def static setX(int x) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("C.setX(int)", TypesPackage.Literals.JVM_OPERATION, assignment);
	}

	@Test public void testBug447982_03() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def m() {\n" + 
				"		x = 1\n" + 
				"	} \n" + 
				"	int x\n" + 
				"	def setX(int x) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("C.x", TypesPackage.Literals.JVM_FIELD, assignment);
	}
	
	@Test public void testBug447982_04() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def static m() {\n" + 
				"		x = 1\n" + 
				"	} \n" + 
				"	static int x\n" + 
				"	def static setX(int x) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("C.x", TypesPackage.Literals.JVM_FIELD, assignment);
	}
	
	@Test public void testBug447982_05() throws Exception {
		XtendClass clazz = clazz(
				"class C {\n" + 
				"	def m(String it) {\n" + 
				"		x = 1\n" + 
				"	} \n" + 
				"	def x(String s, int x) {}\n" + 
				"	def setX(String s, int x) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("C.setX(java.lang.String,int)", TypesPackage.Literals.JVM_OPERATION, assignment);
	}
	
	@Test public void testLocalVariable() throws Exception {
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
	
	@SuppressWarnings("deprecation")
	@Test public void testParameter() throws Exception {
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
	
	@Test public void testQualifiedField() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    this.aString = 'foo'\n" + 
				"  }" +
				"  String aString\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.aString", assignment);
		assertNull(assignment.getImplicitReceiver());
	}
	
	@Test public void testUnqualifiedField_onThis() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    aString = 'foo'\n" + 
				"  }" +
				"  String aString\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.aString", assignment);
		assertImplicitReceiver("SomeClass", assignment);
	}
	
	@Test public void testUnqualifiedField_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.FieldAccess it) {\n" + 
				"    stringField = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.FieldAccess.stringField", assignment);
		assertImplicitReceiver("it", assignment);
	}
	
	@Test public void testUnqualifiedField_onExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    stringField = 'foo'\n" + 
				"  }\n" +
				"  extension testdata.FieldAccess" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.FieldAccess.stringField", assignment);
		assertImplicitReceiver("SomeClass._fieldAccess", assignment);
	}
	
	@Test public void testSugaredAssignment_onThis() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    string = 'foo'\n" + 
				"  }" +
				"  def setString(String aString) {}\n" + 
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setString(java.lang.String)", assignment);
		assertImplicitReceiver("SomeClass", assignment);
	}
	
	@Test public void testUnqualifiedField_withConflict_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.Properties1 it) {\n" + 
				"    prop1 = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.prop1", assignment);
		assertImplicitReceiver("it", assignment);
	}
	
	@Test public void testSugaredAssignment_onIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(testdata.Properties1 it) {\n" + 
				"    prop2 = 'foo'\n" + 
				"  }" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.setProp2(java.lang.String)", assignment);
		assertImplicitReceiver("it", assignment);
	}
	
	@Test public void testSugaredAssignment_onExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    prop2 = 'foo'\n" + 
				"  }\n" +
				"  extension testdata.Properties1" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("testdata.Properties1.setProp2(java.lang.String)", assignment);
		assertImplicitReceiver("SomeClass._properties1", assignment);
	}
	
	@Test public void testSugaredAssignment_asExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String something) {\n" + 
				"    something.myValue = 'foo'\n" + 
				"  }\n" +
				"  def void setMyValue(String something, String value) {}" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setMyValue(java.lang.String,java.lang.String)", assignment);
		assertImplicitReceiver("SomeClass", assignment);
	}
	
	@Test public void testSugaredAssignment_onThis_withIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String it) {\n" + 
				"    value = 'foo'\n" + 
				"  }\n" +
				"  def void setValue(String receiver, String value) {}" +
				"}");
		XAssignment assignment = getLastAssignment(clazz);
		assertLinksTo("SomeClass.setValue(java.lang.String,java.lang.String)", assignment);
		assertImplicitReceiver("SomeClass", assignment);
	}
	
	protected void assertLinksTo(String identifier, XAssignment featureCall) {
		assertLinksTo(identifier, featureCall, false);
	}
	
	protected void assertImplicitReceiver(String identifier, XAssignment assignment) {
		assertTrue("assignment.implicitReceiver instanceof XFeatureCall", assignment.getImplicitReceiver() instanceof XAbstractFeatureCall);
		XAbstractFeatureCall implicitReceiver = (XAbstractFeatureCall) assignment.getImplicitReceiver();
		JvmIdentifiableElement linked = implicitReceiver.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertEquals(identifier, linked.getIdentifier());
	}
	
	protected void assertLinksTo(String identifier, EClass type, XAssignment featureCall) {
		assertLinksTo(identifier, type, featureCall, false);
	}
	
	protected void assertLinksTo(String identifier, XAssignment featureCall, boolean withIssues) {
		assertLinksTo(identifier, TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT, featureCall, withIssues);
	}
	
	@SuppressWarnings("deprecation")
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
