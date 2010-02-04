/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParsingTestUtilAdapterFactory.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parser.partialParsingTestUtil.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage
 * @generated
 */
public class PartialParsingTestUtilAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PartialParsingTestUtilPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialParsingTestUtilAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PartialParsingTestUtilPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
	protected PartialParsingTestUtilSwitch<Adapter> modelSwitch =
		new PartialParsingTestUtilSwitch<Adapter>() {
			@Override
			public Adapter caseCrossResourceContainerManyChildren(CrossResourceContainerManyChildren object) {
				return createCrossResourceContainerManyChildrenAdapter();
			}
			@Override
			public Adapter caseCrossResourceContainerOneChild(CrossResourceContainerOneChild object) {
				return createCrossResourceContainerOneChildAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren <em>Cross Resource Container Many Children</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren
	 * @generated
	 */
	public Adapter createCrossResourceContainerManyChildrenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild <em>Cross Resource Container One Child</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild
	 * @generated
	 */
	public Adapter createCrossResourceContainerOneChildAdapter() {
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
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PartialParsingTestUtilAdapterFactory
