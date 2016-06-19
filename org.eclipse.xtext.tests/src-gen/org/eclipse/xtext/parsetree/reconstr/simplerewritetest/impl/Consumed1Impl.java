/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consumed1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl#getV1 <em>V1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Consumed1Impl#getV2 <em>V2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Consumed1Impl extends ExpressionImpl implements Consumed1
{
  /**
   * The cached value of the '{@link #getV1() <em>V1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getV1()
   * @generated
   * @ordered
   */
  protected EList<Integer> v1;

  /**
   * The cached value of the '{@link #getV2() <em>V2</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getV2()
   * @generated
   * @ordered
   */
  protected EList<String> v2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Consumed1Impl()
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
    return SimplerewritetestPackage.Literals.CONSUMED1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getV1()
  {
    if (v1 == null)
    {
      v1 = new EDataTypeEList<Integer>(Integer.class, this, SimplerewritetestPackage.CONSUMED1__V1);
    }
    return v1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getV2()
  {
    if (v2 == null)
    {
      v2 = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.CONSUMED1__V2);
    }
    return v2;
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
      case SimplerewritetestPackage.CONSUMED1__V1:
        return getV1();
      case SimplerewritetestPackage.CONSUMED1__V2:
        return getV2();
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
      case SimplerewritetestPackage.CONSUMED1__V1:
        getV1().clear();
        getV1().addAll((Collection<? extends Integer>)newValue);
        return;
      case SimplerewritetestPackage.CONSUMED1__V2:
        getV2().clear();
        getV2().addAll((Collection<? extends String>)newValue);
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
      case SimplerewritetestPackage.CONSUMED1__V1:
        getV1().clear();
        return;
      case SimplerewritetestPackage.CONSUMED1__V2:
        getV2().clear();
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
      case SimplerewritetestPackage.CONSUMED1__V1:
        return v1 != null && !v1.isEmpty();
      case SimplerewritetestPackage.CONSUMED1__V2:
        return v2 != null && !v2.isEmpty();
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
    result.append(" (v1: ");
    result.append(v1);
    result.append(", v2: ");
    result.append(v2);
    result.append(')');
    return result.toString();
  }

} //Consumed1Impl
