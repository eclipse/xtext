package org.eclipse.xtext.testlanguages.indent.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.testlanguages.indent.indentLang.IndentLangPackage;
import org.eclipse.xtext.testlanguages.indent.indentLang.Node;
import org.eclipse.xtext.testlanguages.indent.indentLang.NodeList;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class IndentationAwareTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IndentationAwareTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == IndentLangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case IndentLangPackage.NODE:
				if(context == grammarAccess.getNodeRule()) {
					sequence_Node(context, (Node) semanticObject); 
					return; 
				}
				else break;
			case IndentLangPackage.NODE_LIST:
				if(context == grammarAccess.getNodeListRule()) {
					sequence_NodeList(context, (NodeList) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (children+=Node children+=Node*)
	 */
	protected void sequence_NodeList(EObject context, NodeList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=String children=NodeList?)
	 */
	protected void sequence_Node(EObject context, Node semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
