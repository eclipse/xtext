/**
 */
package org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage;
import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.StartImpl#getFeatureA <em>Feature A</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartImpl extends MinimalEObjectImpl.Container implements Start
{
  /**
   * The cached value of the '{@link #getFeatureA() <em>Feature A</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureA()
   * @generated
   * @ordered
   */
  protected EList<String> featureA;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StartImpl()
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
    return MultiValueFeatureTestLanguagePackage.Literals.START;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFeatureA()
  {
    if (featureA == null)
    {
      featureA = new EDataTypeEList<String>(String.class, this, MultiValueFeatureTestLanguagePackage.START__FEATURE_A);
    }
    return featureA;
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
      case MultiValueFeatureTestLanguagePackage.START__FEATURE_A:
        return getFeatureA();
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
      case MultiValueFeatureTestLanguagePackage.START__FEATURE_A:
        getFeatureA().clear();
        getFeatureA().addAll((Collection<? extends String>)newValue);
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
      case MultiValueFeatureTestLanguagePackage.START__FEATURE_A:
        getFeatureA().clear();
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
      case MultiValueFeatureTestLanguagePackage.START__FEATURE_A:
        return featureA != null && !featureA.isEmpty();
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
    result.append(" (featureA: ");
    result.append(featureA);
    result.append(')');
    return result.toString();
  }

} //StartImpl
