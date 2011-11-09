package org.eclipse.xtext.metamodelreferencing.tests.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar;
import org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.simpleTest.Foo;
import org.eclipse.xtext.metamodelreferencing.tests.simpleTest.SimpleTestPackage;
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
public class AbstractMultiGenMMTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MultiGenMMTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == OtherTestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OtherTestPackage.FOO_BAR:
				if(context == grammarAccess.getNameRefRule()) {
					sequence_NameRef(context, (FooBar) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == SimpleTestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SimpleTestPackage.FOO:
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
	 *     (name=ID nameRefs+=NameRef*)
	 */
	protected void sequence_Foo(EObject context, Foo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_NameRef(EObject context, FooBar semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, OtherTestPackage.Literals.FOO_BAR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OtherTestPackage.Literals.FOO_BAR__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNameRefAccess().getNameSTRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
