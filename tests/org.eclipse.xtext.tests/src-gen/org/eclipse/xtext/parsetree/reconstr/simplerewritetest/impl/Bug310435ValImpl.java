/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bug310435 Val</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl.Bug310435ValImpl#getLits <em>Lits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Bug310435ValImpl extends ExpressionImpl implements Bug310435Val
{
  /**
   * The cached value of the '{@link #getLits() <em>Lits</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLits()
   * @generated
   * @ordered
   */
  protected EList<String> lits;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Bug310435ValImpl()
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
    return SimplerewritetestPackage.Literals.BUG310435_VAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getLits()
  {
    if (lits == null)
    {
      lits = new EDataTypeEList<String>(String.class, this, SimplerewritetestPackage.BUG310435_VAL__LITS);
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
      case SimplerewritetestPackage.BUG310435_VAL__LITS:
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
      case SimplerewritetestPackage.BUG310435_VAL__LITS:
        getLits().clear();
        getLits().addAll((Collection<? extends String>)newValue);
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
      case SimplerewritetestPackage.BUG310435_VAL__LITS:
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
      case SimplerewritetestPackage.BUG310435_VAL__LITS:
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

} //Bug310435ValImpl
