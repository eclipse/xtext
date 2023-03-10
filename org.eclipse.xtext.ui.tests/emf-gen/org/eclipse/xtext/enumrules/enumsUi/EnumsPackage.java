/**
 * <copyright>
 * </copyright>
 *
 * $Id: EnumsPackage.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enumsUi;

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
 * @see org.eclipse.xtext.enumrules.enumsUi.EnumsFactory
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
	String eNAME = "enumsUi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/ui/EnumRulesTestLanguage/imported";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "enumsUi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnumsPackage eINSTANCE = org.eclipse.xtext.enumrules.enumsUi.impl.EnumsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.enumrules.enumsUi.ExistingEnum <em>Existing Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.enumrules.enumsUi.ExistingEnum
	 * @see org.eclipse.xtext.enumrules.enumsUi.impl.EnumsPackageImpl#getExistingEnum()
	 * @generated
	 */
	int EXISTING_ENUM = 0;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.xtext.enumrules.enumsUi.ExistingEnum <em>Existing Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Existing Enum</em>'.
	 * @see org.eclipse.xtext.enumrules.enumsUi.ExistingEnum
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
		 * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enumsUi.ExistingEnum <em>Existing Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.enumrules.enumsUi.ExistingEnum
		 * @see org.eclipse.xtext.enumrules.enumsUi.impl.EnumsPackageImpl#getExistingEnum()
		 * @generated
		 */
		EEnum EXISTING_ENUM = eINSTANCE.getExistingEnum();

	}

} //EnumsPackage
