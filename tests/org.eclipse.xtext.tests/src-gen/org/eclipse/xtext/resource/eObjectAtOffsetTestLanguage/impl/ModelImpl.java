/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo;
import org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl#getFoos <em>Foos</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl#getBars <em>Bars</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getFoos() <em>Foos</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFoos()
   * @generated
   * @ordered
   */
  protected EList<Foo> foos;

  /**
   * The cached value of the '{@link #getBars() <em>Bars</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBars()
   * @generated
   * @ordered
   */
  protected EList<AbstractBar> bars;

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
    return EObjectAtOffsetTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Foo> getFoos()
  {
    if (foos == null)
    {
      foos = new EObjectContainmentEList<Foo>(Foo.class, this, EObjectAtOffsetTestLanguagePackage.MODEL__FOOS);
    }
    return foos;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractBar> getBars()
  {
    if (bars == null)
    {
      bars = new EObjectContainmentEList<AbstractBar>(AbstractBar.class, this, EObjectAtOffsetTestLanguagePackage.MODEL__BARS);
    }
    return bars;
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
      case EObjectAtOffsetTestLanguagePackage.MODEL__FOOS:
        return ((InternalEList<?>)getFoos()).basicRemove(otherEnd, msgs);
      case EObjectAtOffsetTestLanguagePackage.MODEL__BARS:
        return ((InternalEList<?>)getBars()).basicRemove(otherEnd, msgs);
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
      case EObjectAtOffsetTestLanguagePackage.MODEL__FOOS:
        return getFoos();
      case EObjectAtOffsetTestLanguagePackage.MODEL__BARS:
        return getBars();
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
      case EObjectAtOffsetTestLanguagePackage.MODEL__FOOS:
        getFoos().clear();
        getFoos().addAll((Collection<? extends Foo>)newValue);
        return;
      case EObjectAtOffsetTestLanguagePackage.MODEL__BARS:
        getBars().clear();
        getBars().addAll((Collection<? extends AbstractBar>)newValue);
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
      case EObjectAtOffsetTestLanguagePackage.MODEL__FOOS:
        getFoos().clear();
        return;
      case EObjectAtOffsetTestLanguagePackage.MODEL__BARS:
        getBars().clear();
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
      case EObjectAtOffsetTestLanguagePackage.MODEL__FOOS:
        return foos != null && !foos.isEmpty();
      case EObjectAtOffsetTestLanguagePackage.MODEL__BARS:
        return bars != null && !bars.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
