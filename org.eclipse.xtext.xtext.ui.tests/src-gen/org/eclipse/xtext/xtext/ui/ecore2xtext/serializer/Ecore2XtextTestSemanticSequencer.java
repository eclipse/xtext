/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext.serializer;

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete0;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete1;
import org.eclipse.xtext.xtext.ui.ecore2xtext.DiamondInheritance;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextPackage;
import org.eclipse.xtext.xtext.ui.ecore2xtext.Root;
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;

@SuppressWarnings("all")
public class Ecore2XtextTestSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Ecore2XtextTestGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Ecore2xtextPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Ecore2xtextPackage.CONCRETE0:
				sequence_Concrete0_Impl(context, (Concrete0) semanticObject); 
				return; 
			case Ecore2xtextPackage.CONCRETE1:
				sequence_Concrete1_Impl(context, (Concrete1) semanticObject); 
				return; 
			case Ecore2xtextPackage.DIAMOND_INHERITANCE:
				sequence_DiamondInheritance(context, (DiamondInheritance) semanticObject); 
				return; 
			case Ecore2xtextPackage.ROOT:
				sequence_Root(context, (Root) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Abstract returns Concrete0
	 *     Concrete0 returns Concrete0
	 *     Concrete0_Impl returns Concrete0
	 *
	 * Constraint:
	 *     name=EString
	 * </pre>
	 */
	protected void sequence_Concrete0_Impl(ISerializationContext context, Concrete0 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Abstract returns Concrete1
	 *     Concrete1_Impl returns Concrete1
	 *
	 * Constraint:
	 *     name=EString
	 * </pre>
	 */
	protected void sequence_Concrete1_Impl(ISerializationContext context, Concrete1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Abstract returns DiamondInheritance
	 *     Concrete0 returns DiamondInheritance
	 *     DiamondInheritance returns DiamondInheritance
	 *
	 * Constraint:
	 *     name=EString
	 * </pre>
	 */
	protected void sequence_DiamondInheritance(ISerializationContext context, DiamondInheritance semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Ecore2xtextPackage.Literals.ABSTRACT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns Root
	 *
	 * Constraint:
	 *     (name=INT0 (classes+=Abstract classes+=Abstract*)? concrete0=Concrete0?)
	 * </pre>
	 */
	protected void sequence_Root(ISerializationContext context, Root semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
