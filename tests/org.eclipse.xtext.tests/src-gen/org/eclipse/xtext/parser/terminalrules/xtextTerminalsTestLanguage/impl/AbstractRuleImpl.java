/**
 */
package org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractElement;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractRule;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TypeRef;
import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl.AbstractRuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl.AbstractRuleImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.impl.AbstractRuleImpl#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractRuleImpl extends MinimalEObjectImpl.Container implements AbstractRule
{
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
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeRef type;

  /**
   * The cached value of the '{@link #getAlternatives() <em>Alternatives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAlternatives()
   * @generated
   * @ordered
   */
  protected AbstractElement alternatives;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractRuleImpl()
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
    return XtextTerminalsTestLanguagePackage.Literals.ABSTRACT_RULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeRef getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeRef newType, NotificationChain msgs)
  {
    TypeRef oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeRef newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement getAlternatives()
  {
    return alternatives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAlternatives(AbstractElement newAlternatives, NotificationChain msgs)
  {
    AbstractElement oldAlternatives = alternatives;
    alternatives = newAlternatives;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES, oldAlternatives, newAlternatives);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlternatives(AbstractElement newAlternatives)
  {
    if (newAlternatives != alternatives)
    {
      NotificationChain msgs = null;
      if (alternatives != null)
        msgs = ((InternalEObject)alternatives).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES, null, msgs);
      if (newAlternatives != null)
        msgs = ((InternalEObject)newAlternatives).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES, null, msgs);
      msgs = basicSetAlternatives(newAlternatives, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES, newAlternatives, newAlternatives));
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
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE:
        return basicSetType(null, msgs);
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES:
        return basicSetAlternatives(null, msgs);
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
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__NAME:
        return getName();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE:
        return getType();
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES:
        return getAlternatives();
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
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__NAME:
        setName((String)newValue);
        return;
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE:
        setType((TypeRef)newValue);
        return;
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES:
        setAlternatives((AbstractElement)newValue);
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
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE:
        setType((TypeRef)null);
        return;
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES:
        setAlternatives((AbstractElement)null);
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
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__TYPE:
        return type != null;
      case XtextTerminalsTestLanguagePackage.ABSTRACT_RULE__ALTERNATIVES:
        return alternatives != null;
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

} //AbstractRuleImpl
