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
import org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.NoTerminalExtensionPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistNoTerminalExtensionTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class ContentAssistNoTerminalExtensionTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ContentAssistNoTerminalExtensionTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == NoTerminalExtensionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case NoTerminalExtensionPackage.POLYGON_BASED_SHAPE:
				sequence_PolygonBasedShape(context, (PolygonBasedShape) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     PolygonBasedShape returns PolygonBasedShape
	 *
	 * Constraint:
	 *     shape+=PolygonBasedNodeShape+
	 * </pre>
	 */
	protected void sequence_PolygonBasedShape(ISerializationContext context, PolygonBasedShape semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
