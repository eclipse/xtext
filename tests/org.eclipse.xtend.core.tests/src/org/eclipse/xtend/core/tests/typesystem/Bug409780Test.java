/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug409780Test extends AbstractXtendTestCase {
	
	@Override
	protected XtendFile file(String string) throws Exception {
		return file(string, false);
	}
	
	@Inject
	protected IXtendJvmAssociations associator;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	private LightweightTypeReference getType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}
	private LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	
	@Test public void testMissingTypeArgumentInference() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"	def private <T extends Appendable> Iterable<T> a(Iterable<CharSequence> it) {\n" + 
				"		map[ b ]\n" + 
				"	}\n" + 
				"	def private <T extends Appendable> T b(CharSequence c) {}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
		assertTrue(featureCall.isStatic());
		assertTrue(featureCall.isExtension());
		assertFalse(featureCall.isTypeLiteral());
		LightweightTypeReference type = getType(featureCall);
		assertEquals("java.lang.Iterable<T>", type.getIdentifier());
		LightweightTypeReference expectedType = getExpectedType(featureCall);
		assertEquals("java.lang.Iterable<T>", expectedType.getIdentifier());
	}
	
	@Test public void testConstraintsInfluenceType() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"	def private a(Iterable<CharSequence> it) {\n" + 
				"		map[ b ]\n" + 
				"	}\n" + 
				"	def private <T extends Appendable> T b(CharSequence c) {}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
		assertTrue(featureCall.isStatic());
		assertTrue(featureCall.isExtension());
		assertFalse(featureCall.isTypeLiteral());
		LightweightTypeReference type = getType(featureCall);
		assertEquals("java.lang.Iterable<java.lang.Appendable>", type.getIdentifier());
	}
	
	@Test public void testConstraintsInfluenceFeatureScope() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"	def private a(Iterable<CharSequence> it) {\n" + 
				"		map[ b ].map[ append('') ]\n" + 
				"	}\n" + 
				"	def private <T extends Appendable> T b(CharSequence c) {}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XMemberFeatureCall featureCall = (XMemberFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
		assertTrue(featureCall.isStatic());
		assertTrue(featureCall.isExtension());
		assertFalse(featureCall.isTypeLiteral());
		LightweightTypeReference type = getType(featureCall);
		assertEquals("java.lang.Iterable<java.lang.Appendable>", type.getIdentifier());
	}
	
	@Test public void testConstraintsInfluenceFeatureScope_02() throws Exception {
		XtendFile file = file(
				"class C {\n" + 
				"	def private a(Iterable<CharSequence> it) {\n" + 
				"		map[ b.append('') ]\n" + 
				"	}\n" + 
				"	def private <T extends Appendable> T b(CharSequence c) {}\n" + 
				"}"); 
		XtendClass c = (XtendClass) file.getXtendTypes().get(0);
		XtendFunction m = (XtendFunction) c.getMembers().get(0);
		XBlockExpression body = (XBlockExpression) m.getExpression();
		XFeatureCall featureCall = (XFeatureCall) body.getExpressions().get(0);
		JvmIdentifiableElement method = featureCall.getFeature();
		assertEquals("org.eclipse.xtext.xbase.lib.IterableExtensions.map(java.lang.Iterable,org.eclipse.xtext.xbase.lib.Functions$Function1)", method.getIdentifier());
		assertTrue(featureCall.isStatic());
		assertTrue(featureCall.isExtension());
		assertFalse(featureCall.isTypeLiteral());
		LightweightTypeReference type = getType(featureCall);
		assertEquals("java.lang.Iterable<java.lang.Appendable>", type.getIdentifier());
	}


}
