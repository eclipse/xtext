package org.eclipse.xtext.metamodelreferencing.tests.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.EcorePerNsURIPackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerNsURI.ExtendsNsURIEObject;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.EcorePerPlatformPluginPackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformPlugin.ExtendsPluginEObject;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.EcorePerPlatformResourcePackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecorePerPlatformResource.ExtendsResourceEObject;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage;
import org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.Model;
import org.eclipse.xtext.metamodelreferencing.tests.services.EcoreReferenceTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractEcoreReferenceTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected EcoreReferenceTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == EcorePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePackage.EATTRIBUTE:
				if(context == grammarAccess.getEAttributeRule()) {
					sequence_EAttribute(context, (EAttribute) semanticObject); 
					return; 
				}
				else break;
			case EcorePackage.EOBJECT:
				if(context == grammarAccess.getEObjectRule()) {
					sequence_EObject(context, (EObject) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EcorePerNsURIPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePerNsURIPackage.EXTENDS_NS_URIE_OBJECT:
				if(context == grammarAccess.getExtendsNsURIEObjectRule()) {
					sequence_ExtendsNsURIEObject(context, (ExtendsNsURIEObject) semanticObject); 
					return; 
				}
				else break;
			case EcorePerNsURIPackage.MY_EATTRIBUTE:
				if(context == grammarAccess.getMyEAttributeRule()) {
					sequence_MyEAttribute(context, (EAttribute) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EcorePerPlatformPluginPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePerPlatformPluginPackage.EXTENDS_PLUGIN_EOBJECT:
				if(context == grammarAccess.getExtendsPluginEObjectRule()) {
					sequence_ExtendsPluginEObject(context, (ExtendsPluginEObject) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EcorePerPlatformResourcePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePerPlatformResourcePackage.EXTENDS_RESOURCE_EOBJECT:
				if(context == grammarAccess.getExtendsResourceEObjectRule()) {
					sequence_ExtendsResourceEObject(context, (ExtendsResourceEObject) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EcoreReferencePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcoreReferencePackage.MODEL:
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
	 *     {EAttribute}
	 */
	protected void sequence_EAttribute(EObject context, EAttribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EObject}
	 */
	protected void sequence_EObject(EObject context, EObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         (
	 *             eObjectReference1=[EObject|ID] | 
	 *             eObjectReference1=[ExtendsNsURIEObject|ID] | 
	 *             eObjectReference1=[ExtendsPluginEObject|ID] | 
	 *             eObjectReference1=[ExtendsResourceEObject|ID]
	 *         ) 
	 *         (
	 *             eAttributeReference=[MyEAttribute|ID] 
	 *             eObjectReference2=[ExtendsNsURIEObject|ID] 
	 *             eObjectReference3=[ExtendsPluginEObject|ID] 
	 *             eObjectReference4=[ExtendsResourceEObject|ID] 
	 *             eObjectContainment+=ExtendsNsURIEObject? 
	 *             eObjectContainment+=ExtendsPluginEObject? 
	 *             eObjectContainment+=ExtendsResourceEObject? 
	 *             eObjectContainment+=EObject 
	 *             eObjectContainment+=EAttribute 
	 *             eObjectContainment+=MyEAttribute
	 *         )?
	 *     )
	 */
	protected void sequence_ExtendsNsURIEObject(EObject context, ExtendsNsURIEObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         (
	 *             eObjectReference1=[EObject|ID] | 
	 *             eObjectReference1=[ExtendsNsURIEObject|ID] | 
	 *             eObjectReference1=[ExtendsPluginEObject|ID] | 
	 *             eObjectReference1=[ExtendsResourceEObject|ID]
	 *         ) 
	 *         (
	 *             eObjectReference2=[ExtendsNsURIEObject|ID] 
	 *             eObjectReference3=[ExtendsPluginEObject|ID] 
	 *             eObjectReference4=[ExtendsResourceEObject|ID] 
	 *             eObjectContainment+=ExtendsNsURIEObject? 
	 *             eObjectContainment+=ExtendsPluginEObject? 
	 *             eObjectContainment+=ExtendsResourceEObject? 
	 *             eObjectContainment+=EObject 
	 *             eObjectContainment+=EAttribute 
	 *             eObjectContainment+=MyEAttribute
	 *         )?
	 *     )
	 */
	protected void sequence_ExtendsPluginEObject(EObject context, ExtendsPluginEObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ValidID 
	 *         (
	 *             eObjectReference1=[EObject|ID] | 
	 *             eObjectReference1=[ExtendsNsURIEObject|ID] | 
	 *             eObjectReference1=[ExtendsPluginEObject|ID] | 
	 *             eObjectReference1=[ExtendsResourceEObject|ID]
	 *         ) 
	 *         (
	 *             eObjectReference2=[ExtendsNsURIEObject|ID] 
	 *             eObjectReference3=[ExtendsPluginEObject|ID] 
	 *             eObjectReference4=[ExtendsResourceEObject|ID] 
	 *             eObjectContainment+=ExtendsNsURIEObject 
	 *             eObjectContainment+=ExtendsPluginEObject 
	 *             eObjectContainment+=ExtendsResourceEObject 
	 *             eObjectContainment+=EObject 
	 *             eObjectContainment+=EAttribute 
	 *             eObjectContainment+=MyEAttribute
	 *         )?
	 *     )
	 */
	protected void sequence_ExtendsResourceEObject(EObject context, ExtendsResourceEObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (extends+=ExtendsNsURIEObject extends+=ExtendsPluginEObject extends+=ExtendsResourceEObject)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {MyEAttribute}
	 */
	protected void sequence_MyEAttribute(EObject context, EAttribute semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
}
