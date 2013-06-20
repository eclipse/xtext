package org.eclipse.xtext.metamodelreferencing.tests.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage;
import org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class MetamodelRefTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MetamodelRefTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AnotherSimpleTestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AnotherSimpleTestPackage.FOO:
				if(context == grammarAccess.getFooRule()) {
					sequence_Foo(context, (Foo) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtextPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtextPackage.PARSER_RULE:
				if(context == grammarAccess.getMyRuleRule()) {
					sequence_MyRule(context, (ParserRule) semanticObject); 
					return; 
				}
				else break;
			case XtextPackage.RULE_CALL:
				if(context == grammarAccess.getNameRefRule()) {
					sequence_NameRef(context, (RuleCall) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID nameRefs+=NameRef*)
	 */
	protected void sequence_Foo(EObject context, Foo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_MyRule(EObject context, ParserRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     rule=[ParserRule|ID]
	 */
	protected void sequence_NameRef(EObject context, RuleCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
