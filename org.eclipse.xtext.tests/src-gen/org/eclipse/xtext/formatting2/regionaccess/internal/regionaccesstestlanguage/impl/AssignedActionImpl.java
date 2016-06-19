/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assigned Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl#getChild <em>Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignedActionImpl extends MixedImpl implements AssignedAction
{
  /**
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
  protected Mixed child;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected Mixed body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignedActionImpl()
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
    return RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed getChild()
  {
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChild(Mixed newChild, NotificationChain msgs)
  {
    Mixed oldChild = child;
    child = newChild;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD, oldChild, newChild);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChild(Mixed newChild)
  {
    if (newChild != child)
    {
      NotificationChain msgs = null;
      if (child != null)
        msgs = ((InternalEObject)child).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD, null, msgs);
      if (newChild != null)
        msgs = ((InternalEObject)newChild).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD, null, msgs);
      msgs = basicSetChild(newChild, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD, newChild, newChild));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mixed getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(Mixed newBody, NotificationChain msgs)
  {
    Mixed oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(Mixed newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY, newBody, newBody));
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
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD:
        return basicSetChild(null, msgs);
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY:
        return basicSetBody(null, msgs);
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
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD:
        return getChild();
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY:
        return getBody();
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
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD:
        setChild((Mixed)newValue);
        return;
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY:
        setBody((Mixed)newValue);
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
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD:
        setChild((Mixed)null);
        return;
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY:
        setBody((Mixed)null);
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
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__CHILD:
        return child != null;
      case RegionaccesstestlanguagePackage.ASSIGNED_ACTION__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignedActionImpl
