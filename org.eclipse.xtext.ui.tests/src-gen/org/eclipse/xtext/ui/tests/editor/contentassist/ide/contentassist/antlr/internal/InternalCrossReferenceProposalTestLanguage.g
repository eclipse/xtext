/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalCrossReferenceProposalTestLanguage;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;

}
@parser::members {
	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
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

// Entry rule entryRuleClass
entryRuleClass
:
{ before(grammarAccess.getClassRule()); }
	 ruleClass
{ after(grammarAccess.getClassRule()); } 
	 EOF 
;

// Rule Class
ruleClass 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getClassAccess().getGroup()); }
		(rule__Class__Group__0)
		{ after(grammarAccess.getClassAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleComplexName
entryRuleComplexName
:
{ before(grammarAccess.getComplexNameRule()); }
	 ruleComplexName
{ after(grammarAccess.getComplexNameRule()); } 
	 EOF 
;

// Rule ComplexName
ruleComplexName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getComplexNameAccess().getGroup()); }
		(rule__ComplexName__Group__0)
		{ after(grammarAccess.getComplexNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Alternatives_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); }
		(rule__Class__SuperClassAssignment_0_0_0)
		{ after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); }
		(rule__Class__SuperClassAssignment_0_0_1)
		{ after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); }
		(rule__Class__SuperClassAssignment_0_0_2)
		{ after(grammarAccess.getClassAccess().getSuperClassAssignment_0_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__NameAlternatives_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); }
		RULE_ID
		{ after(grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); }
		ruleComplexName
		{ after(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group__0__Impl
	rule__Class__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getGroup_0()); }
	(rule__Class__Group_0__0)?
	{ after(grammarAccess.getClassAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group__1__Impl
	rule__Class__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getNameAssignment_1()); }
	(rule__Class__NameAssignment_1)
	{ after(grammarAccess.getClassAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group__2__Impl
	rule__Class__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); }
	'{'
	{ after(grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); }
	'}'
	{ after(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Class__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group_0__0__Impl
	rule__Class__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getAlternatives_0_0()); }
	(rule__Class__Alternatives_0_0)
	{ after(grammarAccess.getClassAccess().getAlternatives_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Class__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); }
	'<-'
	{ after(grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ComplexName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComplexName__Group__0__Impl
	rule__ComplexName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ComplexName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); }
	'::'
	{ after(grammarAccess.getComplexNameAccess().getColonColonKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ComplexName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ComplexName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ComplexName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); }
	RULE_ID
	{ after(grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1()); }
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
		{ before(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); }
		ruleClass
		{ after(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__SuperClassAssignment_0_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); }
		(
			{ before(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); }
			'Object'
			{ after(grammarAccess.getClassAccess().getSuperClassClassObjectKeyword_0_0_0_0_1()); }
		)
		{ after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__SuperClassAssignment_0_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); }
		(
			{ before(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getClassAccess().getSuperClassClassIDTerminalRuleCall_0_0_1_0_1()); }
		)
		{ after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__SuperClassAssignment_0_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); }
		(
			{ before(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); }
			ruleComplexName
			{ after(grammarAccess.getClassAccess().getSuperClassClassComplexNameParserRuleCall_0_0_2_0_1()); }
		)
		{ after(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Class__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getClassAccess().getNameAlternatives_1_0()); }
		(rule__Class__NameAlternatives_1_0)
		{ after(grammarAccess.getClassAccess().getNameAlternatives_1_0()); }
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
