/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.common.types.TypesPackage
 * @generated
 */
public class TypesAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TypesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = TypesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypesSwitch<Adapter> modelSwitch =
		new TypesSwitch<Adapter>()
		{
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object)
			{
				return createJvmIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseJvmType(JvmType object)
			{
				return createJvmTypeAdapter();
			}
			@Override
			public Adapter caseJvmVoid(JvmVoid object)
			{
				return createJvmVoidAdapter();
			}
			@Override
			public Adapter caseJvmComponentType(JvmComponentType object)
			{
				return createJvmComponentTypeAdapter();
			}
			@Override
			public Adapter caseJvmPrimitiveType(JvmPrimitiveType object)
			{
				return createJvmPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseJvmArrayType(JvmArrayType object)
			{
				return createJvmArrayTypeAdapter();
			}
			@Override
			public Adapter caseJvmDeclaredType(JvmDeclaredType object)
			{
				return createJvmDeclaredTypeAdapter();
			}
			@Override
			public Adapter caseJvmTypeParameter(JvmTypeParameter object)
			{
				return createJvmTypeParameterAdapter();
			}
			@Override
			public Adapter caseJvmTypeParameterDeclarator(JvmTypeParameterDeclarator object)
			{
				return createJvmTypeParameterDeclaratorAdapter();
			}
			@Override
			public Adapter caseJvmConstraintOwner(JvmConstraintOwner object)
			{
				return createJvmConstraintOwnerAdapter();
			}
			@Override
			public Adapter caseJvmTypeConstraint(JvmTypeConstraint object)
			{
				return createJvmTypeConstraintAdapter();
			}
			@Override
			public Adapter caseJvmUpperBound(JvmUpperBound object)
			{
				return createJvmUpperBoundAdapter();
			}
			@Override
			public Adapter caseJvmLowerBound(JvmLowerBound object)
			{
				return createJvmLowerBoundAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationType(JvmAnnotationType object)
			{
				return createJvmAnnotationTypeAdapter();
			}
			@Override
			public Adapter caseJvmEnumerationType(JvmEnumerationType object)
			{
				return createJvmEnumerationTypeAdapter();
			}
			@Override
			public Adapter caseJvmEnumerationLiteral(JvmEnumerationLiteral object)
			{
				return createJvmEnumerationLiteralAdapter();
			}
			@Override
			public Adapter caseJvmGenericType(JvmGenericType object)
			{
				return createJvmGenericTypeAdapter();
			}
			@Override
			public Adapter caseJvmTypeReference(JvmTypeReference object)
			{
				return createJvmTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmParameterizedTypeReference(JvmParameterizedTypeReference object)
			{
				return createJvmParameterizedTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmGenericArrayTypeReference(JvmGenericArrayTypeReference object)
			{
				return createJvmGenericArrayTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmWildcardTypeReference(JvmWildcardTypeReference object)
			{
				return createJvmWildcardTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmAnyTypeReference(JvmAnyTypeReference object)
			{
				return createJvmAnyTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmMultiTypeReference(JvmMultiTypeReference object)
			{
				return createJvmMultiTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmMember(JvmMember object)
			{
				return createJvmMemberAdapter();
			}
			@Override
			public Adapter caseJvmFeature(JvmFeature object)
			{
				return createJvmFeatureAdapter();
			}
			@Override
			public Adapter caseJvmField(JvmField object)
			{
				return createJvmFieldAdapter();
			}
			@Override
			public Adapter caseJvmExecutable(JvmExecutable object)
			{
				return createJvmExecutableAdapter();
			}
			@Override
			public Adapter caseJvmConstructor(JvmConstructor object)
			{
				return createJvmConstructorAdapter();
			}
			@Override
			public Adapter caseJvmOperation(JvmOperation object)
			{
				return createJvmOperationAdapter();
			}
			@Override
			public Adapter caseJvmFormalParameter(JvmFormalParameter object)
			{
				return createJvmFormalParameterAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object)
			{
				return createJvmAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationReference(JvmAnnotationReference object)
			{
				return createJvmAnnotationReferenceAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationValue(JvmAnnotationValue object)
			{
				return createJvmAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmIntAnnotationValue(JvmIntAnnotationValue object)
			{
				return createJvmIntAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmBooleanAnnotationValue(JvmBooleanAnnotationValue object)
			{
				return createJvmBooleanAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmByteAnnotationValue(JvmByteAnnotationValue object)
			{
				return createJvmByteAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmShortAnnotationValue(JvmShortAnnotationValue object)
			{
				return createJvmShortAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmLongAnnotationValue(JvmLongAnnotationValue object)
			{
				return createJvmLongAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmDoubleAnnotationValue(JvmDoubleAnnotationValue object)
			{
				return createJvmDoubleAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmFloatAnnotationValue(JvmFloatAnnotationValue object)
			{
				return createJvmFloatAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmCharAnnotationValue(JvmCharAnnotationValue object)
			{
				return createJvmCharAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmStringAnnotationValue(JvmStringAnnotationValue object)
			{
				return createJvmStringAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmTypeAnnotationValue(JvmTypeAnnotationValue object)
			{
				return createJvmTypeAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationAnnotationValue(JvmAnnotationAnnotationValue object)
			{
				return createJvmAnnotationAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmEnumAnnotationValue(JvmEnumAnnotationValue object)
			{
				return createJvmEnumAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmDelegateTypeReference(JvmDelegateTypeReference object)
			{
				return createJvmDelegateTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmSpecializedTypeReference(JvmSpecializedTypeReference object)
			{
				return createJvmSpecializedTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmSynonymTypeReference(JvmSynonymTypeReference object)
			{
				return createJvmSynonymTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmUnknownTypeReference(JvmUnknownTypeReference object)
			{
				return createJvmUnknownTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmCompoundTypeReference(JvmCompoundTypeReference object)
			{
				return createJvmCompoundTypeReferenceAdapter();
			}
			@Override
			public Adapter caseJvmCustomAnnotationValue(JvmCustomAnnotationValue object)
			{
				return createJvmCustomAnnotationValueAdapter();
			}
			@Override
			public Adapter caseJvmInnerTypeReference(JvmInnerTypeReference object)
			{
				return createJvmInnerTypeReferenceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmIdentifiableElement
	 * @generated
	 */
	public Adapter createJvmIdentifiableElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmType <em>Jvm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmType
	 * @generated
	 */
	public Adapter createJvmTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmVoid <em>Jvm Void</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmVoid
	 * @generated
	 */
	public Adapter createJvmVoidAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmComponentType <em>Jvm Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmComponentType
	 * @generated
	 */
	public Adapter createJvmComponentTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmPrimitiveType <em>Jvm Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmPrimitiveType
	 * @generated
	 */
	public Adapter createJvmPrimitiveTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmArrayType <em>Jvm Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmArrayType
	 * @generated
	 */
	public Adapter createJvmArrayTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType
	 * @generated
	 */
	public Adapter createJvmDeclaredTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeParameter <em>Jvm Type Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameter
	 * @generated
	 */
	public Adapter createJvmTypeParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator <em>Jvm Type Parameter Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
	 * @generated
	 */
	public Adapter createJvmTypeParameterDeclaratorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmConstraintOwner <em>Jvm Constraint Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmConstraintOwner
	 * @generated
	 */
	public Adapter createJvmConstraintOwnerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeConstraint <em>Jvm Type Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint
	 * @generated
	 */
	public Adapter createJvmTypeConstraintAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmUpperBound <em>Jvm Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmUpperBound
	 * @generated
	 */
	public Adapter createJvmUpperBoundAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmLowerBound <em>Jvm Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmLowerBound
	 * @generated
	 */
	public Adapter createJvmLowerBoundAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationType <em>Jvm Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationType
	 * @generated
	 */
	public Adapter createJvmAnnotationTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmEnumerationType <em>Jvm Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmEnumerationType
	 * @generated
	 */
	public Adapter createJvmEnumerationTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmEnumerationLiteral <em>Jvm Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmEnumerationLiteral
	 * @generated
	 */
	public Adapter createJvmEnumerationLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmGenericType <em>Jvm Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmGenericType
	 * @generated
	 */
	public Adapter createJvmGenericTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeReference <em>Jvm Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeReference
	 * @generated
	 */
	public Adapter createJvmTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference <em>Jvm Parameterized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmParameterizedTypeReference
	 * @generated
	 */
	public Adapter createJvmParameterizedTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference <em>Jvm Generic Array Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
	 * @generated
	 */
	public Adapter createJvmGenericArrayTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmWildcardTypeReference <em>Jvm Wildcard Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmWildcardTypeReference
	 * @generated
	 */
	public Adapter createJvmWildcardTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnyTypeReference <em>Jvm Any Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnyTypeReference
	 * @generated
	 */
	public Adapter createJvmAnyTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmMultiTypeReference <em>Jvm Multi Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmMultiTypeReference
	 * @generated
	 */
	public Adapter createJvmMultiTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmMember <em>Jvm Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmMember
	 * @generated
	 */
	public Adapter createJvmMemberAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFeature <em>Jvm Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmFeature
	 * @generated
	 */
	public Adapter createJvmFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmField <em>Jvm Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmField
	 * @generated
	 */
	public Adapter createJvmFieldAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmExecutable <em>Jvm Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmExecutable
	 * @generated
	 */
	public Adapter createJvmExecutableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmConstructor <em>Jvm Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmConstructor
	 * @generated
	 */
	public Adapter createJvmConstructorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmOperation <em>Jvm Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmOperation
	 * @generated
	 */
	public Adapter createJvmOperationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFormalParameter <em>Jvm Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmFormalParameter
	 * @generated
	 */
	public Adapter createJvmFormalParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationTarget
	 * @generated
	 */
	public Adapter createJvmAnnotationTargetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationReference <em>Jvm Annotation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationReference
	 * @generated
	 */
	public Adapter createJvmAnnotationReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationValue <em>Jvm Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationValue
	 * @generated
	 */
	public Adapter createJvmAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIntAnnotationValue <em>Jvm Int Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmIntAnnotationValue
	 * @generated
	 */
	public Adapter createJvmIntAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmBooleanAnnotationValue <em>Jvm Boolean Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
	 * @generated
	 */
	public Adapter createJvmBooleanAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmByteAnnotationValue <em>Jvm Byte Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmByteAnnotationValue
	 * @generated
	 */
	public Adapter createJvmByteAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmShortAnnotationValue <em>Jvm Short Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmShortAnnotationValue
	 * @generated
	 */
	public Adapter createJvmShortAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmLongAnnotationValue <em>Jvm Long Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmLongAnnotationValue
	 * @generated
	 */
	public Adapter createJvmLongAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmDoubleAnnotationValue <em>Jvm Double Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
	 * @generated
	 */
	public Adapter createJvmDoubleAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFloatAnnotationValue <em>Jvm Float Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmFloatAnnotationValue
	 * @generated
	 */
	public Adapter createJvmFloatAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmCharAnnotationValue <em>Jvm Char Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmCharAnnotationValue
	 * @generated
	 */
	public Adapter createJvmCharAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmStringAnnotationValue <em>Jvm String Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmStringAnnotationValue
	 * @generated
	 */
	public Adapter createJvmStringAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeAnnotationValue <em>Jvm Type Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeAnnotationValue
	 * @generated
	 */
	public Adapter createJvmTypeAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue <em>Jvm Annotation Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
	 * @generated
	 */
	public Adapter createJvmAnnotationAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmEnumAnnotationValue <em>Jvm Enum Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmEnumAnnotationValue
	 * @generated
	 */
	public Adapter createJvmEnumAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmDelegateTypeReference <em>Jvm Delegate Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmDelegateTypeReference
	 * @generated
	 */
	public Adapter createJvmDelegateTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmSpecializedTypeReference <em>Jvm Specialized Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmSpecializedTypeReference
	 * @generated
	 */
	public Adapter createJvmSpecializedTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmSynonymTypeReference <em>Jvm Synonym Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmSynonymTypeReference
	 * @generated
	 */
	public Adapter createJvmSynonymTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmUnknownTypeReference <em>Jvm Unknown Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmUnknownTypeReference
	 * @generated
	 */
	public Adapter createJvmUnknownTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmCompoundTypeReference <em>Jvm Compound Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmCompoundTypeReference
	 * @generated
	 */
	public Adapter createJvmCompoundTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmCustomAnnotationValue <em>Jvm Custom Annotation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmCustomAnnotationValue
	 * @generated
	 */
	public Adapter createJvmCustomAnnotationValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmInnerTypeReference <em>Jvm Inner Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmInnerTypeReference
	 * @generated
	 */
	public Adapter createJvmInnerTypeReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //TypesAdapterFactory
