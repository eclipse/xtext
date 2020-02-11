/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ide.tests.testlanguage.partialContentAssistTestLanguage.PartialContentAssistTestLanguagePackage;
import org.eclipse.xtext.ide.tests.testlanguage.partialContentAssistTestLanguage.Property;
import org.eclipse.xtext.ide.tests.testlanguage.partialContentAssistTestLanguage.TypeDeclaration;
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class PartialContentAssistTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private PartialContentAssistTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == PartialContentAssistTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case PartialContentAssistTestLanguagePackage.PROPERTY:
				sequence_Property(context, (Property) semanticObject); 
				return; 
			case PartialContentAssistTestLanguagePackage.TYPE_DECLARATION:
				sequence_TypeDeclaration(context, (TypeDeclaration) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Property returns Property
	 *
	 * Constraint:
	 *     ((type='int' | type='bool') name=ID)
	 */
	protected void sequence_Property(ISerializationContext context, Property semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TypeDeclaration returns TypeDeclaration
	 *
	 * Constraint:
	 *     (name=ID superType=[TypeDeclaration|ID]? properties+=Property*)
	 */
	protected void sequence_TypeDeclaration(ISerializationContext context, TypeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
