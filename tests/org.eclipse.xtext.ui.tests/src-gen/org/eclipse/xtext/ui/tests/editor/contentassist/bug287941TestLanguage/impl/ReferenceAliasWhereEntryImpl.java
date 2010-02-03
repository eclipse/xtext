/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.FromEntry;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.ReferenceAliasWhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Alias Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug287941TestLanguage.impl.ReferenceAliasWhereEntryImpl#getRightAlias <em>Right Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceAliasWhereEntryImpl extends WhereEntryImpl implements ReferenceAliasWhereEntry
{
  /**
   * The cached value of the '{@link #getAlias() <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlias()
   * @generated
   * @ordered
   */
  protected FromEntry alias;

  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected EReference reference;

  /**
   * The cached value of the '{@link #getRightAlias() <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightAlias()
   * @generated
   * @ordered
   */
  protected FromEntry rightAlias;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceAliasWhereEntryImpl()
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
    return Bug287941TestLanguagePackage.Literals.REFERENCE_ALIAS_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getAlias()
  {
    if (alias != null && alias.eIsProxy())
    {
      InternalEObject oldAlias = (InternalEObject)alias;
      alias = (FromEntry)eResolveProxy(oldAlias);
      if (alias != oldAlias)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS, oldAlias, alias));
      }
    }
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetAlias()
  {
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlias(FromEntry newAlias)
  {
    FromEntry oldAlias = alias;
    alias = newAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS, oldAlias, alias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReference()
  {
    if (reference != null && reference.eIsProxy())
    {
      InternalEObject oldReference = (InternalEObject)reference;
      reference = (EReference)eResolveProxy(oldReference);
      if (reference != oldReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE, oldReference, reference));
      }
    }
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference basicGetReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReference(EReference newReference)
  {
    EReference oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE, oldReference, reference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getRightAlias()
  {
    if (rightAlias != null && rightAlias.eIsProxy())
    {
      InternalEObject oldRightAlias = (InternalEObject)rightAlias;
      rightAlias = (FromEntry)eResolveProxy(oldRightAlias);
      if (rightAlias != oldRightAlias)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
      }
    }
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetRightAlias()
  {
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightAlias(FromEntry newRightAlias)
  {
    FromEntry oldRightAlias = rightAlias;
    rightAlias = newRightAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
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
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS:
        if (resolve) return getAlias();
        return basicGetAlias();
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE:
        if (resolve) return getReference();
        return basicGetReference();
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        if (resolve) return getRightAlias();
        return basicGetRightAlias();
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
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS:
        setAlias((FromEntry)newValue);
        return;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE:
        setReference((EReference)newValue);
        return;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)newValue);
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
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS:
        setAlias((FromEntry)null);
        return;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE:
        setReference((EReference)null);
        return;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)null);
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
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__ALIAS:
        return alias != null;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE:
        return reference != null;
      case Bug287941TestLanguagePackage.REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS:
        return rightAlias != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceAliasWhereEntryImpl
