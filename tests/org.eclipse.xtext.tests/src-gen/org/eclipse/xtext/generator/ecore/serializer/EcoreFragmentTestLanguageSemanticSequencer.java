package org.eclipse.xtext.generator.ecore.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.ecore.second.Second;
import org.eclipse.xtext.generator.ecore.second.SecondPackage;
import org.eclipse.xtext.generator.ecore.services.EcoreFragmentTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class EcoreFragmentTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EcoreFragmentTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SecondPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SecondPackage.SECOND:
				if(context == grammarAccess.getSecondRule()) {
					sequence_Second(context, (Second) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID first=[First|ID])
	 */
	protected void sequence_Second(EObject context, Second semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SecondPackage.Literals.SECOND__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SecondPackage.Literals.SECOND__NAME));
			if(transientValues.isValueTransient(semanticObject, SecondPackage.Literals.SECOND__FIRST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SecondPackage.Literals.SECOND__FIRST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSecondAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSecondAccess().getFirstFirstIDTerminalRuleCall_2_0_1(), semanticObject.getFirst());
		feeder.finish();
	}
}
