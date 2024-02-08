/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element;
import org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.IgnoreCaseNamespacesTestPackage;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.Import;
import org.eclipse.xtext.linking.ignoreCaseNamespacesTest.Model;
import org.eclipse.xtext.linking.services.IgnoreCaseNamespacesTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class IgnoreCaseNamespacesTestLanguageSemanticSequencer extends AbstractIgnoreCaseLinkingTestLanguageSemanticSequencer {

	@Inject
	private IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == IgnoreCaseLinkingTestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IgnoreCaseLinkingTestPackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			}
		else if (epackage == IgnoreCaseNamespacesTestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case IgnoreCaseNamespacesTestPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case IgnoreCaseNamespacesTestPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importedNamespace=STRING
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, IgnoreCaseNamespacesTestPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IgnoreCaseNamespacesTestPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceSTRINGTerminalRuleCall_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (imports+=Import* elements+=Element+)
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
