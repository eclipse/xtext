/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependent Alternative1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DependentAlternative1Impl#getVal <em>Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.DependentAlternative1Impl#isFlag <em>Flag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependentAlternative1Impl extends MinimalEObjectImpl.Container implements DependentAlternative1
{
  /**
   * The default value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected static final String VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal() <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal()
   * @generated
   * @ordered
   */
  protected String val = VAL_EDEFAULT;

  /**
   * The default value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected static final boolean FLAG_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFlag() <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFlag()
   * @generated
   * @ordered
   */
  protected boolean flag = FLAG_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DependentAlternative1Impl()
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
    return SequencertestPackage.Literals.DEPENDENT_ALTERNATIVE1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal()
  {
    return val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal(String newVal)
  {
    String oldVal = val;
    val = newVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DEPENDENT_ALTERNATIVE1__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFlag()
  {
    return flag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFlag(boolean newFlag)
  {
    boolean oldFlag = flag;
    flag = newFlag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.DEPENDENT_ALTERNATIVE1__FLAG, oldFlag, flag));
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__VAL:
        return getVal();
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__FLAG:
        return isFlag();
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__VAL:
        setVal((String)newValue);
        return;
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__FLAG:
        setFlag((Boolean)newValue);
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__FLAG:
        setFlag(FLAG_EDEFAULT);
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
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__VAL:
        return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1__FLAG:
        return flag != FLAG_EDEFAULT;
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
    result.append(" (val: ");
    result.append(val);
    result.append(", flag: ");
    result.append(flag);
    result.append(')');
    return result.toString();
  }

} //DependentAlternative1Impl
