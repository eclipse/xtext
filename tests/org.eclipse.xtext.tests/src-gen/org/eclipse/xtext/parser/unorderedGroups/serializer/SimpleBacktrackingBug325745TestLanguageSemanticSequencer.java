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
import org.eclipse.xtext.parser.unorderedGroups.serializer.BacktrackingBug325745TestLanguageSemanticSequencer;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleBacktrackingBug325745TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class SimpleBacktrackingBug325745TestLanguageSemanticSequencer extends BacktrackingBug325745TestLanguageSemanticSequencer {

	@Inject
	private SimpleBacktrackingBug325745TestLanguageGrammarAccess grammarAccess;
	
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
				if(context == grammarAccess.getDelegateModelRule() ||
				   context == grammarAccess.getModelRule()) {
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
	
}
