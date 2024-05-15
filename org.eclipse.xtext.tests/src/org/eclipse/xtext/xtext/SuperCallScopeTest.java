/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import static org.eclipse.xtext.GrammarUtil.*;
import static org.eclipse.xtext.xbase.lib.Pair.*;

import java.util.Arrays;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SuperCallScopeTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}

	@Test
	public void testGetAllElements_01() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElementNames(scope.getAllElements(), "Lang.Rule", "test.Lang.Rule", "Lang.ID", "test.Lang.ID", "super.ID",
				"Terminals.ID", "org.eclipse.xtext.common.Terminals.ID", "super.INT", "Terminals.INT",
				"org.eclipse.xtext.common.Terminals.INT", "super.STRING", "Terminals.STRING",
				"org.eclipse.xtext.common.Terminals.STRING", "super.ML_COMMENT", "Terminals.ML_COMMENT",
				"org.eclipse.xtext.common.Terminals.ML_COMMENT", "super.SL_COMMENT", "Terminals.SL_COMMENT",
				"org.eclipse.xtext.common.Terminals.SL_COMMENT", "super.WS", "Terminals.WS",
				"org.eclipse.xtext.common.Terminals.WS", "super.ANY_OTHER", "Terminals.ANY_OTHER",
				"org.eclipse.xtext.common.Terminals.ANY_OTHER");
	}

	@Test
	public void testGetAllElements_02() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(Iterables.getLast(grammar.getRules()));
		assertElementNames(scope.getAllElements(), "Lang.Rule", "test.Lang.Rule", "Lang.ID", "test.Lang.ID", "super",
				"super.ID", "Terminals.ID", "org.eclipse.xtext.common.Terminals.ID", "super.INT", "Terminals.INT",
				"org.eclipse.xtext.common.Terminals.INT", "super.STRING", "Terminals.STRING",
				"org.eclipse.xtext.common.Terminals.STRING", "super.ML_COMMENT", "Terminals.ML_COMMENT",
				"org.eclipse.xtext.common.Terminals.ML_COMMENT", "super.SL_COMMENT", "Terminals.SL_COMMENT",
				"org.eclipse.xtext.common.Terminals.SL_COMMENT", "super.WS", "Terminals.WS",
				"org.eclipse.xtext.common.Terminals.WS", "super.ANY_OTHER", "Terminals.ANY_OTHER",
				"org.eclipse.xtext.common.Terminals.ANY_OTHER");
	}

	@Test
	public void testGetElementsByName_01() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElements(scope.getElements(QualifiedName.create("ID")));
	}

	@Test
	public void testGetElementsByName_02() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElements(scope.getElements(QualifiedName.create("super")));
	}

	@Test
	public void testGetElementsByName_03() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(Iterables.getFirst(grammar.getRules(), null));
		assertElements(scope.getElements(QualifiedName.create("super")));
	}

	@Test
	public void testGetElementsByName_04() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(Iterables.getLast(grammar.getRules()));
		assertElements(scope.getElements(QualifiedName.create("super")),
				of("super", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")));
	}

	@Test
	public void testGetElementsByName_05() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElements(scope.getElements(QualifiedName.create("super", "ID")),
				of("super.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")));
	}

	@Test
	public void testGetElementsByName_06() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElements(scope.getElements(QualifiedName.create("Lang", "ID")),
				of("Lang.ID", findRuleForName(grammar, "test.Lang.ID")));
	}

	@Test
	public void testGetElementsByName_07() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		assertElements(scope.getElements(QualifiedName.create("test", "Lang", "ID")),
				of("test.Lang.ID", findRuleForName(grammar, "test.Lang.ID")));
	}

	@Test
	public void testGetElementsByEObject_01() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(grammar);
		AbstractRule id = findRuleForName(grammar, "test.Lang.ID");
		assertElements(scope.getElements(id), of("Lang.ID", findRuleForName(grammar, "test.Lang.ID")),
				of("test.Lang.ID", findRuleForName(grammar, "test.Lang.ID")));
	}

	@Test
	public void testGetElementsByEObject_02() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(Iterables.getFirst(grammar.getRules(), null));
		AbstractRule id = findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
		assertElements(scope.getElements(id),
				of("super.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")),
				of("Lang.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")),
				of("test.Lang.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")));
	}

	@Test
	public void testGetElementsByEObject_03() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		SuperCallScope scope = new SuperCallScope(Iterables.getLast(grammar.getRules()));
		AbstractRule id = findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
		assertElements(scope.getElements(id),
				of("super", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")),
				of("super.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")),
				of("Lang.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")),
				of("test.Lang.ID", findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID")));
	}

	public void assertElementNames(Iterable<IEObjectDescription> descriptions, String... expectedNames) {
		Assert.assertEquals(Joiner.on("\n").join(Arrays.asList(expectedNames)),
				Joiner.on("\n").join(Iterables.transform(descriptions, it -> it.getName().toString())));
	}

	@SafeVarargs
	public final void assertElements(Iterable<IEObjectDescription> descriptions,
			Pair<String, AbstractRule>... expected) {
		Assert.assertEquals(Joiner.on("\n").join(Lists.transform(Arrays.asList(expected), it -> {
			return it.getKey() + "->" + getGrammar(it.getValue()).getName() + "." + it.getValue().getName();
		})), Joiner.on("\n").join(Iterables.transform(descriptions, (IEObjectDescription it) -> {
			return it.getName().toString() + "->" + getGrammar(it.getEObjectOrProxy()).getName() + "."
					+ ((AbstractRule) it.getEObjectOrProxy()).getName();
		})));
	}
}
