/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.validation.csvalidationtest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CsvalidationtestFactoryImpl extends EFactoryImpl implements CsvalidationtestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CsvalidationtestFactory init()
  {
    try
    {
      CsvalidationtestFactory theCsvalidationtestFactory = (CsvalidationtestFactory)EPackage.Registry.INSTANCE.getEFactory(CsvalidationtestPackage.eNS_URI);
      if (theCsvalidationtestFactory != null)
      {
        return theCsvalidationtestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CsvalidationtestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CsvalidationtestFactoryImpl()
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
      case CsvalidationtestPackage.MODEL: return createModel();
      case CsvalidationtestPackage.SIMPLE_GROUP: return createSimpleGroup();
      case CsvalidationtestPackage.SIMPLE_ALTERNATIVE: return createSimpleAlternative();
      case CsvalidationtestPackage.SIMPLE_MULTIPLICITIES: return createSimpleMultiplicities();
      case CsvalidationtestPackage.GROUP_MULTIPLICITIES: return createGroupMultiplicities();
      case CsvalidationtestPackage.ALTERNATIVE_MULTIPLICITIES: return createAlternativeMultiplicities();
      case CsvalidationtestPackage.ASSIGNED_ACTION: return createAssignedAction();
      case CsvalidationtestPackage.UNASSIGNED_ACTION1: return createUnassignedAction1();
      case CsvalidationtestPackage.UNASSIGNED_ACTION2: return createUnassignedAction2();
      case CsvalidationtestPackage.UNASSIGNED_ACTION3: return createUnassignedAction3();
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL1: return createUnassignedRuleCall1();
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL1_SUB: return createUnassignedRuleCall1Sub();
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2: return createUnassignedRuleCall2();
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2_SUB: return createUnassignedRuleCall2Sub();
      case CsvalidationtestPackage.COMBINATION1: return createCombination1();
      case CsvalidationtestPackage.COMBINATION2: return createCombination2();
      case CsvalidationtestPackage.COMBINATION3: return createCombination3();
      case CsvalidationtestPackage.COMBINATION4: return createCombination4();
      case CsvalidationtestPackage.LIST1: return createList1();
      case CsvalidationtestPackage.LIST2: return createList2();
      case CsvalidationtestPackage.LIST3: return createList3();
      case CsvalidationtestPackage.LIST4: return createList4();
      case CsvalidationtestPackage.LIST5: return createList5();
      case CsvalidationtestPackage.ALT_LIST1: return createAltList1();
      case CsvalidationtestPackage.ALT_LIST2: return createAltList2();
      case CsvalidationtestPackage.TRANSIENT_OBJECT: return createTransientObject();
      case CsvalidationtestPackage.TRANSIENT_OBJECT_SUB: return createTransientObjectSub();
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1: return createTransientSerializeables1();
      case CsvalidationtestPackage.STATIC_SIMPLIFICATION: return createStaticSimplification();
      case CsvalidationtestPackage.TWO_VERSION: return createTwoVersion();
      case CsvalidationtestPackage.HEURISTIC1: return createHeuristic1();
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB: return createUnassignedAction2Sub();
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB1: return createUnassignedAction2Sub1();
      case CsvalidationtestPackage.UNASSIGNED_ACTION2_SUB2: return createUnassignedAction2Sub2();
      case CsvalidationtestPackage.UNASSIGNED_RULE_CALL2_SUB_ACTION: return createUnassignedRuleCall2SubAction();
      case CsvalidationtestPackage.EMPTY_ALTERNATIVE_SUB: return createEmptyAlternativeSub();
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1_ENUM:
        return createTransientSerializeables1EnumFromString(eDataType, initialValue);
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
      case CsvalidationtestPackage.TRANSIENT_SERIALIZEABLES1_ENUM:
        return convertTransientSerializeables1EnumToString(eDataType, instanceValue);
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
  public SimpleGroup createSimpleGroup()
  {
    SimpleGroupImpl simpleGroup = new SimpleGroupImpl();
    return simpleGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAlternative createSimpleAlternative()
  {
    SimpleAlternativeImpl simpleAlternative = new SimpleAlternativeImpl();
    return simpleAlternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleMultiplicities createSimpleMultiplicities()
  {
    SimpleMultiplicitiesImpl simpleMultiplicities = new SimpleMultiplicitiesImpl();
    return simpleMultiplicities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupMultiplicities createGroupMultiplicities()
  {
    GroupMultiplicitiesImpl groupMultiplicities = new GroupMultiplicitiesImpl();
    return groupMultiplicities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlternativeMultiplicities createAlternativeMultiplicities()
  {
    AlternativeMultiplicitiesImpl alternativeMultiplicities = new AlternativeMultiplicitiesImpl();
    return alternativeMultiplicities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignedAction createAssignedAction()
  {
    AssignedActionImpl assignedAction = new AssignedActionImpl();
    return assignedAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction1 createUnassignedAction1()
  {
    UnassignedAction1Impl unassignedAction1 = new UnassignedAction1Impl();
    return unassignedAction1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction2 createUnassignedAction2()
  {
    UnassignedAction2Impl unassignedAction2 = new UnassignedAction2Impl();
    return unassignedAction2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction3 createUnassignedAction3()
  {
    UnassignedAction3Impl unassignedAction3 = new UnassignedAction3Impl();
    return unassignedAction3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall1 createUnassignedRuleCall1()
  {
    UnassignedRuleCall1Impl unassignedRuleCall1 = new UnassignedRuleCall1Impl();
    return unassignedRuleCall1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall1Sub createUnassignedRuleCall1Sub()
  {
    UnassignedRuleCall1SubImpl unassignedRuleCall1Sub = new UnassignedRuleCall1SubImpl();
    return unassignedRuleCall1Sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall2 createUnassignedRuleCall2()
  {
    UnassignedRuleCall2Impl unassignedRuleCall2 = new UnassignedRuleCall2Impl();
    return unassignedRuleCall2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall2Sub createUnassignedRuleCall2Sub()
  {
    UnassignedRuleCall2SubImpl unassignedRuleCall2Sub = new UnassignedRuleCall2SubImpl();
    return unassignedRuleCall2Sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination1 createCombination1()
  {
    Combination1Impl combination1 = new Combination1Impl();
    return combination1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination2 createCombination2()
  {
    Combination2Impl combination2 = new Combination2Impl();
    return combination2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination3 createCombination3()
  {
    Combination3Impl combination3 = new Combination3Impl();
    return combination3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Combination4 createCombination4()
  {
    Combination4Impl combination4 = new Combination4Impl();
    return combination4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List1 createList1()
  {
    List1Impl list1 = new List1Impl();
    return list1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List2 createList2()
  {
    List2Impl list2 = new List2Impl();
    return list2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List3 createList3()
  {
    List3Impl list3 = new List3Impl();
    return list3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List4 createList4()
  {
    List4Impl list4 = new List4Impl();
    return list4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public List5 createList5()
  {
    List5Impl list5 = new List5Impl();
    return list5;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList1 createAltList1()
  {
    AltList1Impl altList1 = new AltList1Impl();
    return altList1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AltList2 createAltList2()
  {
    AltList2Impl altList2 = new AltList2Impl();
    return altList2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientObject createTransientObject()
  {
    TransientObjectImpl transientObject = new TransientObjectImpl();
    return transientObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientObjectSub createTransientObjectSub()
  {
    TransientObjectSubImpl transientObjectSub = new TransientObjectSubImpl();
    return transientObjectSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientSerializeables1 createTransientSerializeables1()
  {
    TransientSerializeables1Impl transientSerializeables1 = new TransientSerializeables1Impl();
    return transientSerializeables1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticSimplification createStaticSimplification()
  {
    StaticSimplificationImpl staticSimplification = new StaticSimplificationImpl();
    return staticSimplification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoVersion createTwoVersion()
  {
    TwoVersionImpl twoVersion = new TwoVersionImpl();
    return twoVersion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Heuristic1 createHeuristic1()
  {
    Heuristic1Impl heuristic1 = new Heuristic1Impl();
    return heuristic1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction2Sub createUnassignedAction2Sub()
  {
    UnassignedAction2SubImpl unassignedAction2Sub = new UnassignedAction2SubImpl();
    return unassignedAction2Sub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction2Sub1 createUnassignedAction2Sub1()
  {
    UnassignedAction2Sub1Impl unassignedAction2Sub1 = new UnassignedAction2Sub1Impl();
    return unassignedAction2Sub1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedAction2Sub2 createUnassignedAction2Sub2()
  {
    UnassignedAction2Sub2Impl unassignedAction2Sub2 = new UnassignedAction2Sub2Impl();
    return unassignedAction2Sub2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnassignedRuleCall2SubAction createUnassignedRuleCall2SubAction()
  {
    UnassignedRuleCall2SubActionImpl unassignedRuleCall2SubAction = new UnassignedRuleCall2SubActionImpl();
    return unassignedRuleCall2SubAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyAlternativeSub createEmptyAlternativeSub()
  {
    EmptyAlternativeSubImpl emptyAlternativeSub = new EmptyAlternativeSubImpl();
    return emptyAlternativeSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransientSerializeables1Enum createTransientSerializeables1EnumFromString(EDataType eDataType, String initialValue)
  {
    TransientSerializeables1Enum result = TransientSerializeables1Enum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTransientSerializeables1EnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CsvalidationtestPackage getCsvalidationtestPackage()
  {
    return (CsvalidationtestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CsvalidationtestPackage getPackage()
  {
    return CsvalidationtestPackage.eINSTANCE;
  }

} //CsvalidationtestFactoryImpl
