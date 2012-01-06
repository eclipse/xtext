/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.RelationalDependencyType;
import org.eclipse.xtext.util.Pair;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarConstraintProviderAssignmentsTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	final static String HEADER = "grammar org.eclipse.xtext.validation.GrammarConstraintTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate grammarConstraintTest \"http://www.eclipse.org/2010/tmf/xtext/GCT\"  ";

	private String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		IGrammarConstraintProvider gcp = get(IGrammarConstraintProvider.class);

		IConstraint ctxts = gcp.getConstraints(grammar).get(0).getConstraints().get(0);
		List<String> result = Lists.newArrayList();
		for (IConstraintElement ass : ctxts.getBody().getContainedAssignments()) {
			result.add(ass.toString());
			for (Pair<IConstraintElement, RelationalDependencyType> c : ass.getDependingAssignment())
				result.add("  " + c.getSecond() + " " + c.getFirst());
		}
		return Joiner.on("\n").join(result);
	}

	@Test public void testMandatoryGroup1() throws Exception {
		String actual = getParserRule("Rule: 'kw1' a1='a1' a2+='a2'* a3+='a3'+ a4+='a4'?;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("a2+='a2'*\n");
		expected.append("a3+='a3'+\n");
		expected.append("a4+='a4'?");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testMandatoryGroup2() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2='a2') (b1='b1'? b2='b2'?) (c1+='c1'+ c2+='c2'+) (d1+='a1'* d2+='d2'*);");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("a2='a2'\n");
		expected.append("b1='b1'?\n");
		expected.append("b2='b2'?\n");
		expected.append("c1+='c1'+\n");
		expected.append("c2+='c2'+\n");
		expected.append("d1+='a1'*\n");
		expected.append("d2+='d2'*");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testOptionalGroup1() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2+='a2'* a3+='a3'+ a4+='a4'?)?;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  EXCLUDE_IF_UNSET a3+='a3'+\n");
		expected.append("  MANDATORY_IF_SET a3+='a3'+\n");
		expected.append("  MANDATORY_IF_SET a4+='a4'?\n");
		expected.append("a2+='a2'*\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET a3+='a3'+\n");
		expected.append("a3+='a3'+\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  MANDATORY_IF_SET a4+='a4'?\n");
		expected.append("a4+='a4'?\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET a3+='a3'+");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testOptionalGroup2() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2='a2')? (b1='b1'? b2='b2'?)? (c1+='c1'+ c2+='c2'+)? (d1+='a1'* d2+='d2'*)?;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET a2='a2'\n");
		expected.append("  MANDATORY_IF_SET a2='a2'\n");
		expected.append("a2='a2'\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a1='a1'\n");
		expected.append("b1='b1'?\n");
		expected.append("b2='b2'?\n");
		expected.append("c1+='c1'+\n");
		expected.append("  EXCLUDE_IF_UNSET c2+='c2'+\n");
		expected.append("  MANDATORY_IF_SET c2+='c2'+\n");
		expected.append("c2+='c2'+\n");
		expected.append("  EXCLUDE_IF_UNSET c1+='c1'+\n");
		expected.append("  MANDATORY_IF_SET c1+='c1'+\n");
		expected.append("d1+='a1'*\n");
		expected.append("d2+='d2'*");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testManyGroup1() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1+='a1' a2+='a2'* a3+='a3'+ a4+='a4'?)+;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1+='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  MANDATORY_IF_SET a3+='a3'+\n");
		expected.append("  SAME_OR_LESS a3+='a3'+\n");
		expected.append("  SAME_OR_MORE a4+='a4'?\n");
		expected.append("a2+='a2'*\n");
		expected.append("  EXCLUDE_IF_UNSET a1+='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET a3+='a3'+\n");
		expected.append("a3+='a3'+\n");
		expected.append("  EXCLUDE_IF_UNSET a1+='a1'\n");
		expected.append("  SAME_OR_MORE a1+='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  SAME_OR_MORE a4+='a4'?\n");
		expected.append("a4+='a4'?\n");
		expected.append("  SAME_OR_LESS a1+='a1'\n");
		expected.append("  SAME_OR_LESS a3+='a3'+");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testManyGroup2() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2='a2')+ (b1='b1'? b2='b2'?)+ (c1+='c1'+ c2+='c2'+)+ (d1+='a1'* d2+='d2'*)+;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  SAME a2='a2'\n");
		expected.append("a2='a2'\n");
		expected.append("  SAME a1='a1'\n");
		expected.append("b1='b1'?\n");
		expected.append("b2='b2'?\n");
		expected.append("c1+='c1'+\n");
		expected.append("  EXCLUDE_IF_UNSET c2+='c2'+\n");
		expected.append("  MANDATORY_IF_SET c2+='c2'+\n");
		expected.append("c2+='c2'+\n");
		expected.append("  EXCLUDE_IF_UNSET c1+='c1'+\n");
		expected.append("  MANDATORY_IF_SET c1+='c1'+\n");
		expected.append("d1+='a1'*\n");
		expected.append("d2+='d2'*");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testOptionalManyGroup1() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2+='a2'* a3+='a3'+ a4+='a4'?)*;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  MANDATORY_IF_SET a3+='a3'+\n");
		expected.append("  SAME_OR_LESS a3+='a3'+\n");
		expected.append("  SAME_OR_MORE a4+='a4'?\n");
		expected.append("a2+='a2'*\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET a3+='a3'+\n");
		expected.append("a3+='a3'+\n");
		expected.append("  EXCLUDE_IF_UNSET a1='a1'\n");
		expected.append("  SAME_OR_MORE a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'*\n");
		expected.append("  SAME_OR_MORE a4+='a4'?\n");
		expected.append("a4+='a4'?\n");
		expected.append("  SAME_OR_LESS a1='a1'\n");
		expected.append("  SAME_OR_LESS a3+='a3'+");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testOptionalManyGroup2() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' a2='a2')* (b1='b1'? b2='b2'?)* (c1+='c1'+ c2+='c2'+)* (d1+='a1'* d2+='d2'*)*;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  SAME a2='a2'\n");
		expected.append("a2='a2'\n");
		expected.append("  SAME a1='a1'\n");
		expected.append("b1='b1'?\n");
		expected.append("b2='b2'?\n");
		expected.append("c1+='c1'+\n");
		expected.append("  EXCLUDE_IF_UNSET c2+='c2'+\n");
		expected.append("  MANDATORY_IF_SET c2+='c2'+\n");
		expected.append("c2+='c2'+\n");
		expected.append("  EXCLUDE_IF_UNSET c1+='c1'+\n");
		expected.append("  MANDATORY_IF_SET c1+='c1'+\n");
		expected.append("d1+='a1'*\n");
		expected.append("d2+='d2'*");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testKeywords2() throws Exception {
		String actual = getParserRule("Rule: 'kw1' (a1='a1' | a2+='a2') b1='b1' b2+='b2'* b3+='b3'+ b4+='b4'?;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  EXCLUDE_IF_SET a2+='a2'\n");
		expected.append("a2+='a2'\n");
		expected.append("  EXCLUDE_IF_SET a1='a1'\n");
		expected.append("b1='b1'\n");
		expected.append("b2+='b2'*\n");
		expected.append("b3+='b3'+\n");
		expected.append("b4+='b4'?");
		assertEquals(expected.toString(), actual);
	}

	@Test public void testKeywords3() throws Exception {
		String actual = getParserRule("Rule: 'kw1' ((a1='a1' | a2+='a2') b1='b1' b2+='b2'* b3+='b3'+ b4+='b4'?)?;");
		StringBuilder expected = new StringBuilder();
		expected.append("a1='a1'\n");
		expected.append("  EXCLUDE_IF_SET a2+='a2'\n");
		expected.append("  EXCLUDE_IF_UNSET b1='b1'\n");
		expected.append("  EXCLUDE_IF_UNSET b3+='b3'+\n");
		expected.append("a2+='a2'\n");
		expected.append("  EXCLUDE_IF_SET a1='a1'\n");
		expected.append("  EXCLUDE_IF_UNSET b1='b1'\n");
		expected.append("  EXCLUDE_IF_UNSET b3+='b3'+\n");
		expected.append("b1='b1'\n");
		expected.append("  MANDATORY_IF_SET a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'\n");
		expected.append("  MANDATORY_IF_SET b2+='b2'*\n");
		expected.append("  EXCLUDE_IF_UNSET b3+='b3'+\n");
		expected.append("  MANDATORY_IF_SET b3+='b3'+\n");
		expected.append("  MANDATORY_IF_SET b4+='b4'?\n");
		expected.append("b2+='b2'*\n");
		expected.append("  EXCLUDE_IF_UNSET b1='b1'\n");
		expected.append("  EXCLUDE_IF_UNSET b3+='b3'+\n");
		expected.append("b3+='b3'+\n");
		expected.append("  MANDATORY_IF_SET a1='a1'\n");
		expected.append("  MANDATORY_IF_SET a2+='a2'\n");
		expected.append("  EXCLUDE_IF_UNSET b1='b1'\n");
		expected.append("  MANDATORY_IF_SET b1='b1'\n");
		expected.append("  MANDATORY_IF_SET b2+='b2'*\n");
		expected.append("  MANDATORY_IF_SET b4+='b4'?\n");
		expected.append("b4+='b4'?\n");
		expected.append("  EXCLUDE_IF_UNSET b1='b1'\n");
		expected.append("  EXCLUDE_IF_UNSET b3+='b3'+");
		assertEquals(expected.toString(), actual);
	}
}