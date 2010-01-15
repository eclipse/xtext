/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package;
import org.eclipse.xtext.parsetree.reconstr.bug299395.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getUnused <em>Unused</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getUnused() <em>Unused</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnused()
   * @generated
   * @ordered
   */
  protected EList<String> unused;

  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected EList<String> key;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected EList<String> value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return Bug299395Package.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getUnused()
  {
    if (unused == null)
    {
      unused = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__UNUSED);
    }
    return unused;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getKey()
  {
    if (key == null)
    {
      key = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__KEY);
    }
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getValue()
  {
    if (value == null)
    {
      value = new EDataTypeEList<String>(String.class, this, Bug299395Package.MODEL__VALUE);
    }
    return value;
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
      case Bug299395Package.MODEL__UNUSED:
        return getUnused();
      case Bug299395Package.MODEL__KEY:
        return getKey();
      case Bug299395Package.MODEL__VALUE:
        return getValue();
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
      case Bug299395Package.MODEL__UNUSED:
        getUnused().clear();
        getUnused().addAll((Collection<? extends String>)newValue);
        return;
      case Bug299395Package.MODEL__KEY:
        getKey().clear();
        getKey().addAll((Collection<? extends String>)newValue);
        return;
      case Bug299395Package.MODEL__VALUE:
        getValue().clear();
        getValue().addAll((Collection<? extends String>)newValue);
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
      case Bug299395Package.MODEL__UNUSED:
        getUnused().clear();
        return;
      case Bug299395Package.MODEL__KEY:
        getKey().clear();
        return;
      case Bug299395Package.MODEL__VALUE:
        getValue().clear();
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
      case Bug299395Package.MODEL__UNUSED:
        return unused != null && !unused.isEmpty();
      case Bug299395Package.MODEL__KEY:
        return key != null && !key.isEmpty();
      case Bug299395Package.MODEL__VALUE:
        return value != null && !value.isEmpty();
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
    result.append(" (unused: ");
    result.append(unused);
    result.append(", key: ");
    result.append(key);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
