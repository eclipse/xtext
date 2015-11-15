/**
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.xtextTest.NamedArgument;
import org.eclipse.xtext.xtextTest.Parameter;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl#isLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.NamedArgumentImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedArgumentImpl extends MinimalEObjectImpl.Container implements NamedArgument
{
  /**
   * The default value of the '{@link #isLiteralValue() <em>Literal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLiteralValue()
   * @generated
   * @ordered
   */
  protected static final boolean LITERAL_VALUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLiteralValue() <em>Literal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLiteralValue()
   * @generated
   * @ordered
   */
  protected boolean literalValue = LITERAL_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected Parameter parameter;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Parameter value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedArgumentImpl()
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
    return XtextTestPackage.Literals.NAMED_ARGUMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLiteralValue()
  {
    return literalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLiteralValue(boolean newLiteralValue)
  {
    boolean oldLiteralValue = literalValue;
    literalValue = newLiteralValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.NAMED_ARGUMENT__LITERAL_VALUE, oldLiteralValue, literalValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter getParameter()
  {
    if (parameter != null && parameter.eIsProxy())
    {
      InternalEObject oldParameter = (InternalEObject)parameter;
      parameter = (Parameter)eResolveProxy(oldParameter);
      if (parameter != oldParameter)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextTestPackage.NAMED_ARGUMENT__PARAMETER, oldParameter, parameter));
      }
    }
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter basicGetParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(Parameter newParameter)
  {
    Parameter oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.NAMED_ARGUMENT__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter getValue()
  {
    if (value != null && value.eIsProxy())
    {
      InternalEObject oldValue = (InternalEObject)value;
      value = (Parameter)eResolveProxy(oldValue);
      if (value != oldValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextTestPackage.NAMED_ARGUMENT__VALUE, oldValue, value));
      }
    }
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter basicGetValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Parameter newValue)
  {
    Parameter oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.NAMED_ARGUMENT__VALUE, oldValue, value));
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
      case XtextTestPackage.NAMED_ARGUMENT__LITERAL_VALUE:
        return isLiteralValue();
      case XtextTestPackage.NAMED_ARGUMENT__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case XtextTestPackage.NAMED_ARGUMENT__VALUE:
        if (resolve) return getValue();
        return basicGetValue();
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
      case XtextTestPackage.NAMED_ARGUMENT__LITERAL_VALUE:
        setLiteralValue((Boolean)newValue);
        return;
      case XtextTestPackage.NAMED_ARGUMENT__PARAMETER:
        setParameter((Parameter)newValue);
        return;
      case XtextTestPackage.NAMED_ARGUMENT__VALUE:
        setValue((Parameter)newValue);
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
      case XtextTestPackage.NAMED_ARGUMENT__LITERAL_VALUE:
        setLiteralValue(LITERAL_VALUE_EDEFAULT);
        return;
      case XtextTestPackage.NAMED_ARGUMENT__PARAMETER:
        setParameter((Parameter)null);
        return;
      case XtextTestPackage.NAMED_ARGUMENT__VALUE:
        setValue((Parameter)null);
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
      case XtextTestPackage.NAMED_ARGUMENT__LITERAL_VALUE:
        return literalValue != LITERAL_VALUE_EDEFAULT;
      case XtextTestPackage.NAMED_ARGUMENT__PARAMETER:
        return parameter != null;
      case XtextTestPackage.NAMED_ARGUMENT__VALUE:
        return value != null;
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
    result.append(" (literalValue: ");
    result.append(literalValue);
    result.append(')');
    return result.toString();
  }

} //NamedArgumentImpl
