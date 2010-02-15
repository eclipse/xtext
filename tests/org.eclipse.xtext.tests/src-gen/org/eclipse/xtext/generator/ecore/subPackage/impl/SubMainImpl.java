/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.generator.ecore.subPackage.AnotherSuperMain;
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
 *   <li>{@link org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl#getAnother <em>Another</em>}</li>
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
   * The cached value of the '{@link #getAnother() <em>Another</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnother()
   * @generated
   * @ordered
   */
  protected AnotherSuperMain another;

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
  public AnotherSuperMain getAnother()
  {
    return another;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAnother(AnotherSuperMain newAnother, NotificationChain msgs)
  {
    AnotherSuperMain oldAnother = another;
    another = newAnother;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SubPackagePackage.SUB_MAIN__ANOTHER, oldAnother, newAnother);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnother(AnotherSuperMain newAnother)
  {
    if (newAnother != another)
    {
      NotificationChain msgs = null;
      if (another != null)
        msgs = ((InternalEObject)another).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SubPackagePackage.SUB_MAIN__ANOTHER, null, msgs);
      if (newAnother != null)
        msgs = ((InternalEObject)newAnother).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SubPackagePackage.SUB_MAIN__ANOTHER, null, msgs);
      msgs = basicSetAnother(newAnother, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SubPackagePackage.SUB_MAIN__ANOTHER, newAnother, newAnother));
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
      case SubPackagePackage.SUB_MAIN__ANOTHER:
        return basicSetAnother(null, msgs);
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
      case SubPackagePackage.SUB_MAIN__ANOTHER:
        return getAnother();
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
      case SubPackagePackage.SUB_MAIN__ANOTHER:
        setAnother((AnotherSuperMain)newValue);
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
      case SubPackagePackage.SUB_MAIN__ANOTHER:
        setAnother((AnotherSuperMain)null);
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
      case SubPackagePackage.SUB_MAIN__ANOTHER:
        return another != null;
    }
    return super.eIsSet(featureID);
  }

} //SubMainImpl
