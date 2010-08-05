/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl;

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

import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl#getReferenceHolder <em>Reference Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<Import> imports;

  /**
   * The cached value of the '{@link #getReferenceHolder() <em>Reference Holder</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceHolder()
   * @generated
   * @ordered
   */
  protected ReferenceHolder referenceHolder;

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
    return ContentAssistTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Import> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<Import>(Import.class, this, ContentAssistTestLanguagePackage.MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceHolder getReferenceHolder()
  {
    return referenceHolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReferenceHolder(ReferenceHolder newReferenceHolder, NotificationChain msgs)
  {
    ReferenceHolder oldReferenceHolder = referenceHolder;
    referenceHolder = newReferenceHolder;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER, oldReferenceHolder, newReferenceHolder);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceHolder(ReferenceHolder newReferenceHolder)
  {
    if (newReferenceHolder != referenceHolder)
    {
      NotificationChain msgs = null;
      if (referenceHolder != null)
        msgs = ((InternalEObject)referenceHolder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER, null, msgs);
      if (newReferenceHolder != null)
        msgs = ((InternalEObject)newReferenceHolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER, null, msgs);
      msgs = basicSetReferenceHolder(newReferenceHolder, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER, newReferenceHolder, newReferenceHolder));
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
      case ContentAssistTestLanguagePackage.MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        return basicSetReferenceHolder(null, msgs);
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
      case ContentAssistTestLanguagePackage.MODEL__IMPORTS:
        return getImports();
      case ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER:
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
      case ContentAssistTestLanguagePackage.MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        setReferenceHolder((ReferenceHolder)newValue);
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
      case ContentAssistTestLanguagePackage.MODEL__IMPORTS:
        getImports().clear();
        return;
      case ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        setReferenceHolder((ReferenceHolder)null);
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
      case ContentAssistTestLanguagePackage.MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case ContentAssistTestLanguagePackage.MODEL__REFERENCE_HOLDER:
        return referenceHolder != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
