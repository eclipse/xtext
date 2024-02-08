/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalContentAssistNoTerminalExtensionTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;

}

@parser::members {

 	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;

    public InternalContentAssistNoTerminalExtensionTestLanguageParser(TokenStream input, ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "PolygonBasedShape";
   	}

   	@Override
   	protected ContentAssistNoTerminalExtensionTestLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRulePolygonBasedShape
entryRulePolygonBasedShape returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPolygonBasedShapeRule()); }
	iv_rulePolygonBasedShape=rulePolygonBasedShape
	{ $current=$iv_rulePolygonBasedShape.current; }
	EOF;

// Rule PolygonBasedShape
rulePolygonBasedShape returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0());
			}
			lv_shape_0_0=rulePolygonBasedNodeShape
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getPolygonBasedShapeRule());
				}
				add(
					$current,
					"shape",
					lv_shape_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage.PolygonBasedNodeShape");
				afterParserOrEnumRuleCall();
			}
		)
	)+
;

// Rule PolygonBasedNodeShape
rulePolygonBasedNodeShape returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='octagon'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='oval'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='parallelogram'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='pentagon'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3());
			}
		)
		    |
		(
			enumLiteral_4='plain'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_4, grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4());
			}
		)
		    |
		(
			enumLiteral_5='plaintext'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_5, grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5());
			}
		)
		    |
		(
			enumLiteral_6='point'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_6, grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6());
			}
		)
		    |
		(
			enumLiteral_7='polygon'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_7, grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7());
			}
		)
		    |
		(
			enumLiteral_8='primersite'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_8, grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8());
			}
		)
		    |
		(
			enumLiteral_9='promoter'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_9, grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9());
			}
		)
		    |
		(
			enumLiteral_10='proteasesite'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_10, grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10());
			}
		)
		    |
		(
			enumLiteral_11='proteinstab'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_11, grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11());
			}
		)
		    |
		(
			enumLiteral_12='rarrow'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_12, grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12());
			}
		)
		    |
		(
			enumLiteral_13='record'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_13, grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13());
			}
		)
		    |
		(
			enumLiteral_14='rect'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_14, grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14());
			}
		)
		    |
		(
			enumLiteral_15='rectangle'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_15, grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15());
			}
		)
		    |
		(
			enumLiteral_16='restrictionsite'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_16, grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16());
			}
		)
		    |
		(
			enumLiteral_17='ribosite'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_17, grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17());
			}
		)
		    |
		(
			enumLiteral_18='rnastab'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_18, grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18());
			}
		)
		    |
		(
			enumLiteral_19='rpromoter'
			{
				$current = grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_19, grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19());
			}
		)
	)
;

RULE_WS : ' '+;
