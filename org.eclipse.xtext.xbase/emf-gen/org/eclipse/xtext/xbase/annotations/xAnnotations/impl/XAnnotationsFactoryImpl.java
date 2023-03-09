/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.annotations.xAnnotations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @since 2.7
 * @generated
 */
public class XAnnotationsFactoryImpl extends EFactoryImpl implements XAnnotationsFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XAnnotationsFactory init()
	{
		try
		{
			XAnnotationsFactory theXAnnotationsFactory = (XAnnotationsFactory)EPackage.Registry.INSTANCE.getEFactory(XAnnotationsPackage.eNS_URI);
			if (theXAnnotationsFactory != null)
			{
				return theXAnnotationsFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XAnnotationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAnnotationsFactoryImpl()
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
			case XAnnotationsPackage.XANNOTATION: return createXAnnotation();
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_PAIR: return createXAnnotationElementValuePair();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XAnnotation createXAnnotation()
	{
		XAnnotationImpl xAnnotation = new XAnnotationImpl();
		return xAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XAnnotationElementValuePair createXAnnotationElementValuePair()
	{
		XAnnotationElementValuePairImpl xAnnotationElementValuePair = new XAnnotationElementValuePairImpl();
		return xAnnotationElementValuePair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XAnnotationsPackage getXAnnotationsPackage()
	{
		return (XAnnotationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XAnnotationsPackage getPackage()
	{
		return XAnnotationsPackage.eINSTANCE;
	}

} //XAnnotationsFactoryImpl
