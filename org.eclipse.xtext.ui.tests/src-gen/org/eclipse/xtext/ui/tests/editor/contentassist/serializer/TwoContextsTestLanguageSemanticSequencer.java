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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.TwoContextsTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel;
import org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsPackage;

@SuppressWarnings("all")
public class TwoContextsTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TwoContextsTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TwoContextsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TwoContextsPackage.AN_ELEMENT:
				sequence_AnElement(context, (AnElement) semanticObject); 
				return; 
			case TwoContextsPackage.MAIN_MODEL:
				sequence_MainModel(context, (MainModel) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AnElement returns AnElement
	 *
	 * Constraint:
	 *     (name=ID referred=[AnElement|ID]?)
	 * </pre>
	 */
	protected void sequence_AnElement(ISerializationContext context, AnElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MainModel returns MainModel
	 *
	 * Constraint:
	 *     elements+=AnElement+
	 * </pre>
	 */
	protected void sequence_MainModel(ISerializationContext context, MainModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
