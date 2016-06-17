/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nested Type Recursive Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.NestedTypeRecursiveTestImpl#getLeft <em>Left</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NestedTypeRecursiveTestImpl extends MinimalEObjectImpl.Container implements NestedTypeRecursiveTest
{
  /**
   * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeft()
   * @generated
   * @ordered
   */
  protected NestedTypeRecursiveTest left;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NestedTypeRecursiveTestImpl()
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
    return ContextFinderTestPackage.Literals.NESTED_TYPE_RECURSIVE_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest getLeft()
  {
    return left;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeft(NestedTypeRecursiveTest newLeft, NotificationChain msgs)
  {
    NestedTypeRecursiveTest oldLeft = left;
    left = newLeft;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT, oldLeft, newLeft);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeft(NestedTypeRecursiveTest newLeft)
  {
    if (newLeft != left)
    {
      NotificationChain msgs = null;
      if (left != null)
        msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT, null, msgs);
      if (newLeft != null)
        msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT, null, msgs);
      msgs = basicSetLeft(newLeft, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT, newLeft, newLeft));
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
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT:
        return basicSetLeft(null, msgs);
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
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT:
        return getLeft();
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
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT:
        setLeft((NestedTypeRecursiveTest)newValue);
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
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT:
        setLeft((NestedTypeRecursiveTest)null);
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
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST__LEFT:
        return left != null;
    }
    return super.eIsSet(featureID);
  }

} //NestedTypeRecursiveTestImpl
