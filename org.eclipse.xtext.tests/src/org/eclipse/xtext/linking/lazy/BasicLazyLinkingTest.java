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
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.linking.lazy.lazyLinking.LazyLinkingPackage;
import org.eclipse.xtext.linking.lazy.lazyLinking.Model;
import org.eclipse.xtext.linking.lazy.lazyLinking.Property;
import org.eclipse.xtext.linking.lazy.lazyLinking.Type;
import org.eclipse.xtext.linking.lazy.lazyLinking.UnresolvedProxyProperty;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class BasicLazyLinkingTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		return false;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LazyLinkingTestLanguageStandaloneSetup());
	}
	
	@Test public void testLazyLinking() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A extends B.id{} type B { A id; }"));
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

	@Test public void testRecursion() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A extends B.a { B b; } type B extends A.b { A a; }"));
		doTest(resource);
	}
	
	@Test public void testBackwardDependency() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A for a in B { B b; } type B for b in A { A a; }"));
		doTest(resource);
	}
	
	@Test public void testLazyMultiRef() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A {} type B { A B a; }"));
		Model m = (Model) resource.getContents().get(0);
		Type t2 = m.getTypes().get(1);
		
		Property property = t2.getProperties().get(0);
		EList<Type> types = property.getType();
		assertTrue(((InternalEObject)((InternalEList<Type>)types).basicGet(0)).eIsProxy());
		assertTrue(((InternalEObject)((InternalEList<Type>)types).basicGet(0)).eIsProxy());
		assertFalse(((InternalEObject)types.get(0)).eIsProxy());
		assertFalse(((InternalEObject)types.get(1)).eIsProxy());
	}
	
	@Test public void testLazyMultiRefDuplicates() throws Exception {
		XtextResource resource = getResource(new StringInputStream("type A {} type B { A B A a; }"));
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
	
	@Test public void testBug281775_01() throws Exception {
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
	
	@Test public void testBug281775_02() throws Exception {
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

	
    // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=282486
	// and https://bugs.eclipse.org/bugs/show_bug.cgi?id=303441
    @SuppressWarnings("unchecked")
    @Test public void testReferenceWithOpposite() throws Exception {
        XtextResource resource = getResourceAndExpect(new StringInputStream("type foo {} type bar extends foo {}"), 1);
        Model model = (Model) resource.getContents().get(0);
        Type typeFoo = model.getTypes().get(0);
        Type typeBar = model.getTypes().get(1);
        InternalEObject proxy = (InternalEObject) typeBar.eGet(LazyLinkingPackage.Literals.TYPE__EXTENDS, false);
        assertTrue(proxy.eIsProxy());
		assertEquals(typeFoo, typeBar.getExtends());
        List<Type> fooSubtypes = (List<Type>) typeFoo.eGet(LazyLinkingPackage.Literals.TYPE__SUBTYPES, false);
        // the opposite is not automatically set (see https://bugs.eclipse.org/bugs/show_bug.cgi?id=282486) 
        assertEquals(0, fooSubtypes.size());
    }

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		rs.setClasspathURIContext(getClass());
		XtextResource resource = (XtextResource) getResourceFactory().createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		return resource;
	}
}
