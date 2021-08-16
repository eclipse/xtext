/**
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.tests.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareTestLanguageInjectorProvider.class)
public class NodeModelTest {
	public static void assertEquals(Object expected, Object actual) {
		Assert.assertEquals(expected.toString().replaceAll("\r\n", "\n"), actual.toString().replaceAll("\r\n", "\n"));
	}

	@Inject
	private ParseHelper<Tree> parseHelper;

	@Inject
	private InvariantChecker invariantChecker;

	@Test
	public void testEmptyTree() throws Exception {
		ICompositeNode tree = getRootNode("");
		NodeModelTest.assertEquals("", asText(tree));
	}

	@Test
	public void testSingleRootNode() throws Exception {
		ICompositeNode tree = getRootNode("root");
		String expectation = "[ID:root]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testTwoRootNodes() throws Exception {
		String model =
				"first\n" +
				"second\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[ID:first][-WS:\n" +
				"][ID:second][-WS:\n" +
				"]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testParentChild() throws Exception {
		String model =
				"parent\n" +
				"	child\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[ID:parent][-WS:\n" +
				"\\t][INDENT:][ID:child][-WS:\n" +
				"][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testParentChildWithEof() throws Exception {
		String model =
				"parent\n" +
				"	child\n";
		ICompositeNode tree = getRootNode(model.trim());
		String expectation = "[ID:parent][-WS:\n" +
				"\\t][INDENT:][ID:child][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testParentChildren() throws Exception {
		String model =
				"parent\n" +
				"	child\n" +
				"	child\n";
		ICompositeNode tree = getRootNode(model);
		String expectation = 
				"[ID:parent][-WS:\n" +
				"\\t][INDENT:][ID:child][-WS:\n" +
				"\\t][ID:child][-WS:\n" +
				"][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testTree_01() throws Exception {
		String model =
				"a\n" +
				"	b\n" +
				"	 c\n" +
				"	d\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[ID:a][-WS:\n" +
				"\\t][INDENT:][ID:b][-WS:\n" +
				"\\t ][INDENT:][ID:c][-WS:\n" +
				"][DEDENT:][-WS:\\t][ID:d][-WS:\n" +
				"][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testWeirdTree() throws Exception {
		String model =
				"root\n" +
				"    s4\n" +
				"        s8\n" +
				"      s6\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[ID:root][-WS:\n" +
				"    ][INDENT:][ID:s4][-WS:\n" +
				"        ][INDENT:][ID:s8][-WS:\n" +
				"][DEDENT:][-WS:      ][INDENT:][ID:s6][-WS:\n" +
				"][DEDENT:][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testWeirdTreeEof() throws Exception {
		String model =
				"root\n" +
				"    s4\n" +
				"        s8\n" +
				"      s6\n";
		ICompositeNode tree = getRootNode(model.trim());
		String expectation =
				"[ID:root][-WS:\n" +
				"    ][INDENT:][ID:s4][-WS:\n" +
				"        ][INDENT:][ID:s8][-WS:\n" +
				"][DEDENT:][-WS:      ][INDENT:][ID:s6][DEDENT:][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_1() throws Exception {
		String model =
				"first\n" +
				"	\n" +
				"second\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[ID:first][-WS:\n" +
				"\\t\n" +
				"][ID:second][-WS:\n" +
				"]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_2() throws Exception {
		String model =
				"\"first\"\n" +
				"	\n" +
				"\"second\"\n";
		ICompositeNode tree = getRootNode(model);
		String expectation =
				"[STRING:\"first\"][-WS:\n" +
				"\\t\n" +
				"][STRING:\"second\"][-WS:\n" +
				"]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_3() throws Exception {
		ICompositeNode tree = getRootNode("first\n\t");
		String expectation =
				"[ID:first][-WS:\n" +
				"\\t]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_4() throws Exception {
		// first<LB>
		//                 abc<LB>
		//         <EOF>
		ICompositeNode tree = getRootNode("first\n\t\tabc\n\t");
		String expectation =
				"[ID:first][-WS:\n" +
				"\\t\\t][INDENT:][ID:abc][-WS:\n" +
				"][DEDENT:][-WS:\\t]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_5() throws Exception {
		// first<LB>
		//   abc<LB>
		// <LB>
		// <EOF>
		ICompositeNode tree = getRootNode("first\n\t\tabc\n\n");
		String expectation =
				"[ID:first][-WS:\n" +
				"\\t\\t][INDENT:][ID:abc][-WS:\n" +
				"][DEDENT:][-WS:\n" +
				"]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_6() throws Exception {
		// first<LB>
		//   abc<LB>
		//   <LB>
		// <EOF>
		ICompositeNode tree = getRootNode("first\n\t\tabc\n\t\n");
		String expectation =
				"[ID:first][-WS:\n" +
				"\\t\\t][INDENT:][ID:abc][-WS:\n" +
				"][DEDENT:][-WS:\\t\n" +
				"]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	@Test
	public void testIgnoreEmptyLines_7() throws Exception {
		// a<LB>
		//   b<LB>
		//     <EOF>
		ICompositeNode tree = getRootNode("a\n\tb\n\t ");
		String expectation =
				"[ID:a][-WS:\n" +
				"\\t][INDENT:][ID:b][-WS:\n" +
				"\\t ][DEDENT:]\n";
		NodeModelTest.assertEquals(expectation.trim(), asText(tree));
	}

	private ICompositeNode getRootNode(CharSequence seq) throws Exception {
		Tree model = parseHelper.parse(seq.toString().replaceAll("\r\n", "\n"));
		ICompositeNode result = NodeModelUtils.getNode(model).getRootNode();
		invariantChecker.checkInvariant(result);
		return result;
	}

	private String asText(INode node) {
		Iterable<ILeafNode> filtered = Iterables.filter(node.getLeafNodes(),
				(ILeafNode it) -> (!(it.getGrammarElement() instanceof Action)));
		
		if (Iterables.isEmpty(filtered)) {
			return "";
		}
		return "[" + Joiner.on("][").join(Iterables.transform(filtered, (ILeafNode it) -> {
			return (it.isHidden() ? "-" : "") + tokenType(it.getGrammarElement()) + ":"
					+ it.getText().replace("\t", "\\t");
		})) + "]";
	}

	private String tokenType(EObject obj) {
		if (obj instanceof RuleCall) {
			return ((RuleCall) obj).getRule().getName();
		} else if (obj instanceof Keyword) {
			return ((Keyword) obj).getValue();
		} else if (obj instanceof AbstractRule) {
			return ((AbstractRule) obj).getName();
		}
		return null;
	}
}
