/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tricky G</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl.TrickyGImpl#getTree <em>Tree</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TrickyGImpl extends RootImpl implements TrickyG
{
  /**
   * The cached value of the '{@link #getTree() <em>Tree</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTree()
   * @generated
   * @ordered
   */
  protected TrickyG1 tree;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TrickyGImpl()
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
    return ComplexrewritetestPackage.Literals.TRICKY_G;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyG1 getTree()
  {
    return tree;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTree(TrickyG1 newTree, NotificationChain msgs)
  {
    TrickyG1 oldTree = tree;
    tree = newTree;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.TRICKY_G__TREE, oldTree, newTree);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTree(TrickyG1 newTree)
  {
    if (newTree != tree)
    {
      NotificationChain msgs = null;
      if (tree != null)
        msgs = ((InternalEObject)tree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.TRICKY_G__TREE, null, msgs);
      if (newTree != null)
        msgs = ((InternalEObject)newTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComplexrewritetestPackage.TRICKY_G__TREE, null, msgs);
      msgs = basicSetTree(newTree, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ComplexrewritetestPackage.TRICKY_G__TREE, newTree, newTree));
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
      case ComplexrewritetestPackage.TRICKY_G__TREE:
        return basicSetTree(null, msgs);
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
      case ComplexrewritetestPackage.TRICKY_G__TREE:
        return getTree();
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
      case ComplexrewritetestPackage.TRICKY_G__TREE:
        setTree((TrickyG1)newValue);
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
      case ComplexrewritetestPackage.TRICKY_G__TREE:
        setTree((TrickyG1)null);
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
      case ComplexrewritetestPackage.TRICKY_G__TREE:
        return tree != null;
    }
    return super.eIsSet(featureID);
  }

} //TrickyGImpl
