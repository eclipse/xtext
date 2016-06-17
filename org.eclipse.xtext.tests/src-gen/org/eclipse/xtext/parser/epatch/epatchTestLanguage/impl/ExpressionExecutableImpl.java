/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Executable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExpressionExecutableImpl#getExprstr <em>Exprstr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionExecutableImpl extends ExecutableImpl implements ExpressionExecutable
{
  /**
   * The default value of the '{@link #getExprstr() <em>Exprstr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprstr()
   * @generated
   * @ordered
   */
  protected static final String EXPRSTR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExprstr() <em>Exprstr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprstr()
   * @generated
   * @ordered
   */
  protected String exprstr = EXPRSTR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionExecutableImpl()
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
    return EpatchTestLanguagePackage.Literals.EXPRESSION_EXECUTABLE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExprstr()
  {
    return exprstr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExprstr(String newExprstr)
  {
    String oldExprstr = exprstr;
    exprstr = newExprstr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE__EXPRSTR, oldExprstr, exprstr));
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
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE__EXPRSTR:
        return getExprstr();
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
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE__EXPRSTR:
        setExprstr((String)newValue);
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
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE__EXPRSTR:
        setExprstr(EXPRSTR_EDEFAULT);
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
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE__EXPRSTR:
        return EXPRSTR_EDEFAULT == null ? exprstr != null : !EXPRSTR_EDEFAULT.equals(exprstr);
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
    result.append(" (exprstr: ");
    result.append(exprstr);
    result.append(')');
    return result.toString();
  }

} //ExpressionExecutableImpl
