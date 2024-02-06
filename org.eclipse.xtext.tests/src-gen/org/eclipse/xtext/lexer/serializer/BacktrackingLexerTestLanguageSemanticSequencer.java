/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.lexer.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Model;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class BacktrackingLexerTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BacktrackingLexerTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BacktrackingTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BacktrackingTestLanguagePackage.AB:
				sequence_Ab(context, (Ab) semanticObject); 
				return; 
			case BacktrackingTestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case BacktrackingTestLanguagePackage.XB:
				sequence_Xb(context, (Xb) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Ab returns Ab
	 *
	 * Constraint:
	 *     (x=CharA y=Charb)
	 * </pre>
	 */
	protected void sequence_Ab(ISerializationContext context, Ab semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__X));
			if (transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__Y));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         (enums+=EnumName* ((xbs+=Xb+ as+=CharA+) | as+=CharA+)) | 
	 *         (enums+=EnumName* ycs+=Yc+ ((xbs+=Xb+ as+=CharA+) | as+=CharA+)) | 
	 *         (((enums+=EnumName* abs+=Ab+) | (enums+=EnumName* ycs+=Yc+ abs+=Ab+) | abs+=Ab+) ((xbs+=Xb+ as+=CharA+) | as+=CharA+)) | 
	 *         (
	 *             ((enums+=EnumName* ((abs+=Ab+ xbs+=Xb+) | xbs+=Xb+)) | (enums+=EnumName* ycs+=Yc+ ((abs+=Ab+ xbs+=Xb+) | xbs+=Xb+)) | (abs+=Ab+ xbs+=Xb+) | xbs+=Xb+)? 
	 *             ys+=CharY+ 
	 *             as+=CharA+
	 *         ) | 
	 *         (xbs+=Xb+ as+=CharA+) | 
	 *         as+=CharA+
	 *     )?
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Xb returns Xb
	 *
	 * Constraint:
	 *     (x=CharX y=Charb)
	 * </pre>
	 */
	protected void sequence_Xb(ISerializationContext context, Xb semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__X));
			if (transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__Y));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
}
