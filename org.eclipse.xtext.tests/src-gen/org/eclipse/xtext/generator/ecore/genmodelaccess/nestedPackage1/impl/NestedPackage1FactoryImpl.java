/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NestedPackage1FactoryImpl extends EFactoryImpl implements NestedPackage1Factory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NestedPackage1Factory init()
	{
		try
		{
			NestedPackage1Factory theNestedPackage1Factory = (NestedPackage1Factory)EPackage.Registry.INSTANCE.getEFactory(NestedPackage1Package.eNS_URI);
			if (theNestedPackage1Factory != null)
			{
				return theNestedPackage1Factory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NestedPackage1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedPackage1FactoryImpl()
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
			case NestedPackage1Package.NESTED_CLASS1: return createNestedClass1();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedClass1 createNestedClass1()
	{
		NestedClass1Impl nestedClass1 = new NestedClass1Impl();
		return nestedClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedPackage1Package getNestedPackage1Package()
	{
		return (NestedPackage1Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NestedPackage1Package getPackage()
	{
		return NestedPackage1Package.eINSTANCE;
	}

} //NestedPackage1FactoryImpl
