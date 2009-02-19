/**
 * <copyright>
 * </copyright>
 *
 * $Id: EcoreDslImpl.java,v 1.4 2009/02/19 14:38:38 sefftinge Exp $
 */
package org.eclipse.xtext.example.ecoredsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.example.ecoredsl.EcoreDsl;
import org.eclipse.xtext.example.ecoredsl.EcoredslPackage;
import org.eclipse.xtext.example.ecoredsl.ImportStatementDecl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ecore Dsl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EcoreDslImpl extends EObjectImpl implements EcoreDsl
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<ImportStatementDecl> imports;

  /**
   * The cached value of the '{@link #getPackage() <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackage()
   * @generated
   * @ordered
   */
  protected EPackage package_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EcoreDslImpl()
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
    return EcoredslPackage.Literals.ECORE_DSL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ImportStatementDecl> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<ImportStatementDecl>(ImportStatementDecl.class, this, EcoredslPackage.ECORE_DSL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage getPackage()
  {
    return package_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(EPackage newPackage, NotificationChain msgs)
  {
    EPackage oldPackage = package_;
    package_ = newPackage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcoredslPackage.ECORE_DSL__PACKAGE, oldPackage, newPackage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(EPackage newPackage)
  {
    if (newPackage != package_)
    {
      NotificationChain msgs = null;
      if (package_ != null)
        msgs = ((InternalEObject)package_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcoredslPackage.ECORE_DSL__PACKAGE, null, msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcoredslPackage.ECORE_DSL__PACKAGE, null, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcoredslPackage.ECORE_DSL__PACKAGE, newPackage, newPackage));
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
      case EcoredslPackage.ECORE_DSL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case EcoredslPackage.ECORE_DSL__PACKAGE:
        return basicSetPackage(null, msgs);
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
      case EcoredslPackage.ECORE_DSL__IMPORTS:
        return getImports();
      case EcoredslPackage.ECORE_DSL__PACKAGE:
        return getPackage();
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
      case EcoredslPackage.ECORE_DSL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends ImportStatementDecl>)newValue);
        return;
      case EcoredslPackage.ECORE_DSL__PACKAGE:
        setPackage((EPackage)newValue);
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
      case EcoredslPackage.ECORE_DSL__IMPORTS:
        getImports().clear();
        return;
      case EcoredslPackage.ECORE_DSL__PACKAGE:
        setPackage((EPackage)null);
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
      case EcoredslPackage.ECORE_DSL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case EcoredslPackage.ECORE_DSL__PACKAGE:
        return package_ != null;
    }
    return super.eIsSet(featureID);
  }

} //EcoreDslImpl
