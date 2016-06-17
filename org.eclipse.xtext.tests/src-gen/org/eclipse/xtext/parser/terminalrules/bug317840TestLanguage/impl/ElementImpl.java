/**
 */
package org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Bug317840TestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Element;
import org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.Named;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.impl.ElementImpl#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.impl.ElementImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.impl.ElementImpl#getThird <em>Third</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.bug317840TestLanguage.impl.ElementImpl#getForth <em>Forth</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected Named first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected Named second;

  /**
   * The cached value of the '{@link #getThird() <em>Third</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThird()
   * @generated
   * @ordered
   */
  protected EList<Named> third;

  /**
   * The cached value of the '{@link #getForth() <em>Forth</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForth()
   * @generated
   * @ordered
   */
  protected EList<Named> forth;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementImpl()
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
    return Bug317840TestLanguagePackage.Literals.ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Named getFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirst(Named newFirst, NotificationChain msgs)
  {
    Named oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug317840TestLanguagePackage.ELEMENT__FIRST, oldFirst, newFirst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(Named newFirst)
  {
    if (newFirst != first)
    {
      NotificationChain msgs = null;
      if (first != null)
        msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug317840TestLanguagePackage.ELEMENT__FIRST, null, msgs);
      if (newFirst != null)
        msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug317840TestLanguagePackage.ELEMENT__FIRST, null, msgs);
      msgs = basicSetFirst(newFirst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug317840TestLanguagePackage.ELEMENT__FIRST, newFirst, newFirst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Named getSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecond(Named newSecond, NotificationChain msgs)
  {
    Named oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug317840TestLanguagePackage.ELEMENT__SECOND, oldSecond, newSecond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(Named newSecond)
  {
    if (newSecond != second)
    {
      NotificationChain msgs = null;
      if (second != null)
        msgs = ((InternalEObject)second).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug317840TestLanguagePackage.ELEMENT__SECOND, null, msgs);
      if (newSecond != null)
        msgs = ((InternalEObject)newSecond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug317840TestLanguagePackage.ELEMENT__SECOND, null, msgs);
      msgs = basicSetSecond(newSecond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug317840TestLanguagePackage.ELEMENT__SECOND, newSecond, newSecond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Named> getThird()
  {
    if (third == null)
    {
      third = new EObjectContainmentEList<Named>(Named.class, this, Bug317840TestLanguagePackage.ELEMENT__THIRD);
    }
    return third;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Named> getForth()
  {
    if (forth == null)
    {
      forth = new EObjectContainmentEList<Named>(Named.class, this, Bug317840TestLanguagePackage.ELEMENT__FORTH);
    }
    return forth;
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
      case Bug317840TestLanguagePackage.ELEMENT__FIRST:
        return basicSetFirst(null, msgs);
      case Bug317840TestLanguagePackage.ELEMENT__SECOND:
        return basicSetSecond(null, msgs);
      case Bug317840TestLanguagePackage.ELEMENT__THIRD:
        return ((InternalEList<?>)getThird()).basicRemove(otherEnd, msgs);
      case Bug317840TestLanguagePackage.ELEMENT__FORTH:
        return ((InternalEList<?>)getForth()).basicRemove(otherEnd, msgs);
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
      case Bug317840TestLanguagePackage.ELEMENT__FIRST:
        return getFirst();
      case Bug317840TestLanguagePackage.ELEMENT__SECOND:
        return getSecond();
      case Bug317840TestLanguagePackage.ELEMENT__THIRD:
        return getThird();
      case Bug317840TestLanguagePackage.ELEMENT__FORTH:
        return getForth();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Bug317840TestLanguagePackage.ELEMENT__FIRST:
        setFirst((Named)newValue);
        return;
      case Bug317840TestLanguagePackage.ELEMENT__SECOND:
        setSecond((Named)newValue);
        return;
      case Bug317840TestLanguagePackage.ELEMENT__THIRD:
        getThird().clear();
        getThird().addAll((Collection<? extends Named>)newValue);
        return;
      case Bug317840TestLanguagePackage.ELEMENT__FORTH:
        getForth().clear();
        getForth().addAll((Collection<? extends Named>)newValue);
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
      case Bug317840TestLanguagePackage.ELEMENT__FIRST:
        setFirst((Named)null);
        return;
      case Bug317840TestLanguagePackage.ELEMENT__SECOND:
        setSecond((Named)null);
        return;
      case Bug317840TestLanguagePackage.ELEMENT__THIRD:
        getThird().clear();
        return;
      case Bug317840TestLanguagePackage.ELEMENT__FORTH:
        getForth().clear();
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
      case Bug317840TestLanguagePackage.ELEMENT__FIRST:
        return first != null;
      case Bug317840TestLanguagePackage.ELEMENT__SECOND:
        return second != null;
      case Bug317840TestLanguagePackage.ELEMENT__THIRD:
        return third != null && !third.isEmpty();
      case Bug317840TestLanguagePackage.ELEMENT__FORTH:
        return forth != null && !forth.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ElementImpl
