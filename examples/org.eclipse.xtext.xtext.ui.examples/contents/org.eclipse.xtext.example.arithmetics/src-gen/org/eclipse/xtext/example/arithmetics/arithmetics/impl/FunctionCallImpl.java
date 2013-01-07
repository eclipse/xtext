/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.arithmetics.arithmetics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.example.arithmetics.arithmetics.AbstractDefinition;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.arithmetics.arithmetics.impl.FunctionCallImpl#getFunc <em>Func</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.arithmetics.arithmetics.impl.FunctionCallImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionCallImpl extends ExpressionImpl implements FunctionCall
{
  /**
   * The cached value of the '{@link #getFunc() <em>Func</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunc()
   * @generated
   * @ordered
   */
  protected AbstractDefinition func;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expression> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FunctionCallImpl()
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
    return ArithmeticsPackage.Literals.FUNCTION_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDefinition getFunc()
  {
    if (func != null && func.eIsProxy())
    {
      InternalEObject oldFunc = (InternalEObject)func;
      func = (AbstractDefinition)eResolveProxy(oldFunc);
      if (func != oldFunc)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArithmeticsPackage.FUNCTION_CALL__FUNC, oldFunc, func));
      }
    }
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractDefinition basicGetFunc()
  {
    return func;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFunc(AbstractDefinition newFunc)
  {
    AbstractDefinition oldFunc = func;
    func = newFunc;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArithmeticsPackage.FUNCTION_CALL__FUNC, oldFunc, func));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expression>(Expression.class, this, ArithmeticsPackage.FUNCTION_CALL__ARGS);
    }
    return args;
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
      case ArithmeticsPackage.FUNCTION_CALL__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case ArithmeticsPackage.FUNCTION_CALL__FUNC:
        if (resolve) return getFunc();
        return basicGetFunc();
      case ArithmeticsPackage.FUNCTION_CALL__ARGS:
        return getArgs();
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
      case ArithmeticsPackage.FUNCTION_CALL__FUNC:
        setFunc((AbstractDefinition)newValue);
        return;
      case ArithmeticsPackage.FUNCTION_CALL__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
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
      case ArithmeticsPackage.FUNCTION_CALL__FUNC:
        setFunc((AbstractDefinition)null);
        return;
      case ArithmeticsPackage.FUNCTION_CALL__ARGS:
        getArgs().clear();
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
      case ArithmeticsPackage.FUNCTION_CALL__FUNC:
        return func != null;
      case ArithmeticsPackage.FUNCTION_CALL__ARGS:
        return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //FunctionCallImpl
