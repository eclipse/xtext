/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class JavaFormatterGrammarTest extends AbstractXtextTests {

	private static final String NL = System.lineSeparator();
	private static final String TAB = "\t";

	@Inject
	private FormatterTestHelper formatterTestHelper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void action() {
		// @formatter:off
		assertFormattedGrammar(
				"Rule:" + NL +
				TAB + "SubRule ({ Other . source = current } op='.');"
				,
				"Rule:" + NL +
				TAB + "SubRule ({Other.source=current} op='.');"
		);
		// @formatter:on
	}

	@Test
	public void enumLiterals() {
		// @formatter:off
		assertFormattedGrammar(
				"enum StateType:" + NL +
				TAB + "FIRST|SECOND|THIRD;"
				,
				"enum StateType:" + NL +
				TAB + "FIRST | SECOND | THIRD;"
				);
		// @formatter:on
	}

	@Test
	public void enumLiteralAssignment() {
		// @formatter:off
		assertFormattedGrammar(
				"enum StateType:" + NL +
				TAB + "PSEUDO = 'cond';"
				,
				"enum StateType:" + NL +
				TAB + "PSEUDO='cond';"
				);
		// @formatter:on
	}

	@Test
	public void hiddenClause() {
		// @formatter:off
		assertFormattedGrammar(
				"Child  hidden ( WS ,  ID ):" + NL +
				TAB + "A;"
				,
				"Child hidden(WS, ID):" + NL +
				TAB + "A;"
				);
		// @formatter:on
	}

	@Test
	public void tokenCardinality() {
		// @formatter:off
		assertFormattedGrammar(
				"Real hidden(): INT ? '.' (EXT_INT | INT);"
				,
				"Real hidden():" + NL
				+ TAB + "INT? '.' (EXT_INT | INT);"
				);
		// @formatter:on
	}

	@Test
	public void unorderedGroups() {
		// @formatter:off
		assertFormattedGrammar(
				"CopyFieldNameToVariableStmt:" + NL +
				"  'FIELD-NAME-TO-VARIABLE' ((',' 'SCREEN' '=' '(' line=INT ',' column=INT ')') &" + NL +
				TAB + TAB + TAB + "(','     'VAR' '=' name=ID) &" + NL +
				TAB + TAB + TAB + "(',' 'TYPE' '='    'REPLACE')?);"
				,
				"CopyFieldNameToVariableStmt:" + NL +
				TAB + "'FIELD-NAME-TO-VARIABLE' ((',' 'SCREEN' '=' '(' line=INT ',' column=INT ')') &" + NL +
				TAB + "(',' 'VAR' '=' name=ID) &" + NL +
				TAB + "(',' 'TYPE' '=' 'REPLACE')?);"
				);
		// @formatter:on
	}

	@Test
	public void guardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"AssignmentExpression <In, Yield> returns Expression:" + NL +
				TAB + "<Yield> YieldExpression<In>" + NL +
				TAB + "| RelationalExpression<In,Yield> (=> ({AssignmentExpression.lhs=current} op='=') rhs=AssignmentExpression<In,Yield>)?" + NL +
				";"
				,
				"AssignmentExpression <In, Yield> returns Expression:" + NL +
				TAB + "<Yield> YieldExpression<In>" + NL +
				TAB + "| RelationalExpression<In, Yield> (=> ({AssignmentExpression.lhs=current} op='=')" + NL +
				TAB + "rhs=AssignmentExpression<In, Yield>)?;"
				);
		// @formatter:on
	}

	@Test
	public void negatedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + TAB + "<Expression> body=Block<Yield>" + NL +
				TAB + "|"+ TAB + "<!Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + "<Expression> body=Block<Yield>" + NL +
				TAB + "| <!Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}
	
	@Test
	public void disjunctedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + "<Expression|Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + "<Expression | Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}
	
	@Test
	public void conjunctedGuardExpressions() {
		// @formatter:off
		assertFormattedGrammar(
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + "<Expression&Expression> body=Block<Yield>?" + NL +
				";"
				,
				"fragment FunctionBody <Yield, Expression>*:" + NL +
				TAB + "<Expression & Expression> body=Block<Yield>?;"
				);
		// @formatter:on
	}
	
	private void assertFormattedGrammar(String input, String expectation) {
		assertFormatted("grammar a.A" + NL + NL + input, "grammar a.A" + NL + NL + expectation);
	}

	private void assertFormatted(String original, String expectation) {
		formatterTestHelper
				.assertFormatted(r -> r.setToBeFormatted(original).setExpectation(expectation).setUseSerializer(false));
	}

	public static class XtextInjectorProvider implements IInjectorProvider {
		@Override
		public Injector getInjector() {
			return new XtextStandaloneSetup().createInjectorAndDoEMFRegistration();
		}
	}
}
