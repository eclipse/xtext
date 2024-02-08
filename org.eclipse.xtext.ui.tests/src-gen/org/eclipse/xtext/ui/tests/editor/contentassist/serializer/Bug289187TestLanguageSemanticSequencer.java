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
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Attribute;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Bug289187TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Operation;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;

@SuppressWarnings("all")
public class Bug289187TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug289187TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Bug289187TestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Bug289187TestLanguagePackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case Bug289187TestLanguagePackage.CLASS:
				sequence_Class(context, (org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class) semanticObject); 
				return; 
			case Bug289187TestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case Bug289187TestLanguagePackage.OPERATION:
				sequence_Operation(context, (Operation) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (visibility=Visibility? name=ID)
	 * </pre>
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Class returns Class
	 *
	 * Constraint:
	 *     (
	 *         abstract?='abstract'? 
	 *         transient?='transient'? 
	 *         name=ID 
	 *         superClass=[Class|ID]? 
	 *         (implementedInterfaces+=[Class|ID] implementedInterfaces+=[Class|ID]*)? 
	 *         classNumber=INT? 
	 *         quid=INT? 
	 *         documentation=STRING? 
	 *         attributes+=Attribute* 
	 *         operations+=Operation*
	 *     )
	 * </pre>
	 */
	protected void sequence_Class(ISerializationContext context, org.eclipse.xtext.ui.tests.editor.contentassist.bug289187TestLanguage.Class semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     classes+=Class+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Operation returns Operation
	 *
	 * Constraint:
	 *     (visibility=Visibility? name=ID)
	 * </pre>
	 */
	protected void sequence_Operation(ISerializationContext context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
