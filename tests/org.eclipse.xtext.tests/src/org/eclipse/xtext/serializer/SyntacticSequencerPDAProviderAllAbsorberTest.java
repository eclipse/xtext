/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerPDAProviderAllAbsorberTest extends AbstractSyntacticSequencerPDAProviderTest {

	@Override
	protected SyntacticSequencerPDAProvider createSequenceParserPDAProvider() {
		return new SyntacticSequencerPDAProvider() {
			@Override
			protected boolean isOptionalAbsorber(AbstractElement ele) {
				return true;
			}
		};
	}

	public void testKeyword() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' a2=ID\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testKeywordOptional() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'? a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' 'kw2'?\n");
		expected.append("  'kw1' 'kw2'? a2=ID\n");
		expected.append("  'kw1' a2=ID\n");
		expected.append("  'kw2'? a2=ID\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' 'kw2'?\n");
		expected.append("  a1=ID 'kw1' 'kw2'? a2=ID !a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testKeywordMany() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'+ a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' 'kw2'+\n");
		expected.append("  'kw1' 'kw2'+ !'kw2'+ a2=ID\n");
		expected.append("  'kw2'+ 'kw2'+\n");
		expected.append("  'kw2'+ 'kw2'+ !'kw2'+ a2=ID\n");
		expected.append("  'kw2'+ a2=ID\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' 'kw2'+\n");
		expected.append("  a1=ID 'kw1' 'kw2'+ !'kw2'+ a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testKeywordOptionalMany() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'* a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' 'kw2'*\n");
		expected.append("  'kw1' 'kw2'* !'kw2'* a2=ID\n");
		expected.append("  'kw1' a2=ID\n");
		expected.append("  'kw2'* 'kw2'*\n");
		expected.append("  'kw2'* 'kw2'* !'kw2'* a2=ID\n");
		expected.append("  'kw2'* a2=ID\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' 'kw2'*\n");
		expected.append("  a1=ID 'kw1' 'kw2'* !'kw2'* a2=ID !a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testKeywordAlternative() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' | 'kw2') a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' a2=ID\n");
		expected.append("  'kw2' a2=ID\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' a2=ID\n");
		expected.append("  a1=ID 'kw2'\n");
		expected.append("  a1=ID 'kw2' a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testKeywordAllMandatory() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' a2=ID | 'kw2' a2=ID 'kw3');");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  'kw1' a2=ID\n");
		expected.append("  'kw2' a2=ID\n");
		expected.append("  'kw3' stop\n");
		expected.append("  a1=ID 'kw1'\n");
		expected.append("  a1=ID 'kw1' a2=ID\n");
		expected.append("  a1=ID 'kw2'\n");
		expected.append("  a1=ID 'kw2' a2=ID\n");
		expected.append("  a2=ID 'kw3'\n");
		expected.append("  a2=ID 'kw3' stop\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testUnassignedRuleCall1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub;\n");
		grammar.append("Sub: val=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Sub_Model:\n");
		expected.append("  <<Sub stop\n");
		expected.append("  >>Sub val=ID\n");
		expected.append("  start >>Sub\n");
		expected.append("  start >>Sub val=ID\n");
		expected.append("  val=ID <<Sub\n");
		expected.append("  val=ID <<Sub stop\n");
		expected.append("Sub_Sub:\n");
		expected.append("  start val=ID\n");
		expected.append("  val=ID stop");
		assertEquals(expected.toString(), actual);
	}

	public void testUnassignedRuleCall2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'kw1' Sub 'kw4';\n");
		grammar.append("Sub: 'kw2' val=ID 'kw3';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Sub_Model:\n");
		expected.append("  'kw1' >>Sub\n");
		expected.append("  'kw1' >>Sub 'kw2'\n");
		expected.append("  'kw1' >>Sub 'kw2' val=ID\n");
		expected.append("  'kw2' val=ID\n");
		expected.append("  'kw3' <<Sub\n");
		expected.append("  'kw3' <<Sub 'kw4'\n");
		expected.append("  'kw3' <<Sub 'kw4' stop\n");
		expected.append("  'kw4' stop\n");
		expected.append("  <<Sub 'kw4'\n");
		expected.append("  <<Sub 'kw4' stop\n");
		expected.append("  >>Sub 'kw2'\n");
		expected.append("  >>Sub 'kw2' val=ID\n");
		expected.append("  start 'kw1'\n");
		expected.append("  start 'kw1' >>Sub\n");
		expected.append("  start 'kw1' >>Sub 'kw2'\n");
		expected.append("  start 'kw1' >>Sub 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3'\n");
		expected.append("  val=ID 'kw3' <<Sub\n");
		expected.append("  val=ID 'kw3' <<Sub 'kw4'\n");
		expected.append("  val=ID 'kw3' <<Sub 'kw4' stop\n");
		expected.append("Sub_Sub:\n");
		expected.append("  'kw2' val=ID\n");
		expected.append("  'kw3' stop\n");
		expected.append("  start 'kw2'\n");
		expected.append("  start 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3'\n");
		expected.append("  val=ID 'kw3' stop");
		assertEquals(expected.toString(), actual);
	}

	public void testAssignedRuleCall2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'kw1' sub=Sub 'kw4';\n");
		grammar.append("Sub: 'kw2' val=ID 'kw3';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model_Model:\n");
		expected.append("  'kw1' sub=Sub\n");
		expected.append("  'kw4' stop\n");
		expected.append("  start 'kw1'\n");
		expected.append("  start 'kw1' sub=Sub\n");
		expected.append("  sub=Sub 'kw4'\n");
		expected.append("  sub=Sub 'kw4' stop\n");
		expected.append("Sub_Sub:\n");
		expected.append("  'kw2' val=ID\n");
		expected.append("  'kw3' stop\n");
		expected.append("  start 'kw2'\n");
		expected.append("  start 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3'\n");
		expected.append("  val=ID 'kw3' stop");
		assertEquals(expected.toString(), actual);
	}

	//	public void testUnassignedRuleCallNested1() throws Exception {
	//		StringBuilder grammar = new StringBuilder();
	//		grammar.append("Model: start=ID Sub1 val1=ID;\n");
	//		grammar.append("Sub1: 'sub1' Sub2 val2=ID;\n");
	//		grammar.append("Sub2: 'sub2' Sub3 val3=ID;\n");
	//		grammar.append("Sub3: 'sub3' val4=ID;\n");
	//		String actual = getParserRule(grammar.toString());
	//		StringBuilder expected = new StringBuilder();
	//		expected.append("'sub1' >>Sub2\n");
	//		expected.append("'sub1' >>Sub2 'sub2'\n");
	//		expected.append("'sub1' >>Sub2 'sub2' >>Sub3\n");
	//		expected.append("'sub1' >>Sub2 'sub2' >>Sub3 'sub3'\n");
	//		expected.append("'sub1' >>Sub2 'sub2' >>Sub3 'sub3' val4=ID\n");
	//		expected.append("'sub2' >>Sub3\n");
	//		expected.append("'sub2' >>Sub3 'sub3'\n");
	//		expected.append("'sub2' >>Sub3 'sub3' val4=ID\n");
	//		expected.append("'sub3' val4=ID\n");
	//		expected.append("<<Sub1 val1=ID\n");
	//		expected.append("<<Sub2 val2=ID\n");
	//		expected.append("<<Sub3 val3=ID\n");
	//		expected.append(">>Sub1 'sub1'\n");
	//		expected.append(">>Sub1 'sub1' >>Sub2\n");
	//		expected.append(">>Sub1 'sub1' >>Sub2 'sub2'\n");
	//		expected.append(">>Sub1 'sub1' >>Sub2 'sub2' >>Sub3\n");
	//		expected.append(">>Sub1 'sub1' >>Sub2 'sub2' >>Sub3 'sub3'\n");
	//		expected.append(">>Sub1 'sub1' >>Sub2 'sub2' >>Sub3 'sub3' val4=ID\n");
	//		expected.append(">>Sub2 'sub2'\n");
	//		expected.append(">>Sub2 'sub2' >>Sub3\n");
	//		expected.append(">>Sub2 'sub2' >>Sub3 'sub3'\n");
	//		expected.append(">>Sub2 'sub2' >>Sub3 'sub3' val4=ID\n");
	//		expected.append(">>Sub3 'sub3'\n");
	//		expected.append(">>Sub3 'sub3' val4=ID\n");
	//		expected.append("start start=ID\n");
	//		expected.append("start=ID >>Sub1\n");
	//		expected.append("start=ID >>Sub1 'sub1'\n");
	//		expected.append("start=ID >>Sub1 'sub1' >>Sub2\n");
	//		expected.append("start=ID >>Sub1 'sub1' >>Sub2 'sub2'\n");
	//		expected.append("start=ID >>Sub1 'sub1' >>Sub2 'sub2' >>Sub3\n");
	//		expected.append("start=ID >>Sub1 'sub1' >>Sub2 'sub2' >>Sub3 'sub3'\n");
	//		expected.append("start=ID >>Sub1 'sub1' >>Sub2 'sub2' >>Sub3 'sub3' val4=ID\n");
	//		expected.append("val1=ID stop\n");
	//		expected.append("val2=ID <<Sub1\n");
	//		expected.append("val2=ID <<Sub1 val1=ID\n");
	//		expected.append("val3=ID <<Sub2\n");
	//		expected.append("val3=ID <<Sub2 val2=ID\n");
	//		expected.append("val4=ID <<Sub3\n");
	//		expected.append("val4=ID <<Sub3 val3=ID");
	//		assertEquals(expected.toString(), actual);
	//	}

	public void testAssignedRuleCallNested1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: start=ID sub1=Sub1 val1=ID;\n");
		grammar.append("Sub1: 'sub1' sub2=Sub2 val2=ID;\n");
		grammar.append("Sub2: 'sub2' sub3=Sub3 val3=ID;\n");
		grammar.append("Sub3: 'sub3' val4=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model_Model:\n");
		expected.append("  start start=ID\n");
		expected.append("  start=ID sub1=Sub1\n");
		expected.append("  sub1=Sub1 val1=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("Sub1_Sub1:\n");
		expected.append("  'sub1' sub2=Sub2\n");
		expected.append("  start 'sub1'\n");
		expected.append("  start 'sub1' sub2=Sub2\n");
		expected.append("  sub2=Sub2 val2=ID\n");
		expected.append("  val2=ID stop\n");
		expected.append("Sub2_Sub2:\n");
		expected.append("  'sub2' sub3=Sub3\n");
		expected.append("  start 'sub2'\n");
		expected.append("  start 'sub2' sub3=Sub3\n");
		expected.append("  sub3=Sub3 val3=ID\n");
		expected.append("  val3=ID stop\n");
		expected.append("Sub3_Sub3:\n");
		expected.append("  'sub3' val4=ID\n");
		expected.append("  start 'sub3'\n");
		expected.append("  start 'sub3' val4=ID\n");
		expected.append("  val4=ID stop");
		assertEquals(expected.toString(), actual);
	}

	public void testAssignedElements() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: t=MyTerminal 'kw1' d=MyDatatype 'kw2' e=MyEnum 'kw3' k='kw4' 'kw5' b='kw6'? \n");
		grammar.append("       c1=[Model|MyTerminal] 'kw7' c2=[Model|MyDatatype] 'kw8' c3=[Model|'kw9'];\n");
		grammar.append("terminal MyTerminal: '$' ('a'..'z')+;\n");
		grammar.append("MyDatatype: 'kw1' | 'kw2';\n");
		grammar.append("enum MyEnum: kw1 | kw2;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model_Model:\n");
		expected.append("  'kw1' d=MyDatatype\n");
		expected.append("  'kw2' e=MyEnum\n");
		expected.append("  'kw3' k='kw4'\n");
		expected.append("  'kw5' b='kw6'\n");
		expected.append("  'kw5' c1=[Model|MyTerminal]\n");
		expected.append("  'kw7' c2=[Model|MyDatatype]\n");
		expected.append("  'kw8' c3=[Model|'kw9']\n");
		expected.append("  b='kw6' c1=[Model|MyTerminal]\n");
		expected.append("  c1=[Model|MyTerminal] 'kw7'\n");
		expected.append("  c1=[Model|MyTerminal] 'kw7' c2=[Model|MyDatatype]\n");
		expected.append("  c2=[Model|MyDatatype] 'kw8'\n");
		expected.append("  c2=[Model|MyDatatype] 'kw8' c3=[Model|'kw9']\n");
		expected.append("  c3=[Model|'kw9'] stop\n");
		expected.append("  d=MyDatatype 'kw2'\n");
		expected.append("  d=MyDatatype 'kw2' e=MyEnum\n");
		expected.append("  e=MyEnum 'kw3'\n");
		expected.append("  e=MyEnum 'kw3' k='kw4'\n");
		expected.append("  k='kw4' 'kw5'\n");
		expected.append("  k='kw4' 'kw5' b='kw6'\n");
		expected.append("  k='kw4' 'kw5' c1=[Model|MyTerminal]\n");
		expected.append("  start t=MyTerminal\n");
		expected.append("  t=MyTerminal 'kw1'\n");
		expected.append("  t=MyTerminal 'kw1' d=MyDatatype");
		assertEquals(expected.toString(), actual);
	}

}
