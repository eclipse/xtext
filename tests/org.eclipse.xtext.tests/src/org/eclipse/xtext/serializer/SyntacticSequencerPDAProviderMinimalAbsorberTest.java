/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.io.IOException;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.serializer.impl.SequenceParserPDAProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerPDAProviderMinimalAbsorberTest extends AbstractSyntacticSequencerPDAProviderTest {

	@Override
	protected SequenceParserPDAProvider createSequenceParserPDAProvider() {
		return new SequenceParserPDAProvider() {
			@Override
			protected boolean canBeAbsorber(AbstractElement ele) {
				return false;
			}
		};
	}

	public void textXtext() {
		Grammar grammar = get(IGrammarAccess.class).getGrammar();
		try {
			new SequenceParserNDA2Dot().draw(grammar, "pdf/" + getName() + "-NFA.pdf", "-T pdf");
			//			new SequenceParserPDA2Dot().draw(grammar, "pdf/" + getName() + "-PDA.pdf", "-T pdf");
			long time = System.currentTimeMillis();
			System.out.println(new SequenceParserPDA2Dot().draw(grammar));
			System.out.println((System.currentTimeMillis() - time) + " msec");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testRecursion() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Recursion: val=ID | '(' Recursion ')';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("start '(' >>Recursion !'(' val=ID\n");
		expected.append("start val=ID\n");
		expected.append("val=ID <<Recursion ')' !<<Recursion stop\n");
		expected.append("val=ID stop");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression0() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("<<right=Prim stop\n");
		expected.append("<<right=Prim {Add.left=} '+' >>right=Prim\n");
		expected.append(">>right=Prim {Val} name=ID\n");
		expected.append("name=ID <<Prim stop\n");
		expected.append("name=ID <<Prim {Add.left=} '+' >>right=Prim\n");
		expected.append("name=ID <<right=Prim\n");
		expected.append("start >>Prim {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("<<right=Prim <<Addition ')' !<<Addition <<Prim !<<Addition <<right=Prim\n");
		expected.append("<<right=Prim <<Addition ')' !<<Addition <<Prim !<<Addition stop\n");
		expected.append("<<right=Prim <<Addition ')' !<<Addition <<Prim !<<Addition {Add.left=} '+' >>right=Prim\n");
		expected.append("<<right=Prim stop\n");
		expected.append("<<right=Prim {Add.left=} '+' >>right=Prim\n");
		expected.append(">>right=Prim '(' >>Addition >>Prim !'(' {Val} name=ID\n");
		expected.append(">>right=Prim {Val} name=ID\n");
		expected.append("name=ID <<Addition ')' !<<Addition <<Prim !<<Addition <<right=Prim\n");
		expected.append("name=ID <<Addition ')' !<<Addition <<Prim !<<Addition stop\n");
		expected.append("name=ID <<Addition ')' !<<Addition <<Prim !<<Addition {Add.left=} '+' >>right=Prim\n");
		expected.append("name=ID <<Prim <<Addition ')' !<<Addition !<<Prim <<right=Prim\n");
		expected.append("name=ID <<Prim <<Addition ')' !<<Addition !<<Prim stop\n");
		expected.append("name=ID <<Prim <<Addition ')' !<<Addition !<<Prim {Add.left=} '+' >>right=Prim\n");
		expected.append("name=ID <<right=Prim\n");
		expected.append("start >>Prim '(' >>Addition !>>Prim {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

}
