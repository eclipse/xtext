/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered Group Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupBooleanImpl#isVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupBooleanImpl#isVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupBooleanImpl#isVal3 <em>Val3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnorderedGroupBooleanImpl extends MinimalEObjectImpl.Container implements UnorderedGroupBoolean
{
  /**
   * The default value of the '{@link #isVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal1()
   * @generated
   * @ordered
   */
  protected static final boolean VAL1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVal1() <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal1()
   * @generated
   * @ordered
   */
  protected boolean val1 = VAL1_EDEFAULT;

  /**
   * The default value of the '{@link #isVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal2()
   * @generated
   * @ordered
   */
  protected static final boolean VAL2_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal2()
   * @generated
   * @ordered
   */
  protected boolean val2 = VAL2_EDEFAULT;

  /**
   * The default value of the '{@link #isVal3() <em>Val3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal3()
   * @generated
   * @ordered
   */
  protected static final boolean VAL3_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVal3() <em>Val3</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVal3()
   * @generated
   * @ordered
   */
  protected boolean val3 = VAL3_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnorderedGroupBooleanImpl()
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
    return SequencertestPackage.Literals.UNORDERED_GROUP_BOOLEAN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVal1()
  {
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal1(boolean newVal1)
  {
    boolean oldVal1 = val1;
    val1 = newVal1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL1, oldVal1, val1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVal2()
  {
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal2(boolean newVal2)
  {
    boolean oldVal2 = val2;
    val2 = newVal2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL2, oldVal2, val2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVal3()
  {
    return val3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal3(boolean newVal3)
  {
    boolean oldVal3 = val3;
    val3 = newVal3;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL3, oldVal3, val3));
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
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL1:
        return isVal1();
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL2:
        return isVal2();
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL3:
        return isVal3();
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
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL1:
        setVal1((Boolean)newValue);
        return;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL2:
        setVal2((Boolean)newValue);
        return;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL3:
        setVal3((Boolean)newValue);
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
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL1:
        setVal1(VAL1_EDEFAULT);
        return;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL2:
        setVal2(VAL2_EDEFAULT);
        return;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL3:
        setVal3(VAL3_EDEFAULT);
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
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL1:
        return val1 != VAL1_EDEFAULT;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL2:
        return val2 != VAL2_EDEFAULT;
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN__VAL3:
        return val3 != VAL3_EDEFAULT;
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
    result.append(", val2: ");
    result.append(val2);
    result.append(", val3: ");
    result.append(val3);
    result.append(')');
    return result.toString();
  }

} //UnorderedGroupBooleanImpl
