/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Pair;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarConstraintProviderTest extends AbstractXtextTests {

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

		Map<ISerializationContext, IConstraint> constraints = gcp.getConstraints(grammar);
		List<Pair<List<ISerializationContext>, IConstraint>> grouped = SerializationContext.groupByEqualityAndSort(constraints);
		List<String> result = Lists.newArrayList();
		for (Pair<List<ISerializationContext>, IConstraint> r : grouped) {
			result.add(r.getFirst() + ":");
			result.add("  " + r.getSecond());
		}
		return Joiner.on("\n").join(result);
	}

	@Test
	public void testKeywords() throws Exception {
		String actual = getParserRule("Rule: 'kw1' a1='a1' a2+='a2'* a3+='a3'+ a4+='a4'?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1='a1' a2+='a2'* a3+='a3'+ a4+='a4'?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testTerminals() throws Exception {
		String actual = getParserRule("Rule: ID a1=ID a2+=ID* a3+=ID+ a4+=ID?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=ID a2+=ID* a3+=ID+ a4+=ID?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testDatatype() throws Exception {
		String actual = getParserRule("Rule: DT a1=DT a2+=DT* a3+=DT+ a4+=DT?; DT: ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=DT a2+=DT* a3+=DT+ a4+=DT?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testEnum() throws Exception {
		String actual = getParserRule("Rule: a1=EN a2+=EN* a3+=EN+ a4+=EN?; enum EN: foo | bar;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=EN a2+=EN* a3+=EN+ a4+=EN?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testCrossRef1() throws Exception {
		String actual = getParserRule("Rule: a1=[Rule|ID] a2+=[Rule|ID]* a3+=[Rule|ID]+ a4+=[Rule|ID]?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=[Rule|ID] a2+=[Rule|ID]* a3+=[Rule|ID]+ a4+=[Rule|ID]?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testCrossRef2() throws Exception {
		String actual = getParserRule("Rule: a1=[Rule] a2+=[Rule]* a3+=[Rule]+ a4+=[Rule]?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=[Rule|ID] a2+=[Rule|ID]* a3+=[Rule|ID]+ a4+=[Rule|ID]?);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testCrossRef3() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Rule: a1=[Rule|TERMINAL_RULE] a2=[Rule|DatatypeRule] a3=[Rule|EnumRule];\n");
		grammar.append("terminal TERMINAL_RULE: 'a'..'z';\n");
		grammar.append("DatatypeRule: ID;\n");
		grammar.append("enum EnumRule: foo;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (a1=[Rule|TERMINAL_RULE] a2=[Rule|DatatypeRule] a3=[Rule|EnumRule]);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testIgnoredRules() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("ParserRule: foo=INT term=TERMINAL_RULE dat=DatatypeRule en=EnumRule;\n");
		grammar.append("terminal TERMINAL_RULE: 'a'..'z';\n");
		grammar.append("DatatypeRule: ID;\n");
		grammar.append("enum EnumRule: foo;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("ParserRule returns ParserRule:\n");
		expected.append("  ParserRule_ParserRule returns ParserRule: (foo=INT term=TERMINAL_RULE dat=DatatypeRule en=EnumRule);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testInlineGroups() throws Exception {
		String actual = getParserRule("Rule: (x1=ID x2=ID) (x3=ID x4=ID)* (x5=ID x6=ID)? (x7=ID x8=ID)+;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (x1=ID x2=ID (x3=ID x4=ID)* (x5=ID x6=ID)? (x7=ID x8=ID)+);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testInlineAlternatives() throws Exception {
		String actual = getParserRule("Rule: (x1=ID | x2=ID) | (x3=ID | x4=ID)* | (x5=ID | x6=ID)? | (x7=ID | x8=ID)+;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (\n");
		expected.append("    x1=ID | \n");
		expected.append("    x2=ID | \n");
		expected.append("    (x3=ID | x4=ID)+ | \n");
		expected.append("    x5=ID | \n");
		expected.append("    x6=ID | \n");
		expected.append("    (x7=ID | x8=ID)+\n");
		expected.append(");\n");
		expected.append("Rule returns null:\n");
		expected.append("  Rule_null returns null: {null};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	@Ignore
	public void testEmptyAlternatives() throws Exception {
		String actual = getParserRule("Rule: (x1=ID | x2=ID | 'foo') (x3=ID | x4=ID | 'foo' | 'bar');");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule: Rule_Rule | Rule_null;\n");
		expected.append("  Rule_Rule returns Rule: ((x1=ID | x2=ID)? (x3=ID | x4=ID)?);\n");
		expected.append("  Rule_null returns null: {null};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	@Ignore
	public void testDoubleMulti() throws Exception {
		String actual = getParserRule("Rule: x1=ID* x2=ID*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule: Rule_Rule | Rule_null;\n");
		expected.append("  Rule_Rule returns Rule: ((x1=ID+ x2=ID+) | x1=ID+ | x2=ID+);\n");
		expected.append("  Rule_null returns null: {null};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAssignedAlternatives1() throws Exception {
		String actual = getParserRule("Rule: a1=(ID|'id') a2=(ID|STRING|'bar') a3+=(ID|STRING|'bar')*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: ((a1=ID | a1='id') (a2=ID | a2=STRING | a2='bar') (a3+=ID | a3+=STRING | a3+='bar')*);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAssignedAlternatives2() throws Exception {
		String actual = getParserRule("Rule: a1=(ID|'id') | a2=(ID|STRING|'bar') | a3+=(ID|STRING|'bar')*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (\n");
		expected.append("    a1=ID | \n");
		expected.append("    a1='id' | \n");
		expected.append("    a2=ID | \n");
		expected.append("    a2=STRING | \n");
		expected.append("    a2='bar' | \n");
		expected.append("    (a3+=ID | a3+=STRING | a3+='bar')+\n");
		expected.append(");\n");
		expected.append("Rule returns null:\n");
		expected.append("  Rule_null returns null: {null};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testBooleanAlternative() throws Exception {
		String actual = getParserRule("Rule: {Rule} ('false' | isTrue?='true');");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: isTrue?='true'?;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub;\n");
		grammar.append("Sub: val=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub, Sub returns Sub:\n");
		expected.append("  Sub_Sub returns Sub: val=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: (Sub1 | Sub2) name=ID 'kw1';\n");
		grammar.append("Sub1: 'sub1' val1=ID;\n");
		grammar.append("Sub2: 'sub2' val2=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub1:\n");
		expected.append("  Model_Sub1_Sub1 returns Sub1: (val1=ID name=ID);\n");
		expected.append("Model returns Sub2:\n");
		expected.append("  Model_Sub2_Sub2 returns Sub2: (val2=ID name=ID);\n");
		expected.append("Sub1 returns Sub1:\n");
		expected.append("  Sub1_Sub1 returns Sub1: val1=ID;\n");
		expected.append("Sub2 returns Sub2:\n");
		expected.append("  Sub2_Sub2 returns Sub2: val2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall3() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: (Sub1 | Sub2)? name=ID 'kw1';\n");
		grammar.append("Sub1: 'sub1' val1=ID;\n");
		grammar.append("Sub2: 'sub2' val2=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  Model_Model returns Model: name=ID;\n");
		expected.append("Model returns Sub1:\n");
		expected.append("  Model_Sub1_Sub1 returns Sub1: (val1=ID name=ID);\n");
		expected.append("Model returns Sub2:\n");
		expected.append("  Model_Sub2_Sub2 returns Sub2: (val2=ID name=ID);\n");
		expected.append("Sub1 returns Sub1:\n");
		expected.append("  Sub1_Sub1 returns Sub1: val1=ID;\n");
		expected.append("Sub2 returns Sub2:\n");
		expected.append("  Sub2_Sub2 returns Sub2: val2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall4() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub1 | Sub2 | Sub3;\n");
		grammar.append("Sub1: 'sub1' val1=ID;\n");
		grammar.append("Sub2: 'sub2' val2=ID;\n");
		grammar.append("Sub3: 'sub3' val3=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub1, Sub1 returns Sub1:\n");
		expected.append("  Sub1_Sub1 returns Sub1: val1=ID;\n");
		expected.append("Model returns Sub2, Sub2 returns Sub2:\n");
		expected.append("  Sub2_Sub2 returns Sub2: val2=ID;\n");
		expected.append("Model returns Sub3, Sub3 returns Sub3:\n");
		expected.append("  Sub3_Sub3 returns Sub3: val3=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCallNested1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub1 val1=ID;\n");
		grammar.append("Sub1: Sub2 val2=ID;\n");
		grammar.append("Sub2: Sub3 val3=ID;\n");
		grammar.append("Sub3: 'sub3' val4=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub3:\n");
		expected.append("  Model_Sub1_Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID val2=ID val1=ID);\n");
		expected.append("Sub1 returns Sub3:\n");
		expected.append("  Sub1_Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID val2=ID);\n");
		expected.append("Sub2 returns Sub3:\n");
		expected.append("  Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID);\n");
		expected.append("Sub3 returns Sub3:\n");
		expected.append("  Sub3_Sub3 returns Sub3: val4=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCallNested2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub1? val1=ID;\n");
		grammar.append("Sub1: Sub2? val2=ID;\n");
		grammar.append("Sub2: Sub3? val3=ID;\n");
		grammar.append("Sub3: 'sub3' val4=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  Model_Model returns Model: val1=ID;\n");
		expected.append("Model returns Sub1:\n");
		expected.append("  Model_Sub1_Sub1 returns Sub1: (val2=ID val1=ID);\n");
		expected.append("Model returns Sub2:\n");
		expected.append("  Model_Sub1_Sub2_Sub2 returns Sub2: (val3=ID val2=ID val1=ID);\n");
		expected.append("Model returns Sub3:\n");
		expected.append("  Model_Sub1_Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID val2=ID val1=ID);\n");
		expected.append("Sub1 returns Sub1:\n");
		expected.append("  Sub1_Sub1 returns Sub1: val2=ID;\n");
		expected.append("Sub1 returns Sub2:\n");
		expected.append("  Sub1_Sub2_Sub2 returns Sub2: (val3=ID val2=ID);\n");
		expected.append("Sub1 returns Sub3:\n");
		expected.append("  Sub1_Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID val2=ID);\n");
		expected.append("Sub2 returns Sub2:\n");
		expected.append("  Sub2_Sub2 returns Sub2: val3=ID;\n");
		expected.append("Sub2 returns Sub3:\n");
		expected.append("  Sub2_Sub3_Sub3 returns Sub3: (val4=ID val3=ID);\n");
		expected.append("Sub3 returns Sub3:\n");
		expected.append("  Sub3_Sub3 returns Sub3: val4=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAction1() throws Exception {
		String actual = getParserRule("Rule: {Rule} val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: val=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAction2() throws Exception {
		String actual = getParserRule("Rule: {Type} val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Type:\n");
		expected.append("  Rule_Type returns Type: val=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAction3() throws Exception {
		String actual = getParserRule("Rule: 'kw1' {Type1} val1=ID | 'kw2' {Type2} val2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Type1:\n");
		expected.append("  Rule_Type1 returns Type1: val1=ID;\n");
		expected.append("Rule returns Type2:\n");
		expected.append("  Rule_Type2 returns Type2: val2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAction4() throws Exception {
		String actual = getParserRule("Rule: 'kw1' {Type1} val1=ID | 'kw2' {Type2} val2=ID | 'kw3' val3=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: val3=ID;\n");
		expected.append("Rule returns Type1:\n");
		expected.append("  Rule_Type1 returns Type1: val1=ID;\n");
		expected.append("Rule returns Type2:\n");
		expected.append("  Rule_Type2 returns Type2: val2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAction5() throws Exception {
		String actual = getParserRule("Rule: 'kw1' {Type1} val1=ID | 'kw2' {Type2} val2=ID | 'kw3' {Type3};");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Type1:\n");
		expected.append("  Rule_Type1 returns Type1: val1=ID;\n");
		expected.append("Rule returns Type2:\n");
		expected.append("  Rule_Type2 returns Type2: val2=ID;\n");
		expected.append("Rule returns Type3:\n");
		expected.append("  Rule_Type3 returns Type3: {Type3};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testReturnsNullAlways() throws Exception {
		String actual = getParserRule("Rule: val1=NullRule val2=ID; NullRule: 'kw1';");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (val1=NullRule val2=ID);");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testReturnsNullSometimes() throws Exception {
		String actual = getParserRule("Rule: val1=NullRule val2=ID; NullRule: 'kw1' | 'kw2' {NullRule};");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  Rule_Rule returns Rule: (val1=NullRule val2=ID);\n");
		expected.append("NullRule returns NullRule:\n");
		expected.append("  NullRule_NullRule returns NullRule: {NullRule};\n");
		expected.append("NullRule returns null:\n");
		expected.append("  NullRule_null returns null: {null};");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testWildcardFragment() throws Exception {
		String actual = getParserRule("Rule: F; fragment F*:name=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  F_Rule returns Rule: name=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testParameters() throws Exception {
		String actual = getParserRule("M: 'kw1' s=S<true> | 'kw2' s=S<false>; S <P>: <P> v1=ID | <!P> v2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("M returns M:\n");
		expected.append("  M_M returns M: (s=S | s=S);\n");
		expected.append("S<P> returns S:\n");
		expected.append("  S$P$true$_S returns S: v1=ID;\n");
		expected.append("S returns S:\n");
		expected.append("  S$P$false$_S returns S: v2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testParameters2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("C: '#34' cpq=R<true, true> cp=R<true, false> cq=R<false, true> c=R<false, false>;\n");
		grammar.append("R<P, Q>: <P> v1=ID | <!P> v2=ID (<Q> v3=ID)?;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("C returns C:\n");
		expected.append("  C_C returns C: (cpq=R cp=R cq=R c=R);\n");
		expected.append("R<P,Q> returns R, R<P> returns R:\n");
		expected.append("  R$P$true$_R returns R: v1=ID;\n");
		expected.append("R<Q> returns R:\n");
		expected.append("  R$P$false$Q$true$_R returns R: (v2=ID v3=ID?);\n");
		expected.append("R returns R:\n");
		expected.append("  R$P$false$Q$false$_R returns R: v2=ID;");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testLonelyAction() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("C: D | foo=ID; D: {C};");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("C returns C:\n");
		expected.append("  C_D_C returns C: foo=ID?;\n");
		expected.append("D returns C:\n");
		expected.append("  D_C returns C: {C};");
		assertEquals(expected.toString(), actual);
	}
}
