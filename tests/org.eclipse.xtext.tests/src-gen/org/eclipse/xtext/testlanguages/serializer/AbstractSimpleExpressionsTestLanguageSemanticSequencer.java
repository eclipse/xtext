package org.eclipse.xtext.testlanguages.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.simpleExpressions.Atom;
import org.eclipse.xtext.testlanguages.simpleExpressions.Op;
import org.eclipse.xtext.testlanguages.simpleExpressions.Sequence;
import org.eclipse.xtext.testlanguages.simpleExpressions.SimpleExpressionsPackage;

@SuppressWarnings("restriction")
public class AbstractSimpleExpressionsTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SimpleExpressionsTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == SimpleExpressionsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SimpleExpressionsPackage.ATOM:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getOpValuesAction_1_0() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getOpValuesAction_1_0() ||
				   context == grammarAccess.getParensRule() ||
				   context == grammarAccess.getSequenceRule() ||
				   context == grammarAccess.getSequenceAccess().getSequenceExpressionsAction_1_0() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Atom(context, (Atom) semanticObject); 
					return; 
				}
				else break;
			case SimpleExpressionsPackage.OP:
				if(context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getOpValuesAction_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getOpValuesAction_1_0() ||
				   context == grammarAccess.getParensRule() ||
				   context == grammarAccess.getSequenceRule() ||
				   context == grammarAccess.getSequenceAccess().getSequenceExpressionsAction_1_0() ||
				   context == grammarAccess.getTermRule()) {
					sequence_Addition(context, (Op) semanticObject); 
					return; 
				}
				else break;
			case SimpleExpressionsPackage.SEQUENCE:
				if(context == grammarAccess.getSequenceRule() ||
				   context == grammarAccess.getSequenceAccess().getSequenceExpressionsAction_1_0()) {
					sequence_Sequence(context, (Sequence) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (values+=Addition_Op_1_0 (operator='+' | operator='-') values+=Multiplication) | 
	 *         (values+=Multiplication_Op_1_0 (operator='*' | operator='/') values+=Term)
	 *     )
	 */
	protected void sequence_Addition(EObject context, Op semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Atom(EObject context, Atom semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=Sequence_Sequence_1_0 expressions+=Addition)
	 */
	protected void sequence_Sequence(EObject context, Sequence semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
