/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalReferringTestLanguage;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.refactoring.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;

}
@parser::members {
	private ReferringTestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(ReferringTestLanguageGrammarAccess grammarAccess) {
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

// Entry rule entryRuleMain
entryRuleMain
:
{ before(grammarAccess.getMainRule()); }
	 ruleMain
{ after(grammarAccess.getMainRule()); } 
	 EOF 
;

// Rule Main
ruleMain 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMainAccess().getReferencedAssignment()); }
		(rule__Main__ReferencedAssignment)*
		{ after(grammarAccess.getMainAccess().getReferencedAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleAbstractReference
entryRuleAbstractReference
:
{ before(grammarAccess.getAbstractReferenceRule()); }
	 ruleAbstractReference
{ after(grammarAccess.getAbstractReferenceRule()); } 
	 EOF 
;

// Rule AbstractReference
ruleAbstractReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getAbstractReferenceAccess().getAlternatives()); }
		(rule__AbstractReference__Alternatives)
		{ after(grammarAccess.getAbstractReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReference
entryRuleReference
:
{ before(grammarAccess.getReferenceRule()); }
	 ruleReference
{ after(grammarAccess.getReferenceRule()); } 
	 EOF 
;

// Rule Reference
ruleReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReferenceAccess().getGroup()); }
		(rule__Reference__Group__0)
		{ after(grammarAccess.getReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleReference2
entryRuleReference2
:
{ before(grammarAccess.getReference2Rule()); }
	 ruleReference2
{ after(grammarAccess.getReference2Rule()); } 
	 EOF 
;

// Rule Reference2
ruleReference2 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getReference2Access().getGroup()); }
		(rule__Reference2__Group__0)
		{ after(grammarAccess.getReference2Access().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleNamed
entryRuleNamed
:
{ before(grammarAccess.getNamedRule()); }
	 ruleNamed
{ after(grammarAccess.getNamedRule()); } 
	 EOF 
;

// Rule Named
ruleNamed 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getNamedAccess().getNameAssignment()); }
		(rule__Named__NameAssignment)
		{ after(grammarAccess.getNamedAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleFQN
entryRuleFQN
:
{ before(grammarAccess.getFQNRule()); }
	 ruleFQN
{ after(grammarAccess.getFQNRule()); } 
	 EOF 
;

// Rule FQN
ruleFQN 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getFQNAccess().getGroup()); }
		(rule__FQN__Group__0)
		{ after(grammarAccess.getFQNAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__AbstractReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); }
		ruleReference
		{ after(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); }
		ruleReference2
		{ after(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Reference__Group__0__Impl
	rule__Reference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceAccess().getRefKeyword_0()); }
	'ref'
	{ after(grammarAccess.getReferenceAccess().getRefKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Reference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); }
	(rule__Reference__ReferencedAssignment_1)
	{ after(grammarAccess.getReferenceAccess().getReferencedAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Reference2__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Reference2__Group__0__Impl
	rule__Reference2__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); }
	ruleNamed
	{ after(grammarAccess.getReference2Access().getNamedParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Reference2__Group__1__Impl
	rule__Reference2__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); }
	'='
	{ after(grammarAccess.getReference2Access().getEqualsSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Reference2__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getReference2Access().getReferencedAssignment_2()); }
	(rule__Reference2__ReferencedAssignment_2)
	{ after(grammarAccess.getReference2Access().getReferencedAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group__0__Impl
	rule__FQN__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
	RULE_ID
	{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getGroup_1()); }
	(rule__FQN__Group_1__0)*
	{ after(grammarAccess.getFQNAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__FQN__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group_1__0__Impl
	rule__FQN__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__FQN__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__FQN__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
	RULE_ID
	{ after(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Main__ReferencedAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); }
		ruleAbstractReference
		{ after(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference__ReferencedAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); }
		(
			{ before(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); }
			ruleFQN
			{ after(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1()); }
		)
		{ after(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Reference2__ReferencedAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); }
		(
			{ before(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); }
			ruleFQN
			{ after(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1()); }
		)
		{ after(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Named__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); }
		RULE_ID
		{ after(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0()); }
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
