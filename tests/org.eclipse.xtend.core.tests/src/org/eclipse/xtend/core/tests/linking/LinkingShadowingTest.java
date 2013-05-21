/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingShadowingTest extends AbstractXtendTestCase {

	@Inject
	private ValidationTestHelper validator;
	
	@Test public void testField_noConflicts_local() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    aString\n" + 
				"  }\n" + 
				"  private String aString\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.aString", featureCall);
	}
	
	@Test public void testField_noConflicts_inheritedProtected() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass extends testdata.LinkingType {\n" +
				"  def method() {\n" + 
				"    protectedField\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.protectedField", featureCall);
	}
	
	@Test public void testField_noConflicts_publicOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_noConflicts_protectedOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    protectedField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.protectedField", featureCall, true);
	}
	
	@Test public void testField_noConflicts_publicOnExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_noConflicts_protectedOnExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    protectedField\n" + 
				"  }" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.protectedField", featureCall, true);
	}

	@Test public void testField_noConflicts_publicStaticImport() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.publicField", featureCall);
	}
	
	@Test public void testField_noConflicts_protectedStaticImport() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    protectedField\n" + 
				"  }" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.protectedField", featureCall, true);
	}
	
	@Test public void testField_noConflicts_publicStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.publicField", featureCall);
	}
	
	@Test public void testField_noConflicts_protectedStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    protectedField\n" + 
				"  }" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.protectedField", featureCall, true);
	}
	
	@Test public void testParameter_noConflict() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(String aString) {\n" + 
				"    aString\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("aString", featureCall);
	}
	
	@Test public void testParameter_shadows_field() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(String aString) {\n" + 
				"    aString\n" + 
				"  }\n" +
				"  String aString" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("aString", featureCall);
	}
	
	@Test public void testParameter_shadows_fieldOfIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(String publicField, testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("publicField", featureCall);
	}
	
	@Test public void testLocalVariable_noConflict() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    val String aString = null\n" +
				"    aString\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFeatureCall(clazz, 1);
		assertLinksTo("aString", featureCall);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testLocalVariable_shadows_parameter() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(String aString) {\n" + 
				"    val String aString = null\n" +
				"    aString\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFeatureCall(clazz, 1);
		assertNotNull("feature is available", featureCall.getFeature());
		JvmIdentifiableElement linked = featureCall.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertEquals("aString", linked.getIdentifier());
		assertTrue(XbasePackage.Literals.XVARIABLE_DECLARATION.isInstance(linked));
		assertNull(featureCall.getInvalidFeatureIssueCode(), featureCall.getInvalidFeatureIssueCode());
	}
	
	@Test public void testLocalVariable_shadows_field() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    val String aString = null\n" +
				"    aString\n" + 
				"  }\n" +
				"  String aString" +
				"}");
		XAbstractFeatureCall featureCall = getFeatureCall(clazz, 1);
		assertLinksTo("aString", XbasePackage.Literals.XVARIABLE_DECLARATION, featureCall);
	}
	
	@Test public void testLocalVariable_shadows_fieldOfIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" +
				"    val String publicField = null\n" +
				"    publicField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFeatureCall(clazz, 1);
		assertLinksTo("publicField", featureCall);
	}
	
	@Test public void testField_onIt_shadows_local() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" + 
				"  public String publicField\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_onIt_shadows_injectedExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" + 
				"  extension testdata.LinkingTypeEquallyNamed\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_onIt_shadows_importedExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_onIt_shadows_staticallyImported() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    publicField\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_local_shadows_injectedExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  String publicField\n" + 
				"  extension testdata.LinkingType\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.publicField", featureCall);
	}
	
	@Test public void testField_local_shadows_importedExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  String publicField\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.publicField", featureCall);
	}
	
	@Test public void testField_local_shadows_staticallyImported() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  String publicField\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.publicField", featureCall);
	}
	
	@Test public void testField_inherited_shadows_injectedExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass extends testdata.LinkingType {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  extension testdata.LinkingTypeEquallyNamed\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_inherited_shadows_importedExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*" +
				"class SomeClass extends testdata.LinkingType {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_inherited_shadows_staticallyImported() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*" +
				"class SomeClass extends testdata.LinkingType {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_injectedExtension_shadows_importedExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  extension testdata.LinkingType\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_injectedExtension_shadows_staticallyImported() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    publicField\n" + 
				"  }\n" +
				"  extension testdata.LinkingType\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.publicField", featureCall);
	}
	
	@Test public void testField_local_shadowsInvisibleOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    protectedField\n" + 
				"  }\n" + 
				"  String protectedField\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.protectedField", featureCall);
	}
	
	@Test public void testField_inherited_shadowsInvisibleOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass extends testdata.LinkingType {\n" +
				"  def method(testdata.LinkingTypeEquallyNamed it) {\n" + 
				"    protectedField\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.protectedField", featureCall);
	}
	
	@Test public void testField_local_shadows_sugarOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" + 
				"  String fieldOverloadsMethod\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.fieldOverloadsMethod", featureCall);
	}
	
	@Test public void testField_inherited_shadows_sugarOnIt() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass extends testdata.LinkingTypeEquallyNamed {\n" +
				"  def method(testdata.LinkingTypeEquallyNamed it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingTypeEquallyNamed.fieldOverloadsMethod", featureCall);
	}
	
	@Test public void testField_staticallyImported_shadows_sugarOnIt() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.fieldOverloadsMethod", featureCall);
	}
	
	@Test public void testField_staticExtension_shadows_sugarOnIt() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticType.*\n" +
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticType.fieldOverloadsMethod", featureCall);
	}
	
	@Test public void testOperation_sugarOnIt_shadows_sugarOnThis() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(testdata.LinkingType it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" +
				"  def fieldOverloadsMethod() {}" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.fieldOverloadsMethod()", featureCall);
	}
	
	@Test public void testOperation_sugarOnThis_shadows_sugarOnExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" +
				"  def fieldOverloadsMethod() {}" +
				"  extension testdata.LinkingType" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.fieldOverloadsMethod()", featureCall);
	}
	
	@Test public void testOperation_sugarOnExtension_shadows_sugarOnStatic() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticTypeEquallyNamed.*\n" +
				"class SomeClass {\n" +
				"  def method() {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" +
				"  extension testdata.LinkingType" + 
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.fieldOverloadsMethod()", featureCall);
	}
	
	@Test public void testOperation_sugarOnStatic_shadows_implicitArgumentOnThis() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticTypeEquallyNamed.*\n" +
				"class SomeClass {\n" +
				"  def method(Object it) {\n" + 
				"    fieldOverloadsMethod\n" + 
				"  }\n" +
				"  def fieldOverloadsMethod(Object o) {}" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticTypeEquallyNamed.fieldOverloadsMethod()", featureCall);
	}
	
	@Test public void testOperation_implicitArgumentOnThis_shadows_implicitArgumentOnExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def method(Object it) {\n" + 
				"    withArgument\n" + 
				"  }\n" +
				"  def withArgument(Object o) {}\n" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.withArgument(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_implicitArgumentOnExtension_shadows_implicitArgumentOnStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument\n" + 
				"  }\n" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.withArgument(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_implicitArgumentOnStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_implicitArgumentOnStaticExtension_shadows_sugarImplicitArgumentOnThis() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument\n" + 
				"  }" +
				"  def getWithArgument(Object it) {}\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		// TODO I think this should link to the static method 'withArgument' instead of 'getWithArgument'
//		assertLinksTo("testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object)", featureCall);
		assertLinksTo("SomeClass.getWithArgument(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_sugarImplicitArgumentOnThis_shadows_sugarImplicitArgumentOnExtension() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument2\n" + 
				"  }" +
				"  def getWithArgument2(Object it) {}\n" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.getWithArgument2(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_sugarImplicitArgumentOnExtension_shadows_sugarOnStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument2\n" + 
				"  }" +
				"  extension testdata.LinkingType\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingType.getWithArgument2(java.lang.Object)", featureCall);
	}

	@Test public void testOperation_sugarOnStaticExtension() throws Exception {
		XtendClass clazz = clazz(
				"import static extension testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument2\n" + 
				"  }" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("testdata.LinkingStaticTypeEquallyNamed.getWithArgument2(java.lang.Object)", featureCall);
	}
	
	@Test public void testOperation_implicitArgumentOnStatic() throws Exception {
		XtendClass clazz = clazz(
				"import static testdata.LinkingStaticTypeEquallyNamed.*" +
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    withArgument\n" + 
				"  }\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertNotNull("feature is available", featureCall.getFeature());
		JvmIdentifiableElement linked = featureCall.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertTrue(
				"testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object)".equals(linked.getIdentifier()) ||
				"testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object,int,int)".equals(linked.getIdentifier()));
		assertFalse(clazz.eResource().getErrors().isEmpty());
	}
	
	@Test public void testOperationWithParam_noConflict() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    methodWithParam('foo')\n" + 
				"  }\n" +
				"  def methodWithParam(String s) {}" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String)", featureCall);
	}
	
	@Test public void testOperationWithParam_itPresent() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String it) {\n" + 
				"    methodWithParam('foo')\n" + 
				"  }\n" +
				"  def methodWithParam(String s) {}" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testOperationWithTwoParams_noConflict() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    methodWithParam('foo', 'bar')\n" + 
				"  }\n" +
				"  def methodWithParam(String s1, String s2) {}" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String,java.lang.String)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testOperationWithTwoParams_itPresent() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    methodWithParam(it.toString, 'bar')\n" + 
				"  }\n" +
				"  def methodWithParam(String s1, String s2) {}" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String,java.lang.String)", featureCall);
	}
	
	@Test public void testOperationWithParam_overloaded() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    methodWithParam('foo')\n" + 
				"  }\n" +
				"  def methodWithParam(String s) {}\n" +
				"  def methodWithParam(StringBuffer s) {}\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String)", featureCall);
	}
	
	@Test public void testOperationWithParam_overloaded_itPresent() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(String it) {\n" + 
				"    methodWithParam('foo')\n" + 
				"  }\n" +
				"  def methodWithParam(String s) {}\n" +
				"  def methodWithParam(StringBuffer s) {}\n" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testOperationWithTwoParams_overloaded() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method() {\n" + 
				"    methodWithParam('foo', 'bar')\n" + 
				"  }\n" +
				"  def methodWithParam(String s1, String s2) {}\n" +
				"  def methodWithParam(StringBuffer s1, String s2) {}\n" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String,java.lang.String)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testStaticImport_overloaded() throws Exception {
		XtendClass clazz = clazz(
				"import static org.junit.Assert.*\n" +
				"class SomeClass extends org.junit.Assert {\n" +
				"  def void method() {\n" + 
				"    assertTrue(false)\n" + 
				"  }\n" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("org.junit.Assert.assertTrue(boolean)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
		assertNull(featureCall.getImplicitReceiver());
	}
	
	@Test public void testStaticMethod_overloaded() throws Exception {
		XtendClass clazz = clazz(
				"import org.junit.Assert\n" +
				"class SomeClass extends org.junit.Assert {\n" +
				"  def void method() {\n" + 
				"    Assert::assertTrue(false)\n" + 
				"  }\n" +
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("org.junit.Assert.assertTrue(boolean)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
		assertNull(featureCall.getImplicitReceiver());
	}
	
	@Test public void testStaticMethod_overloaded_noImport() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass extends org.junit.Assert {\n" +
				"  def void method() {\n" + 
				"    assertTrue(false)\n" + 
				"  }\n" +
				"}");
		XFeatureCall featureCall = (XFeatureCall) getFirstFeatureCall(clazz);
		assertLinksTo("org.junit.Assert.assertTrue(boolean)", featureCall);
		assertNull(featureCall.getImplicitFirstArgument());
		assertNull(featureCall.getImplicitReceiver());
	}
	
	@Test public void testOperationWithTwoParams_overloaded_itPresent() throws Exception {
		XtendClass clazz = clazz(
				"class SomeClass {\n" +
				"  def void method(Object it) {\n" + 
				"    methodWithParam('foo', 'bar')\n" + 
				"  }\n" +
				"  def methodWithParam(String s1, String s2) {}\n" +
				"  def methodWithParam(StringBuffer s1, String s2) {}\n" +
				"}");
		XAbstractFeatureCall featureCall = getFirstFeatureCall(clazz);
		assertLinksTo("SomeClass.methodWithParam(java.lang.String,java.lang.String)", featureCall);
	}
	
	protected void assertLinksTo(String identifier, XAbstractFeatureCall featureCall) {
		assertLinksTo(identifier, featureCall, false);
	}
	
	protected void assertLinksTo(String identifier, EClass type, XAbstractFeatureCall featureCall) {
		assertLinksTo(identifier, type, featureCall, false);
	}
	
	protected void assertLinksTo(String identifier, XAbstractFeatureCall featureCall, boolean withIssues) {
		assertLinksTo(identifier, TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT, featureCall, withIssues);
	}
	
	protected void assertLinksTo(String identifier, EClass type, XAbstractFeatureCall featureCall, boolean withIssues) {
		assertNotNull("feature is available", featureCall.getFeature());
		JvmIdentifiableElement linked = featureCall.getFeature();
		assertFalse("is resolved", linked.eIsProxy());
		assertEquals(identifier, linked.getIdentifier());
		assertTrue(type.isInstance(linked));
		if (!withIssues) {
			validator.assertNoErrors(featureCall);
		} else {
			assertFalse(featureCall.eResource().getErrors().isEmpty());
		}
	}

	protected XAbstractFeatureCall getFirstFeatureCall(XtendClass clazz) {
		return getFeatureCall(clazz, 0);
	}
	
	protected XAbstractFeatureCall getFeatureCall(XtendClass clazz, int expressionInFunction) {
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) function.getExpression();
		XAbstractFeatureCall result = (XAbstractFeatureCall) body.getExpressions().get(expressionInFunction);
		return result;
	}
	
}
