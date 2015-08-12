/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage;
import org.eclipse.xtext.serializer.contextFinderTest.Model;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextFinderTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ContextFinderTestLanguageStandaloneSetup.class);
		getInjector().injectMembers(this);
	}

	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private IContextFinder finder;

	@Inject
	private Context2NameFunction context2name;

	private String findContextsByContents(EObject obj) {
		return contexts2names(finder.findContextsByContents(obj, null));
	}

	private String findContextsByContentsAndContainer(EObject obj) {
		return contexts2names(finder.findContextsByContentsAndContainer(obj, null));
	}

	private String contexts2names(Iterable<EObject> contexts) {
		List<String> result = Lists.newArrayList();
		for (EObject ctx : contexts)
			result.add(context2name.toFunction(getGrammarAccess().getGrammar()).apply(ctx));
		Collections.sort(result);
		return Joiner.on(", ").join(result);
	}

	@Test public void testAttributeExclusionTest1() throws Exception {
		Model model = parseHelper.parse("#1 kw1 bar");
		assertEquals("AttributeExclusionTest1", findContextsByContents(model.getAttributeExclusion()));
	}

	@Test public void testAttributeExclusionTest2() throws Exception {
		Model model = parseHelper.parse("#1 kw2 bar");
		assertEquals("AttributeExclusionTest2", findContextsByContents(model.getAttributeExclusion()));
	}

	@Test public void testNestedTypeTest1() throws Exception {
		Model model = parseHelper.parse("#2 kw1 bar");
		assertEquals("NestedTypeTest1", findContextsByContents(model.getNestedType()));
	}

	@Test public void testNestedTypeTest2() throws Exception {
		Model model = parseHelper.parse("#2 kw2 bar");
		assertEquals("NestedTypeTest2", findContextsByContents(model.getNestedType()));
	}

	@Test public void testNestedTypeRecursiveTest1() throws Exception {
		Model model = parseHelper.parse("#3 kw1 . .");
		assertEquals("NestedTypeRecursiveTest1, NestedTypeRecursiveTest1_NestedTypeRecursiveTest_2_0",
				findContextsByContents(model.getNestedTypeRecursiveTest2()));
	}

	@Test public void testNestedTypeRecursiveTest2() throws Exception {
		Model model = parseHelper.parse("#3 kw2 . .");
		assertEquals("NestedTypeRecursiveTest2, NestedTypeRecursiveTest2_NestedTypeRecursiveTest_2_0",
				findContextsByContents(model.getNestedTypeRecursiveTest2()));
	}

	@Test public void testParentRefTest1() throws Exception {
		Model model = parseHelper.parse("#4 kw1 foo");
		ParentRefTestChild child1 = ((ParentRefTest1) model.getParentRef()).getChild1();
		assertEquals("ParentRefTestChild1", findContextsByContentsAndContainer(child1));
	}

	@Test public void testParentRefTest2() throws Exception {
		Model model = parseHelper.parse("#4 kw2 foo");
		ParentRefTestChild child2 = ((ParentRefTest2) model.getParentRef()).getChild2();
		assertEquals("ParentRefTestChild2", findContextsByContentsAndContainer(child2));
	}

	@Test public void testParentRefTest3() throws Exception {
		Model model = parseHelper.parse("#4 kw1 foo foo foo");
		ParentRefTestChild child1 = ((ParentRefTest1) model.getParentRef()).getChild1().getChild().getChild();
		assertEquals("ParentRefTestChild1", findContextsByContentsAndContainer(child1));
	}

	@Test public void testParentRefTest4() throws Exception {
		Model model = parseHelper.parse("#4 kw2 foo foo foo");
		ParentRefTestChild child2 = ((ParentRefTest2) model.getParentRef()).getChild2().getChild().getChild();
		assertEquals("ParentRefTestChild2", findContextsByContentsAndContainer(child2));
	}

	@Test public void testRootContainer() throws Exception {
		Model model = parseHelper.parse("#0 model #1 kw1 bar");
		assertEquals("Model", findContextsByContentsAndContainer(model));
		assertEquals("Model2", findContextsByContentsAndContainer(model.getModel()));
	}

	@Test public void testQuantityExclusionTest1() throws Exception {
		Model model = parseHelper.parse("#5 kw1 bar");
		assertEquals("QuantityExclusionTest1", findContextsByContents(model.getQuantityExclusion()));
	}

	@Test public void testQuantityExclusionTest2() throws Exception {
		Model model = parseHelper.parse("#5 kw2 bar");
		assertEquals("QuantityExclusionTest2", findContextsByContents(model.getQuantityExclusion()));
	}

	@Test public void testQuantityExclusionTest3() throws Exception {
		Model model = parseHelper.parse("#5 kw2 bar baz");
		assertEquals("QuantityExclusionTest1, QuantityExclusionTest2",
				findContextsByContents(model.getQuantityExclusion()));
	}

	@Test public void testValueExclusionTest1() throws Exception {
		Model model = parseHelper.parse("#6 lit1");
		assertEquals("ValueExclusionTest1", findContextsByContents(model.getValueExclusion()));
	}

	@Test public void testValueExclusionTest2() throws Exception {
		Model model = parseHelper.parse("#6 lit2");
		assertEquals("ValueExclusionTest2", findContextsByContents(model.getValueExclusion()));
	}
	
	@Test public void testNodeExclusion1() throws Exception {
		Model model = parseHelper.parse("#7 'myname' myname");
		proxify(model.getNodeExclusion(), ContextFinderTestPackage.Literals.NODE_EXCLUSION__REF);
		assertEquals("NodeExclusion1", findContextsByContents(model.getNodeExclusion()));
	}

	@Test public void testNodeExclusion2() throws Exception {
		Model model = parseHelper.parse("#7 'my@' 'my@'");
		proxify(model.getNodeExclusion(), ContextFinderTestPackage.Literals.NODE_EXCLUSION__REF);
		assertEquals("NodeExclusion2", findContextsByContents(model.getNodeExclusion()));
	}

	@Test public void testNodeExclusion1List() throws Exception {
		Model model = parseHelper.parse("#8 'myname' myname");
		proxify(model.getNodeExclusionList(), ContextFinderTestPackage.Literals.NODE_EXCLUSION_LIST__REF);
		assertEquals("NodeExclusion1List", findContextsByContents(model.getNodeExclusionList()));
	}

	@Test public void testNodeExclusion2List() throws Exception {
		Model model = parseHelper.parse("#8 'my@' 'my@'");
		proxify(model.getNodeExclusionList(), ContextFinderTestPackage.Literals.NODE_EXCLUSION_LIST__REF);
		assertEquals("NodeExclusion2List", findContextsByContents(model.getNodeExclusionList()));
	}

	private void proxify(EObject owner, EReference ref) {
		if (ref.isMany()) {
			@SuppressWarnings("unchecked")
			List<? super Object> list = (List<? super Object>) owner.eGet(ref);
			for (int i = 0; i < list.size(); i++)
				list.set(i, createProxy((EObject) list.get(i)));
		} else {
			owner.eSet(ref, createProxy((EObject) owner.eGet(ref)));
		}
	}

	private EObject createProxy(EObject old) {
		EClass type = old.eClass();
		InternalEObject proxy = (InternalEObject) type.getEPackage().getEFactoryInstance().create(type);
		proxy.eSetProxyURI(old.eResource().getURI().appendFragment("some_invalid_fragment"));
		return proxy;
	}

}
