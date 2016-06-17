/**
 */
package org.eclipse.xtext.parser.parameters.parametersTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.parameters.parametersTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParametersTestLanguageFactoryImpl extends EFactoryImpl implements ParametersTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ParametersTestLanguageFactory init()
  {
    try
    {
      ParametersTestLanguageFactory theParametersTestLanguageFactory = (ParametersTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(ParametersTestLanguagePackage.eNS_URI);
      if (theParametersTestLanguageFactory != null)
      {
        return theParametersTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ParametersTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametersTestLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ParametersTestLanguagePackage.PARSER_RULE_PARAMETERS: return createParserRuleParameters();
      case ParametersTestLanguagePackage.SCENARIO: return createScenario();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParserRuleParameters createParserRuleParameters()
  {
    ParserRuleParametersImpl parserRuleParameters = new ParserRuleParametersImpl();
    return parserRuleParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scenario createScenario()
  {
    ScenarioImpl scenario = new ScenarioImpl();
    return scenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParametersTestLanguagePackage getParametersTestLanguagePackage()
  {
    return (ParametersTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ParametersTestLanguagePackage getPackage()
  {
    return ParametersTestLanguagePackage.eINSTANCE;
  }

} //ParametersTestLanguageFactoryImpl
