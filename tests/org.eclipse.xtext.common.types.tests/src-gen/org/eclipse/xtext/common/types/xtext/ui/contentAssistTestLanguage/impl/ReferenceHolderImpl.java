/**
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmType;

import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl#getDefaultReference <em>Default Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl#getCustomizedReference <em>Customized Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl#getSubtypeReference <em>Subtype Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceHolderImpl extends MinimalEObjectImpl.Container implements ReferenceHolder
{
  /**
   * The cached value of the '{@link #getDefaultReference() <em>Default Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultReference()
   * @generated
   * @ordered
   */
  protected JvmType defaultReference;

  /**
   * The cached value of the '{@link #getCustomizedReference() <em>Customized Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCustomizedReference()
   * @generated
   * @ordered
   */
  protected JvmType customizedReference;

  /**
   * The cached value of the '{@link #getSubtypeReference() <em>Subtype Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubtypeReference()
   * @generated
   * @ordered
   */
  protected JvmType subtypeReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceHolderImpl()
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
    return ContentAssistTestLanguagePackage.Literals.REFERENCE_HOLDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getDefaultReference()
  {
    if (defaultReference != null && defaultReference.eIsProxy())
    {
      InternalEObject oldDefaultReference = (InternalEObject)defaultReference;
      defaultReference = (JvmType)eResolveProxy(oldDefaultReference);
      if (defaultReference != oldDefaultReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE, oldDefaultReference, defaultReference));
      }
    }
    return defaultReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetDefaultReference()
  {
    return defaultReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultReference(JvmType newDefaultReference)
  {
    JvmType oldDefaultReference = defaultReference;
    defaultReference = newDefaultReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE, oldDefaultReference, defaultReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getCustomizedReference()
  {
    if (customizedReference != null && customizedReference.eIsProxy())
    {
      InternalEObject oldCustomizedReference = (InternalEObject)customizedReference;
      customizedReference = (JvmType)eResolveProxy(oldCustomizedReference);
      if (customizedReference != oldCustomizedReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE, oldCustomizedReference, customizedReference));
      }
    }
    return customizedReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetCustomizedReference()
  {
    return customizedReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCustomizedReference(JvmType newCustomizedReference)
  {
    JvmType oldCustomizedReference = customizedReference;
    customizedReference = newCustomizedReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE, oldCustomizedReference, customizedReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getSubtypeReference()
  {
    if (subtypeReference != null && subtypeReference.eIsProxy())
    {
      InternalEObject oldSubtypeReference = (InternalEObject)subtypeReference;
      subtypeReference = (JvmType)eResolveProxy(oldSubtypeReference);
      if (subtypeReference != oldSubtypeReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE, oldSubtypeReference, subtypeReference));
      }
    }
    return subtypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetSubtypeReference()
  {
    return subtypeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubtypeReference(JvmType newSubtypeReference)
  {
    JvmType oldSubtypeReference = subtypeReference;
    subtypeReference = newSubtypeReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE, oldSubtypeReference, subtypeReference));
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
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        if (resolve) return getDefaultReference();
        return basicGetDefaultReference();
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE:
        if (resolve) return getCustomizedReference();
        return basicGetCustomizedReference();
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE:
        if (resolve) return getSubtypeReference();
        return basicGetSubtypeReference();
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
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        setDefaultReference((JvmType)newValue);
        return;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE:
        setCustomizedReference((JvmType)newValue);
        return;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE:
        setSubtypeReference((JvmType)newValue);
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
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        setDefaultReference((JvmType)null);
        return;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE:
        setCustomizedReference((JvmType)null);
        return;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE:
        setSubtypeReference((JvmType)null);
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
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        return defaultReference != null;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__CUSTOMIZED_REFERENCE:
        return customizedReference != null;
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER__SUBTYPE_REFERENCE:
        return subtypeReference != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceHolderImpl
