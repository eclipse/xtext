/**
 * <copyright>
 * </copyright>
 *
 * $Id: SimplestructurePackage.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructureFactory
 * @model kind="package"
 * @generated
 */
public interface SimplestructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simplestructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/simplestructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simplestructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimplestructurePackage eINSTANCE = org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.AImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.AImpl
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getA()
	 * @generated
	 */
	int A = 0;

	/**
	 * The feature id for the '<em><b>A</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__A = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__B = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__NAME = 2;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.BImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.BImpl
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getB()
	 * @generated
	 */
	int B = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__NAME = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.rootImpl <em>root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.rootImpl
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getroot()
	 * @generated
	 */
	int ROOT = 2;

	/**
	 * The feature id for the '<em><b>A</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__A = 0;

	/**
	 * The number of structural features of the '<em>root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A
	 * @generated
	 */
	EClass getA();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>A</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getA()
	 * @see #getA()
	 * @generated
	 */
	EReference getA_A();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getB()
	 * @see #getA()
	 * @generated
	 */
	EReference getA_B();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A#getName()
	 * @see #getA()
	 * @generated
	 */
	EAttribute getA_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B
	 * @generated
	 */
	EClass getB();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getName()
	 * @see #getB()
	 * @generated
	 */
	EAttribute getB_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>B</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.B#getB()
	 * @see #getB()
	 * @generated
	 */
	EReference getB_B();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.root <em>root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>root</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.root
	 * @generated
	 */
	EClass getroot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.root#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>A</em>'.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.root#getA()
	 * @see #getroot()
	 * @generated
	 */
	EReference getroot_A();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimplestructureFactory getSimplestructureFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.AImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.AImpl
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getA()
		 * @generated
		 */
		EClass A = eINSTANCE.getA();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A__A = eINSTANCE.getA_A();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A__B = eINSTANCE.getA_B();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A__NAME = eINSTANCE.getA_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.BImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.BImpl
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getB()
		 * @generated
		 */
		EClass B = eINSTANCE.getB();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B__NAME = eINSTANCE.getB_Name();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B__B = eINSTANCE.getB_B();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.rootImpl <em>root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.rootImpl
		 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.impl.SimplestructurePackageImpl#getroot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getroot();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__A = eINSTANCE.getroot_A();

	}

} //SimplestructurePackage
