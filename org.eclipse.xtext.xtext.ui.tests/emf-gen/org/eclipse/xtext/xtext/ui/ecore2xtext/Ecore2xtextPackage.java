/**
 * <copyright>
 * </copyright>
 *
 * $Id: Ecore2xtextPackage.java,v 1.2 2010/03/10 16:34:10 jkohnlein Exp $
 */
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2xtextFactory
 * @model kind="package"
 * @generated
 */
public interface Ecore2xtextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ecore2xtext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/ecore2xtext";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ecore2xtext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ecore2xtextPackage eINSTANCE = org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.AbstractImpl <em>Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.AbstractImpl
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getAbstract()
	 * @generated
	 */
	int ABSTRACT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete0Impl <em>Concrete0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete0Impl
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getConcrete0()
	 * @generated
	 */
	int CONCRETE0 = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE0__NAME = ABSTRACT__NAME;

	/**
	 * The number of structural features of the '<em>Concrete0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE0_FEATURE_COUNT = ABSTRACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete1Impl <em>Concrete1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete1Impl
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getConcrete1()
	 * @generated
	 */
	int CONCRETE1 = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE1__NAME = ABSTRACT__NAME;

	/**
	 * The number of structural features of the '<em>Concrete1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE1_FEATURE_COUNT = ABSTRACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.RootImpl
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 3;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CLASSES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.DiamondInheritanceImpl <em>Diamond Inheritance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.DiamondInheritanceImpl
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getDiamondInheritance()
	 * @generated
	 */
	int DIAMOND_INHERITANCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAMOND_INHERITANCE__NAME = CONCRETE0__NAME;

	/**
	 * The number of structural features of the '<em>Diamond Inheritance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAMOND_INHERITANCE_FEATURE_COUNT = CONCRETE0_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '<em>INT</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getINT()
	 * @generated
	 */
	int INT = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract
	 * @generated
	 */
	EClass getAbstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Abstract#getName()
	 * @see #getAbstract()
	 * @generated
	 */
	EAttribute getAbstract_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete0 <em>Concrete0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete0</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete0
	 * @generated
	 */
	EClass getConcrete0();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete1 <em>Concrete1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete1</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Concrete1
	 * @generated
	 */
	EClass getConcrete1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getClasses()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Classes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.Root#getName()
	 * @see #getRoot()
	 * @generated
	 */
	EAttribute getRoot_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.DiamondInheritance <em>Diamond Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diamond Inheritance</em>'.
	 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.DiamondInheritance
	 * @generated
	 */
	EClass getDiamondInheritance();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>INT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>INT</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getINT();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Ecore2xtextFactory getEcore2xtextFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.AbstractImpl <em>Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.AbstractImpl
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getAbstract()
		 * @generated
		 */
		EClass ABSTRACT = eINSTANCE.getAbstract();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT__NAME = eINSTANCE.getAbstract_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete0Impl <em>Concrete0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete0Impl
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getConcrete0()
		 * @generated
		 */
		EClass CONCRETE0 = eINSTANCE.getConcrete0();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete1Impl <em>Concrete1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Concrete1Impl
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getConcrete1()
		 * @generated
		 */
		EClass CONCRETE1 = eINSTANCE.getConcrete1();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.RootImpl
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__CLASSES = eINSTANCE.getRoot_Classes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT__NAME = eINSTANCE.getRoot_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtext.ui.ecore2xtext.impl.DiamondInheritanceImpl <em>Diamond Inheritance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.DiamondInheritanceImpl
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getDiamondInheritance()
		 * @generated
		 */
		EClass DIAMOND_INHERITANCE = eINSTANCE.getDiamondInheritance();

		/**
		 * The meta object literal for the '<em>INT</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.xtext.xtext.ui.ecore2xtext.impl.Ecore2xtextPackageImpl#getINT()
		 * @generated
		 */
		EDataType INT = eINSTANCE.getINT();

	}

} //Ecore2xtextPackage
