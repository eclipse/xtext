/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExistingTypeImpl.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.enumrules.enums.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.enumrules.enums.EnumsPackage;
import org.eclipse.xtext.enumrules.enums.ExistingEnum;
import org.eclipse.xtext.enumrules.enums.ExistingType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Existing Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl#getEnumFeature <em>Enum Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enums.impl.ExistingTypeImpl#getStringFeature <em>String Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExistingTypeImpl extends EObjectImpl implements ExistingType {
	/**
	 * The default value of the '{@link #getEnumFeature() <em>Enum Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumFeature()
	 * @generated
	 * @ordered
	 */
	protected static final ExistingEnum ENUM_FEATURE_EDEFAULT = ExistingEnum.SAME_NAME;

	/**
	 * The cached value of the '{@link #getEnumFeature() <em>Enum Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumFeature()
	 * @generated
	 * @ordered
	 */
	protected ExistingEnum enumFeature = ENUM_FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringFeature() <em>String Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringFeature() <em>String Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringFeature()
	 * @generated
	 * @ordered
	 */
	protected String stringFeature = STRING_FEATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistingTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EnumsPackage.Literals.EXISTING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistingEnum getEnumFeature() {
		return enumFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumFeature(ExistingEnum newEnumFeature) {
		ExistingEnum oldEnumFeature = enumFeature;
		enumFeature = newEnumFeature == null ? ENUM_FEATURE_EDEFAULT : newEnumFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnumsPackage.EXISTING_TYPE__ENUM_FEATURE, oldEnumFeature, enumFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringFeature() {
		return stringFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringFeature(String newStringFeature) {
		String oldStringFeature = stringFeature;
		stringFeature = newStringFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EnumsPackage.EXISTING_TYPE__STRING_FEATURE, oldStringFeature, stringFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EnumsPackage.EXISTING_TYPE__ENUM_FEATURE:
				return getEnumFeature();
			case EnumsPackage.EXISTING_TYPE__STRING_FEATURE:
				return getStringFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EnumsPackage.EXISTING_TYPE__ENUM_FEATURE:
				setEnumFeature((ExistingEnum)newValue);
				return;
			case EnumsPackage.EXISTING_TYPE__STRING_FEATURE:
				setStringFeature((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EnumsPackage.EXISTING_TYPE__ENUM_FEATURE:
				setEnumFeature(ENUM_FEATURE_EDEFAULT);
				return;
			case EnumsPackage.EXISTING_TYPE__STRING_FEATURE:
				setStringFeature(STRING_FEATURE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EnumsPackage.EXISTING_TYPE__ENUM_FEATURE:
				return enumFeature != ENUM_FEATURE_EDEFAULT;
			case EnumsPackage.EXISTING_TYPE__STRING_FEATURE:
				return STRING_FEATURE_EDEFAULT == null ? stringFeature != null : !STRING_FEATURE_EDEFAULT.equals(stringFeature);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (enumFeature: ");
		result.append(enumFeature);
		result.append(", stringFeature: ");
		result.append(stringFeature);
		result.append(')');
		return result.toString();
	}

} //ExistingTypeImpl
