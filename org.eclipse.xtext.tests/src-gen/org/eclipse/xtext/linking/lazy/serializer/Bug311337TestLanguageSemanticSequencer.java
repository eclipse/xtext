/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package;
import org.eclipse.xtext.linking.lazy.bug311337.Child;
import org.eclipse.xtext.linking.lazy.bug311337.Definition;
import org.eclipse.xtext.linking.lazy.bug311337.Model;
import org.eclipse.xtext.linking.lazy.bug311337.NestedRef;
import org.eclipse.xtext.linking.lazy.bug311337.Reference;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Bug311337TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug311337TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Bug311337Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Bug311337Package.CHILD:
				sequence_Child(context, (Child) semanticObject); 
				return; 
			case Bug311337Package.DEFINITION:
				sequence_Definition(context, (Definition) semanticObject); 
				return; 
			case Bug311337Package.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case Bug311337Package.NESTED_REF:
				sequence_Reference(context, (NestedRef) semanticObject); 
				return; 
			case Bug311337Package.REFERENCE:
				sequence_Reference(context, (Reference) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Child returns Child
	 *
	 * Constraint:
	 *     (name=ID link=[Definition|ID]?)
	 * </pre>
	 */
	protected void sequence_Child(ISerializationContext context, Child semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Definition returns Definition
	 *
	 * Constraint:
	 *     (name=ID child+=Child ref+=Reference?)
	 * </pre>
	 */
	protected void sequence_Definition(ISerializationContext context, Definition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     def+=Definition+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Reference returns NestedRef
	 *     Reference.NestedRef_2_1 returns NestedRef
	 *
	 * Constraint:
	 *     (left=Reference_NestedRef_2_1 refChild=[Child|ID])
	 * </pre>
	 */
	protected void sequence_Reference(ISerializationContext context, NestedRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.NESTED_REF__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.NESTED_REF__LEFT));
			if (transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getReferenceAccess().getRefChildChildIDTerminalRuleCall_2_2_0_1(), semanticObject.eGet(Bug311337Package.Literals.REFERENCE__REF_CHILD, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Reference returns Reference
	 *     Reference.NestedRef_2_1 returns Reference
	 *
	 * Constraint:
	 *     refChild=[Child|ID]
	 * </pre>
	 */
	protected void sequence_Reference(ISerializationContext context, Reference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getReferenceAccess().getRefChildChildIDTerminalRuleCall_1_0_1(), semanticObject.eGet(Bug311337Package.Literals.REFERENCE__REF_CHILD, false));
		feeder.finish();
	}
	
	
}
