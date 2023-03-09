/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmCompoundTypeReference;
import org.eclipse.xtext.common.types.JvmConstraintOwner;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmDelegateTypeReference;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmSynonymTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmIdentifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmVoidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmPrimitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmArrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDeclaredTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeParameterDeclaratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmConstraintOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmUpperBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmLowerBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumerationLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmGenericTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmParameterizedTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmGenericArrayTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmWildcardTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnyTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmMultiTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmExecutableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFormalParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmIntAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmBooleanAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmByteAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmShortAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmLongAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDoubleAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmFloatAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCharAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmStringAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmTypeAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmAnnotationAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmEnumAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmDelegateTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmSpecializedTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmSynonymTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmUnknownTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCompoundTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmCustomAnnotationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jvmInnerTypeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum jvmVisibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iterableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTypeReferenceVisitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTypeReferenceVisitorWithParameterEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.xtext.common.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl()
	{
		super(eNS_URI, TypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init()
	{
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTypesPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TypesPackageImpl theTypesPackage = registeredTypesPackage instanceof TypesPackageImpl ? (TypesPackageImpl)registeredTypesPackage : new TypesPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmIdentifiableElement()
	{
		return jvmIdentifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmType()
	{
		return jvmTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmVoid()
	{
		return jvmVoidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmComponentType()
	{
		return jvmComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmComponentType_ArrayType()
	{
		return (EReference)jvmComponentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmPrimitiveType()
	{
		return jvmPrimitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmPrimitiveType_SimpleName()
	{
		return (EAttribute)jvmPrimitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmArrayType()
	{
		return jvmArrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmArrayType_ComponentType()
	{
		return (EReference)jvmArrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmDeclaredType()
	{
		return jvmDeclaredTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmDeclaredType_SuperTypes()
	{
		return (EReference)jvmDeclaredTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmDeclaredType_Members()
	{
		return (EReference)jvmDeclaredTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmDeclaredType_Abstract()
	{
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmDeclaredType_Static()
	{
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmDeclaredType_Final()
	{
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmDeclaredType_PackageName()
	{
		return (EAttribute)jvmDeclaredTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmTypeParameter()
	{
		return jvmTypeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmTypeParameter_Name()
	{
		return (EAttribute)jvmTypeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmTypeParameter_Declarator()
	{
		return (EReference)jvmTypeParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmTypeParameterDeclarator()
	{
		return jvmTypeParameterDeclaratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmTypeParameterDeclarator_TypeParameters()
	{
		return (EReference)jvmTypeParameterDeclaratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmConstraintOwner()
	{
		return jvmConstraintOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmConstraintOwner_Constraints()
	{
		return (EReference)jvmConstraintOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmTypeConstraint()
	{
		return jvmTypeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmTypeConstraint_TypeReference()
	{
		return (EReference)jvmTypeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmTypeConstraint_Owner()
	{
		return (EReference)jvmTypeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmUpperBound()
	{
		return jvmUpperBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmLowerBound()
	{
		return jvmLowerBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnnotationType()
	{
		return jvmAnnotationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmEnumerationType()
	{
		return jvmEnumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmEnumerationType_Literals()
	{
		return (EReference)jvmEnumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmEnumerationLiteral()
	{
		return jvmEnumerationLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmGenericType()
	{
		return jvmGenericTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmGenericType_Interface()
	{
		return (EAttribute)jvmGenericTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmGenericType_StrictFloatingPoint()
	{
		return (EAttribute)jvmGenericTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmGenericType_Anonymous()
	{
		return (EAttribute)jvmGenericTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmTypeReference()
	{
		return jvmTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmParameterizedTypeReference()
	{
		return jvmParameterizedTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmParameterizedTypeReference_Arguments()
	{
		return (EReference)jvmParameterizedTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmParameterizedTypeReference_Type()
	{
		return (EReference)jvmParameterizedTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmGenericArrayTypeReference()
	{
		return jvmGenericArrayTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmGenericArrayTypeReference_ComponentType()
	{
		return (EReference)jvmGenericArrayTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmWildcardTypeReference()
	{
		return jvmWildcardTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnyTypeReference()
	{
		return jvmAnyTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnyTypeReference_Type()
	{
		return (EReference)jvmAnyTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmMultiTypeReference()
	{
		return jvmMultiTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmMember()
	{
		return jvmMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmMember_DeclaringType()
	{
		return (EReference)jvmMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmMember_Visibility()
	{
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmMember_SimpleName()
	{
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmMember_Identifier()
	{
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmMember_Deprecated()
	{
		return (EAttribute)jvmMemberEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmFeature()
	{
		return jvmFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmFeature_LocalClasses()
	{
		return (EReference)jvmFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmField()
	{
		return jvmFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_Static()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_Final()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmField_Type()
	{
		return (EReference)jvmFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_Volatile()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_Transient()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_Constant()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmField_ConstantValue()
	{
		return (EAttribute)jvmFieldEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmExecutable()
	{
		return jvmExecutableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmExecutable_Parameters()
	{
		return (EReference)jvmExecutableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmExecutable_Exceptions()
	{
		return (EReference)jvmExecutableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmExecutable_VarArgs()
	{
		return (EAttribute)jvmExecutableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmConstructor()
	{
		return jvmConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmOperation()
	{
		return jvmOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Static()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Final()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Abstract()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmOperation_ReturnType()
	{
		return (EReference)jvmOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmOperation_DefaultValue()
	{
		return (EReference)jvmOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Synchronized()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Default()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_Native()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmOperation_StrictFloatingPoint()
	{
		return (EAttribute)jvmOperationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmFormalParameter()
	{
		return jvmFormalParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmFormalParameter_Name()
	{
		return (EAttribute)jvmFormalParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmFormalParameter_ParameterType()
	{
		return (EReference)jvmFormalParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnnotationTarget()
	{
		return jvmAnnotationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnnotationTarget_Annotations()
	{
		return (EReference)jvmAnnotationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnnotationReference()
	{
		return jvmAnnotationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnnotationReference_Annotation()
	{
		return (EReference)jvmAnnotationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnnotationReference_ExplicitValues()
	{
		return (EReference)jvmAnnotationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnnotationValue()
	{
		return jvmAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnnotationValue_Operation()
	{
		return (EReference)jvmAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmIntAnnotationValue()
	{
		return jvmIntAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmIntAnnotationValue_Values()
	{
		return (EAttribute)jvmIntAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmBooleanAnnotationValue()
	{
		return jvmBooleanAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmBooleanAnnotationValue_Values()
	{
		return (EAttribute)jvmBooleanAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmByteAnnotationValue()
	{
		return jvmByteAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmByteAnnotationValue_Values()
	{
		return (EAttribute)jvmByteAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmShortAnnotationValue()
	{
		return jvmShortAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmShortAnnotationValue_Values()
	{
		return (EAttribute)jvmShortAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmLongAnnotationValue()
	{
		return jvmLongAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmLongAnnotationValue_Values()
	{
		return (EAttribute)jvmLongAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmDoubleAnnotationValue()
	{
		return jvmDoubleAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmDoubleAnnotationValue_Values()
	{
		return (EAttribute)jvmDoubleAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmFloatAnnotationValue()
	{
		return jvmFloatAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmFloatAnnotationValue_Values()
	{
		return (EAttribute)jvmFloatAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmCharAnnotationValue()
	{
		return jvmCharAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmCharAnnotationValue_Values()
	{
		return (EAttribute)jvmCharAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmStringAnnotationValue()
	{
		return jvmStringAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJvmStringAnnotationValue_Values()
	{
		return (EAttribute)jvmStringAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmTypeAnnotationValue()
	{
		return jvmTypeAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmTypeAnnotationValue_Values()
	{
		return (EReference)jvmTypeAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmAnnotationAnnotationValue()
	{
		return jvmAnnotationAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmAnnotationAnnotationValue_Values()
	{
		return (EReference)jvmAnnotationAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmEnumAnnotationValue()
	{
		return jvmEnumAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmEnumAnnotationValue_Values()
	{
		return (EReference)jvmEnumAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmDelegateTypeReference()
	{
		return jvmDelegateTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmDelegateTypeReference_Delegate()
	{
		return (EReference)jvmDelegateTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmSpecializedTypeReference()
	{
		return jvmSpecializedTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmSpecializedTypeReference_Equivalent()
	{
		return (EReference)jvmSpecializedTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmSynonymTypeReference()
	{
		return jvmSynonymTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmUnknownTypeReference()
	{
		return jvmUnknownTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.4
	 * @generated
	 */
	@Override
	public EAttribute getJvmUnknownTypeReference_QualifiedName()
	{
		return (EAttribute)jvmUnknownTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmCompoundTypeReference()
	{
		return jvmCompoundTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmCompoundTypeReference_Type()
	{
		return (EReference)jvmCompoundTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmCompoundTypeReference_References()
	{
		return (EReference)jvmCompoundTypeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmCustomAnnotationValue()
	{
		return jvmCustomAnnotationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmCustomAnnotationValue_Values()
	{
		return (EReference)jvmCustomAnnotationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJvmInnerTypeReference()
	{
		return jvmInnerTypeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJvmInnerTypeReference_Outer()
	{
		return (EReference)jvmInnerTypeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getJvmVisibility()
	{
		return jvmVisibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getIterable()
	{
		return iterableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getITypeReferenceVisitor()
	{
		return iTypeReferenceVisitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getITypeReferenceVisitorWithParameter()
	{
		return iTypeReferenceVisitorWithParameterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypesFactory getTypesFactory()
	{
		return (TypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		jvmIdentifiableElementEClass = createEClass(JVM_IDENTIFIABLE_ELEMENT);

		jvmTypeEClass = createEClass(JVM_TYPE);

		jvmVoidEClass = createEClass(JVM_VOID);

		jvmComponentTypeEClass = createEClass(JVM_COMPONENT_TYPE);
		createEReference(jvmComponentTypeEClass, JVM_COMPONENT_TYPE__ARRAY_TYPE);

		jvmPrimitiveTypeEClass = createEClass(JVM_PRIMITIVE_TYPE);
		createEAttribute(jvmPrimitiveTypeEClass, JVM_PRIMITIVE_TYPE__SIMPLE_NAME);

		jvmArrayTypeEClass = createEClass(JVM_ARRAY_TYPE);
		createEReference(jvmArrayTypeEClass, JVM_ARRAY_TYPE__COMPONENT_TYPE);

		jvmDeclaredTypeEClass = createEClass(JVM_DECLARED_TYPE);
		createEReference(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__SUPER_TYPES);
		createEReference(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__MEMBERS);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__ABSTRACT);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__STATIC);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__FINAL);
		createEAttribute(jvmDeclaredTypeEClass, JVM_DECLARED_TYPE__PACKAGE_NAME);

		jvmTypeParameterEClass = createEClass(JVM_TYPE_PARAMETER);
		createEAttribute(jvmTypeParameterEClass, JVM_TYPE_PARAMETER__NAME);
		createEReference(jvmTypeParameterEClass, JVM_TYPE_PARAMETER__DECLARATOR);

		jvmTypeParameterDeclaratorEClass = createEClass(JVM_TYPE_PARAMETER_DECLARATOR);
		createEReference(jvmTypeParameterDeclaratorEClass, JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS);

		jvmConstraintOwnerEClass = createEClass(JVM_CONSTRAINT_OWNER);
		createEReference(jvmConstraintOwnerEClass, JVM_CONSTRAINT_OWNER__CONSTRAINTS);

		jvmTypeConstraintEClass = createEClass(JVM_TYPE_CONSTRAINT);
		createEReference(jvmTypeConstraintEClass, JVM_TYPE_CONSTRAINT__TYPE_REFERENCE);
		createEReference(jvmTypeConstraintEClass, JVM_TYPE_CONSTRAINT__OWNER);

		jvmUpperBoundEClass = createEClass(JVM_UPPER_BOUND);

		jvmLowerBoundEClass = createEClass(JVM_LOWER_BOUND);

		jvmAnnotationTypeEClass = createEClass(JVM_ANNOTATION_TYPE);

		jvmEnumerationTypeEClass = createEClass(JVM_ENUMERATION_TYPE);
		createEReference(jvmEnumerationTypeEClass, JVM_ENUMERATION_TYPE__LITERALS);

		jvmEnumerationLiteralEClass = createEClass(JVM_ENUMERATION_LITERAL);

		jvmGenericTypeEClass = createEClass(JVM_GENERIC_TYPE);
		createEAttribute(jvmGenericTypeEClass, JVM_GENERIC_TYPE__INTERFACE);
		createEAttribute(jvmGenericTypeEClass, JVM_GENERIC_TYPE__STRICT_FLOATING_POINT);
		createEAttribute(jvmGenericTypeEClass, JVM_GENERIC_TYPE__ANONYMOUS);

		jvmTypeReferenceEClass = createEClass(JVM_TYPE_REFERENCE);

		jvmParameterizedTypeReferenceEClass = createEClass(JVM_PARAMETERIZED_TYPE_REFERENCE);
		createEReference(jvmParameterizedTypeReferenceEClass, JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS);
		createEReference(jvmParameterizedTypeReferenceEClass, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);

		jvmGenericArrayTypeReferenceEClass = createEClass(JVM_GENERIC_ARRAY_TYPE_REFERENCE);
		createEReference(jvmGenericArrayTypeReferenceEClass, JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE);

		jvmWildcardTypeReferenceEClass = createEClass(JVM_WILDCARD_TYPE_REFERENCE);

		jvmAnyTypeReferenceEClass = createEClass(JVM_ANY_TYPE_REFERENCE);
		createEReference(jvmAnyTypeReferenceEClass, JVM_ANY_TYPE_REFERENCE__TYPE);

		jvmMultiTypeReferenceEClass = createEClass(JVM_MULTI_TYPE_REFERENCE);

		jvmMemberEClass = createEClass(JVM_MEMBER);
		createEReference(jvmMemberEClass, JVM_MEMBER__DECLARING_TYPE);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__VISIBILITY);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__SIMPLE_NAME);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__IDENTIFIER);
		createEAttribute(jvmMemberEClass, JVM_MEMBER__DEPRECATED);

		jvmFeatureEClass = createEClass(JVM_FEATURE);
		createEReference(jvmFeatureEClass, JVM_FEATURE__LOCAL_CLASSES);

		jvmFieldEClass = createEClass(JVM_FIELD);
		createEAttribute(jvmFieldEClass, JVM_FIELD__STATIC);
		createEAttribute(jvmFieldEClass, JVM_FIELD__FINAL);
		createEReference(jvmFieldEClass, JVM_FIELD__TYPE);
		createEAttribute(jvmFieldEClass, JVM_FIELD__VOLATILE);
		createEAttribute(jvmFieldEClass, JVM_FIELD__TRANSIENT);
		createEAttribute(jvmFieldEClass, JVM_FIELD__CONSTANT);
		createEAttribute(jvmFieldEClass, JVM_FIELD__CONSTANT_VALUE);

		jvmExecutableEClass = createEClass(JVM_EXECUTABLE);
		createEReference(jvmExecutableEClass, JVM_EXECUTABLE__PARAMETERS);
		createEReference(jvmExecutableEClass, JVM_EXECUTABLE__EXCEPTIONS);
		createEAttribute(jvmExecutableEClass, JVM_EXECUTABLE__VAR_ARGS);

		jvmConstructorEClass = createEClass(JVM_CONSTRUCTOR);

		jvmOperationEClass = createEClass(JVM_OPERATION);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__STATIC);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__FINAL);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__ABSTRACT);
		createEReference(jvmOperationEClass, JVM_OPERATION__RETURN_TYPE);
		createEReference(jvmOperationEClass, JVM_OPERATION__DEFAULT_VALUE);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__SYNCHRONIZED);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__DEFAULT);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__NATIVE);
		createEAttribute(jvmOperationEClass, JVM_OPERATION__STRICT_FLOATING_POINT);

		jvmFormalParameterEClass = createEClass(JVM_FORMAL_PARAMETER);
		createEAttribute(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__NAME);
		createEReference(jvmFormalParameterEClass, JVM_FORMAL_PARAMETER__PARAMETER_TYPE);

		jvmAnnotationTargetEClass = createEClass(JVM_ANNOTATION_TARGET);
		createEReference(jvmAnnotationTargetEClass, JVM_ANNOTATION_TARGET__ANNOTATIONS);

		jvmAnnotationReferenceEClass = createEClass(JVM_ANNOTATION_REFERENCE);
		createEReference(jvmAnnotationReferenceEClass, JVM_ANNOTATION_REFERENCE__ANNOTATION);
		createEReference(jvmAnnotationReferenceEClass, JVM_ANNOTATION_REFERENCE__EXPLICIT_VALUES);

		jvmAnnotationValueEClass = createEClass(JVM_ANNOTATION_VALUE);
		createEReference(jvmAnnotationValueEClass, JVM_ANNOTATION_VALUE__OPERATION);

		jvmIntAnnotationValueEClass = createEClass(JVM_INT_ANNOTATION_VALUE);
		createEAttribute(jvmIntAnnotationValueEClass, JVM_INT_ANNOTATION_VALUE__VALUES);

		jvmBooleanAnnotationValueEClass = createEClass(JVM_BOOLEAN_ANNOTATION_VALUE);
		createEAttribute(jvmBooleanAnnotationValueEClass, JVM_BOOLEAN_ANNOTATION_VALUE__VALUES);

		jvmByteAnnotationValueEClass = createEClass(JVM_BYTE_ANNOTATION_VALUE);
		createEAttribute(jvmByteAnnotationValueEClass, JVM_BYTE_ANNOTATION_VALUE__VALUES);

		jvmShortAnnotationValueEClass = createEClass(JVM_SHORT_ANNOTATION_VALUE);
		createEAttribute(jvmShortAnnotationValueEClass, JVM_SHORT_ANNOTATION_VALUE__VALUES);

		jvmLongAnnotationValueEClass = createEClass(JVM_LONG_ANNOTATION_VALUE);
		createEAttribute(jvmLongAnnotationValueEClass, JVM_LONG_ANNOTATION_VALUE__VALUES);

		jvmDoubleAnnotationValueEClass = createEClass(JVM_DOUBLE_ANNOTATION_VALUE);
		createEAttribute(jvmDoubleAnnotationValueEClass, JVM_DOUBLE_ANNOTATION_VALUE__VALUES);

		jvmFloatAnnotationValueEClass = createEClass(JVM_FLOAT_ANNOTATION_VALUE);
		createEAttribute(jvmFloatAnnotationValueEClass, JVM_FLOAT_ANNOTATION_VALUE__VALUES);

		jvmCharAnnotationValueEClass = createEClass(JVM_CHAR_ANNOTATION_VALUE);
		createEAttribute(jvmCharAnnotationValueEClass, JVM_CHAR_ANNOTATION_VALUE__VALUES);

		jvmStringAnnotationValueEClass = createEClass(JVM_STRING_ANNOTATION_VALUE);
		createEAttribute(jvmStringAnnotationValueEClass, JVM_STRING_ANNOTATION_VALUE__VALUES);

		jvmTypeAnnotationValueEClass = createEClass(JVM_TYPE_ANNOTATION_VALUE);
		createEReference(jvmTypeAnnotationValueEClass, JVM_TYPE_ANNOTATION_VALUE__VALUES);

		jvmAnnotationAnnotationValueEClass = createEClass(JVM_ANNOTATION_ANNOTATION_VALUE);
		createEReference(jvmAnnotationAnnotationValueEClass, JVM_ANNOTATION_ANNOTATION_VALUE__VALUES);

		jvmEnumAnnotationValueEClass = createEClass(JVM_ENUM_ANNOTATION_VALUE);
		createEReference(jvmEnumAnnotationValueEClass, JVM_ENUM_ANNOTATION_VALUE__VALUES);

		jvmDelegateTypeReferenceEClass = createEClass(JVM_DELEGATE_TYPE_REFERENCE);
		createEReference(jvmDelegateTypeReferenceEClass, JVM_DELEGATE_TYPE_REFERENCE__DELEGATE);

		jvmSpecializedTypeReferenceEClass = createEClass(JVM_SPECIALIZED_TYPE_REFERENCE);
		createEReference(jvmSpecializedTypeReferenceEClass, JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT);

		jvmSynonymTypeReferenceEClass = createEClass(JVM_SYNONYM_TYPE_REFERENCE);

		jvmUnknownTypeReferenceEClass = createEClass(JVM_UNKNOWN_TYPE_REFERENCE);
		createEAttribute(jvmUnknownTypeReferenceEClass, JVM_UNKNOWN_TYPE_REFERENCE__QUALIFIED_NAME);

		jvmCompoundTypeReferenceEClass = createEClass(JVM_COMPOUND_TYPE_REFERENCE);
		createEReference(jvmCompoundTypeReferenceEClass, JVM_COMPOUND_TYPE_REFERENCE__TYPE);
		createEReference(jvmCompoundTypeReferenceEClass, JVM_COMPOUND_TYPE_REFERENCE__REFERENCES);

		jvmCustomAnnotationValueEClass = createEClass(JVM_CUSTOM_ANNOTATION_VALUE);
		createEReference(jvmCustomAnnotationValueEClass, JVM_CUSTOM_ANNOTATION_VALUE__VALUES);

		jvmInnerTypeReferenceEClass = createEClass(JVM_INNER_TYPE_REFERENCE);
		createEReference(jvmInnerTypeReferenceEClass, JVM_INNER_TYPE_REFERENCE__OUTER);

		// Create enums
		jvmVisibilityEEnum = createEEnum(JVM_VISIBILITY);

		// Create data types
		iterableEDataType = createEDataType(ITERABLE);
		iTypeReferenceVisitorEDataType = createEDataType(ITYPE_REFERENCE_VISITOR);
		iTypeReferenceVisitorWithParameterEDataType = createEDataType(ITYPE_REFERENCE_VISITOR_WITH_PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		addETypeParameter(iterableEDataType, "E");
		addETypeParameter(iTypeReferenceVisitorEDataType, "Result");
		addETypeParameter(iTypeReferenceVisitorWithParameterEDataType, "Parameter");
		addETypeParameter(iTypeReferenceVisitorWithParameterEDataType, "Result");

		// Set bounds for type parameters

		// Add supertypes to classes
		jvmTypeEClass.getESuperTypes().add(this.getJvmIdentifiableElement());
		jvmVoidEClass.getESuperTypes().add(this.getJvmType());
		jvmComponentTypeEClass.getESuperTypes().add(this.getJvmType());
		jvmPrimitiveTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmArrayTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmDeclaredTypeEClass.getESuperTypes().add(this.getJvmMember());
		jvmDeclaredTypeEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmTypeParameterEClass.getESuperTypes().add(this.getJvmComponentType());
		jvmTypeParameterEClass.getESuperTypes().add(this.getJvmConstraintOwner());
		jvmUpperBoundEClass.getESuperTypes().add(this.getJvmTypeConstraint());
		jvmLowerBoundEClass.getESuperTypes().add(this.getJvmTypeConstraint());
		jvmAnnotationTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmEnumerationTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmEnumerationLiteralEClass.getESuperTypes().add(this.getJvmField());
		jvmGenericTypeEClass.getESuperTypes().add(this.getJvmDeclaredType());
		jvmGenericTypeEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmParameterizedTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmGenericArrayTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmWildcardTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmWildcardTypeReferenceEClass.getESuperTypes().add(this.getJvmConstraintOwner());
		jvmAnyTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmMultiTypeReferenceEClass.getESuperTypes().add(this.getJvmCompoundTypeReference());
		jvmMemberEClass.getESuperTypes().add(this.getJvmAnnotationTarget());
		jvmFeatureEClass.getESuperTypes().add(this.getJvmMember());
		jvmFieldEClass.getESuperTypes().add(this.getJvmFeature());
		jvmExecutableEClass.getESuperTypes().add(this.getJvmFeature());
		jvmExecutableEClass.getESuperTypes().add(this.getJvmTypeParameterDeclarator());
		jvmConstructorEClass.getESuperTypes().add(this.getJvmExecutable());
		jvmOperationEClass.getESuperTypes().add(this.getJvmExecutable());
		jvmFormalParameterEClass.getESuperTypes().add(this.getJvmAnnotationTarget());
		jvmAnnotationTargetEClass.getESuperTypes().add(this.getJvmIdentifiableElement());
		jvmIntAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmBooleanAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmByteAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmShortAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmLongAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmDoubleAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmFloatAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmCharAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmStringAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmTypeAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmAnnotationAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmEnumAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmDelegateTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmSpecializedTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmSynonymTypeReferenceEClass.getESuperTypes().add(this.getJvmCompoundTypeReference());
		jvmUnknownTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmCompoundTypeReferenceEClass.getESuperTypes().add(this.getJvmTypeReference());
		jvmCustomAnnotationValueEClass.getESuperTypes().add(this.getJvmAnnotationValue());
		jvmInnerTypeReferenceEClass.getESuperTypes().add(this.getJvmParameterizedTypeReference());

		// Initialize classes and features; add operations and parameters
		initEClass(jvmIdentifiableElementEClass, JvmIdentifiableElement.class, "JvmIdentifiableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(jvmIdentifiableElementEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmTypeEClass, JvmType.class, "JvmType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmVoidEClass, JvmVoid.class, "JvmVoid", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmComponentTypeEClass, JvmComponentType.class, "JvmComponentType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmComponentType_ArrayType(), this.getJvmArrayType(), this.getJvmArrayType_ComponentType(), "arrayType", null, 0, 1, JvmComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmPrimitiveTypeEClass, JvmPrimitiveType.class, "JvmPrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmPrimitiveType_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmArrayTypeEClass, JvmArrayType.class, "JvmArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmArrayType_ComponentType(), this.getJvmComponentType(), this.getJvmComponentType_ArrayType(), "componentType", null, 0, 1, JvmArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmArrayTypeEClass, ecorePackage.getEInt(), "getDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmDeclaredTypeEClass, JvmDeclaredType.class, "JvmDeclaredType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmDeclaredType_SuperTypes(), this.getJvmTypeReference(), null, "superTypes", null, 0, -1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmDeclaredType_Members(), this.getJvmMember(), this.getJvmMember_DeclaringType(), "members", null, 0, -1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmDeclaredType_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, JvmDeclaredType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getDeclaredOperations", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getIterable());
		EGenericType g2 = createEGenericType(this.getJvmOperation());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getDeclaredFields", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmField());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "findAllFeaturesByName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "simpleName", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmFeature());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getAllFeatures", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmFeature());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getExtendedInterfaces", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmTypeReference());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		addEOperation(jvmDeclaredTypeEClass, this.getJvmTypeReference(), "getExtendedClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmDeclaredTypeEClass, ecorePackage.getEBoolean(), "isInstantiateable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmDeclaredTypeEClass, null, "findAllNestedTypesByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "simpleName", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmDeclaredType());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		addEOperation(jvmDeclaredTypeEClass, ecorePackage.getEBoolean(), "isLocal", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getDeclaredConstructors", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmConstructor());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(jvmDeclaredTypeEClass, null, "getAllNestedTypes", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getJvmDeclaredType());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(jvmTypeParameterEClass, JvmTypeParameter.class, "JvmTypeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmTypeParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, JvmTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmTypeParameter_Declarator(), this.getJvmTypeParameterDeclarator(), this.getJvmTypeParameterDeclarator_TypeParameters(), "declarator", null, 0, 1, JvmTypeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeParameterDeclaratorEClass, JvmTypeParameterDeclarator.class, "JvmTypeParameterDeclarator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeParameterDeclarator_TypeParameters(), this.getJvmTypeParameter(), this.getJvmTypeParameter_Declarator(), "typeParameters", null, 0, -1, JvmTypeParameterDeclarator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmConstraintOwnerEClass, JvmConstraintOwner.class, "JvmConstraintOwner", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmConstraintOwner_Constraints(), this.getJvmTypeConstraint(), this.getJvmTypeConstraint_Owner(), "constraints", null, 0, -1, JvmConstraintOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeConstraintEClass, JvmTypeConstraint.class, "JvmTypeConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeConstraint_TypeReference(), this.getJvmTypeReference(), null, "typeReference", null, 0, 1, JvmTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmTypeConstraint_Owner(), this.getJvmConstraintOwner(), this.getJvmConstraintOwner_Constraints(), "owner", null, 0, 1, JvmTypeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeConstraintEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmUpperBoundEClass, JvmUpperBound.class, "JvmUpperBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmLowerBoundEClass, JvmLowerBound.class, "JvmLowerBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmAnnotationTypeEClass, JvmAnnotationType.class, "JvmAnnotationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmEnumerationTypeEClass, JvmEnumerationType.class, "JvmEnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmEnumerationType_Literals(), this.getJvmEnumerationLiteral(), null, "literals", null, 0, -1, JvmEnumerationType.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(jvmEnumerationLiteralEClass, JvmEnumerationLiteral.class, "JvmEnumerationLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmEnumerationLiteralEClass, this.getJvmEnumerationType(), "getEnumType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmGenericTypeEClass, JvmGenericType.class, "JvmGenericType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmGenericType_Interface(), ecorePackage.getEBoolean(), "interface", null, 0, 1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmGenericType_StrictFloatingPoint(), ecorePackage.getEBoolean(), "strictFloatingPoint", null, 0, 1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmGenericType_Anonymous(), ecorePackage.getEBoolean(), "anonymous", null, 0, 1, JvmGenericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeReferenceEClass, JvmTypeReference.class, "JvmTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(jvmTypeReferenceEClass, this.getJvmType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeReferenceEClass, ecorePackage.getEString(), "getQualifiedName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEChar(), "innerClassDelimiter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(jvmTypeReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "Result");
		g1 = createEGenericType(this.getITypeReferenceVisitor());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = addEOperation(jvmTypeReferenceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "Parameter");
		ETypeParameter t2 = addETypeParameter(op, "Result");
		g1 = createEGenericType(this.getITypeReferenceVisitorWithParameter());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "parameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t2);
		initEOperation(op, g1);

		initEClass(jvmParameterizedTypeReferenceEClass, JvmParameterizedTypeReference.class, "JvmParameterizedTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmParameterizedTypeReference_Arguments(), this.getJvmTypeReference(), null, "arguments", null, 0, -1, JvmParameterizedTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmParameterizedTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmParameterizedTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmGenericArrayTypeReferenceEClass, JvmGenericArrayTypeReference.class, "JvmGenericArrayTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmGenericArrayTypeReference_ComponentType(), this.getJvmTypeReference(), null, "componentType", null, 0, 1, JvmGenericArrayTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmGenericArrayTypeReferenceEClass, ecorePackage.getEInt(), "getDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmGenericArrayTypeReferenceEClass, this.getJvmArrayType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmWildcardTypeReferenceEClass, JvmWildcardTypeReference.class, "JvmWildcardTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmAnyTypeReferenceEClass, JvmAnyTypeReference.class, "JvmAnyTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnyTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmAnyTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmMultiTypeReferenceEClass, JvmMultiTypeReference.class, "JvmMultiTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmMemberEClass, JvmMember.class, "JvmMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmMember_DeclaringType(), this.getJvmDeclaredType(), this.getJvmDeclaredType_Members(), "declaringType", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Visibility(), this.getJvmVisibility(), "visibility", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_SimpleName(), ecorePackage.getEString(), "simpleName", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, JvmMember.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmMember_Deprecated(), ecorePackage.getEBoolean(), "deprecated", null, 0, 1, JvmMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(jvmMemberEClass, null, "internalSetIdentifier", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "identifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmFeatureEClass, JvmFeature.class, "JvmFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmFeature_LocalClasses(), this.getJvmGenericType(), null, "localClasses", null, 0, -1, JvmFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmFeatureEClass, ecorePackage.getEBoolean(), "isStatic", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmFieldEClass, JvmField.class, "JvmField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmField_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmField_Type(), this.getJvmTypeReference(), null, "type", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Volatile(), ecorePackage.getEBoolean(), "volatile", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Transient(), ecorePackage.getEBoolean(), "transient", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_Constant(), ecorePackage.getEBoolean(), "constant", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmField_ConstantValue(), ecorePackage.getEJavaObject(), "constantValue", null, 0, 1, JvmField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getELong(), "getConstantValueAsLong", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEInt(), "getConstantValueAsInt", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEShort(), "getConstantValueAsShort", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEByte(), "getConstantValueAsByte", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEDouble(), "getConstantValueAsDouble", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEFloat(), "getConstantValueAsFloat", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEChar(), "getConstantValueAsChar", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEBoolean(), "getConstantValueAsBoolean", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(jvmFieldEClass, ecorePackage.getEString(), "getConstantValueAsString", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmExecutableEClass, JvmExecutable.class, "JvmExecutable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmExecutable_Parameters(), this.getJvmFormalParameter(), null, "parameters", null, 0, -1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmExecutable_Exceptions(), this.getJvmTypeReference(), null, "exceptions", null, 0, -1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmExecutable_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, JvmExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmConstructorEClass, JvmConstructor.class, "JvmConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmOperationEClass, JvmOperation.class, "JvmOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmOperation_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmOperation_ReturnType(), this.getJvmTypeReference(), null, "returnType", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmOperation_DefaultValue(), this.getJvmAnnotationValue(), null, "defaultValue", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Synchronized(), ecorePackage.getEBoolean(), "synchronized", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJvmOperation_StrictFloatingPoint(), ecorePackage.getEBoolean(), "strictFloatingPoint", null, 0, 1, JvmOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmFormalParameterEClass, JvmFormalParameter.class, "JvmFormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmFormalParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmFormalParameter_ParameterType(), this.getJvmTypeReference(), null, "parameterType", null, 0, 1, JvmFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationTargetEClass, JvmAnnotationTarget.class, "JvmAnnotationTarget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationTarget_Annotations(), this.getJvmAnnotationReference(), null, "annotations", null, 0, -1, JvmAnnotationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationReferenceEClass, JvmAnnotationReference.class, "JvmAnnotationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationReference_Annotation(), this.getJvmAnnotationType(), null, "annotation", null, 0, 1, JvmAnnotationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmAnnotationReference_ExplicitValues(), this.getJvmAnnotationValue(), null, "explicitValues", null, 0, -1, JvmAnnotationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmAnnotationReferenceEClass, this.getJvmAnnotationValue(), "getValues", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmAnnotationValueEClass, JvmAnnotationValue.class, "JvmAnnotationValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationValue_Operation(), this.getJvmOperation(), null, "operation", null, 0, 1, JvmAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jvmAnnotationValueEClass, ecorePackage.getEString(), "getValueName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jvmIntAnnotationValueEClass, JvmIntAnnotationValue.class, "JvmIntAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmIntAnnotationValue_Values(), ecorePackage.getEInt(), "values", null, 0, -1, JvmIntAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmBooleanAnnotationValueEClass, JvmBooleanAnnotationValue.class, "JvmBooleanAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmBooleanAnnotationValue_Values(), ecorePackage.getEBoolean(), "values", null, 0, -1, JvmBooleanAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmByteAnnotationValueEClass, JvmByteAnnotationValue.class, "JvmByteAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmByteAnnotationValue_Values(), ecorePackage.getEByte(), "values", null, 0, -1, JvmByteAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmShortAnnotationValueEClass, JvmShortAnnotationValue.class, "JvmShortAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmShortAnnotationValue_Values(), ecorePackage.getEShort(), "values", null, 0, -1, JvmShortAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmLongAnnotationValueEClass, JvmLongAnnotationValue.class, "JvmLongAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmLongAnnotationValue_Values(), ecorePackage.getELong(), "values", null, 0, -1, JvmLongAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmDoubleAnnotationValueEClass, JvmDoubleAnnotationValue.class, "JvmDoubleAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmDoubleAnnotationValue_Values(), ecorePackage.getEDouble(), "values", null, 0, -1, JvmDoubleAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmFloatAnnotationValueEClass, JvmFloatAnnotationValue.class, "JvmFloatAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmFloatAnnotationValue_Values(), ecorePackage.getEFloat(), "values", null, 0, -1, JvmFloatAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCharAnnotationValueEClass, JvmCharAnnotationValue.class, "JvmCharAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmCharAnnotationValue_Values(), ecorePackage.getEChar(), "values", null, 0, -1, JvmCharAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmStringAnnotationValueEClass, JvmStringAnnotationValue.class, "JvmStringAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmStringAnnotationValue_Values(), ecorePackage.getEString(), "values", null, 0, -1, JvmStringAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmTypeAnnotationValueEClass, JvmTypeAnnotationValue.class, "JvmTypeAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmTypeAnnotationValue_Values(), this.getJvmTypeReference(), null, "values", null, 0, -1, JvmTypeAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmAnnotationAnnotationValueEClass, JvmAnnotationAnnotationValue.class, "JvmAnnotationAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmAnnotationAnnotationValue_Values(), this.getJvmAnnotationReference(), null, "values", null, 0, -1, JvmAnnotationAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmEnumAnnotationValueEClass, JvmEnumAnnotationValue.class, "JvmEnumAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmEnumAnnotationValue_Values(), this.getJvmEnumerationLiteral(), null, "values", null, 0, -1, JvmEnumAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmDelegateTypeReferenceEClass, JvmDelegateTypeReference.class, "JvmDelegateTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmDelegateTypeReference_Delegate(), this.getJvmTypeReference(), null, "delegate", null, 0, 1, JvmDelegateTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmSpecializedTypeReferenceEClass, JvmSpecializedTypeReference.class, "JvmSpecializedTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmSpecializedTypeReference_Equivalent(), this.getJvmTypeReference(), null, "equivalent", null, 0, 1, JvmSpecializedTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmSynonymTypeReferenceEClass, JvmSynonymTypeReference.class, "JvmSynonymTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jvmUnknownTypeReferenceEClass, JvmUnknownTypeReference.class, "JvmUnknownTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJvmUnknownTypeReference_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, JvmUnknownTypeReference.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCompoundTypeReferenceEClass, JvmCompoundTypeReference.class, "JvmCompoundTypeReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmCompoundTypeReference_Type(), this.getJvmType(), null, "type", null, 0, 1, JvmCompoundTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJvmCompoundTypeReference_References(), this.getJvmTypeReference(), null, "references", null, 0, -1, JvmCompoundTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmCustomAnnotationValueEClass, JvmCustomAnnotationValue.class, "JvmCustomAnnotationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmCustomAnnotationValue_Values(), ecorePackage.getEObject(), null, "values", null, 0, -1, JvmCustomAnnotationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jvmInnerTypeReferenceEClass, JvmInnerTypeReference.class, "JvmInnerTypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJvmInnerTypeReference_Outer(), this.getJvmParameterizedTypeReference(), null, "outer", null, 0, 1, JvmInnerTypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(jvmVisibilityEEnum, JvmVisibility.class, "JvmVisibility");
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.DEFAULT);
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.PRIVATE);
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.PROTECTED);
		addEEnumLiteral(jvmVisibilityEEnum, JvmVisibility.PUBLIC);

		// Initialize data types
		initEDataType(iterableEDataType, Iterable.class, "Iterable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iTypeReferenceVisitorEDataType, ITypeReferenceVisitor.class, "ITypeReferenceVisitor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iTypeReferenceVisitorWithParameterEDataType, ITypeReferenceVisitorWithParameter.class, "ITypeReferenceVisitorWithParameter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (jvmIdentifiableElementEClass.getEOperations().get(0),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The identifier of a JvmIdentifiableElement is a canonical representation of the element.</p>\n<p>A type will return its fully qualified name as its identifier with a \'$\' delimiter for inner classes. \nThe identifier of an executables contains the identifiers of their respective parameter types. They do\nnot contain any information about type parameters.</p>\n<p>Examples for identifiers are:</p>\n<ul>\n<li>java.lang.String for a class</li>\n<li>java.util.Map$Entry for an inner class</li>\n<li>java.lang.String.String() for a constructor (note the repeated simple name)</li>\n<li>java.lang.String.charAt(int) for a method</li>\n<li>java.lang.String.offset for a field</li>\n<li>java.lang.Object[][] for an array type</li>\n</ul>"
		   });
		addAnnotation
		  (jvmIdentifiableElementEClass.getEOperations().get(1),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The simple name of a JvmIdentifiableElement is short representation of the element.</p>\n<p>The simple name does not contain any information about type parameters.</p>\n<p>Examples for simple names are:</p>\n<ul>\n<li>String for class java.lang.String</li>\n<li>Entry for class java.util.Map$Entry</li>\n<li>charAt for method java.lang.String.charAt(int)</li>\n<li>String for constructor java.lang.String.String(java.lang.String)</li>\n</ul>"
		   });
		addAnnotation
		  (jvmIdentifiableElementEClass.getEOperations().get(2),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The qualified name of a JvmIdentifiableElement is a textual representation of the element.</p>\n<p>The default delimiter character is the \'$\'.</p>\n@see #getQualifiedName(char)"
		   });
		addAnnotation
		  (jvmIdentifiableElementEClass.getEOperations().get(3),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The qualified name of a JvmIdentifiableElement is a textual representation of the element.</p>\n<p>The name does not contain any information about type parameters. Inner classes are delimited by means of \nthe given \'innerClassDelimiter\'</p>\n<p>Examples for qualified names with a \'$\' delimiter are:</p>\n<ul>\n<li>java.lang.String for class java.lang.String</li>\n<li>java.util.Map$Entry for class java.util.Map$Entry</li>\n<li>java.lang.String.charAt for method java.lang.String.charAt(int)</li>\n<li>java.lang.String.offset for field java.lang.String.offset</li>\n<li>java.lang.String for a constructor that is identified by java.lang.String.String(java.lang.String)</li>\n</ul>"
		   });
		addAnnotation
		  (jvmDeclaredTypeEClass.getEOperations().get(2),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns all the fields and operations with the given simple name.</p>\n<p>Inherited features will be returend, but overridden features are not contained in the result.</p>"
		   });
		addAnnotation
		  (jvmDeclaredTypeEClass.getEOperations().get(3),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns all the fields and operations of this type.</p>\n<p>Inherited features are included, but overridden features will not be returned.</p>"
		   });
		addAnnotation
		  (jvmDeclaredTypeEClass.getEOperations().get(7),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns all the nested types with the given simple name.</p>\n<p>Inherited types will be returned, too.</p>"
		   });
		addAnnotation
		  (jvmDeclaredTypeEClass.getEOperations().get(10),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns all the nested types of this type.</p>\n<p>Inherited types will also be returned.</p>"
		   });
		addAnnotation
		  (jvmTypeConstraintEClass.getEOperations().get(0),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The identifier of a JvmTypeConstraint is a canonical representation of the constraint information.</p>\n<p>Examples for constraint identifiers are:</p>\n<ul>\n<li>extends java.util.List&lt;java.lang.Map$Entry&lt;java.lang.Object,java.lang.Object&gt;&gt;</li>\n<li>super java.lang.Object</li>\n</ul>"
		   });
		addAnnotation
		  (jvmTypeReferenceEClass.getEOperations().get(1),
		   source,
		   new String[]
		   {
			   "documentation", "<p>The identifier of a JvmTypeReference is a canonical representation of the referenced type \nincluding its type arguments.</p>\n<p>The types fully qualified name is used (\'$\' is the delimiter for inner types).</p>\n<p>Examples for reference identifiers are:</p>\n<ul>\n<li>java.lang.String for a reference to an object type</li>\n<li>java.util.Map$Entry&lt;java.lang.Object,java.lang.Integer&gt; for a parameterized type</li>\n<li>java.util.List&lt;? extends java.lang.String&gt;[] for a generic array type</li>\n</ul>"
		   });
		addAnnotation
		  (jvmFeatureEClass.getEOperations().get(0),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns <code>true</code> if the feature is a static field or static operation.</p>\n\n@since 2.4"
		   });
		addAnnotation
		  (getJvmOperation_DefaultValue(),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns the default value for the annotation member represented by this JvmOperation instance.</p>\n<p>Returns null if no default is associated with the member, or if the operation does not represent a declared member of an annotation type.</p>"
		   });
		addAnnotation
		  (jvmAnnotationReferenceEClass.getEOperations().get(0),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns all annotation values. That is, default values are included if not explicitly given.</p>"
		   });
		addAnnotation
		  (getJvmAnnotationReference_ExplicitValues(),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns the explicit annotation values. That is, default values are not expected to be contained in that list.</p>\n<p>Important note: Some implementations don\'t have enough information about default values on annotations.\nThey may choose to consider all available values as explicit values.</p>"
		   });
		addAnnotation
		  (jvmAnnotationValueEClass,
		   source,
		   new String[]
		   {
			   "documentation", "<p>Represents the value of an annotation member.</p>\n<p>That is, either the default value of an operation as a member of an annotation type, or the \nconcrete value in an annotation reference is returned.</p>"
		   });
		addAnnotation
		  (getJvmUnknownTypeReference_QualifiedName(),
		   source,
		   new String[]
		   {
			   "documentation", "<p>Returns the known qualified name of the otherwise unresolveable type. May be <code>null</code>.</p>\n\n@since 2.4"
		   });
	}

} //TypesPackageImpl
