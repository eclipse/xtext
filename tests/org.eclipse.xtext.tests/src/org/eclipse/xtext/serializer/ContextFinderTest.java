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
import org.eclipse.xtext.serializer.sequencer.IContextFinder;

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
		Iterable<EObject> contexts = finder.findContextsByContents(obj, null);
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
}
