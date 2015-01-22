/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object New</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl#getImpFrag <em>Imp Frag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectNewImpl extends CreatedObjectImpl implements ObjectNew
{
  /**
   * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImport()
   * @generated
   * @ordered
   */
  protected Import import_;

  /**
   * The default value of the '{@link #getImpFrag() <em>Imp Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpFrag()
   * @generated
   * @ordered
   */
  protected static final String IMP_FRAG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImpFrag() <em>Imp Frag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpFrag()
   * @generated
   * @ordered
   */
  protected String impFrag = IMP_FRAG_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ObjectNewImpl()
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
    return EpatchTestLanguagePackage.Literals.OBJECT_NEW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import getImport()
  {
    if (import_ != null && import_.eIsProxy())
    {
      InternalEObject oldImport = (InternalEObject)import_;
      import_ = (Import)eResolveProxy(oldImport);
      if (import_ != oldImport)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EpatchTestLanguagePackage.OBJECT_NEW__IMPORT, oldImport, import_));
      }
    }
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import basicGetImport()
  {
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImport(Import newImport)
  {
    Import oldImport = import_;
    import_ = newImport;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.OBJECT_NEW__IMPORT, oldImport, import_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImpFrag()
  {
    return impFrag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImpFrag(String newImpFrag)
  {
    String oldImpFrag = impFrag;
    impFrag = newImpFrag;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.OBJECT_NEW__IMP_FRAG, oldImpFrag, impFrag));
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
      case EpatchTestLanguagePackage.OBJECT_NEW__IMPORT:
        if (resolve) return getImport();
        return basicGetImport();
      case EpatchTestLanguagePackage.OBJECT_NEW__IMP_FRAG:
        return getImpFrag();
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
      case EpatchTestLanguagePackage.OBJECT_NEW__IMPORT:
        setImport((Import)newValue);
        return;
      case EpatchTestLanguagePackage.OBJECT_NEW__IMP_FRAG:
        setImpFrag((String)newValue);
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
      case EpatchTestLanguagePackage.OBJECT_NEW__IMPORT:
        setImport((Import)null);
        return;
      case EpatchTestLanguagePackage.OBJECT_NEW__IMP_FRAG:
        setImpFrag(IMP_FRAG_EDEFAULT);
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
      case EpatchTestLanguagePackage.OBJECT_NEW__IMPORT:
        return import_ != null;
      case EpatchTestLanguagePackage.OBJECT_NEW__IMP_FRAG:
        return IMP_FRAG_EDEFAULT == null ? impFrag != null : !IMP_FRAG_EDEFAULT.equals(impFrag);
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
    result.append(" (impFrag: ");
    result.append(impFrag);
    result.append(')');
    return result.toString();
  }

} //ObjectNewImpl
