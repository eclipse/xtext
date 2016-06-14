/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl;

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

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement;
import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl#isFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.impl.RuleImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends MinimalEObjectImpl.Container implements Rule
{
  /**
   * The default value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected static final boolean FRAGMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFragment() <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFragment()
   * @generated
   * @ordered
   */
  protected boolean fragment = FRAGMENT_EDEFAULT;

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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected RuleElement body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleImpl()
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
    return SimpleAntlrPackage.Literals.RULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFragment()
  {
    return fragment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFragment(boolean newFragment)
  {
    boolean oldFragment = fragment;
    fragment = newFragment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE__FRAGMENT, oldFragment, fragment));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, SimpleAntlrPackage.RULE__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleElement getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(RuleElement newBody, NotificationChain msgs)
  {
    RuleElement oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(RuleElement newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimpleAntlrPackage.RULE__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SimpleAntlrPackage.RULE__BODY, newBody, newBody));
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
      case SimpleAntlrPackage.RULE__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case SimpleAntlrPackage.RULE__BODY:
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
      case SimpleAntlrPackage.RULE__FRAGMENT:
        return isFragment();
      case SimpleAntlrPackage.RULE__NAME:
        return getName();
      case SimpleAntlrPackage.RULE__PARAMETERS:
        return getParameters();
      case SimpleAntlrPackage.RULE__BODY:
        return getBody();
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
      case SimpleAntlrPackage.RULE__FRAGMENT:
        setFragment((Boolean)newValue);
        return;
      case SimpleAntlrPackage.RULE__NAME:
        setName((String)newValue);
        return;
      case SimpleAntlrPackage.RULE__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case SimpleAntlrPackage.RULE__BODY:
        setBody((RuleElement)newValue);
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
      case SimpleAntlrPackage.RULE__FRAGMENT:
        setFragment(FRAGMENT_EDEFAULT);
        return;
      case SimpleAntlrPackage.RULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SimpleAntlrPackage.RULE__PARAMETERS:
        getParameters().clear();
        return;
      case SimpleAntlrPackage.RULE__BODY:
        setBody((RuleElement)null);
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
      case SimpleAntlrPackage.RULE__FRAGMENT:
        return fragment != FRAGMENT_EDEFAULT;
      case SimpleAntlrPackage.RULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SimpleAntlrPackage.RULE__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case SimpleAntlrPackage.RULE__BODY:
        return body != null;
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
    result.append(" (fragment: ");
    result.append(fragment);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //RuleImpl
