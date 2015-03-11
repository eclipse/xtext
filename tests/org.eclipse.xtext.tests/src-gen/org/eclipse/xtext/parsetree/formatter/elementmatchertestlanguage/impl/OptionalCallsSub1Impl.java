/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Calls Sub1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl#getOpt2 <em>Opt2</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsSub1Impl#getOpt3 <em>Opt3</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalCallsSub1Impl extends MinimalEObjectImpl.Container implements OptionalCallsSub1
{
  /**
   * The cached value of the '{@link #getOpt2() <em>Opt2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt2()
   * @generated
   * @ordered
   */
  protected OptionalCallsSub2 opt2;

  /**
   * The cached value of the '{@link #getOpt3() <em>Opt3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt3()
   * @generated
   * @ordered
   */
  protected OptionalCallsSub3 opt3;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OptionalCallsSub1Impl()
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
    return ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS_SUB1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub2 getOpt2()
  {
    return opt2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpt2(OptionalCallsSub2 newOpt2, NotificationChain msgs)
  {
    OptionalCallsSub2 oldOpt2 = opt2;
    opt2 = newOpt2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2, oldOpt2, newOpt2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpt2(OptionalCallsSub2 newOpt2)
  {
    if (newOpt2 != opt2)
    {
      NotificationChain msgs = null;
      if (opt2 != null)
        msgs = ((InternalEObject)opt2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2, null, msgs);
      if (newOpt2 != null)
        msgs = ((InternalEObject)newOpt2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2, null, msgs);
      msgs = basicSetOpt2(newOpt2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2, newOpt2, newOpt2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub3 getOpt3()
  {
    return opt3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpt3(OptionalCallsSub3 newOpt3, NotificationChain msgs)
  {
    OptionalCallsSub3 oldOpt3 = opt3;
    opt3 = newOpt3;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3, oldOpt3, newOpt3);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpt3(OptionalCallsSub3 newOpt3)
  {
    if (newOpt3 != opt3)
    {
      NotificationChain msgs = null;
      if (opt3 != null)
        msgs = ((InternalEObject)opt3).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3, null, msgs);
      if (newOpt3 != null)
        msgs = ((InternalEObject)newOpt3).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3, null, msgs);
      msgs = basicSetOpt3(newOpt3, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3, newOpt3, newOpt3));
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2:
        return basicSetOpt2(null, msgs);
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3:
        return basicSetOpt3(null, msgs);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2:
        return getOpt2();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3:
        return getOpt3();
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2:
        setOpt2((OptionalCallsSub2)newValue);
        return;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3:
        setOpt3((OptionalCallsSub3)newValue);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2:
        setOpt2((OptionalCallsSub2)null);
        return;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3:
        setOpt3((OptionalCallsSub3)null);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT2:
        return opt2 != null;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1__OPT3:
        return opt3 != null;
    }
    return super.eIsSet(featureID);
  }

} //OptionalCallsSub1Impl
