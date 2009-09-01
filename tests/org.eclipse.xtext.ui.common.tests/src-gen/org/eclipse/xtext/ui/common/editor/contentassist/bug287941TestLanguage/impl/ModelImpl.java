/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

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

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Import;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.ModelImpl#getQuery <em>Query</em>}</li>
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
   * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQuery()
   * @generated
   * @ordered
   */
  protected MQLquery query;

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
    return Bug287941TestLanguagePackage.Literals.MODEL;
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
      imports = new EObjectContainmentEList<Import>(Import.class, this, Bug287941TestLanguagePackage.MODEL__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MQLquery getQuery()
  {
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuery(MQLquery newQuery, NotificationChain msgs)
  {
    MQLquery oldQuery = query;
    query = newQuery;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.MODEL__QUERY, oldQuery, newQuery);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuery(MQLquery newQuery)
  {
    if (newQuery != query)
    {
      NotificationChain msgs = null;
      if (query != null)
        msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug287941TestLanguagePackage.MODEL__QUERY, null, msgs);
      if (newQuery != null)
        msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug287941TestLanguagePackage.MODEL__QUERY, null, msgs);
      msgs = basicSetQuery(newQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.MODEL__QUERY, newQuery, newQuery));
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
      case Bug287941TestLanguagePackage.MODEL__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case Bug287941TestLanguagePackage.MODEL__QUERY:
        return basicSetQuery(null, msgs);
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
      case Bug287941TestLanguagePackage.MODEL__IMPORTS:
        return getImports();
      case Bug287941TestLanguagePackage.MODEL__QUERY:
        return getQuery();
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
      case Bug287941TestLanguagePackage.MODEL__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends Import>)newValue);
        return;
      case Bug287941TestLanguagePackage.MODEL__QUERY:
        setQuery((MQLquery)newValue);
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
      case Bug287941TestLanguagePackage.MODEL__IMPORTS:
        getImports().clear();
        return;
      case Bug287941TestLanguagePackage.MODEL__QUERY:
        setQuery((MQLquery)null);
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
      case Bug287941TestLanguagePackage.MODEL__IMPORTS:
        return imports != null && !imports.isEmpty();
      case Bug287941TestLanguagePackage.MODEL__QUERY:
        return query != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
