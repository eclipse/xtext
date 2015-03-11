/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue;
import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl#getSingle <em>Single</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl#getMulti <em>Multi</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getSingle() <em>Single</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingle()
   * @generated
   * @ordered
   */
  protected SingleValue single;

  /**
   * The cached value of the '{@link #getMulti() <em>Multi</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMulti()
   * @generated
   * @ordered
   */
  protected MultiValue multi;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected EObject object;

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
    return AssignmentsTestLanguagePackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleValue getSingle()
  {
    return single;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSingle(SingleValue newSingle, NotificationChain msgs)
  {
    SingleValue oldSingle = single;
    single = newSingle;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__SINGLE, oldSingle, newSingle);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingle(SingleValue newSingle)
  {
    if (newSingle != single)
    {
      NotificationChain msgs = null;
      if (single != null)
        msgs = ((InternalEObject)single).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__SINGLE, null, msgs);
      if (newSingle != null)
        msgs = ((InternalEObject)newSingle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__SINGLE, null, msgs);
      msgs = basicSetSingle(newSingle, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__SINGLE, newSingle, newSingle));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValue getMulti()
  {
    return multi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMulti(MultiValue newMulti, NotificationChain msgs)
  {
    MultiValue oldMulti = multi;
    multi = newMulti;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__MULTI, oldMulti, newMulti);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMulti(MultiValue newMulti)
  {
    if (newMulti != multi)
    {
      NotificationChain msgs = null;
      if (multi != null)
        msgs = ((InternalEObject)multi).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__MULTI, null, msgs);
      if (newMulti != null)
        msgs = ((InternalEObject)newMulti).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__MULTI, null, msgs);
      msgs = basicSetMulti(newMulti, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__MULTI, newMulti, newMulti));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObject(EObject newObject, NotificationChain msgs)
  {
    EObject oldObject = object;
    object = newObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__OBJECT, oldObject, newObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(EObject newObject)
  {
    if (newObject != object)
    {
      NotificationChain msgs = null;
      if (object != null)
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AssignmentsTestLanguagePackage.MODEL__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentsTestLanguagePackage.MODEL__OBJECT, newObject, newObject));
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
      case AssignmentsTestLanguagePackage.MODEL__SINGLE:
        return basicSetSingle(null, msgs);
      case AssignmentsTestLanguagePackage.MODEL__MULTI:
        return basicSetMulti(null, msgs);
      case AssignmentsTestLanguagePackage.MODEL__OBJECT:
        return basicSetObject(null, msgs);
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
      case AssignmentsTestLanguagePackage.MODEL__SINGLE:
        return getSingle();
      case AssignmentsTestLanguagePackage.MODEL__MULTI:
        return getMulti();
      case AssignmentsTestLanguagePackage.MODEL__OBJECT:
        return getObject();
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
      case AssignmentsTestLanguagePackage.MODEL__SINGLE:
        setSingle((SingleValue)newValue);
        return;
      case AssignmentsTestLanguagePackage.MODEL__MULTI:
        setMulti((MultiValue)newValue);
        return;
      case AssignmentsTestLanguagePackage.MODEL__OBJECT:
        setObject((EObject)newValue);
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
      case AssignmentsTestLanguagePackage.MODEL__SINGLE:
        setSingle((SingleValue)null);
        return;
      case AssignmentsTestLanguagePackage.MODEL__MULTI:
        setMulti((MultiValue)null);
        return;
      case AssignmentsTestLanguagePackage.MODEL__OBJECT:
        setObject((EObject)null);
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
      case AssignmentsTestLanguagePackage.MODEL__SINGLE:
        return single != null;
      case AssignmentsTestLanguagePackage.MODEL__MULTI:
        return multi != null;
      case AssignmentsTestLanguagePackage.MODEL__OBJECT:
        return object != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
