/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.Attribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.LookAheadContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.lookAheadContentAssistTest.Pair;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.LookAheadContentAssistTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class LookAheadContentAssistTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private LookAheadContentAssistTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == LookAheadContentAssistTestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case LookAheadContentAssistTestPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case LookAheadContentAssistTestPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case LookAheadContentAssistTestPackage.PAIR:
				sequence_Pair(context, (Pair) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     value=ID
	 * </pre>
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LookAheadContentAssistTestPackage.Literals.ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookAheadContentAssistTestPackage.Literals.ATTRIBUTE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAttributeAccess().getValueIDTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         (attribute+=Attribute* attribute+=Pair*) | 
	 *         (attribute+=Attribute+ attribute+=Pair*) | 
	 *         (attribute+=Attribute* attribute+=Pair+) | 
	 *         (attribute+=Attribute+ attribute+=Pair+)
	 *     )
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Pair returns Pair
	 *
	 * Constraint:
	 *     (name=ID value=ID)
	 * </pre>
	 */
	protected void sequence_Pair(ISerializationContext context, Pair semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LookAheadContentAssistTestPackage.Literals.PAIR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookAheadContentAssistTestPackage.Literals.PAIR__NAME));
			if (transientValues.isValueTransient(semanticObject, LookAheadContentAssistTestPackage.Literals.PAIR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LookAheadContentAssistTestPackage.Literals.PAIR__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPairAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPairAccess().getValueIDTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
