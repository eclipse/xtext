/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed;
import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule Fragments</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParserRuleFragmentsImpl extends MinimalEObjectImpl.Container implements ParserRuleFragments
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected PRFNamed element;

  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected PRFNamed ref;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParserRuleFragmentsImpl()
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
    return FragmentTestLanguagePackage.Literals.PARSER_RULE_FRAGMENTS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed getElement()
  {
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElement(PRFNamed newElement, NotificationChain msgs)
  {
    PRFNamed oldElement = element;
    element = newElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT, oldElement, newElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElement(PRFNamed newElement)
  {
    if (newElement != element)
    {
      NotificationChain msgs = null;
      if (element != null)
        msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT, null, msgs);
      if (newElement != null)
        msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT, null, msgs);
      msgs = basicSetElement(newElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT, newElement, newElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (PRFNamed)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(PRFNamed newRef)
  {
    PRFNamed oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF, oldRef, ref));
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT:
        return basicSetElement(null, msgs);
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT:
        return getElement();
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF:
        if (resolve) return getRef();
        return basicGetRef();
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT:
        setElement((PRFNamed)newValue);
        return;
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF:
        setRef((PRFNamed)newValue);
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT:
        setElement((PRFNamed)null);
        return;
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF:
        setRef((PRFNamed)null);
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__ELEMENT:
        return element != null;
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS__REF:
        return ref != null;
    }
    return super.eIsSet(featureID);
  }

} //ParserRuleFragmentsImpl
