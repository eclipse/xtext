/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.ParameterImpl#isKw2 <em>Kw2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends FieldImpl implements Parameter
{
  /**
   * The default value of the '{@link #isKw2() <em>Kw2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKw2()
   * @generated
   * @ordered
   */
  protected static final boolean KW2_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isKw2() <em>Kw2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isKw2()
   * @generated
   * @ordered
   */
  protected boolean kw2 = KW2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterImpl()
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
    return ElementmatchertestlanguagePackage.Literals.PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isKw2()
  {
    return kw2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKw2(boolean newKw2)
  {
    boolean oldKw2 = kw2;
    kw2 = newKw2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.PARAMETER__KW2, oldKw2, kw2));
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
      case ElementmatchertestlanguagePackage.PARAMETER__KW2:
        return isKw2();
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
      case ElementmatchertestlanguagePackage.PARAMETER__KW2:
        setKw2((Boolean)newValue);
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
      case ElementmatchertestlanguagePackage.PARAMETER__KW2:
        setKw2(KW2_EDEFAULT);
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
      case ElementmatchertestlanguagePackage.PARAMETER__KW2:
        return kw2 != KW2_EDEFAULT;
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
    result.append(" (kw2: ");
    result.append(kw2);
    result.append(')');
    return result.toString();
  }

} //ParameterImpl
