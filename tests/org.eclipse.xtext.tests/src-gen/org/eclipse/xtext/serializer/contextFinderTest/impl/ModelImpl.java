/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.contextFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest;
import org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage;
import org.eclipse.xtext.serializer.contextFinderTest.Model;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest;
import org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl#getAttributeExclusion <em>Attribute Exclusion</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl#getNestedType <em>Nested Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.impl.ModelImpl#getNestedTypeRecursiveTest2 <em>Nested Type Recursive Test2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getAttributeExclusion() <em>Attribute Exclusion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeExclusion()
   * @generated
   * @ordered
   */
  protected AttributeExclusionTest attributeExclusion;

  /**
   * The cached value of the '{@link #getNestedType() <em>Nested Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedType()
   * @generated
   * @ordered
   */
  protected NestedTypeTest nestedType;

  /**
   * The cached value of the '{@link #getNestedTypeRecursiveTest2() <em>Nested Type Recursive Test2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedTypeRecursiveTest2()
   * @generated
   * @ordered
   */
  protected NestedTypeRecursiveTest nestedTypeRecursiveTest2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
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
    return ContextFinderTestPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeExclusionTest getAttributeExclusion()
  {
    return attributeExclusion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeExclusion(AttributeExclusionTest newAttributeExclusion, NotificationChain msgs)
  {
    AttributeExclusionTest oldAttributeExclusion = attributeExclusion;
    attributeExclusion = newAttributeExclusion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION, oldAttributeExclusion, newAttributeExclusion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeExclusion(AttributeExclusionTest newAttributeExclusion)
  {
    if (newAttributeExclusion != attributeExclusion)
    {
      NotificationChain msgs = null;
      if (attributeExclusion != null)
        msgs = ((InternalEObject)attributeExclusion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION, null, msgs);
      if (newAttributeExclusion != null)
        msgs = ((InternalEObject)newAttributeExclusion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION, null, msgs);
      msgs = basicSetAttributeExclusion(newAttributeExclusion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION, newAttributeExclusion, newAttributeExclusion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeTest getNestedType()
  {
    return nestedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNestedType(NestedTypeTest newNestedType, NotificationChain msgs)
  {
    NestedTypeTest oldNestedType = nestedType;
    nestedType = newNestedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__NESTED_TYPE, oldNestedType, newNestedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNestedType(NestedTypeTest newNestedType)
  {
    if (newNestedType != nestedType)
    {
      NotificationChain msgs = null;
      if (nestedType != null)
        msgs = ((InternalEObject)nestedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__NESTED_TYPE, null, msgs);
      if (newNestedType != null)
        msgs = ((InternalEObject)newNestedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__NESTED_TYPE, null, msgs);
      msgs = basicSetNestedType(newNestedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__NESTED_TYPE, newNestedType, newNestedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedTypeRecursiveTest getNestedTypeRecursiveTest2()
  {
    return nestedTypeRecursiveTest2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNestedTypeRecursiveTest2(NestedTypeRecursiveTest newNestedTypeRecursiveTest2, NotificationChain msgs)
  {
    NestedTypeRecursiveTest oldNestedTypeRecursiveTest2 = nestedTypeRecursiveTest2;
    nestedTypeRecursiveTest2 = newNestedTypeRecursiveTest2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2, oldNestedTypeRecursiveTest2, newNestedTypeRecursiveTest2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNestedTypeRecursiveTest2(NestedTypeRecursiveTest newNestedTypeRecursiveTest2)
  {
    if (newNestedTypeRecursiveTest2 != nestedTypeRecursiveTest2)
    {
      NotificationChain msgs = null;
      if (nestedTypeRecursiveTest2 != null)
        msgs = ((InternalEObject)nestedTypeRecursiveTest2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2, null, msgs);
      if (newNestedTypeRecursiveTest2 != null)
        msgs = ((InternalEObject)newNestedTypeRecursiveTest2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2, null, msgs);
      msgs = basicSetNestedTypeRecursiveTest2(newNestedTypeRecursiveTest2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2, newNestedTypeRecursiveTest2, newNestedTypeRecursiveTest2));
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
      case ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION:
        return basicSetAttributeExclusion(null, msgs);
      case ContextFinderTestPackage.MODEL__NESTED_TYPE:
        return basicSetNestedType(null, msgs);
      case ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2:
        return basicSetNestedTypeRecursiveTest2(null, msgs);
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
      case ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION:
        return getAttributeExclusion();
      case ContextFinderTestPackage.MODEL__NESTED_TYPE:
        return getNestedType();
      case ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2:
        return getNestedTypeRecursiveTest2();
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
      case ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION:
        setAttributeExclusion((AttributeExclusionTest)newValue);
        return;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE:
        setNestedType((NestedTypeTest)newValue);
        return;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2:
        setNestedTypeRecursiveTest2((NestedTypeRecursiveTest)newValue);
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
      case ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION:
        setAttributeExclusion((AttributeExclusionTest)null);
        return;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE:
        setNestedType((NestedTypeTest)null);
        return;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2:
        setNestedTypeRecursiveTest2((NestedTypeRecursiveTest)null);
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
      case ContextFinderTestPackage.MODEL__ATTRIBUTE_EXCLUSION:
        return attributeExclusion != null;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE:
        return nestedType != null;
      case ContextFinderTestPackage.MODEL__NESTED_TYPE_RECURSIVE_TEST2:
        return nestedTypeRecursiveTest2 != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
