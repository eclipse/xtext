/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.fileAware.serializer;

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
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import;
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration;
import org.eclipse.xtext.testlanguages.fileAware.services.FileAwareTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class FileAwareTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FileAwareTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == FileAwarePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FileAwarePackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case FileAwarePackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case FileAwarePackage.PACKAGE_DECLARATION:
				sequence_PackageDeclaration(context, (PackageDeclaration) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Element
	 *
	 * Constraint:
	 *     (name=ID (contents+=Element | ref+=[Element|QualifiedName])*)
	 * </pre>
	 */
	protected void sequence_Element(ISerializationContext context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     element=[Element|QualifiedName]
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, FileAwarePackage.Literals.IMPORT__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FileAwarePackage.Literals.IMPORT__ELEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getElementElementQualifiedNameParserRuleCall_1_0_1(), semanticObject.eGet(FileAwarePackage.Literals.IMPORT__ELEMENT, false));
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PackageDeclaration returns PackageDeclaration
	 *
	 * Constraint:
	 *     (name=QualifiedName imports+=Import* contents+=Element*)
	 * </pre>
	 */
	protected void sequence_PackageDeclaration(ISerializationContext context, PackageDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
