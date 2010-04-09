/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossContainmentPackage.java,v 1.1 2010/04/09 10:00:01 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl.crossContainment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentFactory
 * @model kind="package"
 * @generated
 */
public interface CrossContainmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "crossContainment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/test/crossContainment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "crossContainment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CrossContainmentPackage eINSTANCE = org.eclipse.xtext.parsetree.impl.crossContainment.impl.CrossContainmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.impl.CrossContainmentPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Containment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CONTAINMENT = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Containment</em>'.
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainment()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Containment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CrossContainmentFactory getCrossContainmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.parsetree.impl.crossContainment.impl.ElementImpl
		 * @see org.eclipse.xtext.parsetree.impl.crossContainment.impl.CrossContainmentPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__CONTAINER = eINSTANCE.getElement_Container();

		/**
		 * The meta object literal for the '<em><b>Containment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__CONTAINMENT = eINSTANCE.getElement_Containment();

	}

} //CrossContainmentPackage
