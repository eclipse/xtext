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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round Bracket Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl#isPre <em>Pre</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl.RoundBracketExpImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundBracketExpImpl extends ExpressionImpl implements RoundBracketExp
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected NameExp name;

  /**
   * The default value of the '{@link #isPre() <em>Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPre()
   * @generated
   * @ordered
   */
  protected static final boolean PRE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPre() <em>Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPre()
   * @generated
   * @ordered
   */
  protected boolean pre = PRE_EDEFAULT;

  /**
   * The cached value of the '{@link #getVariable1() <em>Variable1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable1()
   * @generated
   * @ordered
   */
  protected iteratorVariable variable1;

  /**
   * The cached value of the '{@link #getVariable2() <em>Variable2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariable2()
   * @generated
   * @ordered
   */
  protected EObject variable2;

  /**
   * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArguments()
   * @generated
   * @ordered
   */
  protected EList<Expression> arguments;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RoundBracketExpImpl()
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
    return BacktrackingContentAssistTestPackage.Literals.ROUND_BRACKET_EXP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExp getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(NameExp newName, NotificationChain msgs)
  {
    NameExp oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(NameExp newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPre()
  {
    return pre;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPre(boolean newPre)
  {
    boolean oldPre = pre;
    pre = newPre;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__PRE, oldPre, pre));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public iteratorVariable getVariable1()
  {
    return variable1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable1(iteratorVariable newVariable1, NotificationChain msgs)
  {
    iteratorVariable oldVariable1 = variable1;
    variable1 = newVariable1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1, oldVariable1, newVariable1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable1(iteratorVariable newVariable1)
  {
    if (newVariable1 != variable1)
    {
      NotificationChain msgs = null;
      if (variable1 != null)
        msgs = ((InternalEObject)variable1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1, null, msgs);
      if (newVariable1 != null)
        msgs = ((InternalEObject)newVariable1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1, null, msgs);
      msgs = basicSetVariable1(newVariable1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1, newVariable1, newVariable1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getVariable2()
  {
    return variable2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariable2(EObject newVariable2, NotificationChain msgs)
  {
    EObject oldVariable2 = variable2;
    variable2 = newVariable2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2, oldVariable2, newVariable2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariable2(EObject newVariable2)
  {
    if (newVariable2 != variable2)
    {
      NotificationChain msgs = null;
      if (variable2 != null)
        msgs = ((InternalEObject)variable2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2, null, msgs);
      if (newVariable2 != null)
        msgs = ((InternalEObject)newVariable2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2, null, msgs);
      msgs = basicSetVariable2(newVariable2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2, newVariable2, newVariable2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArguments()
  {
    if (arguments == null)
    {
      arguments = new EObjectContainmentEList<Expression>(Expression.class, this, BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS);
    }
    return arguments;
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
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME:
        return basicSetName(null, msgs);
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1:
        return basicSetVariable1(null, msgs);
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2:
        return basicSetVariable2(null, msgs);
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS:
        return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME:
        return getName();
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__PRE:
        return isPre();
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1:
        return getVariable1();
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2:
        return getVariable2();
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS:
        return getArguments();
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
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME:
        setName((NameExp)newValue);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__PRE:
        setPre((Boolean)newValue);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1:
        setVariable1((iteratorVariable)newValue);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2:
        setVariable2((EObject)newValue);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS:
        getArguments().clear();
        getArguments().addAll((Collection<? extends Expression>)newValue);
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
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME:
        setName((NameExp)null);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__PRE:
        setPre(PRE_EDEFAULT);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1:
        setVariable1((iteratorVariable)null);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2:
        setVariable2((EObject)null);
        return;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS:
        getArguments().clear();
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
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__NAME:
        return name != null;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__PRE:
        return pre != PRE_EDEFAULT;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE1:
        return variable1 != null;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__VARIABLE2:
        return variable2 != null;
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP__ARGUMENTS:
        return arguments != null && !arguments.isEmpty();
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
    result.append(" (pre: ");
    result.append(pre);
    result.append(')');
    return result.toString();
  }

} //RoundBracketExpImpl
