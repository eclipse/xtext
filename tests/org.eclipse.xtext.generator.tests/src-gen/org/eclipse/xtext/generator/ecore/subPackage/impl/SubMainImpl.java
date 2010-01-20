/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.generator.ecore.subPackage.SubMain;
import org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage;

import org.eclipse.xtext.generator.ecore.superPackage.SuperMain;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl#getSuperMains <em>Super Mains</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubMainImpl extends MinimalEObjectImpl.Container implements SubMain
{
  /**
   * The cached value of the '{@link #getSuperMains() <em>Super Mains</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSuperMains()
   * @generated
   * @ordered
   */
  protected EList<SuperMain> superMains;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SubMainImpl()
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
    return SubPackagePackage.Literals.SUB_MAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuperMain> getSuperMains()
  {
    if (superMains == null)
    {
      superMains = new EObjectContainmentEList<SuperMain>(SuperMain.class, this, SubPackagePackage.SUB_MAIN__SUPER_MAINS);
    }
    return superMains;
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
      case SubPackagePackage.SUB_MAIN__SUPER_MAINS:
        return ((InternalEList<?>)getSuperMains()).basicRemove(otherEnd, msgs);
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
      case SubPackagePackage.SUB_MAIN__SUPER_MAINS:
        return getSuperMains();
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
      case SubPackagePackage.SUB_MAIN__SUPER_MAINS:
        getSuperMains().clear();
        getSuperMains().addAll((Collection<? extends SuperMain>)newValue);
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
      case SubPackagePackage.SUB_MAIN__SUPER_MAINS:
        getSuperMains().clear();
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
      case SubPackagePackage.SUB_MAIN__SUPER_MAINS:
        return superMains != null && !superMains.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SubMainImpl
