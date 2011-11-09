package org.eclipse.xtext.linking.lazy.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package;
import org.eclipse.xtext.linking.lazy.bug311337.Child;
import org.eclipse.xtext.linking.lazy.bug311337.Definition;
import org.eclipse.xtext.linking.lazy.bug311337.Model;
import org.eclipse.xtext.linking.lazy.bug311337.NestedRef;
import org.eclipse.xtext.linking.lazy.bug311337.Reference;
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;
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
public class AbstractBug311337TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug311337TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == Bug311337Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug311337Package.CHILD:
				if(context == grammarAccess.getChildRule()) {
					sequence_Child(context, (Child) semanticObject); 
					return; 
				}
				else break;
			case Bug311337Package.DEFINITION:
				if(context == grammarAccess.getDefinitionRule()) {
					sequence_Definition(context, (Definition) semanticObject); 
					return; 
				}
				else break;
			case Bug311337Package.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case Bug311337Package.NESTED_REF:
				if(context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1()) {
					sequence_Reference(context, (NestedRef) semanticObject); 
					return; 
				}
				else break;
			case Bug311337Package.REFERENCE:
				if(context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1()) {
					sequence_Reference(context, (Reference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID link=[Definition|ID]?)
	 */
	protected void sequence_Child(EObject context, Child semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID child+=Child ref+=Reference?)
	 */
	protected void sequence_Definition(EObject context, Definition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     def+=Definition+
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Reference_NestedRef_2_1 refChild=[Child|ID])
	 */
	protected void sequence_Reference(EObject context, NestedRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD));
			if(transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.NESTED_REF__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.NESTED_REF__LEFT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getReferenceAccess().getRefChildChildIDTerminalRuleCall_2_2_0_1(), semanticObject.getRefChild());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     refChild=[Child|ID]
	 */
	protected void sequence_Reference(EObject context, Reference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug311337Package.Literals.REFERENCE__REF_CHILD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReferenceAccess().getRefChildChildIDTerminalRuleCall_1_0_1(), semanticObject.getRefChild());
		feeder.finish();
	}
}
