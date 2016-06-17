/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.LeafNode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Pair;
import org.junit.Test;

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
	public void setUp() throws Exception {
		super.setUp();
		with(new AbstractModule() {
			@Override
			protected void configure() {
				bind(EPackage.Registry.class).toInstance(EPackage.Registry.INSTANCE);
				bind(IGrammarAccess.class).toInstance(new IGrammarAccess() {
					@Override
					public List<Pair<Keyword, Keyword>> findKeywordPairs(String leftKw, String rightKw) {
						return Collections.emptyList();
					}

					@Override
					public List<Keyword> findKeywords(String... keywords) {
						return Collections.emptyList();
					}

					@Override
					public List<RuleCall> findRuleCalls(AbstractRule... rules) {
						return Collections.emptyList();
					}

					@Override
					public Grammar getGrammar() {
						return XtextFactory.eINSTANCE.createGrammar();
					}
				});
			}
		});
		linker = get(LazyLinker.class);
		resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		lazyLinkingPackage = (EPackage) resourceSet.getResource(
				URI.createURI("classpath:/org/eclipse/xtext/linking/lazy/LazyLinking.ecore"), true).getContents().get(0);
	}

	@Override
	public void tearDown() throws Exception {
		lazyLinkingPackage = null;
		linker = null;
		resourceSet = null;
		super.tearDown();
	}

	@Test public void testSingleValuedResolveProxiesReference() throws Exception {
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

		final INode leafNode = newCrossReferenceAssignmentNode(eReference.getName());
		final ICompositeNode adapter = newSimpleNodeAdapter(leafNode);
		foo.eAdapters().add((Adapter) adapter);
		linker.linkModel(foo, new ListBasedDiagnosticConsumer());
		assertEquals(bar, foo.eGet(eReference, false));
	}

	@Test public void testManyValuedResolveProxiesReference() throws Exception {
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

		final INode leafNode = newCrossReferenceAssignmentNode(eReference.getName());
		final INode leafNode2 = newCrossReferenceAssignmentNode(eReference.getName());
		final ICompositeNode adapter = newSimpleNodeAdapter(leafNode, leafNode2);
		foo.eAdapters().add((Adapter) adapter);
		linker.linkModel(foo, new ListBasedDiagnosticConsumer());
		assertEquals(bars, foo.eGet(eReference, false));
	}

	private EObject newEObject(String type) {
		final EClass eClass = (EClass) lazyLinkingPackage.getEClassifier(type);
		return EcoreUtil.create(eClass);
	}

	private INode newCrossReferenceAssignmentNode(final String feature) {
		final LeafNode leafNode = new LeafNode();
		final Assignment assignment = XtextFactory.eINSTANCE.createAssignment();
		assignment.setFeature(feature);
		final CrossReference crossReference = XtextFactory.eINSTANCE.createCrossReference();
		assignment.setTerminal(crossReference);
		leafNode.basicSetGrammarElement(crossReference);
		return leafNode;
	}

	private ICompositeNode newSimpleNodeAdapter(final INode... nodes) {
		NodeModelBuilder builder = new NodeModelBuilder();
		ICompositeNode result = new CompositeNodeWithSemanticElement();
		for(INode node: nodes) {
			builder.addChild(result, (AbstractNode) node);
		}
		return result;
	}

}
