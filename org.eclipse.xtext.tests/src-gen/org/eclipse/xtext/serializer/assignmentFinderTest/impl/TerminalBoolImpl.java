/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage;
import org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Terminal Bool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.impl.TerminalBoolImpl#isTerm <em>Term</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TerminalBoolImpl extends MinimalEObjectImpl.Container implements TerminalBool
{
  /**
   * The default value of the '{@link #isTerm() <em>Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTerm()
   * @generated
   * @ordered
   */
  protected static final boolean TERM_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTerm() <em>Term</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTerm()
   * @generated
   * @ordered
   */
  protected boolean term = TERM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TerminalBoolImpl()
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
    return AssignmentFinderTestPackage.Literals.TERMINAL_BOOL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTerm()
  {
    return term;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerm(boolean newTerm)
  {
    boolean oldTerm = term;
    term = newTerm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AssignmentFinderTestPackage.TERMINAL_BOOL__TERM, oldTerm, term));
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
      case AssignmentFinderTestPackage.TERMINAL_BOOL__TERM:
        return isTerm();
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
      case AssignmentFinderTestPackage.TERMINAL_BOOL__TERM:
        setTerm((Boolean)newValue);
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
      case AssignmentFinderTestPackage.TERMINAL_BOOL__TERM:
        setTerm(TERM_EDEFAULT);
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
      case AssignmentFinderTestPackage.TERMINAL_BOOL__TERM:
        return term != TERM_EDEFAULT;
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
    result.append(" (term: ");
    result.append(term);
    result.append(')');
    return result.toString();
  }

} //TerminalBoolImpl
