/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.ui.tests.folding.Element;
import org.eclipse.xtext.ui.tests.folding.FoldingModel;
import org.eclipse.xtext.ui.tests.folding.FoldingPackage;
import org.eclipse.xtext.ui.tests.services.FoldingTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class FoldingTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private FoldingTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == FoldingPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FoldingPackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case FoldingPackage.FOLDING_MODEL:
				sequence_FoldingModel(context, (FoldingModel) semanticObject); 
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
	 *     (name=ID subelements+=Element*)
	 * </pre>
	 */
	protected void sequence_Element(ISerializationContext context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FoldingModel returns FoldingModel
	 *
	 * Constraint:
	 *     elements+=Element+
	 * </pre>
	 */
	protected void sequence_FoldingModel(ISerializationContext context, FoldingModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
