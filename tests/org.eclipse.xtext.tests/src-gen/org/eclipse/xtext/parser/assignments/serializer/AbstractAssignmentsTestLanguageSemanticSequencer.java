package org.eclipse.xtext.parser.assignments.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractAssignmentsTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected AssignmentsTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == AssignmentsTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AssignmentsTestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case AssignmentsTestLanguagePackage.MULTI_VALUE:
				if(context == grammarAccess.getMultiDatatypeRule()) {
					sequence_MultiDatatype(context, (MultiValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMultiValueRule()) {
					sequence_MultiValue(context, (MultiValue) semanticObject); 
					return; 
				}
				else break;
			case AssignmentsTestLanguagePackage.SINGLE_VALUE:
				if(context == grammarAccess.getSingleDatatypeRule()) {
					sequence_SingleDatatype(context, (SingleValue) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSingleValueRule()) {
					sequence_SingleValue(context, (SingleValue) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         single=SingleValue | 
	 *         multi=MultiValue | 
	 *         single=SingleDatatype | 
	 *         multi=MultiDatatype | 
	 *         object=SingleValue | 
	 *         object=MultiValue | 
	 *         object=SingleDatatype | 
	 *         object=MultiDatatype
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value+=IdDatatype | value+=IdDatatype | value+=StringDatatype | value+=StringDatatype)
	 */
	protected void sequence_MultiDatatype(EObject context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value+=ID | value+=ID | value+=STRING | value+=STRING)
	 */
	protected void sequence_MultiValue(EObject context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=IdDatatype | value=IdDatatype | value=StringDatatype | value=StringDatatype)
	 */
	protected void sequence_SingleDatatype(EObject context, SingleValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=ID | value=ID | value=STRING | value=STRING)
	 */
	protected void sequence_SingleValue(EObject context, SingleValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
