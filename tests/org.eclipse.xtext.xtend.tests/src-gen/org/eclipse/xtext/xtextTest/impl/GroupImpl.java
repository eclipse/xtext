/**
 * <copyright>
 * </copyright>
 *
 * $Id: GroupImpl.java,v 1.4 2009/02/19 16:25:24 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xtextTest.AbstractElement;
import org.eclipse.xtext.xtextTest.Group;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.GroupImpl#getAbstractTokens <em>Abstract Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends AbstractElementImpl implements Group
{
  /**
   * The cached value of the '{@link #getAbstractTokens() <em>Abstract Tokens</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractTokens()
   * @generated
   * @ordered
   */
  protected EList<AbstractElement> abstractTokens;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupImpl()
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
    return XtextTestPackage.Literals.GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractElement> getAbstractTokens()
  {
    if (abstractTokens == null)
    {
      abstractTokens = new EObjectContainmentEList<AbstractElement>(AbstractElement.class, this, XtextTestPackage.GROUP__ABSTRACT_TOKENS);
    }
    return abstractTokens;
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
      case XtextTestPackage.GROUP__ABSTRACT_TOKENS:
        return ((InternalEList<?>)getAbstractTokens()).basicRemove(otherEnd, msgs);
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
      case XtextTestPackage.GROUP__ABSTRACT_TOKENS:
        return getAbstractTokens();
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
      case XtextTestPackage.GROUP__ABSTRACT_TOKENS:
        getAbstractTokens().clear();
        getAbstractTokens().addAll((Collection<? extends AbstractElement>)newValue);
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
      case XtextTestPackage.GROUP__ABSTRACT_TOKENS:
        getAbstractTokens().clear();
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
      case XtextTestPackage.GROUP__ABSTRACT_TOKENS:
        return abstractTokens != null && !abstractTokens.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //GroupImpl
