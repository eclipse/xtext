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
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parent Ref Test1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest1Impl#getChild1 <em>Child1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParentRefTest1Impl extends MinimalEObjectImpl.Container implements ParentRefTest1
{
  /**
   * The cached value of the '{@link #getChild1() <em>Child1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild1()
   * @generated
   * @ordered
   */
  protected ParentRefTestChild child1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParentRefTest1Impl()
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
    return ContextFinderTestPackage.Literals.PARENT_REF_TEST1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParentRefTestChild getChild1()
  {
    return child1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild1(ParentRefTestChild newChild1, NotificationChain msgs)
  {
    ParentRefTestChild oldChild1 = child1;
    child1 = newChild1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1, oldChild1, newChild1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChild1(ParentRefTestChild newChild1)
  {
    if (newChild1 != child1)
    {
      NotificationChain msgs = null;
      if (child1 != null)
        msgs = ((InternalEObject)child1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1, null, msgs);
      if (newChild1 != null)
        msgs = ((InternalEObject)newChild1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1, null, msgs);
      msgs = basicSetChild1(newChild1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1, newChild1, newChild1));
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
      case ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1:
        return basicSetChild1(null, msgs);
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
      case ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1:
        return getChild1();
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
      case ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1:
        setChild1((ParentRefTestChild)newValue);
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
      case ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1:
        setChild1((ParentRefTestChild)null);
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
      case ContextFinderTestPackage.PARENT_REF_TEST1__CHILD1:
        return child1 != null;
    }
    return super.eIsSet(featureID);
  }

} //ParentRefTest1Impl
