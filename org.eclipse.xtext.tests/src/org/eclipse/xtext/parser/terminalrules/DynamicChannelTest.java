/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import java.io.StringReader;
import java.util.List;

import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DynamicChannelTest extends AbstractXtextTests {

	private final String grammar = "grammar";
	private final String a = "a";
	private final String ext = "with";
	private final String b = "b";
	private final String dot = ".";
	private final String c = "c";
	private final String space = " ";
	private final String comment = "/* comment \n*/";
	private final String lb = "\n";
	private final String rulename = "rulename";
	private final String d = "d";
	private final String returns = "returns";
	private final String name = "name";
	private final String ass = "=";
	private final String id = "ID";
	private final String sc = ";";
	private final String colon = ":";
	private final String model = "grammar a with b. c\n/* comment \n*/rulename  returns \nd: name=ID;";

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextTerminalsTestLanguageStandaloneSetup.class);
	}

	@Test public void testParseSimpleLanguage() throws Exception {
		IParseResult result = parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		assertNotNull(result.getSyntaxErrors());
		assertFalse(result.hasSyntaxErrors());
		assertTrue(result.getSyntaxErrors().toString(), Iterables.isEmpty(result.getSyntaxErrors()));
	}

	@Test public void testNodeModelOfSimpleLanguage() throws Exception {
		IParseResult result = parse(model);
		List<ILeafNode> leafs = Lists.newArrayList(result.getRootNode().getLeafNodes());
		assertEquals(23, leafs.size());
		int i = 0;
		checkLeaf(leafs.get(i++), grammar, false);
		checkLeaf(leafs.get(i++), space, true);
		checkLeaf(leafs.get(i++), a, false);
		checkLeaf(leafs.get(i++), space, true);
		checkLeaf(leafs.get(i++), ext, false);
		checkLeaf(leafs.get(i++), space, true);
		checkLeaf(leafs.get(i++), b, false);
		checkLeaf(leafs.get(i++), dot, false);
		checkLeaf(leafs.get(i++), space, true);
		checkLeaf(leafs.get(i++), c, false);
		checkLeaf(leafs.get(i++), lb, true);
		checkLeaf(leafs.get(i++), comment, true);
		checkLeaf(leafs.get(i++), rulename, false);
		checkLeaf(leafs.get(i++), space + space, true);
		checkLeaf(leafs.get(i++), returns, false);
		checkLeaf(leafs.get(i++), space + lb, true);
		checkLeaf(leafs.get(i++), d, false);
		checkLeaf(leafs.get(i++), colon, false);
		checkLeaf(leafs.get(i++), space, true);
		checkLeaf(leafs.get(i++), name, false);
		checkLeaf(leafs.get(i++), ass, false);
		checkLeaf(leafs.get(i++), id, false);
		checkLeaf(leafs.get(i++), sc, false);
	}

	protected IParseResult parse(String model) {
		return getParser().parse(new StringReader(model));
	}

	private void checkLeaf(ILeafNode leaf, String expected, boolean expectedHidden) {
		assertEquals(expected, leaf.getText());
		assertEquals(leaf.getText(), expectedHidden, leaf.isHidden());
	}
}
