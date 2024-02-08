/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder;
import org.eclipse.xtext.common.types.xtext.ui.services.RefactoringTestLanguage2GrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;

@SuppressWarnings("all")
public class RefactoringTestLanguage2SemanticSequencer extends RefactoringTestLanguageSemanticSequencer {

	@Inject
	private RefactoringTestLanguage2GrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RefactoringTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RefactoringTestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case RefactoringTestLanguagePackage.REFERENCE_HOLDER:
				sequence_ReferenceHolder(context, (ReferenceHolder) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
}
