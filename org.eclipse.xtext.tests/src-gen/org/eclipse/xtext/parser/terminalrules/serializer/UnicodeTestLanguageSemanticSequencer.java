/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.unicode.GString;
import org.eclipse.xtext.parser.terminalrules.unicode.Model;
import org.eclipse.xtext.parser.terminalrules.unicode.QuotedString;
import org.eclipse.xtext.parser.terminalrules.unicode.UnicodePackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class UnicodeTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UnicodeTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UnicodePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UnicodePackage.GSTRING:
				sequence_GString(context, (GString) semanticObject); 
				return; 
			case UnicodePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case UnicodePackage.QUOTED_STRING:
				sequence_QuotedString(context, (QuotedString) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractString returns GString
	 *     GString returns GString
	 *
	 * Constraint:
	 *     name=GERMAN_STRING
	 * </pre>
	 */
	protected void sequence_GString(ISerializationContext context, GString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGStringAccess().getNameGERMAN_STRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     strings+=AbstractString+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractString returns QuotedString
	 *     QuotedString returns QuotedString
	 *
	 * Constraint:
	 *     name=STRING
	 * </pre>
	 */
	protected void sequence_QuotedString(ISerializationContext context, QuotedString semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getQuotedStringAccess().getNameSTRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
