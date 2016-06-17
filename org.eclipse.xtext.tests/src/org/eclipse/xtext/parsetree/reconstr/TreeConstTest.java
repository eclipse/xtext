/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.util.Collection;
import java.util.Set;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstructionNFAProvider;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstTest extends AbstractXtextTests {

	private TreeConstructionNFAProvider nfa = new TreeConstructionNFAProvider();

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	final static String HEADER = "grammar org.eclipse.xtext.parsetree.reconstr.TreeConstTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate treeConstTest \"http://www.eclipse.org/2010/tmf/xtext/TreeConstTest\"  ";

	private ParserRule parseRule(String body) throws Exception {
		return (ParserRule) parseGrammar(body).getRules().get(0);
	}

	private Grammar parseGrammar(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		String file = "src-gen/" + TreeConstTest.class.getName().replace('.', '/') + "-" + getName() + ".pdf";
		//		new TreeConstNFAToDot().draw(grammar, file, "-T pdf");
		//		System.out.println(new TreeConstNFAToDot().draw(grammar));
		return grammar;
	}

	private void assertTypes(Collection<TypeRef> actual, String... expected) {
		Set<String> refs = Sets.newHashSet();
		for (TypeRef t : actual)
			refs.add(t == null ? "null" : t.getClassifier().getName());
		Set<String> actual2 = Sets.newHashSet(refs);
		for (String e : expected) {
			if (refs.contains(e))
				refs.remove(e);
			else
				fail("Type '" + e + "' not found. Actual:" + actual2 + " Expected: " + Joiner.on(", ").join(expected));
		}
		if (!refs.isEmpty())
			fail("Types '" + refs + "' are not expected. Actual:" + actual2 + " Expected: " + Joiner.on(", ").join(expected));
	}

	@Test public void testSingleAssignment() throws Exception {
		AbstractRule rule = parseRule("Model: name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Model");
	}

	@Test public void testSingleAssignmentOrNull() throws Exception {
		AbstractRule rule = parseRule("Model: 'foo' name=ID?;");
		Group group = (Group) rule.getAlternatives();
		assertTypes(nfa.getNFA(group).getTypes(), "Model", "null");
		assertTypes(nfa.getNFA(group.getElements().get(0)).getTypesToCheck());
	}

	@Test public void testSingleAction1() throws Exception {
		AbstractRule rule = parseRule("Model: 'someKeyword' {Model};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Model");
	}

	@Test public void testSingleAction2() throws Exception {
		AbstractRule rule = parseRule("Model: 'someKeyword' {TypeRestriction};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "TypeRestriction");
	}

	@Test public void testMultiAction1() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1} | 'b' {Type2};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type1", "Type2");
	}

	@Test public void testMultiAction2() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1} | 'b' {Type2} | 'c';");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type1", "Type2", "null");
	}

	@Test public void testMultiAction3() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1} | 'b' {Type2} | 'c' name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type1", "Type2", "Model");
	}

	@Test public void testMultiAction4() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1} | 'b' {Type2} | 'c' | name=ID;");
		Alternatives alt = (Alternatives) rule.getAlternatives();
		assertTypes(nfa.getNFA(alt).getTypes(), "Type1", "Type2", "Model", "null");
		assertTypes(nfa.getNFA(alt.getElements().get(0)).getTypesToCheck(), "Type1");
		assertTypes(nfa.getNFA(alt.getElements().get(1)).getTypesToCheck(), "Type2");
		assertTypes(nfa.getNFA(alt.getElements().get(2)).getTypesToCheck());
		assertTypes(nfa.getNFA(alt.getElements().get(3)).getTypesToCheck(), "Model");
	}

	@Test public void testAssignedAction1() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1.sub=current};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type1");
	}

	@Test public void testAssignedAction2() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1.sub=current} 'b' {Type2.sub=current};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type2");
	}

	@Test public void testAssignedAction3() throws Exception {
		AbstractRule rule = parseRule("Model: 'a' {Type1.sub=current} | 'b' {Type2.sub=current};");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Type1", "Type2");
	}

	@Test public void testAssignedRuleCall() throws Exception {
		AbstractRule rule = parseRule("Model: 'something' foo=Bar; Bar: name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Model");
	}

	@Test public void testRuleCall1() throws Exception {
		AbstractRule rule = parseRule("Model: Foo; Foo: name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Foo");
	}

	@Test public void testRuleCall2() throws Exception {
		AbstractRule rule = parseRule("Model: Foo | 'bar'; Foo: name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Foo", "null");
	}

	@Test public void testRuleCall3() throws Exception {
		AbstractRule rule = parseRule("Model: Foo | 'bar' name=ID | 'null'; Foo: name=ID;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Foo", "Model", "null");
	}

	@Test public void testRuleCall4() throws Exception {
		AbstractRule rule = parseRule("Model: Foo | Bar; Foo: name=ID; Bar: val=INT;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Foo", "Bar");
	}

	@Test public void testRuleCall5() throws Exception {
		AbstractRule rule = parseRule("Model: (Foo | Bar) v2=ID v1=ID; Foo: name=ID; Bar: val=INT;");
		assertTypes(nfa.getNFA(rule.getAlternatives()).getTypes(), "Foo", "Bar");
	}

	@Test public void testExpression1() throws Exception {
		StringBuilder s = new StringBuilder();
		s.append("Expression: Add; ");
		s.append("Add returns Expression: Mult ({Add.left=current} '+' right=Mult)?; ");
		s.append("Mult returns Expression: Prim ({Mult.left=current} '+' right=Prim)?; ");
		s.append("Prim returns Expression: {Val} val=INT | '(' Expression ')'; ");
		Grammar rule = parseGrammar(s.toString());

		AbstractRule expression = rule.getRules().get(0);
		assertTypes(nfa.getNFA(expression.getAlternatives()).getTypes(), "Val", "Add", "Mult");
		assertTypes(nfa.getNFA(expression.getAlternatives()).getTypesToCheck(), "Val", "Add", "Mult");

		AbstractRule add = rule.getRules().get(1);
		assertTypes(nfa.getNFA(add.getAlternatives()).getTypes(), "Val", "Add", "Mult");
		assertTypes(nfa.getNFA(add.getAlternatives()).getTypesToCheck(), "Val", "Add", "Mult");
		Group add_g1 = (Group) ((Group) add.getAlternatives()).getElements().get(1);
		assertTypes(nfa.getNFA(add_g1).getTypes(), "Add");
		assertTypes(nfa.getNFA(add_g1).getTypesToCheck(), "Add");
		assertTypes(nfa.getNFA(add_g1.getElements().get(2)).getTypes(), "Add");
		assertTypes(nfa.getNFA(add_g1.getElements().get(2)).getTypesToCheck());

		AbstractRule mult = rule.getRules().get(2);
		assertTypes(nfa.getNFA(mult.getAlternatives()).getTypes(), "Val", "Add", "Mult");
		assertTypes(nfa.getNFA(mult.getAlternatives()).getTypesToCheck(), "Val", "Add", "Mult");

		AbstractRule prim = rule.getRules().get(3);
		assertTypes(nfa.getNFA(prim.getAlternatives()).getTypes(), "Val", "Add", "Mult");
		assertTypes(nfa.getNFA(prim.getAlternatives()).getTypesToCheck(), "Val", "Add", "Mult");

	}
}
