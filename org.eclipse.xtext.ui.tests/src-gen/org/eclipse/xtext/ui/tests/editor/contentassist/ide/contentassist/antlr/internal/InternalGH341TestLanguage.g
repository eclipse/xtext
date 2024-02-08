/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalGH341TestLanguage;

options {
	superClass=AbstractInternalContentAssistParser;
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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;

}
@parser::members {
	private GH341TestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(GH341TestLanguageGrammarAccess grammarAccess) {
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

// Entry rule entryRuleModel
entryRuleModel
:
{ before(grammarAccess.getModelRule()); }
	 ruleModel
{ after(grammarAccess.getModelRule()); } 
	 EOF 
;

// Rule Model
ruleModel 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getModelAccess().getElementsAssignment()); }
		(rule__Model__ElementsAssignment)*
		{ after(grammarAccess.getModelAccess().getElementsAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleWorks
entryRuleWorks
:
{ before(grammarAccess.getWorksRule()); }
	 ruleWorks
{ after(grammarAccess.getWorksRule()); } 
	 EOF 
;

// Rule Works
ruleWorks 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getWorksAccess().getGroup()); }
		(rule__Works__Group__0)
		{ after(grammarAccess.getWorksAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleBroken
entryRuleBroken
:
{ before(grammarAccess.getBrokenRule()); }
	 ruleBroken
{ after(grammarAccess.getBrokenRule()); } 
	 EOF 
;

// Rule Broken
ruleBroken 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getBrokenAccess().getGroup()); }
		(rule__Broken__Group__0)
		{ after(grammarAccess.getBrokenAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleThird
entryRuleThird
:
{ before(grammarAccess.getThirdRule()); }
	 ruleThird
{ after(grammarAccess.getThirdRule()); } 
	 EOF 
;

// Rule Third
ruleThird 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getThirdAccess().getGroup()); }
		(rule__Third__Group__0)
		{ after(grammarAccess.getThirdAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule STREAM
ruleSTREAM 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getSTREAMAccess().getStreamKeyword()); }
		'stream'
		{ after(grammarAccess.getSTREAMAccess().getStreamKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule DEFINE
ruleDEFINE 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getDEFINEAccess().getDefineKeyword()); }
		'define'
		{ after(grammarAccess.getDEFINEAccess().getDefineKeyword()); }
	)
;
finally {
	restoreStackSize(stackSize);
}


// Rule Fragment
ruleFragment 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFragmentAccess().getGroup()); }
		(rule__Fragment__Group__0)*
		{ after(grammarAccess.getFragmentAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Model__ElementsAlternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); }
		ruleWorks
		{ after(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); }
		ruleBroken
		{ after(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); }
		ruleThird
		{ after(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group__0__Impl
	rule__Works__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getWorksKeyword_0()); }
	'works'
	{ after(grammarAccess.getWorksAccess().getWorksKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group__1__Impl
	rule__Works__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getNameAssignment_1()); }
	(rule__Works__NameAssignment_1)
	{ after(grammarAccess.getWorksAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group__2__Impl
	rule__Works__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getGroup_2()); }
	(rule__Works__Group_2__0)*
	{ after(grammarAccess.getWorksAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getGroup_3()); }
	(rule__Works__Group_3__0)*
	{ after(grammarAccess.getWorksAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Works__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_2__0__Impl
	rule__Works__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); }
	(rule__Works__IdsAssignment_2_0)
	{ after(grammarAccess.getWorksAccess().getIdsAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_2__1__Impl
	rule__Works__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getGroup_2_1()); }
	(rule__Works__Group_2_1__0)*
	{ after(grammarAccess.getWorksAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); }
	';'
	{ after(grammarAccess.getWorksAccess().getSemicolonKeyword_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Works__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_2_1__0__Impl
	rule__Works__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); }
	'.'
	{ after(grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); }
	(rule__Works__IdsAssignment_2_1_1)
	{ after(grammarAccess.getWorksAccess().getIdsAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Works__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3__0__Impl
	rule__Works__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); }
	(rule__Works__RefsAssignment_3_0)
	{ after(grammarAccess.getWorksAccess().getRefsAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3__1__Impl
	rule__Works__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getGroup_3_1()); }
	(rule__Works__Group_3_1__0)*
	{ after(grammarAccess.getWorksAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3__2__Impl
	rule__Works__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getXKeyword_3_2()); }
	'X'
	{ after(grammarAccess.getWorksAccess().getXKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); }
	';'
	{ after(grammarAccess.getWorksAccess().getSemicolonKeyword_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Works__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3_1__0__Impl
	rule__Works__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); }
	'.'
	{ after(grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Works__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); }
	(rule__Works__RefsAssignment_3_1_1)
	{ after(grammarAccess.getWorksAccess().getRefsAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Broken__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group__0__Impl
	rule__Broken__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); }
	'broken'
	{ after(grammarAccess.getBrokenAccess().getBrokenKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group__1__Impl
	rule__Broken__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getNameAssignment_1()); }
	(rule__Broken__NameAssignment_1)
	{ after(grammarAccess.getBrokenAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group__2__Impl
	rule__Broken__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); }
	ruleFragment
	{ after(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getGroup_3()); }
	(rule__Broken__Group_3__0)*
	{ after(grammarAccess.getBrokenAccess().getGroup_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Broken__Group_3__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3__0__Impl
	rule__Broken__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); }
	(rule__Broken__RefsAssignment_3_0)
	{ after(grammarAccess.getBrokenAccess().getRefsAssignment_3_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3__1__Impl
	rule__Broken__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getGroup_3_1()); }
	(rule__Broken__Group_3_1__0)*
	{ after(grammarAccess.getBrokenAccess().getGroup_3_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3__2__Impl
	rule__Broken__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getXKeyword_3_2()); }
	'X'
	{ after(grammarAccess.getBrokenAccess().getXKeyword_3_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); }
	';'
	{ after(grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Broken__Group_3_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3_1__0__Impl
	rule__Broken__Group_3_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); }
	'.'
	{ after(grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Broken__Group_3_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__Group_3_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); }
	(rule__Broken__RefsAssignment_3_1_1)
	{ after(grammarAccess.getBrokenAccess().getRefsAssignment_3_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Third__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Third__Group__0__Impl
	rule__Third__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); }
	ruleDEFINE
	{ after(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Third__Group__1__Impl
	rule__Third__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); }
	ruleSTREAM
	{ after(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Third__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getThirdAccess().getNameAssignment_2()); }
	(rule__Third__NameAssignment_2)
	{ after(grammarAccess.getThirdAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Fragment__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fragment__Group__0__Impl
	rule__Fragment__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFragmentAccess().getIdsAssignment_0()); }
	(rule__Fragment__IdsAssignment_0)
	{ after(grammarAccess.getFragmentAccess().getIdsAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fragment__Group__1__Impl
	rule__Fragment__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFragmentAccess().getGroup_1()); }
	(rule__Fragment__Group_1__0)*
	{ after(grammarAccess.getFragmentAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fragment__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); }
	';'
	{ after(grammarAccess.getFragmentAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Fragment__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fragment__Group_1__0__Impl
	rule__Fragment__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getFragmentAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Fragment__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); }
	(rule__Fragment__IdsAssignment_1_1)
	{ after(grammarAccess.getFragmentAccess().getIdsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Model__ElementsAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getElementsAlternatives_0()); }
		(rule__Model__ElementsAlternatives_0)
		{ after(grammarAccess.getModelAccess().getElementsAlternatives_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__IdsAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); }
		RULE_ID
		{ after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__IdsAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); }
		RULE_ID
		{ after(grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__RefsAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); }
		(
			{ before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_0_0_1()); }
		)
		{ after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Works__RefsAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); }
		(
			{ before(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getWorksAccess().getRefsWorksIDTerminalRuleCall_3_1_1_0_1()); }
		)
		{ after(grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__RefsAssignment_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); }
		(
			{ before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_0_0_1()); }
		)
		{ after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Broken__RefsAssignment_3_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); }
		(
			{ before(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getBrokenAccess().getRefsBrokenIDTerminalRuleCall_3_1_1_0_1()); }
		)
		{ after(grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Third__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__IdsAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); }
		RULE_ID
		{ after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Fragment__IdsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); }
		RULE_ID
		{ after(grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0()); }
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
