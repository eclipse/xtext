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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.contextFinderTest.Model;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextFinderTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
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
			result.add(context2name.apply(ctx));
		Collections.sort(result);
		return Joiner.on(", ").join(result);
	}

	public void testAttributeExclusionTest1() throws Exception {
		Model model = parseHelper.parse("#1 kw1 bar");
		assertEquals("AttributeExclusionTest1", findContextsByContents(model.getAttributeExclusion()));
	}

	public void testAttributeExclusionTest2() throws Exception {
		Model model = parseHelper.parse("#1 kw2 bar");
		assertEquals("AttributeExclusionTest2", findContextsByContents(model.getAttributeExclusion()));
	}

	public void testNestedTypeTest1() throws Exception {
		Model model = parseHelper.parse("#2 kw1 bar");
		assertEquals("NestedTypeTest1", findContextsByContents(model.getNestedType()));
	}

	public void testNestedTypeTest2() throws Exception {
		Model model = parseHelper.parse("#2 kw2 bar");
		assertEquals("NestedTypeTest2", findContextsByContents(model.getNestedType()));
	}

	public void testNestedTypeRecursiveTest1() throws Exception {
		Model model = parseHelper.parse("#3 kw1 . .");
		assertEquals("NestedTypeRecursiveTest1, NestedTypeRecursiveTest1_NestedTypeRecursiveTest_2_0",
				findContextsByContents(model.getNestedTypeRecursiveTest2()));
	}

	public void testNestedTypeRecursiveTest2() throws Exception {
		Model model = parseHelper.parse("#3 kw2 . .");
		assertEquals("NestedTypeRecursiveTest2, NestedTypeRecursiveTest2_NestedTypeRecursiveTest_2_0",
				findContextsByContents(model.getNestedTypeRecursiveTest2()));
	}

	public void testParentRefTest1() throws Exception {
		Model model = parseHelper.parse("#4 kw1 foo");
		ParentRefTestChild child1 = ((ParentRefTest1) model.getParentRef()).getChild1();
		assertEquals("ParentRefTestChild1", findContextsByContentsAndContainer(child1));
	}

	public void testParentRefTest2() throws Exception {
		Model model = parseHelper.parse("#4 kw2 foo");
		ParentRefTestChild child2 = ((ParentRefTest2) model.getParentRef()).getChild2();
		assertEquals("ParentRefTestChild2", findContextsByContentsAndContainer(child2));
	}

	public void testParentRefTest3() throws Exception {
		Model model = parseHelper.parse("#4 kw1 foo foo foo");
		ParentRefTestChild child1 = ((ParentRefTest1) model.getParentRef()).getChild1().getChild().getChild();
		assertEquals("ParentRefTestChild1", findContextsByContentsAndContainer(child1));
	}

	public void testParentRefTest4() throws Exception {
		Model model = parseHelper.parse("#4 kw2 foo foo foo");
		ParentRefTestChild child2 = ((ParentRefTest2) model.getParentRef()).getChild2().getChild().getChild();
		assertEquals("ParentRefTestChild2", findContextsByContentsAndContainer(child2));
	}

	public void testRootContainer() throws Exception {
		Model model = parseHelper.parse("#0 model #1 kw1 bar");
		assertEquals("Model", findContextsByContentsAndContainer(model));
		assertEquals("Model2", findContextsByContentsAndContainer(model.getModel()));
	}
}
