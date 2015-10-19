/**
 */
package org.eclipse.xtext.serializer.sequencertest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SequencertestPackageImpl extends EPackageImpl implements SequencertestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleGroupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleAlternativeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleMultiplicitiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupMultiplicitiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alternativeMultiplicitiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass list1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass list2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass altList1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass altList2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleKeywordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleKeywordsOrIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleTerminalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleEnumEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleCrossReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleContainmentReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleContainmentReferenceChild1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleContainmentReferenceChild2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleContainmentReferenceChild3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiKeywordsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiKeywordsOrIDEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiTerminalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependentAlternative1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependentAlternative2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass floatEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedAlternativeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedAlternativeValEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedAlternativeValDelegateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedAlternativeVal2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupValEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupValDelegateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupVal2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupOptionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unorderedGroupBooleanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complex1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass optionalDoubleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullCrossRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fragmentCallerTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterCallerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterizedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterDelegationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass delegationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass delegationAEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum defEnumEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SequencertestPackageImpl()
  {
    super(eNS_URI, SequencertestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SequencertestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SequencertestPackage init()
  {
    if (isInited) return (SequencertestPackage)EPackage.Registry.INSTANCE.getEPackage(SequencertestPackage.eNS_URI);

    // Obtain or create and register package
    SequencertestPackageImpl theSequencertestPackage = (SequencertestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SequencertestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SequencertestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSequencertestPackage.createPackageContents();

    // Initialize created meta-data
    theSequencertestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSequencertestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SequencertestPackage.eNS_URI, theSequencertestPackage);
    return theSequencertestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X1()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X2()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X3()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X4()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X5()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X6()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X7()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X8()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X9()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X10()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X11()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X12()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X13()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X14()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X15()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X19()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X20()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X21()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X22()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(18);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X23()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(19);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X24()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(20);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X25()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(21);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X26()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(22);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X27()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(23);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X28()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(24);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X29()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(25);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X30()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(26);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X31()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(27);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X32()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(28);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X33()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(29);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X34()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(30);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X35()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(31);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleGroup()
  {
    return simpleGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleGroup_Val1()
  {
    return (EAttribute)simpleGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleGroup_Val2()
  {
    return (EAttribute)simpleGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleAlternative()
  {
    return simpleAlternativeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleAlternative_Val1()
  {
    return (EAttribute)simpleAlternativeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleAlternative_Val2()
  {
    return (EAttribute)simpleAlternativeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleMultiplicities()
  {
    return simpleMultiplicitiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleMultiplicities_Val1()
  {
    return (EAttribute)simpleMultiplicitiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleMultiplicities_Val2()
  {
    return (EAttribute)simpleMultiplicitiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleMultiplicities_Val3()
  {
    return (EAttribute)simpleMultiplicitiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleMultiplicities_Val4()
  {
    return (EAttribute)simpleMultiplicitiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGroupMultiplicities()
  {
    return groupMultiplicitiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val1()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val2()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val3()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val4()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val5()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val6()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGroupMultiplicities_Val7()
  {
    return (EAttribute)groupMultiplicitiesEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlternativeMultiplicities()
  {
    return alternativeMultiplicitiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val2()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val3()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val4()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val5()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val6()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAlternativeMultiplicities_Val7()
  {
    return (EAttribute)alternativeMultiplicitiesEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList1()
  {
    return list1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList1_Val1()
  {
    return (EAttribute)list1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList2()
  {
    return list2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList2_Val1()
  {
    return (EAttribute)list2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAltList1()
  {
    return altList1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList1_Val1()
  {
    return (EAttribute)altList1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList1_Val2()
  {
    return (EAttribute)altList1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList1_Val3()
  {
    return (EAttribute)altList1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList1_Val4()
  {
    return (EAttribute)altList1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAltList2()
  {
    return altList2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList2_Val1()
  {
    return (EAttribute)altList2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList2_Val2()
  {
    return (EAttribute)altList2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAltList2_Val3()
  {
    return (EAttribute)altList2EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleKeywords()
  {
    return singleKeywordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleKeywords_Val()
  {
    return (EAttribute)singleKeywordsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleKeywordsOrID()
  {
    return singleKeywordsOrIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleKeywordsOrID_Val()
  {
    return (EAttribute)singleKeywordsOrIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleTerminals()
  {
    return singleTerminalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleTerminals_Val()
  {
    return (EAttribute)singleTerminalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleEnum()
  {
    return singleEnumEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleEnum_Val()
  {
    return (EAttribute)singleEnumEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleCrossReference()
  {
    return singleCrossReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleCrossReference_Name()
  {
    return (EAttribute)singleCrossReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleCrossReference_Ref()
  {
    return (EReference)singleCrossReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleContainmentReference()
  {
    return singleContainmentReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleContainmentReference_Child()
  {
    return (EReference)singleContainmentReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleContainmentReferenceChild1()
  {
    return singleContainmentReferenceChild1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleContainmentReferenceChild1_Val()
  {
    return (EAttribute)singleContainmentReferenceChild1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleContainmentReferenceChild2()
  {
    return singleContainmentReferenceChild2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleContainmentReferenceChild2_Val()
  {
    return (EAttribute)singleContainmentReferenceChild2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleContainmentReferenceChild3()
  {
    return singleContainmentReferenceChild3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleContainmentReferenceChild3_Val()
  {
    return (EAttribute)singleContainmentReferenceChild3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiKeywords()
  {
    return multiKeywordsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiKeywords_Val()
  {
    return (EAttribute)multiKeywordsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiKeywordsOrID()
  {
    return multiKeywordsOrIDEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiKeywordsOrID_Val()
  {
    return (EAttribute)multiKeywordsOrIDEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiTerminals()
  {
    return multiTerminalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiTerminals_Val()
  {
    return (EAttribute)multiTerminalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependentAlternative1()
  {
    return dependentAlternative1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependentAlternative1_Val()
  {
    return (EAttribute)dependentAlternative1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependentAlternative1_Flag()
  {
    return (EAttribute)dependentAlternative1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependentAlternative2()
  {
    return dependentAlternative2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependentAlternative2_Val()
  {
    return (EAttribute)dependentAlternative2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDependentAlternative2_Flag()
  {
    return (EAttribute)dependentAlternative2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptional()
  {
    return optionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptional_Int0()
  {
    return (EAttribute)optionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptional_Int1()
  {
    return (EAttribute)optionalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptional_Int2()
  {
    return (EAttribute)optionalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFloat()
  {
    return floatEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedAlternative()
  {
    return unorderedAlternativeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedAlternative_Val1()
  {
    return (EAttribute)unorderedAlternativeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedAlternative_Val2()
  {
    return (EAttribute)unorderedAlternativeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnorderedAlternative_Val3()
  {
    return (EReference)unorderedAlternativeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnorderedAlternative_Val4()
  {
    return (EReference)unorderedAlternativeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedAlternativeVal()
  {
    return unorderedAlternativeValEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedAlternativeVal_Val()
  {
    return (EAttribute)unorderedAlternativeValEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedAlternativeValDelegate()
  {
    return unorderedAlternativeValDelegateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedAlternativeVal2()
  {
    return unorderedAlternativeVal2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedAlternativeVal2_Val()
  {
    return (EAttribute)unorderedAlternativeVal2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroup()
  {
    return unorderedGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroup_Val1()
  {
    return (EAttribute)unorderedGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroup_Val2()
  {
    return (EAttribute)unorderedGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnorderedGroup_Val3()
  {
    return (EReference)unorderedGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnorderedGroup_Val4()
  {
    return (EReference)unorderedGroupEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroupVal()
  {
    return unorderedGroupValEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupVal_Val()
  {
    return (EAttribute)unorderedGroupValEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroupValDelegate()
  {
    return unorderedGroupValDelegateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroupVal2()
  {
    return unorderedGroupVal2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupVal2_Val()
  {
    return (EAttribute)unorderedGroupVal2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroupOptional()
  {
    return unorderedGroupOptionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupOptional_Val1()
  {
    return (EAttribute)unorderedGroupOptionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupOptional_Va2()
  {
    return (EAttribute)unorderedGroupOptionalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupOptional_Val3()
  {
    return (EAttribute)unorderedGroupOptionalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnorderedGroupBoolean()
  {
    return unorderedGroupBooleanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupBoolean_Val1()
  {
    return (EAttribute)unorderedGroupBooleanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupBoolean_Val2()
  {
    return (EAttribute)unorderedGroupBooleanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnorderedGroupBoolean_Val3()
  {
    return (EAttribute)unorderedGroupBooleanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplex1()
  {
    return complex1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val1()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val2()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val3()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val4()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val5()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplex1_Val6()
  {
    return (EAttribute)complex1EClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOptionalDouble()
  {
    return optionalDoubleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalDouble_Double0()
  {
    return (EAttribute)optionalDoubleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalDouble_Double1()
  {
    return (EAttribute)optionalDoubleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOptionalDouble_Double2()
  {
    return (EAttribute)optionalDoubleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullValue()
  {
    return nullValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNullValue_Value()
  {
    return (EAttribute)nullValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNullValue_Foo()
  {
    return (EAttribute)nullValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullCrossRef()
  {
    return nullCrossRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNullCrossRef_Ref()
  {
    return (EReference)nullCrossRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNullCrossRef_Foo()
  {
    return (EAttribute)nullCrossRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFragmentCallerType()
  {
    return fragmentCallerTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFragmentCallerType_Val1()
  {
    return (EAttribute)fragmentCallerTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFragmentCallerType_Val()
  {
    return (EAttribute)fragmentCallerTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFragmentCallerType_FragVal()
  {
    return (EAttribute)fragmentCallerTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterCaller()
  {
    return parameterCallerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterCaller_P()
  {
    return (EReference)parameterCallerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterized()
  {
    return parameterizedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterized_V1()
  {
    return (EAttribute)parameterizedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterized_V2()
  {
    return (EAttribute)parameterizedEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterized_V3()
  {
    return (EAttribute)parameterizedEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterDelegation()
  {
    return parameterDelegationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDelegation_P()
  {
    return (EReference)parameterDelegationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDelegation()
  {
    return delegationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDelegation_P()
  {
    return (EAttribute)delegationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDelegation_Np()
  {
    return (EAttribute)delegationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDelegationA()
  {
    return delegationAEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDelegationA_Left()
  {
    return (EReference)delegationAEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDelegationA_Rc2()
  {
    return (EReference)delegationAEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDefEnum()
  {
    return defEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencertestFactory getSequencertestFactory()
  {
    return (SequencertestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__X1);
    createEReference(modelEClass, MODEL__X2);
    createEReference(modelEClass, MODEL__X3);
    createEReference(modelEClass, MODEL__X4);
    createEReference(modelEClass, MODEL__X5);
    createEReference(modelEClass, MODEL__X6);
    createEReference(modelEClass, MODEL__X7);
    createEReference(modelEClass, MODEL__X8);
    createEReference(modelEClass, MODEL__X9);
    createEReference(modelEClass, MODEL__X10);
    createEReference(modelEClass, MODEL__X11);
    createEReference(modelEClass, MODEL__X12);
    createEReference(modelEClass, MODEL__X13);
    createEReference(modelEClass, MODEL__X14);
    createEReference(modelEClass, MODEL__X15);
    createEReference(modelEClass, MODEL__X19);
    createEReference(modelEClass, MODEL__X20);
    createEReference(modelEClass, MODEL__X21);
    createEReference(modelEClass, MODEL__X22);
    createEReference(modelEClass, MODEL__X23);
    createEReference(modelEClass, MODEL__X24);
    createEReference(modelEClass, MODEL__X25);
    createEReference(modelEClass, MODEL__X26);
    createEReference(modelEClass, MODEL__X27);
    createEReference(modelEClass, MODEL__X28);
    createEReference(modelEClass, MODEL__X29);
    createEReference(modelEClass, MODEL__X30);
    createEReference(modelEClass, MODEL__X31);
    createEReference(modelEClass, MODEL__X32);
    createEReference(modelEClass, MODEL__X33);
    createEReference(modelEClass, MODEL__X34);
    createEReference(modelEClass, MODEL__X35);

    simpleGroupEClass = createEClass(SIMPLE_GROUP);
    createEAttribute(simpleGroupEClass, SIMPLE_GROUP__VAL1);
    createEAttribute(simpleGroupEClass, SIMPLE_GROUP__VAL2);

    simpleAlternativeEClass = createEClass(SIMPLE_ALTERNATIVE);
    createEAttribute(simpleAlternativeEClass, SIMPLE_ALTERNATIVE__VAL1);
    createEAttribute(simpleAlternativeEClass, SIMPLE_ALTERNATIVE__VAL2);

    simpleMultiplicitiesEClass = createEClass(SIMPLE_MULTIPLICITIES);
    createEAttribute(simpleMultiplicitiesEClass, SIMPLE_MULTIPLICITIES__VAL1);
    createEAttribute(simpleMultiplicitiesEClass, SIMPLE_MULTIPLICITIES__VAL2);
    createEAttribute(simpleMultiplicitiesEClass, SIMPLE_MULTIPLICITIES__VAL3);
    createEAttribute(simpleMultiplicitiesEClass, SIMPLE_MULTIPLICITIES__VAL4);

    groupMultiplicitiesEClass = createEClass(GROUP_MULTIPLICITIES);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL1);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL2);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL3);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL4);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL5);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL6);
    createEAttribute(groupMultiplicitiesEClass, GROUP_MULTIPLICITIES__VAL7);

    alternativeMultiplicitiesEClass = createEClass(ALTERNATIVE_MULTIPLICITIES);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL2);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL3);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL4);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL5);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL6);
    createEAttribute(alternativeMultiplicitiesEClass, ALTERNATIVE_MULTIPLICITIES__VAL7);

    list1EClass = createEClass(LIST1);
    createEAttribute(list1EClass, LIST1__VAL1);

    list2EClass = createEClass(LIST2);
    createEAttribute(list2EClass, LIST2__VAL1);

    altList1EClass = createEClass(ALT_LIST1);
    createEAttribute(altList1EClass, ALT_LIST1__VAL1);
    createEAttribute(altList1EClass, ALT_LIST1__VAL2);
    createEAttribute(altList1EClass, ALT_LIST1__VAL3);
    createEAttribute(altList1EClass, ALT_LIST1__VAL4);

    altList2EClass = createEClass(ALT_LIST2);
    createEAttribute(altList2EClass, ALT_LIST2__VAL1);
    createEAttribute(altList2EClass, ALT_LIST2__VAL2);
    createEAttribute(altList2EClass, ALT_LIST2__VAL3);

    singleKeywordsEClass = createEClass(SINGLE_KEYWORDS);
    createEAttribute(singleKeywordsEClass, SINGLE_KEYWORDS__VAL);

    singleKeywordsOrIDEClass = createEClass(SINGLE_KEYWORDS_OR_ID);
    createEAttribute(singleKeywordsOrIDEClass, SINGLE_KEYWORDS_OR_ID__VAL);

    singleTerminalsEClass = createEClass(SINGLE_TERMINALS);
    createEAttribute(singleTerminalsEClass, SINGLE_TERMINALS__VAL);

    singleEnumEClass = createEClass(SINGLE_ENUM);
    createEAttribute(singleEnumEClass, SINGLE_ENUM__VAL);

    singleCrossReferenceEClass = createEClass(SINGLE_CROSS_REFERENCE);
    createEAttribute(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__NAME);
    createEReference(singleCrossReferenceEClass, SINGLE_CROSS_REFERENCE__REF);

    singleContainmentReferenceEClass = createEClass(SINGLE_CONTAINMENT_REFERENCE);
    createEReference(singleContainmentReferenceEClass, SINGLE_CONTAINMENT_REFERENCE__CHILD);

    singleContainmentReferenceChild1EClass = createEClass(SINGLE_CONTAINMENT_REFERENCE_CHILD1);
    createEAttribute(singleContainmentReferenceChild1EClass, SINGLE_CONTAINMENT_REFERENCE_CHILD1__VAL);

    singleContainmentReferenceChild2EClass = createEClass(SINGLE_CONTAINMENT_REFERENCE_CHILD2);
    createEAttribute(singleContainmentReferenceChild2EClass, SINGLE_CONTAINMENT_REFERENCE_CHILD2__VAL);

    singleContainmentReferenceChild3EClass = createEClass(SINGLE_CONTAINMENT_REFERENCE_CHILD3);
    createEAttribute(singleContainmentReferenceChild3EClass, SINGLE_CONTAINMENT_REFERENCE_CHILD3__VAL);

    multiKeywordsEClass = createEClass(MULTI_KEYWORDS);
    createEAttribute(multiKeywordsEClass, MULTI_KEYWORDS__VAL);

    multiKeywordsOrIDEClass = createEClass(MULTI_KEYWORDS_OR_ID);
    createEAttribute(multiKeywordsOrIDEClass, MULTI_KEYWORDS_OR_ID__VAL);

    multiTerminalsEClass = createEClass(MULTI_TERMINALS);
    createEAttribute(multiTerminalsEClass, MULTI_TERMINALS__VAL);

    dependentAlternative1EClass = createEClass(DEPENDENT_ALTERNATIVE1);
    createEAttribute(dependentAlternative1EClass, DEPENDENT_ALTERNATIVE1__VAL);
    createEAttribute(dependentAlternative1EClass, DEPENDENT_ALTERNATIVE1__FLAG);

    dependentAlternative2EClass = createEClass(DEPENDENT_ALTERNATIVE2);
    createEAttribute(dependentAlternative2EClass, DEPENDENT_ALTERNATIVE2__VAL);
    createEAttribute(dependentAlternative2EClass, DEPENDENT_ALTERNATIVE2__FLAG);

    optionalEClass = createEClass(OPTIONAL);
    createEAttribute(optionalEClass, OPTIONAL__INT0);
    createEAttribute(optionalEClass, OPTIONAL__INT1);
    createEAttribute(optionalEClass, OPTIONAL__INT2);

    floatEClass = createEClass(FLOAT);

    unorderedAlternativeEClass = createEClass(UNORDERED_ALTERNATIVE);
    createEAttribute(unorderedAlternativeEClass, UNORDERED_ALTERNATIVE__VAL1);
    createEAttribute(unorderedAlternativeEClass, UNORDERED_ALTERNATIVE__VAL2);
    createEReference(unorderedAlternativeEClass, UNORDERED_ALTERNATIVE__VAL3);
    createEReference(unorderedAlternativeEClass, UNORDERED_ALTERNATIVE__VAL4);

    unorderedAlternativeValEClass = createEClass(UNORDERED_ALTERNATIVE_VAL);
    createEAttribute(unorderedAlternativeValEClass, UNORDERED_ALTERNATIVE_VAL__VAL);

    unorderedAlternativeValDelegateEClass = createEClass(UNORDERED_ALTERNATIVE_VAL_DELEGATE);

    unorderedAlternativeVal2EClass = createEClass(UNORDERED_ALTERNATIVE_VAL2);
    createEAttribute(unorderedAlternativeVal2EClass, UNORDERED_ALTERNATIVE_VAL2__VAL);

    unorderedGroupEClass = createEClass(UNORDERED_GROUP);
    createEAttribute(unorderedGroupEClass, UNORDERED_GROUP__VAL1);
    createEAttribute(unorderedGroupEClass, UNORDERED_GROUP__VAL2);
    createEReference(unorderedGroupEClass, UNORDERED_GROUP__VAL3);
    createEReference(unorderedGroupEClass, UNORDERED_GROUP__VAL4);

    unorderedGroupValEClass = createEClass(UNORDERED_GROUP_VAL);
    createEAttribute(unorderedGroupValEClass, UNORDERED_GROUP_VAL__VAL);

    unorderedGroupValDelegateEClass = createEClass(UNORDERED_GROUP_VAL_DELEGATE);

    unorderedGroupVal2EClass = createEClass(UNORDERED_GROUP_VAL2);
    createEAttribute(unorderedGroupVal2EClass, UNORDERED_GROUP_VAL2__VAL);

    unorderedGroupOptionalEClass = createEClass(UNORDERED_GROUP_OPTIONAL);
    createEAttribute(unorderedGroupOptionalEClass, UNORDERED_GROUP_OPTIONAL__VAL1);
    createEAttribute(unorderedGroupOptionalEClass, UNORDERED_GROUP_OPTIONAL__VA2);
    createEAttribute(unorderedGroupOptionalEClass, UNORDERED_GROUP_OPTIONAL__VAL3);

    unorderedGroupBooleanEClass = createEClass(UNORDERED_GROUP_BOOLEAN);
    createEAttribute(unorderedGroupBooleanEClass, UNORDERED_GROUP_BOOLEAN__VAL1);
    createEAttribute(unorderedGroupBooleanEClass, UNORDERED_GROUP_BOOLEAN__VAL2);
    createEAttribute(unorderedGroupBooleanEClass, UNORDERED_GROUP_BOOLEAN__VAL3);

    complex1EClass = createEClass(COMPLEX1);
    createEAttribute(complex1EClass, COMPLEX1__VAL1);
    createEAttribute(complex1EClass, COMPLEX1__VAL2);
    createEAttribute(complex1EClass, COMPLEX1__VAL3);
    createEAttribute(complex1EClass, COMPLEX1__VAL4);
    createEAttribute(complex1EClass, COMPLEX1__VAL5);
    createEAttribute(complex1EClass, COMPLEX1__VAL6);

    optionalDoubleEClass = createEClass(OPTIONAL_DOUBLE);
    createEAttribute(optionalDoubleEClass, OPTIONAL_DOUBLE__DOUBLE0);
    createEAttribute(optionalDoubleEClass, OPTIONAL_DOUBLE__DOUBLE1);
    createEAttribute(optionalDoubleEClass, OPTIONAL_DOUBLE__DOUBLE2);

    nullValueEClass = createEClass(NULL_VALUE);
    createEAttribute(nullValueEClass, NULL_VALUE__VALUE);
    createEAttribute(nullValueEClass, NULL_VALUE__FOO);

    nullCrossRefEClass = createEClass(NULL_CROSS_REF);
    createEReference(nullCrossRefEClass, NULL_CROSS_REF__REF);
    createEAttribute(nullCrossRefEClass, NULL_CROSS_REF__FOO);

    fragmentCallerTypeEClass = createEClass(FRAGMENT_CALLER_TYPE);
    createEAttribute(fragmentCallerTypeEClass, FRAGMENT_CALLER_TYPE__VAL1);
    createEAttribute(fragmentCallerTypeEClass, FRAGMENT_CALLER_TYPE__VAL);
    createEAttribute(fragmentCallerTypeEClass, FRAGMENT_CALLER_TYPE__FRAG_VAL);

    parameterCallerEClass = createEClass(PARAMETER_CALLER);
    createEReference(parameterCallerEClass, PARAMETER_CALLER__P);

    parameterizedEClass = createEClass(PARAMETERIZED);
    createEAttribute(parameterizedEClass, PARAMETERIZED__V1);
    createEAttribute(parameterizedEClass, PARAMETERIZED__V2);
    createEAttribute(parameterizedEClass, PARAMETERIZED__V3);

    parameterDelegationEClass = createEClass(PARAMETER_DELEGATION);
    createEReference(parameterDelegationEClass, PARAMETER_DELEGATION__P);

    delegationEClass = createEClass(DELEGATION);
    createEAttribute(delegationEClass, DELEGATION__P);
    createEAttribute(delegationEClass, DELEGATION__NP);

    delegationAEClass = createEClass(DELEGATION_A);
    createEReference(delegationAEClass, DELEGATION_A__LEFT);
    createEReference(delegationAEClass, DELEGATION_A__RC2);

    // Create enums
    defEnumEEnum = createEEnum(DEF_ENUM);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    unorderedAlternativeVal2EClass.getESuperTypes().add(this.getUnorderedAlternativeValDelegate());
    unorderedGroupVal2EClass.getESuperTypes().add(this.getUnorderedGroupValDelegate());
    delegationAEClass.getESuperTypes().add(this.getDelegation());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_X1(), this.getSimpleGroup(), null, "x1", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X2(), this.getSimpleAlternative(), null, "x2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X3(), this.getSimpleMultiplicities(), null, "x3", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X4(), this.getGroupMultiplicities(), null, "x4", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X5(), this.getAlternativeMultiplicities(), null, "x5", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X6(), this.getList1(), null, "x6", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X7(), this.getList2(), null, "x7", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X8(), this.getAltList1(), null, "x8", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X9(), this.getAltList2(), null, "x9", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X10(), theEcorePackage.getEObject(), null, "x10", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X11(), theEcorePackage.getEObject(), null, "x11", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X12(), theEcorePackage.getEObject(), null, "x12", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X13(), this.getSingleEnum(), null, "x13", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X14(), this.getSingleCrossReference(), null, "x14", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X15(), this.getSingleContainmentReference(), null, "x15", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X19(), this.getDependentAlternative1(), null, "x19", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X20(), this.getDependentAlternative2(), null, "x20", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X21(), this.getOptional(), null, "x21", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X22(), this.getFloat(), null, "x22", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X23(), this.getUnorderedAlternative(), null, "x23", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X24(), this.getUnorderedGroup(), null, "x24", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X25(), this.getUnorderedGroupOptional(), null, "x25", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X26(), this.getUnorderedGroupBoolean(), null, "x26", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X27(), this.getComplex1(), null, "x27", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X28(), this.getOptionalDouble(), null, "x28", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X29(), this.getNullValue(), null, "x29", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X30(), this.getNullValue(), null, "x30", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X31(), this.getNullCrossRef(), null, "x31", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X32(), this.getNullCrossRef(), null, "x32", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X33(), this.getFragmentCallerType(), null, "x33", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X34(), this.getParameterCaller(), null, "x34", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X35(), this.getParameterDelegation(), null, "x35", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleGroupEClass, SimpleGroup.class, "SimpleGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleGroup_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, SimpleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleGroup_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, SimpleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleAlternativeEClass, SimpleAlternative.class, "SimpleAlternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleAlternative_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, SimpleAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleAlternative_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, SimpleAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleMultiplicitiesEClass, SimpleMultiplicities.class, "SimpleMultiplicities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleMultiplicities_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, SimpleMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleMultiplicities_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, SimpleMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleMultiplicities_Val3(), theEcorePackage.getEString(), "val3", null, 0, -1, SimpleMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSimpleMultiplicities_Val4(), theEcorePackage.getEString(), "val4", null, 0, -1, SimpleMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupMultiplicitiesEClass, GroupMultiplicities.class, "GroupMultiplicities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGroupMultiplicities_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val4(), theEcorePackage.getEString(), "val4", null, 0, -1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val5(), theEcorePackage.getEString(), "val5", null, 0, -1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val6(), theEcorePackage.getEString(), "val6", null, 0, -1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGroupMultiplicities_Val7(), theEcorePackage.getEString(), "val7", null, 0, -1, GroupMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alternativeMultiplicitiesEClass, AlternativeMultiplicities.class, "AlternativeMultiplicities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAlternativeMultiplicities_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlternativeMultiplicities_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlternativeMultiplicities_Val4(), theEcorePackage.getEString(), "val4", null, 0, -1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlternativeMultiplicities_Val5(), theEcorePackage.getEString(), "val5", null, 0, -1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlternativeMultiplicities_Val6(), theEcorePackage.getEString(), "val6", null, 0, -1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAlternativeMultiplicities_Val7(), theEcorePackage.getEString(), "val7", null, 0, -1, AlternativeMultiplicities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list1EClass, List1.class, "List1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList1_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list2EClass, List2.class, "List2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList2_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(altList1EClass, AltList1.class, "AltList1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAltList1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val4(), theEcorePackage.getEString(), "val4", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(altList2EClass, AltList2.class, "AltList2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAltList2_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList2_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList2_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleKeywordsEClass, SingleKeywords.class, "SingleKeywords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleKeywords_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleKeywords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleKeywordsOrIDEClass, SingleKeywordsOrID.class, "SingleKeywordsOrID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleKeywordsOrID_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleKeywordsOrID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleTerminalsEClass, SingleTerminals.class, "SingleTerminals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleTerminals_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleTerminals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleEnumEClass, SingleEnum.class, "SingleEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleEnum_Val(), this.getDefEnum(), "val", null, 0, 1, SingleEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleCrossReferenceEClass, SingleCrossReference.class, "SingleCrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleCrossReference_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleCrossReference_Ref(), this.getSingleCrossReference(), null, "ref", null, 0, 1, SingleCrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleContainmentReferenceEClass, SingleContainmentReference.class, "SingleContainmentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSingleContainmentReference_Child(), theEcorePackage.getEObject(), null, "child", null, 0, 1, SingleContainmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleContainmentReferenceChild1EClass, SingleContainmentReferenceChild1.class, "SingleContainmentReferenceChild1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleContainmentReferenceChild1_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleContainmentReferenceChild1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleContainmentReferenceChild2EClass, SingleContainmentReferenceChild2.class, "SingleContainmentReferenceChild2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleContainmentReferenceChild2_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleContainmentReferenceChild2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleContainmentReferenceChild3EClass, SingleContainmentReferenceChild3.class, "SingleContainmentReferenceChild3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSingleContainmentReferenceChild3_Val(), theEcorePackage.getEString(), "val", null, 0, 1, SingleContainmentReferenceChild3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiKeywordsEClass, MultiKeywords.class, "MultiKeywords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiKeywords_Val(), theEcorePackage.getEString(), "val", null, 0, -1, MultiKeywords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiKeywordsOrIDEClass, MultiKeywordsOrID.class, "MultiKeywordsOrID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiKeywordsOrID_Val(), theEcorePackage.getEString(), "val", null, 0, -1, MultiKeywordsOrID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiTerminalsEClass, MultiTerminals.class, "MultiTerminals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiTerminals_Val(), theEcorePackage.getEString(), "val", null, 0, -1, MultiTerminals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dependentAlternative1EClass, DependentAlternative1.class, "DependentAlternative1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDependentAlternative1_Val(), theEcorePackage.getEString(), "val", null, 0, 1, DependentAlternative1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDependentAlternative1_Flag(), theEcorePackage.getEBoolean(), "flag", null, 0, 1, DependentAlternative1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dependentAlternative2EClass, DependentAlternative2.class, "DependentAlternative2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDependentAlternative2_Val(), theEcorePackage.getEString(), "val", null, 0, -1, DependentAlternative2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDependentAlternative2_Flag(), theEcorePackage.getEBoolean(), "flag", null, 0, 1, DependentAlternative2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalEClass, Optional.class, "Optional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptional_Int0(), theEcorePackage.getEInt(), "int0", null, 0, 1, Optional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptional_Int1(), theEcorePackage.getEInt(), "int1", null, 0, 1, Optional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptional_Int2(), theEcorePackage.getEInt(), "int2", null, 0, 1, Optional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(floatEClass, org.eclipse.xtext.serializer.sequencertest.Float.class, "Float", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unorderedAlternativeEClass, UnorderedAlternative.class, "UnorderedAlternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedAlternative_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, UnorderedAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedAlternative_Val2(), theEcorePackage.getEInt(), "val2", null, 0, -1, UnorderedAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnorderedAlternative_Val3(), this.getUnorderedAlternativeVal(), null, "val3", null, 0, -1, UnorderedAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnorderedAlternative_Val4(), this.getUnorderedAlternativeValDelegate(), null, "val4", null, 0, -1, UnorderedAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedAlternativeValEClass, UnorderedAlternativeVal.class, "UnorderedAlternativeVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedAlternativeVal_Val(), theEcorePackage.getEString(), "val", null, 0, 1, UnorderedAlternativeVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedAlternativeValDelegateEClass, UnorderedAlternativeValDelegate.class, "UnorderedAlternativeValDelegate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unorderedAlternativeVal2EClass, UnorderedAlternativeVal2.class, "UnorderedAlternativeVal2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedAlternativeVal2_Val(), theEcorePackage.getEString(), "val", null, 0, 1, UnorderedAlternativeVal2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedGroupEClass, UnorderedGroup.class, "UnorderedGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedGroup_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnorderedGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedGroup_Val2(), theEcorePackage.getEInt(), "val2", null, 0, 1, UnorderedGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnorderedGroup_Val3(), this.getUnorderedGroupVal(), null, "val3", null, 0, 1, UnorderedGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnorderedGroup_Val4(), this.getUnorderedGroupValDelegate(), null, "val4", null, 0, 1, UnorderedGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedGroupValEClass, UnorderedGroupVal.class, "UnorderedGroupVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedGroupVal_Val(), theEcorePackage.getEString(), "val", null, 0, 1, UnorderedGroupVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedGroupValDelegateEClass, UnorderedGroupValDelegate.class, "UnorderedGroupValDelegate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unorderedGroupVal2EClass, UnorderedGroupVal2.class, "UnorderedGroupVal2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedGroupVal2_Val(), theEcorePackage.getEString(), "val", null, 0, 1, UnorderedGroupVal2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedGroupOptionalEClass, UnorderedGroupOptional.class, "UnorderedGroupOptional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedGroupOptional_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnorderedGroupOptional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedGroupOptional_Va2(), theEcorePackage.getEString(), "va2", null, 0, 1, UnorderedGroupOptional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedGroupOptional_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, UnorderedGroupOptional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unorderedGroupBooleanEClass, UnorderedGroupBoolean.class, "UnorderedGroupBoolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnorderedGroupBoolean_Val1(), theEcorePackage.getEBoolean(), "val1", null, 0, 1, UnorderedGroupBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedGroupBoolean_Val2(), theEcorePackage.getEBoolean(), "val2", null, 0, 1, UnorderedGroupBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnorderedGroupBoolean_Val3(), theEcorePackage.getEBoolean(), "val3", null, 0, 1, UnorderedGroupBoolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(complex1EClass, Complex1.class, "Complex1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComplex1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplex1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplex1_Val3(), theEcorePackage.getEString(), "val3", null, 0, -1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplex1_Val4(), theEcorePackage.getEString(), "val4", null, 0, -1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplex1_Val5(), theEcorePackage.getEString(), "val5", null, 0, -1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getComplex1_Val6(), theEcorePackage.getEString(), "val6", null, 0, -1, Complex1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(optionalDoubleEClass, OptionalDouble.class, "OptionalDouble", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOptionalDouble_Double0(), theEcorePackage.getEDouble(), "double0", null, 0, 1, OptionalDouble.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptionalDouble_Double1(), theEcorePackage.getEDouble(), "double1", null, 0, 1, OptionalDouble.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOptionalDouble_Double2(), theEcorePackage.getEDouble(), "double2", null, 0, 1, OptionalDouble.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullValueEClass, NullValue.class, "NullValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNullValue_Value(), theEcorePackage.getEString(), "value", null, 0, 1, NullValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNullValue_Foo(), theEcorePackage.getEString(), "foo", null, 0, 1, NullValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullCrossRefEClass, NullCrossRef.class, "NullCrossRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNullCrossRef_Ref(), theEcorePackage.getEObject(), null, "ref", null, 0, 1, NullCrossRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNullCrossRef_Foo(), theEcorePackage.getEString(), "foo", null, 0, 1, NullCrossRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fragmentCallerTypeEClass, FragmentCallerType.class, "FragmentCallerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFragmentCallerType_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, FragmentCallerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFragmentCallerType_Val(), theEcorePackage.getEString(), "val", null, 0, 1, FragmentCallerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFragmentCallerType_FragVal(), theEcorePackage.getEString(), "fragVal", null, 0, 1, FragmentCallerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterCallerEClass, ParameterCaller.class, "ParameterCaller", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterCaller_P(), this.getParameterized(), null, "p", null, 0, 1, ParameterCaller.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterizedEClass, Parameterized.class, "Parameterized", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameterized_V1(), theEcorePackage.getEString(), "v1", null, 0, 1, Parameterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterized_V2(), theEcorePackage.getEString(), "v2", null, 0, 1, Parameterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterized_V3(), theEcorePackage.getEString(), "v3", null, 0, 1, Parameterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterDelegationEClass, ParameterDelegation.class, "ParameterDelegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterDelegation_P(), this.getDelegation(), null, "p", null, 0, 1, ParameterDelegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(delegationEClass, Delegation.class, "Delegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDelegation_P(), theEcorePackage.getEString(), "p", null, 0, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDelegation_Np(), theEcorePackage.getEInt(), "np", null, 0, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(delegationAEClass, DelegationA.class, "DelegationA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDelegationA_Left(), this.getDelegation(), null, "left", null, 0, 1, DelegationA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDelegationA_Rc2(), this.getDelegation(), null, "rc2", null, 0, 1, DelegationA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(defEnumEEnum, DefEnum.class, "DefEnum");
    addEEnumLiteral(defEnumEEnum, DefEnum.KW1);
    addEEnumLiteral(defEnumEEnum, DefEnum.KW2);
    addEEnumLiteral(defEnumEEnum, DefEnum.KW3);

    // Create resource
    createResource(eNS_URI);
  }

} //SequencertestPackageImpl
