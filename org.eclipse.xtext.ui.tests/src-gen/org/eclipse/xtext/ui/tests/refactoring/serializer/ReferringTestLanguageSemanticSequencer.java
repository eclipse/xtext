/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.serializer;

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
import org.eclipse.xtext.ui.tests.refactoring.referring.Main;
import org.eclipse.xtext.ui.tests.refactoring.referring.Named;
import org.eclipse.xtext.ui.tests.refactoring.referring.Reference;
import org.eclipse.xtext.ui.tests.refactoring.referring.ReferringPackage;
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class ReferringTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ReferringTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ReferringPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ReferringPackage.MAIN:
				sequence_Main(context, (Main) semanticObject); 
				return; 
			case ReferringPackage.NAMED:
				if (rule == grammarAccess.getNamedRule()) {
					sequence_Named(context, (Named) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getAbstractReferenceRule()
						|| rule == grammarAccess.getReference2Rule()) {
					sequence_Named_Reference2(context, (Named) semanticObject); 
					return; 
				}
				else break;
			case ReferringPackage.REFERENCE:
				sequence_Reference(context, (Reference) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Main returns Main
	 *
	 * Constraint:
	 *     referenced+=AbstractReference+
	 * </pre>
	 */
	protected void sequence_Main(ISerializationContext context, Main semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Named returns Named
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Named(ISerializationContext context, Named semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ReferringPackage.Literals.NAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferringPackage.Literals.NAMED__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractReference returns Named
	 *     Reference2 returns Named
	 *
	 * Constraint:
	 *     (name=ID referenced=[EObject|FQN])
	 * </pre>
	 */
	protected void sequence_Named_Reference2(ISerializationContext context, Named semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ReferringPackage.Literals.NAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferringPackage.Literals.NAMED__NAME));
			if (transientValues.isValueTransient(semanticObject, ReferringPackage.Literals.NAMED__REFERENCED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferringPackage.Literals.NAMED__REFERENCED));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getReference2Access().getReferencedEObjectFQNParserRuleCall_2_0_1(), semanticObject.eGet(ReferringPackage.Literals.NAMED__REFERENCED, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AbstractReference returns Reference
	 *     Reference returns Reference
	 *
	 * Constraint:
	 *     referenced=[EObject|FQN]
	 * </pre>
	 */
	protected void sequence_Reference(ISerializationContext context, Reference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ReferringPackage.Literals.REFERENCE__REFERENCED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferringPackage.Literals.REFERENCE__REFERENCED));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReferenceAccess().getReferencedEObjectFQNParserRuleCall_1_0_1(), semanticObject.eGet(ReferringPackage.Literals.REFERENCE__REFERENCED, false));
		feeder.finish();
	}
	
	
}
