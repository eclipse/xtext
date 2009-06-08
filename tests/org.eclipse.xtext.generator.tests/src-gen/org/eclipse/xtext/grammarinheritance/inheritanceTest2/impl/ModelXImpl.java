/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.grammarinheritance.inheritanceTest.impl.ElementImpl;

import org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package;
import org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model X</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl#getElements2 <em>Elements2</em>}</li>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl#getIds <em>Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelXImpl extends ElementImpl implements ModelX
{
  /**
   * The cached value of the '{@link #getElements2() <em>Elements2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements2()
   * @generated
   * @ordered
   */
  protected EList<ModelX> elements2;

  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected EList<String> ids;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelXImpl()
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
    return InheritanceTest2Package.Literals.MODEL_X;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModelX> getElements2()
  {
    if (elements2 == null)
    {
      elements2 = new EObjectContainmentEList<ModelX>(ModelX.class, this, InheritanceTest2Package.MODEL_X__ELEMENTS2);
    }
    return elements2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIds()
  {
    if (ids == null)
    {
      ids = new EDataTypeEList<String>(String.class, this, InheritanceTest2Package.MODEL_X__IDS);
    }
    return ids;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case InheritanceTest2Package.MODEL_X__ELEMENTS2:
        return ((InternalEList<?>)getElements2()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case InheritanceTest2Package.MODEL_X__ELEMENTS2:
        return getElements2();
      case InheritanceTest2Package.MODEL_X__IDS:
        return getIds();
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
      case InheritanceTest2Package.MODEL_X__ELEMENTS2:
        getElements2().clear();
        getElements2().addAll((Collection<? extends ModelX>)newValue);
        return;
      case InheritanceTest2Package.MODEL_X__IDS:
        getIds().clear();
        getIds().addAll((Collection<? extends String>)newValue);
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
      case InheritanceTest2Package.MODEL_X__ELEMENTS2:
        getElements2().clear();
        return;
      case InheritanceTest2Package.MODEL_X__IDS:
        getIds().clear();
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
      case InheritanceTest2Package.MODEL_X__ELEMENTS2:
        return elements2 != null && !elements2.isEmpty();
      case InheritanceTest2Package.MODEL_X__IDS:
        return ids != null && !ids.isEmpty();
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
    result.append(" (ids: ");
    result.append(ids);
    result.append(')');
    return result.toString();
  }

} //ModelXImpl
