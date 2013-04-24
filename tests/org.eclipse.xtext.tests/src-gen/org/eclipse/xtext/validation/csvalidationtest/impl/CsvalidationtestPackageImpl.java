/**
 */
package org.eclipse.xtext.validation.csvalidationtest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.validation.csvalidationtest.AltList1;
import org.eclipse.xtext.validation.csvalidationtest.AltList2;
import org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.AssignedAction;
import org.eclipse.xtext.validation.csvalidationtest.Combination1;
import org.eclipse.xtext.validation.csvalidationtest.Combination2;
import org.eclipse.xtext.validation.csvalidationtest.Combination3;
import org.eclipse.xtext.validation.csvalidationtest.Combination4;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestFactory;
import org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage;
import org.eclipse.xtext.validation.csvalidationtest.EmptyAlternativeSub;
import org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.Heuristic1;
import org.eclipse.xtext.validation.csvalidationtest.List1;
import org.eclipse.xtext.validation.csvalidationtest.List2;
import org.eclipse.xtext.validation.csvalidationtest.List3;
import org.eclipse.xtext.validation.csvalidationtest.List4;
import org.eclipse.xtext.validation.csvalidationtest.List5;
import org.eclipse.xtext.validation.csvalidationtest.Model;
import org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative;
import org.eclipse.xtext.validation.csvalidationtest.SimpleGroup;
import org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities;
import org.eclipse.xtext.validation.csvalidationtest.StaticSimplification;
import org.eclipse.xtext.validation.csvalidationtest.TransientObject;
import org.eclipse.xtext.validation.csvalidationtest.TransientObjectSub;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1;
import org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1Enum;
import org.eclipse.xtext.validation.csvalidationtest.TwoVersion;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2Sub;
import org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CsvalidationtestPackageImpl extends EPackageImpl implements CsvalidationtestPackage
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
  private EClass assignedActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedRuleCall1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedRuleCall1SubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedRuleCall2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedRuleCall2SubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass combination1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass combination2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass combination3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass combination4EClass = null;

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
  private EClass list3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass list4EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass list5EClass = null;

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
  private EClass transientObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transientObjectSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transientSerializeables1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticSimplificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass twoVersionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass heuristic1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction2SubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction2Sub1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedAction2Sub2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unassignedRuleCall2SubActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyAlternativeSubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum transientSerializeables1EnumEEnum = null;

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
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CsvalidationtestPackageImpl()
  {
    super(eNS_URI, CsvalidationtestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link CsvalidationtestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CsvalidationtestPackage init()
  {
    if (isInited) return (CsvalidationtestPackage)EPackage.Registry.INSTANCE.getEPackage(CsvalidationtestPackage.eNS_URI);

    // Obtain or create and register package
    CsvalidationtestPackageImpl theCsvalidationtestPackage = (CsvalidationtestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CsvalidationtestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CsvalidationtestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theCsvalidationtestPackage.createPackageContents();

    // Initialize created meta-data
    theCsvalidationtestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCsvalidationtestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CsvalidationtestPackage.eNS_URI, theCsvalidationtestPackage);
    return theCsvalidationtestPackage;
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
  public EReference getModel_X16()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X17()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X18()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(17);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X19()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(18);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X20()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(19);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X21()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(20);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X22()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(21);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X23()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(22);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X24()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(23);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X25()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(24);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X26()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(25);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X27()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(26);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_X28()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(27);
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
  public EClass getAssignedAction()
  {
    return assignedActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignedAction_Val1()
  {
    return (EAttribute)assignedActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignedAction_Child()
  {
    return (EReference)assignedActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignedAction_Val2()
  {
    return (EAttribute)assignedActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction1()
  {
    return unassignedAction1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction1_Val1()
  {
    return (EAttribute)unassignedAction1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction1_Val2()
  {
    return (EAttribute)unassignedAction1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction2()
  {
    return unassignedAction2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction3()
  {
    return unassignedAction3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction3_Val1()
  {
    return (EAttribute)unassignedAction3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction3_Val2()
  {
    return (EAttribute)unassignedAction3EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedRuleCall1()
  {
    return unassignedRuleCall1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedRuleCall1Sub()
  {
    return unassignedRuleCall1SubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedRuleCall1Sub_Val2()
  {
    return (EAttribute)unassignedRuleCall1SubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedRuleCall1Sub_Val1()
  {
    return (EAttribute)unassignedRuleCall1SubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedRuleCall2()
  {
    return unassignedRuleCall2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedRuleCall2Sub()
  {
    return unassignedRuleCall2SubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedRuleCall2Sub_Val2()
  {
    return (EAttribute)unassignedRuleCall2SubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCombination1()
  {
    return combination1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination1_Val1()
  {
    return (EAttribute)combination1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination1_Val2()
  {
    return (EAttribute)combination1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination1_Val3()
  {
    return (EAttribute)combination1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination1_Val4()
  {
    return (EAttribute)combination1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCombination2()
  {
    return combination2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination2_Val1()
  {
    return (EAttribute)combination2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination2_Val2()
  {
    return (EAttribute)combination2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination2_Val3()
  {
    return (EAttribute)combination2EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination2_Val4()
  {
    return (EAttribute)combination2EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCombination3()
  {
    return combination3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination3_Val1()
  {
    return (EAttribute)combination3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination3_Val2()
  {
    return (EAttribute)combination3EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination3_Val3()
  {
    return (EAttribute)combination3EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCombination4()
  {
    return combination4EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination4_Val1()
  {
    return (EAttribute)combination4EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination4_Val2()
  {
    return (EAttribute)combination4EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCombination4_Val3()
  {
    return (EAttribute)combination4EClass.getEStructuralFeatures().get(2);
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
  public EClass getList3()
  {
    return list3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList3_Val1()
  {
    return (EAttribute)list3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList3_Val2()
  {
    return (EAttribute)list3EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList4()
  {
    return list4EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList4_Val1()
  {
    return (EAttribute)list4EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList4_Val2()
  {
    return (EAttribute)list4EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList5()
  {
    return list5EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList5_Val1()
  {
    return (EAttribute)list5EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList5_Val2()
  {
    return (EAttribute)list5EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getList5_Val3()
  {
    return (EAttribute)list5EClass.getEStructuralFeatures().get(2);
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
  public EClass getTransientObject()
  {
    return transientObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientObject_Val1()
  {
    return (EAttribute)transientObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransientObject_Nested()
  {
    return (EReference)transientObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransientObjectSub()
  {
    return transientObjectSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientObjectSub_Val2()
  {
    return (EAttribute)transientObjectSubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientObjectSub_Val3()
  {
    return (EAttribute)transientObjectSubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransientSerializeables1()
  {
    return transientSerializeables1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientSerializeables1_Val1()
  {
    return (EAttribute)transientSerializeables1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientSerializeables1_Enum1()
  {
    return (EAttribute)transientSerializeables1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientSerializeables1_Val2()
  {
    return (EAttribute)transientSerializeables1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransientSerializeables1_Int1()
  {
    return (EAttribute)transientSerializeables1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticSimplification()
  {
    return staticSimplificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStaticSimplification_Val1()
  {
    return (EAttribute)staticSimplificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStaticSimplification_Val2()
  {
    return (EAttribute)staticSimplificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStaticSimplification_Val3()
  {
    return (EAttribute)staticSimplificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTwoVersion()
  {
    return twoVersionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Shared1()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Shared2()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Shared3()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Version1()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Extra1()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Extra2()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Extra3()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoVersion_Extra4()
  {
    return (EAttribute)twoVersionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHeuristic1()
  {
    return heuristic1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHeuristic1_A()
  {
    return (EAttribute)heuristic1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHeuristic1_B()
  {
    return (EAttribute)heuristic1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHeuristic1_C()
  {
    return (EAttribute)heuristic1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction2Sub()
  {
    return unassignedAction2SubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction2Sub_Val1()
  {
    return (EAttribute)unassignedAction2SubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnassignedAction2Sub_Val2()
  {
    return (EAttribute)unassignedAction2SubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction2Sub1()
  {
    return unassignedAction2Sub1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedAction2Sub2()
  {
    return unassignedAction2Sub2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnassignedRuleCall2SubAction()
  {
    return unassignedRuleCall2SubActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyAlternativeSub()
  {
    return emptyAlternativeSubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTransientSerializeables1Enum()
  {
    return transientSerializeables1EnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CsvalidationtestFactory getCsvalidationtestFactory()
  {
    return (CsvalidationtestFactory)getEFactoryInstance();
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
    createEReference(modelEClass, MODEL__X16);
    createEReference(modelEClass, MODEL__X17);
    createEReference(modelEClass, MODEL__X18);
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

    assignedActionEClass = createEClass(ASSIGNED_ACTION);
    createEAttribute(assignedActionEClass, ASSIGNED_ACTION__VAL1);
    createEReference(assignedActionEClass, ASSIGNED_ACTION__CHILD);
    createEAttribute(assignedActionEClass, ASSIGNED_ACTION__VAL2);

    unassignedAction1EClass = createEClass(UNASSIGNED_ACTION1);
    createEAttribute(unassignedAction1EClass, UNASSIGNED_ACTION1__VAL1);
    createEAttribute(unassignedAction1EClass, UNASSIGNED_ACTION1__VAL2);

    unassignedAction2EClass = createEClass(UNASSIGNED_ACTION2);

    unassignedAction3EClass = createEClass(UNASSIGNED_ACTION3);
    createEAttribute(unassignedAction3EClass, UNASSIGNED_ACTION3__VAL1);
    createEAttribute(unassignedAction3EClass, UNASSIGNED_ACTION3__VAL2);

    unassignedRuleCall1EClass = createEClass(UNASSIGNED_RULE_CALL1);

    unassignedRuleCall1SubEClass = createEClass(UNASSIGNED_RULE_CALL1_SUB);
    createEAttribute(unassignedRuleCall1SubEClass, UNASSIGNED_RULE_CALL1_SUB__VAL2);
    createEAttribute(unassignedRuleCall1SubEClass, UNASSIGNED_RULE_CALL1_SUB__VAL1);

    unassignedRuleCall2EClass = createEClass(UNASSIGNED_RULE_CALL2);

    unassignedRuleCall2SubEClass = createEClass(UNASSIGNED_RULE_CALL2_SUB);
    createEAttribute(unassignedRuleCall2SubEClass, UNASSIGNED_RULE_CALL2_SUB__VAL2);

    combination1EClass = createEClass(COMBINATION1);
    createEAttribute(combination1EClass, COMBINATION1__VAL1);
    createEAttribute(combination1EClass, COMBINATION1__VAL2);
    createEAttribute(combination1EClass, COMBINATION1__VAL3);
    createEAttribute(combination1EClass, COMBINATION1__VAL4);

    combination2EClass = createEClass(COMBINATION2);
    createEAttribute(combination2EClass, COMBINATION2__VAL1);
    createEAttribute(combination2EClass, COMBINATION2__VAL2);
    createEAttribute(combination2EClass, COMBINATION2__VAL3);
    createEAttribute(combination2EClass, COMBINATION2__VAL4);

    combination3EClass = createEClass(COMBINATION3);
    createEAttribute(combination3EClass, COMBINATION3__VAL1);
    createEAttribute(combination3EClass, COMBINATION3__VAL2);
    createEAttribute(combination3EClass, COMBINATION3__VAL3);

    combination4EClass = createEClass(COMBINATION4);
    createEAttribute(combination4EClass, COMBINATION4__VAL1);
    createEAttribute(combination4EClass, COMBINATION4__VAL2);
    createEAttribute(combination4EClass, COMBINATION4__VAL3);

    list1EClass = createEClass(LIST1);
    createEAttribute(list1EClass, LIST1__VAL1);

    list2EClass = createEClass(LIST2);
    createEAttribute(list2EClass, LIST2__VAL1);

    list3EClass = createEClass(LIST3);
    createEAttribute(list3EClass, LIST3__VAL1);
    createEAttribute(list3EClass, LIST3__VAL2);

    list4EClass = createEClass(LIST4);
    createEAttribute(list4EClass, LIST4__VAL1);
    createEAttribute(list4EClass, LIST4__VAL2);

    list5EClass = createEClass(LIST5);
    createEAttribute(list5EClass, LIST5__VAL1);
    createEAttribute(list5EClass, LIST5__VAL2);
    createEAttribute(list5EClass, LIST5__VAL3);

    altList1EClass = createEClass(ALT_LIST1);
    createEAttribute(altList1EClass, ALT_LIST1__VAL1);
    createEAttribute(altList1EClass, ALT_LIST1__VAL2);
    createEAttribute(altList1EClass, ALT_LIST1__VAL3);
    createEAttribute(altList1EClass, ALT_LIST1__VAL4);

    altList2EClass = createEClass(ALT_LIST2);
    createEAttribute(altList2EClass, ALT_LIST2__VAL1);
    createEAttribute(altList2EClass, ALT_LIST2__VAL2);
    createEAttribute(altList2EClass, ALT_LIST2__VAL3);

    transientObjectEClass = createEClass(TRANSIENT_OBJECT);
    createEAttribute(transientObjectEClass, TRANSIENT_OBJECT__VAL1);
    createEReference(transientObjectEClass, TRANSIENT_OBJECT__NESTED);

    transientObjectSubEClass = createEClass(TRANSIENT_OBJECT_SUB);
    createEAttribute(transientObjectSubEClass, TRANSIENT_OBJECT_SUB__VAL2);
    createEAttribute(transientObjectSubEClass, TRANSIENT_OBJECT_SUB__VAL3);

    transientSerializeables1EClass = createEClass(TRANSIENT_SERIALIZEABLES1);
    createEAttribute(transientSerializeables1EClass, TRANSIENT_SERIALIZEABLES1__VAL1);
    createEAttribute(transientSerializeables1EClass, TRANSIENT_SERIALIZEABLES1__ENUM1);
    createEAttribute(transientSerializeables1EClass, TRANSIENT_SERIALIZEABLES1__VAL2);
    createEAttribute(transientSerializeables1EClass, TRANSIENT_SERIALIZEABLES1__INT1);

    staticSimplificationEClass = createEClass(STATIC_SIMPLIFICATION);
    createEAttribute(staticSimplificationEClass, STATIC_SIMPLIFICATION__VAL1);
    createEAttribute(staticSimplificationEClass, STATIC_SIMPLIFICATION__VAL2);
    createEAttribute(staticSimplificationEClass, STATIC_SIMPLIFICATION__VAL3);

    twoVersionEClass = createEClass(TWO_VERSION);
    createEAttribute(twoVersionEClass, TWO_VERSION__SHARED1);
    createEAttribute(twoVersionEClass, TWO_VERSION__SHARED2);
    createEAttribute(twoVersionEClass, TWO_VERSION__SHARED3);
    createEAttribute(twoVersionEClass, TWO_VERSION__VERSION1);
    createEAttribute(twoVersionEClass, TWO_VERSION__EXTRA1);
    createEAttribute(twoVersionEClass, TWO_VERSION__EXTRA2);
    createEAttribute(twoVersionEClass, TWO_VERSION__EXTRA3);
    createEAttribute(twoVersionEClass, TWO_VERSION__EXTRA4);

    heuristic1EClass = createEClass(HEURISTIC1);
    createEAttribute(heuristic1EClass, HEURISTIC1__A);
    createEAttribute(heuristic1EClass, HEURISTIC1__B);
    createEAttribute(heuristic1EClass, HEURISTIC1__C);

    unassignedAction2SubEClass = createEClass(UNASSIGNED_ACTION2_SUB);
    createEAttribute(unassignedAction2SubEClass, UNASSIGNED_ACTION2_SUB__VAL1);
    createEAttribute(unassignedAction2SubEClass, UNASSIGNED_ACTION2_SUB__VAL2);

    unassignedAction2Sub1EClass = createEClass(UNASSIGNED_ACTION2_SUB1);

    unassignedAction2Sub2EClass = createEClass(UNASSIGNED_ACTION2_SUB2);

    unassignedRuleCall2SubActionEClass = createEClass(UNASSIGNED_RULE_CALL2_SUB_ACTION);

    emptyAlternativeSubEClass = createEClass(EMPTY_ALTERNATIVE_SUB);

    // Create enums
    transientSerializeables1EnumEEnum = createEEnum(TRANSIENT_SERIALIZEABLES1_ENUM);
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
    unassignedRuleCall1SubEClass.getESuperTypes().add(this.getUnassignedRuleCall1());
    unassignedRuleCall2SubEClass.getESuperTypes().add(this.getUnassignedRuleCall2());
    unassignedAction2SubEClass.getESuperTypes().add(this.getUnassignedAction2());
    unassignedAction2Sub1EClass.getESuperTypes().add(this.getUnassignedAction3());
    unassignedAction2Sub2EClass.getESuperTypes().add(this.getUnassignedAction3());
    unassignedRuleCall2SubActionEClass.getESuperTypes().add(this.getUnassignedRuleCall2Sub());
    emptyAlternativeSubEClass.getESuperTypes().add(this.getStaticSimplification());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_X1(), this.getSimpleGroup(), null, "x1", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X2(), this.getSimpleAlternative(), null, "x2", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X3(), this.getSimpleMultiplicities(), null, "x3", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X4(), this.getGroupMultiplicities(), null, "x4", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X5(), this.getAlternativeMultiplicities(), null, "x5", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X6(), this.getAssignedAction(), null, "x6", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X7(), this.getAssignedAction(), null, "x7", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X8(), this.getUnassignedAction1(), null, "x8", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X9(), this.getUnassignedAction2(), null, "x9", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X10(), this.getUnassignedAction3(), null, "x10", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X11(), this.getUnassignedRuleCall1(), null, "x11", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X12(), this.getUnassignedRuleCall2(), null, "x12", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X13(), this.getCombination1(), null, "x13", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X14(), this.getCombination2(), null, "x14", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X15(), this.getCombination3(), null, "x15", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X16(), this.getCombination4(), null, "x16", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X17(), this.getList1(), null, "x17", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X18(), this.getList2(), null, "x18", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X19(), this.getList3(), null, "x19", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X20(), this.getList4(), null, "x20", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X21(), this.getList5(), null, "x21", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X22(), this.getAltList1(), null, "x22", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X23(), this.getAltList2(), null, "x23", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X24(), this.getTransientObject(), null, "x24", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X25(), this.getTransientSerializeables1(), null, "x25", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X26(), this.getStaticSimplification(), null, "x26", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X27(), this.getTwoVersion(), null, "x27", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_X28(), this.getHeuristic1(), null, "x28", null, 0, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

    initEClass(assignedActionEClass, AssignedAction.class, "AssignedAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignedAction_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, AssignedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignedAction_Child(), this.getAssignedAction(), null, "child", null, 0, 1, AssignedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignedAction_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AssignedAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedAction1EClass, UnassignedAction1.class, "UnassignedAction1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnassignedAction1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnassignedAction1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnassignedAction1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, UnassignedAction1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedAction2EClass, UnassignedAction2.class, "UnassignedAction2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unassignedAction3EClass, UnassignedAction3.class, "UnassignedAction3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnassignedAction3_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnassignedAction3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnassignedAction3_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, UnassignedAction3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedRuleCall1EClass, UnassignedRuleCall1.class, "UnassignedRuleCall1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unassignedRuleCall1SubEClass, UnassignedRuleCall1Sub.class, "UnassignedRuleCall1Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnassignedRuleCall1Sub_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, UnassignedRuleCall1Sub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnassignedRuleCall1Sub_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnassignedRuleCall1Sub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedRuleCall2EClass, UnassignedRuleCall2.class, "UnassignedRuleCall2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unassignedRuleCall2SubEClass, UnassignedRuleCall2Sub.class, "UnassignedRuleCall2Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnassignedRuleCall2Sub_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, UnassignedRuleCall2Sub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(combination1EClass, Combination1.class, "Combination1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCombination1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, Combination1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, Combination1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination1_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, Combination1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination1_Val4(), theEcorePackage.getEString(), "val4", null, 0, 1, Combination1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(combination2EClass, Combination2.class, "Combination2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCombination2_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, Combination2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination2_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, Combination2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination2_Val3(), theEcorePackage.getEString(), "val3", null, 0, -1, Combination2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination2_Val4(), theEcorePackage.getEString(), "val4", null, 0, -1, Combination2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(combination3EClass, Combination3.class, "Combination3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCombination3_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, Combination3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination3_Val2(), theEcorePackage.getEInt(), "val2", null, 0, 1, Combination3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination3_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, Combination3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(combination4EClass, Combination4.class, "Combination4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCombination4_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, Combination4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination4_Val2(), theEcorePackage.getEString(), "val2", null, 0, -1, Combination4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCombination4_Val3(), theEcorePackage.getEString(), "val3", null, 0, -1, Combination4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list1EClass, List1.class, "List1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList1_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list2EClass, List2.class, "List2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList2_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list3EClass, List3.class, "List3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList3_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getList3_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, List3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list4EClass, List4.class, "List4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList4_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getList4_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, List4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(list5EClass, List5.class, "List5", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getList5_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, List5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getList5_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, List5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getList5_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, List5.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(altList1EClass, AltList1.class, "AltList1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAltList1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList1_Val4(), theEcorePackage.getEString(), "val4", null, 0, 1, AltList1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(altList2EClass, AltList2.class, "AltList2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAltList2_Val1(), theEcorePackage.getEString(), "val1", null, 0, -1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList2_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAltList2_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, AltList2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transientObjectEClass, TransientObject.class, "TransientObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransientObject_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, TransientObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransientObject_Nested(), this.getTransientObjectSub(), null, "nested", null, 0, 1, TransientObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transientObjectSubEClass, TransientObjectSub.class, "TransientObjectSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransientObjectSub_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, TransientObjectSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransientObjectSub_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, TransientObjectSub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transientSerializeables1EClass, TransientSerializeables1.class, "TransientSerializeables1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransientSerializeables1_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, TransientSerializeables1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransientSerializeables1_Enum1(), this.getTransientSerializeables1Enum(), "enum1", null, 0, 1, TransientSerializeables1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransientSerializeables1_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, TransientSerializeables1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransientSerializeables1_Int1(), theEcorePackage.getEInt(), "int1", null, 0, 1, TransientSerializeables1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(staticSimplificationEClass, StaticSimplification.class, "StaticSimplification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStaticSimplification_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, StaticSimplification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStaticSimplification_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, StaticSimplification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStaticSimplification_Val3(), theEcorePackage.getEString(), "val3", null, 0, 1, StaticSimplification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(twoVersionEClass, TwoVersion.class, "TwoVersion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTwoVersion_Shared1(), theEcorePackage.getEString(), "shared1", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Shared2(), theEcorePackage.getEString(), "shared2", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Shared3(), theEcorePackage.getEString(), "shared3", null, 0, -1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Version1(), theEcorePackage.getEString(), "version1", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Extra1(), theEcorePackage.getEString(), "extra1", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Extra2(), theEcorePackage.getEString(), "extra2", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Extra3(), theEcorePackage.getEString(), "extra3", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoVersion_Extra4(), theEcorePackage.getEString(), "extra4", null, 0, 1, TwoVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(heuristic1EClass, Heuristic1.class, "Heuristic1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHeuristic1_A(), theEcorePackage.getEString(), "a", null, 0, -1, Heuristic1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHeuristic1_B(), theEcorePackage.getEString(), "b", null, 0, -1, Heuristic1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getHeuristic1_C(), theEcorePackage.getEString(), "c", null, 0, -1, Heuristic1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedAction2SubEClass, UnassignedAction2Sub.class, "UnassignedAction2Sub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnassignedAction2Sub_Val1(), theEcorePackage.getEString(), "val1", null, 0, 1, UnassignedAction2Sub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnassignedAction2Sub_Val2(), theEcorePackage.getEString(), "val2", null, 0, 1, UnassignedAction2Sub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unassignedAction2Sub1EClass, UnassignedAction2Sub1.class, "UnassignedAction2Sub1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unassignedAction2Sub2EClass, UnassignedAction2Sub2.class, "UnassignedAction2Sub2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unassignedRuleCall2SubActionEClass, UnassignedRuleCall2SubAction.class, "UnassignedRuleCall2SubAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(emptyAlternativeSubEClass, EmptyAlternativeSub.class, "EmptyAlternativeSub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(transientSerializeables1EnumEEnum, TransientSerializeables1Enum.class, "TransientSerializeables1Enum");
    addEEnumLiteral(transientSerializeables1EnumEEnum, TransientSerializeables1Enum.LIT1);
    addEEnumLiteral(transientSerializeables1EnumEEnum, TransientSerializeables1Enum.LIT2);

    // Create resource
    createResource(eNS_URI);
  }

} //CsvalidationtestPackageImpl
