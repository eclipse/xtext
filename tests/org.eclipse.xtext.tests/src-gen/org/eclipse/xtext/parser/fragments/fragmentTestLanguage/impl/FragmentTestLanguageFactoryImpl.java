/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.fragments.fragmentTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FragmentTestLanguageFactoryImpl extends EFactoryImpl implements FragmentTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FragmentTestLanguageFactory init()
  {
    try
    {
      FragmentTestLanguageFactory theFragmentTestLanguageFactory = (FragmentTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(FragmentTestLanguagePackage.eNS_URI);
      if (theFragmentTestLanguageFactory != null)
      {
        return theFragmentTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FragmentTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentTestLanguageFactoryImpl()
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
      case FragmentTestLanguagePackage.PARSER_RULE_FRAGMENTS: return createParserRuleFragments();
      case FragmentTestLanguagePackage.PRF_NAMED: return createPRFNamed();
      case FragmentTestLanguagePackage.PRF_NAMED_WITH_ACTION: return createPRFNamedWithAction();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParserRuleFragments createParserRuleFragments()
  {
    ParserRuleFragmentsImpl parserRuleFragments = new ParserRuleFragmentsImpl();
    return parserRuleFragments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamed createPRFNamed()
  {
    PRFNamedImpl prfNamed = new PRFNamedImpl();
    return prfNamed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PRFNamedWithAction createPRFNamedWithAction()
  {
    PRFNamedWithActionImpl prfNamedWithAction = new PRFNamedWithActionImpl();
    return prfNamedWithAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentTestLanguagePackage getFragmentTestLanguagePackage()
  {
    return (FragmentTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FragmentTestLanguagePackage getPackage()
  {
    return FragmentTestLanguagePackage.eINSTANCE;
  }

} //FragmentTestLanguageFactoryImpl
