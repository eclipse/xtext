/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage;
import org.eclipse.xtext.serializer.contextFinderTest.Model;
import org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Exclusion List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NodeExclusionListImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeExclusionListImpl extends MinimalEObjectImpl.Container implements NodeExclusionList
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected EList<Model> ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeExclusionListImpl()
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
    return ContextFinderTestPackage.Literals.NODE_EXCLUSION_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Model> getRef()
  {
    if (ref == null)
    {
      ref = new EObjectResolvingEList<Model>(Model.class, this, ContextFinderTestPackage.NODE_EXCLUSION_LIST__REF);
    }
    return ref;
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
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST__REF:
        return getRef();
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
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST__REF:
        getRef().clear();
        getRef().addAll((Collection<? extends Model>)newValue);
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
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST__REF:
        getRef().clear();
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
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST__REF:
        return ref != null && !ref.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //NodeExclusionListImpl
