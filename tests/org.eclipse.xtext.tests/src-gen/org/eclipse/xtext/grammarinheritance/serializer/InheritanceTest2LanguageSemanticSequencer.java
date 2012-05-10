package org.eclipse.xtext.grammarinheritance.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.grammarinheritance.inheritanceTest.Element;
import org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage;
import org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package;
import org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model;
import org.eclipse.xtext.grammarinheritance.serializer.InheritanceTestLanguageSemanticSequencer;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest2LanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class InheritanceTest2LanguageSemanticSequencer extends InheritanceTestLanguageSemanticSequencer {

	@Inject
	private InheritanceTest2LanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == InheritanceTestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InheritanceTestPackage.ELEMENT:
				if(context == grammarAccess.getElementRule()) {
					sequence_Element(context, (Element) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == InheritanceTest2Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InheritanceTest2Package.MODEL:
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
	 *     (name=ID elements+=Element* ids+=FQN)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
