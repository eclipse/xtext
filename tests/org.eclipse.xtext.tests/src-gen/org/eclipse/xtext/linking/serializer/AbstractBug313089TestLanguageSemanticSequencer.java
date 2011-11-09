package org.eclipse.xtext.linking.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.bug313089.Bar;
import org.eclipse.xtext.linking.bug313089.Baz;
import org.eclipse.xtext.linking.bug313089.Bug313089Package;
import org.eclipse.xtext.linking.bug313089.Foo;
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractBug313089TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug313089TestLanguageGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug313089Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug313089Package.BAR:
				if(context == grammarAccess.getBarRule()) {
					sequence_Bar(context, (Bar) semanticObject); 
					return; 
				}
				else break;
			case Bug313089Package.BAZ:
				if(context == grammarAccess.getBazRule() ||
				   context == grammarAccess.getBazAccess().getBazChildAction_2_0()) {
					sequence_Baz(context, (Baz) semanticObject); 
					return; 
				}
				else break;
			case Bug313089Package.FOO:
				if(context == grammarAccess.getFooRule()) {
					sequence_Foo(context, (Foo) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Bar(EObject context, Bar semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug313089Package.Literals.BAR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug313089Package.Literals.BAR__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBarAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((child=Baz_Baz_2_0 name=ID) | name=ID)
	 */
	protected void sequence_Baz(EObject context, Baz semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (bar=Bar | baz=Baz) ref=[Foo|ID])
	 */
	protected void sequence_Foo(EObject context, Foo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
