/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
grammar InternalTestLanguage;

options {
	superClass=AbstractInternalContentAssistParser;
}

@lexer::header {
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;

}
@parser::members {
	private TestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(TestLanguageGrammarAccess grammarAccess) {
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
		{ before(grammarAccess.getModelAccess().getTypesAssignment()); }
		(rule__Model__TypesAssignment)*
		{ after(grammarAccess.getModelAccess().getTypesAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeDeclaration
entryRuleTypeDeclaration
:
{ before(grammarAccess.getTypeDeclarationRule()); }
	 ruleTypeDeclaration
{ after(grammarAccess.getTypeDeclarationRule()); } 
	 EOF 
;

// Rule TypeDeclaration
ruleTypeDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeDeclarationAccess().getGroup()); }
		(rule__TypeDeclaration__Group__0)
		{ after(grammarAccess.getTypeDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleProperty
entryRuleProperty
:
{ before(grammarAccess.getPropertyRule()); }
	 ruleProperty
{ after(grammarAccess.getPropertyRule()); } 
	 EOF 
;

// Rule Property
ruleProperty 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPropertyAccess().getGroup()); }
		(rule__Property__Group__0)
		{ after(grammarAccess.getPropertyAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleType
entryRuleType
:
{ before(grammarAccess.getTypeRule()); }
	 ruleType
{ after(grammarAccess.getTypeRule()); } 
	 EOF 
;

// Rule Type
ruleType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeAccess().getGroup()); }
		(rule__Type__Group__0)
		{ after(grammarAccess.getTypeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTypeReference
entryRuleTypeReference
:
{ before(grammarAccess.getTypeReferenceRule()); }
	 ruleTypeReference
{ after(grammarAccess.getTypeReferenceRule()); } 
	 EOF 
;

// Rule TypeReference
ruleTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); }
		(rule__TypeReference__TypeRefAssignment)
		{ after(grammarAccess.getTypeReferenceAccess().getTypeRefAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRulePrimitiveType
entryRulePrimitiveType
:
{ before(grammarAccess.getPrimitiveTypeRule()); }
	 rulePrimitiveType
{ after(grammarAccess.getPrimitiveTypeRule()); } 
	 EOF 
;

// Rule PrimitiveType
rulePrimitiveType 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); }
		(rule__PrimitiveType__NameAssignment)
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameAssignment()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Alternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0()); }
		ruleTypeReference
		{ after(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1()); }
		rulePrimitiveType
		{ after(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveType__NameAlternatives_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); }
		'string'
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0()); }
	)
	|
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); }
		'int'
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1()); }
	)
	|
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); }
		'boolean'
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__0__Impl
	rule__TypeDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); }
	'type'
	{ after(grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__1__Impl
	rule__TypeDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); }
	(rule__TypeDeclaration__NameAssignment_1)
	{ after(grammarAccess.getTypeDeclarationAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__2__Impl
	rule__TypeDeclaration__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getGroup_2()); }
	(rule__TypeDeclaration__Group_2__0)?
	{ after(grammarAccess.getTypeDeclarationAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__3__Impl
	rule__TypeDeclaration__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); }
	'{'
	{ after(grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__4__Impl
	rule__TypeDeclaration__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); }
	(rule__TypeDeclaration__PropertiesAssignment_4)*
	{ after(grammarAccess.getTypeDeclarationAccess().getPropertiesAssignment_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group__5__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); }
	'}'
	{ after(grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TypeDeclaration__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group_2__0__Impl
	rule__TypeDeclaration__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); }
	'extends'
	{ after(grammarAccess.getTypeDeclarationAccess().getExtendsKeyword_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TypeDeclaration__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); }
	(rule__TypeDeclaration__SuperTypeAssignment_2_1)
	{ after(grammarAccess.getTypeDeclarationAccess().getSuperTypeAssignment_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Property__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Property__Group__0__Impl
	rule__Property__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPropertyAccess().getTypeAssignment_0()); }
	(rule__Property__TypeAssignment_0)
	{ after(grammarAccess.getPropertyAccess().getTypeAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Property__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getPropertyAccess().getNameAssignment_1()); }
	(rule__Property__NameAssignment_1)
	{ after(grammarAccess.getPropertyAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group__0__Impl
	rule__Type__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getAlternatives_0()); }
	(rule__Type__Alternatives_0)
	{ after(grammarAccess.getTypeAccess().getAlternatives_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getGroup_1()); }
	(rule__Type__Group_1__0)*
	{ after(grammarAccess.getTypeAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Type__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_1__0__Impl
	rule__Type__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); }
	(rule__Type__ArrayDiemensionsAssignment_1_0)
	{ after(grammarAccess.getTypeAccess().getArrayDiemensionsAssignment_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Type__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); }
	']'
	{ after(grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Model__TypesAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0()); }
		ruleTypeDeclaration
		{ after(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__SuperTypeAssignment_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); }
		(
			{ before(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationIDTerminalRuleCall_2_1_0_1()); }
		)
		{ after(grammarAccess.getTypeDeclarationAccess().getSuperTypeTypeDeclarationCrossReference_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeDeclaration__PropertiesAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); }
		ruleProperty
		{ after(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_4_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__TypeAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0()); }
		ruleType
		{ after(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Property__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Type__ArrayDiemensionsAssignment_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); }
		(
			{ before(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); }
			'['
			{ after(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); }
		)
		{ after(grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TypeReference__TypeRefAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); }
		(
			{ before(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationIDTerminalRuleCall_0_1()); }
			RULE_ID
			{ after(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationIDTerminalRuleCall_0_1()); }
		)
		{ after(grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PrimitiveType__NameAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); }
		(rule__PrimitiveType__NameAlternatives_0)
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameAlternatives_0()); }
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
