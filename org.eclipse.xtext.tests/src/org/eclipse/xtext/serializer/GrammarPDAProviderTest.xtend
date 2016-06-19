/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch
import org.eclipse.xtext.serializer.analysis.IGrammarPDAProvider
import org.eclipse.xtext.serializer.analysis.ISerState
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.eclipse.xtext.util.EmfFormatter
import org.eclipse.xtext.util.formallang.NfaUtil
import org.eclipse.xtext.util.formallang.Pda
import org.eclipse.xtext.util.formallang.PdaListFormatter
import org.eclipse.xtext.util.formallang.PdaToDot
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class GrammarPDAProviderTest {

	@Inject IGrammarPDAProvider pdaProvider
	@Inject ParseHelper<Grammar> parser
	@Inject ValidationTestHelper validator

	@Test def void testUnassignedAction() {
		val actual = '''
			Rule: {Action};
		'''.toPda
		val expected = '''
			Rule:
				start -> {Action}
				{Action} -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testAssignedAction() {
		val actual = '''
			Rule: {Foo} {Action.feat=current};
		'''.toPda
		val expected = '''
			Rule:
				start -> {Foo}
				{Action.feat=} -> stop
				{Foo} -> {Action.feat=}
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testAssignedTerminalRuleCall() {
		val actual = '''
			Rule: name=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> name=ID
				name=ID -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testAssignedEObjectRuleCall() {
		val actual = '''
			Rule: call=Called;
			Called: name=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> call=Called
				call=Called -> stop
			Called:
				start -> name=ID
				name=ID -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testAssignedDatatypeRuleCall() {
		val actual = '''
			Rule: call=Called;
			Called: "foo";
		'''.toPda
		val expected = '''
			Rule:
				start -> call=Called
				call=Called -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedCalledAction() {
		val actual = '''
			Rule: D1 | D2;
			D1: 'd1' A;
			D2: 'd2' A;
			A: f1=ID {A.l=current} f2=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> >>D1, >>D2
				'd1' -> >>A
				'd2' -> >>A
				<<A -> <<D1
				<<A -> <<D2
				<<D1 -> stop
				<<D2 -> stop
				>>A -> f1=ID
				>>A -> f1=ID
				>>D1 -> 'd1'
				>>D2 -> 'd2'
				f1=ID -> {A.l=}
				f2=ID -> <<A, <<A
				{A.l=} -> f2=ID
			D1:
				start -> 'd1'
				'd1' -> >>A
				<<A -> stop
				>>A -> f1=ID
				f1=ID -> {A.l=}
				f2=ID -> <<A
				{A.l=} -> f2=ID
			D2:
				start -> 'd2'
				'd2' -> >>A
				<<A -> stop
				>>A -> f1=ID
				f1=ID -> {A.l=}
				f2=ID -> <<A
				{A.l=} -> f2=ID
			A:
				start -> f1=ID
				f1=ID -> {A.l=}
				f2=ID -> stop
				{A.l=} -> f2=ID
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedFragmentRuleCall() {
		val actual = '''
			Rule: Called;
			fragment Called returns Abstract: name=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> >>Called
				<<Called -> stop
				>>Called -> name=ID
				name=ID -> <<Called
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedDatatypeRule() {
		val actual = '''
			Rule: val=ID Called;
			Called: 'kw1';
		'''.toPda
		val expected = '''
			Rule:
				start -> val=ID
				Called -> stop
				val=ID -> Called
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedTerminalRule() {
		val actual = '''
			Rule: val=ID Called;
			terminal Called: 'kw1';
		'''.toPda
		val expected = '''
			Rule:
				start -> val=ID
				Called -> stop
				val=ID -> Called
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedParserRuleCall() {
		val actual = '''
			Rule: Called;
			Called returns Sub: name=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> >>Called
				<<Called -> stop
				>>Called -> name=ID
				name=ID -> <<Called
			Called:
				start -> name=ID
				name=ID -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnassignedWildcardFragmentRuleCall() {
		val actual = '''
			Rule: Called;
			fragment Called*: name=ID;
		'''.toPda
		val expected = '''
			Rule:
				start -> >>Called
				<<Called -> stop
				>>Called -> name=ID
				name=ID -> <<Called
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testGroup() {
		val actual = '''
			Rule: {Rule} 'a' 'b' 'c';
		'''.toPda
		val expected = '''
			Rule:
				start -> {Rule}
				'a' -> 'b'
				'b' -> 'c'
				'c' -> stop
				{Rule} -> 'a'
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testAlternative() {
		val actual = '''
			Rule: {Rule} ('a' | 'b' | 'c');
		'''.toPda
		val expected = '''
			Rule:
				start -> {Rule}
				'a' -> stop
				'b' -> stop
				'c' -> stop
				{Rule} -> 'a', 'b', 'c'
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnorderedGroup() {
		val actual = '''
			Rule: {Rule} ('a' & 'b' & 'c');
		'''.toPda
		val expected = '''
			Rule:
				start -> {Rule}
				'a' -> 'a', 'b', 'c', stop
				'b' -> 'a', 'b', 'c', stop
				'c' -> 'a', 'b', 'c', stop
				{Rule} -> 'a', 'b', 'c'
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testUnorderedGroup2() {
		val actual = '''
			Rule: {Rule} ('a' & 'b'? & 'c'* & 'd'+);
		'''.toPda
		val expected = '''
			Rule:
				start -> {Rule}
				'a' -> 'a', 'b', 'c', 'd', stop
				'b' -> 'a', 'b', 'c', 'd', stop
				'c' -> 'a', 'b', 'c', 'd', stop
				'd' -> 'a', 'b', 'c', 'd', stop
				{Rule} -> 'a', 'b', 'c', 'd'
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testTwoAssignedEObjectRuleCalls() {
		val actual = '''
			Rule: foo1=Sub foo2=Sub; Sub: id='id';
		'''.toPda
		val expected = '''
			Rule:
				start -> foo1=Sub
				foo1=Sub -> foo2=Sub
				foo2=Sub -> stop
			Sub:
				start -> id='id'
				id='id' -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testRecursion() {
		val actual = '''
			Recursion: val=ID | '(' Recursion ')';
		'''.toPda
		val expected = '''
			Recursion:
				start -> '(', val=ID
				'(' -> >>Recursion
				')' -> <<Recursion, stop
				<<Recursion -> ')'
				>>Recursion -> '(', val=ID
				val=ID -> <<Recursion, stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testExpression1() {
		val actual = '''
			Exp: 'kw' Addit; Addit returns Exp: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Exp: {Val} val=ID;
		'''.toPda
		val expected = '''
			Exp:
				start -> 'kw'
				'+' -> right=Prim
				'kw' -> >>Addit
				<<Addit -> stop
				<<Prim -> <<Addit, {Add.left=}
				>>Addit -> >>Prim
				>>Prim -> {Val}
				right=Prim -> <<Addit, {Add.left=}
				val=ID -> <<Prim
				{Add.left=} -> '+'
				{Val} -> val=ID
			Addit:
				start -> >>Prim
				'+' -> right=Prim
				<<Prim -> stop, {Add.left=}
				>>Prim -> {Val}
				right=Prim -> stop, {Add.left=}
				val=ID -> <<Prim
				{Add.left=} -> '+'
				{Val} -> val=ID
			Prim:
				start -> {Val}
				val=ID -> stop
				{Val} -> val=ID
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testActionAlternative() {
		val actual = '''
			Greeting: '(' Greeting ')' {Foo.child=current} | val=ID;
		'''.toPda
		val expected = '''
			Greeting:
				start -> '(', val=ID
				'(' -> >>Greeting
				')' -> {Foo.child=}
				<<Greeting -> ')'
				>>Greeting -> '(', val=ID
				val=ID -> <<Greeting, stop
				{Foo.child=} -> <<Greeting, stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test @Ignore def void testFragmentWithAction() {
		val actual = '''
			R: f1=ID F; fragment F returns R: {A.prev=current} f2=ID;
		'''.toPda
		val expected = '''
			R:
				start -> f1=ID
				<<F -> stop
				>>F -> {A.prev=}
				f1=ID -> >>F
				f2=ID -> <<F
				{A.prev=} -> f2=ID
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test @Ignore def void testFragmentWithAction2() {
		val actual = '''
			R: 'kw1a' f1=ID 'kw1b' F; fragment F returns R: 'kw2a' {A.prev=current} 'kw2b' f2=ID 'kw2c';
		'''.toPda
		val expected = '''
			R:
				start -> f1=ID
				<<F -> stop
				>>F -> {A.prev=}
				f1=ID -> >>F
				f2=ID -> <<F
				{A.prev=} -> f2=ID
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testParameter1() {
		val actual = '''
			M: "kw1" s=S<true> | "kw2" s=S<false>;
			S <P>: <P> v1=ID | <!P> v2=ID;  
		'''.toPda
		val expected = '''
			M:
				start -> 'kw1', 'kw2'
				'kw1' -> (s=S|)
				'kw2' -> (|s=S)
				(s=S|) -> stop
				(|s=S) -> stop
			S<P>:
				start -> v1=ID
				v1=ID -> stop
			S:
				start -> v2=ID
				v2=ID -> stop
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testDoubleFragment() {
		val actual = '''
			R: F1 F2;
			fragment F1: f1=ID;  
			fragment F2: f2=ID;  
		'''.toPda
		val expected = '''
			R:
				start -> >>F1
				<<F1 -> >>F2
				<<F2 -> stop
				>>F1 -> f1=ID
				>>F2 -> f2=ID
				f1=ID -> <<F1
				f2=ID -> <<F2
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testFragmentLoop() {
		val actual = '''
			R: F+;
			fragment F: f+=ID;  
		'''.toPda
		val expected = '''
			R:
				start -> >>F
				<<F -> >>F, stop
				>>F -> f+=ID
				f+=ID -> <<F
		'''
		Assert.assertEquals(expected, actual)
	}

	@Test def void testParameterizedDoubleDelegation() {
		val actual = '''
			R: F<true> | F<false>;
			fragment F<X>: f+=ID;
		'''.toPda
		val expected = '''
			R:
				start -> >>F, >>F
				<<F -> stop
				<<F -> stop
				>>F -> f+=ID
				>>F -> f+=ID
				f+=ID -> <<F, <<F
		'''
		Assert.assertEquals(expected, actual)
	}

	def private String toPda(CharSequence rulesText) {
		val grammar = parser.parse('''
			grammar org.eclipse.xtext.serializer.GrammarPDAProviderTestLanguage with org.eclipse.xtext.common.Terminals
			
			generate GrammarPDAProviderTest "http://www.eclipse.org/2010/tmf/xtext/GrammarPDAProviderTestLanguage"
			
			«rulesText»
		''')
		validator.assertNoErrors(grammar)
		val pdas = pdaProvider.getGrammarPDAs(grammar)
		pdas.values.forEach[assertNoLeakedGrammarElements(grammar, it)]

//		pdas.forEach[p1, p2|p2.toDot(p1.name)]
		return pdas.keySet.sort.map [
			'''
				«it»:
					«pdas.get(it).toListString»
			'''
		].join
	}

	def private void assertNoLeakedGrammarElements(Grammar grammar, Pda<ISerState, RuleCall> pda) {
		for (ele : new NfaUtil().collect(pda).map[grammarElement].filterNull) {
			val actual = GrammarUtil.getGrammar(ele)
			if (actual !== grammar) {
				Assert.fail("Element " + EmfFormatter.objPath(ele) + " leaked!")
			}
		}
	}

	def protected toDot(Pda<ISerState, RuleCall> pda, String name) {
		val test = Thread.currentThread.stackTrace.get(6).methodName
		new PdaToDot().draw(pda, "dot2/" + test + "_" + name + ".pdf", "-T pdf")

	}

	def private toListString(Pda<ISerState, RuleCall> pda) {
		val ts = new GrammarElementTitleSwitch().showAssignments().hideCardinality().showQualified()
		val formatter = new PdaListFormatter<ISerState, RuleCall>();
		formatter.setStateFormatter [
			switch (type) { case START: "start" case STOP: "stop" default: ts.apply(grammarElement) }
		];
		formatter.setStackitemFormatter(new GrammarElementTitleSwitch().showAssignments().hideCardinality());
		formatter.sortFollowers();
		return formatter.format(pda) + "\n"
	}
}