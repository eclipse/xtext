/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.WhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MQ Lquery</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl#getSelectEntries <em>Select Entries</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl#getFromEntries <em>From Entries</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.MQLqueryImpl#getWhereEntries <em>Where Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MQLqueryImpl extends MinimalEObjectImpl.Container implements MQLquery
{
  /**
   * The cached value of the '{@link #getSelectEntries() <em>Select Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectEntries()
   * @generated
   * @ordered
   */
  protected EList<SelectEntry> selectEntries;

  /**
   * The cached value of the '{@link #getFromEntries() <em>From Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFromEntries()
   * @generated
   * @ordered
   */
  protected EList<FromEntry> fromEntries;

  /**
   * The cached value of the '{@link #getWhereEntries() <em>Where Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhereEntries()
   * @generated
   * @ordered
   */
  protected EList<WhereEntry> whereEntries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MQLqueryImpl()
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
    return Bug287941TestLanguagePackage.Literals.MQ_LQUERY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SelectEntry> getSelectEntries()
  {
    if (selectEntries == null)
    {
      selectEntries = new EObjectContainmentEList<SelectEntry>(SelectEntry.class, this, Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES);
    }
    return selectEntries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FromEntry> getFromEntries()
  {
    if (fromEntries == null)
    {
      fromEntries = new EObjectContainmentEList<FromEntry>(FromEntry.class, this, Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES);
    }
    return fromEntries;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<WhereEntry> getWhereEntries()
  {
    if (whereEntries == null)
    {
      whereEntries = new EObjectContainmentEList<WhereEntry>(WhereEntry.class, this, Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES);
    }
    return whereEntries;
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
      case Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES:
        return ((InternalEList<?>)getSelectEntries()).basicRemove(otherEnd, msgs);
      case Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES:
        return ((InternalEList<?>)getFromEntries()).basicRemove(otherEnd, msgs);
      case Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES:
        return ((InternalEList<?>)getWhereEntries()).basicRemove(otherEnd, msgs);
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
      case Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES:
        return getSelectEntries();
      case Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES:
        return getFromEntries();
      case Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES:
        return getWhereEntries();
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
      case Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES:
        getSelectEntries().clear();
        getSelectEntries().addAll((Collection<? extends SelectEntry>)newValue);
        return;
      case Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES:
        getFromEntries().clear();
        getFromEntries().addAll((Collection<? extends FromEntry>)newValue);
        return;
      case Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES:
        getWhereEntries().clear();
        getWhereEntries().addAll((Collection<? extends WhereEntry>)newValue);
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
      case Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES:
        getSelectEntries().clear();
        return;
      case Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES:
        getFromEntries().clear();
        return;
      case Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES:
        getWhereEntries().clear();
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
      case Bug287941TestLanguagePackage.MQ_LQUERY__SELECT_ENTRIES:
        return selectEntries != null && !selectEntries.isEmpty();
      case Bug287941TestLanguagePackage.MQ_LQUERY__FROM_ENTRIES:
        return fromEntries != null && !fromEntries.isEmpty();
      case Bug287941TestLanguagePackage.MQ_LQUERY__WHERE_ENTRIES:
        return whereEntries != null && !whereEntries.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MQLqueryImpl
