/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleUnorderedGroupsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization;
import org.eclipse.xtext.serializer.ISerializationContext;

@SuppressWarnings("all")
public class SimpleUnorderedGroupsTestLanguageSemanticSequencer extends UnorderedGroupsTestLanguageSemanticSequencer {

	@Inject
	private SimpleUnorderedGroupsTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == UnorderedGroupsTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case UnorderedGroupsTestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case UnorderedGroupsTestLanguagePackage.NESTED_MODEL:
				sequence_NestedModel(context, (NestedModel) semanticObject); 
				return; 
			case UnorderedGroupsTestLanguagePackage.UNORDERED_SERIALIZATION:
				sequence_UnorderedSerialization(context, (UnorderedSerialization) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
}
