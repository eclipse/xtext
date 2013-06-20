package org.eclipse.xtext.linking.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.ignoreCaseLinkingTest.Element;
import org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage;
import org.eclipse.xtext.linking.ignoreCaseLinkingTest.Model;
import org.eclipse.xtext.linking.services.AbstractIgnoreCaseLinkingTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractAbstractIgnoreCaseLinkingTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AbstractIgnoreCaseLinkingTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == IgnoreCaseLinkingTestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case IgnoreCaseLinkingTestPackage.ELEMENT:
				if(context == grammarAccess.getElementRule()) {
					sequence_Element(context, (Element) semanticObject); 
					return; 
				}
				else break;
			case IgnoreCaseLinkingTestPackage.MODEL:
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
	 *     (name=ID reference=[Element|ID]? elements+=Element*)
	 */
	protected void sequence_Element(EObject context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements+=Element+
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
