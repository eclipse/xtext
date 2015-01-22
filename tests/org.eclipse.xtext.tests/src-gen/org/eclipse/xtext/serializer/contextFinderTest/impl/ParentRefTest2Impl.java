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
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2;
import org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parent Ref Test2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ParentRefTest2Impl#getChild2 <em>Child2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParentRefTest2Impl extends MinimalEObjectImpl.Container implements ParentRefTest2
{
  /**
   * The cached value of the '{@link #getChild2() <em>Child2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild2()
   * @generated
   * @ordered
   */
  protected ParentRefTestChild child2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParentRefTest2Impl()
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
    return ContextFinderTestPackage.Literals.PARENT_REF_TEST2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParentRefTestChild getChild2()
  {
    return child2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild2(ParentRefTestChild newChild2, NotificationChain msgs)
  {
    ParentRefTestChild oldChild2 = child2;
    child2 = newChild2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2, oldChild2, newChild2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChild2(ParentRefTestChild newChild2)
  {
    if (newChild2 != child2)
    {
      NotificationChain msgs = null;
      if (child2 != null)
        msgs = ((InternalEObject)child2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2, null, msgs);
      if (newChild2 != null)
        msgs = ((InternalEObject)newChild2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2, null, msgs);
      msgs = basicSetChild2(newChild2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2, newChild2, newChild2));
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
      case ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2:
        return basicSetChild2(null, msgs);
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
      case ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2:
        return getChild2();
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
      case ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2:
        setChild2((ParentRefTestChild)newValue);
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
      case ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2:
        setChild2((ParentRefTestChild)null);
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
      case ContextFinderTestPackage.PARENT_REF_TEST2__CHILD2:
        return child2 != null;
    }
    return super.eIsSet(featureID);
  }

} //ParentRefTest2Impl
