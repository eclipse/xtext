/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.impl.ConcreteSyntaxConstraintProvider;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxConstraintProviderTest extends AbstractXtextTests {

	private static class CSCPTest extends ConcreteSyntaxConstraintProvider {
		public CSCPTest(Grammar grammar) {
			super();
			this.grammar = grammar;
		}
	}

	final static String HEADER = "grammar org.eclipse.xtext.validation.ConcreteSyntaxConstraintProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate treeConstTest \"http://www.eclipse.org/2010/tmf/xtext/CSCT\"  ";

	private String parseRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		Matcher m = Pattern.compile("^[a-zA-Z]+").matcher(body);
		m.find();
		String firstRuleName = m.group();
		AbstractRule firstRule = GrammarUtil.findRuleForName(grammar, firstRuleName);
		IConcreteSyntaxConstraintProvider cscp = new CSCPTest(grammar);
		return toString(cscp.getConstraint((ParserRule) firstRule));
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	private String toString(ISyntaxConstraint c) {
		if (c == null)
			return null;
		String t = "";
		if (c.getSemanticTypesToCheck() != null) {
			List<String> names = Lists.newArrayList(Iterables.transform(c.getSemanticTypesToCheck(),
					new Function<EClass, String>() {
						@Override
						public String apply(EClass from) {
							return from.getName();
						}
					}));
			Collections.sort(names);
			t = "<" + Joiner.on(", ").join(names) + ">";
		}
		Iterable<String> contents = Iterables.transform(c.getContents(), new Function<ISyntaxConstraint, String>() {
			@Override
			public String apply(ISyntaxConstraint from) {
				return ConcreteSyntaxConstraintProviderTest.this.toString(from);
			}
		});
		switch (c.getType()) {
			case ASSIGNMENT:
				return t + c.getAssignmentName() + c.getCardinality();
			case GROUP:
				return t + "(" + Joiner.on(" ").join(contents) + ")" + c.getCardinality();
			case ALTERNATIVE:
				return t + "(" + Joiner.on("|").join(contents) + ")" + c.getCardinality();
			case ACTION:
				return t + "{}";
		}
		return "";
	}

	@Test public void testSimple() throws Exception {
		String constraint = parseRule("Model: name=ID;");
		assertEquals("<Model>name", constraint);
	}

	@Test public void testGroup1() throws Exception {
		String constraint = parseRule("Model: name=ID (val=INT 'somekw')?;");
		assertEquals("<Model>(name val?)", constraint);
	}

	@Test public void testAlternatives1() throws Exception {
		String constraint = parseRule("Model: name=ID | val=INT | 'somekw';");
		assertEquals("<Model>(name|val)?", constraint);
	}

	@Test public void testAction1() throws Exception {
		String constraint = parseRule("Model: {Model} name=ID;");
		assertEquals("<Model>({} name)", constraint);
	}

	@Test public void testAction2() throws Exception {
		String constraint = parseRule("Model: {Type1} name=ID;");
		assertEquals("<Type1>({} name)", constraint);
	}

	@Test public void testAction3() throws Exception {
		String constraint = parseRule("Model: 'something' ({Type1} name=ID)? val=INT;");
		assertEquals("<Model, Type1>(<Type1>({} name)? val)", constraint);
	}

	@Test public void testAction4() throws Exception {
		String constraint = parseRule("Model: 't1' {Type1} | 't2' {Type2} | 't3' {Type3};");
		assertEquals("<Type1, Type2, Type3>(<Type1>{}|<Type2>{}|<Type3>{})", constraint);
	}

	@Test public void testAction5() throws Exception {
		String constraint = parseRule("Model: 't1' {Type1} | 't2' {Type2} | 't3' {Type3} | 't4';");
		assertEquals("<Model, Type1, Type2, Type3>(<Type1>{}|<Type2>{}|<Type3>{})?", constraint);
	}

	@Test public void testAction6() throws Exception {
		String constraint = parseRule("Model: 't1' {Type1} val=ID | 't2' {Type2} val=ID | 't3' {Type3} | 't4';");
		assertEquals("<Model, Type1, Type2, Type3>(<Type1>({} val)|<Type2>({} val)|<Type3>{})?", constraint);
	}

	@Test public void testAction7() throws Exception {
		String constraint = parseRule("Model: ('t1' {Type1} val=ID | 't2' {Type2} val=ID | 't3' {Type3})?;");
		assertEquals("<Model, Type1, Type2, Type3>(<Type1>({} val)|<Type2>({} val)|<Type3>{})?", constraint);
	}

	@Test public void testAction8() throws Exception {
		String constraint = parseRule("Model: 't1' {Type1} val=ID | ('something' ({Type2} 't2' | {Type3} 't3'));");
		assertEquals("<Type1, Type2, Type3>(<Type1>({} val)|<Type2, Type3>(<Type2>{}|<Type3>{}))", constraint);
	}

	@Test public void testAction9() throws Exception {
		String constraint = parseRule("Model: ('t1' {Type1} val1=ID | val2=ID) val3=ID;");
		assertEquals("<Model, Type1>((<Type1>({} val1)|<Model>val2) val3)", constraint);
	}

	@Test public void testSummarizeAssignments1() throws Exception {
		String constraint = parseRule("Model: val+=ID (',' val+=ID)*;");
		assertEquals("<Model>val+", constraint);
	}

	@Test public void testSummarizeAssignments2() throws Exception {
		String constraint = parseRule("Model: val+=ID (',' val+=ID)+;");
		assertEquals("<Model>(val val+)", constraint);
	}

	@Test public void testSummarizeAssignments3() throws Exception {
		String constraint = parseRule("Model: (val+=ID (',' val+=ID)*)?;");
		assertEquals("<Model>val*", constraint);
	}

	@Test public void testMulti1() throws Exception {
		String constraint = parseRule("model : ('kw1' a+=ID b+=ID)* ('kw2' a+=ID c+=ID)* ('kw3' b+=ID c+=ID)*;");
		assertEquals("<model>((a b)* (a c)* (b c)*)", constraint);
	}

	@Test public void testRuleCall1() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: Sub; ");
		b.append("Sub: val=ID; ");
		String constraint = parseRule(b.toString());
		assertEquals("<Sub>val", constraint);
	}

	@Test public void testRuleCall2() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: (Sub1 | Sub2) name=ID 'somekeyword'; ");
		b.append("Sub1: 'sub1' val1=ID; ");
		b.append("Sub2: 'sub2' val2=ID; ");
		String constraint = parseRule(b.toString());
		assertEquals("<Sub1, Sub2>((<Sub1>val1|<Sub2>val2) name)", constraint);
	}

	@Test public void testRuleCall3() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: (Sub1 | Sub2)? name=ID 'somekeyword'; ");
		b.append("Sub1: 'sub1' val1=ID; ");
		b.append("Sub2: 'sub2' val2=ID; ");
		String constraint = parseRule(b.toString());
		assertEquals("<Model, Sub1, Sub2>(<Sub1, Sub2>(<Sub1>val1|<Sub2>val2)? name)", constraint);
	}

	@Test public void testRecursion() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model returns Model: Sub1 | name=ID 'somekeyword'; ");
		b.append("Sub1 returns Model: '(' Model ')'; ");
		String constraint = parseRule(b.toString());
		assertNull(constraint);
	}

	@Test public void testAssignedActions() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: 'y' val=ID ({Evil.left=current} ',' right=ID)?; ");
		String constraint = parseRule(b.toString());
		assertNull(constraint);
	}

	@Test public void testNestedAssignedActions() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: Foo | Bar; ");
		b.append("Foo: 'x' val=ID; ");
		b.append("Bar: 'y' val=ID ({Evil.left=current} ',' right=ID)?; ");
		String constraint = parseRule(b.toString());
		assertNull(constraint);
	}

	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=312220
	@Test public void testUnassignedRuleCall() throws Exception {
		String constraint = parseRule("WithoutHidden hidden(): '[' 'kw' WS x=INT '.' y=INT ']';");
		assertEquals("<WithoutHidden>(x y)", constraint);
	}

	@Test public void testNestedAlternative() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: (SE | Decl) ';'; ");
		b.append("Decl:	type+=ID name+=ID; ");
		b.append("SE: '`' (ids+=(WS|ID|ANY_OTHER)|ints+=INT)+ '`'; ");
		String constraint = parseRule(b.toString());
		assertEquals("<Decl, SE>(<SE>(ids|ints)+|<Decl>(type name))", constraint);
	}

	@Test public void testEmptyAlternative() throws Exception {
		String constraint = parseRule("Import: ('import' | 'imp') foo=ID?;");
		assertEquals("<Import>foo?", constraint);
	}
	
	@Test public void testOptionalGroupWithUnassignedElements() throws Exception {
		StringBuilder b = new StringBuilder();
		b.append("Model: ('(' INT ')')? a=STRING b=STRING;");
		String constraint = parseRule(b.toString());
		assertEquals("<Model>(a b)", constraint);
	}
}
