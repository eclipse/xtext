package org.eclipse.xtext.valueconverter.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.valueconverter.bug250313.Bug250313Package;
import org.eclipse.xtext.valueconverter.bug250313.Child1;
import org.eclipse.xtext.valueconverter.bug250313.Child2;
import org.eclipse.xtext.valueconverter.bug250313.Model;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

@SuppressWarnings("restriction")
public class AbstractBug250313SemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug250313GrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == Bug250313Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug250313Package.CHILD1:
				if(context == grammarAccess.getChildRule() ||
				   context == grammarAccess.getChild1Rule()) {
					sequence_Child1(context, (Child1) semanticObject); 
					return; 
				}
				else break;
			case Bug250313Package.CHILD2:
				if(context == grammarAccess.getChildRule() ||
				   context == grammarAccess.getChild2Rule()) {
					sequence_Child2(context, (Child2) semanticObject); 
					return; 
				}
				else break;
			case Bug250313Package.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
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
	protected void sequence_Child1(EObject context, Child1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug250313Package.Literals.CHILD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug250313Package.Literals.CHILD__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChild1Access().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_Child2(EObject context, Child2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug250313Package.Literals.CHILD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug250313Package.Literals.CHILD__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChild2Access().getNameSTRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         value='mykeyword1' | 
	 *         value=STRING | 
	 *         value=NestedDatatype | 
	 *         value=Datatype | 
	 *         value=ID | 
	 *         multiValue+='mykeyword1' | 
	 *         multiValue+=STRING | 
	 *         multiValue+=NestedDatatype | 
	 *         multiValue+=Datatype | 
	 *         multiValue+=ID | 
	 *         value=STRING | 
	 *         multiValue+=STRING | 
	 *         value=Datatype | 
	 *         multiValue+=Datatype | 
	 *         value=NestedDatatype | 
	 *         multiValue+=NestedDatatype | 
	 *         (children=Child (ref=[Child1|STRING] | ref=[Child2|ID])?)
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
