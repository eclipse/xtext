/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal4 <em>Val4</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal5 <em>Val5</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.impl.Complex1Impl#getVal6 <em>Val6</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Complex1Impl extends MinimalEObjectImpl.Container implements Complex1
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
  protected static final String VAL2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected String val2 = VAL2_EDEFAULT;

  /**
   * The cached value of the '{@link #getVal3() <em>Val3</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal3()
   * @generated
   * @ordered
   */
  protected EList<String> val3;

  /**
   * The cached value of the '{@link #getVal4() <em>Val4</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal4()
   * @generated
   * @ordered
   */
  protected EList<String> val4;

  /**
   * The cached value of the '{@link #getVal5() <em>Val5</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal5()
   * @generated
   * @ordered
   */
  protected EList<String> val5;

  /**
   * The cached value of the '{@link #getVal6() <em>Val6</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal6()
   * @generated
   * @ordered
   */
  protected EList<String> val6;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Complex1Impl()
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
    return SequencertestPackage.Literals.COMPLEX1;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.COMPLEX1__VAL1, oldVal1, val1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVal2()
  {
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVal2(String newVal2)
  {
    String oldVal2 = val2;
    val2 = newVal2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SequencertestPackage.COMPLEX1__VAL2, oldVal2, val2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal3()
  {
    if (val3 == null)
    {
      val3 = new EDataTypeEList<String>(String.class, this, SequencertestPackage.COMPLEX1__VAL3);
    }
    return val3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal4()
  {
    if (val4 == null)
    {
      val4 = new EDataTypeEList<String>(String.class, this, SequencertestPackage.COMPLEX1__VAL4);
    }
    return val4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal5()
  {
    if (val5 == null)
    {
      val5 = new EDataTypeEList<String>(String.class, this, SequencertestPackage.COMPLEX1__VAL5);
    }
    return val5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal6()
  {
    if (val6 == null)
    {
      val6 = new EDataTypeEList<String>(String.class, this, SequencertestPackage.COMPLEX1__VAL6);
    }
    return val6;
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
      case SequencertestPackage.COMPLEX1__VAL1:
        return getVal1();
      case SequencertestPackage.COMPLEX1__VAL2:
        return getVal2();
      case SequencertestPackage.COMPLEX1__VAL3:
        return getVal3();
      case SequencertestPackage.COMPLEX1__VAL4:
        return getVal4();
      case SequencertestPackage.COMPLEX1__VAL5:
        return getVal5();
      case SequencertestPackage.COMPLEX1__VAL6:
        return getVal6();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SequencertestPackage.COMPLEX1__VAL1:
        setVal1((String)newValue);
        return;
      case SequencertestPackage.COMPLEX1__VAL2:
        setVal2((String)newValue);
        return;
      case SequencertestPackage.COMPLEX1__VAL3:
        getVal3().clear();
        getVal3().addAll((Collection<? extends String>)newValue);
        return;
      case SequencertestPackage.COMPLEX1__VAL4:
        getVal4().clear();
        getVal4().addAll((Collection<? extends String>)newValue);
        return;
      case SequencertestPackage.COMPLEX1__VAL5:
        getVal5().clear();
        getVal5().addAll((Collection<? extends String>)newValue);
        return;
      case SequencertestPackage.COMPLEX1__VAL6:
        getVal6().clear();
        getVal6().addAll((Collection<? extends String>)newValue);
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
      case SequencertestPackage.COMPLEX1__VAL1:
        setVal1(VAL1_EDEFAULT);
        return;
      case SequencertestPackage.COMPLEX1__VAL2:
        setVal2(VAL2_EDEFAULT);
        return;
      case SequencertestPackage.COMPLEX1__VAL3:
        getVal3().clear();
        return;
      case SequencertestPackage.COMPLEX1__VAL4:
        getVal4().clear();
        return;
      case SequencertestPackage.COMPLEX1__VAL5:
        getVal5().clear();
        return;
      case SequencertestPackage.COMPLEX1__VAL6:
        getVal6().clear();
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
      case SequencertestPackage.COMPLEX1__VAL1:
        return VAL1_EDEFAULT == null ? val1 != null : !VAL1_EDEFAULT.equals(val1);
      case SequencertestPackage.COMPLEX1__VAL2:
        return VAL2_EDEFAULT == null ? val2 != null : !VAL2_EDEFAULT.equals(val2);
      case SequencertestPackage.COMPLEX1__VAL3:
        return val3 != null && !val3.isEmpty();
      case SequencertestPackage.COMPLEX1__VAL4:
        return val4 != null && !val4.isEmpty();
      case SequencertestPackage.COMPLEX1__VAL5:
        return val5 != null && !val5.isEmpty();
      case SequencertestPackage.COMPLEX1__VAL6:
        return val6 != null && !val6.isEmpty();
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
    result.append(", val4: ");
    result.append(val4);
    result.append(", val5: ");
    result.append(val5);
    result.append(", val6: ");
    result.append(val6);
    result.append(')');
    return result.toString();
  }

} //Complex1Impl
