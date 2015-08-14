/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ModelImpl#getReferenceHolder <em>Reference Holder</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getReferenceHolder() <em>Reference Holder</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceHolder()
   * @generated
   * @ordered
   */
  protected EList<ReferenceHolder> referenceHolder;

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
    return RefactoringTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReferenceHolder> getReferenceHolder()
  {
    if (referenceHolder == null)
    {
      referenceHolder = new EObjectContainmentEList<ReferenceHolder>(ReferenceHolder.class, this, RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER);
    }
    return referenceHolder;
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
      case RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        return ((InternalEList<?>)getReferenceHolder()).basicRemove(otherEnd, msgs);
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
      case RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        return getReferenceHolder();
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
      case RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        getReferenceHolder().clear();
        getReferenceHolder().addAll((Collection<? extends ReferenceHolder>)newValue);
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
      case RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        getReferenceHolder().clear();
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
      case RefactoringTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        return referenceHolder != null && !referenceHolder.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
