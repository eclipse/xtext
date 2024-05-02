/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.indentation;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider;
import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.Tree;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCompletePrefixProviderTest {
	public abstract CompletionPrefixProvider getTestee();

	@Inject
	private ParseHelper<Tree> parseHelper;

	@Test
	public void testInputToParse_01() throws Exception {
		Assert.assertEquals("abc", getTestee().getInputToParse("abcdefg", 3, 7));
	}

	@Test
	public void testInputToParse_02() throws Exception {
		Assert.assertEquals("abc", getTestee().getInputToParse("abc   defg", 3, 7));
	}

	@Test
	public void testWholeNodeModel() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		grandChild2\n" +
				"	child1\n" +
				"			grandChild3\n" +
				"			\n" +
				"			grandChild4\n" +
				"		\n" +
				"	child2\n" +
				"		\n" +
				"		grandChild5\n" +
				"parent2\n" +
				"\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[ID:grandChild2]\n" +
				"[DEDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild3]\n" +
				"[ID:grandChild4]\n" +
				"[DEDENT:]\n" +
				"[ID:child2]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild5]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:parent2]\n");
	}

	@Test
	public void testLastCompleteNode_0_0() throws Exception {
		assertLastCompleteNode(
				"<|>parent1\n" +
				"	child1\n" +
				"\n"
,				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_0_2() throws Exception {
		assertLastCompleteNode(
				"pa<|>rent1\n" +
				"	child1\n"
,				"[ID:parent1]\n");
	}

	@Test
	public void testLastCompleteNode_1_0() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"<|>	child1\n"
,				"[ID:parent1]\n");
	}

	@Test
	public void testLastCompleteNode_1_1() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	<|>child1\n"
,				"[ID:parent1]\n");
	}

	@Test
	public void testLastCompleteNode_1_2() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	c<|>hild1\n"
,				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n");
	}

	@Test
	public void testLastCompleteNode_2_0() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"<|>		grandChild1\n"
,				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n");
	}

	@Test
	public void testLastCompleteNode_2_1() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"	<|>	grandChild1\n"
,				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n");
	}

	@Test
	public void testLastCompleteNode_2_2() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		<|>grandChild1\n"
,				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n");
	}

	@Test
	public void testLastCompleteNode_3_1() throws Exception {
		assertLastCompleteNode(
				"c\n" +
				"	d\n" +
				"	g\n" +
				"	<|>\n"
,				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_3_2() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>grandChild2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_2() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_1() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_0() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_2b() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n" +
				"		grandChild2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_1b() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n" +
				"		grandChild2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_0b() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n" +
				"		grandChild2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_2c() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n" +
				"	child2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_1c() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n" +
				"	child2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_0c() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n" +
				"	child2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_4_2d() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n" +
				"parent2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_1d() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n" +
				"parent2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_4_0d() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n" +
				"parent2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	public void testLastCompleteNode_6_0() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n");
	}

	@Test
	public void testLastCompleteNode_6_0b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"<|>\n" +
				"	f\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n");
	}

	@Test
	public void testLastCompleteNode_6_1b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"	<|>\n" +
				"	f\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_5_1() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"	b\n" +
				"		c\n" +
				"			d\n" +
				"	<|>\n" +
				"			e\n",
				"[ID:a]\n" +
				"[INDENT:]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n");
	}

	@Test
	public void testLastCompleteNode_6_3() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g <|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_6_3b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g <|>",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_6_3c() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g <|> ",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_6_3d() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g <|> // comment",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_7_0() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g\n" +
				"<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_7_1() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"	g\n" +
				"	<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_1() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"c\n" +
				"	d\n" +
				"		e\n" +
				"			f\n" +
				"	g\n" +
				"	<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_2() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"		<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_2b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"		<|>\n" +
				"		h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_8_2c() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"		<|>\n" +
				"	h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_3() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"			<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_3b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"			<|>\n" +
				"		h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_8_3c() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"			<|>\n" +
				"	h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_4() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"				<|>\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	public void testLastCompleteNode_8_4b() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"				<|>\n" +
				"		h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n");
	}

	@Test
	public void testLastCompleteNode_8_4c() throws Exception {
		assertLastCompleteNode(
				"a\n" +
				"b\n" +
				"	c\n" +
				"		d\n" +
				"			e\n" +
				"				f\n" +
				"		g\n" +
				"				<|>\n" +
				"	h\n",
				"[ID:a]\n" +
				"[ID:b]\n" +
				"[INDENT:]\n" +
				"[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[INDENT:]\n" +
				"[ID:e]\n" +
				"[INDENT:]\n" +
				"[ID:f]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	protected void assertLastCompleteNode(CharSequence model, String expectation) throws Exception {
		String modelAsString = model.toString().replaceAll("\r\n", "\n");
		assertLastCompleteNode(modelAsString, expectation);
		String withStringLiterals = modelAsString.replaceAll("(\\w+(<\\|>\\w+)?)", "\"$1\"");
		String expectationWithLiterals = expectation.replaceAll("ID:(\\w+)", "STRING:\"$1\"");
		assertLastCompleteNode(withStringLiterals, expectationWithLiterals);
	}

	private void assertLastCompleteNode(String model, String expectation) throws Exception {
		int offset = model.indexOf("<|>");
		if (offset == -1) {
			offset = model.length();
		}
		int completionOffset = model.indexOf("<|>", offset);
		if (completionOffset == -1) {
			completionOffset = offset;
		}
		Tree tree = parseHelper.parse(model.replace("<|>", ""));
		ICompositeNode nodeModel = NodeModelUtils.findActualNodeFor(tree);
		INode completeNode = getTestee().getLastCompleteNodeByOffset(nodeModel, offset, completionOffset);
		assertNodeModel(expectation, completeNode);
	}

	private void assertNodeModel(String expectation, INode node) {
		Assert.assertEquals(expectation, asText(node.getRootNode(), node));
	}

	private String asText(INode node, INode stop) {
		Iterable<String> elements = Iterables.transform(
				upTo(Iterables.filter(
						Iterables.filter(node.getLeafNodes(), it -> !(it.getGrammarElement() instanceof Action)),
						it -> !it.isHidden()), stop),
				leaf -> "[" + tokenType(leaf.getGrammarElement()) + ":" + leaf.getText().replace("\t", "\\t") + "]\n");
		return Joiner.on("").join(elements);
	}

	private <T extends Object> Iterable<T> upTo(Iterable<T> iter, Object element) {
		final class UpToPredicate implements Predicate<T> {
			boolean found = false;

			@Override
			public boolean apply(T t) {
				if (found) {
					return false;
				}
				try {
					return true;
				} finally {
					found = Objects.equals(t, element);
				}
			}
		}

		return Iterables.filter(iter, new UpToPredicate());
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
