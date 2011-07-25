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
public class SyntacticSequencerPDAProviderMinimalAbsorberTest extends AbstractSyntacticSequencerPDAProviderTest {

	@Override
	protected SyntacticSequencerPDAProvider createSequenceParserPDAProvider() {
		return new SyntacticSequencerPDAProvider() {
			@Override
			protected boolean isOptionalAbsorber(AbstractElement ele) {
				return false;
			}
		};
	}

	//	public void testXtext() {
	//		Grammar grammar = get(IGrammarAccess.class).getGrammar();
	//		try {
	//			new SequenceParserNDA2Dot().draw(grammar, "pdf/" + getName() + "-NFA.pdf", "-T pdf");
	//			SequenceParserPDA2Dot.drawGrammar(createSequenceParserPDAProvider(), "pdf/xtext", get(IGrammarAccess.class)
	//					.getGrammar());
	//			//			long time = System.currentTimeMillis();
	//			//				System.out.println(new SequenceParserPDA2Dot(createSequenceParserPDAProvider()).draw(grammar));
	//			//				System.out.println((System.currentTimeMillis() - time) + " msec");
	//		} catch (IOException e) {
	//		}
	//	}

	public void testRecursion() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Recursion: val=ID | '(' Recursion ')';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Recursion_Recursion:\n");
		expected.append("  start '(' >>Recursion !'(' val=ID\n");
		expected.append("  start val=ID\n");
		expected.append("  val=ID <<Recursion ')' !<<Recursion stop\n");
		expected.append("  val=ID stop");
		assertEquals(expected.toString(), actual);
	}

	public void testReturnChoices() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub1 | Sub2;\n");
		grammar.append("Sub1: 'in1' Infix 'out1';\n");
		grammar.append("Sub2: 'in2' Infix 'out2';\n");
		grammar.append("Sub3: 'in3' Infix 'out3';\n");
		grammar.append("Infix: val=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Infix_Infix:\n");
		expected.append("  start val=ID\n");
		expected.append("  val=ID stop\n");
		expected.append("Infix_Model:\n");
		expected.append("  start >>Sub1 'in1' >>Infix val=ID\n");
		expected.append("  start >>Sub2 'in2' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out1' <<Sub1 stop\n");
		expected.append("  val=ID <<Infix 'out2' <<Sub2 stop\n");
		expected.append("Infix_Sub1:\n");
		expected.append("  start 'in1' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out1' stop\n");
		expected.append("Infix_Sub2:\n");
		expected.append("  start 'in2' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out2' stop\n");
		expected.append("Infix_Sub3:\n");
		expected.append("  start 'in3' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out3' stop");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression0() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Add_Addition:\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Add_Addition_Add_1_0:\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Val_Addition:\n");
		expected.append("  name=ID <<Prim stop\n");
		expected.append("  start >>Prim {Val} name=ID\n");
		expected.append("Val_Addition_Add_1_0:\n");
		expected.append("  name=ID <<Prim stop\n");
		expected.append("  start >>Prim {Val} name=ID\n");
		expected.append("Val_Prim:\n");
		expected.append("  name=ID stop\n");
		expected.append("  start {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Add_Addition:\n");
		expected.append("  right=Prim <<Addition ')' <<Prim !<<Addition stop\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition !>>Prim {Add.left=}\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Add_Addition_Add_1_0:\n");
		expected.append("  right=Prim <<Addition ')' <<Prim !<<Addition stop\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition !>>Prim {Add.left=}\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Add_Prim:\n");
		expected.append("  right=Prim <<Addition ')' <<Prim !<<Addition stop\n");
		expected.append("  start '(' >>Addition >>Prim !'(' {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Val_Addition:\n");
		expected.append("  name=ID <<Prim <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition !>>Prim {Val} name=ID\n");
		expected.append("Val_Addition_Add_1_0:\n");
		expected.append("  name=ID <<Prim <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition !>>Prim {Val} name=ID\n");
		expected.append("Val_Prim:\n");
		expected.append("  name=ID <<Prim <<Addition ')' !<<Prim stop\n");
		expected.append("  name=ID stop\n");
		expected.append("  start '(' >>Addition >>Prim !'(' {Val} name=ID\n");
		expected.append("  start {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testOptionalEnd() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'model' foo=AbstractRule;\n");
		grammar.append("AbstractRule: Rule1 | Rule2;\n");
		grammar.append("Rule1: 'r1' foo1=ID ('as' alias1+=ID)?;\n");
		grammar.append("Rule2: 'r2' foo2=ID ('as' alias2+=ID)*;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model_Model:\n");
		expected.append("  foo=AbstractRule stop\n");
		expected.append("  start 'model' foo=AbstractRule\n");
		expected.append("Rule1_AbstractRule:\n");
		expected.append("  alias1+=ID <<Rule1 stop\n");
		expected.append("  foo1=ID 'as' alias1+=ID\n");
		expected.append("  foo1=ID <<Rule1 stop\n");
		expected.append("  start >>Rule1 'r1' foo1=ID\n");
		expected.append("Rule1_Rule1:\n");
		expected.append("  alias1+=ID stop\n");
		expected.append("  foo1=ID 'as' alias1+=ID\n");
		expected.append("  foo1=ID stop\n");
		expected.append("  start 'r1' foo1=ID\n");
		expected.append("Rule2_AbstractRule:\n");
		expected.append("  alias2+=ID 'as' alias2+=ID\n");
		expected.append("  alias2+=ID <<Rule2 stop\n");
		expected.append("  foo2=ID 'as' alias2+=ID\n");
		expected.append("  foo2=ID <<Rule2 stop\n");
		expected.append("  start >>Rule2 'r2' foo2=ID\n");
		expected.append("Rule2_Rule2:\n");
		expected.append("  alias2+=ID 'as' alias2+=ID\n");
		expected.append("  alias2+=ID stop\n");
		expected.append("  foo2=ID 'as' alias2+=ID\n");
		expected.append("  foo2=ID stop\n");
		expected.append("  start 'r2' foo2=ID");
		assertEquals(expected.toString(), actual);
	}

	// TODO: fixme: this fails randomly
	public void disabled_testExpression4() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: x1=Exp1;\n");
		grammar.append("Exp1: '#3' Addition1;\n");
		grammar.append("Addition1 returns Exp1: Prim1 ({Add1.left=current} '+' right=Prim1)*;\n");
		grammar.append("Prim1 returns Exp1: {Val1} name=ID | '(' Addition1 ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model:\n");
		expected.append("  start x1=Exp1\n");
		expected.append("  x1=Exp1 stop\n");
		expected.append("Exp1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 stop <<Addition1 ')' !<<Prim1\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 <<Addition1 stop !<<Addition1\n");
		expected.append("  right=Prim1 <<Addition1 stop\n");
		expected.append("  start '#3' >>Addition1 >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=} !{Add1.left=}\n");
		expected.append("  start '#3' >>Addition1 >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("Addition1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  right=Prim1 stop\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=}\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  start {Add1.left=}\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("Prim1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  name=ID stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  start '(' >>Addition1 >>Prim1 !'(' {Add1.left=}\n");
		expected.append("  start '(' >>Addition1 >>Prim1 !'(' {Val1} name=ID\n");
		expected.append("  start {Val1} name=ID\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("{Add1.left}:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  right=Prim1 stop\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=}\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  start {Add1.left=}\n");
		expected.append("  {Add1.left=} '+' right=Prim1");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression5() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Multiplication ({Add.left=current} '+' right=Multiplication)*;\n");
		grammar.append("Multiplication returns Expr: Prim ({Mult.left=current} '*' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Add_Addition:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim <<Multiplication !<<Addition stop\n");
		expected.append("  right=Multiplication stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Add.left=}\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Add_Addition_Add_1_0:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim <<Multiplication !<<Addition stop\n");
		expected.append("  right=Multiplication stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Add.left=}\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Add_Multiplication:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim <<Multiplication !<<Addition stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Add_Multiplication_Mult_1_0:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim <<Multiplication !<<Addition stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Add_Prim:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim <<Multiplication !<<Addition stop\n");
		expected.append("  start '(' >>Addition >>Multiplication >>Prim !'(' {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Mult_Addition:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' <<Prim !<<Multiplication stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Mult_Addition_Add_1_0:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' <<Prim !<<Multiplication stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Mult_Multiplication:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' <<Prim !<<Multiplication stop\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Mult.left=}\n");
		expected.append("  start {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Mult_Multiplication_Mult_1_0:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' <<Prim !<<Multiplication stop\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Mult.left=}\n");
		expected.append("  start {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Mult_Prim:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' <<Prim !<<Multiplication stop\n");
		expected.append("  start '(' >>Addition >>Multiplication >>Prim !'(' {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Val_Addition:\n");
		expected.append("  name=ID <<Prim <<Multiplication <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Val} name=ID\n");
		expected.append("Val_Addition_Add_1_0:\n");
		expected.append("  name=ID <<Prim <<Multiplication <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Multiplication >>Prim '(' >>Addition !>>Multiplication {Val} name=ID\n");
		expected.append("Val_Multiplication:\n");
		expected.append("  name=ID <<Prim <<Multiplication <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Val} name=ID\n");
		expected.append("Val_Multiplication_Mult_1_0:\n");
		expected.append("  name=ID <<Prim <<Multiplication <<Addition ')' !<<Prim stop\n");
		expected.append("  start >>Prim '(' >>Addition >>Multiplication !>>Prim {Val} name=ID\n");
		expected.append("Val_Prim:\n");
		expected.append("  name=ID <<Prim <<Multiplication <<Addition ')' !<<Prim stop\n");
		expected.append("  name=ID stop\n");
		expected.append("  start '(' >>Addition >>Multiplication >>Prim !'(' {Val} name=ID\n");
		expected.append("  start {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testMultiOptional() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Optional: val1=ID? val2=ID? val3=ID?;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Optional_Optional:\n");
		expected.append("  start val1=ID\n");
		expected.append("  start val2=ID\n");
		expected.append("  start val3=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("  val1=ID val2=ID\n");
		expected.append("  val1=ID val3=ID\n");
		expected.append("  val2=ID stop\n");
		expected.append("  val2=ID val3=ID\n");
		expected.append("  val3=ID stop\n");
		expected.append("null_Optional:");
		assertEquals(expected.toString(), actual);
	}

	public void testActions1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: {Foo.left=current} (val=ID? | {Foo.left=current});");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Foo_Model:\n");
		expected.append("  start {Foo.left=}\n");
		expected.append("  start {Foo.left=}\n");
		expected.append("  val=ID stop\n");
		expected.append("  {Foo.left=} stop\n");
		expected.append("  {Foo.left=} stop\n");
		expected.append("  {Foo.left=} val=ID\n");
		expected.append("Foo_Model_Foo_1_1:\n");
		expected.append("  start {Foo.left=}\n");
		expected.append("  {Foo.left=} stop");
		assertEquals(expected.toString(), actual);
	}

}
