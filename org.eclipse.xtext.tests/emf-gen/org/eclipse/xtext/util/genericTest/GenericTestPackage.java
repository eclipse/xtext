/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericTestPackage.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest;

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
 * @see org.eclipse.xtext.util.genericTest.GenericTestFactory
 * @model kind="package"
 * @generated
 */
public interface GenericTestPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "genericTest";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Xtext/tests/genericTest";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "genericTest";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericTestPackage eINSTANCE = org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.AImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.AImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getA()
	 * @generated
	 */
	int A = 0;

	/**
	 * The feature id for the '<em><b>Some Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__SOME_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Some Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__SOME_REFERENCE1 = 1;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.BImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.BImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getB()
	 * @generated
	 */
	int B = 1;

	/**
	 * The feature id for the '<em><b>Some Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__SOME_REFERENCE = A__SOME_REFERENCE;

	/**
	 * The feature id for the '<em><b>Some Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__SOME_REFERENCE1 = A__SOME_REFERENCE1;

	/**
	 * The feature id for the '<em><b>Other Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__OTHER_REFERENCE = A_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Other Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__OTHER_REFERENCE1 = A_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_FEATURE_COUNT = A_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.CImpl <em>C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.CImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getC()
	 * @generated
	 */
	int C = 2;

	/**
	 * The feature id for the '<em><b>Some Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__SOME_REFERENCE = B__SOME_REFERENCE;

	/**
	 * The feature id for the '<em><b>Some Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__SOME_REFERENCE1 = B__SOME_REFERENCE1;

	/**
	 * The feature id for the '<em><b>Other Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__OTHER_REFERENCE = B__OTHER_REFERENCE;

	/**
	 * The feature id for the '<em><b>Other Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__OTHER_REFERENCE1 = B__OTHER_REFERENCE1;

	/**
	 * The number of structural features of the '<em>C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C_FEATURE_COUNT = B_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.DImpl <em>D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.DImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getD()
	 * @generated
	 */
	int D = 3;

	/**
	 * The feature id for the '<em><b>Some Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__SOME_REFERENCE = C__SOME_REFERENCE;

	/**
	 * The feature id for the '<em><b>Some Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__SOME_REFERENCE1 = C__SOME_REFERENCE1;

	/**
	 * The feature id for the '<em><b>Other Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__OTHER_REFERENCE = C__OTHER_REFERENCE;

	/**
	 * The feature id for the '<em><b>Other Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__OTHER_REFERENCE1 = C__OTHER_REFERENCE1;

	/**
	 * The number of structural features of the '<em>D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D_FEATURE_COUNT = C_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.SomeTypeImpl <em>Some Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.SomeTypeImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getSomeType()
	 * @generated
	 */
	int SOME_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Some Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.util.genericTest.impl.OtherTypeImpl <em>Other Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.util.genericTest.impl.OtherTypeImpl
	 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getOtherType()
	 * @generated
	 */
	int OTHER_TYPE = 5;

	/**
	 * The number of structural features of the '<em>Other Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.A <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.xtext.util.genericTest.A
	 * @generated
	 */
	EClass getA();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.util.genericTest.A#getSomeReference <em>Some Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Some Reference</em>'.
	 * @see org.eclipse.xtext.util.genericTest.A#getSomeReference()
	 * @see #getA()
	 * @generated
	 */
	EReference getA_SomeReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.util.genericTest.A#getSomeReference1 <em>Some Reference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Some Reference1</em>'.
	 * @see org.eclipse.xtext.util.genericTest.A#getSomeReference1()
	 * @see #getA()
	 * @generated
	 */
	EReference getA_SomeReference1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.B <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.xtext.util.genericTest.B
	 * @generated
	 */
	EClass getB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.util.genericTest.B#getOtherReference <em>Other Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other Reference</em>'.
	 * @see org.eclipse.xtext.util.genericTest.B#getOtherReference()
	 * @see #getB()
	 * @generated
	 */
	EReference getB_OtherReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.util.genericTest.B#getOtherReference1 <em>Other Reference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other Reference1</em>'.
	 * @see org.eclipse.xtext.util.genericTest.B#getOtherReference1()
	 * @see #getB()
	 * @generated
	 */
	EReference getB_OtherReference1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.C <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C</em>'.
	 * @see org.eclipse.xtext.util.genericTest.C
	 * @generated
	 */
	EClass getC();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.D <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D</em>'.
	 * @see org.eclipse.xtext.util.genericTest.D
	 * @generated
	 */
	EClass getD();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.SomeType <em>Some Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Some Type</em>'.
	 * @see org.eclipse.xtext.util.genericTest.SomeType
	 * @generated
	 */
	EClass getSomeType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.util.genericTest.OtherType <em>Other Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other Type</em>'.
	 * @see org.eclipse.xtext.util.genericTest.OtherType
	 * @generated
	 */
	EClass getOtherType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenericTestFactory getGenericTestFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.AImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.AImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getA()
		 * @generated
		 */
		EClass A = eINSTANCE.getA();

		/**
		 * The meta object literal for the '<em><b>Some Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A__SOME_REFERENCE = eINSTANCE.getA_SomeReference();

		/**
		 * The meta object literal for the '<em><b>Some Reference1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A__SOME_REFERENCE1 = eINSTANCE.getA_SomeReference1();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.BImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.BImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getB()
		 * @generated
		 */
		EClass B = eINSTANCE.getB();

		/**
		 * The meta object literal for the '<em><b>Other Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B__OTHER_REFERENCE = eINSTANCE.getB_OtherReference();

		/**
		 * The meta object literal for the '<em><b>Other Reference1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B__OTHER_REFERENCE1 = eINSTANCE.getB_OtherReference1();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.CImpl <em>C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.CImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getC()
		 * @generated
		 */
		EClass C = eINSTANCE.getC();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.DImpl <em>D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.DImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getD()
		 * @generated
		 */
		EClass D = eINSTANCE.getD();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.SomeTypeImpl <em>Some Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.SomeTypeImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getSomeType()
		 * @generated
		 */
		EClass SOME_TYPE = eINSTANCE.getSomeType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.util.genericTest.impl.OtherTypeImpl <em>Other Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.util.genericTest.impl.OtherTypeImpl
		 * @see org.eclipse.xtext.util.genericTest.impl.GenericTestPackageImpl#getOtherType()
		 * @generated
		 */
		EClass OTHER_TYPE = eINSTANCE.getOtherType();

	}

} //GenericTestPackage
