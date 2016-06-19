/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Multi</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ConcreteMultiImpl#getM2 <em>M2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcreteMultiImpl extends AbstractMulti1Impl implements ConcreteMulti
{
  /**
   * The default value of the '{@link #getM2() <em>M2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getM2()
   * @generated
   * @ordered
   */
  protected static final String M2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getM2() <em>M2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getM2()
   * @generated
   * @ordered
   */
  protected String m2 = M2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConcreteMultiImpl()
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
    return SimplerewritetestPackage.Literals.CONCRETE_MULTI;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getM2()
  {
    return m2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setM2(String newM2)
  {
    String oldM2 = m2;
    m2 = newM2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimplerewritetestPackage.CONCRETE_MULTI__M2, oldM2, m2));
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
      case SimplerewritetestPackage.CONCRETE_MULTI__M2:
        return getM2();
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
      case SimplerewritetestPackage.CONCRETE_MULTI__M2:
        setM2((String)newValue);
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
      case SimplerewritetestPackage.CONCRETE_MULTI__M2:
        setM2(M2_EDEFAULT);
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
      case SimplerewritetestPackage.CONCRETE_MULTI__M2:
        return M2_EDEFAULT == null ? m2 != null : !M2_EDEFAULT.equals(m2);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == AbstractMulti2.class)
    {
      switch (derivedFeatureID)
      {
        case SimplerewritetestPackage.CONCRETE_MULTI__M2: return SimplerewritetestPackage.ABSTRACT_MULTI2__M2;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == AbstractMulti2.class)
    {
      switch (baseFeatureID)
      {
        case SimplerewritetestPackage.ABSTRACT_MULTI2__M2: return SimplerewritetestPackage.CONCRETE_MULTI__M2;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (m2: ");
    result.append(m2);
    result.append(')');
    return result.toString();
  }

} //ConcreteMultiImpl
