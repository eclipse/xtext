/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.Complex1;
import org.eclipse.xtext.serializer.sequencertest.DefEnum;
import org.eclipse.xtext.serializer.sequencertest.Delegation;
import org.eclipse.xtext.serializer.sequencertest.DelegationA;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.FragmentCallerType;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.NullCrossRef;
import org.eclipse.xtext.serializer.sequencertest.NullValue;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.OptionalDouble;
import org.eclipse.xtext.serializer.sequencertest.ParameterCaller;
import org.eclipse.xtext.serializer.sequencertest.ParameterDelegation;
import org.eclipse.xtext.serializer.sequencertest.Parameterized;
import org.eclipse.xtext.serializer.sequencertest.SequencertestFactory;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywords;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SingleTerminals;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternative;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedAlternativeValDelegate;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroup;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupBoolean;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupOptional;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupVal2;
import org.eclipse.xtext.serializer.sequencertest.UnorderedGroupValDelegate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SequencertestFactoryImpl extends EFactoryImpl implements SequencertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SequencertestFactory init()
  {
    try
    {
      SequencertestFactory theSequencertestFactory = (SequencertestFactory)EPackage.Registry.INSTANCE.getEFactory(SequencertestPackage.eNS_URI);
      if (theSequencertestFactory != null)
      {
        return theSequencertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SequencertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencertestFactoryImpl()
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
      case SequencertestPackage.MODEL: return createModel();
      case SequencertestPackage.SIMPLE_GROUP: return createSimpleGroup();
      case SequencertestPackage.SIMPLE_ALTERNATIVE: return createSimpleAlternative();
      case SequencertestPackage.SIMPLE_MULTIPLICITIES: return createSimpleMultiplicities();
      case SequencertestPackage.GROUP_MULTIPLICITIES: return createGroupMultiplicities();
      case SequencertestPackage.ALTERNATIVE_MULTIPLICITIES: return createAlternativeMultiplicities();
      case SequencertestPackage.LIST1: return createList1();
      case SequencertestPackage.LIST2: return createList2();
      case SequencertestPackage.ALT_LIST1: return createAltList1();
      case SequencertestPackage.ALT_LIST2: return createAltList2();
      case SequencertestPackage.SINGLE_KEYWORDS: return createSingleKeywords();
      case SequencertestPackage.SINGLE_KEYWORDS_OR_ID: return createSingleKeywordsOrID();
      case SequencertestPackage.SINGLE_TERMINALS: return createSingleTerminals();
      case SequencertestPackage.SINGLE_ENUM: return createSingleEnum();
      case SequencertestPackage.SINGLE_CROSS_REFERENCE: return createSingleCrossReference();
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE: return createSingleContainmentReference();
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD1: return createSingleContainmentReferenceChild1();
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD2: return createSingleContainmentReferenceChild2();
      case SequencertestPackage.SINGLE_CONTAINMENT_REFERENCE_CHILD3: return createSingleContainmentReferenceChild3();
      case SequencertestPackage.MULTI_KEYWORDS: return createMultiKeywords();
      case SequencertestPackage.MULTI_KEYWORDS_OR_ID: return createMultiKeywordsOrID();
      case SequencertestPackage.MULTI_TERMINALS: return createMultiTerminals();
      case SequencertestPackage.DEPENDENT_ALTERNATIVE1: return createDependentAlternative1();
      case SequencertestPackage.DEPENDENT_ALTERNATIVE2: return createDependentAlternative2();
      case SequencertestPackage.OPTIONAL: return createOptional();
      case SequencertestPackage.FLOAT: return createFloat();
      case SequencertestPackage.UNORDERED_ALTERNATIVE: return createUnorderedAlternative();
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL: return createUnorderedAlternativeVal();
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL_DELEGATE: return createUnorderedAlternativeValDelegate();
      case SequencertestPackage.UNORDERED_ALTERNATIVE_VAL2: return createUnorderedAlternativeVal2();
      case SequencertestPackage.UNORDERED_GROUP: return createUnorderedGroup();
      case SequencertestPackage.UNORDERED_GROUP_VAL: return createUnorderedGroupVal();
      case SequencertestPackage.UNORDERED_GROUP_VAL_DELEGATE: return createUnorderedGroupValDelegate();
      case SequencertestPackage.UNORDERED_GROUP_VAL2: return createUnorderedGroupVal2();
      case SequencertestPackage.UNORDERED_GROUP_OPTIONAL: return createUnorderedGroupOptional();
      case SequencertestPackage.UNORDERED_GROUP_BOOLEAN: return createUnorderedGroupBoolean();
      case SequencertestPackage.COMPLEX1: return createComplex1();
      case SequencertestPackage.OPTIONAL_DOUBLE: return createOptionalDouble();
      case SequencertestPackage.NULL_VALUE: return createNullValue();
      case SequencertestPackage.NULL_CROSS_REF: return createNullCrossRef();
      case SequencertestPackage.FRAGMENT_CALLER_TYPE: return createFragmentCallerType();
      case SequencertestPackage.PARAMETER_CALLER: return createParameterCaller();
      case SequencertestPackage.PARAMETERIZED: return createParameterized();
      case SequencertestPackage.PARAMETER_DELEGATION: return createParameterDelegation();
      case SequencertestPackage.DELEGATION: return createDelegation();
      case SequencertestPackage.DELEGATION_A: return createDelegationA();
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
      case SequencertestPackage.DEF_ENUM:
        return createDefEnumFromString(eDataType, initialValue);
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
      case SequencertestPackage.DEF_ENUM:
        return convertDefEnumToString(eDataType, instanceValue);
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
  public SingleKeywords createSingleKeywords()
  {
    SingleKeywordsImpl singleKeywords = new SingleKeywordsImpl();
    return singleKeywords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleKeywordsOrID createSingleKeywordsOrID()
  {
    SingleKeywordsOrIDImpl singleKeywordsOrID = new SingleKeywordsOrIDImpl();
    return singleKeywordsOrID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleTerminals createSingleTerminals()
  {
    SingleTerminalsImpl singleTerminals = new SingleTerminalsImpl();
    return singleTerminals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleEnum createSingleEnum()
  {
    SingleEnumImpl singleEnum = new SingleEnumImpl();
    return singleEnum;
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
  public SingleContainmentReference createSingleContainmentReference()
  {
    SingleContainmentReferenceImpl singleContainmentReference = new SingleContainmentReferenceImpl();
    return singleContainmentReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleContainmentReferenceChild1 createSingleContainmentReferenceChild1()
  {
    SingleContainmentReferenceChild1Impl singleContainmentReferenceChild1 = new SingleContainmentReferenceChild1Impl();
    return singleContainmentReferenceChild1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleContainmentReferenceChild2 createSingleContainmentReferenceChild2()
  {
    SingleContainmentReferenceChild2Impl singleContainmentReferenceChild2 = new SingleContainmentReferenceChild2Impl();
    return singleContainmentReferenceChild2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleContainmentReferenceChild3 createSingleContainmentReferenceChild3()
  {
    SingleContainmentReferenceChild3Impl singleContainmentReferenceChild3 = new SingleContainmentReferenceChild3Impl();
    return singleContainmentReferenceChild3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiKeywords createMultiKeywords()
  {
    MultiKeywordsImpl multiKeywords = new MultiKeywordsImpl();
    return multiKeywords;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiKeywordsOrID createMultiKeywordsOrID()
  {
    MultiKeywordsOrIDImpl multiKeywordsOrID = new MultiKeywordsOrIDImpl();
    return multiKeywordsOrID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiTerminals createMultiTerminals()
  {
    MultiTerminalsImpl multiTerminals = new MultiTerminalsImpl();
    return multiTerminals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependentAlternative1 createDependentAlternative1()
  {
    DependentAlternative1Impl dependentAlternative1 = new DependentAlternative1Impl();
    return dependentAlternative1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependentAlternative2 createDependentAlternative2()
  {
    DependentAlternative2Impl dependentAlternative2 = new DependentAlternative2Impl();
    return dependentAlternative2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Optional createOptional()
  {
    OptionalImpl optional = new OptionalImpl();
    return optional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.serializer.sequencertest.Float createFloat()
  {
    FloatImpl float_ = new FloatImpl();
    return float_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedAlternative createUnorderedAlternative()
  {
    UnorderedAlternativeImpl unorderedAlternative = new UnorderedAlternativeImpl();
    return unorderedAlternative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedAlternativeVal createUnorderedAlternativeVal()
  {
    UnorderedAlternativeValImpl unorderedAlternativeVal = new UnorderedAlternativeValImpl();
    return unorderedAlternativeVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedAlternativeValDelegate createUnorderedAlternativeValDelegate()
  {
    UnorderedAlternativeValDelegateImpl unorderedAlternativeValDelegate = new UnorderedAlternativeValDelegateImpl();
    return unorderedAlternativeValDelegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedAlternativeVal2 createUnorderedAlternativeVal2()
  {
    UnorderedAlternativeVal2Impl unorderedAlternativeVal2 = new UnorderedAlternativeVal2Impl();
    return unorderedAlternativeVal2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroup createUnorderedGroup()
  {
    UnorderedGroupImpl unorderedGroup = new UnorderedGroupImpl();
    return unorderedGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupVal createUnorderedGroupVal()
  {
    UnorderedGroupValImpl unorderedGroupVal = new UnorderedGroupValImpl();
    return unorderedGroupVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupValDelegate createUnorderedGroupValDelegate()
  {
    UnorderedGroupValDelegateImpl unorderedGroupValDelegate = new UnorderedGroupValDelegateImpl();
    return unorderedGroupValDelegate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupVal2 createUnorderedGroupVal2()
  {
    UnorderedGroupVal2Impl unorderedGroupVal2 = new UnorderedGroupVal2Impl();
    return unorderedGroupVal2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupOptional createUnorderedGroupOptional()
  {
    UnorderedGroupOptionalImpl unorderedGroupOptional = new UnorderedGroupOptionalImpl();
    return unorderedGroupOptional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupBoolean createUnorderedGroupBoolean()
  {
    UnorderedGroupBooleanImpl unorderedGroupBoolean = new UnorderedGroupBooleanImpl();
    return unorderedGroupBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Complex1 createComplex1()
  {
    Complex1Impl complex1 = new Complex1Impl();
    return complex1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OptionalDouble createOptionalDouble()
  {
    OptionalDoubleImpl optionalDouble = new OptionalDoubleImpl();
    return optionalDouble;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullValue createNullValue()
  {
    NullValueImpl nullValue = new NullValueImpl();
    return nullValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullCrossRef createNullCrossRef()
  {
    NullCrossRefImpl nullCrossRef = new NullCrossRefImpl();
    return nullCrossRef;
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
  public ParameterCaller createParameterCaller()
  {
    ParameterCallerImpl parameterCaller = new ParameterCallerImpl();
    return parameterCaller;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameterized createParameterized()
  {
    ParameterizedImpl parameterized = new ParameterizedImpl();
    return parameterized;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDelegation createParameterDelegation()
  {
    ParameterDelegationImpl parameterDelegation = new ParameterDelegationImpl();
    return parameterDelegation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Delegation createDelegation()
  {
    DelegationImpl delegation = new DelegationImpl();
    return delegation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DelegationA createDelegationA()
  {
    DelegationAImpl delegationA = new DelegationAImpl();
    return delegationA;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefEnum createDefEnumFromString(EDataType eDataType, String initialValue)
  {
    DefEnum result = DefEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDefEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencertestPackage getSequencertestPackage()
  {
    return (SequencertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SequencertestPackage getPackage()
  {
    return SequencertestPackage.eINSTANCE;
  }

} //SequencertestFactoryImpl
