/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Combination4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Combination4Impl#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Combination4Impl#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.impl.Combination4Impl#getVal3 <em>Val3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Combination4Impl extends MinimalEObjectImpl.Container implements Combination4
{
  /**
   * The cached value of the '{@link #getVal1() <em>Val1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal1()
   * @generated
   * @ordered
   */
  protected EList<String> val1;

  /**
   * The cached value of the '{@link #getVal2() <em>Val2</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVal2()
   * @generated
   * @ordered
   */
  protected EList<String> val2;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Combination4Impl()
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
    return CsvalidationtestPackage.Literals.COMBINATION4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal1()
  {
    if (val1 == null)
    {
      val1 = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.COMBINATION4__VAL1);
    }
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getVal2()
  {
    if (val2 == null)
    {
      val2 = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.COMBINATION4__VAL2);
    }
    return val2;
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
      val3 = new EDataTypeEList<String>(String.class, this, CsvalidationtestPackage.COMBINATION4__VAL3);
    }
    return val3;
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
      case CsvalidationtestPackage.COMBINATION4__VAL1:
        return getVal1();
      case CsvalidationtestPackage.COMBINATION4__VAL2:
        return getVal2();
      case CsvalidationtestPackage.COMBINATION4__VAL3:
        return getVal3();
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
      case CsvalidationtestPackage.COMBINATION4__VAL1:
        getVal1().clear();
        getVal1().addAll((Collection<? extends String>)newValue);
        return;
      case CsvalidationtestPackage.COMBINATION4__VAL2:
        getVal2().clear();
        getVal2().addAll((Collection<? extends String>)newValue);
        return;
      case CsvalidationtestPackage.COMBINATION4__VAL3:
        getVal3().clear();
        getVal3().addAll((Collection<? extends String>)newValue);
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
      case CsvalidationtestPackage.COMBINATION4__VAL1:
        getVal1().clear();
        return;
      case CsvalidationtestPackage.COMBINATION4__VAL2:
        getVal2().clear();
        return;
      case CsvalidationtestPackage.COMBINATION4__VAL3:
        getVal3().clear();
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
      case CsvalidationtestPackage.COMBINATION4__VAL1:
        return val1 != null && !val1.isEmpty();
      case CsvalidationtestPackage.COMBINATION4__VAL2:
        return val2 != null && !val2.isEmpty();
      case CsvalidationtestPackage.COMBINATION4__VAL3:
        return val3 != null && !val3.isEmpty();
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

} //Combination4Impl
