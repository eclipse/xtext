/**
 */
package org.eclipse.xtext.xtextTest.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.xtextTest.AbstractElement;
import org.eclipse.xtext.xtextTest.ConditionalBranch;
import org.eclipse.xtext.xtextTest.Parameter;
import org.eclipse.xtext.xtextTest.XtextTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl#isFiltered <em>Filtered</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.impl.ConditionalBranchImpl#getGuardedElement <em>Guarded Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalBranchImpl extends AbstractElementImpl implements ConditionalBranch
{
  /**
   * The default value of the '{@link #isFiltered() <em>Filtered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFiltered()
   * @generated
   * @ordered
   */
  protected static final boolean FILTERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFiltered() <em>Filtered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFiltered()
   * @generated
   * @ordered
   */
  protected boolean filtered = FILTERED_EDEFAULT;

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
   * The cached value of the '{@link #getGuardedElement() <em>Guarded Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuardedElement()
   * @generated
   * @ordered
   */
  protected AbstractElement guardedElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalBranchImpl()
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
    return XtextTestPackage.Literals.CONDITIONAL_BRANCH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isFiltered()
  {
    return filtered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFiltered(boolean newFiltered)
  {
    boolean oldFiltered = filtered;
    filtered = newFiltered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.CONDITIONAL_BRANCH__FILTERED, oldFiltered, filtered));
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER, oldParameter, parameter));
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
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER, oldParameter, parameter));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractElement getGuardedElement()
  {
    return guardedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuardedElement(AbstractElement newGuardedElement, NotificationChain msgs)
  {
    AbstractElement oldGuardedElement = guardedElement;
    guardedElement = newGuardedElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT, oldGuardedElement, newGuardedElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuardedElement(AbstractElement newGuardedElement)
  {
    if (newGuardedElement != guardedElement)
    {
      NotificationChain msgs = null;
      if (guardedElement != null)
        msgs = ((InternalEObject)guardedElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT, null, msgs);
      if (newGuardedElement != null)
        msgs = ((InternalEObject)newGuardedElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT, null, msgs);
      msgs = basicSetGuardedElement(newGuardedElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT, newGuardedElement, newGuardedElement));
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
      case XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT:
        return basicSetGuardedElement(null, msgs);
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
      case XtextTestPackage.CONDITIONAL_BRANCH__FILTERED:
        return isFiltered();
      case XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER:
        if (resolve) return getParameter();
        return basicGetParameter();
      case XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT:
        return getGuardedElement();
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
      case XtextTestPackage.CONDITIONAL_BRANCH__FILTERED:
        setFiltered((Boolean)newValue);
        return;
      case XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER:
        setParameter((Parameter)newValue);
        return;
      case XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT:
        setGuardedElement((AbstractElement)newValue);
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
      case XtextTestPackage.CONDITIONAL_BRANCH__FILTERED:
        setFiltered(FILTERED_EDEFAULT);
        return;
      case XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER:
        setParameter((Parameter)null);
        return;
      case XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT:
        setGuardedElement((AbstractElement)null);
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
      case XtextTestPackage.CONDITIONAL_BRANCH__FILTERED:
        return filtered != FILTERED_EDEFAULT;
      case XtextTestPackage.CONDITIONAL_BRANCH__PARAMETER:
        return parameter != null;
      case XtextTestPackage.CONDITIONAL_BRANCH__GUARDED_ELEMENT:
        return guardedElement != null;
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
    result.append(" (filtered: ");
    result.append(filtered);
    result.append(')');
    return result.toString();
  }

} //ConditionalBranchImpl
