/**
 */
package org.eclipse.xtext.ui.tests.refactoring.referring.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.refactoring.referring.Main;
import org.eclipse.xtext.ui.tests.refactoring.referring.Reference;
import org.eclipse.xtext.ui.tests.refactoring.referring.ReferringPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.MainImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainImpl extends MinimalEObjectImpl.Container implements Main
{
  /**
   * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenced()
   * @generated
   * @ordered
   */
  protected EList<Reference> referenced;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MainImpl()
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
    return ReferringPackage.Literals.MAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Reference> getReferenced()
  {
    if (referenced == null)
    {
      referenced = new EObjectContainmentEList<Reference>(Reference.class, this, ReferringPackage.MAIN__REFERENCED);
    }
    return referenced;
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
      case ReferringPackage.MAIN__REFERENCED:
        return ((InternalEList<?>)getReferenced()).basicRemove(otherEnd, msgs);
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
      case ReferringPackage.MAIN__REFERENCED:
        return getReferenced();
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
      case ReferringPackage.MAIN__REFERENCED:
        getReferenced().clear();
        getReferenced().addAll((Collection<? extends Reference>)newValue);
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
      case ReferringPackage.MAIN__REFERENCED:
        getReferenced().clear();
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
      case ReferringPackage.MAIN__REFERENCED:
        return referenced != null && !referenced.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MainImpl
