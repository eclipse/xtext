/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.assignments.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;

@SuppressWarnings("all")
public class AssignmentsTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AssignmentsTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AssignmentsTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AssignmentsTestLanguagePackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case AssignmentsTestLanguagePackage.MULTI_VALUE:
				if (rule == grammarAccess.getMultiDatatypeRule()) {
					sequence_MultiDatatype(context, (MultiValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiValueRule()) {
					sequence_MultiValue(context, (MultiValue) semanticObject); 
					return; 
				}
				else break;
			case AssignmentsTestLanguagePackage.SINGLE_VALUE:
				if (rule == grammarAccess.getSingleDatatypeRule()) {
					sequence_SingleDatatype(context, (SingleValue) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSingleValueRule()) {
					sequence_SingleValue(context, (SingleValue) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (
	 *         single=SingleValue | 
	 *         multi=MultiValue | 
	 *         single=SingleDatatype | 
	 *         multi=MultiDatatype | 
	 *         object=SingleValue | 
	 *         object=MultiValue | 
	 *         object=SingleDatatype | 
	 *         object=MultiDatatype
	 *     )
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MultiDatatype returns MultiValue
	 *
	 * Constraint:
	 *     (value+=IdDatatype | value+=IdDatatype | value+=StringDatatype | value+=StringDatatype)
	 * </pre>
	 */
	protected void sequence_MultiDatatype(ISerializationContext context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MultiValue returns MultiValue
	 *
	 * Constraint:
	 *     (value+=ID | value+=ID | value+=STRING | value+=STRING)
	 * </pre>
	 */
	protected void sequence_MultiValue(ISerializationContext context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleDatatype returns SingleValue
	 *
	 * Constraint:
	 *     (value=IdDatatype | value=IdDatatype | value=StringDatatype | value=StringDatatype)
	 * </pre>
	 */
	protected void sequence_SingleDatatype(ISerializationContext context, SingleValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SingleValue returns SingleValue
	 *
	 * Constraint:
	 *     (value=ID | value=ID | value=STRING | value=STRING)
	 * </pre>
	 */
	protected void sequence_SingleValue(ISerializationContext context, SingleValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
