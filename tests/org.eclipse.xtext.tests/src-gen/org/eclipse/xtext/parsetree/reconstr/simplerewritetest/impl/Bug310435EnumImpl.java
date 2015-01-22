/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bug310435 Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435EnumImpl#getLits <em>Lits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Bug310435EnumImpl extends ExpressionImpl implements Bug310435Enum
{
  /**
   * The cached value of the '{@link #getLits() <em>Lits</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLits()
   * @generated
   * @ordered
   */
  protected EList<EnumBug310435Enum> lits;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Bug310435EnumImpl()
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
    return SimplerewritetestPackage.Literals.BUG310435_ENUM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumBug310435Enum> getLits()
  {
    if (lits == null)
    {
      lits = new EDataTypeEList<EnumBug310435Enum>(EnumBug310435Enum.class, this, SimplerewritetestPackage.BUG310435_ENUM__LITS);
    }
    return lits;
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
      case SimplerewritetestPackage.BUG310435_ENUM__LITS:
        return getLits();
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
      case SimplerewritetestPackage.BUG310435_ENUM__LITS:
        getLits().clear();
        getLits().addAll((Collection<? extends EnumBug310435Enum>)newValue);
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
      case SimplerewritetestPackage.BUG310435_ENUM__LITS:
        getLits().clear();
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
      case SimplerewritetestPackage.BUG310435_ENUM__LITS:
        return lits != null && !lits.isEmpty();
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
    result.append(" (lits: ");
    result.append(lits);
    result.append(')');
    return result.toString();
  }

} //Bug310435EnumImpl
