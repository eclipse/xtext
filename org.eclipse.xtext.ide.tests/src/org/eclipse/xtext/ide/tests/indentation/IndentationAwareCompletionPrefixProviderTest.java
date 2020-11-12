/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.indentation;

import com.google.inject.Inject;
import org.eclipse.xtext.ide.editor.contentassist.CompletionPrefixProvider;
import org.eclipse.xtext.ide.editor.contentassist.IndentationAwareCompletionPrefixProvider;
import org.eclipse.xtext.ide.tests.testlanguage.tests.IndentationAwareUiTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareUiTestLanguageInjectorProvider.class)
public class IndentationAwareCompletionPrefixProviderTest extends AbstractCompletePrefixProviderTest {
	@Inject
	private IndentationAwareCompletionPrefixProvider testee;

	@Override
	public CompletionPrefixProvider getTestee() {
		return testee;
	}

	@Test
	@Override
	public void testInputToParse_02() throws Exception {
		Assert.assertEquals("abc  ", testee.getInputToParse("abc   defg", 3, 5));
	}

	@Test
	@Override
	public void testLastCompleteNode_1_1() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	<|>child1\n" +
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
				"[INDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_2_2() throws Exception {
		assertLastCompleteNode(
				"parent1\n" +
				"	child1\n" +
				"		<|>grandChild1\n" +
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
				"[INDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_3_1() throws Exception {
		assertLastCompleteNode("c\n" +
				"	d\n" +
				"	g\n" +
				"	<|>\n", "[ID:c]\n" +
				"[INDENT:]\n" +
				"[ID:d]\n" +
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_2() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_1() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_1b() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n" +
				"		grandChild2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[ID:grandChild2]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_0() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_0c() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n" +
				"	child2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_0d() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"<|>\n" +
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
	@Override
	public void testLastCompleteNode_4_1d() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"	<|>\n" +
				"parent2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_2c() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n" +
				"	child2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_4_2d() throws Exception {
		assertLastCompleteNode("parent1\n" +
				"	child1\n" +
				"		grandChild1\n" +
				"		<|>\n" +
				"parent2\n",
				"[ID:parent1]\n" +
				"[INDENT:]\n" +
				"[ID:child1]\n" +
				"[INDENT:]\n" +
				"[ID:grandChild1]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_6_0() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_6_0b() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_5_1() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:d]\n" +
				"[ID:e]\n" +
				"[DEDENT:]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_7_0() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n" +
				"[DEDENT:]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_7_1() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_1() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_2() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_2b() throws Exception {
		assertLastCompleteNode("a\n" +
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
	@Override
	public void testLastCompleteNode_8_2c() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_3() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_3b() throws Exception {
		assertLastCompleteNode("a\n" +
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
	@Override
	public void testLastCompleteNode_8_3c() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_4() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}

	@Test
	@Override
	public void testLastCompleteNode_8_4b() throws Exception {
		assertLastCompleteNode("a\n" +
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
	@Override
	public void testLastCompleteNode_8_4c() throws Exception {
		assertLastCompleteNode("a\n" +
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
				"[ID:g]\n");
	}
}
