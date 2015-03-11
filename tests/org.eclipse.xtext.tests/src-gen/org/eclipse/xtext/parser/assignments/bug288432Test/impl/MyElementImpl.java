/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage;
import org.eclipse.xtext.parser.assignments.bug288432Test.MyElement;
import org.eclipse.xtext.parser.assignments.bug288432Test.ParameterObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>My Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyElementImpl#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MyElementImpl extends ContentImpl implements MyElement
{
  /**
   * The cached value of the '{@link #getBar() <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBar()
   * @generated
   * @ordered
   */
  protected ParameterObject bar;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MyElementImpl()
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
    return Bug288432TestPackage.Literals.MY_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterObject getBar()
  {
    return bar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBar(ParameterObject newBar, NotificationChain msgs)
  {
    ParameterObject oldBar = bar;
    bar = newBar;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug288432TestPackage.MY_ELEMENT__BAR, oldBar, newBar);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBar(ParameterObject newBar)
  {
    if (newBar != bar)
    {
      NotificationChain msgs = null;
      if (bar != null)
        msgs = ((InternalEObject)bar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug288432TestPackage.MY_ELEMENT__BAR, null, msgs);
      if (newBar != null)
        msgs = ((InternalEObject)newBar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug288432TestPackage.MY_ELEMENT__BAR, null, msgs);
      msgs = basicSetBar(newBar, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug288432TestPackage.MY_ELEMENT__BAR, newBar, newBar));
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
      case Bug288432TestPackage.MY_ELEMENT__BAR:
        return basicSetBar(null, msgs);
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
      case Bug288432TestPackage.MY_ELEMENT__BAR:
        return getBar();
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
      case Bug288432TestPackage.MY_ELEMENT__BAR:
        setBar((ParameterObject)newValue);
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
      case Bug288432TestPackage.MY_ELEMENT__BAR:
        setBar((ParameterObject)null);
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
      case Bug288432TestPackage.MY_ELEMENT__BAR:
        return bar != null;
    }
    return super.eIsSet(featureID);
  }

} //MyElementImpl
