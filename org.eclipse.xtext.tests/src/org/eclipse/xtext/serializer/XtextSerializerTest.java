/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.serializer.SerializerTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextSerializerTest extends AbstractXtextTests {
	@Inject
	private SerializerTestHelper tester;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
		getInjector().injectMembers(this);
	}

	@Test
	@Ignore
	public void testXtextXtextWithNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithNodeModel(grammar);
	}

	@Test
	public void testGroup() {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		AbstractRule rule = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.Xtext.Grammar");
		Group cGroup_2 = (Group) rule.eContents().get(1).eContents().get(2);
		detachNodeModel(grammar);
		String string = get(ISerializer.class).serialize(cGroup_2);
		Assert.assertEquals("(\"with\" usedGrammars+=[Grammar|GrammarID] (\",\" usedGrammars+=[Grammar|GrammarID])*)?",
				string);
	}

}
