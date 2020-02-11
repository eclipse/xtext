/*******************************************************************************
 * Copyright (c) 2010, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public abstract class AbstractXtypeSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XtypeGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     JvmLowerBoundAnded returns JvmLowerBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmLowerBoundAnded(ISerializationContext context, JvmLowerBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_JvmLowerBoundAnded(EObject context, JvmLowerBound semanticObject) {
		sequence_JvmLowerBoundAnded(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmLowerBound returns JvmLowerBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmLowerBound(ISerializationContext context, JvmLowerBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_JvmLowerBound(EObject context, JvmLowerBound semanticObject) {
		sequence_JvmLowerBound(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmTypeReference returns JvmInnerTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmInnerTypeReference
	 *     JvmParameterizedTypeReference returns JvmInnerTypeReference
	 *     JvmParameterizedTypeReference.JvmInnerTypeReference_1_4_0_0_0 returns JvmInnerTypeReference
	 *     JvmArgumentTypeReference returns JvmInnerTypeReference
	 *
	 * Constraint:
	 *     (
	 *         outer=JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0 
	 *         type=[JvmType|ValidID] 
	 *         (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?
	 *     )
	 */
	protected void sequence_JvmParameterizedTypeReference(ISerializationContext context, JvmInnerTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmParameterizedTypeReference(EObject context, JvmInnerTypeReference semanticObject) {
		sequence_JvmParameterizedTypeReference(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmParameterizedTypeReference.JvmInnerTypeReference_1_4_0_0_0 returns JvmParameterizedTypeReference
	 *
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)
	 */
	protected void sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(EObject context, JvmParameterizedTypeReference semanticObject) {
		sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmTypeReference returns JvmParameterizedTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmParameterizedTypeReference
	 *     JvmParameterizedTypeReference returns JvmParameterizedTypeReference
	 *     JvmArgumentTypeReference returns JvmParameterizedTypeReference
	 *
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?)
	 */
	protected void sequence_JvmParameterizedTypeReference(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmParameterizedTypeReference(EObject context, JvmParameterizedTypeReference semanticObject) {
		sequence_JvmParameterizedTypeReference(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmTypeParameter returns JvmTypeParameter
	 *
	 * Constraint:
	 *     (name=ValidID (constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*)?)
	 */
	protected void sequence_JvmTypeParameter(ISerializationContext context, JvmTypeParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmTypeParameter(EObject context, JvmTypeParameter semanticObject) {
		sequence_JvmTypeParameter(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmTypeReference returns JvmGenericArrayTypeReference
	 *     JvmTypeReference.JvmGenericArrayTypeReference_0_1_0_0 returns JvmGenericArrayTypeReference
	 *     JvmArgumentTypeReference returns JvmGenericArrayTypeReference
	 *
	 * Constraint:
	 *     componentType=JvmTypeReference_JvmGenericArrayTypeReference_0_1_0_0
	 */
	protected void sequence_JvmTypeReference(ISerializationContext context, JvmGenericArrayTypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(), semanticObject.getComponentType());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_JvmTypeReference(EObject context, JvmGenericArrayTypeReference semanticObject) {
		sequence_JvmTypeReference(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmUpperBoundAnded returns JvmUpperBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmUpperBoundAnded(ISerializationContext context, JvmUpperBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_JvmUpperBoundAnded(EObject context, JvmUpperBound semanticObject) {
		sequence_JvmUpperBoundAnded(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmUpperBound returns JvmUpperBound
	 *
	 * Constraint:
	 *     typeReference=JvmTypeReference
	 */
	protected void sequence_JvmUpperBound(ISerializationContext context, JvmUpperBound semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_TYPE_CONSTRAINT__TYPE_REFERENCE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0(), semanticObject.getTypeReference());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_JvmUpperBound(EObject context, JvmUpperBound semanticObject) {
		sequence_JvmUpperBound(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmArgumentTypeReference returns JvmWildcardTypeReference
	 *     JvmWildcardTypeReference returns JvmWildcardTypeReference
	 *
	 * Constraint:
	 *     ((constraints+=JvmUpperBound constraints+=JvmUpperBoundAnded*) | (constraints+=JvmLowerBound constraints+=JvmLowerBoundAnded*))?
	 */
	protected void sequence_JvmWildcardTypeReference(ISerializationContext context, JvmWildcardTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmWildcardTypeReference(EObject context, JvmWildcardTypeReference semanticObject) {
		sequence_JvmWildcardTypeReference(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmTypeReference returns XFunctionTypeRef
	 *     XFunctionTypeRef returns XFunctionTypeRef
	 *     JvmArgumentTypeReference returns XFunctionTypeRef
	 *
	 * Constraint:
	 *     ((paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)? returnType=JvmTypeReference)
	 */
	protected void sequence_XFunctionTypeRef(ISerializationContext context, XFunctionTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XFunctionTypeRef(EObject context, XFunctionTypeRef semanticObject) {
		sequence_XFunctionTypeRef(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XImportDeclaration returns XImportDeclaration
	 *
	 * Constraint:
	 *     (
	 *         (static?='static' extension?='extension'? importedType=[JvmDeclaredType|QualifiedNameInStaticImport] (wildcard?='*' | memberName=ValidID)) | 
	 *         importedType=[JvmDeclaredType|QualifiedName] | 
	 *         importedNamespace=QualifiedNameWithWildcard
	 *     )
	 */
	protected void sequence_XImportDeclaration(ISerializationContext context, XImportDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XImportDeclaration(EObject context, XImportDeclaration semanticObject) {
		sequence_XImportDeclaration(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XImportSection returns XImportSection
	 *
	 * Constraint:
	 *     importDeclarations+=XImportDeclaration+
	 */
	protected void sequence_XImportSection(ISerializationContext context, XImportSection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XImportSection(EObject context, XImportSection semanticObject) {
		sequence_XImportSection(createContext(context, semanticObject), semanticObject);
	}
	
}
