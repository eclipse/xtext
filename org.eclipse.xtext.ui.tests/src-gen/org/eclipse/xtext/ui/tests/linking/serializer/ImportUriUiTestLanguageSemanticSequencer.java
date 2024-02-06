/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.linking.serializer;

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
import org.eclipse.xtext.ui.tests.linking.importUriUi.Import;
import org.eclipse.xtext.ui.tests.linking.importUriUi.ImportUriUiPackage;
import org.eclipse.xtext.ui.tests.linking.importUriUi.Main;
import org.eclipse.xtext.ui.tests.linking.importUriUi.Type;
import org.eclipse.xtext.ui.tests.linking.services.ImportUriUiTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class ImportUriUiTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ImportUriUiTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ImportUriUiPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ImportUriUiPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case ImportUriUiPackage.MAIN:
				sequence_Main(context, (Main) semanticObject); 
				return; 
			case ImportUriUiPackage.TYPE:
				sequence_Type(context, (Type) semanticObject); 
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
	 *     importURI=STRING
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ImportUriUiPackage.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ImportUriUiPackage.Literals.IMPORT__IMPORT_URI));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Main returns Main
	 *
	 * Constraint:
	 *     ((imports+=Import+ types+=Type+) | types+=Type+)?
	 * </pre>
	 */
	protected void sequence_Main(ISerializationContext context, Main semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Type returns Type
	 *
	 * Constraint:
	 *     (name=ID extends=[Type|ID])
	 * </pre>
	 */
	protected void sequence_Type(ISerializationContext context, Type semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ImportUriUiPackage.Literals.TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ImportUriUiPackage.Literals.TYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, ImportUriUiPackage.Literals.TYPE__EXTENDS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ImportUriUiPackage.Literals.TYPE__EXTENDS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1(), semanticObject.eGet(ImportUriUiPackage.Literals.TYPE__EXTENDS, false));
		feeder.finish();
	}
	
	
}
