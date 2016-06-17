/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplerewritetestFactoryImpl extends EFactoryImpl implements SimplerewritetestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SimplerewritetestFactory init()
  {
    try
    {
      SimplerewritetestFactory theSimplerewritetestFactory = (SimplerewritetestFactory)EPackage.Registry.INSTANCE.getEFactory(SimplerewritetestPackage.eNS_URI);
      if (theSimplerewritetestFactory != null)
      {
        return theSimplerewritetestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SimplerewritetestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestFactoryImpl()
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
      case SimplerewritetestPackage.EXPRESSION: return createExpression();
      case SimplerewritetestPackage.ATOM: return createAtom();
      case SimplerewritetestPackage.TWO_NUMBERS: return createTwoNumbers();
      case SimplerewritetestPackage.MANY_STRINGS: return createManyStrings();
      case SimplerewritetestPackage.TYPE: return createType();
      case SimplerewritetestPackage.REF2: return createRef2();
      case SimplerewritetestPackage.SPARE: return createSpare();
      case SimplerewritetestPackage.BOOLEAN: return createBoolean();
      case SimplerewritetestPackage.TRANSIENT1: return createTransient1();
      case SimplerewritetestPackage.CONSUMED1: return createConsumed1();
      case SimplerewritetestPackage.CONSUMED2: return createConsumed2();
      case SimplerewritetestPackage.LOOP1: return createLoop1();
      case SimplerewritetestPackage.LOOP2: return createLoop2();
      case SimplerewritetestPackage.LOOP3: return createLoop3();
      case SimplerewritetestPackage.LOOP4: return createLoop4();
      case SimplerewritetestPackage.LOOP_BUG285452: return createLoopBug285452();
      case SimplerewritetestPackage.DUPLICATE_BUG284491: return createDuplicateBug284491();
      case SimplerewritetestPackage.EMPTY_OBJECT_BUG284850: return createEmptyObjectBug284850();
      case SimplerewritetestPackage.EMPTY_OBJECT_ITEMS: return createEmptyObjectItems();
      case SimplerewritetestPackage.EMPTY_OBJECT_ITEM: return createEmptyObjectItem();
      case SimplerewritetestPackage.MULTI_INHERITANCE_BUG280439: return createMultiInheritanceBug280439();
      case SimplerewritetestPackage.ABSTRACT_MULTI1: return createAbstractMulti1();
      case SimplerewritetestPackage.ABSTRACT_MULTI2: return createAbstractMulti2();
      case SimplerewritetestPackage.CONCRETE_MULTI: return createConcreteMulti();
      case SimplerewritetestPackage.EOBJECT_REF: return createEObjectRef();
      case SimplerewritetestPackage.EOBJECT_ELEMENT: return createEObjectElement();
      case SimplerewritetestPackage.TYPE_BUG305577_1: return createTypeBug305577_1();
      case SimplerewritetestPackage.TYPE_BUG305577_2: return createTypeBug305577_2();
      case SimplerewritetestPackage.TYPE_BUG1_A: return createTypeBug1A();
      case SimplerewritetestPackage.TYPE_BUG1_B: return createTypeBug1B();
      case SimplerewritetestPackage.TYPE_BUG2_A: return createTypeBug2A();
      case SimplerewritetestPackage.TYPE_BUG2_B: return createTypeBug2B();
      case SimplerewritetestPackage.BUG305171: return createBug305171();
      case SimplerewritetestPackage.BUG310435_ENUM: return createBug310435Enum();
      case SimplerewritetestPackage.BUG310435_VAL: return createBug310435Val();
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST: return createCrossRefNameTest();
      case SimplerewritetestPackage.CROSS_REF_NAMED: return createCrossRefNamed();
      case SimplerewritetestPackage.OP: return createOp();
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
      case SimplerewritetestPackage.ENUM_BUG310435_ENUM:
        return createEnumBug310435EnumFromString(eDataType, initialValue);
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
      case SimplerewritetestPackage.ENUM_BUG310435_ENUM:
        return convertEnumBug310435EnumToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TwoNumbers createTwoNumbers()
  {
    TwoNumbersImpl twoNumbers = new TwoNumbersImpl();
    return twoNumbers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyStrings createManyStrings()
  {
    ManyStringsImpl manyStrings = new ManyStringsImpl();
    return manyStrings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ref2 createRef2()
  {
    Ref2Impl ref2 = new Ref2Impl();
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Spare createSpare()
  {
    SpareImpl spare = new SpareImpl();
    return spare;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean createBoolean()
  {
    BooleanImpl boolean_ = new BooleanImpl();
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transient1 createTransient1()
  {
    Transient1Impl transient1 = new Transient1Impl();
    return transient1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Consumed1 createConsumed1()
  {
    Consumed1Impl consumed1 = new Consumed1Impl();
    return consumed1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Consumed2 createConsumed2()
  {
    Consumed2Impl consumed2 = new Consumed2Impl();
    return consumed2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop1 createLoop1()
  {
    Loop1Impl loop1 = new Loop1Impl();
    return loop1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop2 createLoop2()
  {
    Loop2Impl loop2 = new Loop2Impl();
    return loop2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop3 createLoop3()
  {
    Loop3Impl loop3 = new Loop3Impl();
    return loop3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Loop4 createLoop4()
  {
    Loop4Impl loop4 = new Loop4Impl();
    return loop4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopBug285452 createLoopBug285452()
  {
    LoopBug285452Impl loopBug285452 = new LoopBug285452Impl();
    return loopBug285452;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DuplicateBug284491 createDuplicateBug284491()
  {
    DuplicateBug284491Impl duplicateBug284491 = new DuplicateBug284491Impl();
    return duplicateBug284491;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyObjectBug284850 createEmptyObjectBug284850()
  {
    EmptyObjectBug284850Impl emptyObjectBug284850 = new EmptyObjectBug284850Impl();
    return emptyObjectBug284850;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyObjectItems createEmptyObjectItems()
  {
    EmptyObjectItemsImpl emptyObjectItems = new EmptyObjectItemsImpl();
    return emptyObjectItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmptyObjectItem createEmptyObjectItem()
  {
    EmptyObjectItemImpl emptyObjectItem = new EmptyObjectItemImpl();
    return emptyObjectItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiInheritanceBug280439 createMultiInheritanceBug280439()
  {
    MultiInheritanceBug280439Impl multiInheritanceBug280439 = new MultiInheritanceBug280439Impl();
    return multiInheritanceBug280439;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMulti1 createAbstractMulti1()
  {
    AbstractMulti1Impl abstractMulti1 = new AbstractMulti1Impl();
    return abstractMulti1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMulti2 createAbstractMulti2()
  {
    AbstractMulti2Impl abstractMulti2 = new AbstractMulti2Impl();
    return abstractMulti2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteMulti createConcreteMulti()
  {
    ConcreteMultiImpl concreteMulti = new ConcreteMultiImpl();
    return concreteMulti;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObjectRef createEObjectRef()
  {
    EObjectRefImpl eObjectRef = new EObjectRefImpl();
    return eObjectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObjectElement createEObjectElement()
  {
    EObjectElementImpl eObjectElement = new EObjectElementImpl();
    return eObjectElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug305577_1 createTypeBug305577_1()
  {
    TypeBug305577_1Impl typeBug305577_1 = new TypeBug305577_1Impl();
    return typeBug305577_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug305577_2 createTypeBug305577_2()
  {
    TypeBug305577_2Impl typeBug305577_2 = new TypeBug305577_2Impl();
    return typeBug305577_2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug1A createTypeBug1A()
  {
    TypeBug1AImpl typeBug1A = new TypeBug1AImpl();
    return typeBug1A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug1B createTypeBug1B()
  {
    TypeBug1BImpl typeBug1B = new TypeBug1BImpl();
    return typeBug1B;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug2A createTypeBug2A()
  {
    TypeBug2AImpl typeBug2A = new TypeBug2AImpl();
    return typeBug2A;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeBug2B createTypeBug2B()
  {
    TypeBug2BImpl typeBug2B = new TypeBug2BImpl();
    return typeBug2B;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug305171 createBug305171()
  {
    Bug305171Impl bug305171 = new Bug305171Impl();
    return bug305171;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug310435Enum createBug310435Enum()
  {
    Bug310435EnumImpl bug310435Enum = new Bug310435EnumImpl();
    return bug310435Enum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug310435Val createBug310435Val()
  {
    Bug310435ValImpl bug310435Val = new Bug310435ValImpl();
    return bug310435Val;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRefNameTest createCrossRefNameTest()
  {
    CrossRefNameTestImpl crossRefNameTest = new CrossRefNameTestImpl();
    return crossRefNameTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossRefNamed createCrossRefNamed()
  {
    CrossRefNamedImpl crossRefNamed = new CrossRefNamedImpl();
    return crossRefNamed;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Op createOp()
  {
    OpImpl op = new OpImpl();
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBug310435Enum createEnumBug310435EnumFromString(EDataType eDataType, String initialValue)
  {
    EnumBug310435Enum result = EnumBug310435Enum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEnumBug310435EnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestPackage getSimplerewritetestPackage()
  {
    return (SimplerewritetestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SimplerewritetestPackage getPackage()
  {
    return SimplerewritetestPackage.eINSTANCE;
  }

} //SimplerewritetestFactoryImpl
