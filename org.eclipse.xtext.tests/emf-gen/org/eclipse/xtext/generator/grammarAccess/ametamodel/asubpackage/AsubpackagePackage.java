/**
 * <copyright>
 * </copyright>
 *
 * $Id: AsubpackagePackage.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage;

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
 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackageFactory
 * @model kind="package"
 * @generated
 */
public interface AsubpackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "asubpackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/tests/grammarAccess/subpackage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "asubpackage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AsubpackagePackage eINSTANCE = org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.ATypeImpl <em>AType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.ATypeImpl
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl#getAType()
	 * @generated
	 */
	int ATYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>AType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AModelImpl <em>AModel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AModelImpl
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl#getAModel()
	 * @generated
	 */
	int AMODEL = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>AModel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AMODEL_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType <em>AType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AType</em>'.
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType
	 * @generated
	 */
	EClass getAType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AType#getName()
	 * @see #getAType()
	 * @generated
	 */
	EAttribute getAType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel <em>AModel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AModel</em>'.
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel
	 * @generated
	 */
	EClass getAModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AModel#getElements()
	 * @see #getAModel()
	 * @generated
	 */
	EReference getAModel_Elements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AsubpackageFactory getAsubpackageFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.ATypeImpl <em>AType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.ATypeImpl
		 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl#getAType()
		 * @generated
		 */
		EClass ATYPE = eINSTANCE.getAType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATYPE__NAME = eINSTANCE.getAType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AModelImpl <em>AModel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AModelImpl
		 * @see org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.impl.AsubpackagePackageImpl#getAModel()
		 * @generated
		 */
		EClass AMODEL = eINSTANCE.getAModel();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AMODEL__ELEMENTS = eINSTANCE.getAModel_Elements();

	}

} //AsubpackagePackage
