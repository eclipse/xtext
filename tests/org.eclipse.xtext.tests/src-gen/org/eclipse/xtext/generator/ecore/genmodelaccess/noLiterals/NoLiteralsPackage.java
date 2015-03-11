/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals;

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
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsFactory
 * @model kind="package"
 * @generated
 */
public interface NoLiteralsPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "noLiterals";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://xtext.org/genmodeltest-noliterals-v1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "noLiterals";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NoLiteralsPackage eINSTANCE = org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLitClassImpl <em>No Lit Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLitClassImpl
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl#getNoLitClass()
	 * @generated
	 */
	int NO_LIT_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Attribute2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_LIT_CLASS__ATTRIBUTE2 = 0;

	/**
	 * The feature id for the '<em><b>Reference2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_LIT_CLASS__REFERENCE2 = 1;

	/**
	 * The number of structural features of the '<em>No Lit Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NO_LIT_CLASS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitEnum <em>No Lit Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitEnum
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl#getNoLitEnum()
	 * @generated
	 */
	int NO_LIT_ENUM = 1;

	/**
	 * The meta object id for the '<em>No Lit Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.impl.NoLiteralsPackageImpl#getNoLitDataType()
	 * @generated
	 */
	int NO_LIT_DATA_TYPE = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass <em>No Lit Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>No Lit Class</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass
	 * @generated
	 */
	EClass getNoLitClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getAttribute2 <em>Attribute2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute2</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getAttribute2()
	 * @see #getNoLitClass()
	 * @generated
	 */
	EAttribute getNoLitClass_Attribute2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getReference2 <em>Reference2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference2</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getReference2()
	 * @see #getNoLitClass()
	 * @generated
	 */
	EReference getNoLitClass_Reference2();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitEnum <em>No Lit Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>No Lit Enum</em>'.
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitEnum
	 * @generated
	 */
	EEnum getNoLitEnum();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>No Lit Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>No Lit Data Type</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getNoLitDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NoLiteralsFactory getNoLiteralsFactory();

} //NoLiteralsPackage
