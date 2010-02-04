/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems;
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
      SimplerewritetestFactory theSimplerewritetestFactory = (SimplerewritetestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/simplerewritetest"); 
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
