package org.eclipse.xtext.linking.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.bug287988Test.Attribute;
import org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage;
import org.eclipse.xtext.linking.bug287988Test.Master;
import org.eclipse.xtext.linking.bug287988Test.Model;
import org.eclipse.xtext.linking.services.Bug287988TestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractBug287988TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug287988TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == Bug287988TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug287988TestPackage.ATTRIBUTE:
				if(context == grammarAccess.getActionAttributeRule()) {
					sequence_ActionAttribute(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBaseAttributeRule()) {
					sequence_BaseAttribute(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getCallMe2Rule()) {
					sequence_CallMe2(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getCallMe3Rule() ||
				   context == grammarAccess.getCallMe4Rule()) {
					sequence_CallMe4(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getCallMeRule()) {
					sequence_CallMe(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRuleCallAttribute2Rule()) {
					sequence_RuleCallAttribute2(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRuleCallAttribute3Rule()) {
					sequence_RuleCallAttribute3(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getRuleCallAttributeRule()) {
					sequence_RuleCallAttribute(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSimpleAttributeRule()) {
					sequence_SimpleAttribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case Bug287988TestPackage.MASTER:
				if(context == grammarAccess.getActionAttributeRule()) {
					sequence_ActionAttribute(context, (Master) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBaseAttributeRule()) {
					sequence_BaseAttribute(context, (Master) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMasterRule()) {
					sequence_Master(context, (Master) semanticObject); 
					return; 
				}
				else break;
			case Bug287988TestPackage.MODEL:
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
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_ActionAttribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_ActionAttribute(EObject context, Master semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Attribute}
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_BaseAttribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_BaseAttribute(EObject context, Master semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_CallMe2(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_CallMe4(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeRef=[BaseAttribute|ID] | type=ID)
	 */
	protected void sequence_CallMe(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Master}
	 */
	protected void sequence_Master(EObject context, Master semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         attributes+=BaseAttribute* | 
	 *         attributes+=SimpleAttribute* | 
	 *         attributes+=RuleCallAttribute* | 
	 *         attributes+=RuleCallAttribute2* | 
	 *         attributes+=RuleCallAttribute3* | 
	 *         attributes+=ActionAttribute*
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (typeRef=[BaseAttribute|ID] | type=ID))
	 */
	protected void sequence_RuleCallAttribute2(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (typeRef=[BaseAttribute|ID] | type=ID))
	 */
	protected void sequence_RuleCallAttribute3(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_RuleCallAttribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((typeRef=[BaseAttribute|ID] | type=ID) name=ID)
	 */
	protected void sequence_SimpleAttribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
