/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl#getLeftValue <em>Left Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl#getRightValue <em>Right Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleAssignmentImpl extends AssignmentImpl implements SingleAssignment
{
  /**
   * The cached value of the '{@link #getLeftValue() <em>Left Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftValue()
   * @generated
   * @ordered
   */
  protected AssignmentValue leftValue;

  /**
   * The cached value of the '{@link #getRightValue() <em>Right Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightValue()
   * @generated
   * @ordered
   */
  protected AssignmentValue rightValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SingleAssignmentImpl()
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
    return EpatchTestLanguagePackage.Literals.SINGLE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentValue getLeftValue()
  {
    return leftValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftValue(AssignmentValue newLeftValue, NotificationChain msgs)
  {
    AssignmentValue oldLeftValue = leftValue;
    leftValue = newLeftValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE, oldLeftValue, newLeftValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftValue(AssignmentValue newLeftValue)
  {
    if (newLeftValue != leftValue)
    {
      NotificationChain msgs = null;
      if (leftValue != null)
        msgs = ((InternalEObject)leftValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE, null, msgs);
      if (newLeftValue != null)
        msgs = ((InternalEObject)newLeftValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE, null, msgs);
      msgs = basicSetLeftValue(newLeftValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE, newLeftValue, newLeftValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentValue getRightValue()
  {
    return rightValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightValue(AssignmentValue newRightValue, NotificationChain msgs)
  {
    AssignmentValue oldRightValue = rightValue;
    rightValue = newRightValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE, oldRightValue, newRightValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightValue(AssignmentValue newRightValue)
  {
    if (newRightValue != rightValue)
    {
      NotificationChain msgs = null;
      if (rightValue != null)
        msgs = ((InternalEObject)rightValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE, null, msgs);
      if (newRightValue != null)
        msgs = ((InternalEObject)newRightValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE, null, msgs);
      msgs = basicSetRightValue(newRightValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE, newRightValue, newRightValue));
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
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE:
        return basicSetLeftValue(null, msgs);
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE:
        return basicSetRightValue(null, msgs);
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
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE:
        return getLeftValue();
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE:
        return getRightValue();
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
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE:
        setLeftValue((AssignmentValue)newValue);
        return;
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE:
        setRightValue((AssignmentValue)newValue);
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
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE:
        setLeftValue((AssignmentValue)null);
        return;
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE:
        setRightValue((AssignmentValue)null);
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
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__LEFT_VALUE:
        return leftValue != null;
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT__RIGHT_VALUE:
        return rightValue != null;
    }
    return super.eIsSet(featureID);
  }

} //SingleAssignmentImpl
