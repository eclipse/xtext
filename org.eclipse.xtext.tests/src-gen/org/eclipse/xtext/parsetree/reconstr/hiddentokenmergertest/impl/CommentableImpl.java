/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Commentable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableImpl#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommentableImpl extends ModelImpl implements Commentable
{
  /**
   * The cached value of the '{@link #getItem() <em>Item</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getItem()
   * @generated
   * @ordered
   */
  protected EList<CommentableItem> item;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommentableImpl()
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
    return HiddentokenmergertestPackage.Literals.COMMENTABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CommentableItem> getItem()
  {
    if (item == null)
    {
      item = new EObjectContainmentEList<CommentableItem>(CommentableItem.class, this, HiddentokenmergertestPackage.COMMENTABLE__ITEM);
    }
    return item;
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
      case HiddentokenmergertestPackage.COMMENTABLE__ITEM:
        return ((InternalEList<?>)getItem()).basicRemove(otherEnd, msgs);
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
      case HiddentokenmergertestPackage.COMMENTABLE__ITEM:
        return getItem();
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
      case HiddentokenmergertestPackage.COMMENTABLE__ITEM:
        getItem().clear();
        getItem().addAll((Collection<? extends CommentableItem>)newValue);
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
      case HiddentokenmergertestPackage.COMMENTABLE__ITEM:
        getItem().clear();
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
      case HiddentokenmergertestPackage.COMMENTABLE__ITEM:
        return item != null && !item.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CommentableImpl
