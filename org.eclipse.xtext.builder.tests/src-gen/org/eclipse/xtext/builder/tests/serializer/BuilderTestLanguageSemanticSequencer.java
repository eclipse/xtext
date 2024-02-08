/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.builder.tests.builderTestLanguage.BuilderTestLanguagePackage;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Import;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Namespace;
import org.eclipse.xtext.builder.tests.services.BuilderTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class BuilderTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private BuilderTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == BuilderTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case BuilderTestLanguagePackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case BuilderTestLanguagePackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case BuilderTestLanguagePackage.NAMESPACE:
				sequence_Namespace(context, (Namespace) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Element
	 *     Element returns Element
	 *
	 * Constraint:
	 *     (name=ID references=[Element|QualifiedName]? (otherRefs+=[Element|QualifiedName] otherRefs+=[Element|QualifiedName]*)?)
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
	 *     importedNamespace=QualifiedName
	 * </pre>
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, BuilderTestLanguagePackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BuilderTestLanguagePackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NamedElement returns Namespace
	 *     Namespace returns Namespace
	 *
	 * Constraint:
	 *     (name=QualifiedName imports+=Import* elements+=NamedElement*)
	 * </pre>
	 */
	protected void sequence_Namespace(ISerializationContext context, Namespace semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
