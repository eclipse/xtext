/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Select Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl#getSelect <em>Select</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.SelectEntryImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectEntryImpl extends MinimalEObjectImpl.Container implements SelectEntry
{
  /**
   * The cached value of the '{@link #getSelect() <em>Select</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelect()
   * @generated
   * @ordered
   */
  protected FromEntry select;

  /**
   * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttribute()
   * @generated
   * @ordered
   */
  protected EAttribute attribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectEntryImpl()
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
    return Bug287941TestLanguagePackage.Literals.SELECT_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getSelect()
  {
    if (select != null && select.eIsProxy())
    {
      InternalEObject oldSelect = (InternalEObject)select;
      select = (FromEntry)eResolveProxy(oldSelect);
      if (select != oldSelect)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT, oldSelect, select));
      }
    }
    return select;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetSelect()
  {
    return select;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelect(FromEntry newSelect)
  {
    FromEntry oldSelect = select;
    select = newSelect;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT, oldSelect, select));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute()
  {
    if (attribute != null && attribute.eIsProxy())
    {
      InternalEObject oldAttribute = (InternalEObject)attribute;
      attribute = (EAttribute)eResolveProxy(oldAttribute);
      if (attribute != oldAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE, oldAttribute, attribute));
      }
    }
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetAttribute()
  {
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttribute(EAttribute newAttribute)
  {
    EAttribute oldAttribute = attribute;
    attribute = newAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE, oldAttribute, attribute));
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
      case Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT:
        if (resolve) return getSelect();
        return basicGetSelect();
      case Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE:
        if (resolve) return getAttribute();
        return basicGetAttribute();
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
      case Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT:
        setSelect((FromEntry)newValue);
        return;
      case Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE:
        setAttribute((EAttribute)newValue);
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
      case Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT:
        setSelect((FromEntry)null);
        return;
      case Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE:
        setAttribute((EAttribute)null);
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
      case Bug287941TestLanguagePackage.SELECT_ENTRY__SELECT:
        return select != null;
      case Bug287941TestLanguagePackage.SELECT_ENTRY__ATTRIBUTE:
        return attribute != null;
    }
    return super.eIsSet(featureID);
  }

} //SelectEntryImpl
