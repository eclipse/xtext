/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.io.InputStream;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class BasicLazyLinkingTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new LazyLinkingTestLanguageStandaloneSetup());
	}
	
	public void testLazyLinking() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A extends B.id{} type B { A id}"));
		doTest(resource);
	}
	
	private void doTest(XtextResource resource) {
		assertTrue(resource instanceof LazyLinkingResource);
		
		Model model = (Model) resource.getContents().get(0);
		Type typeA = model.getTypes().get(0);
		Type typeB = model.getTypes().get(1);
		
		Property parentId = typeA.getParentId();
		assertEquals(typeB.getProperties().get(0),parentId);
	}

	public void testRecursion() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A extends B.a { B b } type B extends A.b { A a}"));
		
		doTest(resource);
	}
	
	public void testBackwardDependency() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A for a in B { B b } type B for b in A { A a}"));
		
		doTest(resource);
	}
	
	public void testLazyMultiRef() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A {} type B { A B a}"));
		Model m = (Model) resource.getContents().get(0);
		Type t2 = m.getTypes().get(1);
		
		Property property = t2.getProperties().get(0);
		EList<Type> types = property.getType();
		assertTrue(((InternalEObject)((BasicEList<Type>)types).basicGet(0)).eIsProxy());
		assertTrue(((InternalEObject)((BasicEList<Type>)types).basicGet(0)).eIsProxy());
		assertFalse(((InternalEObject)types.get(0)).eIsProxy());
		assertFalse(((InternalEObject)types.get(1)).eIsProxy());
	}
	
	public void testLazyMultiRefDuplicates() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A {} type B { A B A a}"));
		Model m = (Model) resource.getContents().get(0);
		Type t1 = m.getTypes().get(0);
		Type t2 = m.getTypes().get(1);
		
		Property property = t2.getProperties().get(0);
		EList<Type> types = property.getType();
		assertEquals(t1, types.get(0));
		assertEquals(t2, types.get(1));
		assertEquals(t1, types.get(2));
		
		assertEquals(t1, types.get(0));
		assertEquals(t2, types.get(1));
		assertEquals(t1, types.get(2));
	}
	
	public void testBug281775_01() throws Exception {
		String model = "type A {\n" +
				"  A B a;\n" +
				"}\n" +
				"type B {\n" +
				"  B A b;\n" +
				"}";
		XtextResource resource = getResource(new StringInputStream(model));
		Model m = (Model) resource.getContents().get(0);
		Type t1 = m.getTypes().get(0);
		assertEquals("A", t1.getName());
		Type t2 = m.getTypes().get(1);
		assertEquals("B", t2.getName());
		
		Property propA = t1.getProperties().get(0);
		assertEquals(2, propA.getType().size());
		assertEquals(t1, propA.getType().get(0));
		assertEquals(t2, propA.getType().get(1));
		
		Property propB = t2.getProperties().get(0);
		assertEquals(2, propB.getType().size());
		assertEquals(t2, propB.getType().get(0));
		assertEquals(t1, propB.getType().get(1));
	}
	
	public void testBug281775_02() throws Exception {
		String model = "type A {\n" +
				"  unresolved A B a;\n" +
				"}\n" +
				"type B {\n" +
				"  unresolved B A b;\n" +
				"}";
		XtextResource resource = getResource(new StringInputStream(model));
		Model m = (Model) resource.getContents().get(0);
		Type t1 = m.getTypes().get(0);
		assertEquals("A", t1.getName());
		Type t2 = m.getTypes().get(1);
		assertEquals("B", t2.getName());
		
		UnresolvedProxyProperty propA = t1.getUnresolvedProxyProperty().get(0);
		assertEquals(2, propA.getType().size());
		assertEquals(t1, propA.getType().get(0));
		assertEquals(t2, propA.getType().get(1));
		
		UnresolvedProxyProperty propB = t2.getUnresolvedProxyProperty().get(0);
		assertEquals(2, propB.getType().size());
		assertEquals(t2, propB.getType().get(0));
		assertEquals(t1, propB.getType().get(1));
	}

	
	@Override
	public XtextResource getResource(InputStream in) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(URI.createURI("mytestmodel.test"));
		rs.getResources().add(resource);
		resource.load(in, null);
		return resource;
	}
}
