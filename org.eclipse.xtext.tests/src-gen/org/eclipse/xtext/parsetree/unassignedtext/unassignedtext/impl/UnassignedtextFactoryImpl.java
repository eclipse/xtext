/**
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnassignedtextFactoryImpl extends EFactoryImpl implements UnassignedtextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnassignedtextFactory init()
  {
    try
    {
      UnassignedtextFactory theUnassignedtextFactory = (UnassignedtextFactory)EPackage.Registry.INSTANCE.getEFactory(UnassignedtextPackage.eNS_URI);
      if (theUnassignedtextFactory != null)
      {
        return theUnassignedtextFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnassignedtextFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedtextFactoryImpl()
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
      case UnassignedtextPackage.MODEL: return createModel();
      case UnassignedtextPackage.CASE_INSENSITIVE_KEYWORD_RULE: return createCaseInsensitiveKeywordRule();
      case UnassignedtextPackage.PLURAL_RULE: return createPluralRule();
      case UnassignedtextPackage.MULTI_RULE: return createMultiRule();
      case UnassignedtextPackage.DATATYPE_RULE: return createDatatypeRule();
      case UnassignedtextPackage.COMMON_TERMINALS_RULE: return createCommonTerminalsRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseInsensitiveKeywordRule createCaseInsensitiveKeywordRule()
  {
    CaseInsensitiveKeywordRuleImpl caseInsensitiveKeywordRule = new CaseInsensitiveKeywordRuleImpl();
    return caseInsensitiveKeywordRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PluralRule createPluralRule()
  {
    PluralRuleImpl pluralRule = new PluralRuleImpl();
    return pluralRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiRule createMultiRule()
  {
    MultiRuleImpl multiRule = new MultiRuleImpl();
    return multiRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeRule createDatatypeRule()
  {
    DatatypeRuleImpl datatypeRule = new DatatypeRuleImpl();
    return datatypeRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommonTerminalsRule createCommonTerminalsRule()
  {
    CommonTerminalsRuleImpl commonTerminalsRule = new CommonTerminalsRuleImpl();
    return commonTerminalsRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedtextPackage getUnassignedtextPackage()
  {
    return (UnassignedtextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnassignedtextPackage getPackage()
  {
    return UnassignedtextPackage.eINSTANCE;
  }

} //UnassignedtextFactoryImpl
