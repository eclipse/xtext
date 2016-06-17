/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList;
import org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestListImpl#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestListImpl extends RootImpl implements TestList
{
  /**
   * The cached value of the '{@link #getItem() <em>Item</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItem()
   * @generated
   * @ordered
   */
  protected EList<Integer> item;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestListImpl()
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
    return TransientvaluestestPackage.Literals.TEST_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Integer> getItem()
  {
    if (item == null)
    {
      item = new EDataTypeEList<Integer>(Integer.class, this, TransientvaluestestPackage.TEST_LIST__ITEM);
    }
    return item;
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
      case TransientvaluestestPackage.TEST_LIST__ITEM:
        return getItem();
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
      case TransientvaluestestPackage.TEST_LIST__ITEM:
        getItem().clear();
        getItem().addAll((Collection<? extends Integer>)newValue);
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
      case TransientvaluestestPackage.TEST_LIST__ITEM:
        getItem().clear();
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
      case TransientvaluestestPackage.TEST_LIST__ITEM:
        return item != null && !item.isEmpty();
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
    result.append(" (item: ");
    result.append(item);
    result.append(')');
    return result.toString();
  }

} //TestListImpl
