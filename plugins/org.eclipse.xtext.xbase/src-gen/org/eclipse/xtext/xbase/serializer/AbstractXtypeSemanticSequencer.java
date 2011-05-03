package org.eclipse.xtext.xbase.serializer;

import java.util.Collections;
import static java.util.Collections.singleton;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.GenericSequencer;
import org.eclipse.xtext.serializer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ITransientValueService;
import org.eclipse.xtext.serializer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.impl.AbstractSemanticSequencer;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.common.types.*;
import org.eclipse.xtext.xtype.*;

import com.google.inject.Inject;
import com.google.inject.Provider;	

@SuppressWarnings("restriction")
public class AbstractXtypeSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected XtypeGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	protected ISemanticNodeProvider nodeProvider;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequenceAcceptor, errorAcceptor);
	}
	
	public Iterable<EObject> findContexts(EObject semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case TypesPackage.JVM_LOWER_BOUND:                  return singleton((EObject)grammarAccess.getJvmLowerBoundRule());
				case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE: return findContexts((JvmParameterizedTypeReference)semanticObject, consultContainer, contextCandidates);
				case TypesPackage.JVM_TYPE_PARAMETER:               return singleton((EObject)grammarAccess.getJvmTypeParameterRule());
				case TypesPackage.JVM_UPPER_BOUND:                  return findContexts((JvmUpperBound)semanticObject, consultContainer, contextCandidates);
				case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:      return findContexts((JvmWildcardTypeReference)semanticObject, consultContainer, contextCandidates);
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) 
			switch(semanticObject.eClass().getClassifierID()) {
				case XtypePackage.XFUNCTION_TYPE_REF: return findContexts((XFunctionTypeRef)semanticObject, consultContainer, contextCandidates);
			}
		return Collections.emptyList();
	}
	
	/**
	 * Potential Result Contexts:
	 *     getJvmTypeReferenceRule()
	 *     getJvmParameterizedTypeReferenceRule()
	 *     getJvmArgumentTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(JvmParameterizedTypeReference semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmUpperBoundRule()
	 *     getJvmUpperBoundAndedRule()
	 */
	protected Iterable<EObject> findContexts(JvmUpperBound semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmArgumentTypeReferenceRule()
	 *     getJvmWildcardTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(JvmWildcardTypeReference semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	
	/**
	 * Potential Result Contexts:
	 *     getJvmTypeReferenceRule()
	 *     getXFunctionTypeRefRule()
	 *     getJvmArgumentTypeReferenceRule()
	 */
	protected Iterable<EObject> findContexts(XFunctionTypeRef semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
		return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TypesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_LOWER_BOUND:
				if(context == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getJvmParameterizedTypeReferenceRule() ||
				   context == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				if(context == grammarAccess.getJvmTypeParameterRule()) {
					sequence_JvmTypeParameter_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_UPPER_BOUND:
				if(context == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				if(context == grammarAccess.getJvmArgumentTypeReferenceRule() ||
				   context == grammarAccess.getJvmWildcardTypeReferenceRule()) {
					sequence_JvmWildcardTypeReference_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == XtypePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				if(context == grammarAccess.getJvmTypeReferenceRule() ||
				   context == grammarAccess.getXFunctionTypeRefRule() ||
				   context == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_XFunctionTypeRef_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmLowerBound_JvmLowerBound(EObject context, JvmLowerBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?)
	 *
	 * Features:
	 *    arguments[0, *]
	 *    type[1, 1]
	 */
	protected void sequence_JvmParameterizedTypeReference_JvmParameterizedTypeReference(EObject context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID ((constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*) | constraints+=JvmLowerBound)?)
	 *
	 * Features:
	 *    arrayType[1, *]
	 *    name[1, 1]
	 */
	protected void sequence_JvmTypeParameter_JvmTypeParameter(EObject context, JvmTypeParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmUpperBoundAnded_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 *
	 * Features:
	 *    typeReference[1, 1]
	 */
	protected void sequence_JvmUpperBound_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((constraints+=JvmUpperBound | constraints+=JvmLowerBound)?)
	 *
	 * Features:
	 *    constraints[0, 2]
	 */
	protected void sequence_JvmWildcardTypeReference_JvmWildcardTypeReference(EObject context, JvmWildcardTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)? returnType=JvmTypeReference)
	 *
	 * Features:
	 *    paramTypes[0, *]
	 *    returnType[1, 1]
	 */
	protected void sequence_XFunctionTypeRef_XFunctionTypeRef(EObject context, XFunctionTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
