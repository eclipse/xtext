/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList;
import org.eclipse.xtext.formatting2.internal.formattertestlanguage.KWList;
import org.eclipse.xtext.formatting2.internal.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class FormatterTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FormatterTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == FormattertestlanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FormattertestlanguagePackage.ID_LIST:
				sequence_IDList(context, (IDList) semanticObject); 
				return; 
			case FormattertestlanguagePackage.KW_LIST:
				sequence_KWList(context, (KWList) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns IDList
	 *     IDList returns IDList
	 *
	 * Constraint:
	 *     ids+=ID*
	 * </pre>
	 */
	protected void sequence_IDList(ISerializationContext context, IDList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns KWList
	 *     KWList returns KWList
	 *
	 * Constraint:
	 *     (kw1?='kw1'? kw2?='kw2'? kw3?='kw3'? kw4?='kw4'? kw5?='kw5'?)
	 * </pre>
	 */
	protected void sequence_KWList(ISerializationContext context, KWList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
