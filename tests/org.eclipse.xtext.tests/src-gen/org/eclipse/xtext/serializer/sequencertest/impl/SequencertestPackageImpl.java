/**
 * <copyright>
 * </copyright>
 *
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
import org.eclipse.xtext.serializer.sequencertest.DefEnum;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.Optional;
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

    // Initialize enums and add enum literals
    initEEnum(defEnumEEnum, DefEnum.class, "DefEnum");
    addEEnumLiteral(defEnumEEnum, DefEnum.KW1);
    addEEnumLiteral(defEnumEEnum, DefEnum.KW2);
    addEEnumLiteral(defEnumEEnum, DefEnum.KW3);

    // Create resource
    createResource(eNS_URI);
  }

} //SequencertestPackageImpl
