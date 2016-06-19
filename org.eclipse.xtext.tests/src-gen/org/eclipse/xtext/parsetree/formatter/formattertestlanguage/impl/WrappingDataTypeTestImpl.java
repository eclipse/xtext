/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.WrappingDataTypeTest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wrapping Data Type Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.WrappingDataTypeTestImpl#getDatatype <em>Datatype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WrappingDataTypeTestImpl extends RootImpl implements WrappingDataTypeTest
{
  /**
   * The default value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatype()
   * @generated
   * @ordered
   */
  protected static final String DATATYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatype()
   * @generated
   * @ordered
   */
  protected String datatype = DATATYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WrappingDataTypeTestImpl()
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
    return FormattertestlanguagePackage.Literals.WRAPPING_DATA_TYPE_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDatatype()
  {
    return datatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDatatype(String newDatatype)
  {
    String oldDatatype = datatype;
    datatype = newDatatype;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST__DATATYPE, oldDatatype, datatype));
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
      case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST__DATATYPE:
        return getDatatype();
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
      case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST__DATATYPE:
        setDatatype((String)newValue);
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
      case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST__DATATYPE:
        setDatatype(DATATYPE_EDEFAULT);
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
      case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST__DATATYPE:
        return DATATYPE_EDEFAULT == null ? datatype != null : !DATATYPE_EDEFAULT.equals(datatype);
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
    result.append(" (datatype: ");
    result.append(datatype);
    result.append(')');
    return result.toString();
  }

} //WrappingDataTypeTestImpl
