/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Double</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalDoubleImpl#getDouble0 <em>Double0</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalDoubleImpl#getDouble1 <em>Double1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.OptionalDoubleImpl#getDouble2 <em>Double2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalDoubleImpl extends MinimalEObjectImpl.Container implements OptionalDouble
{
  /**
   * The default value of the '{@link #getDouble0() <em>Double0</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble0()
   * @generated
   * @ordered
   */
  protected static final double DOUBLE0_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getDouble0() <em>Double0</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble0()
   * @generated
   * @ordered
   */
  protected double double0 = DOUBLE0_EDEFAULT;

  /**
   * The default value of the '{@link #getDouble1() <em>Double1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble1()
   * @generated
   * @ordered
   */
  protected static final double DOUBLE1_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getDouble1() <em>Double1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble1()
   * @generated
   * @ordered
   */
  protected double double1 = DOUBLE1_EDEFAULT;

  /**
   * The default value of the '{@link #getDouble2() <em>Double2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble2()
   * @generated
   * @ordered
   */
  protected static final double DOUBLE2_EDEFAULT = 0.0;

  /**
   * The cached value of the '{@link #getDouble2() <em>Double2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDouble2()
   * @generated
   * @ordered
   */
  protected double double2 = DOUBLE2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OptionalDoubleImpl()
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
    return SequencertestPackage.Literals.OPTIONAL_DOUBLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getDouble0()
  {
    return double0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDouble0(double newDouble0)
  {
    double oldDouble0 = double0;
    double0 = newDouble0;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE0, oldDouble0, double0));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getDouble1()
  {
    return double1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDouble1(double newDouble1)
  {
    double oldDouble1 = double1;
    double1 = newDouble1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE1, oldDouble1, double1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public double getDouble2()
  {
    return double2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDouble2(double newDouble2)
  {
    double oldDouble2 = double2;
    double2 = newDouble2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE2, oldDouble2, double2));
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
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE0:
        return getDouble0();
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE1:
        return getDouble1();
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE2:
        return getDouble2();
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
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE0:
        setDouble0((Double)newValue);
        return;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE1:
        setDouble1((Double)newValue);
        return;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE2:
        setDouble2((Double)newValue);
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
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE0:
        setDouble0(DOUBLE0_EDEFAULT);
        return;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE1:
        setDouble1(DOUBLE1_EDEFAULT);
        return;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE2:
        setDouble2(DOUBLE2_EDEFAULT);
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
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE0:
        return double0 != DOUBLE0_EDEFAULT;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE1:
        return double1 != DOUBLE1_EDEFAULT;
      case SequencertestPackage.OPTIONAL_DOUBLE__DOUBLE2:
        return double2 != DOUBLE2_EDEFAULT;
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
    result.append(" (double0: ");
    result.append(double0);
    result.append(", double1: ");
    result.append(double1);
    result.append(", double2: ");
    result.append(double2);
    result.append(')');
    return result.toString();
  }

} //OptionalDoubleImpl
