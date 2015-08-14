/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.common.types.JvmType;

import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguagePackage;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl#getDefaultReference <em>Default Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceHolderImpl extends MinimalEObjectImpl.Container implements ReferenceHolder
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

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
    return RefactoringTestLanguagePackage.Literals.REFERENCE_HOLDER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringTestLanguagePackage.REFERENCE_HOLDER__NAME, oldName, name));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE, oldDefaultReference, defaultReference));
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
      eNotify(new ENotificationImpl(this, Notification.SET, RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE, oldDefaultReference, defaultReference));
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
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__NAME:
        return getName();
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        if (resolve) return getDefaultReference();
        return basicGetDefaultReference();
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
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__NAME:
        setName((String)newValue);
        return;
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        setDefaultReference((JvmType)newValue);
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
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        setDefaultReference((JvmType)null);
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
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER__DEFAULT_REFERENCE:
        return defaultReference != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ReferenceHolderImpl
