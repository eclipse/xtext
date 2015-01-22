/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupValDelegate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unordered Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupImpl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupImpl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupImpl#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.UnorderedGroupImpl#getVal4 <em>Val4</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnorderedGroupImpl extends MinimalEObjectImpl.Container implements UnorderedGroup
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
   * The default value of the '{@link #getVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected static final int VAL2_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected int val2 = VAL2_EDEFAULT;

  /**
   * The cached value of the '{@link #getVal3() <em>Val3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal3()
   * @generated
   * @ordered
   */
  protected UnorderedGroupVal val3;

  /**
   * The cached value of the '{@link #getVal4() <em>Val4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal4()
   * @generated
   * @ordered
   */
  protected UnorderedGroupValDelegate val4;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnorderedGroupImpl()
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
    return SequencertestPackage.Literals.UNORDERED_GROUP;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL1, oldVal1, val1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVal2()
  {
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal2(int newVal2)
  {
    int oldVal2 = val2;
    val2 = newVal2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL2, oldVal2, val2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupVal getVal3()
  {
    return val3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVal3(UnorderedGroupVal newVal3, NotificationChain msgs)
  {
    UnorderedGroupVal oldVal3 = val3;
    val3 = newVal3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL3, oldVal3, newVal3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal3(UnorderedGroupVal newVal3)
  {
    if (newVal3 != val3)
    {
      NotificationChain msgs = null;
      if (val3 != null)
        msgs = ((InternalEObject)val3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.UNORDERED_GROUP__VAL3, null, msgs);
      if (newVal3 != null)
        msgs = ((InternalEObject)newVal3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.UNORDERED_GROUP__VAL3, null, msgs);
      msgs = basicSetVal3(newVal3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL3, newVal3, newVal3));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupValDelegate getVal4()
  {
    return val4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVal4(UnorderedGroupValDelegate newVal4, NotificationChain msgs)
  {
    UnorderedGroupValDelegate oldVal4 = val4;
    val4 = newVal4;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL4, oldVal4, newVal4);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal4(UnorderedGroupValDelegate newVal4)
  {
    if (newVal4 != val4)
    {
      NotificationChain msgs = null;
      if (val4 != null)
        msgs = ((InternalEObject)val4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.UNORDERED_GROUP__VAL4, null, msgs);
      if (newVal4 != null)
        msgs = ((InternalEObject)newVal4).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SequencertestPackage.UNORDERED_GROUP__VAL4, null, msgs);
      msgs = basicSetVal4(newVal4, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.UNORDERED_GROUP__VAL4, newVal4, newVal4));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SequencertestPackage.UNORDERED_GROUP__VAL3:
        return basicSetVal3(null, msgs);
      case SequencertestPackage.UNORDERED_GROUP__VAL4:
        return basicSetVal4(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SequencertestPackage.UNORDERED_GROUP__VAL1:
        return getVal1();
      case SequencertestPackage.UNORDERED_GROUP__VAL2:
        return getVal2();
      case SequencertestPackage.UNORDERED_GROUP__VAL3:
        return getVal3();
      case SequencertestPackage.UNORDERED_GROUP__VAL4:
        return getVal4();
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
      case SequencertestPackage.UNORDERED_GROUP__VAL1:
        setVal1((String)newValue);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL2:
        setVal2((Integer)newValue);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL3:
        setVal3((UnorderedGroupVal)newValue);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL4:
        setVal4((UnorderedGroupValDelegate)newValue);
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
      case SequencertestPackage.UNORDERED_GROUP__VAL1:
        setVal1(VAL1_EDEFAULT);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL2:
        setVal2(VAL2_EDEFAULT);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL3:
        setVal3((UnorderedGroupVal)null);
        return;
      case SequencertestPackage.UNORDERED_GROUP__VAL4:
        setVal4((UnorderedGroupValDelegate)null);
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
      case SequencertestPackage.UNORDERED_GROUP__VAL1:
        return VAL1_EDEFAULT == null ? val1 != null : !VAL1_EDEFAULT.equals(val1);
      case SequencertestPackage.UNORDERED_GROUP__VAL2:
        return val2 != VAL2_EDEFAULT;
      case SequencertestPackage.UNORDERED_GROUP__VAL3:
        return val3 != null;
      case SequencertestPackage.UNORDERED_GROUP__VAL4:
        return val4 != null;
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
    result.append(')');
    return result.toString();
  }

} //UnorderedGroupImpl
