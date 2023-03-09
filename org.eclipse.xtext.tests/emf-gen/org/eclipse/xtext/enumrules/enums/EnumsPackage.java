/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsPackage.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.xtext.enumrules.enums.EnumsFactory
 * @model kind="package"
 * @generated
 */
public interface EnumsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "enums";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/EnumRulesTestLanguage/imported";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "enums";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnumsPackage eINSTANCE = org.eclipse.xtext.enumrules.enums.impl.EnumsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl <em>Existing Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl
	 * @see org.eclipse.xtext.enumrules.enums.impl.EnumsPackageImpl#getExistingType()
	 * @generated
	 */
	int EXISTING_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Enum Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_TYPE__ENUM_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>String Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_TYPE__STRING_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Existing Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTING_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.enumrules.enums.ExistingEnum <em>Existing Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.enumrules.enums.ExistingEnum
	 * @see org.eclipse.xtext.enumrules.enums.impl.EnumsPackageImpl#getExistingEnum()
	 * @generated
	 */
	int EXISTING_ENUM = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.enumrules.enums.ExistingType <em>Existing Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Existing Type</em>'.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingType
	 * @generated
	 */
	EClass getExistingType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enums.ExistingType#getEnumFeature <em>Enum Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum Feature</em>'.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingType#getEnumFeature()
	 * @see #getExistingType()
	 * @generated
	 */
	EAttribute getExistingType_EnumFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enums.ExistingType#getStringFeature <em>String Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Feature</em>'.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingType#getStringFeature()
	 * @see #getExistingType()
	 * @generated
	 */
	EAttribute getExistingType_StringFeature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.enumrules.enums.ExistingEnum <em>Existing Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Existing Enum</em>'.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingEnum
	 * @generated
	 */
	EEnum getExistingEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnumsFactory getEnumsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl <em>Existing Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl
		 * @see org.eclipse.xtext.enumrules.enums.impl.EnumsPackageImpl#getExistingType()
		 * @generated
		 */
		EClass EXISTING_TYPE = eINSTANCE.getExistingType();
		/**
		 * The meta object literal for the '<em><b>Enum Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTING_TYPE__ENUM_FEATURE = eINSTANCE.getExistingType_EnumFeature();
		/**
		 * The meta object literal for the '<em><b>String Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXISTING_TYPE__STRING_FEATURE = eINSTANCE.getExistingType_StringFeature();
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enums.ExistingEnum <em>Existing Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.enumrules.enums.ExistingEnum
		 * @see org.eclipse.xtext.enumrules.enums.impl.EnumsPackageImpl#getExistingEnum()
		 * @generated
		 */
		EEnum EXISTING_ENUM = eINSTANCE.getExistingEnum();

	}

} //EnumsPackage
