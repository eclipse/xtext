/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.linking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class InferredJvmModelShadowingJavaLinkingTests extends AbstractXtend2TestCase {

	@Inject
	protected XtextResourceSet resourceSet;
	
	@Inject 
	protected IXtend2JvmAssociations associations;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet.getResources().clear();
		resourceSet.setClasspathURIContext(this);
	}
	public void testLinkJavaClass() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar extends Foo {}");
		assertTrue(isJavaElement(bar.getSuperTypes().get(0).getType()));
	}
	
	public void testLinkInferredJvmClass() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo {}");
		XtendClass bar = classFile("test/Bar", "package test class Bar extends Foo {}");
		assertEquals(associations.getInferredType(foo), bar.getSuperTypes().get(0).getType());
	}
	
	public void testLinkJavaConstructor() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar { bar() {new Foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XConstructorCall constructorCall = (XConstructorCall) ((XBlockExpression)block).getExpressions().get(0);
		assertTrue(isJavaElement(constructorCall.getConstructor()));
	}
	
	public void testLinkInferredJvmConstructor() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo {}");
		XtendClass bar = classFile("test/Bar", "package test class Bar { bar() {new Foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XConstructorCall constructorCall = (XConstructorCall) ((XBlockExpression)block).getExpressions().get(0);
		assertEquals(associations.getInferredConstructor(foo), constructorCall.getConstructor());
	}
	
	public void testLinkJavaMethod() throws Exception {
		XtendClass bar = classFile("test/Bar", "package test class Bar { bar(Foo foo) {foo.foo()} }");
		final XExpression block = ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XMemberFeatureCall methodCall = (XMemberFeatureCall) ((XBlockExpression)block).getExpressions().get(0);
		assertTrue(isJavaElement(methodCall.getFeature()));
	}
	
	public void testLinkInferredJvmOperation() throws Exception {
		XtendClass foo = classFile("test/Foo", "package test class Foo { foo() :this; }");
		XtendClass bar = classFile("test/Bar", "package test class Bar { bar(Foo foo) {foo.foo()} }");
		final XBlockExpression block = (XBlockExpression) ((XtendFunction)bar.getMembers().get(0)).getExpression();
		XMemberFeatureCall methodCall = (XMemberFeatureCall) block.getExpressions().get(0);
		assertEquals(associations.getDirectlyInferredOperation((XtendFunction)foo.getMembers().get(0)), methodCall.getFeature());
	}
	
	protected XtendClass classFile(String fileName, String content) throws Exception {
		Resource resource = resourceSet.createResource(URI.createURI(fileName + ".xtend"));
		resource.load(new StringInputStream(content), null);
		EObject root = resource.getContents().get(0);
		assertTrue(root instanceof XtendFile);
		return ((XtendFile) root).getXtendClass();
	}
	
	protected boolean isJavaElement(EObject element) {
		URI uri = EcoreUtil.getURI(element);
		return "java".equals(uri.scheme());
	}
}
