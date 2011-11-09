package org.eclipse.xtext.parser.unorderedGroups.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Element;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Expression;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.Model;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.SimpleTerm;
import org.eclipse.xtext.parser.unorderedGroups.services.BacktrackingBug325745TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractBacktrackingBug325745TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected BacktrackingBug325745TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == BacktrackingBug325745TestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BacktrackingBug325745TestLanguagePackage.DATA_TYPE:
				if(context == grammarAccess.getDataTypeRule()) {
					sequence_DataType(context, (DataType) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingBug325745TestLanguagePackage.ELEMENT:
				if(context == grammarAccess.getElementRule()) {
					sequence_Element(context, (Element) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingBug325745TestLanguagePackage.EXPRESSION:
				if(context == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingBug325745TestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM:
				if(context == grammarAccess.getSimpleTermRule()) {
					sequence_SimpleTerm(context, (SimpleTerm) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (baseType=ID defaultValue=STRING?)
	 */
	protected void sequence_DataType(EObject context, DataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID dataType=DataType? expression=Expression)
	 */
	protected void sequence_Element(EObject context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=STRING? terms+=SimpleTerm* postfix=STRING?)
	 */
	protected void sequence_Expression(EObject context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     fields+=Element+
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((lineCount=INT charCount=INT? charSet=ID?) | refChar=ID)
	 */
	protected void sequence_SimpleTerm(EObject context, SimpleTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
