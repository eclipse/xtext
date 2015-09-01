/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import static com.google.common.collect.Iterables.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

import testdata.OverloadedMethods;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("deprecation")
public class LinkingTest extends AbstractXtendTestCase {
	
	private static Set<String> files;
	
	@BeforeClass
	public static void recordFiles() {
		files = Sets.newHashSet();
	}
	
	@AfterClass
	public static void clearRecording() {
		files = null;
	}
	
	@Override
	protected XtendFile file(String string) throws Exception {
		assertTrue(string, files.add(string));
		return file(string, false);
	}
	
	@Inject
	protected IXtendJvmAssociations associator;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Test public void testBug460191() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"    def Iterable<K> getFs(Iterable<I> l) {\n" + 
				"        l.filter[true]\n" + 
				"    }\n" + 
				"    interface I {}\n" + 
				"    interface K extends I {}\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.filter(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", feature.getIdentifier());
		assertNull(featureCall.getImplicitReceiver());
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testBug464264_01() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" + 
				"class C {\n" + 
				"	def m(I i, List<CharSequence> list) {\n" + 
				"		i.strings += list.map[it]\n" + 
				"	}\n" + 
				"	interface I {\n" + 
				"		def List<String> getStrings()\n" + 
				"	}\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XBinaryOperation featureCall = (XBinaryOperation) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.operator_add(java.util.Collection,java.lang.Iterable)", feature.getIdentifier());
		assertNull(featureCall.getImplicitReceiver());
		assertNull(featureCall.getImplicitFirstArgument());
		List<Diagnostic> errors = c.eResource().getErrors();
		assertEquals(1, errors.size());
		assertEquals("Type mismatch: cannot convert from List<CharSequence> to Iterable<? extends String>", errors.get(0).getMessage());
	}
	
	@Test public void testOverloadStaticInstance_01() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"	def void m(CharSequence c) {\n" + 
				"		m('')\n" + 
				"	}\n" + 
				"	def static void m(String s) {}\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("C.m(java.lang.String)", feature.getIdentifier());
		assertNull(featureCall.getImplicitReceiver());
		assertNull(featureCall.getImplicitFirstArgument());
	}
	
	@Test public void testStaticNestedClass_01() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"  static class D {\n" +
				"    def static void m(CharSequence c) { m('') }\n" +
				"  }\n" +
				"  def void m(String s) {}\n" +
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendClass d = (XtendClass) c.getMembers().get(0);
		XtendFunction m = (XtendFunction) d.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("C$D.m(java.lang.CharSequence)", feature.getIdentifier());
	}
	
	@Test public void testStaticNestedClass_02() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"  static class D {\n" +
				"    def static void m(CharSequence c) { m('') }\n" +
				"  }\n" +
				"  def static void m(String s) {}\n" +
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendClass d = (XtendClass) c.getMembers().get(0);
		XtendFunction m = (XtendFunction) d.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("C.m(java.lang.String)", feature.getIdentifier());
	}
	
	@Test public void testQualifiedThis() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"  def void m() { C.this.m2() }\n" +
				"  def void m2() {}\n" +
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction n = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) n.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("C.m2()", feature.getIdentifier());
	}
	
	@Test public void testQualifiedThisOuter() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"  def void m() { new Object { def m3() { C.this.m2() } } }\n" +
				"  def void m2() {}\n" +
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression outer = (XBlockExpression) m.getExpression();
		AnonymousClass anonymousClass = (AnonymousClass) outer.getExpressions().get(0);
		XtendFunction m3 = (XtendFunction) anonymousClass.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m3.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("C.m2()", feature.getIdentifier());
	}
	
	@Test public void testQualifiedSuper() throws Exception {
		XtendFile file = file(
				"class B<T> { def T m1() {} }\n" +
				"class C extends B<String> {\n" + 
				"  def void m2() { C.super.m1.subSequence(1, 1) } \n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(1);
		XtendFunction n = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) n.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("java.lang.String.subSequence(int,int)", feature.getIdentifier());
	}
	
	@Test public void testQualifiedSuperOuter() throws Exception {
		XtendFile file = file(
				"class B<T> { def T m1() {} }\n" +
				"class C extends B<String> {\n" + 
				"  def void m2() { new Object { def m3() { C.super.m1.subSequence(1, 1) } } }\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(1);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression outer = (XBlockExpression) m.getExpression();
		AnonymousClass anonymousClass = (AnonymousClass) outer.getExpressions().get(0);
		XtendFunction m3 = (XtendFunction) anonymousClass.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m3.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("java.lang.String.subSequence(int,int)", feature.getIdentifier());
	}
	
	@Test public void testSuper() throws Exception {
		XtendFile file = file(
				"class B<T> { def T m1() {} }\n" +
				"class C extends B<String> {\n" + 
				"  def void m2() { super.m1.subSequence(1,1) }\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(1);
		XtendFunction n = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) n.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement feature = featureCall.getFeature();
		assertEquals("java.lang.String.subSequence(int,int)", feature.getIdentifier());
	}
	
	@Test public void testBug426788() throws Exception {
		XtendFile file = file("class Bug {\n" + 
				"  def <T extends Object> void m(T t) {}\n" + 
				"  def void m(CharSequence t) {}\n" + 
				"  def void n(Iterable<String> it) {\n" + 
				"    m(it.head)           \n" + 
				"    m(it.iterator.next)  \n" + 
				"    m(\"\")              \n" + 
				"  }\n" + 
				"}");
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction n = (XtendFunction) c.getMembers().get(2);
		XBlockExpression body = (XBlockExpression) n.getExpression();
		for(XExpression featureCall: body.getExpressions()) {
			XFeatureCall casted = (XFeatureCall) featureCall;
			JvmIdentifiableElement method = casted.getFeature();
			assertEquals("Bug.m(java.lang.CharSequence)", method.getIdentifier());
		}
	}
	
	@Test public void testExplicitTypeOverSugar_01() throws Exception {
		XtendFile file = file(
				"import static extension org.eclipse.emf.ecore.util.EcoreUtil.*\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"import org.eclipse.emf.common.util.URI\n" + 
				"\n" + 
				"class C {\n" + 
				"  def m(EObject it) {\n" + 
				"    URI::createURI(\"someString\")\n" + 
				"  }\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.emf.common.util.URI.createURI(java.lang.String)", method.getIdentifier());
		assertTrue(featureCall.isStaticWithDeclaringType());
		XFeatureCall target = (XFeatureCall) featureCall.getMemberCallTarget();
		assertTrue(target.isTypeLiteral());
		assertEquals("org.eclipse.emf.common.util.URI", target.getFeature().getIdentifier());
	}

	@Test public void testExplicitTypeOverSugar_02() throws Exception {
		XtendFile file = file(
				"import static extension org.eclipse.emf.ecore.util.EcoreUtil.*\n" + 
				"import org.eclipse.emf.ecore.EObject\n" + 
				"import org.eclipse.emf.common.util.URI\n" + 
				"\n" + 
				"class C {\n" + 
				"  def m(EObject it) {\n" + 
				"    URI.appendFragment(\"someString\")\n" + 
				"  }\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.emf.common.util.URI.appendFragment(java.lang.String)", method.getIdentifier());
		assertFalse(featureCall.isStaticWithDeclaringType());
		XFeatureCall target = (XFeatureCall) featureCall.getMemberCallTarget();
		assertFalse(target.isTypeLiteral());
		assertEquals("org.eclipse.emf.ecore.util.EcoreUtil.getURI(org.eclipse.emf.ecore.EObject)", target.getFeature().getIdentifier());
	}
	
	@Test public void testSugarOverTypeLiteral_01() throws Exception {
		XtendFile file = file(
				"import org.eclipse.emf.ecore.resource.Resource\n" +
				"import org.eclipse.emf.common.util.URI\n" +
				"class C {\n" +
				"	def m(Resource it, URI unused) {\n" +
				"		URI" +
				"	}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.emf.ecore.resource.Resource.getURI()", method.getIdentifier());
	}
	
	@Test public void testSugarOverTypeLiteral_02() throws Exception {
		XtendFile file = file(
				"import org.eclipse.emf.ecore.resource.Resource\n" +
				"import org.eclipse.emf.common.util.URI\n" +
				"class C {\n" +
				"	def m(Resource Resource, URI unused) {\n" +
				"		Resource.URI" +
				"	}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.emf.ecore.resource.Resource.getURI()", method.getIdentifier());
	}

	@Test public void testSugarOverTypeLiteral_03() throws Exception {
		XtendFile file = file(
				"import org.eclipse.emf.ecore.EPackage\n" +
				"class C {\n" +
				"	def m(Object it) {\n" +
				"		EPackage" +
				"	}" +
				"	def void getEPackage(Object o) {}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.getEPackage(java.lang.Object)", method.getIdentifier());
	}
	
	@Test public void testSugarOverTypeLiteral_04() throws Exception {
		XtendFile file = file(
				"import org.eclipse.emf.ecore.EPackage\n" +
				"class C {\n" +
				"	def m(Object it) {\n" +
				"		EPackage" +
				"	}" +
				"	def void getEPackage(String s) {}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.emf.ecore.EPackage", method.getIdentifier());
	}
	
	@Test public void testExplicitStaticInvocation_01() throws Exception {
        XtendFile file = file(
                "class C {\n" +
                "   static def void getFields() {\n" +
                "       C::fields" +
                "   }" +
                "}\n");
        XtendClass c = (XtendClass) file.getXtendTypes().get(0);
        XtendFunction m = (XtendFunction) c.getMembers().get(0);
        XBlockExpression body = (XBlockExpression) m.getExpression();
        XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
        JvmIdentifiableElement method = featureCall.getFeature();
        assertEquals("C.getFields()", method.getIdentifier());
    }
	
	@Test public void testNestedTypeResolution_01() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolution_02() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolution_03() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolution_04() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolution_05() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(EDataType$Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolution_06() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory\n" +
				"class C {\n" +
				"	def m(Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolution_07() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate\n" +
				"class C {\n" +
				"	def m(ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolution_08() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal\n" +
				"class C {\n" +
				"	def m(Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolution_09() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType\n" +
				"class C {\n" +
				"	def m(EDataType$Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	
	@Test public void testNestedTypeResolutionWithDot_01() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDot_02() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDot_03() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDot_04() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDot_05() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(EDataType.Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDot_06() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory\n" +
				"class C {\n" +
				"	def m(Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDot_07() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate\n" +
				"class C {\n" +
				"	def m(ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDot_08() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal\n" +
				"class C {\n" +
				"	def m(Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDot_09() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType\n" +
				"class C {\n" +
				"	def m(EDataType.Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	
	@Test public void testNestedTypeResolutionWithDotInImport_01() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_02() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_03() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_04() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory.Registry\n" +
				"class C {\n" +
				"	def m(EDataType$Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_05() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate.Factory\n" +
				"class C {\n" +
				"	def m(Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_06() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate\n" +
				"class C {\n" +
				"	def m(ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDotInImport_07() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType.Internal\n" +
				"class C {\n" +
				"	def m(Internal$ConversionDelegate$Factory$Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	
	@Test public void testNestedTypeResolutionWithDotInUsage_01() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_02() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_03() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_04() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry\n" +
				"class C {\n" +
				"	def m(EDataType.Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", false);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_05() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory\n" +
				"class C {\n" +
				"	def m(Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_06() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate\n" +
				"class C {\n" +
				"	def m(ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	@Test public void testNestedTypeResolutionWithDotInUsage_07() throws Exception {
		doTestNestedTypeResolution(
				"import org.eclipse.emf.ecore.EDataType$Internal\n" +
				"class C {\n" +
				"	def m(Internal.ConversionDelegate.Factory.Registry r) {\n" +
				"	}\n" +
				"}\n", true);
	}
	
	protected void doTestNestedTypeResolution(String input, boolean success) throws Exception {
		XtendFile file = file(input); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XtendParameter firstParameter = m.getParameters().get(0);
		JvmType parameterType = firstParameter.getParameterType().getType();
		if (success)
			assertEquals("org.eclipse.emf.ecore.EDataType$Internal$ConversionDelegate$Factory$Registry", parameterType.getIdentifier());
		else
			assertTrue(parameterType.eIsProxy());
	}
	
	@Test public void testBug405144_01() throws Exception {
		XtendFile file = file(
				"import com.google.inject.Injector\n" +
				"class C {\n" +
				"	def m(Injector i, Class<? extends CharSequence> c) {\n" +
				"		i.getInstance(c)\n" +
				"	}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("com.google.inject.Injector.getInstance(java.lang.Class)", method.getIdentifier());
	}
	
	@Test public void testBug403580_01() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s ]\n" +
				"	}\n" +
				"	def void overloaded(Object o)" +
				"	def <T> void overloaded(Comparable<T> c)" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(java.lang.Object)", method.getIdentifier());
	}
	
	@Test public void testBug403580_02() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s.length ]\n" +
				"	}\n" +
				"	def void overloaded(Object o)" +
				"	def <T> void overloaded(Comparable<T> c)" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(java.lang.Comparable)", method.getIdentifier());
	}
	
	@Test public void testBug403580_03() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s ]\n" +
				"	}\n" +
				"	def void overloaded((String)=>String s)" +
				"	def <T> void overloaded(Comparable<T> c)" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
	}
	
	@Test public void testBug403580_04() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s.length ]\n" +
				"	}\n" +
				"	def void overloaded((String)=>String s)" +
				"	def <T> void overloaded(Comparable<T> c)" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(java.lang.Comparable)", method.getIdentifier());
	}
	
	@Test public void testBug403580_05() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s ]\n" +
				"	}\n" +
				"	def void overloaded((String)=>String s)" +
				"	def void overloaded(Object o)" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
	}
	
	@Test public void testBug403580_06() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s.length ]\n" +
				"	}\n" +
				"	def void overloaded((String)=>String s)" +
				"	def void overloaded(Object o)" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(java.lang.Object)", method.getIdentifier());
	}
	
	@Ignore("Depends on the order of the overloaded methods")
	@Test public void testBug403580_07() throws Exception {
		XtendFile file = file(
				"abstract class C {\n" +
				"	def void m() {\n" +
				"		overloaded [ String s | s.length ]\n" +
				"	}\n" +
				"	def <T> void overloaded(Comparable<T> c)" + 
				"	def void overloaded((String)=>int s)" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("C.overloaded(java.lang.Comparable)", method.getIdentifier());
	}
	
	@Test public void testOverloadedWithLambdaArgument_01() throws Exception {
		XtendFile file = file(
				"import static extension com.google.common.collect.Iterables.*" +
				"abstract class C {\n" +
				"	def void m(Iterable<String> iter) {\n" +
				"		iter.filter [ it != null ]\n" +
				"	}\n" +
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("com.google.common.collect.Iterables.filter(java.lang.Iterable,com.google.common.base.Predicate)", method.getIdentifier());
	}
	
	@Test public void testBug400807() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import bug400807.Bug400807\n" +
				"class C {\n" +
				"	def Bug400807 m() {\n" +
				"		[ string ]\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XClosure lambda = (XClosure) body.getExpressions().get(0);
		XBlockExpression innerBody = (XBlockExpression) lambda.getExpression();
		XAbstractFeatureCall string = (XAbstractFeatureCall) innerBody.getExpressions().get(0);
		assertEquals("bug400807.Bug400807Param.getString()", string.getFeature().getIdentifier());
	}
	
	@Test public void testOverloadedMethod_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class C {\n" +
				"	def String m(String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"	def String m() {" +
				"		this.m\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("testPackage.C.m()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testOverloadedMethod_02() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class B extends A {\n" +
				"	override m() {\n" +
				"		super.m\n" +
				"	}\n" +
				"}\n" +
				"class A {\n" +
				"	def String m(String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"	def String m() {\n" +
				"		return null\n" +
				"	}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("testPackage.A.m()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testOverloadedMethod_03() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class B extends A {\n" +
				"	def m() {\n" +
				"		super.m('')\n" +
				"	}\n" +
				"}\n" +
				"class A {\n" +
				"	def String m(String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"	def String m(A a, String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("testPackage.A.m(java.lang.String)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testOverloadedMethod_04() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"class B extends A {\n" +
				"	def m() {\n" +
				"		super.m('')\n" +
				"	}\n" +
				"}\n" +
				"class A {\n" +
				"	def String m(String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"	def String m(B b, String s) {\n" +
				"		return null\n" +
				"	}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("testPackage.A.m(java.lang.String)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C {\n" + 
				"	extension ParseHelper<XtendFile>\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_02() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends ParseHelper<XtendFile>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_03() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends XtendFile> {\n" + 
				"	extension ParseHelper<T>\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_04() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends ParseHelper<? extends XtendFile>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_05() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile, T extends ParseHelper<? extends F>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_06() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<F extends XtendFile, T extends ParseHelper<F>> {\n" + 
				"	extension T\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_07() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends XtendFile> {\n" + 
				"	extension ParseHelper<? extends T>\n" +
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_08() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C<T extends XtendFile> extends ParseHelper<T> {\n" + 
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testParameterizedExtension_09() throws Exception {
		XtendFile file = file(
				"package testPackage\n" +
				"import org.eclipse.xtext.junit4.util.ParseHelper\n" +
				"import org.eclipse.xtend.core.xtend.XtendFile\n" + 
				"class C extends ParseHelper<XtendFile> {\n" + 
				"	def m() {" +
				"		parse('').xtendTypes\n" +
				"	}\n" + 
				"}\n"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XAbstractFeatureCall substring = findSingleFeatureCall(c);
		assertEquals("org.eclipse.xtend.core.xtend.XtendFile.getXtendTypes()", substring.getFeature().getIdentifier());
	}
	
	@Test public void testCircularRecursion_01() throws Exception {
		XtendFile file = file(
				"package testPackage\n" + 
				"class Foo{\n" + 
				"	Bar b\n" + 
				"	def bar(){ \n" + 
				"		b.foo\n" + 
				"	}\n" + 
				"}\n" + 
				"class Bar {\n" + 
				"	Foo f\n" + 
				"	def foo() {\n" + 
				"		f.bar\n" + 
				"	}\n" + 
				"}");
		XtendClass foo = (XtendClass) file.getXtendTypes().get(0);
		XtendClass bar = (XtendClass) file.getXtendTypes().get(1);
		XAbstractFeatureCall fooInvoke = findSingleFeatureCall(foo);
		XAbstractFeatureCall barInvoke = findSingleFeatureCall(bar);
		assertEquals("testPackage.Bar.foo()", fooInvoke.getFeature().getIdentifier());
		assertEquals("testPackage.Foo.bar()", barInvoke.getFeature().getIdentifier());
	}
	
	private XAbstractFeatureCall findSingleFeatureCall(XtendClass clazz) {
		XtendFunction function = (XtendFunction) clazz.getMembers().get(clazz.getMembers().size() - 1);
		XBlockExpression block = (XBlockExpression) function.getExpression();
		return (XAbstractFeatureCall) block.getExpressions().get(0);
	}
	
	@Test public void testDeclaredConstructor_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  int i" +
				"  new(int i) { this.i = i }" +
				"}");
		assertEquals(2, clazz.getMembers().size());
		
		XtendConstructor constructor = (XtendConstructor) clazz.getMembers().get(1);
		XAssignment assignment = (XAssignment) ((XBlockExpression)constructor.getExpression()).getExpressions().get(0);
		JvmField field = (JvmField) assignment.getFeature();
		assertEquals("i", field.getSimpleName());
		XFeatureCall target = (XFeatureCall) assignment.getAssignable();
		JvmDeclaredType identifiableElement = (JvmDeclaredType) target.getFeature();
		assertEquals("Foo", identifiableElement.getSimpleName());
		XFeatureCall value = (XFeatureCall) assignment.getValue();
		JvmFormalParameter parameter = (JvmFormalParameter) value.getFeature();
		assertEquals("i", parameter.getSimpleName());
	}
	
	@Test public void testCreateExtension_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def create list: newArrayList('foo') getListWithFooAnd(String s) {" +
				"	list" +
				"   this.getListWithFooAnd('')" +
				"  }" +
				"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		Set<EObject> elements = associator.getJvmElements(func);
		Iterable<JvmOperation> filter = filter(elements, JvmOperation.class);
		JvmOperation initializer = filter(filter, new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation input) {
				return input.getSimpleName().startsWith("_init_");
			}
		}).iterator().next();
		assertEquals(initializer.getParameters().get(0), featureCall.getFeature());
		XAbstractFeatureCall recursiveFeatureCall = (XAbstractFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(1);
		assertEquals("Foo.getListWithFooAnd(java.lang.String)", recursiveFeatureCall.getFeature().getIdentifier());
	}
	
	@Test public void testCreateExtension_01() throws Exception {
		XtendClass clazz = clazz(
				"class Foo { " +
				"  def create list: newArrayList(s) getListWithFooAnd(String s) {" +
				"	 s" +
				"  }" +
				"}");
		assertEquals(1, clazz.getMembers().size());
		
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) func.getCreateExtensionInfo().getCreateExpression();
		List<XExpression> arguments = featureCall.getActualArguments();
		XFeatureCall argument = (XFeatureCall) arguments.get(0);
		JvmFormalParameter parameter = (JvmFormalParameter) argument.getFeature();
		assertEquals("s", parameter.getIdentifier());
		JvmOperation operation = (JvmOperation) parameter.eContainer();
		assertEquals("Foo.getListWithFooAnd(java.lang.String)", operation.getIdentifier());
		
		XFeatureCall featureCallInInitializer = (XFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmFormalParameter parameterInInitializer = (JvmFormalParameter) featureCallInInitializer.getFeature();
		assertEquals("s", parameterInInitializer.getIdentifier());
		JvmOperation initializer = (JvmOperation) parameterInInitializer.eContainer();
		assertEquals("Foo._init_getListWithFooAnd(java.util.ArrayList,java.lang.String)", initializer.getIdentifier());
	}
	
	@Test public void testXtendField_00() throws Exception {
		XtendClass clazz = clazz(
				"class Foo {" +
				"  @com.google.inject.Inject java.util.ArrayList<String> arrayList" +
				"  def foo() {arrayList}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		JvmField field = (JvmField) associator.getJvmElements(clazz.getMembers().get(0)).iterator().next();
		assertSame(field, ((XFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0)).getFeature());
	}
	
	@Test public void testInjectedExtensionMethodCall() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  @com.google.inject.Inject extension String string" +
				"  def foo() " +
				"    {(1 as int).indexOf()}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("java.lang.String.indexOf(int)", call.getFeature().getIdentifier());
		assertEquals("Foo.string", ((XMemberFeatureCall)call.getImplicitReceiver()).getFeature().getIdentifier());
	}
	
	@Test public void testLocalVarExtensionMethodCall() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  def foo() " +
				"    { extension var local = '' (1 as int).indexOf() }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(1);
		assertEquals("java.lang.String.indexOf(int)", call.getFeature().getIdentifier());
		assertEquals("local", ((XFeatureCall)call.getImplicitReceiver()).getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_Bug351827_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1()\n" +
				"  }\n" +
				"  def setProp1(String s) { s }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_Bug351827_02() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1\n" +
				"  }\n" +
				"  def setProp1(String s) { s }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_Bug351827_03() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def foo(String s) {\n" +
				"    s.setProp1\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(1);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("testdata.Properties1.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_Bug351827_04() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  extension testdata.Properties1 p\n" +
				"  def setProp1(String s) { s }" +
				"  def foo(String s) {\n" +
				"    s.setProp1()\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(2);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.setProp1(java.lang.String)", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  def foo() {\n" + 
				"    var java.util.List<? extends String> list = null;\n" + 
				"    list.map(e|e.toUpperCase)\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(1);
		assertEquals("org.eclipse.xtext.xbase.lib.ListExtensions.map(java.util.List,org.eclipse.xtext.xbase.lib.Functions$Function1)", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_02() throws Exception {
		XtendClass clazz = clazz("" +
				"class Foo {" +
				"  def doSomething() {\n" + 
				"    new Object().doSomething\n" +
				"  }\n" +
				"  def doSomething(Object o) {}" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("Foo.doSomething(java.lang.Object)", call.getFeature().getIdentifier());
		assertNull(call.getInvalidFeatureIssueCode(), call.getInvalidFeatureIssueCode());
	}
	
	@Test public void testExtensionMethodCall_03() throws Exception {
		XtendClass clazz = clazz("" +
				"abstract class MyIterable implements Iterable<String> {" +
				"  def doSomething() {\n" + 
				"    filter [ s.toUpperCase != null ]\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XFeatureCall call = (XFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.filter(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", call.getFeature().getIdentifier());
		assertNull(call.getInvalidFeatureIssueCode(), call.getInvalidFeatureIssueCode());
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		assertEquals("Iterable<String>", operation.getReturnType().getSimpleName());
	}
	
	@Test public void testExtensionMethodCall_04() throws Exception {
		XtendClass clazz = clazz("" +
				"abstract class MyIterable implements Iterable<String> {" +
				"  def doSomething() {\n" + 
				"    this.filter [ s.toUpperCase != null ]\n" +
				"  }\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		final XAbstractFeatureCall call = (XAbstractFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.filter(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", call.getFeature().getIdentifier());
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		assertEquals("Iterable<String>", operation.getReturnType().getSimpleName());
	}
	
	@Test public void testExtensionMethodCall_05() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    ''.m\n" +
				"  }\n" +
				"  def void m(String... s) {" +
				"  }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertFalse(call.getFeature().getIdentifier(), call.getFeature().eIsProxy());
		assertEquals("C.m(java.lang.String[])", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_06() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    ''.m('')\n" +
				"  }\n" +
				"  def void m(String... s) {" +
				"  }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertFalse(call.getFeature().getIdentifier(), call.getFeature().eIsProxy());
		assertEquals("C.m(java.lang.String[])", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_07() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    (null as String[]).m\n" +
				"  }\n" +
				"  def void m(String[] s) {" +
				"  }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertFalse(call.getFeature().eIsProxy());
		assertEquals("C.m(java.lang.String[])", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_08() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    (null as String[]).m\n" +
				"  }\n" +
				"  def void m(String... s) {}\n" +
				"  def void m(String s) {}\n" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertFalse(call.getFeature().eIsProxy());
		assertEquals("C.m(java.lang.String[])", call.getFeature().getIdentifier());
	}

	@Test public void testExtensionMethodCall_09() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    (null as String[]).m\n" +
				"  }\n" +
				"  def void m(String... s) {" +
				"  }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall)((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertFalse(call.getFeature().eIsProxy());
		assertEquals("C.m(java.lang.String[])", call.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionMethodCall_10() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m() {\n" + 
				"    ''.m('', '', '')\n" +
				"    ''.m\n" +
				"    this.m('')\n" +
				"  }\n" +
				"  def void m(String s, String... s2) {" +
				"  }" +
				"}");
		XtendFunction func = (XtendFunction) clazz.getMembers().get(0);
		XBlockExpression block = (XBlockExpression) func.getExpression();
		for(XExpression element: block.getExpressions()) {
			XMemberFeatureCall call = (XMemberFeatureCall) element;
			assertFalse(call.getFeature().eIsProxy());
			assertEquals("C.m(java.lang.String,java.lang.String[])", call.getFeature().getIdentifier());
		}
	}
	
	@Test public void testInstanceOverExtension_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def get(java.util.Map<String, String> map, String s) {\n" + 
				"    map.get(s)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("java.util.Map.get(java.lang.Object)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testInstanceOverExtension_02() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def put(java.util.Map<String, String> map, String s1, String s2) {\n" + 
				"    map.put(s1, s2)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("java.util.Map.put(K,V)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testInstanceOverExtension_03() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def put(java.util.Map<Integer, Integer> map, int i, int j) {\n" + 
				"    map.put(i, j)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("java.util.Map.put(K,V)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testInstanceOverExtension_04() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m(java.util.List<String> list) {\n" + 
				"    list.get(0)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("java.util.List.get(int)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionOverDemandConversion_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def m(Object[] array) {\n" + 
				"    array.get(0)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("org.eclipse.xtext.xbase.lib.ArrayExtensions.get(T[],int)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testInstanceExtensionOverStaticConversion_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def void get(Object[] array, int i) {}\n" +
				"  def m(Object[] array) {\n" + 
				"    array.get(0)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("C.get(java.lang.Object[],int)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testInstanceOverExtensionIfReceiverMismatch_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def put(java.util.Map<String, String> map, Integer i, Integer j) {\n" + 
				"    (null as java.util.Map<String, CharSequence>).put(i, j)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("java.util.Map.put(K,V)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testExtensionOverInstanceIfIncompatible_01() throws Exception {
		XtendClass clazz = clazz("" +
				"class C {" +
				"  def put(java.util.Map<String, String> map, Integer i, Integer j) {\n" + 
				"    map.put(i, j)\n" +
				"  }\n" +
				"}");
		XAbstractFeatureCall substring = findSingleFeatureCall(clazz);
		assertEquals("C.put(java.util.Map,java.lang.Integer,java.lang.Integer)", substring.getFeature().getIdentifier());
	}
	
	@Test public void testCaseFunction_00() throws Exception {
		XtendFunction function = function("def dispatch String foo(String s) {_foo(s)}");
		final XBlockExpression block = (XBlockExpression) function.getExpression();
		final JvmOperation feature = (JvmOperation) ((XAbstractFeatureCall)block.getExpressions().get(0)).getFeature();
		XtendFunction xtendFunction = (XtendFunction) associator.getSourceElements(feature).iterator().next();
		assertSame(function,xtendFunction);
	}
	
	@Test public void testTypeReference_withImport() throws Exception {
		XtendFunction func = (XtendFunction) clazz("import java.lang.* class X { def (String)=>Boolean foo() {[|true]} }").getMembers().get(0);
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
		JvmTypeReference paramType = type.getParamTypes().get(0);
		assertEquals("java.lang.String", paramType.getIdentifier());
	}
	
	@Test public void testTypeReference_0() throws Exception {
		XtendFunction func = function("def =>java.lang.Boolean foo() {[|true]}");
		XFunctionTypeRef type = (XFunctionTypeRef) func.getReturnType();
		JvmTypeReference returnType = type.getReturnType();
		assertEquals("java.lang.Boolean", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference() throws Exception {
		XtendFunction func = function("def <X> X foo(X x) {x}");
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("X", typeParamDecl.getIdentifier());
		assertEquals("X", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	@Test public void testTypeParameterReference_0() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("import java.lang.* class X { def <String> String foo(String x) {x}}").getXtendTypes().get(0)).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertEquals(typeParamDecl,paramType.getType());
	}
	
	@Test public void testTypeParameterReference_1() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("import java.lang.* class X { def <String> String foo(java.lang.String x) {x}}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("String", typeParamDecl.getIdentifier());
		assertEquals("String", typeParamDecl.getName());
		
		JvmTypeReference paramType = func.getParameters().get(0).getParameterType();
		assertNotSame(typeParamDecl,paramType.getType());
	}
	
	@Test public void testTypeParameterReference_2() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Y> { def foo(Y y) { return y }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("Y", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("Y", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_3() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Y> { def foo(Iterable<Y> ys) { return newArrayList(ys.head) }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.util.ArrayList<Y>", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("java.lang.Iterable<Y>", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_4() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X { def <Y> foo(Y y) { return y }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("Y", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("Y", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_5() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X { def <Y> foo(Iterable<Y> ys) { return newArrayList(ys.head) }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.util.ArrayList<Y>", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("java.lang.Iterable<Y>", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_6() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { val result = new X return result }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<java.lang.Object>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_7() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { return new X<String> }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<java.lang.String>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_8() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { return new X<Z> }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<Z>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_9() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Y> { def foo(Iterable<Y> iter) { for(y: iter) { return y } }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("Y", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("java.lang.Iterable<Y>", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_10() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Y> { def foo(Iterable<Y> iter) { for(y: iter) { return y } null }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("Y", returnType.getIdentifier());
		
		JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
		assertEquals("java.lang.Iterable<Y>", paramType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_11() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> implements Iterable<Z> { def Iterable<Z> foo() { val result = new X result }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.lang.Iterable<Z>", returnType.getIdentifier());
		LightweightTypeReference bodyType = getType(func.getExpression());
		assertEquals("X<Z>", bodyType.getIdentifier());
		LightweightTypeReference bodyReturnType = getReturnType(func.getExpression());
		assertEquals("X<Z>", bodyReturnType.getIdentifier());
	}
	
	protected LightweightTypeReference getReturnType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getReturnType(expression);
	}

	protected LightweightTypeReference getType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}
	
	protected LightweightTypeReference getType(JvmIdentifiableElement identifiable) {
		return typeResolver.resolveTypes(identifiable).getActualType(identifiable);
	}

	@Test public void testTypeParameterReference_12() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> implements Iterable<Z> { def Iterable<String> foo() { val result = new X return result }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.lang.Iterable<java.lang.String>", returnType.getIdentifier());
		LightweightTypeReference bodyType = getType(func.getExpression());
		assertEquals("void", bodyType.getIdentifier());
		LightweightTypeReference bodyReturnType = getReturnType(func.getExpression());
		assertEquals("X<java.lang.String>", bodyReturnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_13() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> implements Iterable<Z> { def <Y> Iterable<Y> foo() { val r = new X return r }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.lang.Iterable<Y>", returnType.getIdentifier());
		LightweightTypeReference bodyType = getType(func.getExpression());
		assertEquals("void", bodyType.getIdentifier());
		LightweightTypeReference bodyReturnType = getReturnType(func.getExpression());
		assertEquals("X<Y>", bodyReturnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_14() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def <Y> foo() { new X<Y> }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<Y>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_15() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> implements Iterable<Z> { def Iterable<String> foo() { val result = new X result }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.lang.Iterable<java.lang.String>", returnType.getIdentifier());
		LightweightTypeReference bodyType = getType(func.getExpression());
		assertEquals("X<java.lang.String>", bodyType.getIdentifier());
		LightweightTypeReference bodyReturnType = getReturnType(func.getExpression());
		assertEquals("X<java.lang.String>", bodyReturnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_16() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> implements Iterable<Z> { def <Y> Iterable<Y> foo() { val r = new X r }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("java.lang.Iterable<Y>", returnType.getIdentifier());
		LightweightTypeReference bodyType = getType(func.getExpression());
		assertEquals("X<Y>", bodyType.getIdentifier());
		LightweightTypeReference bodyReturnType = getReturnType(func.getExpression());
		assertEquals("X<Y>", bodyReturnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_17() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { val result = new X result }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<java.lang.Object>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_18() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { new X }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<java.lang.Object>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterReference_19() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def foo() { return new X }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<java.lang.Object>", returnType.getIdentifier());
	}
	

	@Test public void testTypeParameterReference_20() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass)file("class X<Z> { def <Y> foo() { return new X<Y> }}")
				.getXtendTypes().get(0)).getMembers().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		JvmTypeReference returnType = operation.getReturnType();
		assertEquals("X<Y>", returnType.getIdentifier());
	}
	
	@Test public void testTypeParameterShadowsType_1() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass) file("class A {} class B { def <A> A foo(A x) {x}}")
				.getXtendTypes().get(1)).getMembers().get(0);
		
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("A", typeParamDecl.getIdentifier());
		
		JvmTypeParameter param = (JvmTypeParameter) func.getParameters().get(0).getParameterType().getType();
		assertSame(typeParamDecl, param);
	}
	
	@Test public void testTypeParameterShadowsType_2() throws Exception {
		XtendFunction func = (XtendFunction) ((XtendClass) file("class A {} class B<A>  { def A foo(A x) {x}}")
				.getXtendTypes().get(1)).getMembers().get(0);
		
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("A", typeParamDecl.getIdentifier());
		
		JvmTypeParameter param = (JvmTypeParameter) func.getParameters().get(0).getParameterType().getType();
		assertSame(typeParamDecl, param);
	}
	
	@Test public void testTypeParameterShadowsType_3() throws Exception {
		final XtendFile file = file("class A {} class B extends A  { def <A> A foo(A x) {x}}");
		final XtendClass xtendClass = ((XtendClass) file.getXtendTypes().get(1));
		
		final JvmType extendedType = xtendClass.getExtends().getType();
		assertTrue(extendedType instanceof JvmGenericType);
		
		XtendFunction func = (XtendFunction) xtendClass.getMembers().get(0);
		
		JvmTypeReference returnType = func.getReturnType();
		JvmTypeParameter typeParamDecl = (JvmTypeParameter) returnType.getType();
		assertEquals("A", typeParamDecl.getIdentifier());
		
		JvmTypeParameter param = (JvmTypeParameter) func.getParameters().get(0).getParameterType().getType();
		assertSame(typeParamDecl, param);
		assertNotSame(extendedType, param);
	}
	
	@Test public void testTypeParameterShadowsType_4() throws Exception {
		final XtendFile file = file("class B<A>  { def A foo(A x) {x} def <A> A foo(A x) {x}}");
		final XtendClass xtendClass = ((XtendClass) file.getXtendTypes().get(0));
		
		XtendFunction func1 = (XtendFunction) xtendClass.getMembers().get(0);
		
		
		XtendFunction func2 = (XtendFunction) xtendClass.getMembers().get(1);
		
		JvmTypeParameter classTypeParam = (JvmTypeParameter) func1.getReturnType().getType();
		assertTrue(classTypeParam.getDeclarator() instanceof JvmGenericType);
		assertSame(classTypeParam, func1.getParameters().get(0).getParameterType().getType());
		
		JvmTypeParameter funcTypeParam = (JvmTypeParameter) func2.getReturnType().getType();
		assertTrue(funcTypeParam.getDeclarator() instanceof JvmOperation);
		assertSame(funcTypeParam, func2.getParameters().get(0).getParameterType().getType());
	}
	
	@Test public void testFeatureScope_1() throws Exception {
		XtendFile file = file ("class X { def String foo() {'hello world'} def String bar(String foo) {foo}}");
		XtendClass xClass = ((XtendClass) file.getXtendTypes().get(0));
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(1);
		final XBlockExpression expression = (XBlockExpression) func.getExpression();
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) expression.getExpressions().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(func);
		assertEquals(operation.getParameters().get(0), featureCall1.getFeature());
	}
	
	@Test public void testFeatureScope_3() throws Exception {
		XtendFile file = file ("import java.lang.String class X { def String foo(String foo) {[String foo|foo]}}");
		XtendClass xClass = ((XtendClass) file.getXtendTypes().get(0));
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XClosure closure = (XClosure) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		XAbstractFeatureCall featureCall1 = (XAbstractFeatureCall) (((XBlockExpression)closure.getExpression()).getExpressions().get(0));
		assertEquals(closure.getFormalParameters().get(0), featureCall1.getFeature());
	}
	
	@Test public void testOverloadedMethods_01() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(chars, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_02() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_03() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(strings, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_04() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded(objects, objects)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethodsJava_01() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		assertEquals("overloaded(Collection,Iterable)", new OverloadedMethods<Object>().overloaded(chars, strings));
		assertEquals("overloaded(Iterable,Collection)", new OverloadedMethods<Object>().overloaded(strings, chars));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(strings, strings));
		assertEquals("overloaded(List,List)", new OverloadedMethods<Object>().overloaded(chars, chars));
		assertEquals("overloaded(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded(objects, objects));
	}
	
	@Test public void testOverloadedMethods_05() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(chars, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.Collection,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_06() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<CharSequence> chars = null\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<CharSequence> receiver = null\n" +
				"    receiver.overloaded2(strings, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(3);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.util.Collection)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_07() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<String> strings = null\n" +
				"    var testdata.OverloadedMethods<String> receiver = null\n" +
				"    receiver.overloaded2(strings, strings)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.util.List,java.util.List)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_08() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends Object> objects = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(objects, objects)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_09() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var List<? extends CharSequence> chars = null\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloaded2(chars, chars)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloaded2(java.lang.Iterable,java.lang.Iterable)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethodsJava_02() throws Exception {
		List<CharSequence> chars = null;
		List<String> strings = null;
		List<? extends Object> objects = null;
		List<? extends CharSequence> chars2 = null;
		assertEquals("overloaded2(Collection,Iterable)", new OverloadedMethods<CharSequence>().overloaded2(chars, strings));
		assertEquals("overloaded2(Iterable,Collection)", new OverloadedMethods<CharSequence>().overloaded2(strings, chars));
		assertEquals("overloaded2(List,List)", new OverloadedMethods<String>().overloaded2(strings, strings));
		assertEquals("overloaded2(List,List)", new OverloadedMethods<CharSequence>().overloaded2(chars, chars));
		assertEquals("overloaded2(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded2(objects, objects));
		assertEquals("overloaded2(Iterable,Iterable)", new OverloadedMethods<Object>().overloaded2(chars2, chars2));
	}
	
	@Test public void testOverloadedMethods_10() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var int i = 0\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloadedInt(i)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(int)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_11() throws Exception {
		XtendFile file = file(
				"import java.util.List\n" +
				"class X {\n" +
				"  def foo() {\n" +
				"    var Integer i = 0\n" +
				"    var testdata.OverloadedMethods<Object> receiver = null\n" +
				"    receiver.overloadedInt(i)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(2);
		JvmIdentifiableElement overloaded = featureCall.getFeature();
		assertNotNull(overloaded);
		assertFalse(overloaded.eIsProxy());
		assertEquals("testdata.OverloadedMethods.overloadedInt(java.lang.Integer)", overloaded.getIdentifier());
	}
	
	@Test public void testOverloadedMethodsJava_03() throws Exception {
		int i = 0;
		Integer integer = null;
		assertEquals("overloadedInt(int)", new OverloadedMethods<Object>().overloadedInt(i));
		assertEquals("overloadedInt(Integer)", new OverloadedMethods<Object>().overloadedInt(integer));
	}
	
	@Test public void testOverloadedMethods_12() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Collection<T> elements) {\n" +
				"    collection.addAll(elements)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("java.util.Collection.addAll(java.util.Collection)", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_13() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Iterable<T> elements) {\n" +
				"    collection.addAll(elements)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,java.lang.Iterable)", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_14() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Iterable<? extends T> elements) {\n" +
				"    collection.addAll(elements)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,java.lang.Iterable)", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_15() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<T> collection, Iterable<? extends T> elements) {\n" +
				"    collection.addAll(elements)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,java.lang.Iterable)", addAll.getIdentifier());
	}
	

	@Test public void testOverloadedMethods_16() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Iterable<T> elements) {\n" +
				"    collection.addAll(elements.head)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_17() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Iterable<? extends T> elements) {\n" +
				"    collection.addAll(elements.head)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_18() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<T> collection, Iterable<? extends T> elements) {\n" +
				"    collection.addAll(elements.head)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_19() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<? super T> collection, Iterable<? extends T> elements) {\n" +
				"    collection.<T>addAll(elements)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_20() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<T> collection, T head) {\n" +
				"    collection.addAll(head)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(0);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testOverloadedMethods_21() throws Exception {
		XtendFile file = file(
				"import java.util.Collection\n" +
				"class X {\n" +
				"  def <T> foo(Collection<T> collection, Iterable<? extends T> elements) {\n" +
				"    val t = elements.head\n" +
				"    collection.addAll(t)\n" +
				"  }\n" +
				"}");
		XtendClass clazz = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) clazz.getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression) func.getExpression()).getExpressions().get(1);
		JvmIdentifiableElement addAll = featureCall.getFeature();
		assertNotNull(addAll);
		assertFalse(addAll.eIsProxy());
		assertEquals("org.eclipse.xtext.xbase.lib.CollectionExtensions.addAll(java.util.Collection,T[])", addAll.getIdentifier());
	}
	
	@Test public void testMemberFeatureScope_0() throws Exception {
		XtendFile file = file ("import java.lang.String class X { def String foo(String foo) {foo.length()}}");
		XtendClass xClass = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction func  = (XtendFunction) xClass.getMembers().get(0);
		XMemberFeatureCall call = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		assertEquals("length", ((JvmOperation)call.getFeature()).getSimpleName());
	}
	
	@Test public void testImplicitPackageImport() throws Exception {
		XtendFile file = file("package java.io class Foo implements Serializable {}");
		List<JvmTypeReference> implementedInterfaces = ((XtendClass) file.getXtendTypes().get(0)).getImplements();
		assertFalse(implementedInterfaces.isEmpty());
		JvmType implementedInterface = implementedInterfaces.get(0).getType();
		assertNotNull(implementedInterface);
		assertEquals("java.io.Serializable", implementedInterface.getIdentifier());
	}
	
	@Test public void testStaticImports_01() throws Exception {
		String fileAsText= "import java.util.Collections.* class Clazz { def void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	@Test public void testStaticImports_02() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() { ''.singletonList() } }";
		XtendFile file = file(fileAsText, false);
		EcoreUtil.resolveAll(file);
		List<Diagnostic> errors = file.eResource().getErrors();
		assertEquals(1, errors.size());
		assertTrue(errors.get(0) instanceof XtextLinkingDiagnostic);
		XtextLinkingDiagnostic diagnostic = (XtextLinkingDiagnostic) errors.get(0);
		assertEquals(fileAsText.indexOf("singletonList"),  diagnostic.getOffset());
	}
	
	@Test public void testStaticImports_03() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() {''.singletonList()} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	@Test public void testStaticImports_04() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() {''.singletonList} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	@Test public void testStaticImports_05() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() {singletonList('')} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	@Test public void testStaticImports_06() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { def void method() {find(singletonList(''), [e|e!=null])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	@Test public void testStaticImports_07() throws Exception {
		String fileAsText= 
				"import static extension com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { def void method() {find(singletonList(''), [e|e!=null])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	@Test public void testStaticImports_08() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { def void method() {singletonList('').findFirst(e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	@Test public void testStaticImports_09() throws Exception {
		String fileAsText= "import static java.util.Collections.* class Clazz { def void method() {singletonList('').findFirst(String e|e!=null)} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.findFirst(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", identifier);
	}
	
	@Test public void testStaticImports_10() throws Exception {
		String fileAsText= "import static extension java.util.Collections.* class Clazz { def void method() { singletonList('')} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.util.Collections.singletonList(T)", identifier);
	}
	
	@Test public void testStaticImports_11() throws Exception {
		String fileAsText= 
				"import static com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { def void method() {find(singletonList(''), [e|e.length!=0])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	@Test public void testStaticImports_12() throws Exception {
		String fileAsText= 
				"import static extension com.google.common.collect.Iterables.*\n" +
				"import static java.util.Collections.*\n" +
				"class Clazz { def void method() { find(singletonList(''), [e|e.length!=0])} }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XFeatureCall featureCall = (XFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("com.google.common.collect.Iterables.find(java.lang.Iterable,com.google.common.base.Predicate)", identifier);
	}
	
	@Test public void testBug343102_01() throws Exception {
		XtendFunction function = function(
				"def <T extends java.lang.Object> test(T t) {\n" + 
				"  t.getClass\n" + 
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	@Test public void testBug343102_02() throws Exception {
		XtendFunction function = function(
				"def <T> test(T t) {\n" + 
				"  t.getClass\n" + 
				"}");
		XMemberFeatureCall featureCall = (XMemberFeatureCall) ((XBlockExpression)function.getExpression()).getExpressions().get(0);
		String identifier = featureCall.getFeature().getIdentifier();
		assertEquals("java.lang.Object.getClass()", identifier);
	}
	
	@Test public void testBug345827_01() throws Exception {
		XtendFunction function = function(
				"def String name() {\n" + 
				"  var name = ''\n" +
				"  name" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		// TODO actually we should prefer the function in case 'explicitOperationCall' is true
		// for a featureCall
		assertSame(block.getExpressions().get(0), featureCall.getFeature());
	}
	
	@Test public void testBug345827_02() throws Exception {
		XtendFunction function = function(
				"def String name() {\n" + 
				"  var name = ''\n" +
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	@Test public void testBug345827_03() throws Exception {
		XtendFunction function = function(
				"def String name(String param) {\n" + 
				"  var name = ''\n" +
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	@Test public void testBug345827_04() throws Exception {
		XtendFunction function = function(
				"def String name(String param) {\n" + 
				"  var name = ''\n" +
				"  name('param')" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(1);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	@Test public void testBug345827_05() throws Exception {
		XtendFunction function = function(
				"def String name(String name) {\n" + 
				"  name()" + 
				"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		JvmOperation operation = associator.getDirectlyInferredOperation(function);
		assertSame(operation, featureCall.getFeature());
	}
	
	@Test public void testBug345827_06() throws Exception {
		XtendFunction function = function("def String name(String param) {\n" + 
				"  name('param')" + 
		"}");
		XBlockExpression block = (XBlockExpression) function.getExpression();
		XFeatureCall featureCall = (XFeatureCall) block.getExpressions().get(0);
		assertSame(associator.getDirectlyInferredOperation(function), featureCall.getFeature());
	}
	
	@Test public void testBug345433_01() throws Exception {
		String classAsString = 
			"import static extension org.eclipse.xtext.GrammarUtil.*\n" +
			"class Foo {" +
			"	org.eclipse.xtext.Grammar grammar\n" +
			"	def function1() {\n" + 
			"		grammar.containedRuleCalls.filter(e | " +
			"			!e.isAssigned() && !e.isEObjectRuleCall()" +
			"		).map(e | e.rule)\n" + 
			"	}\n" +
			"	def function2() {\n" +
			"		newArrayList(function1().head())\n" +
			"	}\n" +
			"}";
		XtendClass clazz = clazz(classAsString);
		IResourceValidator validator = ((XtextResource) clazz.eResource()).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(clazz.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
		assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		XtendFunction function1 = (XtendFunction) clazz.getMembers().get(1);
		JvmOperation operation1 = associator.getDirectlyInferredOperation(function1);
		assertEquals("java.lang.Iterable<org.eclipse.xtext.AbstractRule>", operation1.getReturnType().getIdentifier());
		XtendFunction function2 = (XtendFunction) clazz.getMembers().get(2);
		JvmOperation operation2 = associator.getDirectlyInferredOperation(function2);
		assertEquals("java.util.ArrayList<org.eclipse.xtext.AbstractRule>", operation2.getReturnType().getIdentifier());
	}
	
	@Test public void testBug345433_02() throws Exception {
		String classAsString = 
			"import static extension org.eclipse.xtext.GrammarUtil.*\n" +
			"class Foo {" +
			"	org.eclipse.xtext.Grammar grammar\n" +
			"	def function1() {\n" + 
			"		grammar.containedRuleCalls.filter(e0 | " +
			"			!e0.isAssigned() && !e0.isEObjectRuleCall()" +
			"		).map(e1 | e1.rule)\n" + 
			"	}\n" +
			"}";
		XtendClass clazz = clazz(classAsString);
		IResourceValidator validator = ((XtextResource) clazz.eResource()).getResourceServiceProvider().getResourceValidator();
		List<Issue> issues = validator.validate(clazz.eResource(), CheckMode.ALL, CancelIndicator.NullImpl);
		assertTrue("Resource contained errors : " + issues.toString(), issues.isEmpty());
		XtendFunction function = (XtendFunction) clazz.getMembers().get(1);
		XExpression body = function.getExpression();
		LightweightTypeReference bodyType = getType(body);
		assertEquals("java.lang.Iterable<org.eclipse.xtext.AbstractRule>", bodyType.getIdentifier());
		XBlockExpression block = (XBlockExpression) body;
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(0);
		XClosure closure = (XClosure) featureCall.getMemberCallArguments().get(0);
		JvmFormalParameter e1 = closure.getFormalParameters().get(0);
		assertEquals("e1", e1.getSimpleName());
		assertEquals("org.eclipse.xtext.RuleCall", getType(e1).getIdentifier());
	}
	
	@Test public void testBug342848_01() throws Exception {
		String fileAsText= 
				"import org.eclipse.xtext.xbase.lib.Functions\n" +
				"class Clazz { def void method(Functions$Function0<Integer> f) { f.apply } }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XtendParameter parameter = function.getParameters().get(0);
		String identifier = parameter.getParameterType().getIdentifier();
		assertEquals(Functions.Function0.class.getName()+ "<java.lang.Integer>", identifier);
	}
	
	@Test public void testBug342848_02() throws Exception {
		String fileAsText= 
				"import org.eclipse.xtext.xbase.lib.Functions\n" +
				"class Clazz { def void method(Functions.Function0<Integer> f) { f.apply } }";
		XtendFile file = file(fileAsText, true);
		XtendFunction function = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		XtendParameter parameter = function.getParameters().get(0);
		String identifier = parameter.getParameterType().getIdentifier();
		assertEquals(Functions.Function0.class.getName()+ "<java.lang.Integer>", identifier);
	}
	
	@Test public void testRelativeImports() throws Exception {
		XtendFile file = file (
				"package annotation class X {\n" +
				"  Annotation failed\n" +
				"  java.lang.annotation.Annotation success\n" +
				"  reflect.AccessibleObject failedToo\n" +
				"  Thread.State anotherSuccess\n" +
				"  Thread$State thirdSuccess\n" +
				"}");
		XtendClass xClass = (XtendClass) file.getXtendTypes().get(0);
		XtendField failed  = (XtendField) xClass.getMembers().get(0);
		assertTrue("Annotation", failed.getType().getType().eIsProxy());
		XtendField success  = (XtendField) xClass.getMembers().get(1);
		assertFalse("java.lang.annotation", success.getType().getType().eIsProxy());
		XtendField failedToo  = (XtendField) xClass.getMembers().get(2);
		assertTrue("reflect.AccessibleObject", failedToo.getType().getType().eIsProxy());
		XtendField anotherSuccess  = (XtendField) xClass.getMembers().get(3);
		assertFalse("Thread.State", anotherSuccess.getType().getType().eIsProxy());
		XtendField thirdSuccess  = (XtendField) xClass.getMembers().get(4);
		assertFalse("Thread$State", thirdSuccess.getType().getType().eIsProxy());
	}
	
	@Test public void testImplicitFirstArgument_00() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
				"  def prependHello(String myString) {\n" + 
				"    'Hello '+myString\n" + 
				"  }\n" + 
				"  def testExtensionMethods(String it) {\n" + 
				"    it.prependHello\n" + 
				"    prependHello\n" + 
				"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XMemberFeatureCall first = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertEquals("MyXtendClass", firstReceiver.getFeature().getSimpleName());
		XFeatureCall second = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(1);
		JvmOperation secondFeature = (JvmOperation) second.getFeature();
		assertEquals("prependHello", secondFeature.getSimpleName());
		assertNull(second.getInvalidFeatureIssueCode(), second.getInvalidFeatureIssueCode());
		assertFalse(secondFeature.eIsProxy());
		XFeatureCall secondReceiver = (XFeatureCall) second.getImplicitReceiver();
		assertEquals("MyXtendClass", secondReceiver.getFeature().getSimpleName());
		XFeatureCall implicitArgument = (XFeatureCall) second.getImplicitFirstArgument();
		assertNotNull(implicitArgument);
		assertEquals("it", implicitArgument.getFeature().getSimpleName());
	}
	
	@Test public void testImplicitFirstArgument_00_a() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
				"  def prependHello(String myString) {\n" + 
				"    'Hello '+myString\n" + 
				"  }\n" + 
				"  def testExtensionMethods(String it) {\n" + 
				"    it.prependHello\n" + 
				"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XMemberFeatureCall first = (XMemberFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertEquals("MyXtendClass", firstReceiver.getFeature().getSimpleName());
	}
	
	@Test public void testImplicitFirstArgument_00_b() throws Exception {
		XtendClass clazz = clazz(
				"class MyXtendClass {\n" + 
						"  def prependHello(String myString) {\n" + 
						"  }\n" + 
						"  def testExtensionMethods(String it) {\n" + 
						"    prependHello\n" + 
						"  }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(1);
		XFeatureCall first = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("prependHello", firstFeature.getSimpleName());
		assertNull(first.getInvalidFeatureIssueCode(), first.getInvalidFeatureIssueCode());
		assertNotNull(first.getImplicitFirstArgument());
	}
	
	@Test public void testImplicitFirstArgument_01() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    length\n" +
				"  }\n" +
				"  extension String" +
				"  def length() { null }\n" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall first = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation firstFeature = (JvmOperation) first.getFeature();
		assertEquals("java.lang.CharSequence.length()", firstFeature.getIdentifier());
		assertEquals("java.lang.CharSequence", firstFeature.getDeclaringType().getQualifiedName());
		assertNull(first.getImplicitFirstArgument());
		XFeatureCall firstReceiver = (XFeatureCall) first.getImplicitReceiver();
		assertTrue(firstReceiver.getFeature() instanceof JvmFormalParameter);
		assertNull(first.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_02() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    toUpperCase\n" +
				"  }\n" +
				"  extension String" +
				"  def toUpperCase() { null }\n" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall second = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation secondFeature = (JvmOperation) second.getFeature();
		assertEquals("MyXtendClass.toUpperCase()", secondFeature.getIdentifier());
		assertEquals(0, secondFeature.getParameters().size());
		assertNull(second.getImplicitFirstArgument());
		XFeatureCall secondReceiver = (XFeatureCall) second.getImplicitReceiver();
		assertTrue(secondReceiver.getFeature() instanceof JvmGenericType);
		assertNull(second.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_03() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    toLowerCase\n" + 
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall third = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation thirdFeature = (JvmOperation) third.getFeature();
		assertEquals("java.lang.String.toLowerCase()", thirdFeature.getIdentifier());
		assertNull(third.getImplicitFirstArgument());
		XMemberFeatureCall thirdReceiver = (XMemberFeatureCall) third.getImplicitReceiver();
		assertTrue(thirdReceiver.getFeature() instanceof JvmField);
		assertNull(third.getInvalidFeatureIssueCode(), third.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_04() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    unique" +
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall forth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation forthFeature = (JvmOperation) forth.getFeature();
		assertEquals("test.ImplicitFirstArgumentStatics.unique()", forthFeature.getIdentifier());
		assertNull(forth.getImplicitFirstArgument());
		assertNull(forth.getImplicitReceiver());
		assertNull(forth.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_05() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    withObject\n" + 
				"  }\n" +
				"  extension String" +
				"  def withObject(Object obj) { null }" + 
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall fifth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation fifthFeature = (JvmOperation) fifth.getFeature();
		assertEquals("MyXtendClass.withObject(java.lang.Object)", fifthFeature.getIdentifier());
		assertEquals(1, fifthFeature.getParameters().size());
		assertNotNull(fifth.getImplicitFirstArgument());
		assertEquals("it", ((XAbstractFeatureCall) fifth.getImplicitFirstArgument()).getFeature().getSimpleName());
		XFeatureCall fifthReceiver = (XFeatureCall) fifth.getImplicitReceiver();
		assertTrue(fifthReceiver.getFeature() instanceof JvmGenericType);
		assertNull(fifth.getInvalidFeatureIssueCode(), fifth.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_06() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    contains\n" + 
				"  }\n" +
				"  extension String" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall sixth = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation sixthFeature = (JvmOperation) sixth.getFeature();
		assertEquals("java.lang.String.contains(java.lang.CharSequence)", sixthFeature.getIdentifier());
		assertEquals("java.lang.String", sixthFeature.getDeclaringType().getQualifiedName());
		assertNotNull(sixth.getImplicitFirstArgument());
		assertEquals("it", ((XAbstractFeatureCall) sixth.getImplicitFirstArgument()).getFeature().getSimpleName());
		XMemberFeatureCall sixthReceiver = (XMemberFeatureCall) sixth.getImplicitReceiver();
		assertTrue(sixthReceiver.getFeature() instanceof JvmField);
		assertNull(sixth.getInvalidFeatureIssueCode(), sixth.getInvalidFeatureIssueCode());
	}
	
	@Test public void testImplicitFirstArgument_07() throws Exception {
		XtendClass clazz = clazz(
				"import static extension test.ImplicitFirstArgumentStatics.*\n" +
				"class MyXtendClass {\n" + 
				"  def testExtensionMethods(CharSequence it) {\n" + 
				"    withCharSequence\n" + 
				"  }\n" +
				"}");
		XtendFunction func= (XtendFunction) clazz.getMembers().get(0);
		
		XFeatureCall seventh = (XFeatureCall) ((XBlockExpression)func.getExpression()).getExpressions().get(0);
		JvmOperation seventhFeature = (JvmOperation) seventh.getFeature();
		assertEquals("test.ImplicitFirstArgumentStatics.withCharSequence(java.lang.CharSequence)", 
				seventhFeature.getIdentifier());
		// static methods don't have receiver but an implicit argument
		assertNotNull(seventh.getImplicitFirstArgument());
		assertNull(seventh.getImplicitReceiver());
		assertNull(seventh.getInvalidFeatureIssueCode(), seventh.getInvalidFeatureIssueCode());
		assertEquals("it", ((XAbstractFeatureCall) seventh.getImplicitFirstArgument()).getFeature().getSimpleName());
	}
	
	@Test public void testTypeOfSuper() throws Exception {
		String classAsString = 
			"class Foo extends java.util.ArrayList<String> {" +
			"	def m() {\n" + 
			"		super.add(null)\n" + 
			"	}\n" +
			"}";
		XtendClass clazz = clazz(classAsString);
		XtendFunction function = (XtendFunction) clazz.getMembers().get(0);
		XExpression body = function.getExpression();
		XBlockExpression block = (XBlockExpression) body;
		XMemberFeatureCall featureCall = (XMemberFeatureCall) block.getExpressions().get(0);
		XFeatureCall superCall = (XFeatureCall) featureCall.getMemberCallTarget();
		LightweightTypeReference type = getType(superCall);
		assertEquals("java.util.ArrayList<java.lang.String>", type.getIdentifier());
	}
	
}
