/**
 */
package org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguagePackage;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum;
import org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model;

import org.eclipse.xtext.enumrules.enums.ExistingEnum;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl#getExisting <em>Existing</em>}</li>
 *   <li>{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl#getGenerated <em>Generated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The default value of the '{@link #getExisting() <em>Existing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExisting()
   * @generated
   * @ordered
   */
  protected static final ExistingEnum EXISTING_EDEFAULT = ExistingEnum.SAME_NAME;

  /**
   * The cached value of the '{@link #getExisting() <em>Existing</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExisting()
   * @generated
   * @ordered
   */
  protected ExistingEnum existing = EXISTING_EDEFAULT;

  /**
   * The default value of the '{@link #getGenerated() <em>Generated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerated()
   * @generated
   * @ordered
   */
  protected static final GeneratedEnum GENERATED_EDEFAULT = GeneratedEnum.SAME_NAME;

  /**
   * The cached value of the '{@link #getGenerated() <em>Generated</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGenerated()
   * @generated
   * @ordered
   */
  protected GeneratedEnum generated = GENERATED_EDEFAULT;

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
    return EnumRulesTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExistingEnum getExisting()
  {
    return existing;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExisting(ExistingEnum newExisting)
  {
    ExistingEnum oldExisting = existing;
    existing = newExisting == null ? EXISTING_EDEFAULT : newExisting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EnumRulesTestLanguagePackage.MODEL__EXISTING, oldExisting, existing));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneratedEnum getGenerated()
  {
    return generated;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGenerated(GeneratedEnum newGenerated)
  {
    GeneratedEnum oldGenerated = generated;
    generated = newGenerated == null ? GENERATED_EDEFAULT : newGenerated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EnumRulesTestLanguagePackage.MODEL__GENERATED, oldGenerated, generated));
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
      case EnumRulesTestLanguagePackage.MODEL__EXISTING:
        return getExisting();
      case EnumRulesTestLanguagePackage.MODEL__GENERATED:
        return getGenerated();
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
      case EnumRulesTestLanguagePackage.MODEL__EXISTING:
        setExisting((ExistingEnum)newValue);
        return;
      case EnumRulesTestLanguagePackage.MODEL__GENERATED:
        setGenerated((GeneratedEnum)newValue);
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
      case EnumRulesTestLanguagePackage.MODEL__EXISTING:
        setExisting(EXISTING_EDEFAULT);
        return;
      case EnumRulesTestLanguagePackage.MODEL__GENERATED:
        setGenerated(GENERATED_EDEFAULT);
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
      case EnumRulesTestLanguagePackage.MODEL__EXISTING:
        return existing != EXISTING_EDEFAULT;
      case EnumRulesTestLanguagePackage.MODEL__GENERATED:
        return generated != GENERATED_EDEFAULT;
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
    result.append(" (existing: ");
    result.append(existing);
    result.append(", generated: ");
    result.append(generated);
    result.append(')');
    return result.toString();
  }

} //ModelImpl
