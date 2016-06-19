/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PRF Named With Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl#getPrev <em>Prev</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl#getRef2 <em>Ref2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PRFNamedWithActionImpl extends PRFNamedImpl implements PRFNamedWithAction
{
  /**
   * The cached value of the '{@link #getPrev() <em>Prev</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrev()
   * @generated
   * @ordered
   */
  protected PRFNamed prev;

  /**
   * The cached value of the '{@link #getRef2() <em>Ref2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef2()
   * @generated
   * @ordered
   */
  protected PRFNamed ref2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PRFNamedWithActionImpl()
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
    return FragmentTestLanguagePackage.Literals.PRF_NAMED_WITH_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed getPrev()
  {
    return prev;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrev(PRFNamed newPrev, NotificationChain msgs)
  {
    PRFNamed oldPrev = prev;
    prev = newPrev;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV, oldPrev, newPrev);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrev(PRFNamed newPrev)
  {
    if (newPrev != prev)
    {
      NotificationChain msgs = null;
      if (prev != null)
        msgs = ((InternalEObject)prev).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV, null, msgs);
      if (newPrev != null)
        msgs = ((InternalEObject)newPrev).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV, null, msgs);
      msgs = basicSetPrev(newPrev, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV, newPrev, newPrev));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed getRef2()
  {
    if (ref2 != null && ref2.eIsProxy())
    {
      InternalEObject oldRef2 = (InternalEObject)ref2;
      ref2 = (PRFNamed)eResolveProxy(oldRef2);
      if (ref2 != oldRef2)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2, oldRef2, ref2));
      }
    }
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed basicGetRef2()
  {
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef2(PRFNamed newRef2)
  {
    PRFNamed oldRef2 = ref2;
    ref2 = newRef2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2, oldRef2, ref2));
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
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV:
        return basicSetPrev(null, msgs);
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
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV:
        return getPrev();
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2:
        if (resolve) return getRef2();
        return basicGetRef2();
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
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV:
        setPrev((PRFNamed)newValue);
        return;
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2:
        setRef2((PRFNamed)newValue);
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
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV:
        setPrev((PRFNamed)null);
        return;
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2:
        setRef2((PRFNamed)null);
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
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__PREV:
        return prev != null;
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION__REF2:
        return ref2 != null;
    }
    return super.eIsSet(featureID);
  }

} //PRFNamedWithActionImpl
