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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;

}
@parser::members {
	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;

	public void setGrammarAccess(ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess) {
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

// Entry rule entryRulePolygonBasedShape
entryRulePolygonBasedShape
:
{ before(grammarAccess.getPolygonBasedShapeRule()); }
	 rulePolygonBasedShape
{ after(grammarAccess.getPolygonBasedShapeRule()); } 
	 EOF 
;

// Rule PolygonBasedShape
rulePolygonBasedShape 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		(
			{ before(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); }
			(rule__PolygonBasedShape__ShapeAssignment)
			{ after(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); }
		)
		(
			{ before(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); }
			(rule__PolygonBasedShape__ShapeAssignment)*
			{ after(grammarAccess.getPolygonBasedShapeAccess().getShapeAssignment()); }
		)
	)
;
finally {
	restoreStackSize(stackSize);
}

// Rule PolygonBasedNodeShape
rulePolygonBasedNodeShape
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getAlternatives()); }
		(rule__PolygonBasedNodeShape__Alternatives)
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getAlternatives()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PolygonBasedNodeShape__Alternatives
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0()); }
		('octagon')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getOctagonEnumLiteralDeclaration_0()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1()); }
		('oval')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getOvalEnumLiteralDeclaration_1()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2()); }
		('parallelogram')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getParallelogramEnumLiteralDeclaration_2()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3()); }
		('pentagon')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPentagonEnumLiteralDeclaration_3()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4()); }
		('plain')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPlainEnumLiteralDeclaration_4()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5()); }
		('plaintext')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPlaintextEnumLiteralDeclaration_5()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6()); }
		('point')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPointEnumLiteralDeclaration_6()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7()); }
		('polygon')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPolygonEnumLiteralDeclaration_7()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8()); }
		('primersite')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPrimersiteEnumLiteralDeclaration_8()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9()); }
		('promoter')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getPromoterEnumLiteralDeclaration_9()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10()); }
		('proteasesite')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getProteasesiteEnumLiteralDeclaration_10()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11()); }
		('proteinstab')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getProteinstabEnumLiteralDeclaration_11()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12()); }
		('rarrow')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRarrowEnumLiteralDeclaration_12()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13()); }
		('record')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRecordEnumLiteralDeclaration_13()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14()); }
		('rect')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRectEnumLiteralDeclaration_14()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15()); }
		('rectangle')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRectangleEnumLiteralDeclaration_15()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16()); }
		('restrictionsite')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRestrictionsiteEnumLiteralDeclaration_16()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17()); }
		('ribosite')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRibositeEnumLiteralDeclaration_17()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18()); }
		('rnastab')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRnastabEnumLiteralDeclaration_18()); }
	)
	|
	(
		{ before(grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19()); }
		('rpromoter')
		{ after(grammarAccess.getPolygonBasedNodeShapeAccess().getRpromoterEnumLiteralDeclaration_19()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__PolygonBasedShape__ShapeAssignment
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0()); }
		rulePolygonBasedNodeShape
		{ after(grammarAccess.getPolygonBasedShapeAccess().getShapePolygonBasedNodeShapeEnumRuleCall_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

RULE_WS : ' '+;
