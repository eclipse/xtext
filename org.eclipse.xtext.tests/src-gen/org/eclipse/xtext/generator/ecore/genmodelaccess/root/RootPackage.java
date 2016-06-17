/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.root;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootFactory
 * @model kind="package"
 * @generated
 */
public interface RootPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "root";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xtext.org/genmodeltest-v1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "root";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RootPackage eINSTANCE = org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootClass()
	 * @generated
	 */
	int ROOT_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CLASS__ATTRIBUTE1 = 0;

	/**
	 * The feature id for the '<em><b>Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CLASS__REFERENCE1 = 1;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CLASS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum <em>Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootEnum()
	 * @generated
	 */
	int ROOT_ENUM = 1;

	/**
	 * The meta object id for the '<em>Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootDataType()
	 * @generated
	 */
	int ROOT_DATA_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass
	 * @generated
	 */
	EClass getRootClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getAttribute1 <em>Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute1</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getAttribute1()
	 * @see #getRootClass()
	 * @generated
	 */
	EAttribute getRootClass_Attribute1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getReference1 <em>Reference1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference1</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getReference1()
	 * @see #getRootClass()
	 * @generated
	 */
	EReference getRootClass_Reference1();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum
	 * @generated
	 */
	EEnum getRootEnum();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Data Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getRootDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RootFactory getRootFactory();

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
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootClassImpl
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootClass()
		 * @generated
		 */
		EClass ROOT_CLASS = eINSTANCE.getRootClass();

		/**
		 * The meta object literal for the '<em><b>Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT_CLASS__ATTRIBUTE1 = eINSTANCE.getRootClass_Attribute1();

		/**
		 * The meta object literal for the '<em><b>Reference1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CLASS__REFERENCE1 = eINSTANCE.getRootClass_Reference1();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum <em>Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootEnum
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootEnum()
		 * @generated
		 */
		EEnum ROOT_ENUM = eINSTANCE.getRootEnum();

		/**
		 * The meta object literal for the '<em>Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.impl.RootPackageImpl#getRootDataType()
		 * @generated
		 */
		EDataType ROOT_DATA_TYPE = eINSTANCE.getRootDataType();

	}

} //RootPackage
