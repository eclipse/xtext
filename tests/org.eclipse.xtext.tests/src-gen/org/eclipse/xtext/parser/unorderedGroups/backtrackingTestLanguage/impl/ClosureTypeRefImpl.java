/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ClosureTypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Closure Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ClosureTypeRefImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ClosureTypeRefImpl#isVarArgs <em>Var Args</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl.ClosureTypeRefImpl#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClosureTypeRefImpl extends TypeRefImpl implements ClosureTypeRef
{
  /**
   * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterTypes()
   * @generated
   * @ordered
   */
  protected EList<String> parameterTypes;

  /**
   * The default value of the '{@link #isVarArgs() <em>Var Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVarArgs()
   * @generated
   * @ordered
   */
  protected static final boolean VAR_ARGS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVarArgs() <em>Var Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVarArgs()
   * @generated
   * @ordered
   */
  protected boolean varArgs = VAR_ARGS_EDEFAULT;

  /**
   * The default value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected static final String RETURN_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected String returnType = RETURN_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClosureTypeRefImpl()
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
    return BacktrackingTestLanguagePackage.Literals.CLOSURE_TYPE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getParameterTypes()
  {
    if (parameterTypes == null)
    {
      parameterTypes = new EDataTypeEList<String>(String.class, this, BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__PARAMETER_TYPES);
    }
    return parameterTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVarArgs()
  {
    return varArgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarArgs(boolean newVarArgs)
  {
    boolean oldVarArgs = varArgs;
    varArgs = newVarArgs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__VAR_ARGS, oldVarArgs, varArgs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(String newReturnType)
  {
    String oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__RETURN_TYPE, oldReturnType, returnType));
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
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__PARAMETER_TYPES:
        return getParameterTypes();
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__VAR_ARGS:
        return isVarArgs();
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__RETURN_TYPE:
        return getReturnType();
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
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__PARAMETER_TYPES:
        getParameterTypes().clear();
        getParameterTypes().addAll((Collection<? extends String>)newValue);
        return;
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__VAR_ARGS:
        setVarArgs((Boolean)newValue);
        return;
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__RETURN_TYPE:
        setReturnType((String)newValue);
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
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__PARAMETER_TYPES:
        getParameterTypes().clear();
        return;
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__VAR_ARGS:
        setVarArgs(VAR_ARGS_EDEFAULT);
        return;
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__RETURN_TYPE:
        setReturnType(RETURN_TYPE_EDEFAULT);
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
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__PARAMETER_TYPES:
        return parameterTypes != null && !parameterTypes.isEmpty();
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__VAR_ARGS:
        return varArgs != VAR_ARGS_EDEFAULT;
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF__RETURN_TYPE:
        return RETURN_TYPE_EDEFAULT == null ? returnType != null : !RETURN_TYPE_EDEFAULT.equals(returnType);
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
    result.append(" (parameterTypes: ");
    result.append(parameterTypes);
    result.append(", varArgs: ");
    result.append(varArgs);
    result.append(", returnType: ");
    result.append(returnType);
    result.append(')');
    return result.toString();
  }

} //ClosureTypeRefImpl
