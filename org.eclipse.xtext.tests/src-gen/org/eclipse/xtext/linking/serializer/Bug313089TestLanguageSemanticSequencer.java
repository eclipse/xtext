/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.linking.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.linking.bug313089.Bar;
import org.eclipse.xtext.linking.bug313089.Baz;
import org.eclipse.xtext.linking.bug313089.Bug313089Package;
import org.eclipse.xtext.linking.bug313089.Foo;
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class Bug313089TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug313089TestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == Bug313089Package.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case Bug313089Package.BAR:
				sequence_Bar(context, (Bar) semanticObject); 
				return; 
			case Bug313089Package.BAZ:
				sequence_Baz(context, (Baz) semanticObject); 
				return; 
			case Bug313089Package.FOO:
				sequence_Foo(context, (Foo) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Bar returns Bar
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Bar(ISerializationContext context, Bar semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, Bug313089Package.Literals.BAR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug313089Package.Literals.BAR__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Baz returns Baz
	 *     Baz.Baz_2_0 returns Baz
	 *
	 * Constraint:
	 *     (name=ID | (child=Baz_Baz_2_0 name=ID))
	 * </pre>
	 */
	protected void sequence_Baz(ISerializationContext context, Baz semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Foo returns Foo
	 *
	 * Constraint:
	 *     (name=ID (bar=Bar | baz=Baz) ref=[Foo|ID])
	 * </pre>
	 */
	protected void sequence_Foo(ISerializationContext context, Foo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
