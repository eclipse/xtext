/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class LazyLinkerTest extends AbstractXtextTests {
	
	private EPackage lazyLinkingPackage;
	private LazyLinker linker;
	private XtextResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new AbstractModule() {
			@Override
			protected void configure() {
				bind(EPackage.Registry.class).toInstance(EPackage.Registry.INSTANCE);
			}
		});
		linker = get(LazyLinker.class);
		resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		lazyLinkingPackage = (EPackage) resourceSet.getResource(
				URI.createURI("classpath:/org/eclipse/xtext/linking/lazy/LazyLinking.ecore"), true).getContents().get(0);
	}

	@Override
	protected void tearDown() throws Exception {
		lazyLinkingPackage = null;
		linker = null;
		resourceSet = null;
		super.tearDown();
	}

	public void testSingleValuedResolveProxiesReference() throws Exception {
		final EObject foo = newEObject("Foo");
		final EObject bar = newEObject("Bar");
		final Resource resource = new ResourceImpl(URI.createURI("http://foo/bar.ecore")) {
			@Override
			public EObject getEObject(String uriFragment) {
				return bar;
			}
		};
		resourceSet.getResources().add(resource);
		resource.getContents().add(foo);

		final EReference eReference = (EReference) foo.eClass().getEStructuralFeature("single");
		assertFalse(eReference.isResolveProxies());

		final AbstractNode leafNode = newCrossReferenceAssignmentNode(eReference.getName());
		final NodeAdapter adapter = newSimpleNodeAdapter(leafNode);
		foo.eAdapters().add(adapter);
		linker.linkModel(foo, new ListBasedDiagnosticConsumer());
		assertEquals(bar, foo.eGet(eReference, false));
	}

	public void testManyValuedResolveProxiesReference() throws Exception {
		final EObject foo = newEObject("Foo");
		final List<EObject> bars = Lists.newArrayList(newEObject("Bar"), newEObject("Bar"));
		final Iterator<EObject> barsIterator = bars.iterator();
		final Resource resource = new ResourceImpl(URI.createURI("http://foo/bar.ecore")) {
			@Override
			public EObject getEObject(String uriFragment) {
				return barsIterator.next();
			}
		};
		resourceSet.getResources().add(resource);
		resource.getContents().add(foo);
		final EReference eReference = (EReference) foo.eClass().getEStructuralFeature("many");
		assertFalse(eReference.isResolveProxies());

		final AbstractNode leafNode = newCrossReferenceAssignmentNode(eReference.getName());
		final AbstractNode leafNode2 = newCrossReferenceAssignmentNode(eReference.getName());
		final NodeAdapter adapter = newSimpleNodeAdapter(leafNode, leafNode2);
		foo.eAdapters().add(adapter);
		linker.linkModel(foo, new ListBasedDiagnosticConsumer());
		assertEquals(bars, foo.eGet(eReference, false));
	}

	private EObject newEObject(String type) {
		final EClass eClass = (EClass) lazyLinkingPackage.getEClassifier(type);
		return EcoreUtil.create(eClass);
	}

	private AbstractNode newCrossReferenceAssignmentNode(final String feature) {
		final LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
		final Assignment assignment = XtextFactory.eINSTANCE.createAssignment();
		assignment.setFeature(feature);
		final CrossReference crossReference = XtextFactory.eINSTANCE.createCrossReference();
		assignment.setTerminal(crossReference);
		leafNode.setGrammarElement(crossReference);
		return leafNode;
	}

	private NodeAdapter newSimpleNodeAdapter(final AbstractNode... nodes) {
		final NodeAdapter adapter = new NodeAdapter();
		final CompositeNode parserNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
		parserNode.getChildren().addAll(Arrays.asList(nodes));
		adapter.setParserNode(parserNode);
		return adapter;
	}

}
