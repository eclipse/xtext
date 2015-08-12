/**
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParametersTestLanguagePackage;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parser Rule Parameters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl.ParserRuleParametersImpl#getScenario <em>Scenario</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParserRuleParametersImpl extends MinimalEObjectImpl.Container implements ParserRuleParameters
{
  /**
   * The cached value of the '{@link #getScenario() <em>Scenario</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScenario()
   * @generated
   * @ordered
   */
  protected Scenario scenario;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParserRuleParametersImpl()
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
    return ParametersTestLanguagePackage.Literals.PARSER_RULE_PARAMETERS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scenario getScenario()
  {
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetScenario(Scenario newScenario, NotificationChain msgs)
  {
    Scenario oldScenario = scenario;
    scenario = newScenario;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO, oldScenario, newScenario);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScenario(Scenario newScenario)
  {
    if (newScenario != scenario)
    {
      NotificationChain msgs = null;
      if (scenario != null)
        msgs = ((InternalEObject)scenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO, null, msgs);
      if (newScenario != null)
        msgs = ((InternalEObject)newScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO, null, msgs);
      msgs = basicSetScenario(newScenario, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO, newScenario, newScenario));
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
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO:
        return basicSetScenario(null, msgs);
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
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO:
        return getScenario();
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
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO:
        setScenario((Scenario)newValue);
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
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO:
        setScenario((Scenario)null);
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
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS__SCENARIO:
        return scenario != null;
    }
    return super.eIsSet(featureID);
  }

} //ParserRuleParametersImpl
