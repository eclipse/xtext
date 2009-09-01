/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator;
import org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Where Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl#getRightAlias <em>Right Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.impl.VariableWhereEntryImpl#getRightAttribute <em>Right Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableWhereEntryImpl extends AttributeWhereEntryImpl implements VariableWhereEntry
{
  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final NumericOperator OPERATOR_EDEFAULT = NumericOperator.LESS_THEN;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected NumericOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getRightAlias() <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightAlias()
   * @generated
   * @ordered
   */
  protected FromEntry rightAlias;

  /**
   * The cached value of the '{@link #getRightAttribute() <em>Right Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightAttribute()
   * @generated
   * @ordered
   */
  protected EAttribute rightAttribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableWhereEntryImpl()
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
    return Bug287941TestLanguagePackage.Literals.VARIABLE_WHERE_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(NumericOperator newOperator)
  {
    NumericOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry getRightAlias()
  {
    if (rightAlias != null && rightAlias.eIsProxy())
    {
      InternalEObject oldRightAlias = (InternalEObject)rightAlias;
      rightAlias = (FromEntry)eResolveProxy(oldRightAlias);
      if (rightAlias != oldRightAlias)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
      }
    }
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry basicGetRightAlias()
  {
    return rightAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightAlias(FromEntry newRightAlias)
  {
    FromEntry oldRightAlias = rightAlias;
    rightAlias = newRightAlias;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS, oldRightAlias, rightAlias));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRightAttribute()
  {
    if (rightAttribute != null && rightAttribute.eIsProxy())
    {
      InternalEObject oldRightAttribute = (InternalEObject)rightAttribute;
      rightAttribute = (EAttribute)eResolveProxy(oldRightAttribute);
      if (rightAttribute != oldRightAttribute)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE, oldRightAttribute, rightAttribute));
      }
    }
    return rightAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetRightAttribute()
  {
    return rightAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightAttribute(EAttribute newRightAttribute)
  {
    EAttribute oldRightAttribute = rightAttribute;
    rightAttribute = newRightAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE, oldRightAttribute, rightAttribute));
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
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__OPERATOR:
        return getOperator();
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS:
        if (resolve) return getRightAlias();
        return basicGetRightAlias();
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE:
        if (resolve) return getRightAttribute();
        return basicGetRightAttribute();
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
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__OPERATOR:
        setOperator((NumericOperator)newValue);
        return;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)newValue);
        return;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE:
        setRightAttribute((EAttribute)newValue);
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
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS:
        setRightAlias((FromEntry)null);
        return;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE:
        setRightAttribute((EAttribute)null);
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
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ALIAS:
        return rightAlias != null;
      case Bug287941TestLanguagePackage.VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE:
        return rightAttribute != null;
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
    result.append(')');
    return result.toString();
  }

} //VariableWhereEntryImpl
