/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtype.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @since 2.7
 * @generated
 */
public class XtypeFactoryImpl extends EFactoryImpl implements XtypeFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtypeFactory init()
	{
		try
		{
			XtypeFactory theXtypeFactory = (XtypeFactory)EPackage.Registry.INSTANCE.getEFactory(XtypePackage.eNS_URI);
			if (theXtypeFactory != null)
			{
				return theXtypeFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtypeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtypeFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case XtypePackage.XFUNCTION_TYPE_REF: return createXFunctionTypeRef();
			case XtypePackage.XCOMPUTED_TYPE_REFERENCE: return createXComputedTypeReference();
			case XtypePackage.XIMPORT_SECTION: return createXImportSection();
			case XtypePackage.XIMPORT_DECLARATION: return createXImportDeclaration();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
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
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XFunctionTypeRef createXFunctionTypeRef()
	{
		XFunctionTypeRefImplCustom xFunctionTypeRef = new XFunctionTypeRefImplCustom();
		return xFunctionTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XComputedTypeReference createXComputedTypeReference()
	{
		XComputedTypeReferenceImplCustom xComputedTypeReference = new XComputedTypeReferenceImplCustom();
		return xComputedTypeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XImportSection createXImportSection()
	{
		XImportSectionImpl xImportSection = new XImportSectionImpl();
		return xImportSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XImportDeclaration createXImportDeclaration()
	{
		XImportDeclarationImplCustom xImportDeclaration = new XImportDeclarationImplCustom();
		return xImportDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtypePackage getXtypePackage()
	{
		return (XtypePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XtypePackage getPackage()
	{
		return XtypePackage.eINSTANCE;
	}

} //XtypeFactoryImpl
