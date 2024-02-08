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
import org.eclipse.xtext.ui.tests.foo.File;
import org.eclipse.xtext.ui.tests.foo.FooPackage;
import org.eclipse.xtext.ui.tests.foo.Stuff;
import org.eclipse.xtext.ui.tests.services.TestLanguageGrammarAccess;

@SuppressWarnings("all")
public class TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == FooPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case FooPackage.FILE:
				sequence_File(context, (File) semanticObject); 
				return; 
			case FooPackage.STUFF:
				sequence_Stuff(context, (Stuff) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     File returns File
	 *
	 * Constraint:
	 *     stuff+=Stuff+
	 * </pre>
	 */
	protected void sequence_File(ISerializationContext context, File semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Stuff returns Stuff
	 *
	 * Constraint:
	 *     (name=ID refs=[Stuff|ID]?)
	 * </pre>
	 */
	protected void sequence_Stuff(ISerializationContext context, Stuff semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
