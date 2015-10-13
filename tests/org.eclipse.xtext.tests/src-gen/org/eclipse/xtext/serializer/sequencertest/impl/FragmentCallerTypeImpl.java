/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment Caller Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.FragmentCallerTypeImpl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.FragmentCallerTypeImpl#getVal <em>Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.FragmentCallerTypeImpl#getFragVal <em>Frag Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FragmentCallerTypeImpl extends MinimalEObjectImpl.Container implements FragmentCallerType
{
  /**
   * The default value of the '{@link #getVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected static final String VAL1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected String val1 = VAL1_EDEFAULT;

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
   * The default value of the '{@link #getFragVal() <em>Frag Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragVal()
   * @generated
   * @ordered
   */
  protected static final String FRAG_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFragVal() <em>Frag Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFragVal()
   * @generated
   * @ordered
   */
  protected String fragVal = FRAG_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FragmentCallerTypeImpl()
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
    return SequencertestPackage.Literals.FRAGMENT_CALLER_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal1()
  {
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal1(String newVal1)
  {
    String oldVal1 = val1;
    val1 = newVal1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL1, oldVal1, val1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL, oldVal, val));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFragVal()
  {
    return fragVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFragVal(String newFragVal)
  {
    String oldFragVal = fragVal;
    fragVal = newFragVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.FRAGMENT_CALLER_TYPE__FRAG_VAL, oldFragVal, fragVal));
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
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL1:
        return getVal1();
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL:
        return getVal();
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__FRAG_VAL:
        return getFragVal();
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
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL1:
        setVal1((String)newValue);
        return;
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL:
        setVal((String)newValue);
        return;
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__FRAG_VAL:
        setFragVal((String)newValue);
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
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL1:
        setVal1(VAL1_EDEFAULT);
        return;
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL:
        setVal(VAL_EDEFAULT);
        return;
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__FRAG_VAL:
        setFragVal(FRAG_VAL_EDEFAULT);
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
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL1:
        return VAL1_EDEFAULT == null ? val1 != null : !VAL1_EDEFAULT.equals(val1);
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__VAL:
        return VAL_EDEFAULT == null ? val != null : !VAL_EDEFAULT.equals(val);
      case SequencertestPackage.FRAGMENT_CALLER_TYPE__FRAG_VAL:
        return FRAG_VAL_EDEFAULT == null ? fragVal != null : !FRAG_VAL_EDEFAULT.equals(fragVal);
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
    result.append(" (val1: ");
    result.append(val1);
    result.append(", val: ");
    result.append(val);
    result.append(", fragVal: ");
    result.append(fragVal);
    result.append(')');
    return result.toString();
  }

} //FragmentCallerTypeImpl
