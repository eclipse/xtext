/**
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package;
import org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.SubModelImpl#getStrings <em>Strings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SubModelImpl extends MinimalEObjectImpl.Container implements SubModel
{
  /**
   * The cached value of the '{@link #getStrings() <em>Strings</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStrings()
   * @generated
   * @ordered
   */
  protected EList<String> strings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubModelImpl()
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
    return Bug299395Package.Literals.SUB_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStrings()
  {
    if (strings == null)
    {
      strings = new EDataTypeEList<String>(String.class, this, Bug299395Package.SUB_MODEL__STRINGS);
    }
    return strings;
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
      case Bug299395Package.SUB_MODEL__STRINGS:
        return getStrings();
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
      case Bug299395Package.SUB_MODEL__STRINGS:
        getStrings().clear();
        getStrings().addAll((Collection<? extends String>)newValue);
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
      case Bug299395Package.SUB_MODEL__STRINGS:
        getStrings().clear();
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
      case Bug299395Package.SUB_MODEL__STRINGS:
        return strings != null && !strings.isEmpty();
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
    result.append(" (strings: ");
    result.append(strings);
    result.append(')');
    return result.toString();
  }

} //SubModelImpl
