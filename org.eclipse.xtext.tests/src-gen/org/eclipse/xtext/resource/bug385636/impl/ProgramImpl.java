/**
 */
package org.eclipse.xtext.resource.bug385636.impl;

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

import org.eclipse.xtext.resource.bug385636.Bug385636Package;
import org.eclipse.xtext.resource.bug385636.DefineVariables;
import org.eclipse.xtext.resource.bug385636.Expression;
import org.eclipse.xtext.resource.bug385636.Program;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.impl.ProgramImpl#getDefine <em>Define</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.bug385636.impl.ProgramImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProgramImpl extends MinimalEObjectImpl.Container implements Program
{
  /**
   * The cached value of the '{@link #getDefine() <em>Define</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefine()
   * @generated
   * @ordered
   */
  protected DefineVariables define;

  /**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
  protected EList<Expression> statements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProgramImpl()
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
    return Bug385636Package.Literals.PROGRAM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineVariables getDefine()
  {
    return define;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDefine(DefineVariables newDefine, NotificationChain msgs)
  {
    DefineVariables oldDefine = define;
    define = newDefine;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Bug385636Package.PROGRAM__DEFINE, oldDefine, newDefine);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefine(DefineVariables newDefine)
  {
    if (newDefine != define)
    {
      NotificationChain msgs = null;
      if (define != null)
        msgs = ((InternalEObject)define).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Bug385636Package.PROGRAM__DEFINE, null, msgs);
      if (newDefine != null)
        msgs = ((InternalEObject)newDefine).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Bug385636Package.PROGRAM__DEFINE, null, msgs);
      msgs = basicSetDefine(newDefine, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Bug385636Package.PROGRAM__DEFINE, newDefine, newDefine));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getStatements()
  {
    if (statements == null)
    {
      statements = new EObjectContainmentEList<Expression>(Expression.class, this, Bug385636Package.PROGRAM__STATEMENTS);
    }
    return statements;
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
      case Bug385636Package.PROGRAM__DEFINE:
        return basicSetDefine(null, msgs);
      case Bug385636Package.PROGRAM__STATEMENTS:
        return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
      case Bug385636Package.PROGRAM__DEFINE:
        return getDefine();
      case Bug385636Package.PROGRAM__STATEMENTS:
        return getStatements();
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
      case Bug385636Package.PROGRAM__DEFINE:
        setDefine((DefineVariables)newValue);
        return;
      case Bug385636Package.PROGRAM__STATEMENTS:
        getStatements().clear();
        getStatements().addAll((Collection<? extends Expression>)newValue);
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
      case Bug385636Package.PROGRAM__DEFINE:
        setDefine((DefineVariables)null);
        return;
      case Bug385636Package.PROGRAM__STATEMENTS:
        getStatements().clear();
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
      case Bug385636Package.PROGRAM__DEFINE:
        return define != null;
      case Bug385636Package.PROGRAM__STATEMENTS:
        return statements != null && !statements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ProgramImpl
