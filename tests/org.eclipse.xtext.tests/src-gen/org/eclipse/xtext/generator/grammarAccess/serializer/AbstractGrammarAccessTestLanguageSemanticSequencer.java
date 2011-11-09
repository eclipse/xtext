package org.eclipse.xtext.generator.grammarAccess.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.AnotherType;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage;
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractGrammarAccessTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected GrammarAccessTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == AsubpackagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AsubpackagePackage.AMODEL:
				if(context == grammarAccess.getRootRule()) {
					sequence_Root(context, (AModel) semanticObject); 
					return; 
				}
				else break;
			case AsubpackagePackage.ATYPE:
				if(context == grammarAccess.getATypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (AType) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == SubsubpackagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SubsubpackagePackage.ANOTHER_TYPE:
				if(context == grammarAccess.getAnotherTypeRule() ||
				   context == grammarAccess.getTypeRule()) {
					sequence_Type(context, (AnotherType) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     elements+=Type*
	 */
	protected void sequence_Root(EObject context, AModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AType}
	 */
	protected void sequence_Type(EObject context, AType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {AnotherType}
	 */
	protected void sequence_Type(EObject context, AnotherType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
