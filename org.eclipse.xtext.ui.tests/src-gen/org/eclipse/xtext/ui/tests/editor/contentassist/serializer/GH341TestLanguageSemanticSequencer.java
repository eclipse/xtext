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
import org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Broken;
import org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Gh341TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Third;
import org.eclipse.xtext.ui.tests.editor.contentassist.gh341TestLanguage.Works;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;

@SuppressWarnings("all")
public class GH341TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private GH341TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Gh341TestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Gh341TestLanguagePackage.BROKEN:
				sequence_Broken_Fragment(context, (Broken) semanticObject); 
				return; 
			case Gh341TestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case Gh341TestLanguagePackage.THIRD:
				sequence_Third(context, (Third) semanticObject); 
				return; 
			case Gh341TestLanguagePackage.WORKS:
				sequence_Works(context, (Works) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Broken
	 *     Broken returns Broken
	 *
	 * Constraint:
	 *     (name=ID (ids+=ID ids+=ID*)* (refs+=[Broken|ID] refs+=[Broken|ID]*)*)
	 * </pre>
	 */
	protected void sequence_Broken_Fragment(ISerializationContext context, Broken semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (elements+=Works | elements+=Broken | elements+=Third)+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Third
	 *     Third returns Third
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Third(ISerializationContext context, Third semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Gh341TestLanguagePackage.Literals.ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Gh341TestLanguagePackage.Literals.ELEMENT__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Works
	 *     Works returns Works
	 *
	 * Constraint:
	 *     (name=ID (ids+=ID ids+=ID*)* (refs+=[Works|ID] refs+=[Works|ID]*)*)
	 * </pre>
	 */
	protected void sequence_Works(ISerializationContext context, Works semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
