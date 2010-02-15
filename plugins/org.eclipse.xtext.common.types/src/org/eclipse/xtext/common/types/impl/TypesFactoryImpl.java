/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.lang.Iterable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.common.types.AnnotationReference;
import org.eclipse.xtext.common.types.AnnotationType;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.Constructor;
import org.eclipse.xtext.common.types.EnumerationType;
import org.eclipse.xtext.common.types.Field;
import org.eclipse.xtext.common.types.FormalParameter;
import org.eclipse.xtext.common.types.GenericArrayTypeReference;
import org.eclipse.xtext.common.types.GenericType;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.Operation;
import org.eclipse.xtext.common.types.ParameterizedTypeReference;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.ReferenceTypeArgument;
import org.eclipse.xtext.common.types.SimpleTypeReference;
import org.eclipse.xtext.common.types.TypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.Visibility;
import org.eclipse.xtext.common.types.WildcardTypeArgument;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init() {
		try {
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/common/JavaVMTypes"); 
			if (theTypesFactory != null) {
				return theTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TypesPackage.VOID: return createVoid();
			case TypesPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case TypesPackage.ARRAY_TYPE: return createArrayType();
			case TypesPackage.TYPE_PARAMETER: return createTypeParameter();
			case TypesPackage.UPPER_BOUND: return createUpperBound();
			case TypesPackage.LOWER_BOUND: return createLowerBound();
			case TypesPackage.ANNOTATION_TYPE: return createAnnotationType();
			case TypesPackage.ENUMERATION_TYPE: return createEnumerationType();
			case TypesPackage.GENERIC_TYPE: return createGenericType();
			case TypesPackage.SIMPLE_TYPE_REFERENCE: return createSimpleTypeReference();
			case TypesPackage.PARAMETERIZED_TYPE_REFERENCE: return createParameterizedTypeReference();
			case TypesPackage.GENERIC_ARRAY_TYPE_REFERENCE: return createGenericArrayTypeReference();
			case TypesPackage.WILDCARD_TYPE_ARGUMENT: return createWildcardTypeArgument();
			case TypesPackage.REFERENCE_TYPE_ARGUMENT: return createReferenceTypeArgument();
			case TypesPackage.FIELD: return createField();
			case TypesPackage.CONSTRUCTOR: return createConstructor();
			case TypesPackage.OPERATION: return createOperation();
			case TypesPackage.FORMAL_PARAMETER: return createFormalParameter();
			case TypesPackage.ANNOTATION_REFERENCE: return createAnnotationReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TypesPackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			case TypesPackage.ITERABLE:
				return createIterableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TypesPackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			case TypesPackage.ITERABLE:
				return convertIterableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.xtext.common.types.Void createVoid() {
		VoidImpl void_ = new VoidImpl();
		return void_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayType createArrayType() {
		ArrayTypeImpl arrayType = new ArrayTypeImpl();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeParameter createTypeParameter() {
		TypeParameterImpl typeParameter = new TypeParameterImpl();
		return typeParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpperBound createUpperBound() {
		UpperBoundImpl upperBound = new UpperBoundImpl();
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LowerBound createLowerBound() {
		LowerBoundImpl lowerBound = new LowerBoundImpl();
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationType createAnnotationType() {
		AnnotationTypeImpl annotationType = new AnnotationTypeImpl();
		return annotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationType createEnumerationType() {
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericType createGenericType() {
		GenericTypeImpl genericType = new GenericTypeImpl();
		return genericType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleTypeReference createSimpleTypeReference() {
		SimpleTypeReferenceImpl simpleTypeReference = new SimpleTypeReferenceImpl();
		return simpleTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedTypeReference createParameterizedTypeReference() {
		ParameterizedTypeReferenceImpl parameterizedTypeReference = new ParameterizedTypeReferenceImpl();
		return parameterizedTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericArrayTypeReference createGenericArrayTypeReference() {
		GenericArrayTypeReferenceImpl genericArrayTypeReference = new GenericArrayTypeReferenceImpl();
		return genericArrayTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WildcardTypeArgument createWildcardTypeArgument() {
		WildcardTypeArgumentImpl wildcardTypeArgument = new WildcardTypeArgumentImpl();
		return wildcardTypeArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceTypeArgument createReferenceTypeArgument() {
		ReferenceTypeArgumentImpl referenceTypeArgument = new ReferenceTypeArgumentImpl();
		return referenceTypeArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constructor createConstructor() {
		ConstructorImpl constructor = new ConstructorImpl();
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter createFormalParameter() {
		FormalParameterImpl formalParameter = new FormalParameterImpl();
		return formalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationReference createAnnotationReference() {
		AnnotationReferenceImpl annotationReference = new AnnotationReferenceImpl();
		return annotationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<?> createIterableFromString(EDataType eDataType, String initialValue) {
		return (Iterable<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIterableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage() {
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypesPackage getPackage() {
		return TypesPackage.eINSTANCE;
	}

} //TypesFactoryImpl
