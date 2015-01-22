/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Many Strings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl#getStr1 <em>Str1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.ManyStringsImpl#getStr2 <em>Str2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ManyStringsImpl extends ExpressionImpl implements ManyStrings
{
  /**
   * The cached value of the '{@link #getStr1() <em>Str1</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStr1()
   * @generated
   * @ordered
   */
  protected EList<String> str1;

  /**
   * The cached value of the '{@link #getStr2() <em>Str2</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStr2()
   * @generated
   * @ordered
   */
  protected EList<String> str2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ManyStringsImpl()
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
    return SimplerewritetestPackage.Literals.MANY_STRINGS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStr1()
  {
    if (str1 == null)
    {
      str1 = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.MANY_STRINGS__STR1);
    }
    return str1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStr2()
  {
    if (str2 == null)
    {
      str2 = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.MANY_STRINGS__STR2);
    }
    return str2;
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
      case SimplerewritetestPackage.MANY_STRINGS__STR1:
        return getStr1();
      case SimplerewritetestPackage.MANY_STRINGS__STR2:
        return getStr2();
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
      case SimplerewritetestPackage.MANY_STRINGS__STR1:
        getStr1().clear();
        getStr1().addAll((Collection<? extends String>)newValue);
        return;
      case SimplerewritetestPackage.MANY_STRINGS__STR2:
        getStr2().clear();
        getStr2().addAll((Collection<? extends String>)newValue);
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
      case SimplerewritetestPackage.MANY_STRINGS__STR1:
        getStr1().clear();
        return;
      case SimplerewritetestPackage.MANY_STRINGS__STR2:
        getStr2().clear();
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
      case SimplerewritetestPackage.MANY_STRINGS__STR1:
        return str1 != null && !str1.isEmpty();
      case SimplerewritetestPackage.MANY_STRINGS__STR2:
        return str2 != null && !str2.isEmpty();
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
    result.append(" (str1: ");
    result.append(str1);
    result.append(", str2: ");
    result.append(str2);
    result.append(')');
    return result.toString();
  }

} //ManyStringsImpl
