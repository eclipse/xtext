/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.AnnotationReference;
import org.eclipse.xtext.common.types.AnnotationTarget;
import org.eclipse.xtext.common.types.AnnotationType;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.ComponentType;
import org.eclipse.xtext.common.types.ConstraintOwner;
import org.eclipse.xtext.common.types.Constructor;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.EnumerationType;
import org.eclipse.xtext.common.types.Executable;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericArrayTypeReference;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.IdentifyableElement;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.Member;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ParameterizedTypeReference;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.ReferenceTypeArgument;
import org.eclipse.xtext.common.types.SimpleTypeReference;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypeParameterDeclarator;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.WildcardTypeArgument;

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
public class TypesSwitch<T> {
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
	public TypesSwitch() {
		if (modelPackage == null) {
			modelPackage = TypesPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TypesPackage.IDENTIFYABLE_ELEMENT: {
				IdentifyableElement identifyableElement = (IdentifyableElement)theEObject;
				T result = caseIdentifyableElement(identifyableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseIdentifyableElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.VOID: {
				org.eclipse.xtext.common.types.Void void_ = (org.eclipse.xtext.common.types.Void)theEObject;
				T result = caseVoid(void_);
				if (result == null) result = caseType(void_);
				if (result == null) result = caseIdentifyableElement(void_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				T result = caseComponentType(componentType);
				if (result == null) result = caseType(componentType);
				if (result == null) result = caseIdentifyableElement(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseComponentType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseIdentifyableElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ARRAY_TYPE: {
				ArrayType arrayType = (ArrayType)theEObject;
				T result = caseArrayType(arrayType);
				if (result == null) result = caseComponentType(arrayType);
				if (result == null) result = caseType(arrayType);
				if (result == null) result = caseIdentifyableElement(arrayType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.DECLARED_TYPE: {
				DeclaredType declaredType = (DeclaredType)theEObject;
				T result = caseDeclaredType(declaredType);
				if (result == null) result = caseComponentType(declaredType);
				if (result == null) result = caseMember(declaredType);
				if (result == null) result = caseType(declaredType);
				if (result == null) result = caseAnnotationTarget(declaredType);
				if (result == null) result = caseIdentifyableElement(declaredType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_PARAMETER: {
				TypeParameter typeParameter = (TypeParameter)theEObject;
				T result = caseTypeParameter(typeParameter);
				if (result == null) result = caseComponentType(typeParameter);
				if (result == null) result = caseConstraintOwner(typeParameter);
				if (result == null) result = caseType(typeParameter);
				if (result == null) result = caseIdentifyableElement(typeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_PARAMETER_DECLARATOR: {
				TypeParameterDeclarator typeParameterDeclarator = (TypeParameterDeclarator)theEObject;
				T result = caseTypeParameterDeclarator(typeParameterDeclarator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.CONSTRAINT_OWNER: {
				ConstraintOwner constraintOwner = (ConstraintOwner)theEObject;
				T result = caseConstraintOwner(constraintOwner);
				if (result == null) result = caseIdentifyableElement(constraintOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_CONSTRAINT: {
				TypeConstraint typeConstraint = (TypeConstraint)theEObject;
				T result = caseTypeConstraint(typeConstraint);
				if (result == null) result = caseIdentifyableElement(typeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.UPPER_BOUND: {
				UpperBound upperBound = (UpperBound)theEObject;
				T result = caseUpperBound(upperBound);
				if (result == null) result = caseTypeConstraint(upperBound);
				if (result == null) result = caseIdentifyableElement(upperBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.LOWER_BOUND: {
				LowerBound lowerBound = (LowerBound)theEObject;
				T result = caseLowerBound(lowerBound);
				if (result == null) result = caseTypeConstraint(lowerBound);
				if (result == null) result = caseIdentifyableElement(lowerBound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ANNOTATION_TYPE: {
				AnnotationType annotationType = (AnnotationType)theEObject;
				T result = caseAnnotationType(annotationType);
				if (result == null) result = caseDeclaredType(annotationType);
				if (result == null) result = caseComponentType(annotationType);
				if (result == null) result = caseMember(annotationType);
				if (result == null) result = caseType(annotationType);
				if (result == null) result = caseAnnotationTarget(annotationType);
				if (result == null) result = caseIdentifyableElement(annotationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ENUMERATION_TYPE: {
				EnumerationType enumerationType = (EnumerationType)theEObject;
				T result = caseEnumerationType(enumerationType);
				if (result == null) result = caseDeclaredType(enumerationType);
				if (result == null) result = caseComponentType(enumerationType);
				if (result == null) result = caseMember(enumerationType);
				if (result == null) result = caseType(enumerationType);
				if (result == null) result = caseAnnotationTarget(enumerationType);
				if (result == null) result = caseIdentifyableElement(enumerationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.GENERIC_TYPE: {
				GenericType genericType = (GenericType)theEObject;
				T result = caseGenericType(genericType);
				if (result == null) result = caseDeclaredType(genericType);
				if (result == null) result = caseTypeParameterDeclarator(genericType);
				if (result == null) result = caseComponentType(genericType);
				if (result == null) result = caseMember(genericType);
				if (result == null) result = caseType(genericType);
				if (result == null) result = caseAnnotationTarget(genericType);
				if (result == null) result = caseIdentifyableElement(genericType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_REFERENCE: {
				TypeReference typeReference = (TypeReference)theEObject;
				T result = caseTypeReference(typeReference);
				if (result == null) result = caseIdentifyableElement(typeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.SIMPLE_TYPE_REFERENCE: {
				SimpleTypeReference simpleTypeReference = (SimpleTypeReference)theEObject;
				T result = caseSimpleTypeReference(simpleTypeReference);
				if (result == null) result = caseTypeReference(simpleTypeReference);
				if (result == null) result = caseIdentifyableElement(simpleTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE: {
				ParameterizedTypeReference parameterizedTypeReference = (ParameterizedTypeReference)theEObject;
				T result = caseParameterizedTypeReference(parameterizedTypeReference);
				if (result == null) result = caseTypeReference(parameterizedTypeReference);
				if (result == null) result = caseIdentifyableElement(parameterizedTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.GENERIC_ARRAY_TYPE_REFERENCE: {
				GenericArrayTypeReference genericArrayTypeReference = (GenericArrayTypeReference)theEObject;
				T result = caseGenericArrayTypeReference(genericArrayTypeReference);
				if (result == null) result = caseTypeReference(genericArrayTypeReference);
				if (result == null) result = caseIdentifyableElement(genericArrayTypeReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.TYPE_ARGUMENT: {
				TypeArgument typeArgument = (TypeArgument)theEObject;
				T result = caseTypeArgument(typeArgument);
				if (result == null) result = caseIdentifyableElement(typeArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.WILDCARD_TYPE_ARGUMENT: {
				WildcardTypeArgument wildcardTypeArgument = (WildcardTypeArgument)theEObject;
				T result = caseWildcardTypeArgument(wildcardTypeArgument);
				if (result == null) result = caseTypeArgument(wildcardTypeArgument);
				if (result == null) result = caseConstraintOwner(wildcardTypeArgument);
				if (result == null) result = caseIdentifyableElement(wildcardTypeArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.REFERENCE_TYPE_ARGUMENT: {
				ReferenceTypeArgument referenceTypeArgument = (ReferenceTypeArgument)theEObject;
				T result = caseReferenceTypeArgument(referenceTypeArgument);
				if (result == null) result = caseTypeArgument(referenceTypeArgument);
				if (result == null) result = caseIdentifyableElement(referenceTypeArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.MEMBER: {
				Member member = (Member)theEObject;
				T result = caseMember(member);
				if (result == null) result = caseAnnotationTarget(member);
				if (result == null) result = caseIdentifyableElement(member);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.FIELD: {
				Field field = (Field)theEObject;
				T result = caseField(field);
				if (result == null) result = caseMember(field);
				if (result == null) result = caseAnnotationTarget(field);
				if (result == null) result = caseIdentifyableElement(field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.EXECUTABLE: {
				Executable executable = (Executable)theEObject;
				T result = caseExecutable(executable);
				if (result == null) result = caseMember(executable);
				if (result == null) result = caseTypeParameterDeclarator(executable);
				if (result == null) result = caseAnnotationTarget(executable);
				if (result == null) result = caseIdentifyableElement(executable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.CONSTRUCTOR: {
				Constructor constructor = (Constructor)theEObject;
				T result = caseConstructor(constructor);
				if (result == null) result = caseExecutable(constructor);
				if (result == null) result = caseMember(constructor);
				if (result == null) result = caseTypeParameterDeclarator(constructor);
				if (result == null) result = caseAnnotationTarget(constructor);
				if (result == null) result = caseIdentifyableElement(constructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseExecutable(operation);
				if (result == null) result = caseMember(operation);
				if (result == null) result = caseTypeParameterDeclarator(operation);
				if (result == null) result = caseAnnotationTarget(operation);
				if (result == null) result = caseIdentifyableElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.FORMAL_PARAMETER: {
				FormalParameter formalParameter = (FormalParameter)theEObject;
				T result = caseFormalParameter(formalParameter);
				if (result == null) result = caseIdentifyableElement(formalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ANNOTATION_TARGET: {
				AnnotationTarget annotationTarget = (AnnotationTarget)theEObject;
				T result = caseAnnotationTarget(annotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TypesPackage.ANNOTATION_REFERENCE: {
				AnnotationReference annotationReference = (AnnotationReference)theEObject;
				T result = caseAnnotationReference(annotationReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifyable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifyable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifyableElement(IdentifyableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Void</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Void</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVoid(org.eclipse.xtext.common.types.Void object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentType(ComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayType(ArrayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declared Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declared Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaredType(DeclaredType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameter Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameter Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeParameterDeclarator(TypeParameterDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintOwner(ConstraintOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeParameter(TypeParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeConstraint(TypeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upper Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upper Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpperBound(UpperBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerBound(LowerBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationType(AnnotationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericType(GenericType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeReference(TypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleTypeReference(SimpleTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTypeReference(ParameterizedTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Array Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Array Type Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericArrayTypeReference(GenericArrayTypeReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeArgument(TypeArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard Type Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWildcardTypeArgument(WildcardTypeArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Type Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceTypeArgument(ReferenceTypeArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMember(Member object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutable(Executable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstructor(Constructor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormalParameter(FormalParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationTarget(AnnotationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationReference(AnnotationReference object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //TypesSwitch
