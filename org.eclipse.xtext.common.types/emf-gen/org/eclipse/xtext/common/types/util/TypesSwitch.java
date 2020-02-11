/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.common.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.common.types.TypesPackage
 * @generated
 */
public class TypesSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = TypesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case TypesPackage.JVM_IDENTIFIABLE_ELEMENT:
			{
				JvmIdentifiableElement jvmIdentifiableElement = (JvmIdentifiableElement)theEObject;
				T result = caseJvmIdentifiableElement(jvmIdentifiableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE:
			{
				JvmType jvmType = (JvmType)theEObject;
				T result = caseJvmType(jvmType);
				if (result == null) result = caseJvmIdentifiableElement(jvmType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_VOID:
			{
				JvmVoid jvmVoid = (JvmVoid)theEObject;
				T result = caseJvmVoid(jvmVoid);
				if (result == null) result = caseJvmType(jvmVoid);
				if (result == null) result = caseJvmIdentifiableElement(jvmVoid);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_COMPONENT_TYPE:
			{
				JvmComponentType jvmComponentType = (JvmComponentType)theEObject;
				T result = caseJvmComponentType(jvmComponentType);
				if (result == null) result = caseJvmType(jvmComponentType);
				if (result == null) result = caseJvmIdentifiableElement(jvmComponentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_PRIMITIVE_TYPE:
			{
				JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType)theEObject;
				T result = caseJvmPrimitiveType(jvmPrimitiveType);
				if (result == null) result = caseJvmComponentType(jvmPrimitiveType);
				if (result == null) result = caseJvmType(jvmPrimitiveType);
				if (result == null) result = caseJvmIdentifiableElement(jvmPrimitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ARRAY_TYPE:
			{
				JvmArrayType jvmArrayType = (JvmArrayType)theEObject;
				T result = caseJvmArrayType(jvmArrayType);
				if (result == null) result = caseJvmComponentType(jvmArrayType);
				if (result == null) result = caseJvmType(jvmArrayType);
				if (result == null) result = caseJvmIdentifiableElement(jvmArrayType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_DECLARED_TYPE:
			{
				JvmDeclaredType jvmDeclaredType = (JvmDeclaredType)theEObject;
				T result = caseJvmDeclaredType(jvmDeclaredType);
				if (result == null) result = caseJvmMember(jvmDeclaredType);
				if (result == null) result = caseJvmComponentType(jvmDeclaredType);
				if (result == null) result = caseJvmAnnotationTarget(jvmDeclaredType);
				if (result == null) result = caseJvmType(jvmDeclaredType);
				if (result == null) result = caseJvmIdentifiableElement(jvmDeclaredType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE_PARAMETER:
			{
				JvmTypeParameter jvmTypeParameter = (JvmTypeParameter)theEObject;
				T result = caseJvmTypeParameter(jvmTypeParameter);
				if (result == null) result = caseJvmComponentType(jvmTypeParameter);
				if (result == null) result = caseJvmConstraintOwner(jvmTypeParameter);
				if (result == null) result = caseJvmType(jvmTypeParameter);
				if (result == null) result = caseJvmIdentifiableElement(jvmTypeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR:
			{
				JvmTypeParameterDeclarator jvmTypeParameterDeclarator = (JvmTypeParameterDeclarator)theEObject;
				T result = caseJvmTypeParameterDeclarator(jvmTypeParameterDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_CONSTRAINT_OWNER:
			{
				JvmConstraintOwner jvmConstraintOwner = (JvmConstraintOwner)theEObject;
				T result = caseJvmConstraintOwner(jvmConstraintOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE_CONSTRAINT:
			{
				JvmTypeConstraint jvmTypeConstraint = (JvmTypeConstraint)theEObject;
				T result = caseJvmTypeConstraint(jvmTypeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_UPPER_BOUND:
			{
				JvmUpperBound jvmUpperBound = (JvmUpperBound)theEObject;
				T result = caseJvmUpperBound(jvmUpperBound);
				if (result == null) result = caseJvmTypeConstraint(jvmUpperBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_LOWER_BOUND:
			{
				JvmLowerBound jvmLowerBound = (JvmLowerBound)theEObject;
				T result = caseJvmLowerBound(jvmLowerBound);
				if (result == null) result = caseJvmTypeConstraint(jvmLowerBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANNOTATION_TYPE:
			{
				JvmAnnotationType jvmAnnotationType = (JvmAnnotationType)theEObject;
				T result = caseJvmAnnotationType(jvmAnnotationType);
				if (result == null) result = caseJvmDeclaredType(jvmAnnotationType);
				if (result == null) result = caseJvmMember(jvmAnnotationType);
				if (result == null) result = caseJvmComponentType(jvmAnnotationType);
				if (result == null) result = caseJvmAnnotationTarget(jvmAnnotationType);
				if (result == null) result = caseJvmType(jvmAnnotationType);
				if (result == null) result = caseJvmIdentifiableElement(jvmAnnotationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ENUMERATION_TYPE:
			{
				JvmEnumerationType jvmEnumerationType = (JvmEnumerationType)theEObject;
				T result = caseJvmEnumerationType(jvmEnumerationType);
				if (result == null) result = caseJvmDeclaredType(jvmEnumerationType);
				if (result == null) result = caseJvmMember(jvmEnumerationType);
				if (result == null) result = caseJvmComponentType(jvmEnumerationType);
				if (result == null) result = caseJvmAnnotationTarget(jvmEnumerationType);
				if (result == null) result = caseJvmType(jvmEnumerationType);
				if (result == null) result = caseJvmIdentifiableElement(jvmEnumerationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ENUMERATION_LITERAL:
			{
				JvmEnumerationLiteral jvmEnumerationLiteral = (JvmEnumerationLiteral)theEObject;
				T result = caseJvmEnumerationLiteral(jvmEnumerationLiteral);
				if (result == null) result = caseJvmField(jvmEnumerationLiteral);
				if (result == null) result = caseJvmFeature(jvmEnumerationLiteral);
				if (result == null) result = caseJvmMember(jvmEnumerationLiteral);
				if (result == null) result = caseJvmAnnotationTarget(jvmEnumerationLiteral);
				if (result == null) result = caseJvmIdentifiableElement(jvmEnumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_GENERIC_TYPE:
			{
				JvmGenericType jvmGenericType = (JvmGenericType)theEObject;
				T result = caseJvmGenericType(jvmGenericType);
				if (result == null) result = caseJvmDeclaredType(jvmGenericType);
				if (result == null) result = caseJvmTypeParameterDeclarator(jvmGenericType);
				if (result == null) result = caseJvmMember(jvmGenericType);
				if (result == null) result = caseJvmComponentType(jvmGenericType);
				if (result == null) result = caseJvmAnnotationTarget(jvmGenericType);
				if (result == null) result = caseJvmType(jvmGenericType);
				if (result == null) result = caseJvmIdentifiableElement(jvmGenericType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE_REFERENCE:
			{
				JvmTypeReference jvmTypeReference = (JvmTypeReference)theEObject;
				T result = caseJvmTypeReference(jvmTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
			{
				JvmParameterizedTypeReference jvmParameterizedTypeReference = (JvmParameterizedTypeReference)theEObject;
				T result = caseJvmParameterizedTypeReference(jvmParameterizedTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmParameterizedTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
			{
				JvmGenericArrayTypeReference jvmGenericArrayTypeReference = (JvmGenericArrayTypeReference)theEObject;
				T result = caseJvmGenericArrayTypeReference(jvmGenericArrayTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmGenericArrayTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
			{
				JvmWildcardTypeReference jvmWildcardTypeReference = (JvmWildcardTypeReference)theEObject;
				T result = caseJvmWildcardTypeReference(jvmWildcardTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmWildcardTypeReference);
				if (result == null) result = caseJvmConstraintOwner(jvmWildcardTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANY_TYPE_REFERENCE:
			{
				JvmAnyTypeReference jvmAnyTypeReference = (JvmAnyTypeReference)theEObject;
				T result = caseJvmAnyTypeReference(jvmAnyTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmAnyTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_MULTI_TYPE_REFERENCE:
			{
				JvmMultiTypeReference jvmMultiTypeReference = (JvmMultiTypeReference)theEObject;
				T result = caseJvmMultiTypeReference(jvmMultiTypeReference);
				if (result == null) result = caseJvmCompoundTypeReference(jvmMultiTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmMultiTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_MEMBER:
			{
				JvmMember jvmMember = (JvmMember)theEObject;
				T result = caseJvmMember(jvmMember);
				if (result == null) result = caseJvmAnnotationTarget(jvmMember);
				if (result == null) result = caseJvmIdentifiableElement(jvmMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_FEATURE:
			{
				JvmFeature jvmFeature = (JvmFeature)theEObject;
				T result = caseJvmFeature(jvmFeature);
				if (result == null) result = caseJvmMember(jvmFeature);
				if (result == null) result = caseJvmAnnotationTarget(jvmFeature);
				if (result == null) result = caseJvmIdentifiableElement(jvmFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_FIELD:
			{
				JvmField jvmField = (JvmField)theEObject;
				T result = caseJvmField(jvmField);
				if (result == null) result = caseJvmFeature(jvmField);
				if (result == null) result = caseJvmMember(jvmField);
				if (result == null) result = caseJvmAnnotationTarget(jvmField);
				if (result == null) result = caseJvmIdentifiableElement(jvmField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_EXECUTABLE:
			{
				JvmExecutable jvmExecutable = (JvmExecutable)theEObject;
				T result = caseJvmExecutable(jvmExecutable);
				if (result == null) result = caseJvmFeature(jvmExecutable);
				if (result == null) result = caseJvmTypeParameterDeclarator(jvmExecutable);
				if (result == null) result = caseJvmMember(jvmExecutable);
				if (result == null) result = caseJvmAnnotationTarget(jvmExecutable);
				if (result == null) result = caseJvmIdentifiableElement(jvmExecutable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_CONSTRUCTOR:
			{
				JvmConstructor jvmConstructor = (JvmConstructor)theEObject;
				T result = caseJvmConstructor(jvmConstructor);
				if (result == null) result = caseJvmExecutable(jvmConstructor);
				if (result == null) result = caseJvmFeature(jvmConstructor);
				if (result == null) result = caseJvmTypeParameterDeclarator(jvmConstructor);
				if (result == null) result = caseJvmMember(jvmConstructor);
				if (result == null) result = caseJvmAnnotationTarget(jvmConstructor);
				if (result == null) result = caseJvmIdentifiableElement(jvmConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_OPERATION:
			{
				JvmOperation jvmOperation = (JvmOperation)theEObject;
				T result = caseJvmOperation(jvmOperation);
				if (result == null) result = caseJvmExecutable(jvmOperation);
				if (result == null) result = caseJvmFeature(jvmOperation);
				if (result == null) result = caseJvmTypeParameterDeclarator(jvmOperation);
				if (result == null) result = caseJvmMember(jvmOperation);
				if (result == null) result = caseJvmAnnotationTarget(jvmOperation);
				if (result == null) result = caseJvmIdentifiableElement(jvmOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_FORMAL_PARAMETER:
			{
				JvmFormalParameter jvmFormalParameter = (JvmFormalParameter)theEObject;
				T result = caseJvmFormalParameter(jvmFormalParameter);
				if (result == null) result = caseJvmAnnotationTarget(jvmFormalParameter);
				if (result == null) result = caseJvmIdentifiableElement(jvmFormalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANNOTATION_TARGET:
			{
				JvmAnnotationTarget jvmAnnotationTarget = (JvmAnnotationTarget)theEObject;
				T result = caseJvmAnnotationTarget(jvmAnnotationTarget);
				if (result == null) result = caseJvmIdentifiableElement(jvmAnnotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANNOTATION_REFERENCE:
			{
				JvmAnnotationReference jvmAnnotationReference = (JvmAnnotationReference)theEObject;
				T result = caseJvmAnnotationReference(jvmAnnotationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANNOTATION_VALUE:
			{
				JvmAnnotationValue jvmAnnotationValue = (JvmAnnotationValue)theEObject;
				T result = caseJvmAnnotationValue(jvmAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_INT_ANNOTATION_VALUE:
			{
				JvmIntAnnotationValue jvmIntAnnotationValue = (JvmIntAnnotationValue)theEObject;
				T result = caseJvmIntAnnotationValue(jvmIntAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmIntAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_BOOLEAN_ANNOTATION_VALUE:
			{
				JvmBooleanAnnotationValue jvmBooleanAnnotationValue = (JvmBooleanAnnotationValue)theEObject;
				T result = caseJvmBooleanAnnotationValue(jvmBooleanAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmBooleanAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_BYTE_ANNOTATION_VALUE:
			{
				JvmByteAnnotationValue jvmByteAnnotationValue = (JvmByteAnnotationValue)theEObject;
				T result = caseJvmByteAnnotationValue(jvmByteAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmByteAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_SHORT_ANNOTATION_VALUE:
			{
				JvmShortAnnotationValue jvmShortAnnotationValue = (JvmShortAnnotationValue)theEObject;
				T result = caseJvmShortAnnotationValue(jvmShortAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmShortAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_LONG_ANNOTATION_VALUE:
			{
				JvmLongAnnotationValue jvmLongAnnotationValue = (JvmLongAnnotationValue)theEObject;
				T result = caseJvmLongAnnotationValue(jvmLongAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmLongAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_DOUBLE_ANNOTATION_VALUE:
			{
				JvmDoubleAnnotationValue jvmDoubleAnnotationValue = (JvmDoubleAnnotationValue)theEObject;
				T result = caseJvmDoubleAnnotationValue(jvmDoubleAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmDoubleAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_FLOAT_ANNOTATION_VALUE:
			{
				JvmFloatAnnotationValue jvmFloatAnnotationValue = (JvmFloatAnnotationValue)theEObject;
				T result = caseJvmFloatAnnotationValue(jvmFloatAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmFloatAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_CHAR_ANNOTATION_VALUE:
			{
				JvmCharAnnotationValue jvmCharAnnotationValue = (JvmCharAnnotationValue)theEObject;
				T result = caseJvmCharAnnotationValue(jvmCharAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmCharAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_STRING_ANNOTATION_VALUE:
			{
				JvmStringAnnotationValue jvmStringAnnotationValue = (JvmStringAnnotationValue)theEObject;
				T result = caseJvmStringAnnotationValue(jvmStringAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmStringAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_TYPE_ANNOTATION_VALUE:
			{
				JvmTypeAnnotationValue jvmTypeAnnotationValue = (JvmTypeAnnotationValue)theEObject;
				T result = caseJvmTypeAnnotationValue(jvmTypeAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmTypeAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ANNOTATION_ANNOTATION_VALUE:
			{
				JvmAnnotationAnnotationValue jvmAnnotationAnnotationValue = (JvmAnnotationAnnotationValue)theEObject;
				T result = caseJvmAnnotationAnnotationValue(jvmAnnotationAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmAnnotationAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_ENUM_ANNOTATION_VALUE:
			{
				JvmEnumAnnotationValue jvmEnumAnnotationValue = (JvmEnumAnnotationValue)theEObject;
				T result = caseJvmEnumAnnotationValue(jvmEnumAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmEnumAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_DELEGATE_TYPE_REFERENCE:
			{
				JvmDelegateTypeReference jvmDelegateTypeReference = (JvmDelegateTypeReference)theEObject;
				T result = caseJvmDelegateTypeReference(jvmDelegateTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmDelegateTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_SPECIALIZED_TYPE_REFERENCE:
			{
				JvmSpecializedTypeReference jvmSpecializedTypeReference = (JvmSpecializedTypeReference)theEObject;
				T result = caseJvmSpecializedTypeReference(jvmSpecializedTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmSpecializedTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_SYNONYM_TYPE_REFERENCE:
			{
				JvmSynonymTypeReference jvmSynonymTypeReference = (JvmSynonymTypeReference)theEObject;
				T result = caseJvmSynonymTypeReference(jvmSynonymTypeReference);
				if (result == null) result = caseJvmCompoundTypeReference(jvmSynonymTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmSynonymTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_UNKNOWN_TYPE_REFERENCE:
			{
				JvmUnknownTypeReference jvmUnknownTypeReference = (JvmUnknownTypeReference)theEObject;
				T result = caseJvmUnknownTypeReference(jvmUnknownTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmUnknownTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_COMPOUND_TYPE_REFERENCE:
			{
				JvmCompoundTypeReference jvmCompoundTypeReference = (JvmCompoundTypeReference)theEObject;
				T result = caseJvmCompoundTypeReference(jvmCompoundTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmCompoundTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_CUSTOM_ANNOTATION_VALUE:
			{
				JvmCustomAnnotationValue jvmCustomAnnotationValue = (JvmCustomAnnotationValue)theEObject;
				T result = caseJvmCustomAnnotationValue(jvmCustomAnnotationValue);
				if (result == null) result = caseJvmAnnotationValue(jvmCustomAnnotationValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
			{
				JvmInnerTypeReference jvmInnerTypeReference = (JvmInnerTypeReference)theEObject;
				T result = caseJvmInnerTypeReference(jvmInnerTypeReference);
				if (result == null) result = caseJvmParameterizedTypeReference(jvmInnerTypeReference);
				if (result == null) result = caseJvmTypeReference(jvmInnerTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIdentifiableElement(JvmIdentifiableElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmType(JvmType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Void</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Void</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmVoid(JvmVoid object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmComponentType(JvmComponentType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmPrimitiveType(JvmPrimitiveType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmArrayType(JvmArrayType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Declared Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Declared Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmDeclaredType(JvmDeclaredType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeParameter(JvmTypeParameter object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Parameter Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Parameter Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeParameterDeclarator(JvmTypeParameterDeclarator object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Constraint Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Constraint Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmConstraintOwner(JvmConstraintOwner object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeConstraint(JvmTypeConstraint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Upper Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Upper Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmUpperBound(JvmUpperBound object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Lower Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Lower Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmLowerBound(JvmLowerBound object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationType(JvmAnnotationType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmEnumerationType(JvmEnumerationType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmEnumerationLiteral(JvmEnumerationLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Generic Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Generic Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmGenericType(JvmGenericType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeReference(JvmTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Parameterized Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Parameterized Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmParameterizedTypeReference(JvmParameterizedTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Generic Array Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Generic Array Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmGenericArrayTypeReference(JvmGenericArrayTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Wildcard Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Wildcard Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmWildcardTypeReference(JvmWildcardTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Any Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Any Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnyTypeReference(JvmAnyTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Multi Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Multi Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmMultiTypeReference(JvmMultiTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmMember(JvmMember object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFeature(JvmFeature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmField(JvmField object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Executable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Executable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmExecutable(JvmExecutable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmConstructor(JvmConstructor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmOperation(JvmOperation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFormalParameter(JvmFormalParameter object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationTarget(JvmAnnotationTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationReference(JvmAnnotationReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationValue(JvmAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Int Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Int Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIntAnnotationValue(JvmIntAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Boolean Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Boolean Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmBooleanAnnotationValue(JvmBooleanAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Byte Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Byte Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmByteAnnotationValue(JvmByteAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Short Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Short Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmShortAnnotationValue(JvmShortAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Long Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Long Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmLongAnnotationValue(JvmLongAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Double Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Double Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmDoubleAnnotationValue(JvmDoubleAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Float Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Float Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFloatAnnotationValue(JvmFloatAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Char Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Char Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmCharAnnotationValue(JvmCharAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm String Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm String Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmStringAnnotationValue(JvmStringAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeAnnotationValue(JvmTypeAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationAnnotationValue(JvmAnnotationAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Enum Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Enum Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmEnumAnnotationValue(JvmEnumAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Delegate Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Delegate Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmDelegateTypeReference(JvmDelegateTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Specialized Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Specialized Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmSpecializedTypeReference(JvmSpecializedTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Synonym Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Synonym Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmSynonymTypeReference(JvmSynonymTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Unknown Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Unknown Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmUnknownTypeReference(JvmUnknownTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Compound Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Compound Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmCompoundTypeReference(JvmCompoundTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Custom Annotation Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Custom Annotation Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmCustomAnnotationValue(JvmCustomAnnotationValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Inner Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Inner Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmInnerTypeReference(JvmInnerTypeReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //TypesSwitch
