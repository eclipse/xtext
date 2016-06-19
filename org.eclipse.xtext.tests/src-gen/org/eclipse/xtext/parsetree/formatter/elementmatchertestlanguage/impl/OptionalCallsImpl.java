/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optional Calls</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl#getOpt1 <em>Opt1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.impl.OptionalCallsImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionalCallsImpl extends ModelImpl implements OptionalCalls
{
  /**
   * The cached value of the '{@link #getOpt1() <em>Opt1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpt1()
   * @generated
   * @ordered
   */
  protected OptionalCallsSub1 opt1;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OptionalCallsImpl()
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
    return ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalCallsSub1 getOpt1()
  {
    return opt1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpt1(OptionalCallsSub1 newOpt1, NotificationChain msgs)
  {
    OptionalCallsSub1 oldOpt1 = opt1;
    opt1 = newOpt1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1, oldOpt1, newOpt1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOpt1(OptionalCallsSub1 newOpt1)
  {
    if (newOpt1 != opt1)
    {
      NotificationChain msgs = null;
      if (opt1 != null)
        msgs = ((InternalEObject)opt1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1, null, msgs);
      if (newOpt1 != null)
        msgs = ((InternalEObject)newOpt1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1, null, msgs);
      msgs = basicSetOpt1(newOpt1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1, newOpt1, newOpt1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementmatchertestlanguagePackage.OPTIONAL_CALLS__NAME, oldName, name));
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1:
        return basicSetOpt1(null, msgs);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1:
        return getOpt1();
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__NAME:
        return getName();
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1:
        setOpt1((OptionalCallsSub1)newValue);
        return;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__NAME:
        setName((String)newValue);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1:
        setOpt1((OptionalCallsSub1)null);
        return;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__NAME:
        setName(NAME_EDEFAULT);
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
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__OPT1:
        return opt1 != null;
      case ElementmatchertestlanguagePackage.OPTIONAL_CALLS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OptionalCallsImpl
