/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.templates.Dollar;
import org.eclipse.xtext.ui.codetemplates.templates.Literal;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;

@SuppressWarnings("all")
public class CodetemplatesSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CodetemplatesGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TemplatesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TemplatesPackage.CODETEMPLATE:
				sequence_Codetemplate(context, (Codetemplate) semanticObject); 
				return; 
			case TemplatesPackage.CODETEMPLATES:
				sequence_Codetemplates(context, (Codetemplates) semanticObject); 
				return; 
			case TemplatesPackage.DOLLAR:
				sequence_Dollar(context, (Dollar) semanticObject); 
				return; 
			case TemplatesPackage.LITERAL:
				sequence_Literal(context, (Literal) semanticObject); 
				return; 
			case TemplatesPackage.TEMPLATE_BODY:
				sequence_TemplateBody(context, (TemplateBody) semanticObject); 
				return; 
			case TemplatesPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Codetemplate returns Codetemplate
	 *
	 * Constraint:
	 *     (name=ValidID id=ID description=STRING (context=[AbstractRule|ValidID] | keywordContext=STRING) body=TemplateBodyWithQuotes)
	 * </pre>
	 */
	protected void sequence_Codetemplate(ISerializationContext context, Codetemplate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Codetemplates returns Codetemplates
	 *
	 * Constraint:
	 *     (language=[Grammar|FQN] templates+=Codetemplate*)
	 * </pre>
	 */
	protected void sequence_Codetemplates(ISerializationContext context, Codetemplates semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemplatePart returns Dollar
	 *     VariableOrDollar returns Dollar
	 *     Dollar returns Dollar
	 *
	 * Constraint:
	 *     escaped?='$$'?
	 * </pre>
	 */
	protected void sequence_Dollar(ISerializationContext context, Dollar semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemplatePart returns Literal
	 *     Literal returns Literal
	 *
	 * Constraint:
	 *     value=LiteralValue
	 * </pre>
	 */
	protected void sequence_Literal(ISerializationContext context, Literal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TemplatesPackage.Literals.LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TemplatesPackage.Literals.LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemplateBodyWithQuotes returns TemplateBody
	 *     TemplateBody returns TemplateBody
	 *
	 * Constraint:
	 *     (parts+=Literal? (parts+=VariableOrDollar parts+=Literal?)*)
	 * </pre>
	 */
	protected void sequence_TemplateBody(ISerializationContext context, TemplateBody semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TemplatePart returns Variable
	 *     VariableOrDollar returns Variable
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (
	 *         name=ValidID | 
	 *         (
	 *             name=ValidID? 
	 *             type=ValidID 
	 *             (
	 *                 expectingParameters?='(' | 
	 *                 (expectingParameters?='(' (parameters+=STRING | parameters+=FQN) parameters+=STRING? (parameters+=FQN? parameters+=STRING?)*)
	 *             )?
	 *         )
	 *     )
	 * </pre>
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
