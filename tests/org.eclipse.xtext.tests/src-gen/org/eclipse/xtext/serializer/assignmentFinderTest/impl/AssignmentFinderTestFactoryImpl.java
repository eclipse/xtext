/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.assignmentFinderTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignmentFinderTestFactoryImpl extends EFactoryImpl implements AssignmentFinderTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentFinderTestFactory init()
  {
    try
    {
      AssignmentFinderTestFactory theAssignmentFinderTestFactory = (AssignmentFinderTestFactory)EPackage.Registry.INSTANCE.getEFactory(AssignmentFinderTestPackage.eNS_URI);
      if (theAssignmentFinderTestFactory != null)
      {
        return theAssignmentFinderTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AssignmentFinderTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentFinderTestFactoryImpl()
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
      case AssignmentFinderTestPackage.MODEL: return createModel();
      case AssignmentFinderTestPackage.KEYWORD_VAL: return createKeywordVal();
      case AssignmentFinderTestPackage.TERMINAL_VAL: return createTerminalVal();
      case AssignmentFinderTestPackage.ENUM_VAL: return createEnumVal();
      case AssignmentFinderTestPackage.KEYWORD_BOOL: return createKeywordBool();
      case AssignmentFinderTestPackage.TERMINAL_BOOL: return createTerminalBool();
      case AssignmentFinderTestPackage.ENUM_BOOL: return createEnumBool();
      case AssignmentFinderTestPackage.MIXED_BOOL: return createMixedBool();
      case AssignmentFinderTestPackage.MIXED_VALUE: return createMixedValue();
      case AssignmentFinderTestPackage.CONTAINMENT_REF: return createContainmentRef();
      case AssignmentFinderTestPackage.CONTAINMENT_REF_N: return createContainmentRefN();
      case AssignmentFinderTestPackage.CROSS_REF: return createCrossRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AssignmentFinderTestPackage.TEST_ENUM:
        return createTestEnumFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AssignmentFinderTestPackage.TEST_ENUM:
        return convertTestEnumToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public KeywordVal createKeywordVal()
  {
    KeywordValImpl keywordVal = new KeywordValImpl();
    return keywordVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TerminalVal createTerminalVal()
  {
    TerminalValImpl terminalVal = new TerminalValImpl();
    return terminalVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumVal createEnumVal()
  {
    EnumValImpl enumVal = new EnumValImpl();
    return enumVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordBool createKeywordBool()
  {
    KeywordBoolImpl keywordBool = new KeywordBoolImpl();
    return keywordBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TerminalBool createTerminalBool()
  {
    TerminalBoolImpl terminalBool = new TerminalBoolImpl();
    return terminalBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBool createEnumBool()
  {
    EnumBoolImpl enumBool = new EnumBoolImpl();
    return enumBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedBool createMixedBool()
  {
    MixedBoolImpl mixedBool = new MixedBoolImpl();
    return mixedBool;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MixedValue createMixedValue()
  {
    MixedValueImpl mixedValue = new MixedValueImpl();
    return mixedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentRef createContainmentRef()
  {
    ContainmentRefImpl containmentRef = new ContainmentRefImpl();
    return containmentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContainmentRefN createContainmentRefN()
  {
    ContainmentRefNImpl containmentRefN = new ContainmentRefNImpl();
    return containmentRefN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRef createCrossRef()
  {
    CrossRefImpl crossRef = new CrossRefImpl();
    return crossRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestEnum createTestEnumFromString(EDataType eDataType, String initialValue)
  {
    TestEnum result = TestEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTestEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentFinderTestPackage getAssignmentFinderTestPackage()
  {
    return (AssignmentFinderTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AssignmentFinderTestPackage getPackage()
  {
    return AssignmentFinderTestPackage.eINSTANCE;
  }

} //AssignmentFinderTestFactoryImpl
