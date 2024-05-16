/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.Arrays;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PredicatedElementTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void testPredicatedElement_01() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RootRule: Child;\n" +
				"Child: =>(name=ID ->child=Child?);\n";
		assertPredicate("ID ID?", grammar);
	}

	@Test
	public void testPredicatedElement_02() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RootRule: Child;\n" +
				"Child: =>(name=ID ->child=Sub);\n" +
				"Sub: age=INT? name=STRING;\n";
		assertPredicate("ID (INT | STRING)", grammar);
	}

	@Test
	public void testPredicatedElement_03() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RootRule: Child;\n" +
				"Child: =>(name=ID =>child=Sub);\n" +
				"Sub: age=INT? name=STRING;\n";
		assertPredicate("ID Sub", grammar);
	}

	@Test
	public void testPredicatedElement_04() throws Exception {
		String grammar = "\n" +
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RootRule: =>Child;\n" +
				"Child: =>(name=ID =>child=Sub);\n" +
				"Sub: age=INT? name=STRING;\n";
		assertPredicate("Child", grammar);
	}

	@Test
	public void testPredicatedElement_05() throws Exception {
		String grammar =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RootRule: Child;\n" +
				"Child: =>(name=ID (child=Child? | zonk=ID? ->sub=Sub));\n" +
				"Sub: age=INT? name=STRING;\n";
		assertPredicate("ID (Child? | ID? (INT | STRING))", grammar);
	}

	public void assertPredicate(String expectation, String grammar) throws Exception {
		Grammar parsed = (Grammar) getModel(grammar);
		AbstractElement body = Iterables.getFirst(parsed.getRules(), null).getAlternatives();
		AbstractElement predicate = AntlrGrammarGenUtil.getPredicatedElement(body);
		Assert.assertEquals(expectation, toXtext(predicate));
	}

	private String withCardinality(String s, AbstractElement e) {
		String cardinality = e.getCardinality();
		if (cardinality == null) {
			cardinality = "";
		}
		return s + cardinality;
	}

	public String toXtext(AbstractElement alt) {
		if (alt instanceof Alternatives) {
			Alternatives alt1 = (Alternatives) alt;
			return IterableExtensions.join(alt1.getElements(), "(", " | ", withCardinality(")", alt1), this::toXtext);
		} else if (alt instanceof Group) {
			Group group = (Group) alt;
			if (group.getCardinality() == null) {
				return IterableExtensions.join(group.getElements(), " ", this::toXtext);
			} else {
				return IterableExtensions.join(group.getElements(), "(", " ", ")" + group.getCardinality(),
						this::toXtext);
			}
		} else if (alt instanceof Assignment) {
			Assignment ass = (Assignment) alt;
			String xtext = toXtext(ass.getTerminal());
			return withCardinality(xtext, ass);
		} else if (alt instanceof CrossReference) {
			return toXtext(((CrossReference) alt).getTerminal());
		} else if (alt instanceof Keyword) {
			Keyword kw = (Keyword) alt;
			return withCardinality("'" + kw.getValue() + "'", kw);
		} else if (alt instanceof RuleCall) {
			RuleCall rc = (RuleCall) alt;
			String name = rc.getRule().getName();
			return withCardinality(name, rc);
		} else {
			throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.asList(alt).toString());
		}
	}
}
