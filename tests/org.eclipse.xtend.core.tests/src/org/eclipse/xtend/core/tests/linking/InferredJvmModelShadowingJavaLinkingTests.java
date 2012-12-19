/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class InferredJvmModelShadowingJavaLinkingTests extends AbstractXtendTestCase {

	@Inject
	protected XtextResourceSet resourceSet;
	
	@Inject 
	protected IXtendJvmAssociations associations;
	
	@Before
	public void setUp() throws Exception {
		resourceSet.getResources().clear();
		resourceSet.setClasspathURIContext(this);
	}
	
	@Test public void testLinkJavaClass() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar extends Foo {}");
		assertTrue(isJavaElement(bar.getExtends().getType()));
	}
	
	@Test public void testLinkInferredJvmClass() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo {}");
		XtendClass bar = classFile("test/Bar", "package test class Bar extends Foo {}");
		assertEquals(associations.getInferredType(foo), bar.getExtends().getType());
	}
	
	@Test public void testLinkJavaConstructor() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar { def bar() {new Foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XConstructorCall constructorCall = (XConstructorCall) ((XBlockExpression)block).getExpressions().get(0);
		assertTrue(isJavaElement(constructorCall.getConstructor()));
	}
	
	@Test public void testLinkInferredJvmConstructor() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo {}");
		XtendClass bar = classFile("test/Bar", "package test class Bar { def bar() {new Foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XConstructorCall constructorCall = (XConstructorCall) ((XBlockExpression)block).getExpressions().get(0);
		assertEquals(associations.getInferredConstructor(foo), constructorCall.getConstructor());
	}
	
	@Test public void testLinkJavaMethod() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar { def bar(Foo foo) {foo.foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XMemberFeatureCall methodCall = (XMemberFeatureCall) ((XBlockExpression)block).getExpressions().get(0);
		assertTrue(isJavaElement(methodCall.getFeature()));
	}
	
	@Test public void testLinkInferredJvmOperation() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo { def foo() { this } }");
		XtendClass bar = classFile("test/Bar", "package test class Bar { def bar(Foo foo) {foo.foo()} }");
		final XBlockExpression block = (XBlockExpression) ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XMemberFeatureCall methodCall = (XMemberFeatureCall) block.getExpressions().get(0);
		assertEquals(associations.getDirectlyInferredOperation((XtendFunction)foo.getMembers().get(0)), methodCall.getFeature());
	}
	
	@Test public void testLinkInferredJvmOperationWithSyntaxError() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo { def foo() :this; }"); // syntax error is intentional
		XtendClass bar = classFile("test/Bar", "package test class Bar { def bar(Foo foo) {foo.foo()} }");
		final XBlockExpression block = (XBlockExpression) ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XMemberFeatureCall methodCall = (XMemberFeatureCall) block.getExpressions().get(0);
		assertEquals(associations.getDirectlyInferredOperation((XtendFunction)foo.getMembers().get(0)), methodCall.getFeature());
	}
	
	protected XtendClass classFile(String fileName, String content) throws Exception {
		Resource resource = resourceSet.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(content), null);
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof XtendFile);
		return (XtendClass) ((XtendFile) root).getXtendTypes().get(0);
	}
	
	protected boolean isJavaElement(EObject element) {
		URI uri = EcoreUtil.getURI(element);
		return "java".equals(uri.scheme());
	}
}
