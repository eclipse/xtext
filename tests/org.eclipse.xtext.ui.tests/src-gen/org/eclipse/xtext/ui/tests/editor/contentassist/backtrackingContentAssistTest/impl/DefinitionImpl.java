/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

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

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#getConstraintName <em>Constraint Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#getConstrainedName <em>Constrained Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.DefinitionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefinitionImpl extends MinimalEObjectImpl.Container implements Definition
{
  /**
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #getConstraintName() <em>Constraint Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintName()
   * @generated
   * @ordered
   */
  protected static final String CONSTRAINT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConstraintName() <em>Constraint Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintName()
   * @generated
   * @ordered
   */
  protected String constraintName = CONSTRAINT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getConstrainedName() <em>Constrained Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstrainedName()
   * @generated
   * @ordered
   */
  protected static final String CONSTRAINED_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConstrainedName() <em>Constrained Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstrainedName()
   * @generated
   * @ordered
   */
  protected String constrainedName = CONSTRAINED_NAME_EDEFAULT;

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
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected TypeExp type;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefinitionImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstraintName()
  {
    return constraintName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintName(String newConstraintName)
  {
    String oldConstraintName = constraintName;
    constraintName = newConstraintName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINT_NAME, oldConstraintName, constraintName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstrainedName()
  {
    return constrainedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstrainedName(String newConstrainedName)
  {
    String oldConstrainedName = constrainedName;
    constrainedName = newConstrainedName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINED_NAME, oldConstrainedName, constrainedName));
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
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeExp getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(TypeExp newType, NotificationChain msgs)
  {
    TypeExp oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(TypeExp newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.DEFINITION__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.DEFINITION__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION, newExpression, newExpression));
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
      case BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case BacktrackingContentAssistTestPackage.DEFINITION__TYPE:
        return basicSetType(null, msgs);
      case BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case BacktrackingContentAssistTestPackage.DEFINITION__STATIC:
        return isStatic();
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINT_NAME:
        return getConstraintName();
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINED_NAME:
        return getConstrainedName();
      case BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS:
        return getParameters();
      case BacktrackingContentAssistTestPackage.DEFINITION__TYPE:
        return getType();
      case BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION:
        return getExpression();
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
      case BacktrackingContentAssistTestPackage.DEFINITION__STATIC:
        setStatic((Boolean)newValue);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINT_NAME:
        setConstraintName((String)newValue);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINED_NAME:
        setConstrainedName((String)newValue);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__TYPE:
        setType((TypeExp)newValue);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION:
        setExpression((Expression)newValue);
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
      case BacktrackingContentAssistTestPackage.DEFINITION__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINT_NAME:
        setConstraintName(CONSTRAINT_NAME_EDEFAULT);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINED_NAME:
        setConstrainedName(CONSTRAINED_NAME_EDEFAULT);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS:
        getParameters().clear();
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__TYPE:
        setType((TypeExp)null);
        return;
      case BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION:
        setExpression((Expression)null);
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
      case BacktrackingContentAssistTestPackage.DEFINITION__STATIC:
        return static_ != STATIC_EDEFAULT;
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINT_NAME:
        return CONSTRAINT_NAME_EDEFAULT == null ? constraintName != null : !CONSTRAINT_NAME_EDEFAULT.equals(constraintName);
      case BacktrackingContentAssistTestPackage.DEFINITION__CONSTRAINED_NAME:
        return CONSTRAINED_NAME_EDEFAULT == null ? constrainedName != null : !CONSTRAINED_NAME_EDEFAULT.equals(constrainedName);
      case BacktrackingContentAssistTestPackage.DEFINITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case BacktrackingContentAssistTestPackage.DEFINITION__TYPE:
        return type != null;
      case BacktrackingContentAssistTestPackage.DEFINITION__EXPRESSION:
        return expression != null;
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
    result.append(" (static: ");
    result.append(static_);
    result.append(", constraintName: ");
    result.append(constraintName);
    result.append(", constrainedName: ");
    result.append(constrainedName);
    result.append(')');
    return result.toString();
  }

} //DefinitionImpl
