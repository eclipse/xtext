/**
 * <copyright>
 * </copyright>
 *
 * $Id: MapEntryImpl.java,v 1.1 2009/02/18 19:38:46 sefftinge Exp $
 */
package org.eclipse.xtext.example.ecoredsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.xtext.example.ecoredsl.EcoredslPackage;
import org.eclipse.xtext.example.ecoredsl.MapEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl#getDetailKey <em>Detail Key</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl#getDetailValue <em>Detail Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MapEntryImpl extends EObjectImpl implements MapEntry
{
  /**
   * The default value of the '{@link #getDetailKey() <em>Detail Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailKey()
   * @generated
   * @ordered
   */
  protected static final String DETAIL_KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDetailKey() <em>Detail Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailKey()
   * @generated
   * @ordered
   */
  protected String detailKey = DETAIL_KEY_EDEFAULT;

  /**
   * The default value of the '{@link #getDetailValue() <em>Detail Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailValue()
   * @generated
   * @ordered
   */
  protected static final String DETAIL_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDetailValue() <em>Detail Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDetailValue()
   * @generated
   * @ordered
   */
  protected String detailValue = DETAIL_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MapEntryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EcoredslPackage.Literals.MAP_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDetailKey()
  {
    return detailKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetailKey(String newDetailKey)
  {
    String oldDetailKey = detailKey;
    detailKey = newDetailKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcoredslPackage.MAP_ENTRY__DETAIL_KEY, oldDetailKey, detailKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDetailValue()
  {
    return detailValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDetailValue(String newDetailValue)
  {
    String oldDetailValue = detailValue;
    detailValue = newDetailValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcoredslPackage.MAP_ENTRY__DETAIL_VALUE, oldDetailValue, detailValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EcoredslPackage.MAP_ENTRY__DETAIL_KEY:
        return getDetailKey();
      case EcoredslPackage.MAP_ENTRY__DETAIL_VALUE:
        return getDetailValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EcoredslPackage.MAP_ENTRY__DETAIL_KEY:
        setDetailKey((String)newValue);
        return;
      case EcoredslPackage.MAP_ENTRY__DETAIL_VALUE:
        setDetailValue((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EcoredslPackage.MAP_ENTRY__DETAIL_KEY:
        setDetailKey(DETAIL_KEY_EDEFAULT);
        return;
      case EcoredslPackage.MAP_ENTRY__DETAIL_VALUE:
        setDetailValue(DETAIL_VALUE_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EcoredslPackage.MAP_ENTRY__DETAIL_KEY:
        return DETAIL_KEY_EDEFAULT == null ? detailKey != null : !DETAIL_KEY_EDEFAULT.equals(detailKey);
      case EcoredslPackage.MAP_ENTRY__DETAIL_VALUE:
        return DETAIL_VALUE_EDEFAULT == null ? detailValue != null : !DETAIL_VALUE_EDEFAULT.equals(detailValue);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (detailKey: ");
    result.append(detailKey);
    result.append(", detailValue: ");
    result.append(detailValue);
    result.append(')');
    return result.toString();
  }

} //MapEntryImpl
