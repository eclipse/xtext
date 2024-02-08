/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalParametersTestLanguageEx;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParametersTestLanguageExGrammarAccess;

}
@parser::members {
	private ParametersTestLanguageExGrammarAccess grammarAccess;

	public void setGrammarAccess(ParametersTestLanguageExGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
}

// Entry rule entryRuleParserRuleParameters
entryRuleParserRuleParameters
:
{ before(grammarAccess.getParserRuleParametersRule()); }
	 ruleParserRuleParameters
{ after(grammarAccess.getParserRuleParametersRule()); } 
	 EOF 
;

// Rule ParserRuleParameters
ruleParserRuleParameters 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParserRuleParametersAccess().getParserRuleParametersParserRuleCall()); }
		superParserRuleParameters
		{ after(grammarAccess.getParserRuleParametersAccess().getParserRuleParametersParserRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScenario1
entryRuleScenario1
:
{ before(grammarAccess.getScenario1Rule()); }
	 ruleScenario1
{ after(grammarAccess.getScenario1Rule()); } 
	 EOF 
;

// Rule Scenario1
ruleScenario1 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario1Access().getScenario1ParserRuleCall(), 0
		); }
		superScenario1
		{ after(grammarAccess.getScenario1Access().getScenario1ParserRuleCall(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario1
norm1_Scenario1 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario1Access().getScenario1ParserRuleCall(), 1
		); }
		normSuper1_Scenario1
		{ after(grammarAccess.getScenario1Access().getScenario1ParserRuleCall(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entrySuperParserRuleParameters
entrySuperParserRuleParameters
:
{ before(grammarAccess.getParametersTestLanguageParserRuleParametersRule()); }
	 superParserRuleParameters
{ after(grammarAccess.getParametersTestLanguageParserRuleParametersRule()); } 
	 EOF 
;

// Rule ParserRuleParameters
superParserRuleParameters 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup()); }
		(superParserRuleParameters__Group__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entrySuperScenario1
entrySuperScenario1
:
{ before(grammarAccess.getParametersTestLanguageScenario1Rule()); }
	 superScenario1
{ after(grammarAccess.getParametersTestLanguageScenario1Rule()); } 
	 EOF 
;

// Rule Scenario1
superScenario1 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParametersTestLanguageScenario1Access().getSecondAssignment_1_0(), 0
		); }
		(superScenario1__SecondAssignment_1_0)
		{ after(grammarAccess.getParametersTestLanguageScenario1Access().getSecondAssignment_1_0(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario1
normSuper1_Scenario1 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParametersTestLanguageScenario1Access().getFirstAssignment_0_0(), 1
		); }
		(normSuper1_Scenario1__FirstAssignment_0_0)
		{ after(grammarAccess.getParametersTestLanguageScenario1Access().getFirstAssignment_0_0(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScenario2
entryRuleScenario2
:
{ before(grammarAccess.getScenario2Rule()); }
	 ruleScenario2
{ after(grammarAccess.getScenario2Rule()); } 
	 EOF 
;

// Rule Scenario2
ruleScenario2 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario2Access().getFirstAssignment(), 0
		); }
		(rule__Scenario2__FirstAssignment)
		{ after(grammarAccess.getScenario2Access().getFirstAssignment(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario2
norm1_Scenario2 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario2Access().getFirstAssignment(), 1
		); }
		(norm1_Scenario2__FirstAssignment)
		{ after(grammarAccess.getScenario2Access().getFirstAssignment(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScenario3
entryRuleScenario3
:
{ before(grammarAccess.getScenario3Rule()); }
	 ruleScenario3
{ after(grammarAccess.getScenario3Rule()); } 
	 EOF 
;

// Rule Scenario3
ruleScenario3 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario3Access().getAlternatives(), 0
		); }
		(rule__Scenario3__Alternatives)
		{ after(grammarAccess.getScenario3Access().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario3
norm1_Scenario3 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario3Access().getAlternatives(), 1
		); }
		(norm1_Scenario3__Alternatives)
		{ after(grammarAccess.getScenario3Access().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScenario4
entryRuleScenario4
:
{ before(grammarAccess.getScenario4Rule()); }
	 ruleScenario4
{ after(grammarAccess.getScenario4Rule()); } 
	 EOF 
;

// Rule Scenario4
ruleScenario4 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario4Access().getGroup(), 0
		); }
		(rule__Scenario4__Group__0)
		{ after(grammarAccess.getScenario4Access().getGroup(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario4
norm1_Scenario4 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario4Access().getGroup(), 1
		); }
		(norm1_Scenario4__Group__0)
		{ after(grammarAccess.getScenario4Access().getGroup(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleScenario5
entryRuleScenario5
:
{ before(grammarAccess.getScenario5Rule()); }
	 ruleScenario5
{ after(grammarAccess.getScenario5Rule()); } 
	 EOF 
;

// Rule Scenario5
ruleScenario5 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario5Access().getAlternatives(), 0
		); }
		(rule__Scenario5__Alternatives)
		{ after(grammarAccess.getScenario5Access().getAlternatives(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario5
norm1_Scenario5 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario5Access().getAlternatives(), 1
		); }
		(norm1_Scenario5__Alternatives)
		{ after(grammarAccess.getScenario5Access().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario5Body
ruleScenario5Body 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario5BodyAccess().getFragmentKeyword_1_0(), 0
		); }
		('fragment')?
		{ after(grammarAccess.getScenario5BodyAccess().getFragmentKeyword_1_0(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Scenario5Body
norm1_Scenario5Body 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getScenario5BodyAccess().getIncludeKeyword_0_0(), 1
		); }
		'include'
		{ after(grammarAccess.getScenario5BodyAccess().getIncludeKeyword_0_0(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleIdOrKeyword
entryRuleIdOrKeyword
:
{ before(grammarAccess.getIdOrKeywordRule()); }
	 ruleIdOrKeyword
{ after(grammarAccess.getIdOrKeywordRule()); } 
	 EOF 
;

// Rule IdOrKeyword
ruleIdOrKeyword 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1(), 0
		); }
		RULE_ID
		{ after(grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1(), 0
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule IdOrKeyword
norm1_IdOrKeyword 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getIdOrKeywordAccess().getAlternatives(), 1
		); }
		(norm1_IdOrKeyword__Alternatives)
		{ after(grammarAccess.getIdOrKeywordAccess().getAlternatives(), 1
		); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_0()); }
		(superParserRuleParameters__Group_1_0__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_1()); }
		(superParserRuleParameters__Group_1_1__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_2()); }
		(superParserRuleParameters__Group_1_2__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_2()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_3()); }
		(superParserRuleParameters__Group_1_3__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_3()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4()); }
		(superParserRuleParameters__Group_1_4__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5()); }
		(superParserRuleParameters__Group_1_5__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_6()); }
		(superParserRuleParameters__Group_1_6__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_6()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_7()); }
		(superParserRuleParameters__Group_1_7__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_7()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8()); }
		(superParserRuleParameters__Group_1_8__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9()); }
		(superParserRuleParameters__Group_1_9__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10()); }
		(superParserRuleParameters__Group_1_10__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11()); }
		(superParserRuleParameters__Group_1_11__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_12()); }
		(superParserRuleParameters__Group_1_12__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_12()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_13()); }
		(superParserRuleParameters__Group_1_13__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_13()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Alternatives_1_8_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_0()); }
		(superParserRuleParameters__ScenarioAssignment_1_8_1_0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8_1_1()); }
		(superParserRuleParameters__Group_1_8_1_1__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_8_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Alternatives_1_9_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_0()); }
		(superParserRuleParameters__ScenarioAssignment_1_9_1_0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9_1_1()); }
		(superParserRuleParameters__Group_1_9_1_1__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_9_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Alternatives_1_10_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_0()); }
		(superParserRuleParameters__ScenarioAssignment_1_10_1_0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10_1_1()); }
		(superParserRuleParameters__Group_1_10_1_1__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_10_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Alternatives_1_11_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_0()); }
		(superParserRuleParameters__ScenarioAssignment_1_11_1_0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11_1_1()); }
		(superParserRuleParameters__Group_1_11_1_1__0)
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_11_1_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario3__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getFirstAssignment_0()); }
		(rule__Scenario3__FirstAssignment_0)
		{ after(grammarAccess.getScenario3Access().getFirstAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getScenario3Access().getSecondAssignment_1()); }
		(rule__Scenario3__SecondAssignment_1)
		{ after(grammarAccess.getScenario3Access().getSecondAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario3__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getFirstAssignment_0()); }
		(norm1_Scenario3__FirstAssignment_0)
		{ after(grammarAccess.getScenario3Access().getFirstAssignment_0()); }
	)
	|
	(
		{ before(grammarAccess.getScenario3Access().getSecondAssignment_1()); }
		(norm1_Scenario3__SecondAssignment_1)
		{ after(grammarAccess.getScenario3Access().getSecondAssignment_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getGroup_1()); }
		(rule__Scenario5__Group_1__0)
		{ after(grammarAccess.getScenario5Access().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getScenario5Access().getGroup_2()); }
		(rule__Scenario5__Group_2__0)
		{ after(grammarAccess.getScenario5Access().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getScenario5Access().getGroup_3()); }
		(rule__Scenario5__Group_3__0)
		{ after(grammarAccess.getScenario5Access().getGroup_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getGroup_0()); }
		(norm1_Scenario5__Group_0__0)
		{ after(grammarAccess.getScenario5Access().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getScenario5Access().getGroup_1()); }
		(norm1_Scenario5__Group_1__0)
		{ after(grammarAccess.getScenario5Access().getGroup_1()); }
	)
	|
	(
		{ before(grammarAccess.getScenario5Access().getGroup_2()); }
		(norm1_Scenario5__Group_2__0)
		{ after(grammarAccess.getScenario5Access().getGroup_2()); }
	)
	|
	(
		{ before(grammarAccess.getScenario5Access().getGroup_3()); }
		(norm1_Scenario5__Group_3__0)
		{ after(grammarAccess.getScenario5Access().getGroup_3()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_IdOrKeyword__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); }
		'keyword'
		{ after(grammarAccess.getIdOrKeywordAccess().getKeywordKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1()); }
		RULE_ID
		{ after(grammarAccess.getIdOrKeywordAccess().getIDTerminalRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group__0__Impl
	superParserRuleParameters__Group__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getParserRuleParametersAction_0()); }
	()
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getParserRuleParametersAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1()); }
	(superParserRuleParameters__Alternatives_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_0__0__Impl
	superParserRuleParameters__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0()); }
	'#1'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneKeyword_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_0_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_0_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_1__0__Impl
	superParserRuleParameters__Group_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0()); }
	'#2'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitTwoKeyword_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_1_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_1_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_2__0__Impl
	superParserRuleParameters__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0()); }
	'#3'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitThreeKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_2_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_2_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_3__0__Impl
	superParserRuleParameters__Group_1_3__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0()); }
	'#4'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFourKeyword_1_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_3__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_3_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_3_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_4__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4_0()); }
	(superParserRuleParameters__Group_1_4_0__0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_4_0__0__Impl
	superParserRuleParameters__Group_1_4_0__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0()); }
	'#5'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitFiveKeyword_1_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_4_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_4_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_4_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_4_0_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_4_0_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_4_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_5__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_5__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_5__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5_0()); }
	(superParserRuleParameters__Group_1_5_0__0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getGroup_1_5_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_5_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_5_0__0__Impl
	superParserRuleParameters__Group_1_5_0__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_5_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0()); }
	'#6'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSixKeyword_1_5_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_5_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_5_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_5_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_5_0_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_5_0_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_5_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_6__0__Impl
	superParserRuleParameters__Group_1_6__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0()); }
	'#7'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitSevenKeyword_1_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_6_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_6_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_7__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_7__0__Impl
	superParserRuleParameters__Group_1_7__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_7__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0()); }
	'#8'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitEightKeyword_1_7_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_7__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_7__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_7__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_7_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_7_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_7_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_8__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_8__0__Impl
	superParserRuleParameters__Group_1_8__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0()); }
	'#9'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitNineKeyword_1_8_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_8__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_8_1()); }
	(superParserRuleParameters__Alternatives_1_8_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_8_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_8_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_8_1_1__0__Impl
	superParserRuleParameters__Group_1_8_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_1_0()); }
	(superParserRuleParameters__ScenarioAssignment_1_8_1_1_0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_8_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_8_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_8_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_8_1_1_1()); }
	('trailing')?
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_8_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_9__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_9__0__Impl
	superParserRuleParameters__Group_1_9__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0()); }
	'#10'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitZeroKeyword_1_9_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_9__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_9_1()); }
	(superParserRuleParameters__Alternatives_1_9_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_9_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_9_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_9_1_1__0__Impl
	superParserRuleParameters__Group_1_9_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_1_0()); }
	(superParserRuleParameters__ScenarioAssignment_1_9_1_1_0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_9_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_9_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_9_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_9_1_1_1()); }
	('trailing')?
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_9_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_10__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_10__0__Impl
	superParserRuleParameters__Group_1_10__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0()); }
	'#11'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitOneKeyword_1_10_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_10__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_10_1()); }
	(superParserRuleParameters__Alternatives_1_10_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_10_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_10_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_10_1_1__0__Impl
	superParserRuleParameters__Group_1_10_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_1_0()); }
	(superParserRuleParameters__ScenarioAssignment_1_10_1_1_0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_10_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_10_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_10_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_10_1_1_1()); }
	('trailing')?
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_10_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_11__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_11__0__Impl
	superParserRuleParameters__Group_1_11__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0()); }
	'#12'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitTwoKeyword_1_11_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_11__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_11_1()); }
	(superParserRuleParameters__Alternatives_1_11_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getAlternatives_1_11_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_11_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_11_1_1__0__Impl
	superParserRuleParameters__Group_1_11_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_1_0()); }
	(superParserRuleParameters__ScenarioAssignment_1_11_1_1_0)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_11_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_11_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_11_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_11_1_1_1()); }
	('trailing')?
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getTrailingKeyword_1_11_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_12__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_12__0__Impl
	superParserRuleParameters__Group_1_12__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_12__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitThreeKeyword_1_12_0()); }
	'#13'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitThreeKeyword_1_12_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_12__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_12__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_12__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_12_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_12_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_12_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__Group_1_13__0
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_13__0__Impl
	superParserRuleParameters__Group_1_13__1
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_13__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitFourKeyword_1_13_0()); }
	'#14'
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getNumberSignDigitOneDigitFourKeyword_1_13_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_13__1
	@init {
		int stackSize = keepStackSize();
	}
:
	superParserRuleParameters__Group_1_13__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__Group_1_13__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_13_1()); }
	(superParserRuleParameters__ScenarioAssignment_1_13_1)
	{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioAssignment_1_13_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scenario4__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario4__Group__0__Impl
	rule__Scenario4__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario4__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario4Access().getSecondAssignment_0()); }
	(rule__Scenario4__SecondAssignment_0)
	{ after(grammarAccess.getScenario4Access().getSecondAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario4__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario4__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario4__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario4Access().getScenario4Keyword_1()); }
	'scenario4'
	{ after(grammarAccess.getScenario4Access().getScenario4Keyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Scenario4__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario4__Group__0__Impl
	norm1_Scenario4__Group__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario4__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario4Access().getSecondAssignment_0()); }
	(norm1_Scenario4__SecondAssignment_0)
	{ after(grammarAccess.getScenario4Access().getSecondAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario4__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario4__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario4__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario4Access().getScenario4Keyword_1()); }
	'scenario4'
	{ after(grammarAccess.getScenario4Access().getScenario4Keyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scenario5__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_1__0__Impl
	rule__Scenario5__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_1_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getTrailingKeyword_1_1()); }
	'trailing'
	{ after(grammarAccess.getScenario5Access().getTrailingKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scenario5__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_2__0__Impl
	rule__Scenario5__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_2_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_2__1__Impl
	rule__Scenario5__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5Keyword_2_1()); }
	'scenario5'
	{ after(grammarAccess.getScenario5Access().getScenario5Keyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_2__2__Impl
	rule__Scenario5__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getFirstAssignment_2_3()); }
	(rule__Scenario5__FirstAssignment_2_3)
	{ after(grammarAccess.getScenario5Access().getFirstAssignment_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getSecondAssignment_2_4()); }
	(rule__Scenario5__SecondAssignment_2_4)
	{ after(grammarAccess.getScenario5Access().getSecondAssignment_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Scenario5__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_3__0__Impl
	rule__Scenario5__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_3_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_3__1__Impl
	rule__Scenario5__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5Keyword_3_1()); }
	'scenario5'
	{ after(grammarAccess.getScenario5Access().getScenario5Keyword_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_3__2__Impl
	rule__Scenario5__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getFragmentKeyword_3_2()); }
	'fragment'
	{ after(grammarAccess.getScenario5Access().getFragmentKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_3__3__Impl
	rule__Scenario5__Group_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5BodyParserRuleCall_3_3()); }
	ruleScenario5Body
	{ after(grammarAccess.getScenario5Access().getScenario5BodyParserRuleCall_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Scenario5__Group_3__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__Group_3__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getTrailingKeyword_3_4()); }
	'trailing'
	{ after(grammarAccess.getScenario5Access().getTrailingKeyword_3_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Scenario5__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_0__0__Impl
	norm1_Scenario5__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_0_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getIncludeKeyword_0_1()); }
	'include'
	{ after(grammarAccess.getScenario5Access().getIncludeKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Scenario5__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_1__0__Impl
	norm1_Scenario5__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_1_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getTrailingKeyword_1_1()); }
	'trailing'
	{ after(grammarAccess.getScenario5Access().getTrailingKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Scenario5__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_2__0__Impl
	norm1_Scenario5__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_2_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_2__1__Impl
	norm1_Scenario5__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5Keyword_2_1()); }
	'scenario5'
	{ after(grammarAccess.getScenario5Access().getScenario5Keyword_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_2__2__Impl
	norm1_Scenario5__Group_2__3
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getIncludeKeyword_2_2_0()); }
	('include')?
	{ after(grammarAccess.getScenario5Access().getIncludeKeyword_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_2__3__Impl
	norm1_Scenario5__Group_2__4
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getFirstAssignment_2_3()); }
	(norm1_Scenario5__FirstAssignment_2_3)
	{ after(grammarAccess.getScenario5Access().getFirstAssignment_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__4
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_2__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_2__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getSecondAssignment_2_4()); }
	(norm1_Scenario5__SecondAssignment_2_4)
	{ after(grammarAccess.getScenario5Access().getSecondAssignment_2_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


norm1_Scenario5__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_3__0__Impl
	norm1_Scenario5__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenarioAction_3_0()); }
	()
	{ after(grammarAccess.getScenario5Access().getScenarioAction_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_3__1__Impl
	norm1_Scenario5__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5Keyword_3_1()); }
	'scenario5'
	{ after(grammarAccess.getScenario5Access().getScenario5Keyword_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_3__2__Impl
	norm1_Scenario5__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getFragmentKeyword_3_2()); }
	'fragment'
	{ after(grammarAccess.getScenario5Access().getFragmentKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_3__3__Impl
	norm1_Scenario5__Group_3__4
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getScenario5BodyParserRuleCall_3_3()); }
	norm1_Scenario5Body
	{ after(grammarAccess.getScenario5Access().getScenario5BodyParserRuleCall_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__4
	@init {
		int stackSize = keepStackSize();
	}
:
	norm1_Scenario5__Group_3__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__Group_3__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getScenario5Access().getTrailingKeyword_3_4()); }
	'trailing'
	{ after(grammarAccess.getScenario5Access().getTrailingKeyword_3_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


superParserRuleParameters__ScenarioAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0()); }
		norm1_Scenario1
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0()); }
		ruleScenario1
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario1ParserRuleCall_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0()); }
		norm1_Scenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0()); }
		ruleScenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_4_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0()); }
		norm1_Scenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_4_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_5_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0()); }
		ruleScenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_5_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0()); }
		norm1_Scenario3
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_7_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0()); }
		ruleScenario3
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario3ParserRuleCall_1_7_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_8_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0()); }
		norm1_Scenario4
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_8_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_8_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0()); }
		norm1_Scenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_8_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_9_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0()); }
		norm1_Scenario4
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_9_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_9_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0()); }
		ruleScenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_9_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_10_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0()); }
		ruleScenario4
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_10_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_10_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0()); }
		norm1_Scenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_10_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_11_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0()); }
		ruleScenario4
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario4ParserRuleCall_1_11_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_11_1_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0()); }
		ruleScenario2
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario2ParserRuleCall_1_11_1_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_12_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_12_1_0()); }
		ruleScenario5
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_12_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superParserRuleParameters__ScenarioAssignment_1_13_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_13_1_0()); }
		norm1_Scenario5
		{ after(grammarAccess.getParametersTestLanguageParserRuleParametersAccess().getScenarioScenario5ParserRuleCall_1_13_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

superScenario1__SecondAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageScenario1Access().getSecondIDTerminalRuleCall_1_0_0()); }
		RULE_ID
		{ after(grammarAccess.getParametersTestLanguageScenario1Access().getSecondIDTerminalRuleCall_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

normSuper1_Scenario1__FirstAssignment_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParametersTestLanguageScenario1Access().getFirstIDTerminalRuleCall_0_0_0()); }
		RULE_ID
		{ after(grammarAccess.getParametersTestLanguageScenario1Access().getFirstIDTerminalRuleCall_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario2__FirstAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); }
		ruleIdOrKeyword
		{ after(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario2__FirstAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); }
		norm1_IdOrKeyword
		{ after(grammarAccess.getScenario2Access().getFirstIdOrKeywordParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario3__FirstAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); }
		ruleIdOrKeyword
		{ after(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario3__SecondAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
		(
			{ before(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
			'scenario3'
			{ after(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
		)
		{ after(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario3__FirstAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); }
		norm1_IdOrKeyword
		{ after(grammarAccess.getScenario3Access().getFirstIdOrKeywordParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario3__SecondAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
		(
			{ before(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
			'scenario3'
			{ after(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
		)
		{ after(grammarAccess.getScenario3Access().getSecondScenario3Keyword_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario4__SecondAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); }
		ruleIdOrKeyword
		{ after(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario4__SecondAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); }
		norm1_IdOrKeyword
		{ after(grammarAccess.getScenario4Access().getSecondIdOrKeywordParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__FirstAssignment_2_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); }
		norm1_IdOrKeyword
		{ after(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Scenario5__SecondAssignment_2_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); }
		ruleIdOrKeyword
		{ after(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__FirstAssignment_2_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); }
		norm1_IdOrKeyword
		{ after(grammarAccess.getScenario5Access().getFirstIdOrKeywordParserRuleCall_2_3_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

norm1_Scenario5__SecondAssignment_2_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); }
		ruleIdOrKeyword
		{ after(grammarAccess.getScenario5Access().getSecondIdOrKeywordParserRuleCall_2_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
