/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar InternalXtype;

options {
	superClass=AbstractInternalContentAssistParser;
	backtrack=true;
}

@lexer::header {
package org.eclipse.xtext.xbase.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.xtext.xbase.ide.contentassist.antlr.internal;

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
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;

}
@parser::members {
	private XtypeGrammarAccess grammarAccess;

	public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
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

// Entry rule entryRuleJvmTypeReference
entryRuleJvmTypeReference
:
{ before(grammarAccess.getJvmTypeReferenceRule()); }
	 ruleJvmTypeReference
{ after(grammarAccess.getJvmTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmTypeReference
ruleJvmTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); }
		(rule__JvmTypeReference__Alternatives)
		{ after(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleArrayBrackets
entryRuleArrayBrackets
:
{ before(grammarAccess.getArrayBracketsRule()); }
	 ruleArrayBrackets
{ after(grammarAccess.getArrayBracketsRule()); } 
	 EOF 
;

// Rule ArrayBrackets
ruleArrayBrackets 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getArrayBracketsAccess().getGroup()); }
		(rule__ArrayBrackets__Group__0)
		{ after(grammarAccess.getArrayBracketsAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXFunctionTypeRef
entryRuleXFunctionTypeRef
:
{ before(grammarAccess.getXFunctionTypeRefRule()); }
	 ruleXFunctionTypeRef
{ after(grammarAccess.getXFunctionTypeRefRule()); } 
	 EOF 
;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup()); }
		(rule__XFunctionTypeRef__Group__0)
		{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmParameterizedTypeReference
entryRuleJvmParameterizedTypeReference
:
{ before(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
	 ruleJvmParameterizedTypeReference
{ after(grammarAccess.getJvmParameterizedTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); }
		(rule__JvmParameterizedTypeReference__Group__0)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmArgumentTypeReference
entryRuleJvmArgumentTypeReference
:
{ before(grammarAccess.getJvmArgumentTypeReferenceRule()); }
	 ruleJvmArgumentTypeReference
{ after(grammarAccess.getJvmArgumentTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); }
		(rule__JvmArgumentTypeReference__Alternatives)
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmWildcardTypeReference
entryRuleJvmWildcardTypeReference
:
{ before(grammarAccess.getJvmWildcardTypeReferenceRule()); }
	 ruleJvmWildcardTypeReference
{ after(grammarAccess.getJvmWildcardTypeReferenceRule()); } 
	 EOF 
;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); }
		(rule__JvmWildcardTypeReference__Group__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmUpperBound
entryRuleJvmUpperBound
:
{ before(grammarAccess.getJvmUpperBoundRule()); }
	 ruleJvmUpperBound
{ after(grammarAccess.getJvmUpperBoundRule()); } 
	 EOF 
;

// Rule JvmUpperBound
ruleJvmUpperBound 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmUpperBoundAccess().getGroup()); }
		(rule__JvmUpperBound__Group__0)
		{ after(grammarAccess.getJvmUpperBoundAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmUpperBoundAnded
entryRuleJvmUpperBoundAnded
:
{ before(grammarAccess.getJvmUpperBoundAndedRule()); }
	 ruleJvmUpperBoundAnded
{ after(grammarAccess.getJvmUpperBoundAndedRule()); } 
	 EOF 
;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); }
		(rule__JvmUpperBoundAnded__Group__0)
		{ after(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmLowerBound
entryRuleJvmLowerBound
:
{ before(grammarAccess.getJvmLowerBoundRule()); }
	 ruleJvmLowerBound
{ after(grammarAccess.getJvmLowerBoundRule()); } 
	 EOF 
;

// Rule JvmLowerBound
ruleJvmLowerBound 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmLowerBoundAccess().getGroup()); }
		(rule__JvmLowerBound__Group__0)
		{ after(grammarAccess.getJvmLowerBoundAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleJvmLowerBoundAnded
entryRuleJvmLowerBoundAnded
:
{ before(grammarAccess.getJvmLowerBoundAndedRule()); }
	 ruleJvmLowerBoundAnded
{ after(grammarAccess.getJvmLowerBoundAndedRule()); } 
	 EOF 
;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); }
		(rule__JvmLowerBoundAnded__Group__0)
		{ after(grammarAccess.getJvmLowerBoundAndedAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
		(rule__QualifiedName__Group__0)
		{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedNameWithWildcard
entryRuleQualifiedNameWithWildcard
:
{ before(grammarAccess.getQualifiedNameWithWildcardRule()); }
	 ruleQualifiedNameWithWildcard
{ after(grammarAccess.getQualifiedNameWithWildcardRule()); } 
	 EOF 
;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); }
		(rule__QualifiedNameWithWildcard__Group__0)
		{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleValidID
entryRuleValidID
:
{ before(grammarAccess.getValidIDRule()); }
	 ruleValidID
{ after(grammarAccess.getValidIDRule()); } 
	 EOF 
;

// Rule ValidID
ruleValidID 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); }
		RULE_ID
		{ after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleXImportDeclaration
entryRuleXImportDeclaration
:
{ before(grammarAccess.getXImportDeclarationRule()); }
	 ruleXImportDeclaration
{ after(grammarAccess.getXImportDeclarationRule()); } 
	 EOF 
;

// Rule XImportDeclaration
ruleXImportDeclaration 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getGroup()); }
		(rule__XImportDeclaration__Group__0)
		{ after(grammarAccess.getXImportDeclarationAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleQualifiedNameInStaticImport
entryRuleQualifiedNameInStaticImport
:
{ before(grammarAccess.getQualifiedNameInStaticImportRule()); }
	 ruleQualifiedNameInStaticImport
{ after(grammarAccess.getQualifiedNameInStaticImportRule()); } 
	 EOF 
;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
			(rule__QualifiedNameInStaticImport__Group__0)
			{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
		)
		(
			{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
			(rule__QualifiedNameInStaticImport__Group__0)*
			{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getGroup()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); }
		(rule__JvmTypeReference__Group_0__0)
		{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); }
		ruleXFunctionTypeRef
		{ after(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmArgumentTypeReference__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); }
		ruleJvmWildcardTypeReference
		{ after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Alternatives_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); }
		(rule__JvmWildcardTypeReference__Group_2_0__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_0()); }
	)
	|
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); }
		(rule__JvmWildcardTypeReference__Group_2_1__0)
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup_2_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Alternatives_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); }
		(rule__XImportDeclaration__Group_1_0__0)
		{ after(grammarAccess.getXImportDeclarationAccess().getGroup_1_0()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); }
		(rule__XImportDeclaration__ImportedTypeAssignment_1_1)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); }
		(rule__XImportDeclaration__ImportedNamespaceAssignment_1_2)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceAssignment_1_2()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Alternatives_1_0_3
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); }
		(rule__XImportDeclaration__WildcardAssignment_1_0_3_0)
		{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_1_0_3_0()); }
	)
	|
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); }
		(rule__XImportDeclaration__MemberNameAssignment_1_0_3_1)
		{ after(grammarAccess.getXImportDeclarationAccess().getMemberNameAssignment_1_0_3_1()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0__0__Impl
	rule__JvmTypeReference__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); }
	ruleJvmParameterizedTypeReference
	{ after(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); }
	(rule__JvmTypeReference__Group_0_1__0)*
	{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeReference__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); }
	(rule__JvmTypeReference__Group_0_1_0__0)
	{ after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmTypeReference__Group_0_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1_0__0__Impl
	rule__JvmTypeReference__Group_0_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
	()
	{ after(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmTypeReference__Group_0_1_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmTypeReference__Group_0_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
	ruleArrayBrackets
	{ after(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ArrayBrackets__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayBrackets__Group__0__Impl
	rule__ArrayBrackets__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); }
	'['
	{ after(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ArrayBrackets__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ArrayBrackets__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); }
	']'
	{ after(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__0__Impl
	rule__XFunctionTypeRef__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); }
	(rule__XFunctionTypeRef__Group_0__0)?
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__1__Impl
	rule__XFunctionTypeRef__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
	'=>'
	{ after(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); }
	(rule__XFunctionTypeRef__ReturnTypeAssignment_2)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__0__Impl
	rule__XFunctionTypeRef__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); }
	'('
	{ after(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__1__Impl
	rule__XFunctionTypeRef__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); }
	(rule__XFunctionTypeRef__Group_0_1__0)?
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); }
	')'
	{ after(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1__0__Impl
	rule__XFunctionTypeRef__Group_0_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); }
	(rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); }
	(rule__XFunctionTypeRef__Group_0_1_1__0)*
	{ after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__Group_0_1_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1_1__0__Impl
	rule__XFunctionTypeRef__Group_0_1_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); }
	','
	{ after(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XFunctionTypeRef__Group_0_1_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__Group_0_1_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
	(rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1)
	{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group__0__Impl
	rule__JvmParameterizedTypeReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); }
	(rule__JvmParameterizedTypeReference__TypeAssignment_0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); }
	(rule__JvmParameterizedTypeReference__Group_1__0)?
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__0__Impl
	rule__JvmParameterizedTypeReference__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); }
	('<')
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__1__Impl
	rule__JvmParameterizedTypeReference__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__2__Impl
	rule__JvmParameterizedTypeReference__Group_1__3
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_2__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__3__Impl
	rule__JvmParameterizedTypeReference__Group_1__4
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); }
	'>'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__4
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1__4__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1__4__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); }
	(rule__JvmParameterizedTypeReference__Group_1_4__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); }
	','
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_0__0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__1__Impl
	rule__JvmParameterizedTypeReference__Group_1_4__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); }
	(rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_2__0)?
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_0_0__0)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_0_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
	()
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_0_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); }
	'.'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); }
	('<')
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2__3
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); }
	(rule__JvmParameterizedTypeReference__Group_1_4_2_2__0)*
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_4_2_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); }
	'>'
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmParameterizedTypeReference__Group_1_4_2_2__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); }
	','
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__Group_1_4_2_2__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); }
	(rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1)
	{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_4_2_2_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__0__Impl
	rule__JvmWildcardTypeReference__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); }
	()
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__1__Impl
	rule__JvmWildcardTypeReference__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); }
	'?'
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); }
	(rule__JvmWildcardTypeReference__Alternatives_2)?
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group_2_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_0__0__Impl
	rule__JvmWildcardTypeReference__Group_2_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0)
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_0__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1)*
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmWildcardTypeReference__Group_2_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_1__0__Impl
	rule__JvmWildcardTypeReference__Group_2_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0)
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmWildcardTypeReference__Group_2_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__Group_2_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); }
	(rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1)*
	{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmUpperBound__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBound__Group__0__Impl
	rule__JvmUpperBound__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); }
	'extends'
	{ after(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBound__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmUpperBound__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmUpperBoundAnded__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBoundAnded__Group__0__Impl
	rule__JvmUpperBoundAnded__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); }
	'&'
	{ after(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmUpperBoundAnded__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmUpperBoundAnded__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmLowerBound__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBound__Group__0__Impl
	rule__JvmLowerBound__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); }
	'super'
	{ after(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBound__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmLowerBound__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__JvmLowerBoundAnded__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBoundAnded__Group__0__Impl
	rule__JvmLowerBoundAnded__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); }
	'&'
	{ after(grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__JvmLowerBoundAnded__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); }
	(rule__JvmLowerBoundAnded__TypeReferenceAssignment_1)
	{ after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
	(rule__QualifiedName__Group_1__0)*
	{ after(grammarAccess.getQualifiedNameAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__0__Impl
	rule__QualifiedName__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
	'.'
	{ after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedName__Group_1__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedNameWithWildcard__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__0__Impl
	rule__QualifiedNameWithWildcard__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); }
	ruleQualifiedName
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__1__Impl
	rule__QualifiedNameWithWildcard__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameWithWildcard__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameWithWildcard__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); }
	'*'
	{ after(grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XImportDeclaration__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__0__Impl
	rule__XImportDeclaration__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); }
	'import'
	{ after(grammarAccess.getXImportDeclarationAccess().getImportKeyword_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__1__Impl
	rule__XImportDeclaration__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); }
	(rule__XImportDeclaration__Alternatives_1)
	{ after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); }
	(';')?
	{ after(grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XImportDeclaration__Group_1_0__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__0__Impl
	rule__XImportDeclaration__Group_1_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); }
	(rule__XImportDeclaration__StaticAssignment_1_0_0)
	{ after(grammarAccess.getXImportDeclarationAccess().getStaticAssignment_1_0_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__1__Impl
	rule__XImportDeclaration__Group_1_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); }
	(rule__XImportDeclaration__ExtensionAssignment_1_0_1)?
	{ after(grammarAccess.getXImportDeclarationAccess().getExtensionAssignment_1_0_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__2__Impl
	rule__XImportDeclaration__Group_1_0__3
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); }
	(rule__XImportDeclaration__ImportedTypeAssignment_1_0_2)
	{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__XImportDeclaration__Group_1_0__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__Group_1_0__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); }
	(rule__XImportDeclaration__Alternatives_1_0_3)
	{ after(grammarAccess.getXImportDeclarationAccess().getAlternatives_1_0_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedNameInStaticImport__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameInStaticImport__Group__0__Impl
	rule__QualifiedNameInStaticImport__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); }
	ruleValidID
	{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__QualifiedNameInStaticImport__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedNameInStaticImport__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); }
	'.'
	{ after(grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XFunctionTypeRef__ReturnTypeAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__TypeAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); }
		(
			{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); }
		)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__TypeAssignment_1_4_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
		(
			{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
			ruleValidID
			{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeValidIDParserRuleCall_1_4_1_0_1()); }
		)
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_4_2_2_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
		ruleJvmArgumentTypeReference
		{ after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); }
		ruleJvmUpperBound
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); }
		ruleJvmUpperBoundAnded
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); }
		ruleJvmLowerBound
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); }
		ruleJvmLowerBoundAnded
		{ after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBound__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBound__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__JvmLowerBoundAnded__TypeReferenceAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
		ruleJvmTypeReference
		{ after(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__StaticAssignment_1_0_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
			'static'
			{ after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ExtensionAssignment_1_0_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
			'extension'
			{ after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedTypeAssignment_1_0_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); }
			ruleQualifiedNameInStaticImport
			{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameInStaticImportParserRuleCall_1_0_2_0_1()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__WildcardAssignment_1_0_3_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
			'*'
			{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__MemberNameAssignment_1_0_3_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); }
		ruleValidID
		{ after(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedTypeAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); }
		(
			{ before(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); }
			ruleQualifiedName
			{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeQualifiedNameParserRuleCall_1_1_0_1()); }
		)
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__XImportDeclaration__ImportedNamespaceAssignment_1_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); }
		ruleQualifiedNameWithWildcard
		{ after(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
