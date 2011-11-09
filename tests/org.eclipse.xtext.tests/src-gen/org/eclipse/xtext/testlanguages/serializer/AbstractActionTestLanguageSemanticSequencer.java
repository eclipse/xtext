package org.eclipse.xtext.testlanguages.serializer;

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
import org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage;
import org.eclipse.xtext.testlanguages.actionLang.Child;
import org.eclipse.xtext.testlanguages.actionLang.Parent;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractActionTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ActionTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == ActionLangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ActionLangPackage.CHILD:
				if(context == grammarAccess.getChildRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getModelAccess().getParentLeftAction_1_0()) {
					sequence_Child(context, (Child) semanticObject); 
					return; 
				}
				else break;
			case ActionLangPackage.PARENT:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Parent) semanticObject); 
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
	protected void sequence_Child(EObject context, Child semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionLangPackage.Literals.CHILD__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLangPackage.Literals.CHILD__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Model_Parent_1_0 right=Child)
	 */
	protected void sequence_Model(EObject context, Parent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ActionLangPackage.Literals.PARENT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLangPackage.Literals.PARENT__LEFT));
			if(transientValues.isValueTransient(semanticObject, ActionLangPackage.Literals.PARENT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ActionLangPackage.Literals.PARENT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getParentLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getModelAccess().getRightChildParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
}
