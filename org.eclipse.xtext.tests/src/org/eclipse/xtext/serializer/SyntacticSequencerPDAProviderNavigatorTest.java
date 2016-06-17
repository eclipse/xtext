/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynEmitterState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynFollowerOwner;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerPDAProviderNavigatorTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	final static String HEADER = "grammar org.eclipse.xtext.serializer.SequenceParserPDAProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate sequenceParserPDAProviderTest \"http://www.eclipse.org/2010/tmf/xtext/SequenceParserPDAProvider\"  ";

	protected ISynAbsorberState getParserRule(String body) throws Exception {
		return getParserRule(body, null, null);
	}

	protected ISynAbsorberState getParserRule(String body, String name, String typeName) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		SyntacticSequencerPDA2SimpleDot.drawGrammar("pdf/" + getName(), grammar);
		//		SyntacticSequencerPDA2ExtendedDot.drawGrammar(createSequenceParserPDAProvider(), "pdf/" + getName(), grammar);

		ISyntacticSequencerPDAProvider pdaProvider = get(ISyntacticSequencerPDAProvider.class);
		Map<ISerializationContext, ISynAbsorberState> pdas = pdaProvider.getSyntacticSequencerPDAs(grammar);
		for (Entry<ISerializationContext, ISynAbsorberState> s : pdas.entrySet()) {
			ISerializationContext context = s.getKey();
			if (context.getAssignedAction() != null)
				continue;
			ISynAbsorberState pda = s.getValue();
			ParserRule rule = context.getParserRule();
			EClass type = context.getType();
			boolean nameMatches = rule == null || name == null || rule.getName().equals(name);
			boolean typeMatches = type == null || typeName == null || typeName.equals(type.getName());
			if (nameMatches && typeMatches)
				return pda;
		}
		throw new IllegalStateException();
	}

	protected ISynTransition findTransition(ISynAbsorberState start, String fromAbsorber, String toAbsorber) {
		return findTransition(start, fromAbsorber, toAbsorber, Sets.<ISynAbsorberState> newHashSet());
	}

	protected ISynTransition findTransition(ISynAbsorberState start, String fromAbsorber, String toAbsorber,
			Set<ISynAbsorberState> visited) {
		if (!visited.add(start))
			return null;
		boolean fromMatches = start.toString().equals(fromAbsorber);
		for (ISynTransition trans : start.getOutTransitions()) {
			if (fromMatches && trans.getTarget().toString().equals(toAbsorber))
				return trans;
			ISynTransition result = findTransition(trans.getTarget(), fromAbsorber, toAbsorber, visited);
			if (result != null)
				return result;
		}
		return null;
	}

	protected RuleCallStack newStack() {
		return new RuleCallStack();
	}

	protected ISynEmitterState findEmitter(ISynFollowerOwner start, String name, Set<ISynFollowerOwner> visited) {
		if (start instanceof ISynAbsorberState || !visited.add(start))
			return null;
		if (start.toString().equals(name))
			return (ISynEmitterState) start;
		for (ISynState follower : start.getFollowers()) {
			ISynEmitterState result = findEmitter(follower, name, visited);
			if (result != null)
				return result;
		}
		return null;
	}

	protected RuleCallStack newStack(ISynTransition start, String... ruleCalls) {
		RuleCallStack result = new RuleCallStack();
		for (String name : ruleCalls) {
			ISynEmitterState emitter = findEmitter(start, name, Sets.<ISynFollowerOwner> newHashSet());
			result.push((RuleCall) emitter.getGrammarElement());
		}
		return result;
	}

	@Test
	public void testSimple() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID 'kw1' a2=ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertFalse(trans.involvesUnassignedTokenRuleCalls());
		assertFalse(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("['kw1']", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testTerminal() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID FOO a2=ID; terminal FOO: '$';");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertTrue(trans.involvesUnassignedTokenRuleCalls());
		assertFalse(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("[FOO]", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testDatatype() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID Foo a2=ID; Foo: ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertTrue(trans.involvesUnassignedTokenRuleCalls());
		assertFalse(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("[Foo]", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testAmbiguousOptional() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID 'kw1' 'kw2'? a2=ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertFalse(trans.involvesUnassignedTokenRuleCalls());
		assertTrue(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("['kw1']", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testAmbiguousMany() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID 'kw1' 'kw2'+ a2=ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertFalse(trans.involvesUnassignedTokenRuleCalls());
		assertTrue(trans.isSyntacticallyAmbiguous());
		//		assertEquals(2, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("['kw1', 'kw2'+]", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testAmbiguousManyOptional() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID 'kw1' 'kw2'* a2=ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertFalse(trans.involvesUnassignedTokenRuleCalls());
		assertTrue(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("['kw1']", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testAmbiguousAlternative() throws Exception {
		ISynAbsorberState start = getParserRule("Rule: a1=ID ('kw1' 'kw2' | 'kw3') a2=ID;");
		ISynTransition trans = findTransition(start, "a1=ID", "a2=ID");
		assertFalse(trans.involvesUnassignedTokenRuleCalls());
		assertTrue(trans.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("['kw3']", trans.getShortestPathToAbsorber(newStack()).toString());
	}

	@Test
	public void testAmbiguousRecursion() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		ISynAbsorberState start = getParserRule(grammar.toString(), "Prim", "Val");

		ISynTransition trans1 = findTransition(start, "start", "name=ID");
		assertFalse(trans1.involvesUnassignedTokenRuleCalls());
		assertTrue(trans1.isSyntacticallyAmbiguous());
		//		assertEquals(1, trans1.getDistanceWithStackToAbsorber(newStack()));
		assertEquals("[{Val}]", trans1.getShortestPathToAbsorber(newStack()).toString());

		RuleCallStack stack2 = newStack();
		ISynTransition trans2 = findTransition(start, "name=ID", "stop");
		assertFalse(trans2.involvesUnassignedTokenRuleCalls());
		assertFalse(trans2.isSyntacticallyAmbiguous());
		//		assertEquals(0, trans2.getDistanceWithStackToAbsorber(stack2));
		assertEquals("[]", trans2.getShortestPathToAbsorber(stack2).toString());

		RuleCallStack stack3 = newStack(trans1, ">>Addition", ">>Prim");
		ISynTransition trans3 = findTransition(start, "name=ID", "stop");
		assertFalse(trans3.involvesUnassignedTokenRuleCalls());
		assertFalse(trans3.isSyntacticallyAmbiguous());
		//		assertEquals(3, trans3.getDistanceWithStackToAbsorber(stack3));
		assertEquals("[<<Prim, <<Addition, ')']", trans3.getShortestStackpruningPathToAbsorber(stack3).toString());
	}
}
