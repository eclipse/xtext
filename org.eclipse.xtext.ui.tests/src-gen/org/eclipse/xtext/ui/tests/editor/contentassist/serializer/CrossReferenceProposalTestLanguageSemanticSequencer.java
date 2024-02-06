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
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class CrossReferenceProposalTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == CrossReferenceProposalTestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CrossReferenceProposalTestPackage.CLASS:
				sequence_Class(context, (org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.Class) semanticObject); 
				return; 
			case CrossReferenceProposalTestPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Class returns Class
	 *
	 * Constraint:
	 *     ((superClass=[Class|'Object'] | superClass=[Class|ID] | superClass=[Class|ComplexName])? (name=ID | name=ComplexName))
	 * </pre>
	 */
	protected void sequence_Class(ISerializationContext context, org.eclipse.xtext.ui.tests.editor.contentassist.crossReferenceProposalTest.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     elements+=Class+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
