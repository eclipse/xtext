/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.syntacticsequencertest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyntacticsequencertestFactoryImpl extends EFactoryImpl implements SyntacticsequencertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SyntacticsequencertestFactory init()
  {
    try
    {
      SyntacticsequencertestFactory theSyntacticsequencertestFactory = (SyntacticsequencertestFactory)EPackage.Registry.INSTANCE.getEFactory(SyntacticsequencertestPackage.eNS_URI);
      if (theSyntacticsequencertestFactory != null)
      {
        return theSyntacticsequencertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SyntacticsequencertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyntacticsequencertestFactoryImpl()
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
      case SyntacticsequencertestPackage.MODEL: return createModel();
      case SyntacticsequencertestPackage.MANDATORY_KEYWORDS: return createMandatoryKeywords();
      case SyntacticsequencertestPackage.EXP0: return createExp0();
      case SyntacticsequencertestPackage.EXP1: return createExp1();
      case SyntacticsequencertestPackage.EXP2: return createExp2();
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE: return createSingleCrossReference();
      case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE: return createBooleanAlternative();
      case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE_LITERAL: return createBooleanAlternativeLiteral();
      case SyntacticsequencertestPackage.UNASSIGNED_DATATYPE: return createUnassignedDatatype();
      case SyntacticsequencertestPackage.OPTIONAL_SINGLE_TRANSITION: return createOptionalSingleTransition();
      case SyntacticsequencertestPackage.OPTIONAL_MANY_TRANSITION: return createOptionalManyTransition();
      case SyntacticsequencertestPackage.MANDATORY_MANY_TRANSITION: return createMandatoryManyTransition();
      case SyntacticsequencertestPackage.ALTERNATIVE_TRANSITION: return createAlternativeTransition();
      case SyntacticsequencertestPackage.BOOLEAN_VALUES: return createBooleanValues();
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE: return createLongAlternative();
      case SyntacticsequencertestPackage.ACTION_ONLY: return createActionOnly();
      case SyntacticsequencertestPackage.FRAGMENT_CALLER_TYPE: return createFragmentCallerType();
      case SyntacticsequencertestPackage.ADD0: return createAdd0();
      case SyntacticsequencertestPackage.VAL0: return createVal0();
      case SyntacticsequencertestPackage.ADD1: return createAdd1();
      case SyntacticsequencertestPackage.VAL1: return createVal1();
      case SyntacticsequencertestPackage.ADD2: return createAdd2();
      case SyntacticsequencertestPackage.MULT2: return createMult2();
      case SyntacticsequencertestPackage.VAL2: return createVal2();
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
  public MandatoryKeywords createMandatoryKeywords()
  {
    MandatoryKeywordsImpl mandatoryKeywords = new MandatoryKeywordsImpl();
    return mandatoryKeywords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp0 createExp0()
  {
    Exp0Impl exp0 = new Exp0Impl();
    return exp0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp1 createExp1()
  {
    Exp1Impl exp1 = new Exp1Impl();
    return exp1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exp2 createExp2()
  {
    Exp2Impl exp2 = new Exp2Impl();
    return exp2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleCrossReference createSingleCrossReference()
  {
    SingleCrossReferenceImpl singleCrossReference = new SingleCrossReferenceImpl();
    return singleCrossReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAlternative createBooleanAlternative()
  {
    BooleanAlternativeImpl booleanAlternative = new BooleanAlternativeImpl();
    return booleanAlternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAlternativeLiteral createBooleanAlternativeLiteral()
  {
    BooleanAlternativeLiteralImpl booleanAlternativeLiteral = new BooleanAlternativeLiteralImpl();
    return booleanAlternativeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedDatatype createUnassignedDatatype()
  {
    UnassignedDatatypeImpl unassignedDatatype = new UnassignedDatatypeImpl();
    return unassignedDatatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalSingleTransition createOptionalSingleTransition()
  {
    OptionalSingleTransitionImpl optionalSingleTransition = new OptionalSingleTransitionImpl();
    return optionalSingleTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalManyTransition createOptionalManyTransition()
  {
    OptionalManyTransitionImpl optionalManyTransition = new OptionalManyTransitionImpl();
    return optionalManyTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryManyTransition createMandatoryManyTransition()
  {
    MandatoryManyTransitionImpl mandatoryManyTransition = new MandatoryManyTransitionImpl();
    return mandatoryManyTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlternativeTransition createAlternativeTransition()
  {
    AlternativeTransitionImpl alternativeTransition = new AlternativeTransitionImpl();
    return alternativeTransition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanValues createBooleanValues()
  {
    BooleanValuesImpl booleanValues = new BooleanValuesImpl();
    return booleanValues;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongAlternative createLongAlternative()
  {
    LongAlternativeImpl longAlternative = new LongAlternativeImpl();
    return longAlternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionOnly createActionOnly()
  {
    ActionOnlyImpl actionOnly = new ActionOnlyImpl();
    return actionOnly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FragmentCallerType createFragmentCallerType()
  {
    FragmentCallerTypeImpl fragmentCallerType = new FragmentCallerTypeImpl();
    return fragmentCallerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add0 createAdd0()
  {
    Add0Impl add0 = new Add0Impl();
    return add0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Val0 createVal0()
  {
    Val0Impl val0 = new Val0Impl();
    return val0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add1 createAdd1()
  {
    Add1Impl add1 = new Add1Impl();
    return add1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Val1 createVal1()
  {
    Val1Impl val1 = new Val1Impl();
    return val1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add2 createAdd2()
  {
    Add2Impl add2 = new Add2Impl();
    return add2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mult2 createMult2()
  {
    Mult2Impl mult2 = new Mult2Impl();
    return mult2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Val2 createVal2()
  {
    Val2Impl val2 = new Val2Impl();
    return val2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyntacticsequencertestPackage getSyntacticsequencertestPackage()
  {
    return (SyntacticsequencertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SyntacticsequencertestPackage getPackage()
  {
    return SyntacticsequencertestPackage.eINSTANCE;
  }

} //SyntacticsequencertestFactoryImpl
