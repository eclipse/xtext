/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EnumBug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestFactory;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplerewritetestPackageImpl extends EPackageImpl implements SimplerewritetestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass twoNumbersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manyStringsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ref2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass spareEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transient1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass consumed1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass consumed2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loop1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loop2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loop3EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loop4EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopBug285452EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass duplicateBug284491EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyObjectBug284850EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyObjectItemsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emptyObjectItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiInheritanceBug280439EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMulti1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMulti2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concreteMultiEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eObjectRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eObjectElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug305577_1EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug305577_2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug1AEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug1BEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug2AEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeBug2BEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bug305171EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bug310435EnumEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bug310435ValEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass crossRefNameTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass crossRefNamedEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass opEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum enumBug310435EnumEEnum = null;

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
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SimplerewritetestPackageImpl()
  {
    super(eNS_URI, SimplerewritetestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SimplerewritetestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SimplerewritetestPackage init()
  {
    if (isInited) return (SimplerewritetestPackage)EPackage.Registry.INSTANCE.getEPackage(SimplerewritetestPackage.eNS_URI);

    // Obtain or create and register package
    SimplerewritetestPackageImpl theSimplerewritetestPackage = (SimplerewritetestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SimplerewritetestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SimplerewritetestPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSimplerewritetestPackage.createPackageContents();

    // Initialize created meta-data
    theSimplerewritetestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSimplerewritetestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SimplerewritetestPackage.eNS_URI, theSimplerewritetestPackage);
    return theSimplerewritetestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpression_Em()
  {
    return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtom()
  {
    return atomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAtom_Name()
  {
    return (EAttribute)atomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTwoNumbers()
  {
    return twoNumbersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoNumbers_Num1()
  {
    return (EAttribute)twoNumbersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoNumbers_Num2()
  {
    return (EAttribute)twoNumbersEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTwoNumbers_Num3()
  {
    return (EAttribute)twoNumbersEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManyStrings()
  {
    return manyStringsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyStrings_Str1()
  {
    return (EAttribute)manyStringsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManyStrings_Str2()
  {
    return (EAttribute)manyStringsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getType_Name()
  {
    return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getType_Extends()
  {
    return (EReference)typeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRef2()
  {
    return ref2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRef2_Ref2()
  {
    return (EAttribute)ref2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpare()
  {
    return spareEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpare_Id()
  {
    return (EAttribute)spareEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolean()
  {
    return booleanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolean_Bool()
  {
    return (EAttribute)booleanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolean_Value()
  {
    return (EAttribute)booleanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransient1()
  {
    return transient1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransient1_PrecStar()
  {
    return (EAttribute)transient1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransient1_Prec()
  {
    return (EAttribute)transient1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransient1_ScaleStar()
  {
    return (EAttribute)transient1EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransient1_Scale()
  {
    return (EAttribute)transient1EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConsumed1()
  {
    return consumed1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConsumed1_V1()
  {
    return (EAttribute)consumed1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConsumed1_V2()
  {
    return (EAttribute)consumed1EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConsumed2()
  {
    return consumed2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConsumed2_Child()
  {
    return (EReference)consumed2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop1()
  {
    return loop1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop1_Id()
  {
    return (EAttribute)loop1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop2()
  {
    return loop2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop2_Id()
  {
    return (EAttribute)loop2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop3()
  {
    return loop3EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop3_Id()
  {
    return (EAttribute)loop3EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop4()
  {
    return loop4EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop4_Id()
  {
    return (EAttribute)loop4EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoopBug285452()
  {
    return loopBug285452EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopBug285452_Interface()
  {
    return (EAttribute)loopBug285452EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoopBug285452_Name()
  {
    return (EAttribute)loopBug285452EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDuplicateBug284491()
  {
    return duplicateBug284491EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDuplicateBug284491_Static()
  {
    return (EAttribute)duplicateBug284491EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDuplicateBug284491_Final()
  {
    return (EAttribute)duplicateBug284491EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDuplicateBug284491_Transient()
  {
    return (EAttribute)duplicateBug284491EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyObjectBug284850()
  {
    return emptyObjectBug284850EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEmptyObjectBug284850_Items()
  {
    return (EReference)emptyObjectBug284850EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyObjectItems()
  {
    return emptyObjectItemsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEmptyObjectItems_List()
  {
    return (EReference)emptyObjectItemsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmptyObjectItem()
  {
    return emptyObjectItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEmptyObjectItem_Name()
  {
    return (EAttribute)emptyObjectItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiInheritanceBug280439()
  {
    return multiInheritanceBug280439EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiInheritanceBug280439_Val()
  {
    return (EReference)multiInheritanceBug280439EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMulti1()
  {
    return abstractMulti1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractMulti1_M1()
  {
    return (EAttribute)abstractMulti1EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMulti2()
  {
    return abstractMulti2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractMulti2_M2()
  {
    return (EAttribute)abstractMulti2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcreteMulti()
  {
    return concreteMultiEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEObjectRef()
  {
    return eObjectRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEObjectRef_Obj()
  {
    return (EReference)eObjectRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEObjectRef_Ref()
  {
    return (EReference)eObjectRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEObjectElement()
  {
    return eObjectElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEObjectElement_Name()
  {
    return (EAttribute)eObjectElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug305577_1()
  {
    return typeBug305577_1EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug305577_2()
  {
    return typeBug305577_2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug1A()
  {
    return typeBug1AEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeBug1A_Name()
  {
    return (EAttribute)typeBug1AEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug1B()
  {
    return typeBug1BEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug2A()
  {
    return typeBug2AEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeBug2A_Name()
  {
    return (EAttribute)typeBug2AEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeBug2B()
  {
    return typeBug2BEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBug305171()
  {
    return bug305171EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug305171_X()
  {
    return (EAttribute)bug305171EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug305171_Y()
  {
    return (EAttribute)bug305171EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug305171_Z()
  {
    return (EAttribute)bug305171EClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug305171_Name()
  {
    return (EAttribute)bug305171EClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBug310435Enum()
  {
    return bug310435EnumEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug310435Enum_Lits()
  {
    return (EAttribute)bug310435EnumEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBug310435Val()
  {
    return bug310435ValEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBug310435Val_Lits()
  {
    return (EAttribute)bug310435ValEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCrossRefNameTest()
  {
    return crossRefNameTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrossRefNameTest_Named()
  {
    return (EReference)crossRefNameTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrossRefNameTest_Ref()
  {
    return (EReference)crossRefNameTestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCrossRefNamed()
  {
    return crossRefNamedEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCrossRefNamed_Name()
  {
    return (EAttribute)crossRefNamedEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOp()
  {
    return opEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOp_Values()
  {
    return (EReference)opEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnumBug310435Enum()
  {
    return enumBug310435EnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestFactory getSimplerewritetestFactory()
  {
    return (SimplerewritetestFactory)getEFactoryInstance();
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
    expressionEClass = createEClass(EXPRESSION);
    createEAttribute(expressionEClass, EXPRESSION__EM);

    atomEClass = createEClass(ATOM);
    createEAttribute(atomEClass, ATOM__NAME);

    twoNumbersEClass = createEClass(TWO_NUMBERS);
    createEAttribute(twoNumbersEClass, TWO_NUMBERS__NUM1);
    createEAttribute(twoNumbersEClass, TWO_NUMBERS__NUM2);
    createEAttribute(twoNumbersEClass, TWO_NUMBERS__NUM3);

    manyStringsEClass = createEClass(MANY_STRINGS);
    createEAttribute(manyStringsEClass, MANY_STRINGS__STR1);
    createEAttribute(manyStringsEClass, MANY_STRINGS__STR2);

    typeEClass = createEClass(TYPE);
    createEAttribute(typeEClass, TYPE__NAME);
    createEReference(typeEClass, TYPE__EXTENDS);

    ref2EClass = createEClass(REF2);
    createEAttribute(ref2EClass, REF2__REF2);

    spareEClass = createEClass(SPARE);
    createEAttribute(spareEClass, SPARE__ID);

    booleanEClass = createEClass(BOOLEAN);
    createEAttribute(booleanEClass, BOOLEAN__BOOL);
    createEAttribute(booleanEClass, BOOLEAN__VALUE);

    transient1EClass = createEClass(TRANSIENT1);
    createEAttribute(transient1EClass, TRANSIENT1__PREC_STAR);
    createEAttribute(transient1EClass, TRANSIENT1__PREC);
    createEAttribute(transient1EClass, TRANSIENT1__SCALE_STAR);
    createEAttribute(transient1EClass, TRANSIENT1__SCALE);

    consumed1EClass = createEClass(CONSUMED1);
    createEAttribute(consumed1EClass, CONSUMED1__V1);
    createEAttribute(consumed1EClass, CONSUMED1__V2);

    consumed2EClass = createEClass(CONSUMED2);
    createEReference(consumed2EClass, CONSUMED2__CHILD);

    loop1EClass = createEClass(LOOP1);
    createEAttribute(loop1EClass, LOOP1__ID);

    loop2EClass = createEClass(LOOP2);
    createEAttribute(loop2EClass, LOOP2__ID);

    loop3EClass = createEClass(LOOP3);
    createEAttribute(loop3EClass, LOOP3__ID);

    loop4EClass = createEClass(LOOP4);
    createEAttribute(loop4EClass, LOOP4__ID);

    loopBug285452EClass = createEClass(LOOP_BUG285452);
    createEAttribute(loopBug285452EClass, LOOP_BUG285452__INTERFACE);
    createEAttribute(loopBug285452EClass, LOOP_BUG285452__NAME);

    duplicateBug284491EClass = createEClass(DUPLICATE_BUG284491);
    createEAttribute(duplicateBug284491EClass, DUPLICATE_BUG284491__STATIC);
    createEAttribute(duplicateBug284491EClass, DUPLICATE_BUG284491__FINAL);
    createEAttribute(duplicateBug284491EClass, DUPLICATE_BUG284491__TRANSIENT);

    emptyObjectBug284850EClass = createEClass(EMPTY_OBJECT_BUG284850);
    createEReference(emptyObjectBug284850EClass, EMPTY_OBJECT_BUG284850__ITEMS);

    emptyObjectItemsEClass = createEClass(EMPTY_OBJECT_ITEMS);
    createEReference(emptyObjectItemsEClass, EMPTY_OBJECT_ITEMS__LIST);

    emptyObjectItemEClass = createEClass(EMPTY_OBJECT_ITEM);
    createEAttribute(emptyObjectItemEClass, EMPTY_OBJECT_ITEM__NAME);

    multiInheritanceBug280439EClass = createEClass(MULTI_INHERITANCE_BUG280439);
    createEReference(multiInheritanceBug280439EClass, MULTI_INHERITANCE_BUG280439__VAL);

    abstractMulti1EClass = createEClass(ABSTRACT_MULTI1);
    createEAttribute(abstractMulti1EClass, ABSTRACT_MULTI1__M1);

    abstractMulti2EClass = createEClass(ABSTRACT_MULTI2);
    createEAttribute(abstractMulti2EClass, ABSTRACT_MULTI2__M2);

    concreteMultiEClass = createEClass(CONCRETE_MULTI);

    eObjectRefEClass = createEClass(EOBJECT_REF);
    createEReference(eObjectRefEClass, EOBJECT_REF__OBJ);
    createEReference(eObjectRefEClass, EOBJECT_REF__REF);

    eObjectElementEClass = createEClass(EOBJECT_ELEMENT);
    createEAttribute(eObjectElementEClass, EOBJECT_ELEMENT__NAME);

    typeBug305577_1EClass = createEClass(TYPE_BUG305577_1);

    typeBug305577_2EClass = createEClass(TYPE_BUG305577_2);

    typeBug1AEClass = createEClass(TYPE_BUG1_A);
    createEAttribute(typeBug1AEClass, TYPE_BUG1_A__NAME);

    typeBug1BEClass = createEClass(TYPE_BUG1_B);

    typeBug2AEClass = createEClass(TYPE_BUG2_A);
    createEAttribute(typeBug2AEClass, TYPE_BUG2_A__NAME);

    typeBug2BEClass = createEClass(TYPE_BUG2_B);

    bug305171EClass = createEClass(BUG305171);
    createEAttribute(bug305171EClass, BUG305171__X);
    createEAttribute(bug305171EClass, BUG305171__Y);
    createEAttribute(bug305171EClass, BUG305171__Z);
    createEAttribute(bug305171EClass, BUG305171__NAME);

    bug310435EnumEClass = createEClass(BUG310435_ENUM);
    createEAttribute(bug310435EnumEClass, BUG310435_ENUM__LITS);

    bug310435ValEClass = createEClass(BUG310435_VAL);
    createEAttribute(bug310435ValEClass, BUG310435_VAL__LITS);

    crossRefNameTestEClass = createEClass(CROSS_REF_NAME_TEST);
    createEReference(crossRefNameTestEClass, CROSS_REF_NAME_TEST__NAMED);
    createEReference(crossRefNameTestEClass, CROSS_REF_NAME_TEST__REF);

    crossRefNamedEClass = createEClass(CROSS_REF_NAMED);
    createEAttribute(crossRefNamedEClass, CROSS_REF_NAMED__NAME);

    opEClass = createEClass(OP);
    createEReference(opEClass, OP__VALUES);

    // Create enums
    enumBug310435EnumEEnum = createEEnum(ENUM_BUG310435_ENUM);
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
    atomEClass.getESuperTypes().add(this.getExpression());
    twoNumbersEClass.getESuperTypes().add(this.getExpression());
    manyStringsEClass.getESuperTypes().add(this.getExpression());
    typeEClass.getESuperTypes().add(this.getExpression());
    ref2EClass.getESuperTypes().add(this.getExpression());
    spareEClass.getESuperTypes().add(this.getExpression());
    booleanEClass.getESuperTypes().add(this.getExpression());
    transient1EClass.getESuperTypes().add(this.getExpression());
    consumed1EClass.getESuperTypes().add(this.getExpression());
    consumed2EClass.getESuperTypes().add(this.getExpression());
    loop1EClass.getESuperTypes().add(this.getExpression());
    loop2EClass.getESuperTypes().add(this.getExpression());
    loop3EClass.getESuperTypes().add(this.getExpression());
    loop4EClass.getESuperTypes().add(this.getExpression());
    loopBug285452EClass.getESuperTypes().add(this.getExpression());
    duplicateBug284491EClass.getESuperTypes().add(this.getExpression());
    emptyObjectBug284850EClass.getESuperTypes().add(this.getExpression());
    multiInheritanceBug280439EClass.getESuperTypes().add(this.getExpression());
    concreteMultiEClass.getESuperTypes().add(this.getAbstractMulti1());
    concreteMultiEClass.getESuperTypes().add(this.getAbstractMulti2());
    eObjectRefEClass.getESuperTypes().add(this.getExpression());
    typeBug305577_1EClass.getESuperTypes().add(this.getExpression());
    typeBug305577_2EClass.getESuperTypes().add(this.getExpression());
    typeBug1AEClass.getESuperTypes().add(this.getTypeBug305577_1());
    typeBug1BEClass.getESuperTypes().add(this.getTypeBug305577_1());
    typeBug1BEClass.getESuperTypes().add(this.getTypeBug1A());
    typeBug2AEClass.getESuperTypes().add(this.getTypeBug305577_2());
    typeBug2BEClass.getESuperTypes().add(this.getTypeBug305577_2());
    typeBug2BEClass.getESuperTypes().add(this.getTypeBug2A());
    bug305171EClass.getESuperTypes().add(this.getExpression());
    bug310435EnumEClass.getESuperTypes().add(this.getExpression());
    bug310435ValEClass.getESuperTypes().add(this.getExpression());
    crossRefNameTestEClass.getESuperTypes().add(this.getExpression());
    opEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpression_Em(), theEcorePackage.getEString(), "em", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomEClass, Atom.class, "Atom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAtom_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Atom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(twoNumbersEClass, TwoNumbers.class, "TwoNumbers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTwoNumbers_Num1(), theEcorePackage.getEInt(), "num1", null, 0, 1, TwoNumbers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoNumbers_Num2(), theEcorePackage.getEInt(), "num2", null, 0, 1, TwoNumbers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTwoNumbers_Num3(), theEcorePackage.getEInt(), "num3", null, 0, -1, TwoNumbers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(manyStringsEClass, ManyStrings.class, "ManyStrings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getManyStrings_Str1(), theEcorePackage.getEString(), "str1", null, 0, -1, ManyStrings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getManyStrings_Str2(), theEcorePackage.getEString(), "str2", null, 0, -1, ManyStrings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getType_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getType_Extends(), this.getType(), null, "extends", null, 0, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ref2EClass, Ref2.class, "Ref2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRef2_Ref2(), theEcorePackage.getEString(), "ref2", null, 0, 1, Ref2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(spareEClass, Spare.class, "Spare", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpare_Id(), theEcorePackage.getEString(), "id", null, 0, -1, Spare.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanEClass, org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean.class, "Boolean", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBoolean_Bool(), theEcorePackage.getEBoolean(), "bool", null, 0, 1, org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBoolean_Value(), theEcorePackage.getEString(), "value", null, 0, 1, org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transient1EClass, Transient1.class, "Transient1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransient1_PrecStar(), theEcorePackage.getEBoolean(), "precStar", null, 0, 1, Transient1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransient1_Prec(), theEcorePackage.getEInt(), "prec", null, 0, 1, Transient1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransient1_ScaleStar(), theEcorePackage.getEBoolean(), "scaleStar", null, 0, 1, Transient1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransient1_Scale(), theEcorePackage.getEInt(), "scale", null, 0, 1, Transient1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(consumed1EClass, Consumed1.class, "Consumed1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConsumed1_V1(), theEcorePackage.getEInt(), "v1", null, 0, -1, Consumed1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConsumed1_V2(), theEcorePackage.getEString(), "v2", null, 0, -1, Consumed1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(consumed2EClass, Consumed2.class, "Consumed2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConsumed2_Child(), this.getConsumed1(), null, "child", null, 0, 1, Consumed2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loop1EClass, Loop1.class, "Loop1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop1_Id(), theEcorePackage.getEString(), "id", null, 0, -1, Loop1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loop2EClass, Loop2.class, "Loop2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop2_Id(), theEcorePackage.getEString(), "id", null, 0, -1, Loop2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loop3EClass, Loop3.class, "Loop3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop3_Id(), theEcorePackage.getEString(), "id", null, 0, -1, Loop3.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loop4EClass, Loop4.class, "Loop4", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoop4_Id(), theEcorePackage.getEString(), "id", null, 0, -1, Loop4.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopBug285452EClass, LoopBug285452.class, "LoopBug285452", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLoopBug285452_Interface(), theEcorePackage.getEBoolean(), "interface", null, 0, 1, LoopBug285452.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoopBug285452_Name(), theEcorePackage.getEString(), "name", null, 0, 1, LoopBug285452.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(duplicateBug284491EClass, DuplicateBug284491.class, "DuplicateBug284491", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDuplicateBug284491_Static(), theEcorePackage.getEBoolean(), "static", null, 0, 1, DuplicateBug284491.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDuplicateBug284491_Final(), theEcorePackage.getEBoolean(), "final", null, 0, 1, DuplicateBug284491.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDuplicateBug284491_Transient(), theEcorePackage.getEBoolean(), "transient", null, 0, 1, DuplicateBug284491.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emptyObjectBug284850EClass, EmptyObjectBug284850.class, "EmptyObjectBug284850", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEmptyObjectBug284850_Items(), this.getEmptyObjectItems(), null, "items", null, 0, 1, EmptyObjectBug284850.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emptyObjectItemsEClass, EmptyObjectItems.class, "EmptyObjectItems", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEmptyObjectItems_List(), this.getEmptyObjectItem(), null, "list", null, 0, -1, EmptyObjectItems.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(emptyObjectItemEClass, EmptyObjectItem.class, "EmptyObjectItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEmptyObjectItem_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EmptyObjectItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiInheritanceBug280439EClass, MultiInheritanceBug280439.class, "MultiInheritanceBug280439", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiInheritanceBug280439_Val(), this.getConcreteMulti(), null, "val", null, 0, 1, MultiInheritanceBug280439.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractMulti1EClass, AbstractMulti1.class, "AbstractMulti1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractMulti1_M1(), theEcorePackage.getEString(), "m1", null, 0, 1, AbstractMulti1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractMulti2EClass, AbstractMulti2.class, "AbstractMulti2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractMulti2_M2(), theEcorePackage.getEString(), "m2", null, 0, 1, AbstractMulti2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(concreteMultiEClass, ConcreteMulti.class, "ConcreteMulti", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eObjectRefEClass, EObjectRef.class, "EObjectRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEObjectRef_Obj(), this.getEObjectElement(), null, "obj", null, 0, 1, EObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEObjectRef_Ref(), theEcorePackage.getEObject(), null, "ref", null, 0, 1, EObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eObjectElementEClass, EObjectElement.class, "EObjectElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEObjectElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EObjectElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeBug305577_1EClass, TypeBug305577_1.class, "TypeBug305577_1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeBug305577_2EClass, TypeBug305577_2.class, "TypeBug305577_2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeBug1AEClass, TypeBug1A.class, "TypeBug1A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeBug1A_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TypeBug1A.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeBug1BEClass, TypeBug1B.class, "TypeBug1B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeBug2AEClass, TypeBug2A.class, "TypeBug2A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeBug2A_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TypeBug2A.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeBug2BEClass, TypeBug2B.class, "TypeBug2B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(bug305171EClass, Bug305171.class, "Bug305171", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBug305171_X(), theEcorePackage.getEString(), "x", null, 0, -1, Bug305171.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBug305171_Y(), theEcorePackage.getEString(), "y", null, 0, -1, Bug305171.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBug305171_Z(), theEcorePackage.getEString(), "z", null, 0, -1, Bug305171.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBug305171_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Bug305171.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bug310435EnumEClass, Bug310435Enum.class, "Bug310435Enum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBug310435Enum_Lits(), this.getEnumBug310435Enum(), "lits", null, 0, -1, Bug310435Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bug310435ValEClass, Bug310435Val.class, "Bug310435Val", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBug310435Val_Lits(), theEcorePackage.getEString(), "lits", null, 0, -1, Bug310435Val.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(crossRefNameTestEClass, CrossRefNameTest.class, "CrossRefNameTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCrossRefNameTest_Named(), this.getCrossRefNamed(), null, "named", null, 0, -1, CrossRefNameTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCrossRefNameTest_Ref(), this.getCrossRefNamed(), null, "ref", null, 0, -1, CrossRefNameTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(crossRefNamedEClass, CrossRefNamed.class, "CrossRefNamed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCrossRefNamed_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CrossRefNamed.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(opEClass, Op.class, "Op", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOp_Values(), this.getExpression(), null, "values", null, 0, -1, Op.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(enumBug310435EnumEEnum, EnumBug310435Enum.class, "EnumBug310435Enum");
    addEEnumLiteral(enumBug310435EnumEEnum, EnumBug310435Enum.LIT1);
    addEEnumLiteral(enumBug310435EnumEEnum, EnumBug310435Enum.LIT2);

    // Create resource
    createResource(eNS_URI);
  }

} //SimplerewritetestPackageImpl
