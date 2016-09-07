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

// Entry rule entryRuleMember
entryRuleMember
:
{ before(grammarAccess.getMemberRule()); }
	 ruleMember
{ after(grammarAccess.getMemberRule()); } 
	 EOF 
;

// Rule Member
ruleMember 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getMemberAccess().getAlternatives()); }
		(rule__Member__Alternatives)
		{ after(grammarAccess.getMemberAccess().getAlternatives()); }
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

// Entry rule entryRuleOperation
entryRuleOperation
:
{ before(grammarAccess.getOperationRule()); }
	 ruleOperation
{ after(grammarAccess.getOperationRule()); } 
	 EOF 
;

// Rule Operation
ruleOperation 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperationAccess().getGroup()); }
		(rule__Operation__Group__0)
		{ after(grammarAccess.getOperationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOperationCall
entryRuleOperationCall
:
{ before(grammarAccess.getOperationCallRule()); }
	 ruleOperationCall
{ after(grammarAccess.getOperationCallRule()); } 
	 EOF 
;

// Rule OperationCall
ruleOperationCall 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOperationCallAccess().getGroup()); }
		(rule__OperationCall__Group__0)
		{ after(grammarAccess.getOperationCallAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleParameter
entryRuleParameter
:
{ before(grammarAccess.getParameterRule()); }
	 ruleParameter
{ after(grammarAccess.getParameterRule()); } 
	 EOF 
;

// Rule Parameter
ruleParameter 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getParameterAccess().getGroup()); }
		(rule__Parameter__Group__0)
		{ after(grammarAccess.getParameterAccess().getGroup()); }
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

rule__Member__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getMemberAccess().getPropertyParserRuleCall_0()); }
		ruleProperty
		{ after(grammarAccess.getMemberAccess().getPropertyParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getMemberAccess().getOperationParserRuleCall_1()); }
		ruleOperation
		{ after(grammarAccess.getMemberAccess().getOperationParserRuleCall_1()); }
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
	|
	(
		{ before(grammarAccess.getPrimitiveTypeAccess().getNameVoidKeyword_0_3()); }
		'void'
		{ after(grammarAccess.getPrimitiveTypeAccess().getNameVoidKeyword_0_3()); }
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
	{ before(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4()); }
	(rule__TypeDeclaration__MembersAssignment_4)*
	{ after(grammarAccess.getTypeDeclarationAccess().getMembersAssignment_4()); }
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


rule__Operation__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__0__Impl
	rule__Operation__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getOperationAction_0()); }
	()
	{ after(grammarAccess.getOperationAccess().getOperationAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__1__Impl
	rule__Operation__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getOpKeyword_1()); }
	'op'
	{ after(grammarAccess.getOperationAccess().getOpKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__2__Impl
	rule__Operation__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getNameAssignment_2()); }
	(rule__Operation__NameAssignment_2)
	{ after(grammarAccess.getOperationAccess().getNameAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__3__Impl
	rule__Operation__Group__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); }
	'('
	{ after(grammarAccess.getOperationAccess().getLeftParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__4__Impl
	rule__Operation__Group__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getGroup_4()); }
	(rule__Operation__Group_4__0)?
	{ after(grammarAccess.getOperationAccess().getGroup_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__5
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__5__Impl
	rule__Operation__Group__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__5__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); }
	')'
	{ after(grammarAccess.getOperationAccess().getRightParenthesisKeyword_5()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__6
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__6__Impl
	rule__Operation__Group__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__6__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getGroup_6()); }
	(rule__Operation__Group_6__0)?
	{ after(grammarAccess.getOperationAccess().getGroup_6()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__7
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__7__Impl
	rule__Operation__Group__8
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__7__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7()); }
	'{'
	{ after(grammarAccess.getOperationAccess().getLeftCurlyBracketKeyword_7()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__8
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__8__Impl
	rule__Operation__Group__9
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__8__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getOperationCallAssignment_8()); }
	(rule__Operation__OperationCallAssignment_8)?
	{ after(grammarAccess.getOperationAccess().getOperationCallAssignment_8()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__9
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group__9__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group__9__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_9()); }
	'}'
	{ after(grammarAccess.getOperationAccess().getRightCurlyBracketKeyword_9()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Operation__Group_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_4__0__Impl
	rule__Operation__Group_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); }
	(rule__Operation__ParamsAssignment_4_0)
	{ after(grammarAccess.getOperationAccess().getParamsAssignment_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_4__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getGroup_4_1()); }
	(rule__Operation__Group_4_1__0)*
	{ after(grammarAccess.getOperationAccess().getGroup_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Operation__Group_4_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_4_1__0__Impl
	rule__Operation__Group_4_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); }
	','
	{ after(grammarAccess.getOperationAccess().getCommaKeyword_4_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_4_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_4_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); }
	(rule__Operation__ParamsAssignment_4_1_1)
	{ after(grammarAccess.getOperationAccess().getParamsAssignment_4_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Operation__Group_6__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_6__0__Impl
	rule__Operation__Group_6__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_6__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getColonKeyword_6_0()); }
	':'
	{ after(grammarAccess.getOperationAccess().getColonKeyword_6_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_6__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Operation__Group_6__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__Group_6__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1()); }
	(rule__Operation__ReturnTypeAssignment_6_1)
	{ after(grammarAccess.getOperationAccess().getReturnTypeAssignment_6_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCall__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group__0__Impl
	rule__OperationCall__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getOperationAssignment_0()); }
	(rule__OperationCall__OperationAssignment_0)
	{ after(grammarAccess.getOperationCallAccess().getOperationAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group__1__Impl
	rule__OperationCall__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1()); }
	'('
	{ after(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group__2__Impl
	rule__OperationCall__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getGroup_2()); }
	(rule__OperationCall__Group_2__0)?
	{ after(grammarAccess.getOperationCallAccess().getGroup_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3()); }
	')'
	{ after(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCall__Group_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group_2__0__Impl
	rule__OperationCall__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0()); }
	(rule__OperationCall__ParamsAssignment_2_0)
	{ after(grammarAccess.getOperationCallAccess().getParamsAssignment_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getGroup_2_1()); }
	(rule__OperationCall__Group_2_1__0)*
	{ after(grammarAccess.getOperationCallAccess().getGroup_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OperationCall__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group_2_1__0__Impl
	rule__OperationCall__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0()); }
	','
	{ after(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OperationCall__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1()); }
	(rule__OperationCall__ParamsAssignment_2_1_1)
	{ after(grammarAccess.getOperationCallAccess().getParamsAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Parameter__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__0__Impl
	rule__Parameter__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getParameterAction_0()); }
	()
	{ after(grammarAccess.getParameterAccess().getParameterAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__1__Impl
	rule__Parameter__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getNameAssignment_1()); }
	(rule__Parameter__NameAssignment_1)
	{ after(grammarAccess.getParameterAccess().getNameAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__2__Impl
	rule__Parameter__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getColonKeyword_2()); }
	':'
	{ after(grammarAccess.getParameterAccess().getColonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Parameter__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getParameterAccess().getTypeAssignment_3()); }
	(rule__Parameter__TypeAssignment_3)
	{ after(grammarAccess.getParameterAccess().getTypeAssignment_3()); }
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

rule__TypeDeclaration__MembersAssignment_4
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0()); }
		ruleMember
		{ after(grammarAccess.getTypeDeclarationAccess().getMembersMemberParserRuleCall_4_0()); }
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

rule__Operation__NameAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); }
		RULE_ID
		{ after(grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__ParamsAssignment_4_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); }
		ruleParameter
		{ after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__ParamsAssignment_4_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); }
		ruleParameter
		{ after(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_4_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__ReturnTypeAssignment_6_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0()); }
		ruleType
		{ after(grammarAccess.getOperationAccess().getReturnTypeTypeParserRuleCall_6_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Operation__OperationCallAssignment_8
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0()); }
		ruleOperationCall
		{ after(grammarAccess.getOperationAccess().getOperationCallOperationCallParserRuleCall_8_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__OperationAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0()); }
		(
			{ before(grammarAccess.getOperationCallAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); }
			RULE_ID
			{ after(grammarAccess.getOperationCallAccess().getOperationOperationIDTerminalRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getOperationCallAccess().getOperationOperationCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__ParamsAssignment_2_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_0_0()); }
		RULE_INT
		{ after(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OperationCall__ParamsAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_1_1_0()); }
		RULE_INT
		{ after(grammarAccess.getOperationCallAccess().getParamsINTTerminalRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__NameAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); }
		RULE_ID
		{ after(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Parameter__TypeAssignment_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0()); }
		ruleType
		{ after(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_3_0()); }
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
