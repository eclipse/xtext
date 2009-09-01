/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringAttributeWhereEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.StringOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.StringAttributeWhereEntryImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringAttributeWhereEntryImpl extends AttributeWhereEntryImpl implements StringAttributeWhereEntry
{
  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final StringOperator OPERATOR_EDEFAULT = StringOperator.EQUAL;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected StringOperator operator = OPERATOR_EDEFAULT;

  /**
   * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected static final String PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected String pattern = PATTERN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringAttributeWhereEntryImpl()
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
    return Bug287941TestLanguagePackage.Literals.STRING_ATTRIBUTE_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(StringOperator newOperator)
  {
    StringOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPattern()
  {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPattern(String newPattern)
  {
    String oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN, oldPattern, pattern));
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
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR:
        return getOperator();
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN:
        return getPattern();
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
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR:
        setOperator((StringOperator)newValue);
        return;
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN:
        setPattern((String)newValue);
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
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN:
        setPattern(PATTERN_EDEFAULT);
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
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case Bug287941TestLanguagePackage.STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN:
        return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(", pattern: ");
    result.append(pattern);
    result.append(')');
    return result.toString();
  }

} //StringAttributeWhereEntryImpl
