/**
 */
package org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node;
import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot;
import org.eclipse.xtext.parsetree.reconstr.partialserializationtest.PartialserializationtestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeRootImpl#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeRootImpl extends ModelImpl implements NodeRoot
{
  /**
   * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNode()
   * @generated
   * @ordered
   */
  protected Node node;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeRootImpl()
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
    return PartialserializationtestPackage.Literals.NODE_ROOT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node getNode()
  {
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNode(Node newNode, NotificationChain msgs)
  {
    Node oldNode = node;
    node = newNode;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PartialserializationtestPackage.NODE_ROOT__NODE, oldNode, newNode);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNode(Node newNode)
  {
    if (newNode != node)
    {
      NotificationChain msgs = null;
      if (node != null)
        msgs = ((InternalEObject)node).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PartialserializationtestPackage.NODE_ROOT__NODE, null, msgs);
      if (newNode != null)
        msgs = ((InternalEObject)newNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PartialserializationtestPackage.NODE_ROOT__NODE, null, msgs);
      msgs = basicSetNode(newNode, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PartialserializationtestPackage.NODE_ROOT__NODE, newNode, newNode));
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
      case PartialserializationtestPackage.NODE_ROOT__NODE:
        return basicSetNode(null, msgs);
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
      case PartialserializationtestPackage.NODE_ROOT__NODE:
        return getNode();
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
      case PartialserializationtestPackage.NODE_ROOT__NODE:
        setNode((Node)newValue);
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
      case PartialserializationtestPackage.NODE_ROOT__NODE:
        setNode((Node)null);
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
      case PartialserializationtestPackage.NODE_ROOT__NODE:
        return node != null;
    }
    return super.eIsSet(featureID);
  }

} //NodeRootImpl
