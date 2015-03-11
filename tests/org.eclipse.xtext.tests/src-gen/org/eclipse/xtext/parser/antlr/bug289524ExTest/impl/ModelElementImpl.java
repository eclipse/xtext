/**
 */
package org.eclipse.xtext.parser.antlr.bug289524ExTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage;
import org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained;
import org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl#getContainments <em>Containments</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.impl.ModelElementImpl#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementImpl extends MinimalEObjectImpl.Container implements ModelElement
{
  /**
   * The cached value of the '{@link #getContainments() <em>Containments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContainments()
   * @generated
   * @ordered
   */
  protected EList<Contained> containments;

  /**
   * The cached value of the '{@link #getRefs() <em>Refs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefs()
   * @generated
   * @ordered
   */
  protected EList<Contained> refs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelElementImpl()
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
    return Bug289524ExTestPackage.Literals.MODEL_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Contained> getContainments()
  {
    if (containments == null)
    {
      containments = new EObjectContainmentEList<Contained>(Contained.class, this, Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS);
    }
    return containments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Contained> getRefs()
  {
    if (refs == null)
    {
      refs = new EObjectResolvingEList<Contained>(Contained.class, this, Bug289524ExTestPackage.MODEL_ELEMENT__REFS);
    }
    return refs;
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
      case Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS:
        return ((InternalEList<?>)getContainments()).basicRemove(otherEnd, msgs);
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
      case Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS:
        return getContainments();
      case Bug289524ExTestPackage.MODEL_ELEMENT__REFS:
        return getRefs();
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
      case Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS:
        getContainments().clear();
        getContainments().addAll((Collection<? extends Contained>)newValue);
        return;
      case Bug289524ExTestPackage.MODEL_ELEMENT__REFS:
        getRefs().clear();
        getRefs().addAll((Collection<? extends Contained>)newValue);
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
      case Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS:
        getContainments().clear();
        return;
      case Bug289524ExTestPackage.MODEL_ELEMENT__REFS:
        getRefs().clear();
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
      case Bug289524ExTestPackage.MODEL_ELEMENT__CONTAINMENTS:
        return containments != null && !containments.isEmpty();
      case Bug289524ExTestPackage.MODEL_ELEMENT__REFS:
        return refs != null && !refs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelElementImpl
