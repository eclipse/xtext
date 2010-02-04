/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExistingType.java,v 1.1 2010/02/04 09:24:54 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Existing Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.enums.ExistingType#getEnumFeature <em>Enum Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enums.ExistingType#getStringFeature <em>String Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage#getExistingType()
 * @model
 * @generated
 */
public interface ExistingType extends EObject {
	/**
	 * Returns the value of the '<em><b>Enum Feature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.xtext.enumrules.enums.ExistingEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Feature</em>' attribute.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingEnum
	 * @see #setEnumFeature(ExistingEnum)
	 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage#getExistingType_EnumFeature()
	 * @model
	 * @generated
	 */
	ExistingEnum getEnumFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.enumrules.enums.ExistingType#getEnumFeature <em>Enum Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Feature</em>' attribute.
	 * @see org.eclipse.xtext.enumrules.enums.ExistingEnum
	 * @see #getEnumFeature()
	 * @generated
	 */
	void setEnumFeature(ExistingEnum value);

	/**
	 * Returns the value of the '<em><b>String Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Feature</em>' attribute.
	 * @see #setStringFeature(String)
	 * @see org.eclipse.xtext.enumrules.enums.EnumsPackage#getExistingType_StringFeature()
	 * @model
	 * @generated
	 */
	String getStringFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.enumrules.enums.ExistingType#getStringFeature <em>String Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Feature</em>' attribute.
	 * @see #getStringFeature()
	 * @generated
	 */
	void setStringFeature(String value);

} // ExistingType
