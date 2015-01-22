/**
 */
package org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelImpl#getModelFeatures <em>Model Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getModelFeatures() <em>Model Features</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModelFeatures()
   * @generated
   * @ordered
   */
  protected ModelFeatures modelFeatures;

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
    return UnassignedRuleCallTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelFeatures getModelFeatures()
  {
    return modelFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModelFeatures(ModelFeatures newModelFeatures, NotificationChain msgs)
  {
    ModelFeatures oldModelFeatures = modelFeatures;
    modelFeatures = newModelFeatures;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES, oldModelFeatures, newModelFeatures);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModelFeatures(ModelFeatures newModelFeatures)
  {
    if (newModelFeatures != modelFeatures)
    {
      NotificationChain msgs = null;
      if (modelFeatures != null)
        msgs = ((InternalEObject)modelFeatures).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES, null, msgs);
      if (newModelFeatures != null)
        msgs = ((InternalEObject)newModelFeatures).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES, null, msgs);
      msgs = basicSetModelFeatures(newModelFeatures, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES, newModelFeatures, newModelFeatures));
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
      case UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES:
        return basicSetModelFeatures(null, msgs);
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
      case UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES:
        return getModelFeatures();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES:
        setModelFeatures((ModelFeatures)newValue);
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
      case UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES:
        setModelFeatures((ModelFeatures)null);
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
      case UnassignedRuleCallTestLanguagePackage.MODEL__MODEL_FEATURES:
        return modelFeatures != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
