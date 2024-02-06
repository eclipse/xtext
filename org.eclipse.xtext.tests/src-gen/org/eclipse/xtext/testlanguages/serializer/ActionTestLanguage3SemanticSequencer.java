/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.serializer;

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
import org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Package;
import org.eclipse.xtext.testlanguages.actionLang3.Entry;
import org.eclipse.xtext.testlanguages.actionLang3.P1;
import org.eclipse.xtext.testlanguages.actionLang3.P2;
import org.eclipse.xtext.testlanguages.actionLang3.P3;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;

@SuppressWarnings("all")
public class ActionTestLanguage3SemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ActionTestLanguage3GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ActionLang3Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ActionLang3Package.ENTRY:
				sequence_ProductionRule2(context, (Entry) semanticObject); 
				return; 
			case ActionLang3Package.P1:
				sequence_ProductionRule1_P2_2(context, (P1) semanticObject); 
				return; 
			case ActionLang3Package.P2:
				sequence_ProductionRule1_P3_4(context, (P2) semanticObject); 
				return; 
			case ActionLang3Package.P3:
				sequence_ProductionRule1(context, (P3) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     ProductionRule1.P2_2 returns P1
	 *
	 * Constraint:
	 *     id=ID?
	 * </pre>
	 */
	protected void sequence_ProductionRule1_P2_2(ISerializationContext context, P1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ProductionRules returns P3
	 *     ProductionRule1 returns P3
	 *
	 * Constraint:
	 *     (p=ProductionRule1_P3_4 i=INT)
	 * </pre>
	 */
	protected void sequence_ProductionRule1(ISerializationContext context, P3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ActionLang3Package.Literals.P3__P) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLang3Package.Literals.P3__P));
			if (transientValues.isValueTransient(semanticObject, ActionLang3Package.Literals.P3__I) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLang3Package.Literals.P3__I));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getProductionRule1Access().getP3PAction_4(), semanticObject.getP());
		feeder.accept(grammarAccess.getProductionRule1Access().getIINTTerminalRuleCall_5_0(), semanticObject.getI());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ProductionRule1.P3_4 returns P2
	 *
	 * Constraint:
	 *     (p=ProductionRule1_P2_2 string=STRING?)
	 * </pre>
	 */
	protected void sequence_ProductionRule1_P3_4(ISerializationContext context, P2 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ProductionRules returns Entry
	 *     ProductionRule2 returns Entry
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_ProductionRule2(ISerializationContext context, Entry semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ActionLang3Package.Literals.ENTRY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLang3Package.Literals.ENTRY__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getProductionRule2Access().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
