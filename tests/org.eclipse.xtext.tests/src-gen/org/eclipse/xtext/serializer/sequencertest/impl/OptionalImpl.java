/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalImpl#getInt0 <em>Int0</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalImpl#getInt1 <em>Int1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalImpl#getInt2 <em>Int2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalImpl extends MinimalEObjectImpl.Container implements Optional
{
  /**
   * The default value of the '{@link #getInt0() <em>Int0</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt0()
   * @generated
   * @ordered
   */
  protected static final int INT0_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getInt0() <em>Int0</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt0()
   * @generated
   * @ordered
   */
  protected int int0 = INT0_EDEFAULT;

  /**
   * The default value of the '{@link #getInt1() <em>Int1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt1()
   * @generated
   * @ordered
   */
  protected static final int INT1_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getInt1() <em>Int1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt1()
   * @generated
   * @ordered
   */
  protected int int1 = INT1_EDEFAULT;

  /**
   * The default value of the '{@link #getInt2() <em>Int2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt2()
   * @generated
   * @ordered
   */
  protected static final int INT2_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getInt2() <em>Int2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInt2()
   * @generated
   * @ordered
   */
  protected int int2 = INT2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OptionalImpl()
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
    return SequencertestPackage.Literals.OPTIONAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getInt0()
  {
    return int0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt0(int newInt0)
  {
    int oldInt0 = int0;
    int0 = newInt0;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL__INT0, oldInt0, int0));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getInt1()
  {
    return int1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt1(int newInt1)
  {
    int oldInt1 = int1;
    int1 = newInt1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL__INT1, oldInt1, int1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getInt2()
  {
    return int2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInt2(int newInt2)
  {
    int oldInt2 = int2;
    int2 = newInt2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL__INT2, oldInt2, int2));
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
      case SequencertestPackage.OPTIONAL__INT0:
        return getInt0();
      case SequencertestPackage.OPTIONAL__INT1:
        return getInt1();
      case SequencertestPackage.OPTIONAL__INT2:
        return getInt2();
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
      case SequencertestPackage.OPTIONAL__INT0:
        setInt0((Integer)newValue);
        return;
      case SequencertestPackage.OPTIONAL__INT1:
        setInt1((Integer)newValue);
        return;
      case SequencertestPackage.OPTIONAL__INT2:
        setInt2((Integer)newValue);
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
      case SequencertestPackage.OPTIONAL__INT0:
        setInt0(INT0_EDEFAULT);
        return;
      case SequencertestPackage.OPTIONAL__INT1:
        setInt1(INT1_EDEFAULT);
        return;
      case SequencertestPackage.OPTIONAL__INT2:
        setInt2(INT2_EDEFAULT);
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
      case SequencertestPackage.OPTIONAL__INT0:
        return int0 != INT0_EDEFAULT;
      case SequencertestPackage.OPTIONAL__INT1:
        return int1 != INT1_EDEFAULT;
      case SequencertestPackage.OPTIONAL__INT2:
        return int2 != INT2_EDEFAULT;
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
    result.append(" (int0: ");
    result.append(int0);
    result.append(", int1: ");
    result.append(int1);
    result.append(", int2: ");
    result.append(int2);
    result.append(')');
    return result.toString();
  }

} //OptionalImpl
