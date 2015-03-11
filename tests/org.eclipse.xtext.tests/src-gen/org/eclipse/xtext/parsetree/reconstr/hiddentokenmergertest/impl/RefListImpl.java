/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ref List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl#getObjs <em>Objs</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RefListImpl extends ModelImpl implements RefList
{
  /**
   * The cached value of the '{@link #getObjs() <em>Objs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjs()
   * @generated
   * @ordered
   */
  protected EList<RefObj> objs;

  /**
   * The cached value of the '{@link #getRefs() <em>Refs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefs()
   * @generated
   * @ordered
   */
  protected EList<RefObj> refs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RefListImpl()
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
    return HiddentokenmergertestPackage.Literals.REF_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RefObj> getObjs()
  {
    if (objs == null)
    {
      objs = new EObjectContainmentEList<RefObj>(RefObj.class, this, HiddentokenmergertestPackage.REF_LIST__OBJS);
    }
    return objs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RefObj> getRefs()
  {
    if (refs == null)
    {
      refs = new EObjectResolvingEList<RefObj>(RefObj.class, this, HiddentokenmergertestPackage.REF_LIST__REFS);
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
      case HiddentokenmergertestPackage.REF_LIST__OBJS:
        return ((InternalEList<?>)getObjs()).basicRemove(otherEnd, msgs);
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
      case HiddentokenmergertestPackage.REF_LIST__OBJS:
        return getObjs();
      case HiddentokenmergertestPackage.REF_LIST__REFS:
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
      case HiddentokenmergertestPackage.REF_LIST__OBJS:
        getObjs().clear();
        getObjs().addAll((Collection<? extends RefObj>)newValue);
        return;
      case HiddentokenmergertestPackage.REF_LIST__REFS:
        getRefs().clear();
        getRefs().addAll((Collection<? extends RefObj>)newValue);
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
      case HiddentokenmergertestPackage.REF_LIST__OBJS:
        getObjs().clear();
        return;
      case HiddentokenmergertestPackage.REF_LIST__REFS:
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
      case HiddentokenmergertestPackage.REF_LIST__OBJS:
        return objs != null && !objs.isEmpty();
      case HiddentokenmergertestPackage.REF_LIST__REFS:
        return refs != null && !refs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RefListImpl
