package org.eclipse.xtext.parsetree.transientvalues.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage;
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
public class AbstractTransientValuesTestSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected TransientValuesTestGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == TransientvaluestestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TransientvaluestestPackage.TEST_LIST:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestListRule()) {
					sequence_TestList(context, (TestList) semanticObject); 
					return; 
				}
				else break;
			case TransientvaluestestPackage.TEST_OPTIONAL:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestOptionalRule()) {
					sequence_TestOptional(context, (TestOptional) semanticObject); 
					return; 
				}
				else break;
			case TransientvaluestestPackage.TEST_REQUIRED:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getTestRequiredRule()) {
					sequence_TestRequired(context, (TestRequired) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (item+=INT*)
	 */
	protected void sequence_TestList(EObject context, TestList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opt1=INT? opt2=INT?)
	 */
	protected void sequence_TestOptional(EObject context, TestOptional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (required1=INT required2=INT)
	 */
	protected void sequence_TestRequired(EObject context, TestRequired semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TransientvaluestestPackage.Literals.TEST_REQUIRED__REQUIRED1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransientvaluestestPackage.Literals.TEST_REQUIRED__REQUIRED1));
			if(transientValues.isValueTransient(semanticObject, TransientvaluestestPackage.Literals.TEST_REQUIRED__REQUIRED2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TransientvaluestestPackage.Literals.TEST_REQUIRED__REQUIRED2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTestRequiredAccess().getRequired1INTTerminalRuleCall_2_0(), semanticObject.getRequired1());
		feeder.accept(grammarAccess.getTestRequiredAccess().getRequired2INTTerminalRuleCall_3_0(), semanticObject.getRequired2());
		feeder.finish();
	}
}
